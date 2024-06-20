package com.example.demo;

import com.example.demo.client.HelloClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HelloClient helloClient;

    @Test
    void contextLoads() {
    }

    @Test
    void testHelloEndpoint() {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/hello", String.class);
        assertThat(response).contains("Hello from port");
    }
}
