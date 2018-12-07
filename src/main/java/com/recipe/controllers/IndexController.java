package com.recipe.controllers;

import com.recipe.domain.Category;
import com.recipe.domain.UnitOfMeasure;
import com.recipe.repositories.CategoryRepository;
import com.recipe.repositories.UnitOfMeasureRepository;
import com.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

       public IndexController(RecipeService recipeService) {
           this.recipeService = recipeService;
       }

       @RequestMapping({"", "/", "/index"})
       public String getIndexPage(Model model) {

           model.addAttribute("recipes", recipeService.getRecipes());

           return "index";
       }





}
