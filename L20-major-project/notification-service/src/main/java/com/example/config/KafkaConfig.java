package com.example.config;

import com.example.kafka.UserCreatedPayload;
import com.example.kafka.WalletUpdatePayload;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap.servers}")
    String bootstrapServers;

    @Bean
    public ConsumerFactory<String, WalletUpdatePayload> walletConsumerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(WalletUpdatePayload.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, WalletUpdatePayload> walletKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, WalletUpdatePayload> factory = new ConcurrentKafkaListenerContainerFactory<String, WalletUpdatePayload>();
        factory.setConsumerFactory(walletConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, UserCreatedPayload> userConsumerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(UserCreatedPayload.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserCreatedPayload> userKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserCreatedPayload> factory = new ConcurrentKafkaListenerContainerFactory<String, UserCreatedPayload>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }
}
