package com.atguigu.springcloud.fitter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @authoer:zexian
 * @createDate:2022/6/22
 */
@Component
@Slf4j
public class MyLogFitter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********************come in MyLogFitter"+new Date());
        //带有username的才可以进来访问
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (null == uname){
            log.info("************ 用户名为废话用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//给人家一个回应
            return exchange.getResponse().setComplete();
        }
        //放行过滤链
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
