package com.example.reactivebuildingblocks.reactorcontext;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

@Service
public class ContextDemoService {
    public Mono<String> printContextData(String id) {
        return Mono
                .deferContextual(this::printFromContext)
                .map(s -> "IPAddress for Id=> " + s);
    }

    private Mono<String> printFromContext(ContextView contextView) {
        String ipAdresss = contextView.get("IP Address");
        String location = contextView.get("Location");
        System.out.println("Recived call from " + ipAdresss + " and Location " + location);
        return Mono.just(ipAdresss);
    }
}
