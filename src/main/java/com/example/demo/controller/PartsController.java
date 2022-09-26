package com.example.demo.controller;

import com.example.demo.domain.Part;
import com.example.demo.service.PartsManagerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "api/part", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public class PartsController {

    PartsManagerService svc;
    public PartsController(PartsManagerService svc){
        this.svc = svc;
    }

    @GetMapping (path = "stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Part> getPartsFlux(){
        return svc.getCurrentParts();
    }

    @GetMapping (path = "syncstream", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Part> getSyncPartsFlux(){
        return svc.getCurrentParts();
    }

    @GetMapping("{id}")
    Mono<Part> findById(@PathVariable String id){
        return this.svc.findOne(id);
    }

}
