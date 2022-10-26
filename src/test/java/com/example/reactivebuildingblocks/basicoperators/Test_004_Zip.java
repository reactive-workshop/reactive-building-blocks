package com.example.reactivebuildingblocks.basicoperators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.List;
import java.util.Map;

public class Test_004_Zip {

    @Test
    public void fullNamesWithZip() {
        Flux<String> firstNames = Flux.just("Kalpana", "Imran", "Elon", "Michelle");
        Flux<String> lastNames = Flux.just("Chawla", "Khan", "Musk", "Obama");

        Flux<String> fullNames = Flux.zip(firstNames, lastNames,
                (x, y) -> String.join(" ", x, y));

        Assertions.assertEquals(List.of("Kalpana Chawla", "Imran Khan", "Elon Musk", "Michelle Obama"),
                fullNames.collectList().block());
    }


    @Test
    public void doubleTheNumbersWithZip() {
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4);
        Flux<Integer> doubledNumbers = numbers.map(x -> x * 2);

        Flux<Tuple2<Integer, Integer>> numbersAndTheirDoubles = numbers.zipWith(doubledNumbers);
        //[(1, 2), (2, 4), (3, 6), (4, 8)]

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
