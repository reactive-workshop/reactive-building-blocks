package com.example.reactivebuildingblocks.basicoperators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public class Test_002_FlatMap {

    @Test
    public void doubleTheNumbersWithFlatMap() {

        Flux<Integer> numbers = Flux.just(1, 2, 3, 4);

        Flux<Integer> doubledNumbers = numbers.flatMap(x -> doubleTheNumber(x));

        Assertions.assertEquals(List.of(2, 4, 6, 8), doubledNumbers.collectList().block());
    }

    private Mono<Integer> doubleTheNumber(int number) {
        return Mono.just(number * 2);
    }

    @Test
    public void colorOfFruitsWithFlatMap() {

        Flux<String> fruits = Flux.just("apple", "orange", "grapes", "watermelon");

        //TODO Use the utility function colorOf. Note that colorOf returns a Mono
        Flux<String> fruitColors = fruits;

        Assertions.assertEquals(List.of("red", "orange", "purple", "green"), fruitColors.collectList().block());
    }

    private Mono<String> colorOf(String fruit) {

        Map<String, String> allFruits = Map.of("apple", "red",
                "orange", "orange",
                "grapes", "purple",
                "watermelon", "green");
        return Mono.just(allFruits.get(fruit));
    }

    @Test
    public void colorOfMixedCasedFruits() {

        Flux<String> fruits = Flux.just("aPPle", "Orange", "graPes", "waterMeLon");

        //TODO. Map to lowercase and then apply flatMap over colorOf
        Flux<String> fruitColors = fruits;

        Assertions.assertEquals(List.of("red", "orange", "purple", "green"), fruitColors.collectList().block());
    }

}
