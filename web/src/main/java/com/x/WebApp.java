package com.x;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author
 * @date 2021/10/12 11:46
 */
@EnableAdminServer
@SpringBootApplication
public class WebApp {

    public static void main(String[] args) {
        try {
            SpringApplication.run(WebApp.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
