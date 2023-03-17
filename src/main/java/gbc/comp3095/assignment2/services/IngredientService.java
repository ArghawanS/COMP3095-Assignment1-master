/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import gbc.comp3095.assignment2.models.Ingredient;

import java.util.Set;

public interface IngredientService {
    Ingredient findByName(String name);

    Set<Ingredient> listAll(String keyword);
    void save(Ingredient ingredient);
}
