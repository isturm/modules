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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.exception.NoSuchTagcloudException;
import de.uhh.l2g.plugins.model.Tagcloud;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides the local service interface for Tagcloud. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Iavor Sturm
 * @see TagcloudLocalServiceUtil
 * @see de.uhh.l2g.plugins.service.base.TagcloudLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.TagcloudLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TagcloudLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TagcloudLocalServiceUtil} to access the tagcloud local service. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.TagcloudLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the tagcloud to the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloud the tagcloud
	* @return the tagcloud that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Tagcloud addTagcloud(Tagcloud tagcloud);

	/**
	* Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	*
	* @param tagcloudId the primary key for the new tagcloud
	* @return the new tagcloud
	*/
	public Tagcloud createTagcloud(long tagcloudId);

	/**
	* Deletes the tagcloud from the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloud the tagcloud
	* @return the tagcloud that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Tagcloud deleteTagcloud(Tagcloud tagcloud);

	/**
	* Deletes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud that was removed
	* @throws PortalException if a tagcloud with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Tagcloud deleteTagcloud(long tagcloudId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tagcloud fetchTagcloud(long tagcloudId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tagcloud getByObjectIdAndObjectClassType(long objectId,
		java.lang.String objectClassType)
		throws SystemException, NoSuchTagcloudException;

	/**
	* Returns the tagcloud with the primary key.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud
	* @throws PortalException if a tagcloud with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tagcloud getTagcloud(long tagcloudId) throws PortalException;

	/**
	* Updates the tagcloud in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tagcloud the tagcloud
	* @return the tagcloud that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Tagcloud updateTagcloud(Tagcloud tagcloud);

	/**
	* Returns the number of tagclouds.
	*
	* @return the number of tagclouds
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTagcloudsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the tagclouds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of tagclouds
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tagcloud> getTagclouds(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	public void add(ArrayList<java.lang.String> tagCloudArrayString,
		java.lang.String className, java.lang.Long objectId)
		throws SystemException;

	public void deleteByObjectId(long objectId) throws SystemException;

	public void generateForAllLectureseries();

	public void generateForAllVideos();

	public void generateForLectureseries(java.lang.Long lectureseriesId);

	public void generateForVideo(java.lang.Long videoId);

	public void updateByObjectIdAndObjectClassType(
		ArrayList<java.lang.String> tagCloudArrayString,
		java.lang.String className, long objectId) throws SystemException;
}