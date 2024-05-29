package com.example.recipe.controller;

import com.example.recipe.dto.Base;
import com.example.recipe.dto.Effect;
import com.example.recipe.dto.Ingredient;
import com.example.recipe.dto.Recipe;
import com.example.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @GetMapping("/recipes")
    @ResponseBody
    public List<Base> getAllRecipes() {
        return recipeService.getAllRecipes();
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
                searchResult = recipeService.searchBaseByNumberAndName(항목일련번호, 이름);
            } else {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(searchResult);
        }
}
