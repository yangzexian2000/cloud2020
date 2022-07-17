package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @authoer:zexian
 * @createDate:2022/6/27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PayMent9001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent9001.class,args);
    }
}
