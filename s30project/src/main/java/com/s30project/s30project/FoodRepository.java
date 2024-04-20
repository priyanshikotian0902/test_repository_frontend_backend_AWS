package com.s30project.s30project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {
    List<Food> findByFoodContainingIgnoreCase(String food);
    // You can add more custom query methods here if needed
}
