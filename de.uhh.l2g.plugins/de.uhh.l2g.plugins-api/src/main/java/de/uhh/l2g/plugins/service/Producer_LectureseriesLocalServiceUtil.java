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
 * Provides the local service utility for Producer_Lectureseries. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.Producer_LectureseriesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Producer_LectureseriesLocalService
 * @see de.uhh.l2g.plugins.service.base.Producer_LectureseriesLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.Producer_LectureseriesLocalServiceImpl
 * @generated
 */
@ProviderType
public class Producer_LectureseriesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.Producer_LectureseriesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the producer_ lectureseries to the database. Also notifies the appropriate model listeners.
	*
	* @param producer_Lectureseries the producer_ lectureseries
	* @return the producer_ lectureseries that was added
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries addProducer_Lectureseries(
		de.uhh.l2g.plugins.model.Producer_Lectureseries producer_Lectureseries) {
		return getService().addProducer_Lectureseries(producer_Lectureseries);
	}

	/**
	* Creates a new producer_ lectureseries with the primary key. Does not add the producer_ lectureseries to the database.
	*
	* @param producerLectureseriesId the primary key for the new producer_ lectureseries
	* @return the new producer_ lectureseries
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries createProducer_Lectureseries(
		long producerLectureseriesId) {
		return getService().createProducer_Lectureseries(producerLectureseriesId);
	}

	/**
	* Deletes the producer_ lectureseries from the database. Also notifies the appropriate model listeners.
	*
	* @param producer_Lectureseries the producer_ lectureseries
	* @return the producer_ lectureseries that was removed
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries deleteProducer_Lectureseries(
		de.uhh.l2g.plugins.model.Producer_Lectureseries producer_Lectureseries) {
		return getService().deleteProducer_Lectureseries(producer_Lectureseries);
	}

	/**
	* Deletes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param producerLectureseriesId the primary key of the producer_ lectureseries
	* @return the producer_ lectureseries that was removed
	* @throws PortalException if a producer_ lectureseries with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries deleteProducer_Lectureseries(
		long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteProducer_Lectureseries(producerLectureseriesId);
	}

	public static de.uhh.l2g.plugins.model.Producer_Lectureseries fetchProducer_Lectureseries(
		long producerLectureseriesId) {
		return getService().fetchProducer_Lectureseries(producerLectureseriesId);
	}

	/**
	* Returns the producer_ lectureseries with the primary key.
	*
	* @param producerLectureseriesId the primary key of the producer_ lectureseries
	* @return the producer_ lectureseries
	* @throws PortalException if a producer_ lectureseries with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries getProducer_Lectureseries(
		long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProducer_Lectureseries(producerLectureseriesId);
	}

	/**
	* Updates the producer_ lectureseries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param producer_Lectureseries the producer_ lectureseries
	* @return the producer_ lectureseries that was updated
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries updateProducer_Lectureseries(
		de.uhh.l2g.plugins.model.Producer_Lectureseries producer_Lectureseries) {
		return getService().updateProducer_Lectureseries(producer_Lectureseries);
	}

	/**
	* Returns the number of producer_ lectureserieses.
	*
	* @return the number of producer_ lectureserieses
	*/
	public static int getProducer_LectureseriesesCount() {
		return getService().getProducer_LectureseriesesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the producer_ lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of producer_ lectureserieses
	* @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	* @return the range of producer_ lectureserieses
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> getProducer_Lectureserieses(
		int start, int end) {
		return getService().getProducer_Lectureserieses(start, end);
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

	public static Producer_LectureseriesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Producer_LectureseriesLocalService, Producer_LectureseriesLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Producer_LectureseriesLocalService.class);
}