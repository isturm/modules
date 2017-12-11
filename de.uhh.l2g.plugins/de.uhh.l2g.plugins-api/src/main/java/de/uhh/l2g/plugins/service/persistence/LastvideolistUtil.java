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

import de.uhh.l2g.plugins.model.Lastvideolist;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lastvideolist service. This utility wraps {@link de.uhh.l2g.plugins.service.persistence.impl.LastvideolistPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LastvideolistPersistence
 * @see de.uhh.l2g.plugins.service.persistence.impl.LastvideolistPersistenceImpl
 * @generated
 */
@ProviderType
public class LastvideolistUtil {
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
	public static void clearCache(Lastvideolist lastvideolist) {
		getPersistence().clearCache(lastvideolist);
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
	public static List<Lastvideolist> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lastvideolist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lastvideolist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lastvideolist update(Lastvideolist lastvideolist) {
		return getPersistence().update(lastvideolist);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lastvideolist update(Lastvideolist lastvideolist,
		ServiceContext serviceContext) {
		return getPersistence().update(lastvideolist, serviceContext);
	}

	/**
	* Returns all the lastvideolists where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching lastvideolists
	*/
	public static List<Lastvideolist> findByVideo(long videoId) {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns a range of all the lastvideolists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @return the range of matching lastvideolists
	*/
	public static List<Lastvideolist> findByVideo(long videoId, int start,
		int end) {
		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the lastvideolists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lastvideolists
	*/
	public static List<Lastvideolist> findByVideo(long videoId, int start,
		int end, OrderByComparator<Lastvideolist> orderByComparator) {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lastvideolists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lastvideolists
	*/
	public static List<Lastvideolist> findByVideo(long videoId, int start,
		int end, OrderByComparator<Lastvideolist> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lastvideolist
	* @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	*/
	public static Lastvideolist findByVideo_First(long videoId,
		OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {
		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the first lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	*/
	public static Lastvideolist fetchByVideo_First(long videoId,
		OrderByComparator<Lastvideolist> orderByComparator) {
		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the last lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lastvideolist
	* @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	*/
	public static Lastvideolist findByVideo_Last(long videoId,
		OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {
		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the last lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	*/
	public static Lastvideolist fetchByVideo_Last(long videoId,
		OrderByComparator<Lastvideolist> orderByComparator) {
		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the lastvideolists before and after the current lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param lastvideolistId the primary key of the current lastvideolist
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lastvideolist
	* @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	*/
	public static Lastvideolist[] findByVideo_PrevAndNext(int lastvideolistId,
		long videoId, OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {
		return getPersistence()
				   .findByVideo_PrevAndNext(lastvideolistId, videoId,
			orderByComparator);
	}

	/**
	* Removes all the lastvideolists where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	*/
	public static void removeByVideo(long videoId) {
		getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of lastvideolists where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching lastvideolists
	*/
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Caches the lastvideolist in the entity cache if it is enabled.
	*
	* @param lastvideolist the lastvideolist
	*/
	public static void cacheResult(Lastvideolist lastvideolist) {
		getPersistence().cacheResult(lastvideolist);
	}

	/**
	* Caches the lastvideolists in the entity cache if it is enabled.
	*
	* @param lastvideolists the lastvideolists
	*/
	public static void cacheResult(List<Lastvideolist> lastvideolists) {
		getPersistence().cacheResult(lastvideolists);
	}

	/**
	* Creates a new lastvideolist with the primary key. Does not add the lastvideolist to the database.
	*
	* @param lastvideolistId the primary key for the new lastvideolist
	* @return the new lastvideolist
	*/
	public static Lastvideolist create(int lastvideolistId) {
		return getPersistence().create(lastvideolistId);
	}

	/**
	* Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lastvideolistId the primary key of the lastvideolist
	* @return the lastvideolist that was removed
	* @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	*/
	public static Lastvideolist remove(int lastvideolistId)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {
		return getPersistence().remove(lastvideolistId);
	}

	public static Lastvideolist updateImpl(Lastvideolist lastvideolist) {
		return getPersistence().updateImpl(lastvideolist);
	}

	/**
	* Returns the lastvideolist with the primary key or throws a {@link NoSuchLastvideolistException} if it could not be found.
	*
	* @param lastvideolistId the primary key of the lastvideolist
	* @return the lastvideolist
	* @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	*/
	public static Lastvideolist findByPrimaryKey(int lastvideolistId)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {
		return getPersistence().findByPrimaryKey(lastvideolistId);
	}

	/**
	* Returns the lastvideolist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lastvideolistId the primary key of the lastvideolist
	* @return the lastvideolist, or <code>null</code> if a lastvideolist with the primary key could not be found
	*/
	public static Lastvideolist fetchByPrimaryKey(int lastvideolistId) {
		return getPersistence().fetchByPrimaryKey(lastvideolistId);
	}

	public static java.util.Map<java.io.Serializable, Lastvideolist> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lastvideolists.
	*
	* @return the lastvideolists
	*/
	public static List<Lastvideolist> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lastvideolists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @return the range of lastvideolists
	*/
	public static List<Lastvideolist> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lastvideolists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lastvideolists
	*/
	public static List<Lastvideolist> findAll(int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lastvideolists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lastvideolists
	*/
	public static List<Lastvideolist> findAll(int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lastvideolists from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lastvideolists.
	*
	* @return the number of lastvideolists
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LastvideolistPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LastvideolistPersistence, LastvideolistPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LastvideolistPersistence.class);
}