package com.example.reactivebuildingblocks.basicoperators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.List;
import java.util.Map;

public class ZipTests {

    @Test
    public void doubleTheNumbersWithZip() {
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4);

        Flux<Tuple2<Integer, Integer>> numbersAndTheirDoubles = numbers.zipWith(numbers.map(x -> x * 2));

        Assertions.assertEquals(List.of(Tuples.of(1, 2),
                Tuples.of(2, 4),
                Tuples.of(3, 6),
                Tuples.of(4, 8)), numbersAndTheirDoubles.collectList().block());
    }
    
    @Test
    public void fruitsWithColorRed() {

        Flux<String> fruits = Flux.just("apple", "orange", "grapes", "strawberry", "watermelon");

        //TODO Use colorOf function. Note that colorOf returns a Mono
        Flux<String> redFruits = fruits;

        Assertions.assertEquals(List.of("apple", "strawberry"), redFruits.collectList().block());
    }

    private Mono<String> colorOf(String fruit) {

        Map<String, String> allFruits = Map.of("apple", "red",
                "orange", "orange",
                "grapes", "purple",
                "watermelon", "green",
                "strawberry", "red");
        return Mono.just(allFruits.get(fruit));
    }
}
