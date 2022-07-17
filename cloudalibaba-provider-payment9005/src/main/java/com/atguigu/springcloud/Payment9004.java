package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @authoer:zexian
 * @createDate:2022/6/29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9004 {
    public static void main(String[] args) {
        SpringApplication.run(Payment9004.class,args);
    }
}
