package com.anr.controller;

import com.anr.model.PetDetails;
import com.anr.repo.PetRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet/v1")
@RequiredArgsConstructor
@Validated
public class PetController {


    private final PetRepository petRepository;

    @PostMapping
    public PetDetails savePetDetails(@RequestBody @Valid PetDetails pet) {
        return petRepository.save(pet);
    }

    @GetMapping("/{id}")
    public Optional<PetDetails> getPetDetails(@PathVariable String id) {
        return petRepository.findById(id);
    }

    @GetMapping
    public List<PetDetails> getAllPets() {
        return petRepository.findAll();
    }
}
