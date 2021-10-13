package com.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * TODO
 *
 * @author AD
 * @date 2021/10/10 23:08
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ProductApp {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ProductApp.class,args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
