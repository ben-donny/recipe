package com.recipe.service;

import com.recipe.domain.Recipe;
import com.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImpTest {

    RecipeServiceImp recipeServiceImp;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeServiceImp = new RecipeServiceImp(recipeRepository);
    }

    @Test
    public void getRecipes() {
       Recipe recipe = new Recipe();
       HashSet recipeData = new HashSet();
       recipeData.add(recipe);

       when(recipeServiceImp.getRecipes()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeServiceImp.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}