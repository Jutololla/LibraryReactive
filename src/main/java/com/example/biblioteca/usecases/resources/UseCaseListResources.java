package com.example.biblioteca.usecases.resources;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.mappers.ResourceMapper;
import com.example.biblioteca.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.util.function.Supplier;

@Service
public class UseCaseListResources implements Supplier<Flux<ResourceDTO>> {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired

    public UseCaseListResources(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Flux<ResourceDTO> get() {
        return resourceRepository.findAll().map(resourceMapper::mapToDTO);
    }
}
