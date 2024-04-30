package com.cerba.springbootapp.mappers;

import com.cerba.springbootapp.datatransferobjects.*;
import com.cerba.springbootapp.entities.*;
import com.cerba.springbootapp.mappers.*;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.A;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) // JUnit 5
public class RecipeMapperTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(
            RecipeMapperImpl.class, DietaryRestrictionMapperImpl.class,
            RecipeIngredientMapperImpl.class, RecipeCategoriesMapperImpl.class);

    private RecipeMapperImpl recipeMapper = context.getBean(RecipeMapperImpl.class);

    @Test
    public void recipeMapperDTOLiteralsTest() {
        RecipeEntity recipe = new RecipeEntity();
        recipe.setId(UUID.randomUUID());
        recipe.setName("Spaghetti Carbonara");
        recipe.setDescription("Classic Italian pasta dish");
        recipe.setCookingInstructions("...");
        recipe.setPreparationTime(LocalTime.of(0, 30)); // 30 minutes
        recipe.setCookingTime(LocalTime.of(0, 20)); // 20 minutes
        // Set ingredients, category, and dietary restrictions as needed...

        // When
        RecipeDTO recipeDTO = recipeMapper.entityToDto(recipe);

        // Then
        assertEquals(recipe.getId(), recipeDTO.getId());
        assertEquals(recipe.getName(), recipeDTO.getName());
        assertEquals(recipe.getDescription(), recipeDTO.getDescription());
        assertEquals(recipe.getCookingInstructions(), recipeDTO.getCookingInstructions());
        assertEquals(LocalTime.parse("00:30"), recipeDTO.getPreparationTime()); // Format LocalTime as a string
        assertEquals(LocalTime.parse("00:20"), recipeDTO.getCookingTime()); // Format LocalTime as a string
    }

    @Test
    public void recipeMapperDTOTestWithNestedMappers() {
        RecipeEntity recipe = new RecipeEntity();
        recipe.setName("Pasta Carbonara");
        recipe.setDescription("Classic Italian pasta dish with eggs and bacon");
        recipe.setCookingInstructions("...");
        recipe.setPreparationTime(LocalTime.of(0, 20)); // 20 minutes
        recipe.setCookingTime(LocalTime.of(0, 15)); // 15 minutes

        // Mock ingredients
        RecipeIngredientEntity ingredient1 = new RecipeIngredientEntity();
        ingredient1.setRecipe(recipe);
        ingredient1.setIngredient(new IngredientEntity("Spaghetti"));
        ingredient1.setMeasurement(new MeasurementEntity("grams"));
        ingredient1.setQuantity(200);

        RecipeIngredientEntity ingredient2 = new RecipeIngredientEntity();
        ingredient2.setRecipe(recipe);
        ingredient2.setIngredient(new IngredientEntity("Eggs"));
        ingredient2.setMeasurement(new MeasurementEntity("units"));
        ingredient2.setQuantity(2);

        Set<RecipeIngredientEntity> ingredients = new HashSet<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        recipe.setIngredients(ingredients);

        // Mock category
        RecipeCategoriesEntity category = new RecipeCategoriesEntity("Italian Cuisine");
        recipe.setCategory(category);

        // Mock dietary restrictions
        Set<DietaryRestrictionEntity> dietaryRestrictions = new HashSet<>();
        dietaryRestrictions.add(new DietaryRestrictionEntity("Contains Gluten"));
        recipe.setDietaryRestrictions(dietaryRestrictions);

        // When
        RecipeDTO recipeDTO = recipeMapper.entityToDto(recipe);

        // Then
        assertNotNull(recipeDTO);
        assertEquals(recipe.getName(), recipeDTO.getName());
        assertEquals(recipe.getDescription(), recipeDTO.getDescription());
        assertEquals(recipe.getCookingInstructions(), recipeDTO.getCookingInstructions());
        assertEquals(LocalTime.parse("00:20"), recipeDTO.getPreparationTime()); // Format LocalTime as a string
        assertEquals(LocalTime.parse("00:15"), recipeDTO.getCookingTime()); // Format LocalTime as a string

        // Assert ingredients
        assertNotNull(recipeDTO.getIngredients());
        assertEquals(2, recipeDTO.getIngredients().size());

        RecipeIngredientDTO ingredientDTO1 = recipeDTO.getIngredients().stream()
                .filter(ingredient -> ingredient.getIngredient().equals("Spaghetti"))
                .findFirst()
                .orElse(null);
        assertNotNull(ingredientDTO1);
        assertEquals("Spaghetti", ingredientDTO1.getIngredient());
        assertEquals("grams", ingredientDTO1.getMeasurement());
        assertEquals(Integer.valueOf(200), ingredientDTO1.getQuantity());

        RecipeIngredientDTO ingredientDTO2 = recipeDTO.getIngredients().stream()
                .filter(ingredient -> ingredient.getIngredient().equals("Eggs"))
                .findFirst()
                .orElse(null);
        assertNotNull(ingredientDTO2);
        assertEquals("Eggs", ingredientDTO2.getIngredient());
        assertEquals("units", ingredientDTO2.getMeasurement());
        assertEquals(Integer.valueOf(2), ingredientDTO2.getQuantity());

        // Assert category
        assertNotNull(recipeDTO.getCategory());
        assertEquals("Italian Cuisine", recipeDTO.getCategory().getName());

        // Assert dietary restrictions
        assertNotNull(recipeDTO.getDietaryRestrictions());
        assertEquals(1, recipeDTO.getDietaryRestrictions().size());
        assertEquals("Contains Gluten", recipeDTO.getDietaryRestrictions().iterator().next().getName());
    }

    @Test
    public void recipeMapperEntityLiteralsTest() {
        // Given
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(UUID.randomUUID());
        recipeDTO.setName("Pasta Carbonara");
        recipeDTO.setDescription("Classic Italian pasta dish with eggs and bacon");
        recipeDTO.setCookingInstructions("...");
        recipeDTO.setPreparationTime(LocalTime.parse("00:20")); // 20 minutes
        recipeDTO.setCookingTime(LocalTime.parse("00:15")); // 15 minutes

        // When
        RecipeEntity recipe = recipeMapper.dtoToEntity(recipeDTO);

        // Then
        assertNotNull(recipe);
        assertEquals(recipeDTO.getId(), recipe.getId());
        assertEquals(recipeDTO.getName(), recipe.getName());
        assertEquals(recipeDTO.getDescription(), recipe.getDescription());
        assertEquals(recipeDTO.getCookingInstructions(), recipe.getCookingInstructions());
        assertEquals(LocalTime.of(0, 20), recipe.getPreparationTime()); // Parse string to LocalTime
        assertEquals(LocalTime.of(0, 15), recipe.getCookingTime()); // Parse string to LocalTime
    }

    @Test
    public void recipeMapperEntityTestWithNestedMappers() {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setName("Chicken Stir-Fry");
        recipeDTO.setDescription("Delicious stir-fried chicken with vegetables");
        recipeDTO.setCookingInstructions("...");
        recipeDTO.setPreparationTime(LocalTime.parse("00:25")); // 25 minutes
        recipeDTO.setCookingTime(LocalTime.parse("00:15")); // 15 minutes

        // Mock ingredients
        RecipeIngredientDTO ingredient1 = new RecipeIngredientDTO();
        ingredient1.setIngredient("Chicken");
        ingredient1.setMeasurement("kg");
        ingredient1.setQuantity(2);

        RecipeIngredientDTO ingredient2 = new RecipeIngredientDTO();
        ingredient2.setIngredient("Bell Pepper");
        ingredient2.setMeasurement("large");
        ingredient2.setQuantity(1);

        Set<RecipeIngredientDTO> ingredients = new HashSet<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        recipeDTO.setIngredients(ingredients);

        // Mock category
        RecipeCategoriesDTO category = new RecipeCategoriesDTO("Asian Cuisine");
        recipeDTO.setCategory(category);

        // Mock dietary restrictions
        Set<DietaryRestrictionDTO> dietaryRestrictions = new HashSet<>();
        dietaryRestrictions.add(new DietaryRestrictionDTO("Gluten-Free"));
        dietaryRestrictions.add(new DietaryRestrictionDTO("Nut-Free"));
        recipeDTO.setDietaryRestrictions(dietaryRestrictions);

        // When
        RecipeEntity recipe = recipeMapper.dtoToEntity(recipeDTO);

        // Then
        assertNotNull(recipe);
        assertEquals(recipeDTO.getName(), recipe.getName());
        assertEquals(recipeDTO.getDescription(), recipe.getDescription());
        assertEquals(recipeDTO.getCookingInstructions(), recipe.getCookingInstructions());
        assertEquals(LocalTime.of(0, 25), recipe.getPreparationTime()); // Parse string to LocalTime
        assertEquals(LocalTime.of(0, 15), recipe.getCookingTime()); // Parse string to LocalTime

        // Assert ingredients
        assertNotNull(recipe.getIngredients());
        assertEquals(2, recipe.getIngredients().size());

        RecipeIngredientEntity ingredientDTO1 = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getIngredient().getName().equals("Chicken"))
                .findFirst()
                .orElse(null);
        assertNotNull(ingredientDTO1);
        assertEquals("Chicken", ingredientDTO1.getIngredient().getName());
        assertEquals("kg", ingredientDTO1.getMeasurement().getMeasurement());
        assertEquals(Integer.valueOf(2), ingredientDTO1.getQuantity());

        RecipeIngredientEntity ingredientDTO2 = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getIngredient().getName().equals("Bell Pepper"))
                .findFirst()
                .orElse(null);
        assertNotNull(ingredientDTO2);
        assertEquals("Bell Pepper", ingredientDTO2.getIngredient().getName());
        assertEquals("large", ingredientDTO2.getMeasurement().getMeasurement());
        assertEquals(Integer.valueOf(1), ingredientDTO2.getQuantity());

        // Assert category
        assertNotNull(recipe.getCategory());
        assertEquals("Asian Cuisine", recipe.getCategory().getName());

        // Assert dietary restrictions
        assertFalse(recipe.getDietaryRestrictions().isEmpty());
        assertEquals(2, recipe.getDietaryRestrictions().size());
        assertEquals("Gluten-Free", recipe.getDietaryRestrictions().stream()
                .map(DietaryRestrictionEntity::getName)
                .filter(name -> name.equals("Gluten-Free"))
                .findFirst()
                .orElse(null));
    }

}
