package com.example.eurekaserverpeer3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerPeer3Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerPeer3Application.class, args);
    }
}