package com.cerba.springbootapp.controllers;

import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @GetMapping
    public Flux<Page<RecipeDTO>> getAllRecipes(@RequestParam(defaultValue = "0", required = false) int page,
                                               @RequestParam(defaultValue = "10", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return null;
    }

    @GetMapping("/{id}")
    public Mono<RecipeDTO> getRecipeById(@PathVariable UUID id) {
        return null;
    }

    @PostMapping
    public Mono<RecipeDTO> createRecipe(@RequestBody RecipeDTO Recipe) {
        return null;
    }

    @PutMapping("/{id}")
    public Mono<RecipeDTO> updateRecipe(@PathVariable UUID id, @RequestBody RecipeDTO updatedRecipe) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable UUID id) {
        return null;
    }
}
