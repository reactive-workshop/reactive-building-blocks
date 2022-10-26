package com.example.reactivebuildingblocks.basicoperators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public class Test_002_FlatMap {

    @Test
    public void repeatTheNumbersWithFlatMap() {

        Flux<Integer> numbers = Flux.just(1, 2);

        Flux<Integer> repeatedNumbers = numbers.flatMap(x -> repeatTheNumber(x));

        Assertions.assertEquals(List.of(1, 1, 2, 2), repeatedNumbers.collectList().block());
    }
    private Flux<Integer> repeatTheNumber(int number) {
        return Flux.just(number, number);
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
