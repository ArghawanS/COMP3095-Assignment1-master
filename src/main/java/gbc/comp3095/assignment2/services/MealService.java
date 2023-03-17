/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import gbc.comp3095.assignment2.models.Meal;
import gbc.comp3095.assignment2.models.User;

import java.util.Set;

public interface MealService {
    Meal findByName(String name);
    Meal findByUserEmail(String email);
    Set<Meal> listAll(String keyword);
    void save(Meal meal, User user);
}
