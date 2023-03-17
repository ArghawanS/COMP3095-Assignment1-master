/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import gbc.comp3095.assignment2.models.Recipe;
import gbc.comp3095.assignment2.models.User;
import gbc.comp3095.assignment2.repositories.RecipeRepository;
import gbc.comp3095.assignment2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;

    public void save(Recipe recipe, User user) {
        recipe.setUser(user);
        recipeRepository.save(recipe);
    }

    public Set<Recipe> listAll(String keyword) {
        if (keyword != null) {
            return recipeRepository.search(keyword);
        }
        Set<Recipe> r = new HashSet<>(recipeRepository.findAll());
        return r;
    }

    @Override
    public Recipe findByName(String name) {
        return recipeRepository.findByName(name);
    }
}
