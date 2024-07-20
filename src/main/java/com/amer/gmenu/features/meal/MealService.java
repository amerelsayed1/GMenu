package com.amer.gmenu.features.meal;

import java.util.List;

public interface MealService {
    List<Meal> getAllMeals();
    Meal getMealById(Long id);
    Meal createMeal(Meal meal);
    Meal updateMeal(Long id, Meal meal);
    void deleteMeal(Long id);
    List<Meal> getMealsByCategoryId(Long categoryId);
}
