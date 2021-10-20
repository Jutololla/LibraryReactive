package com.example.biblioteca.routers.resources;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.usecases.resources.UseCaseRecommendResourceThematic;
import com.example.biblioteca.usecases.resources.UseCaseRecommendResourceTypeAndThematic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RecommendResourceTypeAndThematicRouter {

    @Bean
    public RouterFunction<ServerResponse> recommendResourceTypeAndThematic(UseCaseRecommendResourceTypeAndThematic useCaseRecommendResourceTypeAndThematic){
        return route(GET("/library/resource/recommend/thematic/{type}/{thematic}").and(accept(MediaType.APPLICATION_JSON)),
                request ->ServerResponse.ok()
                        .body(useCaseRecommendResourceTypeAndThematic.apply(request.pathVariable("type"),request.pathVariable( "thematic")), ResourceDTO.class));
    }
}
