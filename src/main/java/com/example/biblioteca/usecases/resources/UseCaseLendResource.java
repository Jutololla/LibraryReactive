package com.example.biblioteca.usecases.resources;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.mappers.ResourceMapper;
import com.example.biblioteca.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@Validated
public class UseCaseLendResource implements Function<String, Mono<String>> {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired

    public UseCaseLendResource(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Mono<String> apply(String id){

        return resourceRepository.findById(id).flatMap(
                resource -> {
                    if(resource.getQuantityAvailable()>0){
                        resource.setLoanDate(LocalDate.now());
                        resource.setQuantityAvailable(resource.getQuantityAvailable()-1);
                        resource.setQuantityBorrowed(resource.getQuantityBorrowed()+1);
                        return Mono.just(String.valueOf("The resource's been lent"));
                    }
                    return Mono.just(String.valueOf("There are not units to be lent"));
                }
        );
    }
}
