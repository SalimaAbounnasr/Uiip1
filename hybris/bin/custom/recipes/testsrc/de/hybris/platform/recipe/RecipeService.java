/**
 *
 */
package de.hybris.platform.recipe;

import java.util.List;

import en.hybris.platform.recipes.model.RecipeModel;


public interface RecipeService
{

	List<RecipeModel> getRecipeByCode();

	List<RecipeModel> getRecipeByFoodId();

	List<RecipeModel> getRecipeByFoodServings();



}