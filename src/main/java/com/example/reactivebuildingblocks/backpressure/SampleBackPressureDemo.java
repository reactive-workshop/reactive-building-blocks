package com.example.reactivebuildingblocks.backpressure;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class SampleBackPressureDemo {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1, 10).log();

        subscribe(flux);
//        will result in all elements pushed at once

        subscribeWithBackpressure(flux);
//        will result in all elements pushed at once
    }

    private static void subscribe(Flux<Integer> flux) {
        flux.subscribe(System.out::println);
    }

    private static void subscribeWithBackpressure(Flux<Integer> flux) {
        flux
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        System.out.println("On Subscribe Hook ");
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println("On Next Hook ");
                        processElement(value);
                        request(1);
                    }
                });
    }

    private static void processElement(Integer value) {
        try {
            Thread.sleep(500);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
