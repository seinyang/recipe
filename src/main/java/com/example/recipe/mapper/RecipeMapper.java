package com.example.recipe.mapper;

import com.example.recipe.dto.Base;
import com.example.recipe.dto.Effect;
import com.example.recipe.dto.Ingredient;
import com.example.recipe.dto.Recipe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecipeMapper {

    List<Base> findAll();
    Base findBase(int 항목일련번호);
    List<Effect> findEffects(int 항목일련번호);
    List<Ingredient> findIngredients(int 항목일련번호);
    List<Recipe> findRecipes(int 항목일련번호);

    List<Base> findByNumberAndName(@Param("항목일련번호") Integer 항목일련번호, @Param("이름") String 이름);
}
