package com.example.recipe.mapper;

import com.example.recipe.dto.Base;
import com.example.recipe.dto.Effect;
import com.example.recipe.dto.Ingredient;
import com.example.recipe.dto.Recipe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecipeMapper {


    Base findBase(int 항목일련번호);
    List<Effect> findEffects(int 항목일련번호);
    List<Ingredient> findIngredients(int 항목일련번호);
    List<Recipe> findRecipes(int 항목일련번호);
    List<Base> findSearchName(@Param("항목일련번호") Integer 항목일련번호,@Param("이름") String 이름);
    List<Base> findCategory(@Param("검색어") String 검색어);

    List<Effect> findEffect(@Param("효과") String 효과);

}
