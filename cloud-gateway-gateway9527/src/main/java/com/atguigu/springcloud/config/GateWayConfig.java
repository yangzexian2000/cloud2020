package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @authoer:zexian
 * @createDate:2022/6/20
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder RouteLocatorBuilder){
        org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder routes = RouteLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                        .build();
        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder RouteLocatorBuilder){
        org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder routes = RouteLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"))
                .build();
        return routes.build();
    }
}
