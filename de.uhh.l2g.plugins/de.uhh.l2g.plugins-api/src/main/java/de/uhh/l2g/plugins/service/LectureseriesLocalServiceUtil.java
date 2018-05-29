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
 * Provides the local service utility for Lectureseries. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.LectureseriesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see LectureseriesLocalService
 * @see de.uhh.l2g.plugins.service.base.LectureseriesLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.LectureseriesLocalServiceImpl
 * @generated
 */
@ProviderType
public class LectureseriesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.LectureseriesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the lectureseries to the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries the lectureseries
	* @return the lectureseries that was added
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries addLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries) {
		return getService().addLectureseries(lectureseries);
	}

	/**
	* Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	*
	* @param lectureseriesId the primary key for the new lectureseries
	* @return the new lectureseries
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries createLectureseries(
		long lectureseriesId) {
		return getService().createLectureseries(lectureseriesId);
	}

	/**
	* Deletes the lectureseries from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries the lectureseries
	* @return the lectureseries that was removed
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries deleteLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries) {
		return getService().deleteLectureseries(lectureseries);
	}

	/**
	* Deletes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries that was removed
	* @throws PortalException if a lectureseries with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries deleteLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLectureseries(lectureseriesId);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries fetchLectureseries(
		long lectureseriesId) {
		return getService().fetchLectureseries(lectureseriesId);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries getByUSID(
		java.lang.String usid) {
		return getService().getByUSID(usid);
	}

	/**
	* Returns the lectureseries with the primary key.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries
	* @throws PortalException if a lectureseries with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries getLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLectureseries(lectureseriesId);
	}

	/**
	* Updates the lectureseries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lectureseries the lectureseries
	* @return the lectureseries that was updated
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries updateLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries) {
		return getService().updateLectureseries(lectureseries);
	}

	/**
	* Returns the number of lectureserieses.
	*
	* @return the number of lectureserieses
	*/
	public static int getLectureseriesesCount() {
		return getService().getLectureseriesesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAllForVideo(
		de.uhh.l2g.plugins.model.Video video) {
		return getService().getAllForVideo(video);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAllLectureseriesWhithOpenaccessVideos() {
		return getService().getAllLectureseriesWhithOpenaccessVideos();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAllLectureseriesWhithPassword() {
		return getService().getAllLectureseriesWhithPassword();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getByLatestVideoId(
		java.lang.Long latestVideoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByLatestVideoId(latestVideoId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getByTerm(
		java.lang.Long termId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByTerm(termId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getFilteredByApprovedSemesterFacultyProducer(
		java.lang.Integer approved, java.lang.Long semester,
		java.lang.Long facultyId, java.lang.Long producerId,
		java.lang.Long groupId, java.lang.Long companyId) {
		return getService()
				   .getFilteredByApprovedSemesterFacultyProducer(approved,
			semester, facultyId, producerId, groupId, companyId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
		java.lang.Long institutionId, java.lang.Long parentInstitutionId,
		java.lang.Long termId, java.lang.Long categoryId,
		java.lang.Long creatorId, java.lang.String searchQuery,
		java.lang.Long groupId, java.lang.Long companyId) {
		return getService()
				   .getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(institutionId,
			parentInstitutionId, termId, categoryId, creatorId, searchQuery,
			groupId, companyId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getLatest(
		int limit, java.lang.Long groupId, java.lang.Long companyId) {
		return getService().getLatest(limit, groupId, companyId);
	}

	/**
	* Returns a range of all the lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of lectureserieses
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getLectureserieses(
		int start, int end) {
		return getService().getLectureserieses(start, end);
	}

	public static java.util.Map<de.uhh.l2g.plugins.model.Term, java.util.List<de.uhh.l2g.plugins.model.Lectureseries>> getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(
		java.lang.Integer approved, java.lang.Long semester,
		java.lang.Long facultyId, java.lang.Long producerId,
		java.lang.Long groupId, java.lang.Long companyId) {
		return getService()
				   .getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(approved,
			semester, facultyId, producerId, groupId, companyId);
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

	public static void updateCategoryForLectureseries(
		java.lang.Long lectureseriesId, java.lang.Long newCategoryId)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateCategoryForLectureseries(lectureseriesId, newCategoryId);
	}

	public static void updateOpenAccess(de.uhh.l2g.plugins.model.Video video,
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateOpenAccess(video, lectureseries);
	}

	public static void updatePreviewVideoOpenAccess(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updatePreviewVideoOpenAccess(lectureseries);
	}

	public static void updateUploadAndGenerationDate()
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateUploadAndGenerationDate();
	}

	public static LectureseriesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LectureseriesLocalService, LectureseriesLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LectureseriesLocalService.class);
}