package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import com.cerba.springbootapp.entities.RecipeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RecipeMapper {

    RecipeDTO entityToDto(RecipeEntity entity);
    RecipeEntity dtoToEntity(RecipeDTO dto);
}
