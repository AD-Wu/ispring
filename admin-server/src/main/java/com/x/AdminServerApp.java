package com.x;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

/**
 * TODO
 *
 * @author chunquanw
 * @date 2021/10/12 12:31
 */

@EnableAdminServer
@SpringBootApplication
public class AdminServerApp {

    public static void main(String[] args) {
        try {
            SpringApplication.run(AdminServerApp.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
