/**
 *
 */
package org.hybris.platform.project.daos;

import java.util.Collection;


/**
 * @author soprasteria
 *
 */
public interface ProjectDao
{

	Collection<StageRaceModel> findAllStagesRace;

	Collection<StageRaceModel> findStagesRaceByCode(String code);

	Collection<StageRaceModel> findStageRacesByStages(String name);

}
