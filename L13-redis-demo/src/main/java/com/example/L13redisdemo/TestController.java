package com.example.L13redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

//    @Autowired
//    private RedisTemplate<String,String> redisTemplate;




    @Autowired
    private RedisTemplate<String,Person> personRedisTemplate;


    @GetMapping
    ResponseEntity<String> getHello(){
//        redisTemplate.opsForValue().set("thread-name",Thread.currentThread().getName());
        return ResponseEntity.ok("Hello");
    }

    @PostMapping("/person")
    ResponseEntity<Person> createPerson(@RequestBody Person person){
        Long id = personRedisTemplate.opsForValue().increment("person.id");
        //personRedisTemplate.expire("key",10, TimeUnit.HOURS);
        person.setId(id);

        personRedisTemplate.opsForValue().set(getPersonKey(id),person);
        return ResponseEntity.ok(person);
    }

    @PostMapping("/addInQueue/{id}")
    ResponseEntity<Person> addInQueue(@PathVariable Long id){
        Person person = personRedisTemplate.opsForValue().get(getPersonKey(id));
        personRedisTemplate.opsForList().leftPush("PersonList",person);
        return ResponseEntity.ok(person);
    }


    @GetMapping("/processList")
    ResponseEntity<Person> processList(){
        Person person = personRedisTemplate.opsForList().rightPop("PersonList");
        return ResponseEntity.ok(person);
    }


    @GetMapping("/person/{id}")
    ResponseEntity<Person> getPerson(@PathVariable Long id){
        Person person = personRedisTemplate.opsForValue().get(getPersonKey(id));
        if(person == null){
            //read from db

            //write in redis
        }
        return ResponseEntity.ok(person);
    }




    private String getPersonKey(Long id){
        String key = "person:"+id;
        return key;
    }




//    @PostMapping("/product")
//    ResponseEntity<Product> createProduct(@RequestBody Product product){
//        Long id = personRedisTemplate.opsForValue().increment("product.id");
//        product.setId(id);
//        String key = "product:"+id;
//        personRedisTemplate.opsForValue().set(key,product);
//        return ResponseEntity.ok(product);
//    }





}
