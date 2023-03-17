/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.repositories;

import gbc.comp3095.assignment2.models.Ingredient;
import gbc.comp3095.assignment2.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Set;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByName(String name);

    @Query("SELECT r FROM Recipe r WHERE r.user.userName LIKE %?1%")
    public Set<Recipe> findByUsername(String userName);

    @Query("SELECT r FROM Recipe r WHERE r.name LIKE %?1%"
            + " OR r.description LIKE %?1%"
            + " OR r.user.userName LIKE %?1%")
    public Set<Recipe> search(String keyword);

    @Modifying
    @Transactional
    @Query("UPDATE Recipe r SET r.name = :name, r.description = :description, r.ingredients = :ingredients WHERE r.id = :id")
    public void editRecipe(Long id, String name, String description, Set<Ingredient> ingredients);
}
