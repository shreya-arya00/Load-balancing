package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloClient {

    private final RestTemplate restTemplate;

    @Autowired
    public HelloClient(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String test() {
        return this.restTemplate.getForObject("http://demo-service/hello", String.class);
    }
}