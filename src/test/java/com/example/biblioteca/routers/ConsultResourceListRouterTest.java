package com.example.biblioteca.routers;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.collections.Resource;
import com.example.biblioteca.mappers.ResourceMapper;
import com.example.biblioteca.repositories.ResourceRepository;
import com.example.biblioteca.routers.resources.ConsultResourceListRouter;
import com.example.biblioteca.usecases.resources.UseCaseListResources;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConsultResourceListRouter.class, UseCaseListResources.class, ResourceMapper.class})

class ConsultResourceListRouterTest {

    @MockBean
    private ResourceRepository resourceRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testConsultListResource(){

        Resource resourceOne = new Resource();
        Resource resourceTwo = new Resource();

        resourceOne.setId("60e78b8ce79ba869b07f059c");
        resourceOne.setAreaThemeId("12345");
        resourceOne.setResourceType("Libro");
        resourceOne.setStatus(true);
        resourceOne.setName("Churchill");
        resourceOne.setDate("09/07/2021");
        resourceTwo.setId("60e78b8ce79ba869b07f041k");
        resourceTwo.setAreaThemeId("11223");
        resourceTwo.setResourceType("Libro");
        resourceTwo.setStatus(true);
        resourceTwo.setName("Lluvia fina");
        resourceTwo.setDate("01/04/2021");

        when(resourceRepository.findAll()).thenReturn(Flux.just(resourceOne, resourceTwo));

        webTestClient.get()
                .uri("/biblioteca/resource/consult")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ResourceDTO.class)
                .value(userResponse -> {
                    Assertions.assertThat(userResponse.get(0).getName()).isEqualTo(resourceOne.getName());
                    Assertions.assertThat(userResponse.get(1).getName()).isEqualTo(resourceTwo.getName());
                });
    }
}