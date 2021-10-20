package com.example.biblioteca.mappers;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.collections.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Component
public class ResourceMapper {

    public Resource mapToEntity(ResourceDTO resourceDTO) {
        Resource resource= new Resource();
        BeanUtils.copyProperties(resourceDTO,resource);
        return resource;
        };

    public ResourceDTO mapToDTO(Resource resource) {
        ResourceDTO resourceDto = new ResourceDTO();
        BeanUtils.copyProperties(resource,resourceDto);
        return resourceDto;
    }
}