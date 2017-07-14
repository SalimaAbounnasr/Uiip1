/**
 *
 */
package org.hybris.platform.project.services.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.Collection;

import org.hybris.platform.project.daos.ProjectDao;
import org.hybris.platform.project.services.ProjectService;
import org.springframework.beans.factory.annotation.Required;


/**
 * @author soprasteria
 *
 */
public class DefaultProjectService implements ProjectService
{
	private ProjectDao projectDao;


	@Override
	public ProjectModel getAllStages(final String code)
	{
		final Collection<RecipeModel> result = recipeDao.findRecipeByCode(code);
		if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException("message");
		}
		else if (result.isEmpty())
		{
			throw new UnknownIdentifierException("message");
		}
		return result.iterator().next();
	}


	@Override
	public Collection<StageRaceModel> getStagesRaceForCode(final String code)
	{
		final Collection<ProjectModel> result = projectDao.findStageRaceByCode(code);
		if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException("message");
		}
		else if (result.isEmpty())
		{
			throw new UnknownIdentifierException("message");
		}
		return result.iterator().next();
	}

	@Override
	public Collection<StageRaceModel> getStageRecesForStages(final String code)
	{
		final Collection<ProjectModel> result = projectDao.findStageRacesByStages(code);
		return result;
	}



	@Required
	public void setProjectDao(final ProjectDao projectDao)
	{
		this.projectDao = projectDao;
	}
}