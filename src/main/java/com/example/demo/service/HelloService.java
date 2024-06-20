package com.example.demo.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private final ObjectProvider<RestTemplate> restTemplateProvider;

    public HelloService(ObjectProvider<RestTemplate> restTemplateProvider) {
        this.restTemplateProvider = restTemplateProvider;
    }

    public String getHello() {
        RestTemplate restTemplate = restTemplateProvider.getIfAvailable();
        return restTemplate.getForObject("http://demo-service/hello", String.class);
    }
}
