package com.example.myappapialbums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MyappApiAlbumsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyappApiAlbumsApplication.class, args);
    }

}
