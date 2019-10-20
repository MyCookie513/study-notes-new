package com.jason.leyoueurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LeyoueurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyoueurekaserverApplication.class, args);
    }

}