package com.example.biblioteca.usecases.resources;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.mappers.ResourceMapper;
import com.example.biblioteca.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
public class UseCaseRecommendResourceType implements Function<String, Flux<ResourceDTO>> {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public UseCaseRecommendResourceType(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Flux<ResourceDTO> apply(String resourceType){
        return resourceRepository.findByResourceType(resourceType).map(resourceMapper::mapToDTO);
    }
}
