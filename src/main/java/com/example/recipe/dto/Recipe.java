package com.example.recipe.dto;

import lombok.Data;
//조리법
@Data
public class Recipe {

        private int 항목일련번호;
        private int 조리순서;
        private String 조리법;

}
