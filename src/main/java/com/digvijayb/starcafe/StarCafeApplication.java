package com.digvijayb.starcafe;

import com.digvijayb.starcafe.model.FoodItem;
import com.digvijayb.starcafe.records.MenuItem;
import com.digvijayb.starcafe.repository.FoodItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class StarCafeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarCafeApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final FoodItemRepository foodItemRepository) {

        return args -> {

            var matarPaneer = new FoodItem(null, "VEG", "India Curry", "Matar Paneer", "Cottage Chesse and Green Peas in masala curry", 200F, 4);
            var kadhiPaneer = new FoodItem(null, "VEG", "India Curry", "Kadhi Paneer", "Cottage Chesse in masala curry", 220F, 3);
            var butterChicken = new FoodItem(null, "NON-VEG", "India Curry", "Butter Chicken", "Tandoori Chicken with tomato and butter curry", 250F, 5);


            var foodItems = foodItemRepository.saveAll(List.of(matarPaneer, kadhiPaneer, butterChicken));

            Collection<MenuItem> nonVegItems = foodItemRepository.findByFoodType("NON-VEG", MenuItem.class);
            Collection<MenuItem> vegItems = foodItemRepository.findByFoodType("VEG", MenuItem.class);

            System.out.println("nonVegItems = " + nonVegItems);
            System.out.println("vegItems = " + vegItems);


        };

    }

}
