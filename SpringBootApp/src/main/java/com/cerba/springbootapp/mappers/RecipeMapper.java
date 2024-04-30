package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import com.cerba.springbootapp.entities.RecipeEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = { DietaryRestrictionMapper.class, RecipeCategoriesMapper.class, RecipeIngredientMapper.class })
public interface RecipeMapper {

    RecipeDTO entityToDto(RecipeEntity entity);
    RecipeEntity dtoToEntity(RecipeDTO dto);
}
