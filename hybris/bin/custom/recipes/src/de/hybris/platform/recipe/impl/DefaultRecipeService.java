package en.hybris.platform.recipes.impl;

import de.hybris.platform.recipe.RecipeService;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.recipes.model.RecipeModel;



public class DefaultRecipeService implements RecipeService
{

	private RecipesDAO recipeDAO;

	/*
	 * @see en.hybris.platform.recipes.RecipeService#getRecipeByCode(java.lang.String)
	 */
	@Override
	public List<RecipeModel> getRecipeByCode(final String id)
	{
		return recipeDAO.findRecipeByCode(id);
	}

	/*
	 * @see en.hybris.platform.recipes.RecipeService#getRecipeByFoodCode(java.lang.String)
	 */
	@Override
	public List<RecipeModel> getRecipeByFoodCode(final String id)
	{

		final List<RecipeModel> result = recipeDAO.findRecipeByFoodCode(id);
		if (result.isEmpty())
		{
			throw new UnknownIdentifierException("Recipe with code '" + id + "' not found!");
		}

		return result;
	}

	/*
	 * @see en.hybris.platform.recipes.RecipeService#getRecipeByFoodCodeAndServings(java.lang.String, java.lang.String)
	 */
	@Override
	public List<RecipeModel> getRecipeByFoodServings(final String id, final int servings)
	{
		final List<RecipeModel> result = recipeDAO.findRecipeByFoodCodeAndServings(id, servings);
		if (result.isEmpty())
		{
			throw new UnknownIdentifierException("Recipe with code '" + id + "' not found!");
		}

		return result;
	}

	@Required
	public void setRecipesDAO(final RecipesDAO recipeDAO)
	{
		this.recipeDAO = recipeDAO;
	}

}
