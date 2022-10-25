package com.example.reactivebuildingblocks.reactorcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ContextDemoController {
    @Autowired
    ContextDemoService contextDemoService;

    @GetMapping("/context")
    public Mono<String> testContext(@RequestParam String id){
        return contextDemoService.printContextData(id);
    }
}
