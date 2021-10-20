package com.example.biblioteca.usecases.resources;

import com.example.biblioteca.DTOs.ResourceDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateResource {
    public Mono<ResourceDTO> apply(ResourceDTO resourceDTO);
}
