package com.cerba.springbootapp.repositories;

import com.cerba.springbootapp.entities.RecipeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipeRepo extends PagingAndSortingRepository<RecipeEntity, UUID> {
}
