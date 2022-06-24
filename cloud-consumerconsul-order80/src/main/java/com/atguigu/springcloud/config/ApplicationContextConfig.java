package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @authoer:zexian
 * @createDate:2022/6/15
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //loadBalanced是处理请求负载均衡的注解
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
