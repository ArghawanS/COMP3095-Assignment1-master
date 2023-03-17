/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment1
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.bootstrap;
import gbc.comp3095.assignment2.models.*;
import gbc.comp3095.assignment2.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {
    private UserRepository userRepository;
    private RecipeRepository recipeRepository;
    private MealRepository mealRepository;
    private IngredientRepository ingredientRepository;
    private EventRepository eventRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public BootstrapData(UserRepository userRepository, RecipeRepository recipeRepository, MealRepository mealRepository, IngredientRepository ingredientRepository, EventRepository eventRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
        this.eventRepository = eventRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Ingredient egg = new Ingredient("egg","Brown ones should be better");
        Ingredient rice = new Ingredient("rice","Vietnamese and Thai rice is the best in the world");
        Ingredient milk = new Ingredient("milk", "Any kind of milk is good.");
        Ingredient pasta = new Ingredient("pasta", " pasta is typically  high in fiber.");
        ingredientRepository.save(egg);
        ingredientRepository.save(rice);
        ingredientRepository.save(pasta);
        ingredientRepository.save(milk);

        Set<Ingredient> i = Set.of(egg,rice);
        User argh = new User("arghawan.siddiq@gmail.com", passwordEncoder.encode("1234"),"ArghawanS","Arghawan","Siddiq",i);
        userRepository.save(argh);

        Set<Ingredient> efr = Set.of(egg,rice);
        Set<Ingredient> c = Set.of(egg,milk);
        Recipe cake = new Recipe("cake", argh, "make cake with milk, egg and oil ",c);
        Recipe egg_fried = new Recipe("egg oil ",argh,"make breakfast oil with egg",efr);
        recipeRepository.save(egg_fried);
        recipeRepository.save(cake);




        Set<Recipe> s = Set.of(egg_fried,cake);
        Meal breakfast = new Meal("breakfast", argh, "Simple meal for breakfast",s);
        Meal dinner = new Meal("dinner", argh, "Simple meal for dinner",s);
        mealRepository.save(breakfast);
        mealRepository.save(dinner);

        Event Thanksgiving = new Event("Thanksgiving","Happy Thanksgiving!",argh);
        Event xmas = new Event("xmas","Happy Holiday!",argh);
        eventRepository.save(xmas);
        eventRepository.save(Thanksgiving);
    }
}
