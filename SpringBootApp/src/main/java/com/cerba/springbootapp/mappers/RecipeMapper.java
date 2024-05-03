package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import com.cerba.springbootapp.entities.RecipeEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Mapper(componentModel = "spring", uses = { DietaryRestrictionMapper.class, RecipeCategoriesMapper.class, RecipeIngredientMapper.class })
public interface RecipeMapper {

    RecipeDTO entityToDto(RecipeEntity entity);
    RecipeEntity dtoToEntity(RecipeDTO dto);

    default Mono<RecipeDTO> entityToDto(Mono<RecipeEntity> recipe) {
        return recipe.map(this::entityToDto);
    }

    default Flux<RecipeDTO> entityToDto(Flux<RecipeEntity> recipes) {
        return recipes.map(this::entityToDto);
    }
}
