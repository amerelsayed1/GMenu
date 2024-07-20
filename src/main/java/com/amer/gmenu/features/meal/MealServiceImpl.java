package com.amer.gmenu.features.meal;

import com.amer.gmenu.common.exception.ResourceNotFoundException;
import com.amer.gmenu.features.category.Category;
import com.amer.gmenu.features.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @Override
    public Meal getMealById(Long id) {
        return mealRepository.findById(id).orElseThrow(() -> new RuntimeException("Meal not found"));
    }

    @Override
    public Meal createMeal(Meal meal) {
        Long categoryId = meal.getCategory().getId();
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
        meal.setCategory(category);
        return mealRepository.save(meal);
    }

    @Override
    public Meal updateMeal(Long id, Meal meal) {
        Meal existingMeal = getMealById(id);
        Long categoryId = meal.getCategory().getId();
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
        existingMeal.setName(meal.getName());
        existingMeal.setDescription(meal.getDescription());
        existingMeal.setPrice(meal.getPrice());
        existingMeal.setCategory(category);
        return mealRepository.save(existingMeal);
    }

    @Override
    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }

    @Override
    public List<Meal> getMealsByCategoryId(Long categoryId) {
        return mealRepository.findByCategoryId(categoryId);
    }

}
