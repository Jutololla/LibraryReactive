package com.example.biblioteca.routers;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.collections.Resource;
import com.example.biblioteca.mappers.ResourceMapper;
import com.example.biblioteca.repositories.ResourceRepository;
import com.example.biblioteca.routers.resources.CreateResourceRouter;
import com.example.biblioteca.usecases.resources.UseCaseCreateResource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CreateResourceRouter.class, UseCaseCreateResource.class, ResourceMapper.class})

class CreateResourceRouterTest {

    @MockBean
    private ResourceRepository resourceRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testCreateResource(){

        Resource resource = new Resource();
        resource.setId("60e78b8ce79ba869b07f059c");
        resource.setAreaThemeId("12345");
        resource.setResourceType("Libro");
        resource.setStatus(true);
        resource.setName("Churchill");
        resource.setDate("09/07/2021");

        ResourceDTO resourceDTO = new ResourceDTO(resource.getId(), resource.getAreaThemeId(), resource.getResourceType(), resource.getStatus(), resource.getName(), resource.getDate());
        Mono<Resource> mono = Mono.just(resource);
        when(resourceRepository.save(any())).thenReturn(mono);

        webTestClient.post()
                .uri("/biblioteca/resource/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(resourceDTO), ResourceDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ResourceDTO.class)
                .value(userResponse -> {
                    Assertions.assertThat(userResponse.getId()).isEqualTo(resource.getId());
                });
    }

}