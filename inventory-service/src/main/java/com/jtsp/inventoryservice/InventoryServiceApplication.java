package com.jtsp.inventoryservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@Slf4j
public class InventoryServiceApplication {

    @Autowired
    private  RestTemplate template;
    public static final String SHIPMENT_API = "http://localhost:8081/shipment";

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @GetMapping("/outbound")
    public String outbound() {
        log.info("inventory service deduct count");
        template.getForObject(SHIPMENT_API, String.class);
        return "deduct stock count";
    }
}
