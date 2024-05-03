package com.cerba.springbootapp.service;

import com.cerba.springbootapp.entities.RecipeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RecipeService {
    Flux<RecipeEntity> getRecipes(Pageable pageable);

    Mono<RecipeEntity> getRecipe(UUID id);

    Mono<RecipeEntity> saveRecipe(RecipeEntity recipeEntity);
    Mono<RecipeEntity> updateRecipe(RecipeEntity recipeEntity);

    void deleteRecipe(UUID id);
}
