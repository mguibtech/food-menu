package com.mguib.foodmenu.controller;

import com.mguib.foodmenu.food.Food;
import com.mguib.foodmenu.food.FoodRepository;
import com.mguib.foodmenu.food.FoodRequestDTO;
import com.mguib.foodmenu.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        foodRepository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;

    }
}
