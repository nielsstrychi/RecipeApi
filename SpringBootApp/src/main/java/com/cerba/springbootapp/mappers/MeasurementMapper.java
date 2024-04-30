package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.MeasurementDTO;
import com.cerba.springbootapp.datatransferobjects.RecipeDTO;
import com.cerba.springbootapp.entities.MeasurementEntity;
import com.cerba.springbootapp.entities.RecipeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {

    MeasurementDTO entityToDto(MeasurementEntity entity);
    MeasurementEntity dtoToEntity(MeasurementDTO dto);
}
