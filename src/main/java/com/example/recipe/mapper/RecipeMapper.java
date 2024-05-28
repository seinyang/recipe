package com.example.recipe.mapper;

import com.example.recipe.dto.Recipe;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecipeMapper {

    //@Select("select * from 조리법")
    List<Recipe> findAll();


}
