/**
 *
 */
package org.hybris.platform.project.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;


/**
 * @author soprasteria
 *
 */
@Component(value = "projectDAO")
public class DefaultProjectDao implements ProjectDAO
{
	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Override
	public Collection<StageRaceModel> findAllStagesRace(final String code);

	{
		final String query = "SELECT {sr.pk} FROM {StageRace as sr}";
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(query);
		final SearchResult<ProjectModel> result = flexibleSearchService.search(fsq);
		return result.getResult();
	}

	@Override
	public Collection<StageRaceModel> findStagesRaceByCode(final String code)
	{
		final String query = "SELECT {sr.pk} FROM {StageRace as ar} WHERE {sr.code} = ?code";
		final Map<String, String> params = new HashMap<>();
		params.put("code", code);
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(query, params);
		final SearchResult<StageRaceModel> result = flexibleSearchService.search(fsq);
		return result.getResult();
	}


	@Override
	public Collection<StageModel> findStageRacesByStages(final String name)
	{
		final String query = "SELECT {s.name} FROM {Stage as s} JOIN StageRace as sr ON {s.pk=rs.StageRace} WHERE {s.name} = ?stage";
		final Map<String, String> params = new HashMap<>();
		params.put("name", name);
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(query, params);
		final SearchResult<StageModel> result = flexibleSearchService.search(fsq);
		return result.getResult();
	}


	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}


}
