package com.example.recipe.dto;

import lombok.Data;
import lombok.Getter;


@Data
public class Recipe {
    // Getters and Setters
    private int 항목일련번호; //
    private String 카테고리; // 카테고리
    private String 이름; // 이름
    private String 메인이미지; // 메인이미지

}