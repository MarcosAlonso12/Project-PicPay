package com.tads.picpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PicpayApplication {
    public String PORT = System.getenv("PORT");
    public static void main(String[] args) {
        SpringApplication.run(PicpayApplication.class, args);
    }
}


