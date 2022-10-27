package com.example.reactivebuildingblocks.eventstream;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
interface EventRepository extends ReactiveMongoRepository<Event, Long> {

    @Tailable
    Flux<Event> findEventsBy();

}
