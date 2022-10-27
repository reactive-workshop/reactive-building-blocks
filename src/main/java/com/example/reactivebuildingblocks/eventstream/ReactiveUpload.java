package com.example.reactivebuildingblocks.eventstream;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;

public class ReactiveUpload {
    public static void main(String[] args) {
        WebClient client = WebClient.create("http://localhost:8080");

        Flux<Event> events = Flux.interval(Duration.ofSeconds(2)).map(i -> new Event(i + 200, UUID.randomUUID().toString()));

        client.post()
                .uri("/events/add-stream")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(events, Event.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
