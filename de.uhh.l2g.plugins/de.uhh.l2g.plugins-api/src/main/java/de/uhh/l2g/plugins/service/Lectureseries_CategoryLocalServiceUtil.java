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
 * Provides the local service utility for Lectureseries_Category. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.Lectureseries_CategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryLocalService
 * @see de.uhh.l2g.plugins.service.base.Lectureseries_CategoryLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.Lectureseries_CategoryLocalServiceImpl
 * @generated
 */
@ProviderType
public class Lectureseries_CategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.Lectureseries_CategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the lectureseries_ category to the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Category the lectureseries_ category
	* @return the lectureseries_ category that was added
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category addLectureseries_Category(
		de.uhh.l2g.plugins.model.Lectureseries_Category lectureseries_Category) {
		return getService().addLectureseries_Category(lectureseries_Category);
	}

	/**
	* Creates a new lectureseries_ category with the primary key. Does not add the lectureseries_ category to the database.
	*
	* @param lectureseriesCategoryId the primary key for the new lectureseries_ category
	* @return the new lectureseries_ category
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category createLectureseries_Category(
		long lectureseriesCategoryId) {
		return getService().createLectureseries_Category(lectureseriesCategoryId);
	}

	/**
	* Deletes the lectureseries_ category from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Category the lectureseries_ category
	* @return the lectureseries_ category that was removed
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category deleteLectureseries_Category(
		de.uhh.l2g.plugins.model.Lectureseries_Category lectureseries_Category) {
		return getService().deleteLectureseries_Category(lectureseries_Category);
	}

	/**
	* Deletes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category that was removed
	* @throws PortalException if a lectureseries_ category with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category deleteLectureseries_Category(
		long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLectureseries_Category(lectureseriesCategoryId);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries_Category fetchLectureseries_Category(
		long lectureseriesCategoryId) {
		return getService().fetchLectureseries_Category(lectureseriesCategoryId);
	}

	/**
	* Returns the lectureseries_ category with the primary key.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category
	* @throws PortalException if a lectureseries_ category with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category getLectureseries_Category(
		long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLectureseries_Category(lectureseriesCategoryId);
	}

	/**
	* Updates the lectureseries_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Category the lectureseries_ category
	* @return the lectureseries_ category that was updated
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category updateLectureseries_Category(
		de.uhh.l2g.plugins.model.Lectureseries_Category lectureseries_Category) {
		return getService().updateLectureseries_Category(lectureseries_Category);
	}

	/**
	* Returns the number of lectureseries_ categories.
	*
	* @return the number of lectureseries_ categories
	*/
	public static int getLectureseries_CategoriesCount() {
		return getService().getLectureseries_CategoriesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the lectureseries_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @return the range of lectureseries_ categories
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> getLectureseries_Categories(
		int start, int end) {
		return getService().getLectureseries_Categories(start, end);
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

	public static Lectureseries_CategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Lectureseries_CategoryLocalService, Lectureseries_CategoryLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Lectureseries_CategoryLocalService.class);
}