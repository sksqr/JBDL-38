package com.example.L14resttemplatedemo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/blogPost")
    ResponseEntity<JsonNode> getPost(){
        String blogPostServiceUrl = "https://jsonplaceholder.typicode.com/posts/5";
        JsonNode jsonNode = restTemplate.getForObject(blogPostServiceUrl,JsonNode.class);
        return ResponseEntity.ok(jsonNode);

    }

    @GetMapping("/jobs/{keyword}")
    ResponseEntity<JobResponse> getJobs(@PathVariable String keyword){
        String url = "https://www.naukrigulf.com/spapi/jobapi/search?Limit=3&Keywords=";
        url = url+keyword;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("appId","1112");
        httpHeaders.set("systemId","123");
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

//        ResponseEntity<JsonNode> apiResponse = restTemplate.exchange(url, HttpMethod.GET, httpEntity, JsonNode.class);

        ResponseEntity<JobResponse> apiResponse = restTemplate.exchange(url, HttpMethod.GET, httpEntity, JobResponse.class);
        return ResponseEntity.ok(apiResponse.getBody());
    }
}
