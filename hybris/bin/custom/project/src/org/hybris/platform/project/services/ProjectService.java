/**
 *
 */
package org.hybris.platform.project.services;

import java.util.Collection;


public interface ProjectService
{

	Collection<StageRaceModel> getAllStages;

	Collection<StageRaceModel> getStagesRaceForCode(String code);

	Collection<StageRaceModel> getStageRecesForStages(String name);

}
