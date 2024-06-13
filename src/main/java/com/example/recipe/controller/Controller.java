package com.example.recipe.controller;

import com.example.recipe.dto.Base;
import com.example.recipe.dto.Effect;
import com.example.recipe.dto.Ingredient;
import com.example.recipe.dto.Recipe;
import com.example.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final RecipeService recipeService;
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

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


    @GetMapping("/recipe/{id}")
    public String getRecipe(@PathVariable("id")int id, Model model){
        Base base = recipeService.getBase(id);
        List<Effect> effect = recipeService.getEffects(id);
        List<Ingredient> ingredient = recipeService.getIngredients(id);
        List<Recipe> recipe = recipeService.getRecipes(id);

        model.addAttribute("base",base);
        model.addAttribute("effect",effect);
        model.addAttribute("ingredient",ingredient);
        model.addAttribute("recipe",recipe);

        return "page";
    }


        @GetMapping("/search")
        public ResponseEntity<List<Base>> searchBase(@RequestParam(required = false) Integer 항목일련번호, @RequestParam(required = false) String 이름) {

            List<Base> searchResult;
            if (항목일련번호 != null || 이름 != null) {
                searchResult = recipeService.findSearchName(항목일련번호,이름);
            } else {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(searchResult);
        }

        @GetMapping("/category")
        @ResponseBody
        public List<Base> getCategory(@RequestParam("searchQuery") String 검색어) {
            return recipeService.getCategory(검색어);
        }


        @GetMapping("/effect")
        @ResponseBody
        public List<Effect> getEffect(@RequestParam("searchEffect") String 효과) {
            return recipeService.findEffect(효과);
        }
}
