package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.DietaryRestrictionDTO;
import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import com.cerba.springbootapp.entities.DietaryRestrictionEntity;
import com.cerba.springbootapp.entities.RecipeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DietaryRestrictionMapper {

    DietaryRestrictionDTO entityToDto(DietaryRestrictionEntity entity);
    DietaryRestrictionEntity dtoToEntity(DietaryRestrictionDTO dto);
}
