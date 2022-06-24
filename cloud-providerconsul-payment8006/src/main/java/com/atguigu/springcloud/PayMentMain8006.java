package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @authoer:zexian
 * @createDate:2022/6/15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PayMentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8006.class,args);
    }
}
