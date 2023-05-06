package com.mguib.foodmenu.food;

public record FoodResponseDTO(Long id, String title, String image, Integer price) {

    public FoodResponseDTO(Food food){
        this(food.getId(), food.getImage(), food.getTitle(), food.getPrice());
    }
}
