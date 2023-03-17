/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */

package gbc.comp3095.assignment2.repositories;

import gbc.comp3095.assignment2.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Set;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByName(String name);

    @Query("SELECT r FROM Ingredient r WHERE r.name LIKE %?1%"
            + " OR r.description LIKE %?1%")
    public Set<Ingredient> search(String keyword);

    @Modifying
    @Transactional
    @Query("DELETE FROM Ingredient i WHERE i.id = :id")
    public void deleteIngredientById(Long id);
}
