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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Video_Creator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the video_ creator service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.Video_CreatorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CreatorPersistence
 * @generated
 */
@ProviderType
public class Video_CreatorUtil {

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
	public static void clearCache(Video_Creator video_Creator) {
		getPersistence().clearCache(video_Creator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Video_Creator> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Video_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Video_Creator update(Video_Creator video_Creator) {
		return getPersistence().update(video_Creator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Video_Creator update(
		Video_Creator video_Creator, ServiceContext serviceContext) {

		return getPersistence().update(video_Creator, serviceContext);
	}

	/**
	 * Returns all the video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ creators
	 */
	public static List<Video_Creator> findByVideo(long videoId) {
		return getPersistence().findByVideo(videoId);
	}

	/**
	 * Returns a range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	public static List<Video_Creator> findByVideo(
		long videoId, int start, int end) {

		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	public static List<Video_Creator> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	public static List<Video_Creator> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public static Video_Creator findByVideo_First(
			long videoId, OrderByComparator<Video_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public static Video_Creator fetchByVideo_First(
		long videoId, OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public static Video_Creator findByVideo_Last(
			long videoId, OrderByComparator<Video_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public static Video_Creator fetchByVideo_Last(
		long videoId, OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public static Video_Creator[] findByVideo_PrevAndNext(
			long videoCreatorId, long videoId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByVideo_PrevAndNext(
			videoCreatorId, videoId, orderByComparator);
	}

	/**
	 * Removes all the video_ creators where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public static void removeByVideo(long videoId) {
		getPersistence().removeByVideo(videoId);
	}

	/**
	 * Returns the number of video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ creators
	 */
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	 * Returns all the video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 */
	public static List<Video_Creator> findByCreator(long creatorId) {
		return getPersistence().findByCreator(creatorId);
	}

	/**
	 * Returns a range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	public static List<Video_Creator> findByCreator(
		long creatorId, int start, int end) {

		return getPersistence().findByCreator(creatorId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	public static List<Video_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().findByCreator(
			creatorId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	public static List<Video_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByCreator(
			creatorId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public static Video_Creator findByCreator_First(
			long creatorId, OrderByComparator<Video_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByCreator_First(
			creatorId, orderByComparator);
	}

	/**
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public static Video_Creator fetchByCreator_First(
		long creatorId, OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().fetchByCreator_First(
			creatorId, orderByComparator);
	}

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public static Video_Creator findByCreator_Last(
			long creatorId, OrderByComparator<Video_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByCreator_Last(
			creatorId, orderByComparator);
	}

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public static Video_Creator fetchByCreator_Last(
		long creatorId, OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().fetchByCreator_Last(
			creatorId, orderByComparator);
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public static Video_Creator[] findByCreator_PrevAndNext(
			long videoCreatorId, long creatorId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByCreator_PrevAndNext(
			videoCreatorId, creatorId, orderByComparator);
	}

	/**
	 * Removes all the video_ creators where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 */
	public static void removeByCreator(long creatorId) {
		getPersistence().removeByCreator(creatorId);
	}

	/**
	 * Returns the number of video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 */
	public static int countByCreator(long creatorId) {
		return getPersistence().countByCreator(creatorId);
	}

	/**
	 * Returns all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 */
	public static List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId) {

		return getPersistence().findByVideoCreator(videoId, creatorId);
	}

	/**
	 * Returns a range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	public static List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end) {

		return getPersistence().findByVideoCreator(
			videoId, creatorId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	public static List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().findByVideoCreator(
			videoId, creatorId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	public static List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByVideoCreator(
			videoId, creatorId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public static Video_Creator findByVideoCreator_First(
			long videoId, long creatorId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByVideoCreator_First(
			videoId, creatorId, orderByComparator);
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public static Video_Creator fetchByVideoCreator_First(
		long videoId, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().fetchByVideoCreator_First(
			videoId, creatorId, orderByComparator);
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public static Video_Creator findByVideoCreator_Last(
			long videoId, long creatorId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByVideoCreator_Last(
			videoId, creatorId, orderByComparator);
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public static Video_Creator fetchByVideoCreator_Last(
		long videoId, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().fetchByVideoCreator_Last(
			videoId, creatorId, orderByComparator);
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public static Video_Creator[] findByVideoCreator_PrevAndNext(
			long videoCreatorId, long videoId, long creatorId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByVideoCreator_PrevAndNext(
			videoCreatorId, videoId, creatorId, orderByComparator);
	}

	/**
	 * Removes all the video_ creators where videoId = &#63; and creatorId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 */
	public static void removeByVideoCreator(long videoId, long creatorId) {
		getPersistence().removeByVideoCreator(videoId, creatorId);
	}

	/**
	 * Returns the number of video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 */
	public static int countByVideoCreator(long videoId, long creatorId) {
		return getPersistence().countByVideoCreator(videoId, creatorId);
	}

	/**
	 * Caches the video_ creator in the entity cache if it is enabled.
	 *
	 * @param video_Creator the video_ creator
	 */
	public static void cacheResult(Video_Creator video_Creator) {
		getPersistence().cacheResult(video_Creator);
	}

	/**
	 * Caches the video_ creators in the entity cache if it is enabled.
	 *
	 * @param video_Creators the video_ creators
	 */
	public static void cacheResult(List<Video_Creator> video_Creators) {
		getPersistence().cacheResult(video_Creators);
	}

	/**
	 * Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	 *
	 * @param videoCreatorId the primary key for the new video_ creator
	 * @return the new video_ creator
	 */
	public static Video_Creator create(long videoCreatorId) {
		return getPersistence().create(videoCreatorId);
	}

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public static Video_Creator remove(long videoCreatorId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().remove(videoCreatorId);
	}

	public static Video_Creator updateImpl(Video_Creator video_Creator) {
		return getPersistence().updateImpl(video_Creator);
	}

	/**
	 * Returns the video_ creator with the primary key or throws a <code>NoSuchVideo_CreatorException</code> if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public static Video_Creator findByPrimaryKey(long videoCreatorId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException {

		return getPersistence().findByPrimaryKey(videoCreatorId);
	}

	/**
	 * Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	 */
	public static Video_Creator fetchByPrimaryKey(long videoCreatorId) {
		return getPersistence().fetchByPrimaryKey(videoCreatorId);
	}

	/**
	 * Returns all the video_ creators.
	 *
	 * @return the video_ creators
	 */
	public static List<Video_Creator> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of video_ creators
	 */
	public static List<Video_Creator> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ creators
	 */
	public static List<Video_Creator> findAll(
		int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of video_ creators
	 */
	public static List<Video_Creator> findAll(
		int start, int end, OrderByComparator<Video_Creator> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the video_ creators from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of video_ creators.
	 *
	 * @return the number of video_ creators
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Video_CreatorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Video_CreatorPersistence, Video_CreatorPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(Video_CreatorPersistence.class);

		ServiceTracker<Video_CreatorPersistence, Video_CreatorPersistence>
			serviceTracker =
				new ServiceTracker
					<Video_CreatorPersistence, Video_CreatorPersistence>(
						bundle.getBundleContext(),
						Video_CreatorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}