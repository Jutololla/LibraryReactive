package com.example.biblioteca.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document //Document in the collection
public class Resource {

    @Id
    private String id;
    private String name;
    private LocalDate loanDate;
    private int quantityAvailable;
    private int quantityBorrowed;
    private String type;
    private String thematic;

}
