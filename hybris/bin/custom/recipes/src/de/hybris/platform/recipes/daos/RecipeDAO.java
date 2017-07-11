package de.hybris.platform.recipes.daos;

import java.util.List;

import en.hybris.platform.recipes.model.RecipeModel;


public interface RecipeDAO
{

	List<RecipeModel> findRecipeByCode(String id);

	List<RecipeModel> findRecipesByFoodCode(String id);

	List<RecipeModel> findRecipeByFoodServings(String id, Integer servings);

}