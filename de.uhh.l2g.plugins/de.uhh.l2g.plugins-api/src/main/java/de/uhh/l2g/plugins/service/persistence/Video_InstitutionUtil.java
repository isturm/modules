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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Video_Institution;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the video_ institution service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.Video_InstitutionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_InstitutionPersistence
 * @generated
 */
@ProviderType
public class Video_InstitutionUtil {

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
	public static void clearCache(Video_Institution video_Institution) {
		getPersistence().clearCache(video_Institution);
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
	public static Map<Serializable, Video_Institution> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Video_Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video_Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video_Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Video_Institution update(
		Video_Institution video_Institution) {

		return getPersistence().update(video_Institution);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Video_Institution update(
		Video_Institution video_Institution, ServiceContext serviceContext) {

		return getPersistence().update(video_Institution, serviceContext);
	}

	/**
	 * Returns all the video_ institutions where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ institutions
	 */
	public static List<Video_Institution> findByVideo(long videoId) {
		return getPersistence().findByVideo(videoId);
	}

	/**
	 * Returns a range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	public static List<Video_Institution> findByVideo(
		long videoId, int start, int end) {

		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	public static List<Video_Institution> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	public static List<Video_Institution> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public static Video_Institution findByVideo_First(
			long videoId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public static Video_Institution fetchByVideo_First(
		long videoId, OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public static Video_Institution findByVideo_Last(
			long videoId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public static Video_Institution fetchByVideo_Last(
		long videoId, OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public static Video_Institution[] findByVideo_PrevAndNext(
			long videoInstitutionId, long videoId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByVideo_PrevAndNext(
			videoInstitutionId, videoId, orderByComparator);
	}

	/**
	 * Removes all the video_ institutions where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public static void removeByVideo(long videoId) {
		getPersistence().removeByVideo(videoId);
	}

	/**
	 * Returns the number of video_ institutions where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ institutions
	 */
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	 * Returns all the video_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching video_ institutions
	 */
	public static List<Video_Institution> findByInstitution(
		long institutionId) {

		return getPersistence().findByInstitution(institutionId);
	}

	/**
	 * Returns a range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	public static List<Video_Institution> findByInstitution(
		long institutionId, int start, int end) {

		return getPersistence().findByInstitution(institutionId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	public static List<Video_Institution> findByInstitution(
		long institutionId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().findByInstitution(
			institutionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	public static List<Video_Institution> findByInstitution(
		long institutionId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByInstitution(
			institutionId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public static Video_Institution findByInstitution_First(
			long institutionId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByInstitution_First(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the first video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public static Video_Institution fetchByInstitution_First(
		long institutionId,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().fetchByInstitution_First(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public static Video_Institution findByInstitution_Last(
			long institutionId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByInstitution_Last(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public static Video_Institution fetchByInstitution_Last(
		long institutionId,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().fetchByInstitution_Last(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public static Video_Institution[] findByInstitution_PrevAndNext(
			long videoInstitutionId, long institutionId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByInstitution_PrevAndNext(
			videoInstitutionId, institutionId, orderByComparator);
	}

	/**
	 * Removes all the video_ institutions where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	public static void removeByInstitution(long institutionId) {
		getPersistence().removeByInstitution(institutionId);
	}

	/**
	 * Returns the number of video_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching video_ institutions
	 */
	public static int countByInstitution(long institutionId) {
		return getPersistence().countByInstitution(institutionId);
	}

	/**
	 * Returns all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @return the matching video_ institutions
	 */
	public static List<Video_Institution> findByVideoInstitution(
		long videoId, long institutionId) {

		return getPersistence().findByVideoInstitution(videoId, institutionId);
	}

	/**
	 * Returns a range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	public static List<Video_Institution> findByVideoInstitution(
		long videoId, long institutionId, int start, int end) {

		return getPersistence().findByVideoInstitution(
			videoId, institutionId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	public static List<Video_Institution> findByVideoInstitution(
		long videoId, long institutionId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().findByVideoInstitution(
			videoId, institutionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	public static List<Video_Institution> findByVideoInstitution(
		long videoId, long institutionId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByVideoInstitution(
			videoId, institutionId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public static Video_Institution findByVideoInstitution_First(
			long videoId, long institutionId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByVideoInstitution_First(
			videoId, institutionId, orderByComparator);
	}

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public static Video_Institution fetchByVideoInstitution_First(
		long videoId, long institutionId,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().fetchByVideoInstitution_First(
			videoId, institutionId, orderByComparator);
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public static Video_Institution findByVideoInstitution_Last(
			long videoId, long institutionId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByVideoInstitution_Last(
			videoId, institutionId, orderByComparator);
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public static Video_Institution fetchByVideoInstitution_Last(
		long videoId, long institutionId,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().fetchByVideoInstitution_Last(
			videoId, institutionId, orderByComparator);
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public static Video_Institution[] findByVideoInstitution_PrevAndNext(
			long videoInstitutionId, long videoId, long institutionId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByVideoInstitution_PrevAndNext(
			videoInstitutionId, videoId, institutionId, orderByComparator);
	}

	/**
	 * Removes all the video_ institutions where videoId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 */
	public static void removeByVideoInstitution(
		long videoId, long institutionId) {

		getPersistence().removeByVideoInstitution(videoId, institutionId);
	}

	/**
	 * Returns the number of video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @return the number of matching video_ institutions
	 */
	public static int countByVideoInstitution(
		long videoId, long institutionId) {

		return getPersistence().countByVideoInstitution(videoId, institutionId);
	}

	/**
	 * Returns all the video_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the matching video_ institutions
	 */
	public static List<Video_Institution> findByInstitutionParentId(
		long institutionParentId) {

		return getPersistence().findByInstitutionParentId(institutionParentId);
	}

	/**
	 * Returns a range of all the video_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	public static List<Video_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end) {

		return getPersistence().findByInstitutionParentId(
			institutionParentId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	public static List<Video_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().findByInstitutionParentId(
			institutionParentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	public static List<Video_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByInstitutionParentId(
			institutionParentId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public static Video_Institution findByInstitutionParentId_First(
			long institutionParentId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByInstitutionParentId_First(
			institutionParentId, orderByComparator);
	}

	/**
	 * Returns the first video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public static Video_Institution fetchByInstitutionParentId_First(
		long institutionParentId,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().fetchByInstitutionParentId_First(
			institutionParentId, orderByComparator);
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public static Video_Institution findByInstitutionParentId_Last(
			long institutionParentId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByInstitutionParentId_Last(
			institutionParentId, orderByComparator);
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public static Video_Institution fetchByInstitutionParentId_Last(
		long institutionParentId,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().fetchByInstitutionParentId_Last(
			institutionParentId, orderByComparator);
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public static Video_Institution[] findByInstitutionParentId_PrevAndNext(
			long videoInstitutionId, long institutionParentId,
			OrderByComparator<Video_Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByInstitutionParentId_PrevAndNext(
			videoInstitutionId, institutionParentId, orderByComparator);
	}

	/**
	 * Removes all the video_ institutions where institutionParentId = &#63; from the database.
	 *
	 * @param institutionParentId the institution parent ID
	 */
	public static void removeByInstitutionParentId(long institutionParentId) {
		getPersistence().removeByInstitutionParentId(institutionParentId);
	}

	/**
	 * Returns the number of video_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the number of matching video_ institutions
	 */
	public static int countByInstitutionParentId(long institutionParentId) {
		return getPersistence().countByInstitutionParentId(institutionParentId);
	}

	/**
	 * Caches the video_ institution in the entity cache if it is enabled.
	 *
	 * @param video_Institution the video_ institution
	 */
	public static void cacheResult(Video_Institution video_Institution) {
		getPersistence().cacheResult(video_Institution);
	}

	/**
	 * Caches the video_ institutions in the entity cache if it is enabled.
	 *
	 * @param video_Institutions the video_ institutions
	 */
	public static void cacheResult(List<Video_Institution> video_Institutions) {
		getPersistence().cacheResult(video_Institutions);
	}

	/**
	 * Creates a new video_ institution with the primary key. Does not add the video_ institution to the database.
	 *
	 * @param videoInstitutionId the primary key for the new video_ institution
	 * @return the new video_ institution
	 */
	public static Video_Institution create(long videoInstitutionId) {
		return getPersistence().create(videoInstitutionId);
	}

	/**
	 * Removes the video_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution that was removed
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public static Video_Institution remove(long videoInstitutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().remove(videoInstitutionId);
	}

	public static Video_Institution updateImpl(
		Video_Institution video_Institution) {

		return getPersistence().updateImpl(video_Institution);
	}

	/**
	 * Returns the video_ institution with the primary key or throws a <code>NoSuchVideo_InstitutionException</code> if it could not be found.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public static Video_Institution findByPrimaryKey(long videoInstitutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException {

		return getPersistence().findByPrimaryKey(videoInstitutionId);
	}

	/**
	 * Returns the video_ institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution, or <code>null</code> if a video_ institution with the primary key could not be found
	 */
	public static Video_Institution fetchByPrimaryKey(long videoInstitutionId) {
		return getPersistence().fetchByPrimaryKey(videoInstitutionId);
	}

	/**
	 * Returns all the video_ institutions.
	 *
	 * @return the video_ institutions
	 */
	public static List<Video_Institution> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of video_ institutions
	 */
	public static List<Video_Institution> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ institutions
	 */
	public static List<Video_Institution> findAll(
		int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of video_ institutions
	 */
	public static List<Video_Institution> findAll(
		int start, int end,
		OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the video_ institutions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of video_ institutions.
	 *
	 * @return the number of video_ institutions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Video_InstitutionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Video_InstitutionPersistence, Video_InstitutionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Video_InstitutionPersistence.class);

		ServiceTracker
			<Video_InstitutionPersistence, Video_InstitutionPersistence>
				serviceTracker =
					new ServiceTracker
						<Video_InstitutionPersistence,
						 Video_InstitutionPersistence>(
							 bundle.getBundleContext(),
							 Video_InstitutionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}