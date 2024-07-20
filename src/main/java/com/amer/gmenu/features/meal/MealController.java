package com.amer.gmenu.features.meal;

import com.amer.gmenu.common.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> getMealById(@PathVariable Long id) {
        Meal meal = mealService.getMealById(id);
        return ResponseEntity.ok(meal);
    }

    @PostMapping
    public ResponseEntity<Meal> createMeal(@RequestBody Meal meal) {
        Meal createdMeal = mealService.createMeal(meal);
        return ResponseEntity.ok(createdMeal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable Long id, @RequestBody Meal meal) {
        Meal updatedMeal = mealService.updateMeal(id, meal);
        return ResponseEntity.ok(updatedMeal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long id) {
        mealService.deleteMeal(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{categoryId}")
    public ApiResponse<List<Meal>> getMealsByCategoryId(@PathVariable Long categoryId) {
        List<Meal> meals = mealService.getMealsByCategoryId(categoryId);
        return new ApiResponse<>(true, "Meals retrieved successfully", meals);
    }
}
