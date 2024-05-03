package com.cerba.springbootapp.repositories;

import com.cerba.springbootapp.entities.RecipeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface RecipeRepo extends ReactiveSortingRepository<RecipeEntity, UUID>, ReactiveCrudRepository<RecipeEntity, UUID> {

    Flux<RecipeEntity> findAllBy(Pageable page);


}
