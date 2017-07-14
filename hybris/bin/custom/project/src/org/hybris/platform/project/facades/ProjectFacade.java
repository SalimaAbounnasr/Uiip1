/**
 *
 */
package org.hybris.platform.project.facades;


import java.util.List;

import org.hybris.platform.project.data.ProjectData;


public interface ProjectFacade
{

	ProjectData getAllStages(String code);

	List<ProjectData> getStagesRaceForCode(String code);

	List<ProjectData> getStageRecesForStages(String name);
}
