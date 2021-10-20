package com.example.biblioteca.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResourceDTO {

    private String id;
    private String name;
    private LocalDate loanDate;
    private int quantityAvailable;
    private int quantityBorrowed;
    private String type;
    private String thematic;

    public boolean isEmpty(){
        return name.isEmpty() || type.isEmpty() || thematic.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResourceDTO)) return false;
        ResourceDTO that = (ResourceDTO) o;
        return getQuantityAvailable() == that.getQuantityAvailable() && getQuantityBorrowed() == that.getQuantityBorrowed() && Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getLoanDate(), that.getLoanDate()) && Objects.equals(getType(), that.getType()) && Objects.equals(getThematic(), that.getThematic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLoanDate(), getQuantityAvailable(), getQuantityBorrowed(), getType(), getThematic());
    }
}
