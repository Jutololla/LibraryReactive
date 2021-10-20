package com.example.biblioteca.usecases.resources;

import com.example.biblioteca.DTOs.AnswerDTO;
import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.collections.Resource;
import com.example.biblioteca.mappers.ResourceMapper;
import com.example.biblioteca.repositories.ResourceRepository;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;

@Service
public class UseCaseConsultAvailabilityResource implements Function<String, Mono<String>> {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    public UseCaseConsultAvailabilityResource(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Mono<String> apply(String id) {
        Objects.requireNonNull(id, "The object does not exists");
        return
                resourceRepository.findById(id).
                        map(resource -> {
                            return (resource.getQuantityAvailable() > 0) ?
                                    String.valueOf("The resourse is available to be lent")
                                    : String.valueOf("The resourse is not available. It was lent on "+resource.getLoanDate());
                        });
    }
}
