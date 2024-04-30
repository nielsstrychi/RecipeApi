package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.RecipeIngredientDTO;
import com.cerba.springbootapp.entities.IngredientEntity;
import com.cerba.springbootapp.entities.MeasurementEntity;
import com.cerba.springbootapp.entities.RecipeIngredientEntity;
import com.cerba.springbootapp.mappers.*;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class) // JUnit 5
public class RecipeIngredientMapper {

    ApplicationContext context = new AnnotationConfigApplicationContext(
            RecipeIngredientMapperImpl.class,
            IngredientMapperImpl.class, MeasurementMapperImpl.class);

    private RecipeIngredientMapperImpl ingredientMapper = context.getBean(RecipeIngredientMapperImpl.class);

    @Test
    public void testToDto() {
        // Given
        IngredientEntity ingredient = new IngredientEntity();
        ingredient.setName("Chicken");

        MeasurementEntity measurement = new MeasurementEntity();
        measurement.setMeasurement("kg");

        RecipeIngredientEntity entity = new RecipeIngredientEntity();
        entity.setIngredient(ingredient);
        entity.setMeasurement(measurement);
        entity.setQuantity(1);

        // When
        RecipeIngredientDTO dto = ingredientMapper.entityToDto(entity);

        // Then
        assertNotNull(dto);
        assertEquals("Chicken", dto.getIngredient());
        assertEquals("kg", dto.getMeasurement());
        assertEquals(Integer.valueOf(1), dto.getQuantity());
    }

    @Test
    public void testToDtoWithNullValues() {
        // Given
        RecipeIngredientEntity entity = new RecipeIngredientEntity(); // All fields null by default

        // When
        RecipeIngredientDTO dto = ingredientMapper.entityToDto(entity);

        // Then
        assertNotNull(dto);
        assertNull(dto.getIngredient()); // Expecting null for missing ingredient
        assertNull(dto.getMeasurement()); // Expecting null for missing measurement
        assertNull(dto.getQuantity()); // Expecting null for missing quality
    }

    @Test
    public void testToEntity() {
        // Given
        RecipeIngredientDTO dto = new RecipeIngredientDTO();
        dto.setIngredient("Chicken");
        dto.setMeasurement("kg");
        dto.setQuantity(1);

        // When
        RecipeIngredientEntity entity = ingredientMapper.dtoToEntity(dto);

        // Then
        assertNotNull(entity);
        assertNotNull(entity.getIngredient());
        assertNotNull(entity.getMeasurement());
        assertEquals("Chicken", entity.getIngredient().getName());
        assertEquals("kg", entity.getMeasurement().getMeasurement());
        assertEquals(Integer.valueOf(1), entity.getQuantity());
    }

    @Test
    public void testToEntityWithNullValues() {
        // Given
        RecipeIngredientDTO dto = new RecipeIngredientDTO(); // All fields null by default

        // When
        RecipeIngredientEntity entity = ingredientMapper.dtoToEntity(dto);

        // Then
        assertNotNull(entity);
        assertNotNull(entity.getIngredient());
        assertNotNull(entity.getMeasurement());
        assertNull(entity.getIngredient().getName()); // Expecting null for missing ingredient name
        assertNull(entity.getMeasurement().getMeasurement()); // Expecting null for missing measurement name
        assertNull(entity.getQuantity()); // Expecting null for missing quantity name
    }
}
