package com.example.reactivebuildingblocks.basicoperators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public class Test_005_SwitchIfEmpty {

    @Test
    public void fruitsWithUnknownColors() {

        Flux<String> fruits = Flux.just("apple", "papaya");

        Flux<String> colors = fruits
                .flatMap(x -> colorOf(x)
                        .switchIfEmpty(Mono.just("unknown")));

        Assertions.assertEquals(List.of("red", "unknown"), colors.collectList().block());
    }

    private Mono<String> colorOf(String fruit) {

        Map<String, String> allFruits = Map.of("apple", "red",
                "orange", "orange",
                "grapes", "purple",
                "watermelon", "green",
                "strawberry", "red");
        if (!allFruits.containsKey(fruit)) {
            return Mono.empty();
        }
        return Mono.just(allFruits.get(fruit));
    }
}
