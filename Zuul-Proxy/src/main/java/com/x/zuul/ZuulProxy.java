package com.x.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 微服务网关启动类
 *
 * @author AD
 * @date 2021/10/20 12:34
 */
@EnableZuulProxy
// @EnableDiscoveryClient
@SpringBootApplication
public class ZuulProxy {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ZuulProxy.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
