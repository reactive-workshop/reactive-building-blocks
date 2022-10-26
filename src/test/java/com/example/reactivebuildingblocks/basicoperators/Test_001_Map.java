package com.example.reactivebuildingblocks.basicoperators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.List;

public class Test_001_Map {

    @Test
    public void doubleTheNumbersWithMap() {

        Flux<Integer> numbers = Flux.just(1, 2, 3, 4);

        Flux<Integer> doubledNumbers = numbers.map(x -> doubleTheNumber(x));

        Assertions.assertEquals(List.of(2, 4, 6, 8), doubledNumbers.collectList().block());
    }
    private int doubleTheNumber(int number) {
        return number * 2;
    }

    @Test
    public void upperCaseStringsWithMap() {

        Flux<String> fruits = Flux.just("aPPle", "Orange", "graPes", "waterMeLon");

        //TODO Use upperCaseTheFruits function
        Flux<String> upperCasedFruits = fruits;

        Assertions.assertEquals(List.of("APPLE", "ORANGE", "GRAPES", "WATERMELON"), upperCasedFruits.collectList().block());
    }

    private String upperCaseTheFruits(String fruit) {
        return fruit.toUpperCase();
    }

}
