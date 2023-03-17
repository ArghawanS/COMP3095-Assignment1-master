/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import gbc.comp3095.assignment2.models.Ingredient;
import gbc.comp3095.assignment2.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public Set<Ingredient> listAll(String keyword) {
        if (keyword != null) {
            return ingredientRepository.search(keyword);
        }
        Set<Ingredient> r = new HashSet<>(ingredientRepository.findAll());
        return r;
    }

    @Override
    public Ingredient findByName(String name) {
        return ingredientRepository.findByName(name);
    }
}
