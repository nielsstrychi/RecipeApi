package com.cerba.springbootapp.controllers;

import com.cerba.springbootapp.datatransferobjects.IngredientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @GetMapping
    public Flux<Page<IngredientDTO>> getAllIngredients(@RequestParam(defaultValue = "0", required = false) int page,
                                                       @RequestParam(defaultValue = "10", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return null;
    }

    @GetMapping("/{id}")
    public Mono<IngredientDTO> getIngredientById(@PathVariable UUID id) {
            return null;
    }

    @PostMapping
    public Mono<IngredientDTO> createIngredient(@RequestBody IngredientDTO ingredient) {
        return null;
    }

    @PutMapping("/{id}")
    public Mono<IngredientDTO> updateIngredient(@PathVariable UUID id, @RequestBody IngredientDTO updatedIngredient) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable UUID id) {
        return null;
    }

    }
