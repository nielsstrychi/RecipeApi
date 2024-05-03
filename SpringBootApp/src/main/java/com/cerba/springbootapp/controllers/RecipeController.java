package com.cerba.springbootapp.controllers;

import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import com.cerba.springbootapp.mappers.RecipeMapper;
import com.cerba.springbootapp.service.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;
    private RecipeMapper recipeMapper;

    @GetMapping
    public Flux<RecipeDTO> getAllRecipes(@RequestParam(defaultValue = "0", required = false) int page,
                                               @RequestParam(defaultValue = "10", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return recipeMapper.entityToDto(recipeService.getRecipes(pageable));
    }

    @GetMapping("/{id}")
    public Mono<RecipeDTO> getRecipeById(@PathVariable UUID id) {
        return recipeMapper.entityToDto(recipeService.getRecipe(id));
    }

    @PostMapping
    public Mono<RecipeDTO> createRecipe(@RequestBody RecipeDTO recipe) {
        return recipeMapper.entityToDto(recipeService.saveRecipe(recipeMapper.dtoToEntity(recipe)));
    }

    @PutMapping("/{id}")
    public Mono<RecipeDTO> updateRecipe(@PathVariable UUID id, @RequestBody RecipeDTO updatedRecipe) {
        return recipeMapper.entityToDto(recipeService.updateRecipe(recipeMapper.dtoToEntity(updatedRecipe)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRecipe(@PathVariable UUID id) {
        this.recipeService.deleteRecipe(id);
    }
}
