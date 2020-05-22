//package com.microservice.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder){
//        // 定义路由
//        RouteLocatorBuilder.Builder routes = builder.routes();
//
//        // 路由信息配置
//        // 等同于yml配置中的 id、predicates、uri
//        routes.route("payment_route_code",r -> r.path("/payment/get/**")
//                .uri("http://localhost:8001"));
//
//        routes.route("payment_route_code",r -> r.path("/payment/timeout/**")
//                .uri("http://localhost:8001"));
//
//        return routes.build();
//    }
//}
