package com.example.L13redisdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
//
//    public RedisConnectionFactory

//    @Bean
//    public RedisTemplate<String,Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        return  redisTemplate;
//    }


    @Bean
    public RedisTemplate<String,Person> getRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Person> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        return  redisTemplate;
    }


//    @Bean("productRedisTemplate")
//    public RedisTemplate<String,Product> getProductRedisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<String,Product> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        return  redisTemplate;
//    }
}
