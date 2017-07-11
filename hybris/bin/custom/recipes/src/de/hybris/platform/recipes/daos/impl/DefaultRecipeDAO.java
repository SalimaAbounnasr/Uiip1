package de.hybris.platform.recipes.daos.impl;

import de.hybris.platform.recipes.daos.RecipeDAO;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import en.hybris.platform.recipes.model.FoodModel;
import en.hybris.platform.recipes.model.RecipeModel;


@Component(value = "stadiumDAO")
public class DefaultRecipeDAO implements RecipeDAO
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Override
	public List<RecipeModel> findRecipeByCode(final String id)
	{

		final String queryString = //
				"SELECT {r:" + RecipeModel.PK + "}" //
						+ "FROM {" + RecipeModel._TYPECODE + " AS r} "//
						+ "WHERE " + "{r:" + RecipeModel.CODERECIPE + "}=?id ";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("id", id);

		return flexibleSearchService.<RecipeModel> search(query).getResult();
	}


	@Override
	public List<RecipeModel> findRecipesByFoodCode(final String id)
	{

		/*
		 * Select r.name FROM Recipe as r JOIN RecipeEntry as re ON {r.pk}={re.recipe} JOIN Food as f ON re.food=f.PK
		 */
		/* where f.code=code; */


		final String queryString = "SELECT {r:" + RecipeModel.PK + "} " + "FROM {" //
				+ RecipeModel._TYPECODE + " AS r JOIN " + RecipeEntryModel._TYPECODE + //
				" AS re ON r:" + RecipeModel.PK + " = re:" + RecipeEntryModel.RECIPE //
				+ "JOIN " + FoodModel._TYPECODE + " AS f ON re:" + RecipeEntryModel.FOOD + "= f:" + FoodModel.PK //
				+ "} WHERE f:" + FoodModel.CODEFOOD + " = " + id;

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<RecipeModel> search(query).getResult();

	}


	@Override
	public List<RecipeModel> findRecipeByFoodServings(final String id, final Integer servings)
	{

		/* Select r.name FROM Recipe as r JOIN Food as f ON {r.pk}={f.recipe} */
		/* where {f.id} like=?id && {r.servings} like =?servings */

		final String queryString = "SELECT {r:" + RecipeModel.PK + "} " + "FROM {" //
				+ RecipeModel._TYPECODE + " AS r JOIN " + RecipeEntryModel._TYPECODE + //
				" AS re ON r:" + RecipeModel.PK + " = re:" + RecipeEntryModel.RECIPE //
				+ "JOIN " + FoodModel._TYPECODE + " AS f ON re:" + RecipeEntryModel.FOOD + "= f:" + FoodModel.PK //
				+ "} WHERE f:" + FoodModel.CODEFOOD + " = " + id + " AND r:" + RecipeModel.SERVINGS + "=" + servings;

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<RecipeModel> search(query).getResult();

	}

}