package com.x.product.conf;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * restTemplate
 *
 * @author AD
 * @date 2021/10/12 01:00
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    // @LoadBalanced
    public RestTemplate restTemplate(){
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        //tcp socket通信的一些配置
        connectionManager.setDefaultSocketConfig(SocketConfig.custom().setTcpNoDelay(true).build());
        //路由最大连接数 默认值2
        connectionManager.setDefaultMaxPerRoute(100);
        //连接总数 默认值20
        connectionManager.setMaxTotal(300);

        RequestConfig config = RequestConfig.custom()
                //建立连接超时
                .setConnectTimeout(90 * 1000)
                //连接池获取连接超时时间
                .setConnectionRequestTimeout(500)
                //数据传输超时时间
                .setSocketTimeout(90 * 1000).build();
        CloseableHttpClient client = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .setConnectionManager(connectionManager).build();
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(client));
        //设置消息体的转化器
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(new MediaType("text", "json")));
        converter.setSupportedMediaTypes(Collections.singletonList(new MediaType("application", "json")));

        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }
}
