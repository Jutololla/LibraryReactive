package com.example.biblioteca.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResourceDTO {

    private String id;
    private String areaThemeId;
    private String resourceType;
    private boolean status;
    private String name;
    private String date;

    @Override
    public boolean equals (Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceDTO that = (ResourceDTO) o;
        return status == that.status &&
                Objects.equals(id, that.id) &&
                Objects.equals(resourceType, that.resourceType) &&
                Objects.equals(areaThemeId, that.areaThemeId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, resourceType, areaThemeId, status, name, date);
    }
}
