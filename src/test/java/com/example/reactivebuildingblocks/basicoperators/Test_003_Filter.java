package com.example.reactivebuildingblocks.basicoperators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public class Test_003_Filter {

    @Test
    public void numbersGreaterThan2WithFilter() {

        Flux<Integer> numbers = Flux.just(1, 2, 3, 4);

        Flux<Integer> greaterThan2 = numbers.filter(x -> x > 2);

        Assertions.assertEquals(List.of(3, 4), greaterThan2.collectList().block());
    }

    @Test
    public void fruitsWithColorRedWithFilter() {

        Flux<String> fruits = Flux.just("apple", "orange", "grapes", "strawberry", "watermelon");

        //TODO Use colorOf function. Note that colorOf returns a String
        Flux<String> redFruits = fruits;

        Assertions.assertEquals(List.of("apple", "strawberry"), redFruits.collectList().block());
    }

    private String colorOf(String fruit) {

        Map<String, String> allFruits = Map.of("apple", "red",
                "orange", "orange",
                "grapes", "purple",
                "watermelon", "green",
                "strawberry", "red");
        return allFruits.get(fruit);
    }
}
