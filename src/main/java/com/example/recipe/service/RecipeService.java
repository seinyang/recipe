package com.example.recipe.service;

import com.example.recipe.dto.Recipe;
import com.example.recipe.mapper.RecipeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RecipeService {

    @Autowired
    private RecipeMapper recipeMapper;


    public List<Recipe> getAllRecipes() {
        return recipeMapper.findAll();
    }
}
