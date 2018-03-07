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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CategoryLocalService}.
 *
 * @author Iavor Sturm
 * @see CategoryLocalService
 * @generated
 */
@ProviderType
public class CategoryLocalServiceWrapper implements CategoryLocalService,
	ServiceWrapper<CategoryLocalService> {
	public CategoryLocalServiceWrapper(
		CategoryLocalService categoryLocalService) {
		_categoryLocalService = categoryLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _categoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _categoryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _categoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _categoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _categoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the category to the database. Also notifies the appropriate model listeners.
	*
	* @param category the category
	* @return the category that was added
	*/
	@Override
	public de.uhh.l2g.plugins.model.Category addCategory(
		de.uhh.l2g.plugins.model.Category category) {
		return _categoryLocalService.addCategory(category);
	}

	/**
	* Creates a new category with the primary key. Does not add the category to the database.
	*
	* @param categoryId the primary key for the new category
	* @return the new category
	*/
	@Override
	public de.uhh.l2g.plugins.model.Category createCategory(long categoryId) {
		return _categoryLocalService.createCategory(categoryId);
	}

	/**
	* Deletes the category from the database. Also notifies the appropriate model listeners.
	*
	* @param category the category
	* @return the category that was removed
	*/
	@Override
	public de.uhh.l2g.plugins.model.Category deleteCategory(
		de.uhh.l2g.plugins.model.Category category) {
		return _categoryLocalService.deleteCategory(category);
	}

	/**
	* Deletes the category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category
	* @return the category that was removed
	* @throws PortalException if a category with the primary key could not be found
	*/
	@Override
	public de.uhh.l2g.plugins.model.Category deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _categoryLocalService.deleteCategory(categoryId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Category fetchCategory(long categoryId) {
		return _categoryLocalService.fetchCategory(categoryId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Category getById(java.lang.Long categoryId)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryLocalService.getById(categoryId);
	}

	/**
	* Returns the category with the primary key.
	*
	* @param categoryId the primary key of the category
	* @return the category
	* @throws PortalException if a category with the primary key could not be found
	*/
	@Override
	public de.uhh.l2g.plugins.model.Category getCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _categoryLocalService.getCategory(categoryId);
	}

	/**
	* Updates the category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param category the category
	* @return the category that was updated
	*/
	@Override
	public de.uhh.l2g.plugins.model.Category updateCategory(
		de.uhh.l2g.plugins.model.Category category) {
		return _categoryLocalService.updateCategory(category);
	}

	/**
	* Returns the number of categories.
	*
	* @return the number of categories
	*/
	@Override
	public int getCategoriesCount() {
		return _categoryLocalService.getCategoriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _categoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _categoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _categoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _categoryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Category> getAllCategories(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryLocalService.getAllCategories(begin, end);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Category> getAllCategoriesByCompanyId(
		java.lang.Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryLocalService.getAllCategoriesByCompanyId(companyId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Category> getAllCategoriesByGropuIdAndCompanyId(
		java.lang.Long groupId, java.lang.Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryLocalService.getAllCategoriesByGropuIdAndCompanyId(groupId,
			companyId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Category> getAllCategoriesByGroupId(
		java.lang.Long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryLocalService.getAllCategoriesByGroupId(groupId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Category> getByIdTitleisAndOperatorAndGroupId(
		int cId, java.lang.String cName, boolean isAndOperator,
		java.lang.Long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryLocalService.getByIdTitleisAndOperatorAndGroupId(cId,
			cName, isAndOperator, groupId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Category> getByKeyWordsAndGroupId(
		java.lang.String keywords, java.lang.Long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryLocalService.getByKeyWordsAndGroupId(keywords, groupId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Category> getByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryLocalService.getByName(name);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Category> getCategories(
		int start, int end) {
		return _categoryLocalService.getCategories(start, end);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Category> getCategoriesFromLectureseriesIdsAndVideoIds(
		java.util.ArrayList<java.lang.Long> lectureseriesIds,
		java.util.ArrayList<java.lang.Long> videoIds) {
		return _categoryLocalService.getCategoriesFromLectureseriesIdsAndVideoIds(lectureseriesIds,
			videoIds);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _categoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _categoryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void deleteById(java.lang.Long id)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		_categoryLocalService.deleteById(id);
	}

	@Override
	public CategoryLocalService getWrappedService() {
		return _categoryLocalService;
	}

	@Override
	public void setWrappedService(CategoryLocalService categoryLocalService) {
		_categoryLocalService = categoryLocalService;
	}

	private CategoryLocalService _categoryLocalService;
}