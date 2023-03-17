/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.repositories;

import gbc.comp3095.assignment2.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Meal findByName(String name);
    Meal findByUserEmail(String email);

    @Query("SELECT r FROM Meal r WHERE r.user.userName LIKE %?1%")
    public Set<Meal> findByUsername(String userName);

    @Query("SELECT r FROM Meal r WHERE r.name LIKE %?1%"
            + " OR r.description LIKE %?1%"
            + " OR r.user.userName LIKE %?1%")
    public Set<Meal> search(String keyword);
}
