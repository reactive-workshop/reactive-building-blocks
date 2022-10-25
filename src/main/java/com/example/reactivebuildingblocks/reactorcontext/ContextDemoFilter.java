package com.example.reactivebuildingblocks.reactorcontext;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ContextDemoFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        List<String> possibleIds = exchange.getRequest().getQueryParams().get("id");
        if (CollectionUtils.isEmpty(possibleIds)) {
            return chain.filter(exchange);
        }
        String id = possibleIds.get(0);
        return chain.filter(exchange)
                .contextWrite(ctx -> {
                    ctx = ctx.put("IP Address", id + ".123.23.43");
                    ctx = ctx.put("Location", id + "-Street");
                    return ctx;
                });
    }
}