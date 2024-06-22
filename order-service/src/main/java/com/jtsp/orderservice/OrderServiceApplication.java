package com.jtsp.orderservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
@RestController
public class OrderServiceApplication {

    @Autowired
    private RestTemplate restTemplate;
    public static final String INVENTORY_API = "http://localhost:8082/outbound";
    public static final String EMAIL_API = "http://localhost:8083/email";

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @GetMapping("/orders")
    public String order() {
        log.info("new order comes!");
        restTemplate.getForObject(INVENTORY_API, String.class);
        restTemplate.getForObject(EMAIL_API, String.class);
        return "new orders!";
    }
}
