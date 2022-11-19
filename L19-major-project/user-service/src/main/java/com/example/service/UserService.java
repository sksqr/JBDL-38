package com.example.service;

import com.example.UserNotExistException;
import com.example.dto.UserDto;
import com.example.dto.UserProfile;
import com.example.entity.User;
import com.example.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private static final String PREFIX ="user:";
    private static final String TOPIC = "USER_CREATED";
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;


    public Long createUser(UserDto userDto) throws ExecutionException, InterruptedException, JsonProcessingException {
        User user = User.builder().name(userDto.getName())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .kycId(userDto.getKycId())
                .address(userDto.getAddress())
                .build();
        userRepo.save(user);
        Map<String,Object> map = new HashMap<>();
        map.put("email",user.getEmail());
        map.put("name",user.getName());
        map.put("id",user.getId());
        String payload = objectMapper.writeValueAsString(map);
        ListenableFuture listenableFuture = kafkaTemplate.send(TOPIC,payload);
        LOGGER.info("Pushed to kafka, kafka response : {}", listenableFuture.get());
        return user.getId();
    }

    public UserProfile getUserProfile(Long id) throws UserNotExistException {
        String key = PREFIX+id;
        User user = redisTemplate.opsForValue().get(key);
        if(user == null){
            user = userRepo.findById(id).get();
            if(user != null){
                redisTemplate.opsForValue().set(key,user);
            }
            else {
                throw new UserNotExistException("User does not exist");
            }
        }

        // call wallet;

        String url = "http://localhost:8081/wallet-service/balance";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("userId","2");
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
//        ResponseEntity<JsonNode> apiResponse = restTemplate.exchange(url, HttpMethod.GET, httpEntity, JsonNode.class);

        Double balance = null;
        try {
            ResponseEntity<Double> apiResponse = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Double.class);
            balance = apiResponse.getBody();
        }
        catch (Exception ex){
            LOGGER.error("Exception while calling wallet service");
        }

        UserProfile userProfile = UserProfile.builder()
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .phone(user.getPhone())
                .balance(balance)
                .build();

        return userProfile;
    }
}
