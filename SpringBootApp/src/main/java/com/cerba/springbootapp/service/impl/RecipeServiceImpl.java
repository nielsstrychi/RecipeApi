package com.cerba.springbootapp.service.impl;

import com.cerba.springbootapp.entities.RecipeEntity;
import com.cerba.springbootapp.repositories.RecipeRepo;
import com.cerba.springbootapp.service.RecipeService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepo repo;


    @Override
    public Flux<RecipeEntity> getRecipes(Pageable pageable) {
        return this.repo.findAllBy(pageable);
    }

    @Override
    public Mono<RecipeEntity> getRecipe(UUID id) {
        return this.repo.findById(id);
    }

    @Override
    public Mono<RecipeEntity> saveRecipe(RecipeEntity recipeEntity) {
        return this.repo.save(recipeEntity);
    }

    @Override
    public Mono<RecipeEntity> updateRecipe(RecipeEntity recipeEntity) {
        return this.repo.save(recipeEntity);
    }

    @Override
    public void deleteRecipe(UUID id) {
        this.repo.deleteById(id);
    }
}
