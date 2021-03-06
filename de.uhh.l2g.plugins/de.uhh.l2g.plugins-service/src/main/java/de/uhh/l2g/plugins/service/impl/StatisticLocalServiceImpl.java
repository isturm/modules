/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.exception.StatisticDateException;
import de.uhh.l2g.plugins.exception.StatisticValueException;
import de.uhh.l2g.plugins.model.Statistic;
import de.uhh.l2g.plugins.model.impl.StatisticImpl;
import de.uhh.l2g.plugins.service.StatisticLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.StatisticLocalServiceBaseImpl;

/**
 * The implementation of the daily satitistics record table
 * 
 * Combining records by time intervals is done in views, modeled by its own Entity like below
 * https://www.liferay.com/de/community/wiki/-/wiki/Main/Working+with+Database+Views+in+Liferay
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.StatisticLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.StatisticLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.StatisticLocalServiceUtil
 */
@SuppressWarnings("unused")
public class StatisticLocalServiceImpl
	extends StatisticLocalServiceBaseImpl {

	 protected static Log LOG = LogFactoryUtil.getLog(Statistic.class.getName());	
	/*
	 * NOTE FOR DEVELOPERS:
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.StatisticLocalServiceUtil} to access the institution_ host local service.
	 */

	public JSONObject getAllStatistics() throws SystemException {
			//generate view, if not existing
			statisticFinder.createVideoStatisticView();
			//
			return statisticFinder.findAllStatistics();
	}
		
	public List<Statistic> getByCompanyIdandGroupId(long companyId, long groupId) throws SystemException, PortalException {
		List<Statistic> institution_host = statisticPersistence.findByGroupAndCompany(groupId, companyId);
		return institution_host; 
	}

	public Statistic getByStatisticId(long statisticId) throws SystemException, PortalException {
			Statistic statistic = statisticPersistence.findByStatisticId(statisticId);
			return statistic;
	}
	
	public Statistic getByStatisticId(long companyId, long groupId, long statisticId) throws SystemException, PortalException {
		Statistic statistic = statisticPersistence.findByStatisticId(statisticId);
		
		return statistic;
	}

	/** Drop table via custom query
	 * https://web.liferay.com/de/community/wiki/-/wiki/Main/Working+with+Database+Views+in+Liferay
	 */
	public boolean removeVideoStatisticDefaultTable(){
		statisticFinder.removeVideoStatisticTable();
		return true;	
	}
	
	/**
	 * Add Database View with same Name
	 */
	public boolean addVideoStatisticView(){
		statisticFinder.createVideoStatisticView();
		return true;
	
	}

	protected void validate(long privateVideos, long publicVideos, Date date) throws PortalException {

		if (Validator.isNull(privateVideos) || Validator.isNull(publicVideos)) {
	       throw new StatisticValueException();
		 }

	     if (Validator.isNull(date)) {
	       throw new StatisticDateException();
	     }

	}
	
	public Statistic addDefaultEntry(ServiceContext serviceContext) throws SystemException, PortalException{

		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date(0);

		validate(0, 0, now);

		long statisticId = counterLocalService.increment(Statistic.class.getName());

		Statistic statistic = statisticPersistence.create(statisticId);

		//Anonymous values for debug/consitency check: Stats should be added by System only
		statistic.setUserId(userId);
		statistic.setUserName(UserLocalServiceUtil.getUser(userId).getLogin());
		statistic.setCreateDate(serviceContext.getCreateDate(now));
		statistic.setModifiedDate(serviceContext.getModifiedDate(now));
		
		
		statistic.setGroupId(groupId);
		statistic.setCompanyId(companyId);
		statistic.setPrivateVideos(0);
		statistic.setPublicVideos(0);

		statistic.setExpandoBridgeAttributes(serviceContext);
		
		statisticPersistence.update(statistic);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Statistic.class.getName(), statisticId, false, true, true);


		return statistic;
		
	}

	public Statistic addEntry(int privateVideos, int publicVideos, ServiceContext serviceContext) throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();

		validate(privateVideos, publicVideos, now);

		long statisticId = counterLocalService.increment(Statistic.class.getName());

		Statistic statistic = statisticPersistence.create(statisticId);

		//Anonymous values for debug/consitency check: Stats should be added by System only
		statistic.setUserId(userId);
		statistic.setUserName(UserLocalServiceUtil.getUser(userId).getLogin());
		statistic.setCreateDate(serviceContext.getCreateDate(now));
		statistic.setModifiedDate(serviceContext.getModifiedDate(now));
		
		
		statistic.setGroupId(groupId);
		statistic.setCompanyId(companyId);
		statistic.setPrivateVideos(privateVideos);
		statistic.setPublicVideos(publicVideos);

		statistic.setExpandoBridgeAttributes(serviceContext);
		
		statisticPersistence.update(statistic);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Statistic.class.getName(), statisticId, false, true, true);


		return statistic;

	}

	public Statistic add(int privateVideos, int publicVideos) throws SystemException, PortalException {
		Date now = new Date();
		Statistic statistic = new StatisticImpl();

		statistic.setCreateDate(now);
		statistic.setModifiedDate(now);
		
		statistic.setPrivateVideos(privateVideos);
		statistic.setPublicVideos(publicVideos);
		
		StatisticLocalServiceUtil.addStatistic(statistic);
		return statistic;
	}

	public Statistic updateEntry(long statisticId, int privateVideos, int publicVideos, ServiceContext serviceContext) throws SystemException, PortalException {

		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);
		LOG.info("Input: " +privateVideos +" "+publicVideos);
		Date now = new Date();

		validate(privateVideos, publicVideos, now);


		Statistic statistic = getByStatisticId(companyId, groupId, statisticId);
		//System.out.println ("Link Contents: "+ statistic.toString());

		statistic.setGroupId(groupId);
		statistic.setPrivateVideos(privateVideos);
		statistic.setPublicVideos(publicVideos);
		
		statistic.setModifiedDate(serviceContext.getModifiedDate(now));

		statistic.setExpandoBridgeAttributes(serviceContext);

		statisticPersistence.update(statistic);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Statistic.class.getName(), statisticId, false, true, true);


		return statistic;

	}


	   public Statistic deleteLinkById(long statisticId, ServiceContext serviceContext)
		        throws PortalException, SystemException {
		   		Statistic statistic = null;

		   		long groupId = serviceContext.getScopeGroupId();
		   		long userId = serviceContext.getUserId();

				statistic = deleteStatistic(statisticId);

				statistic.setExpandoBridgeAttributes(serviceContext);
				resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				        		Statistic.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				        		statisticId);

		        return statistic;

		    }
	   

//	   public long updateCounter() throws SystemException, PortalException {
//	        //current counter
//	        Counter counter = CounterLocalServiceUtil.getCounter(Statistic.class.getName());
//	        LOG.debug(counter.getCurrentId());
//  			//check Host Count (if 1 it is supposed to be default statistic)
//	        int count = HostLocalServiceUtil.getHostsCount();
//	        LOG.debug(count); 
//	        long newHostId = 0; //Reset if table is empty
//	        long statisticId = 0;   //the actual Id value
//	        
//	        if (count > 0){ //our db is filled... with something at least
//	        	
//				//Retrieve actual table data
//				ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");    		
//				DynamicQuery query = DynamicQueryFactoryUtil.forClass(Statistic.class,classLoader).addOrder(OrderFactoryUtil.desc("statisticId"));
//				query.setLimit(0,1);
//				List<Statistic> statistics = StatisticLocalServiceUtil.dynamicQuery(query);
//				if (statistics.size() > 0) statisticId = statistics.get(0).getStatisticId(); //current maximum Id
//			
//	        }
//
//	        LOG.debug(statisticId);
//			//Increment Counter if assynchrone with estimated value or data reseted
//			if (counter.getCurrentId() <  statisticId || statisticId == 0){
//				counter.setCurrentId(statisticId);
//				CounterLocalServiceUtil.updateCounter(counter);
//			}			
//			return counter.getCurrentId();
//	   	}  	   

}
