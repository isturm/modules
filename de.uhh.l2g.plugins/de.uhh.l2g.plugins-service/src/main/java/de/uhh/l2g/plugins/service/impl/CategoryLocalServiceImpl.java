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

package de.uhh.l2g.plugins.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.CategoryLocalServiceBaseImpl;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.CategoryLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.CategoryLocalServiceUtil
 */
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.CategoryLocalServiceUtil} to access the category local service.
	 */
	public List<Category> getAllCategories(int begin, int end) throws SystemException {
		List<Category> cl = new ArrayList<Category>();
		cl = categoryPersistence.findAll(begin, end);
		return cl;
	}
	
	public List<Category> getByName(String name) throws SystemException {
		List<Category> cl = new ArrayList<Category>();
		cl = categoryPersistence.findByName(name);
		return cl;
	}
	
	public Category getById(Long categoryId) throws NoSuchModelException, SystemException {
		return categoryPersistence.findByPrimaryKey(categoryId);
	}
	
	public List<Category> getCategoriesFromLectureseriesIdsAndVideoIds(ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds) {
		return categoryFinder.findCategoriesByLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
	}
	
	@Indexable(type = IndexableType.DELETE)
	public void deleteById(Long id) throws NoSuchModelException, SystemException{
		categoryPersistence.remove(id);
	}
	
	@Override
	@Indexable(type = IndexableType.REINDEX)
	public Category addCategory(Category category) {
		return super.addCategory(category);
	}
	
	@Override
	@Indexable(type = IndexableType.REINDEX)
	public Category updateCategory(Category category) {
		return super.updateCategory(category);
	}
	
	public List<Category> getByIdOrAndTitle(int cId, String cName, boolean isAndOperator) throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(de.uhh.l2g.plugins.model.impl.CategoryImpl.class, "cat");
		Junction junction = null;
		List<Category> categoriesList = Collections.emptyList();
		if (isAndOperator) {
			junction = RestrictionsFactoryUtil.conjunction();
		} else {
			junction = RestrictionsFactoryUtil.disjunction();
		}
		if (Validator.isDigit(cId + "") || cId > 0) {
			junction.add(PropertyFactoryUtil.forName("cat.categoryId").eq(Long.valueOf(cId)));
		}
		if (!Validator.isBlank(cName)) {
			junction.add(PropertyFactoryUtil.forName("vid.title").like(StringPool.PERCENT + HtmlUtil.escape(cName) + StringPool.PERCENT));
		}
		dynamicQuery.add(junction);
		try {
			categoriesList = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (final SystemException e) {
		}
		return categoriesList;
	}
	
	public List<Category> getByKeyWords(String keywords) throws SystemException {
		List<Category> categoriesList = Collections.emptyList();
		final Junction junction = RestrictionsFactoryUtil.disjunction();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(de.uhh.l2g.plugins.model.impl.CategoryImpl.class, "cat");
		if (Validator.isDigit(keywords)) {
			junction.add(PropertyFactoryUtil.forName("cat.categoryId").eq(Long.valueOf(keywords)));
		} else {
			junction.add(PropertyFactoryUtil.forName("cat.name").like(StringPool.PERCENT + HtmlUtil.escape(keywords) + StringPool.PERCENT));
		}
		dynamicQuery.add(junction);
		try {
			categoriesList = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (final SystemException e) {
		}
		return categoriesList;
	}	
}