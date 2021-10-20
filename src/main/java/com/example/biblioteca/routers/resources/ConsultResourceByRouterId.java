package com.example.biblioteca.routers.resources;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.usecases.resources.UseCaseConsultResourceById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class ConsultResourceByRouterId {

    @Bean
    public RouterFunction<ServerResponse> consultResourceById(UseCaseConsultResourceById useCaseConsultResourceById){
        return route(GET("/library/resource/consult/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                .body(useCaseConsultResourceById.findById(request.pathVariable("id")),ResourceDTO.class));
    }
}
