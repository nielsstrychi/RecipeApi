package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.RecipeIngredientDTO;
import com.cerba.springbootapp.entities.MeasurementEntity;
import com.cerba.springbootapp.entities.RecipeIngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ValueMapping;

@Mapper(componentModel = "spring")
public interface RecipeIngredientMapper {


    @Mappings({
            @Mapping(source = "ingredient.name", target = "ingredient"),
            @Mapping(source = "measurement.measurement", target = "measurement")
    })
    RecipeIngredientDTO entityToDto(RecipeIngredientEntity entity);
    @Mappings({
            @Mapping(target = "recipe", ignore = true),
            @Mapping(source = "ingredient", target = "ingredient.name"),
            @Mapping(source = "measurement", target = "measurement.measurement")
    })
    RecipeIngredientEntity dtoToEntity(RecipeIngredientDTO dto);
}
