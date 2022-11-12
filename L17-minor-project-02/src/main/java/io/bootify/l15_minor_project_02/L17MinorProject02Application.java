package io.bootify.l15_minor_project_02;

import io.bootify.l15_minor_project_02.model.VisitorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;


@SpringBootApplication
public class L17MinorProject02Application {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public
    RedisTemplate<String, List<VisitorDTO>>  getRedisTemplate(){
        RedisTemplate<String, List<VisitorDTO>> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    public static void main(final String[] args) {
        SpringApplication.run(L17MinorProject02Application.class, args);
    }

}
