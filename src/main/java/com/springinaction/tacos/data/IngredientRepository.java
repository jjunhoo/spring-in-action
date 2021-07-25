package com.springinaction.tacos.data;

import com.springinaction.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    /*
    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
    */
}
