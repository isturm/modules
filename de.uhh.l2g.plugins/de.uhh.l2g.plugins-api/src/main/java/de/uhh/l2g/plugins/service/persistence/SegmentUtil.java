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

import de.uhh.l2g.plugins.model.Segment;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the segment service. This utility wraps {@link de.uhh.l2g.plugins.service.persistence.impl.SegmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see SegmentPersistence
 * @see de.uhh.l2g.plugins.service.persistence.impl.SegmentPersistenceImpl
 * @generated
 */
@ProviderType
public class SegmentUtil {
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
	public static void clearCache(Segment segment) {
		getPersistence().clearCache(segment);
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
	public static List<Segment> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Segment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Segment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Segment> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Segment update(Segment segment) {
		return getPersistence().update(segment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Segment update(Segment segment, ServiceContext serviceContext) {
		return getPersistence().update(segment, serviceContext);
	}

	/**
	* Returns all the segments where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching segments
	*/
	public static List<Segment> findByVideo(long videoId) {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns a range of all the segments where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @return the range of matching segments
	*/
	public static List<Segment> findByVideo(long videoId, int start, int end) {
		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the segments where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching segments
	*/
	public static List<Segment> findByVideo(long videoId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the segments where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching segments
	*/
	public static List<Segment> findByVideo(long videoId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first segment in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment
	* @throws NoSuchSegmentException if a matching segment could not be found
	*/
	public static Segment findByVideo_First(long videoId,
		OrderByComparator<Segment> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchSegmentException {
		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the first segment in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment, or <code>null</code> if a matching segment could not be found
	*/
	public static Segment fetchByVideo_First(long videoId,
		OrderByComparator<Segment> orderByComparator) {
		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the last segment in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment
	* @throws NoSuchSegmentException if a matching segment could not be found
	*/
	public static Segment findByVideo_Last(long videoId,
		OrderByComparator<Segment> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchSegmentException {
		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the last segment in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment, or <code>null</code> if a matching segment could not be found
	*/
	public static Segment fetchByVideo_Last(long videoId,
		OrderByComparator<Segment> orderByComparator) {
		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the segments before and after the current segment in the ordered set where videoId = &#63;.
	*
	* @param segmentId the primary key of the current segment
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next segment
	* @throws NoSuchSegmentException if a segment with the primary key could not be found
	*/
	public static Segment[] findByVideo_PrevAndNext(long segmentId,
		long videoId, OrderByComparator<Segment> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchSegmentException {
		return getPersistence()
				   .findByVideo_PrevAndNext(segmentId, videoId,
			orderByComparator);
	}

	/**
	* Removes all the segments where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	*/
	public static void removeByVideo(long videoId) {
		getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of segments where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching segments
	*/
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Returns all the segments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching segments
	*/
	public static List<Segment> findByUser(long userId) {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the segments where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @return the range of matching segments
	*/
	public static List<Segment> findByUser(long userId, int start, int end) {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the segments where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching segments
	*/
	public static List<Segment> findByUser(long userId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the segments where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching segments
	*/
	public static List<Segment> findByUser(long userId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUser(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first segment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment
	* @throws NoSuchSegmentException if a matching segment could not be found
	*/
	public static Segment findByUser_First(long userId,
		OrderByComparator<Segment> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchSegmentException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first segment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment, or <code>null</code> if a matching segment could not be found
	*/
	public static Segment fetchByUser_First(long userId,
		OrderByComparator<Segment> orderByComparator) {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last segment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment
	* @throws NoSuchSegmentException if a matching segment could not be found
	*/
	public static Segment findByUser_Last(long userId,
		OrderByComparator<Segment> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchSegmentException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last segment in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment, or <code>null</code> if a matching segment could not be found
	*/
	public static Segment fetchByUser_Last(long userId,
		OrderByComparator<Segment> orderByComparator) {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the segments before and after the current segment in the ordered set where userId = &#63;.
	*
	* @param segmentId the primary key of the current segment
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next segment
	* @throws NoSuchSegmentException if a segment with the primary key could not be found
	*/
	public static Segment[] findByUser_PrevAndNext(long segmentId, long userId,
		OrderByComparator<Segment> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchSegmentException {
		return getPersistence()
				   .findByUser_PrevAndNext(segmentId, userId, orderByComparator);
	}

	/**
	* Removes all the segments where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUser(long userId) {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of segments where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching segments
	*/
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	* Caches the segment in the entity cache if it is enabled.
	*
	* @param segment the segment
	*/
	public static void cacheResult(Segment segment) {
		getPersistence().cacheResult(segment);
	}

	/**
	* Caches the segments in the entity cache if it is enabled.
	*
	* @param segments the segments
	*/
	public static void cacheResult(List<Segment> segments) {
		getPersistence().cacheResult(segments);
	}

	/**
	* Creates a new segment with the primary key. Does not add the segment to the database.
	*
	* @param segmentId the primary key for the new segment
	* @return the new segment
	*/
	public static Segment create(long segmentId) {
		return getPersistence().create(segmentId);
	}

	/**
	* Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param segmentId the primary key of the segment
	* @return the segment that was removed
	* @throws NoSuchSegmentException if a segment with the primary key could not be found
	*/
	public static Segment remove(long segmentId)
		throws de.uhh.l2g.plugins.exception.NoSuchSegmentException {
		return getPersistence().remove(segmentId);
	}

	public static Segment updateImpl(Segment segment) {
		return getPersistence().updateImpl(segment);
	}

	/**
	* Returns the segment with the primary key or throws a {@link NoSuchSegmentException} if it could not be found.
	*
	* @param segmentId the primary key of the segment
	* @return the segment
	* @throws NoSuchSegmentException if a segment with the primary key could not be found
	*/
	public static Segment findByPrimaryKey(long segmentId)
		throws de.uhh.l2g.plugins.exception.NoSuchSegmentException {
		return getPersistence().findByPrimaryKey(segmentId);
	}

	/**
	* Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param segmentId the primary key of the segment
	* @return the segment, or <code>null</code> if a segment with the primary key could not be found
	*/
	public static Segment fetchByPrimaryKey(long segmentId) {
		return getPersistence().fetchByPrimaryKey(segmentId);
	}

	public static java.util.Map<java.io.Serializable, Segment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the segments.
	*
	* @return the segments
	*/
	public static List<Segment> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @return the range of segments
	*/
	public static List<Segment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of segments
	*/
	public static List<Segment> findAll(int start, int end,
		OrderByComparator<Segment> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of segments
	*/
	public static List<Segment> findAll(int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the segments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of segments.
	*
	* @return the number of segments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SegmentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SegmentPersistence, SegmentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SegmentPersistence.class);
}