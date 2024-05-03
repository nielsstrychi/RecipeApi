package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.DietaryRestrictionDTO;
import com.cerba.springbootapp.entities.DietaryRestrictionEntity;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class) // JUnit 5
public class DietaryRestrictionMapperTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(
            DietaryRestrictionMapper.class);

    private DietaryRestrictionMapper dietaryRestrictionMapper = context.getBean(DietaryRestrictionMapperImpl.class);

    @Test
    public void testToEntity() {
        // Given
        DietaryRestrictionDTO dto = new DietaryRestrictionDTO();
        dto.setName("Gluten-Free");

        // When
        DietaryRestrictionEntity entity = dietaryRestrictionMapper.dtoToEntity(dto);

        // Then
        assertNotNull(entity);
        assertEquals(dto.getName(), entity.getName());
    }

    @Test
    public void testToDto() {
        // Given
        DietaryRestrictionEntity entity = new DietaryRestrictionEntity();
        entity.setName("Nut-Free");

        // When
        DietaryRestrictionDTO dto = dietaryRestrictionMapper.entityToDto(entity);

        // Then
        assertNotNull(dto);
        assertEquals(entity.getName(), dto.getName());
    }


}
