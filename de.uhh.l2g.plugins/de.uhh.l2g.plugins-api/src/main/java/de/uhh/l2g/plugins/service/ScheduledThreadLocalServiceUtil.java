/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package de.uhh.l2g.plugins.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ScheduledThread. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.ScheduledThreadLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see ScheduledThreadLocalService
 * @see de.uhh.l2g.plugins.service.base.ScheduledThreadLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.ScheduledThreadLocalServiceImpl
 * @generated
 */
@ProviderType
public class ScheduledThreadLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.ScheduledThreadLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the scheduled thread to the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThread the scheduled thread
	* @return the scheduled thread that was added
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread addScheduledThread(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread) {
		return getService().addScheduledThread(scheduledThread);
	}

	public static de.uhh.l2g.plugins.model.ScheduledThread addScheduledThread(
		java.lang.String schedulerClassName, java.lang.String cronText,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addScheduledThread(schedulerClassName, cronText,
			serviceContext);
	}

	/**
	* Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	*
	* @param scheduledThreadId the primary key for the new scheduled thread
	* @return the new scheduled thread
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread createScheduledThread(
		long scheduledThreadId) {
		return getService().createScheduledThread(scheduledThreadId);
	}

	/**
	* Deletes the scheduled thread from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThread the scheduled thread
	* @return the scheduled thread that was removed
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread deleteScheduledThread(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread) {
		return getService().deleteScheduledThread(scheduledThread);
	}

	/**
	* Deletes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread that was removed
	* @throws PortalException if a scheduled thread with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread deleteScheduledThread(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteScheduledThread(scheduledThreadId);
	}

	public static de.uhh.l2g.plugins.model.ScheduledThread fetchScheduledThread(
		long scheduledThreadId) {
		return getService().fetchScheduledThread(scheduledThreadId);
	}

	/**
	* Returns the scheduled thread with the primary key.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread
	* @throws PortalException if a scheduled thread with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread getScheduledThread(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getScheduledThread(scheduledThreadId);
	}

	/**
	* Updates the scheduled thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scheduledThread the scheduled thread
	* @return the scheduled thread that was updated
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread updateScheduledThread(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread) {
		return getService().updateScheduledThread(scheduledThread);
	}

	public static de.uhh.l2g.plugins.model.ScheduledThread updateScheduledThread(
		java.lang.String schedulerClassName, java.lang.String cronText,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateScheduledThread(schedulerClassName, cronText,
			serviceContext);
	}

	/**
	* Returns the number of scheduled threads.
	*
	* @return the number of scheduled threads
	*/
	public static int getScheduledThreadsCount() {
		return getService().getScheduledThreadsCount();
	}

	public static java.lang.String getCronBySchedulerName(
		java.lang.String schedulerClassName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCronBySchedulerName(schedulerClassName);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the scheduled threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scheduled threads
	* @param end the upper bound of the range of scheduled threads (not inclusive)
	* @return the range of scheduled threads
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ScheduledThread> getScheduledThreads(
		int start, int end) {
		return getService().getScheduledThreads(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ScheduledThreadLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ScheduledThreadLocalService, ScheduledThreadLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ScheduledThreadLocalService.class);
}