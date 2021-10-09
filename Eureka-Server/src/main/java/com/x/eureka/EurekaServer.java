package com.x.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author AD
 * @date 2021/10/8 22:22
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {
    
    public static void main(String[] args) {
        try {
            SpringApplication.run(EurekaServer.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
