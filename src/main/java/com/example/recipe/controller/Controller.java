package com.example.recipe.controller;

import com.example.recipe.dto.Recipe;
import com.example.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final RecipeService recipeService;
    @GetMapping ("/")
    public String home(){

        return "index";
    }
    @GetMapping ("/page")
    public String page(){

        return "page";
    }
    @GetMapping ("/popup")
    public String popup(){

        return "popup";
    }

    @GetMapping("/recipes")
    @ResponseBody
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
}
