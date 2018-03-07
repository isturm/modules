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
 * Provides the local service utility for Category. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.CategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see CategoryLocalService
 * @see de.uhh.l2g.plugins.service.base.CategoryLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.CategoryLocalServiceImpl
 * @generated
 */
@ProviderType
public class CategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.CategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the category to the database. Also notifies the appropriate model listeners.
	*
	* @param category the category
	* @return the category that was added
	*/
	public static de.uhh.l2g.plugins.model.Category addCategory(
		de.uhh.l2g.plugins.model.Category category) {
		return getService().addCategory(category);
	}

	/**
	* Creates a new category with the primary key. Does not add the category to the database.
	*
	* @param categoryId the primary key for the new category
	* @return the new category
	*/
	public static de.uhh.l2g.plugins.model.Category createCategory(
		long categoryId) {
		return getService().createCategory(categoryId);
	}

	/**
	* Deletes the category from the database. Also notifies the appropriate model listeners.
	*
	* @param category the category
	* @return the category that was removed
	*/
	public static de.uhh.l2g.plugins.model.Category deleteCategory(
		de.uhh.l2g.plugins.model.Category category) {
		return getService().deleteCategory(category);
	}

	/**
	* Deletes the category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category
	* @return the category that was removed
	* @throws PortalException if a category with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Category deleteCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCategory(categoryId);
	}

	public static de.uhh.l2g.plugins.model.Category fetchCategory(
		long categoryId) {
		return getService().fetchCategory(categoryId);
	}

	public static de.uhh.l2g.plugins.model.Category getById(
		java.lang.Long categoryId)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getById(categoryId);
	}

	/**
	* Returns the category with the primary key.
	*
	* @param categoryId the primary key of the category
	* @return the category
	* @throws PortalException if a category with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Category getCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCategory(categoryId);
	}

	/**
	* Updates the category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param category the category
	* @return the category that was updated
	*/
	public static de.uhh.l2g.plugins.model.Category updateCategory(
		de.uhh.l2g.plugins.model.Category category) {
		return getService().updateCategory(category);
	}

	/**
	* Returns the number of categories.
	*
	* @return the number of categories
	*/
	public static int getCategoriesCount() {
		return getService().getCategoriesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<de.uhh.l2g.plugins.model.Category> getAllCategories(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCategories(begin, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Category> getAllCategoriesByCompanyId(
		java.lang.Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCategoriesByCompanyId(companyId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Category> getAllCategoriesByGropuIdAndCompanyId(
		java.lang.Long groupId, java.lang.Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAllCategoriesByGropuIdAndCompanyId(groupId, companyId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Category> getAllCategoriesByGroupId(
		java.lang.Long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCategoriesByGroupId(groupId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Category> getByIdTitleisAndOperatorAndGroupId(
		int cId, java.lang.String cName, boolean isAndOperator,
		java.lang.Long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByIdTitleisAndOperatorAndGroupId(cId, cName,
			isAndOperator, groupId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Category> getByKeyWordsAndGroupId(
		java.lang.String keywords, java.lang.Long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByKeyWordsAndGroupId(keywords, groupId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Category> getByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByName(name);
	}

	/**
	* Returns a range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of categories
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Category> getCategories(
		int start, int end) {
		return getService().getCategories(start, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Category> getCategoriesFromLectureseriesIdsAndVideoIds(
		java.util.ArrayList<java.lang.Long> lectureseriesIds,
		java.util.ArrayList<java.lang.Long> videoIds) {
		return getService()
				   .getCategoriesFromLectureseriesIdsAndVideoIds(lectureseriesIds,
			videoIds);
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

	public static void deleteById(java.lang.Long id)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteById(id);
	}

	public static CategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CategoryLocalService, CategoryLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CategoryLocalService.class);
}