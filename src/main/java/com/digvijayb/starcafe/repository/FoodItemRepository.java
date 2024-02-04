package com.digvijayb.starcafe.repository;

import com.digvijayb.starcafe.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    <T> Collection<T> findByFoodType(String foodType, Class<T> tClass);
}
