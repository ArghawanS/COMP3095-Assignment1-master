/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import gbc.comp3095.assignment2.models.Ingredient;
import gbc.comp3095.assignment2.models.Recipe;
import gbc.comp3095.assignment2.models.User;

public interface UserService {
    User findByEmail(String email);
    void save(User user);
    void update(User user);
    void addCart(User user, Ingredient ingredient);
    void deleteCart(User user, Ingredient ingredient);

    void addFavorite(User user, Recipe recipe);
    void deleteFavorite(User user, Recipe recipe);
}
