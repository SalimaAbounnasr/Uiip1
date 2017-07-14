/**
 *
 */
package org.hybris.platform.project.facades.impl;


import de.hybris.platform.converters.impl.AbstractPopulatingConverter;

import java.util.List;

import org.hybris.platform.project.data.ProjectData;
import org.hybris.platform.project.facades.ProjectFacade;
import org.hybris.platform.project.services.ProjectService;
import org.springframework.beans.factory.annotation.Required;



public class DefaultProjectFacade implements ProjectFacade
{

	private ProjectService projectService;
	private AbstractPopulatingConverter<ProjectModel, ProjectData> projectConverter;


	@Override
	public ProjectData getAllStages(final String code)
	{
		final ProjectModel projectModel = projectService.getProjectForCode(code);
		final ProjectData toReturn = projectConverter.convert(projectModel);
		return toReturn;
	}



	@Override
	public List<ProjectData> getStagesRaceForCode(final String code)
	{

		return null;
	}


	@Override
	public List<ProjectData> getStageRecesForStages(final String name)
	{

		return null;
	}

	@Required
	public void setProjectConverter(final AbstractPopulatingConverter<ProjectModel, ProjectData> projectConverter)
	{
		this.projectConverter = projectConverter;
	}


	@Required
	public void setProjectService(final ProjectService projectService)
	{
		this.projectService = projectService;
	}


}
