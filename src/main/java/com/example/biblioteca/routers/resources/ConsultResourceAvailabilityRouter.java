package com.example.biblioteca.routers.resources;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.usecases.resources.UseCaseConsultAvailabilityResource;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class ConsultResourceAvailabilityRouter {

    @Bean
    public RouterFunction<ServerResponse> consultAvailabilityResource(UseCaseConsultAvailabilityResource useCaseConsultAvailabilityResource){
        return route(GET("/library/resource/availability/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->ServerResponse.ok()
                        .body(useCaseConsultAvailabilityResource.apply(request.pathVariable("id")), ResourceDTO.class));
    }
}
