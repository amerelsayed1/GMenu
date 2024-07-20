package com.amer.gmenu.features.meal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByCategoryId(Long categoryId);
}
