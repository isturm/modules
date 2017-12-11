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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Videohitlist;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the videohitlist service. This utility wraps {@link de.uhh.l2g.plugins.service.persistence.impl.VideohitlistPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideohitlistPersistence
 * @see de.uhh.l2g.plugins.service.persistence.impl.VideohitlistPersistenceImpl
 * @generated
 */
@ProviderType
public class VideohitlistUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Videohitlist videohitlist) {
		getPersistence().clearCache(videohitlist);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Videohitlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Videohitlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Videohitlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Videohitlist update(Videohitlist videohitlist) {
		return getPersistence().update(videohitlist);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Videohitlist update(Videohitlist videohitlist,
		ServiceContext serviceContext) {
		return getPersistence().update(videohitlist, serviceContext);
	}

	/**
	* Returns all the videohitlists where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching videohitlists
	*/
	public static List<Videohitlist> findByVideo(long videoId) {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns a range of all the videohitlists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @return the range of matching videohitlists
	*/
	public static List<Videohitlist> findByVideo(long videoId, int start,
		int end) {
		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the videohitlists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videohitlists
	*/
	public static List<Videohitlist> findByVideo(long videoId, int start,
		int end, OrderByComparator<Videohitlist> orderByComparator) {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the videohitlists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching videohitlists
	*/
	public static List<Videohitlist> findByVideo(long videoId, int start,
		int end, OrderByComparator<Videohitlist> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching videohitlist
	* @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	*/
	public static Videohitlist findByVideo_First(long videoId,
		OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {
		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the first videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	*/
	public static Videohitlist fetchByVideo_First(long videoId,
		OrderByComparator<Videohitlist> orderByComparator) {
		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the last videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching videohitlist
	* @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	*/
	public static Videohitlist findByVideo_Last(long videoId,
		OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {
		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the last videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	*/
	public static Videohitlist fetchByVideo_Last(long videoId,
		OrderByComparator<Videohitlist> orderByComparator) {
		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the videohitlists before and after the current videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videohitlistId the primary key of the current videohitlist
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next videohitlist
	* @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	*/
	public static Videohitlist[] findByVideo_PrevAndNext(long videohitlistId,
		long videoId, OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {
		return getPersistence()
				   .findByVideo_PrevAndNext(videohitlistId, videoId,
			orderByComparator);
	}

	/**
	* Removes all the videohitlists where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	*/
	public static void removeByVideo(long videoId) {
		getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of videohitlists where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching videohitlists
	*/
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Caches the videohitlist in the entity cache if it is enabled.
	*
	* @param videohitlist the videohitlist
	*/
	public static void cacheResult(Videohitlist videohitlist) {
		getPersistence().cacheResult(videohitlist);
	}

	/**
	* Caches the videohitlists in the entity cache if it is enabled.
	*
	* @param videohitlists the videohitlists
	*/
	public static void cacheResult(List<Videohitlist> videohitlists) {
		getPersistence().cacheResult(videohitlists);
	}

	/**
	* Creates a new videohitlist with the primary key. Does not add the videohitlist to the database.
	*
	* @param videohitlistId the primary key for the new videohitlist
	* @return the new videohitlist
	*/
	public static Videohitlist create(long videohitlistId) {
		return getPersistence().create(videohitlistId);
	}

	/**
	* Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videohitlistId the primary key of the videohitlist
	* @return the videohitlist that was removed
	* @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	*/
	public static Videohitlist remove(long videohitlistId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {
		return getPersistence().remove(videohitlistId);
	}

	public static Videohitlist updateImpl(Videohitlist videohitlist) {
		return getPersistence().updateImpl(videohitlist);
	}

	/**
	* Returns the videohitlist with the primary key or throws a {@link NoSuchVideohitlistException} if it could not be found.
	*
	* @param videohitlistId the primary key of the videohitlist
	* @return the videohitlist
	* @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	*/
	public static Videohitlist findByPrimaryKey(long videohitlistId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {
		return getPersistence().findByPrimaryKey(videohitlistId);
	}

	/**
	* Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videohitlistId the primary key of the videohitlist
	* @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	*/
	public static Videohitlist fetchByPrimaryKey(long videohitlistId) {
		return getPersistence().fetchByPrimaryKey(videohitlistId);
	}

	public static java.util.Map<java.io.Serializable, Videohitlist> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the videohitlists.
	*
	* @return the videohitlists
	*/
	public static List<Videohitlist> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the videohitlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @return the range of videohitlists
	*/
	public static List<Videohitlist> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the videohitlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of videohitlists
	*/
	public static List<Videohitlist> findAll(int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the videohitlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of videohitlists
	*/
	public static List<Videohitlist> findAll(int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the videohitlists from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of videohitlists.
	*
	* @return the number of videohitlists
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VideohitlistPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VideohitlistPersistence, VideohitlistPersistence> _serviceTracker =
		ServiceTrackerFactory.open(VideohitlistPersistence.class);
}