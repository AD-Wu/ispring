package com.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author AD
 * @date 2021/10/9 20:43
 */
// 表示Eureka客户端，在Spring Boot启动后，会根据配置尝试与服务治理服务器连接，连接后进行服务注册或者服务注册信息同步
@EnableDiscoveryClient
@SpringBootApplication
public class UserApp {
    
    public static void main(String[] args) {
        try {
            SpringApplication.run(UserApp.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
