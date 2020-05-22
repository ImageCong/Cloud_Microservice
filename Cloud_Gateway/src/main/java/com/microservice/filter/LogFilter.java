package com.microservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Slf4j
@Component
public class LogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("================LogFilter==============");
        log.info("================Date : " + new Date() + "==============");

        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null) {
            log.info("-----------非法用户------------");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return chain.filter(exchange);
        }

        return chain.filter(exchange);
    }

    /**
     * 数字越小优先级越高
     * 等效于Order(0)
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
