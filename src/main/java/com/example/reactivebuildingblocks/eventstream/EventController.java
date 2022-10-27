package com.example.reactivebuildingblocks.eventstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/events")
class EventController {
    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/all")
    public Flux<Event> getAll() {
        return eventRepository.findAll().log();
    }

    @GetMapping(value = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Event> getAllStream() {
        Flux<Event> flux = eventRepository.findEventsBy();
        return flux.log();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> addOne(@RequestBody Mono<Event> event) {
        return eventRepository.insert(event).then();
    }

    @PostMapping(value = "/add-stream", consumes = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> addEvents(@RequestBody Flux<Event> events) {
        return eventRepository.insert(events).then();
    }
}
