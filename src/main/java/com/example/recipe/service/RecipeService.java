package com.example.recipe.service;

import com.example.recipe.dto.Base;
import com.example.recipe.dto.Effect;
import com.example.recipe.dto.Ingredient;
import com.example.recipe.dto.Recipe;
import com.example.recipe.mapper.RecipeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class RecipeService {


    private final RecipeMapper recipeMapper;


    public List<Base> getAllRecipes() {
        return recipeMapper.findAll();
    }

    public Base getBase(int 항목일련번호){
        return recipeMapper.findBase(항목일련번호);
    }

    public List<Effect> getEffects(int 항목일련번호){
        return recipeMapper.findEffects(항목일련번호);
    }

    public List<Ingredient> getIngredients(int 항목일련번호){
        return recipeMapper.findIngredients(항목일련번호);
    }

    public List<Recipe> getRecipes(int 항목일련번호){
        return recipeMapper.findRecipes(항목일련번호);
    }

    public List<Base> getCategory(String 카테고리){
        return recipeMapper.findCategory(카테고리);
    }

    public List<Base> searchBaseByNumberAndName(Integer 항목일련번호, String 이름) {
        return recipeMapper.findByNumberAndName(항목일련번호, 이름);
    }

}
