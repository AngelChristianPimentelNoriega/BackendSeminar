package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
public class ProductApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProductApplication.class, args);    
    }
}
