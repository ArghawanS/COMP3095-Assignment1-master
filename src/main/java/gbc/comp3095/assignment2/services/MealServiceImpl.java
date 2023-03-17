/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import gbc.comp3095.assignment2.models.Meal;
import gbc.comp3095.assignment2.models.User;
import gbc.comp3095.assignment2.repositories.MealRepository;
import gbc.comp3095.assignment2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MealServiceImpl implements MealService {
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private UserRepository userRepository;

    public void save(Meal meal, User user) {
        meal.setUser(user);
        mealRepository.save(meal);
    }

    public Set<Meal> listAll(String keyword) {
        if (keyword != null) {
            return mealRepository.search(keyword);
        }
        Set<Meal> r = new HashSet<>(mealRepository.findAll());
        return r;
    }

    @Override
    public Meal findByName(String name) {
        return mealRepository.findByName(name);
    }
    @Override
    public Meal findByUserEmail(String email) { return mealRepository.findByUserEmail(email); }
}
