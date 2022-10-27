package com.example.reactivebuildingblocks.eventstream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;

@Component
public class EventDataSetup implements InitializingBean {
    @Autowired
    MongoOperations mongoOperations;

    @Override
    public void afterPropertiesSet() throws Exception {
        mongoOperations.dropCollection(Event.class);
        mongoOperations.createCollection(Event.class, CollectionOptions.empty().size(1000000).capped());

        Flux.range(1, 5)
                .map(i -> new Event(i.longValue(), UUID.randomUUID().toString()))
                .map(mongoOperations::save)
                .blockLast(Duration.ofSeconds(5));

    }
}
