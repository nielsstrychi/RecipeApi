package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.IngredientDTO;
import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import com.cerba.springbootapp.entities.IngredientEntity;
import com.cerba.springbootapp.entities.RecipeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface IngredientMapper {

    IngredientDTO entityToDto(IngredientEntity entity);
    IngredientEntity dtoToEntity(IngredientDTO dto);
}
