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

package de.uhh.l2g.plugins.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.exception.NoSuchTagcloudException;
import de.uhh.l2g.plugins.model.Tagcloud;

/**
 * The persistence interface for the tagcloud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.persistence.impl.TagcloudPersistenceImpl
 * @see TagcloudUtil
 * @generated
 */
@ProviderType
public interface TagcloudPersistence extends BasePersistence<Tagcloud> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TagcloudUtil} to access the tagcloud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tagclouds where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @return the matching tagclouds
	*/
	public java.util.List<Tagcloud> findByObjectClassType(
		java.lang.String objectClassType);

	/**
	* Returns a range of all the tagclouds where objectClassType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectClassType the object class type
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of matching tagclouds
	*/
	public java.util.List<Tagcloud> findByObjectClassType(
		java.lang.String objectClassType, int start, int end);

	/**
	* Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectClassType the object class type
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tagclouds
	*/
	public java.util.List<Tagcloud> findByObjectClassType(
		java.lang.String objectClassType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator);

	/**
	* Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectClassType the object class type
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tagclouds
	*/
	public java.util.List<Tagcloud> findByObjectClassType(
		java.lang.String objectClassType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud
	* @throws NoSuchTagcloudException if a matching tagcloud could not be found
	*/
	public Tagcloud findByObjectClassType_First(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException;

	/**
	* Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	*/
	public Tagcloud fetchByObjectClassType_First(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator);

	/**
	* Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud
	* @throws NoSuchTagcloudException if a matching tagcloud could not be found
	*/
	public Tagcloud findByObjectClassType_Last(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException;

	/**
	* Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	*/
	public Tagcloud fetchByObjectClassType_Last(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator);

	/**
	* Returns the tagclouds before and after the current tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param tagcloudId the primary key of the current tagcloud
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tagcloud
	* @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	*/
	public Tagcloud[] findByObjectClassType_PrevAndNext(long tagcloudId,
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException;

	/**
	* Removes all the tagclouds where objectClassType = &#63; from the database.
	*
	* @param objectClassType the object class type
	*/
	public void removeByObjectClassType(java.lang.String objectClassType);

	/**
	* Returns the number of tagclouds where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @return the number of matching tagclouds
	*/
	public int countByObjectClassType(java.lang.String objectClassType);

	/**
	* Returns all the tagclouds where objectId = &#63;.
	*
	* @param objectId the object ID
	* @return the matching tagclouds
	*/
	public java.util.List<Tagcloud> findByObjectId(long objectId);

	/**
	* Returns a range of all the tagclouds where objectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectId the object ID
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of matching tagclouds
	*/
	public java.util.List<Tagcloud> findByObjectId(long objectId, int start,
		int end);

	/**
	* Returns an ordered range of all the tagclouds where objectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectId the object ID
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tagclouds
	*/
	public java.util.List<Tagcloud> findByObjectId(long objectId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator);

	/**
	* Returns an ordered range of all the tagclouds where objectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectId the object ID
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tagclouds
	*/
	public java.util.List<Tagcloud> findByObjectId(long objectId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud
	* @throws NoSuchTagcloudException if a matching tagcloud could not be found
	*/
	public Tagcloud findByObjectId_First(long objectId,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException;

	/**
	* Returns the first tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	*/
	public Tagcloud fetchByObjectId_First(long objectId,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator);

	/**
	* Returns the last tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud
	* @throws NoSuchTagcloudException if a matching tagcloud could not be found
	*/
	public Tagcloud findByObjectId_Last(long objectId,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException;

	/**
	* Returns the last tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	*/
	public Tagcloud fetchByObjectId_Last(long objectId,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator);

	/**
	* Returns the tagclouds before and after the current tagcloud in the ordered set where objectId = &#63;.
	*
	* @param tagcloudId the primary key of the current tagcloud
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tagcloud
	* @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	*/
	public Tagcloud[] findByObjectId_PrevAndNext(long tagcloudId,
		long objectId,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException;

	/**
	* Removes all the tagclouds where objectId = &#63; from the database.
	*
	* @param objectId the object ID
	*/
	public void removeByObjectId(long objectId);

	/**
	* Returns the number of tagclouds where objectId = &#63;.
	*
	* @param objectId the object ID
	* @return the number of matching tagclouds
	*/
	public int countByObjectId(long objectId);

	/**
	* Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or throws a {@link NoSuchTagcloudException} if it could not be found.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the matching tagcloud
	* @throws NoSuchTagcloudException if a matching tagcloud could not be found
	*/
	public Tagcloud findByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws NoSuchTagcloudException;

	/**
	* Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	*/
	public Tagcloud fetchByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId);

	/**
	* Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	*/
	public Tagcloud fetchByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId,
		boolean retrieveFromCache);

	/**
	* Removes the tagcloud where objectClassType = &#63; and objectId = &#63; from the database.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the tagcloud that was removed
	*/
	public Tagcloud removeByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws NoSuchTagcloudException;

	/**
	* Returns the number of tagclouds where objectClassType = &#63; and objectId = &#63;.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the number of matching tagclouds
	*/
	public int countByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId);

	/**
	* Caches the tagcloud in the entity cache if it is enabled.
	*
	* @param tagcloud the tagcloud
	*/
	public void cacheResult(Tagcloud tagcloud);

	/**
	* Caches the tagclouds in the entity cache if it is enabled.
	*
	* @param tagclouds the tagclouds
	*/
	public void cacheResult(java.util.List<Tagcloud> tagclouds);

	/**
	* Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	*
	* @param tagcloudId the primary key for the new tagcloud
	* @return the new tagcloud
	*/
	public Tagcloud create(long tagcloudId);

	/**
	* Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud that was removed
	* @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	*/
	public Tagcloud remove(long tagcloudId) throws NoSuchTagcloudException;

	public Tagcloud updateImpl(Tagcloud tagcloud);

	/**
	* Returns the tagcloud with the primary key or throws a {@link NoSuchTagcloudException} if it could not be found.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud
	* @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	*/
	public Tagcloud findByPrimaryKey(long tagcloudId)
		throws NoSuchTagcloudException;

	/**
	* Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	*/
	public Tagcloud fetchByPrimaryKey(long tagcloudId);

	@Override
	public java.util.Map<java.io.Serializable, Tagcloud> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tagclouds.
	*
	* @return the tagclouds
	*/
	public java.util.List<Tagcloud> findAll();

	/**
	* Returns a range of all the tagclouds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of tagclouds
	*/
	public java.util.List<Tagcloud> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tagclouds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tagclouds
	*/
	public java.util.List<Tagcloud> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator);

	/**
	* Returns an ordered range of all the tagclouds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tagclouds
	*/
	public java.util.List<Tagcloud> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tagcloud> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tagclouds from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tagclouds.
	*
	* @return the number of tagclouds
	*/
	public int countAll();
}