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
 * Provides the local service utility for Creator. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.CreatorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see CreatorLocalService
 * @see de.uhh.l2g.plugins.service.base.CreatorLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.CreatorLocalServiceImpl
 * @generated
 */
@ProviderType
public class CreatorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.CreatorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONArray getJSONCreator(
		java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJSONCreator(creatorId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getJSONCreatorsByLectureseriesId(
		java.lang.Long lectureseriesId) {
		return getService().getJSONCreatorsByLectureseriesId(lectureseriesId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getJSONCreatorsByVideoId(
		java.lang.Long videoId) {
		return getService().getJSONCreatorsByVideoId(videoId);
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
	* Adds the creator to the database. Also notifies the appropriate model listeners.
	*
	* @param creator the creator
	* @return the creator that was added
	*/
	public static de.uhh.l2g.plugins.model.Creator addCreator(
		de.uhh.l2g.plugins.model.Creator creator) {
		return getService().addCreator(creator);
	}

	/**
	* Creates a new creator with the primary key. Does not add the creator to the database.
	*
	* @param creatorId the primary key for the new creator
	* @return the new creator
	*/
	public static de.uhh.l2g.plugins.model.Creator createCreator(long creatorId) {
		return getService().createCreator(creatorId);
	}

	/**
	* Deletes the creator from the database. Also notifies the appropriate model listeners.
	*
	* @param creator the creator
	* @return the creator that was removed
	*/
	public static de.uhh.l2g.plugins.model.Creator deleteCreator(
		de.uhh.l2g.plugins.model.Creator creator) {
		return getService().deleteCreator(creator);
	}

	/**
	* Deletes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creatorId the primary key of the creator
	* @return the creator that was removed
	* @throws PortalException if a creator with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Creator deleteCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCreator(creatorId);
	}

	public static de.uhh.l2g.plugins.model.Creator fetchCreator(long creatorId) {
		return getService().fetchCreator(creatorId);
	}

	/**
	* Returns the creator with the primary key.
	*
	* @param creatorId the primary key of the creator
	* @return the creator
	* @throws PortalException if a creator with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Creator getCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCreator(creatorId);
	}

	/**
	* Updates the creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param creator the creator
	* @return the creator that was updated
	*/
	public static de.uhh.l2g.plugins.model.Creator updateCreator(
		de.uhh.l2g.plugins.model.Creator creator) {
		return getService().updateCreator(creator);
	}

	/**
	* Returns the number of creators.
	*
	* @return the number of creators
	*/
	public static int getCreatorsCount() {
		return getService().getCreatorsCount();
	}

	public static java.lang.String getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(
		java.lang.Long lectureseriesId, int maxCreators) {
		return getService()
				   .getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(lectureseriesId,
			maxCreators);
	}

	public static java.lang.String getCommaSeparatedCreatorsByVideoIdAndMaxCreators(
		java.lang.Long videoId, int maxCreators) {
		return getService()
				   .getCommaSeparatedCreatorsByVideoIdAndMaxCreators(videoId,
			maxCreators);
	}

	public static java.lang.String getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(
		java.lang.Long lectureseriesId, int maxCreators) {
		return getService()
				   .getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(lectureseriesId,
			maxCreators);
	}

	public static java.lang.String getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(
		java.lang.Long videoId, int maxCreators) {
		return getService()
				   .getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(videoId,
			maxCreators);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getAllCreators()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCreators();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getByFullName(
		java.lang.String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByFullName(fullName);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getByJobTitleOrFirstNameOrMiddleNameOrLastNameOrFullName(
		java.lang.String jobTitle, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String fullName, boolean isAndOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByJobTitleOrFirstNameOrMiddleNameOrLastNameOrFullName(jobTitle,
			firstName, middleName, lastName, fullName, isAndOperator);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getByKeyWords(
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByKeyWords(keywords);
	}

	/**
	* Returns a range of all the creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @return the range of creators
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreators(
		int start, int end) {
		return getService().getCreators(start, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsByLectureseriesId(
		java.lang.Long lectureseriesId) {
		return getService().getCreatorsByLectureseriesId(lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsByLectureseriesIdForOpenAccessVideosOnly(
		java.lang.Long lectureseriesId) {
		return getService()
				   .getCreatorsByLectureseriesIdForOpenAccessVideosOnly(lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsByVideoId(
		java.lang.Long videoId) {
		return getService().getCreatorsByVideoId(videoId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsForLectureseriesOverTheAssigenedVideos(
		java.lang.Long lectureseriesId) {
		return getService()
				   .getCreatorsForLectureseriesOverTheAssigenedVideos(lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsFromLectureseriesIdsAndVideoIds(
		java.util.ArrayList<java.lang.Long> lectureseriesIds,
		java.util.ArrayList<java.lang.Long> videoIds) {
		return getService()
				   .getCreatorsFromLectureseriesIdsAndVideoIds(lectureseriesIds,
			videoIds);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(
		java.lang.Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(lectureseriesId);
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

	public static void deleteById(java.lang.Long id)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteById(id);
	}

	public static CreatorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CreatorLocalService, CreatorLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CreatorLocalService.class);
}