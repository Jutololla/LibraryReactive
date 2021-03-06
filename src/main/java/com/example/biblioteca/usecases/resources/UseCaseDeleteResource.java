package com.example.biblioteca.usecases.resources;

import com.example.biblioteca.mappers.ResourceMapper;
import com.example.biblioteca.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class UseCaseDeleteResource implements DeleteResource {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public UseCaseDeleteResource(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Mono<Void> deleteFindById(String id) {
        Objects.requireNonNull(id, "The object does not exists");
        return resourceRepository.deleteById(id);
    }
}