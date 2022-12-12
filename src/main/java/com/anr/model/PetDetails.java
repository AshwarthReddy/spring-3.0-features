package com.anr.model;


import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record PetDetails(@Id String id, @NotNull(message = "petName must not be null") String name, Integer age) {
}
