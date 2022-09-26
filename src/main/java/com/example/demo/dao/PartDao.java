package com.example.demo.dao;

import com.example.demo.domain.Part;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class PartDao {
    public List<Part> findAll() {
        return IntStream.rangeClosed(1, 20).peek(PartDao::partLookupDelay).peek(i -> System.out.printf("part %s searching %n", i)).mapToObj(i -> new Part(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Part" + i)).collect(Collectors.toList());
    }

    public Flux<Part> findAllParts(){
        return null;
    }
    private static void partLookupDelay(int i) {
        System.out.print("peeking " + i);
    }

    public Part findById(String id) {
        return null;
    }
}
