package com.example.recipe.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

//베이스

@Data
public class Base {

    private int 항목일련번호; //
    private String 카테고리; // 카테고리
    private String 이름; // 이름
    private String 메인이미지; // 메인이미지
    private String 검색어;

}