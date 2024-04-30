package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.RecipeCategoriesDTO;
import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import com.cerba.springbootapp.entities.RecipeEntity;
import com.cerba.springbootapp.entities.RecipeIngredientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeCategoriesMapper {

    RecipeCategoriesDTO entityToDto(RecipeIngredientEntity entity);
    RecipeIngredientEntity dtoToEntity(RecipeCategoriesDTO dto);
}
