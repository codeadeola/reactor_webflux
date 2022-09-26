package com.example.demo.service;

import com.example.demo.dao.PartDao;
import com.example.demo.domain.Part;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PartsManagerService {

    private final PartDao dao;

    public PartsManagerService(PartDao dao){
        this.dao = dao;
    }

    public List<Part> getAllParts(){
        return dao.findAll();
    }

    public Flux<Part> getCurrentParts(){
        return dao.findAllParts();
    }

    public Mono<Part> findOne(final String id) {
       return Mono.justOrEmpty(dao.findById(id));
    }
}
