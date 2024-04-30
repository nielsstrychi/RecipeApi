package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import com.cerba.springbootapp.datatransferobjects.RecipeIngredientDTO;
import com.cerba.springbootapp.entities.RecipeEntity;
import com.cerba.springbootapp.entities.RecipeIngredientEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RecipeIngredientMapper {

    RecipeIngredientDTO entityToDto(RecipeIngredientEntity entity);
    RecipeIngredientEntity dtoToEntity(RecipeIngredientDTO dto);
}
