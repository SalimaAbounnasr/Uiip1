package org.hybris.platform.project.interceptors;

import de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

import java.util.Calendar.*;


public class ProjectInitDefaultInterceptor implements InitDefaultsInterceptor<ProjectModel>
{

	@Override
	public void onInitDefaults(final StageModel stageModel, final InterceptorContext ctx) throws InterceptorException
	{

		final GregorianCalendar gc = new GregorianCalendar();
		final int year = gc.get(Calendar.YEAR);
		final int month = gc.get(Calendar.MONTH);
		final int day = gc.get(Calendar.DATE) -1;

		stageModel.setDate(day+"/"+month+"/"+year);
}

