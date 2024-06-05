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

    @RestController
    @RequestMapping("/api/recipe")
    public static class RecipeDataController {

        @Autowired
        private RecipeService recipeService;

        @GetMapping("/{id}")
        @ResponseBody
        public RecipeData getRecipeData(@PathVariable("id") int id) {
            Base base = recipeService.getBase(id);
            List<Effect> effects = recipeService.getEffects(id);
            List<Ingredient> ingredients = recipeService.getIngredients(id);
            List<Recipe> recipes = recipeService.getRecipes(id);

            return new RecipeData(base, ingredients, effects, recipes);
        }

    }

    public static class RecipeData {
        private Base base;
        private List<Ingredient> ingredients;
        private List<Effect> effects;
        private List<Recipe> recipes;

        public RecipeData(Base base, List<Ingredient> ingredients, List<Effect> effects, List<Recipe> recipes) {
            this.base = base;
            this.ingredients = ingredients;
            this.effects = effects;
            this.recipes = recipes;
        }

        // Getters and setters
        public Base getBase() { return base; }
        public List<Ingredient> getIngredients() { return ingredients; }
        public List<Effect> getEffects() { return effects; }
        public List<Recipe> getRecipes() { return recipes; }
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

    @GetMapping("/category/{category}")

    public List<Base> getCategory(@PathVariable String category) {
        return recipeService.getCategory(category);
    }

}
