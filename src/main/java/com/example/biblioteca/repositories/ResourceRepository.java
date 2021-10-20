package com.example.biblioteca.repositories;

import com.example.biblioteca.collections.Resource;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

public interface ResourceRepository extends ReactiveMongoRepository<Resource, String> {

    @Transactional(readOnly = true)
    Flux<Resource> findByResourceType(String resourceType);

}