package com.example.biblioteca.usecases.resources;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteResource {
    public Mono<Void> deleteFindById(String id);
}
