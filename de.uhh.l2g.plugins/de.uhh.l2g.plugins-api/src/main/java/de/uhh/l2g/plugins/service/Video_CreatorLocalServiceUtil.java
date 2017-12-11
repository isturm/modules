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
 * Provides the local service utility for Video_Creator. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.Video_CreatorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Video_CreatorLocalService
 * @see de.uhh.l2g.plugins.service.base.Video_CreatorLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.Video_CreatorLocalServiceImpl
 * @generated
 */
@ProviderType
public class Video_CreatorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.Video_CreatorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the video_ creator to the database. Also notifies the appropriate model listeners.
	*
	* @param video_Creator the video_ creator
	* @return the video_ creator that was added
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator addVideo_Creator(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator) {
		return getService().addVideo_Creator(video_Creator);
	}

	/**
	* Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	*
	* @param videoCreatorId the primary key for the new video_ creator
	* @return the new video_ creator
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator createVideo_Creator(
		long videoCreatorId) {
		return getService().createVideo_Creator(videoCreatorId);
	}

	/**
	* Deletes the video_ creator from the database. Also notifies the appropriate model listeners.
	*
	* @param video_Creator the video_ creator
	* @return the video_ creator that was removed
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator deleteVideo_Creator(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator) {
		return getService().deleteVideo_Creator(video_Creator);
	}

	/**
	* Deletes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator that was removed
	* @throws PortalException if a video_ creator with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator deleteVideo_Creator(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteVideo_Creator(videoCreatorId);
	}

	public static de.uhh.l2g.plugins.model.Video_Creator fetchVideo_Creator(
		long videoCreatorId) {
		return getService().fetchVideo_Creator(videoCreatorId);
	}

	/**
	* Returns the video_ creator with the primary key.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator
	* @throws PortalException if a video_ creator with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator getVideo_Creator(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getVideo_Creator(videoCreatorId);
	}

	/**
	* Updates the video_ creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param video_Creator the video_ creator
	* @return the video_ creator that was updated
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator updateVideo_Creator(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator) {
		return getService().updateVideo_Creator(video_Creator);
	}

	/**
	* Returns the number of video_ creators.
	*
	* @return the number of video_ creators
	*/
	public static int getVideo_CreatorsCount() {
		return getService().getVideo_CreatorsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> getByCreator(
		java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByCreator(creatorId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> getByVideo(
		java.lang.Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByVideo(videoId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> getByVideoCreator(
		java.lang.Long videoId, java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByVideoCreator(videoId, creatorId);
	}

	/**
	* Returns a range of all the video_ creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of video_ creators
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> getVideo_Creators(
		int start, int end) {
		return getService().getVideo_Creators(start, end);
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

	public static void deleteByCreatorId(java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteByCreatorId(creatorId);
	}

	public static void deleteByVideoId(java.lang.Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteByVideoId(videoId);
	}

	public static Video_CreatorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Video_CreatorLocalService, Video_CreatorLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Video_CreatorLocalService.class);
}