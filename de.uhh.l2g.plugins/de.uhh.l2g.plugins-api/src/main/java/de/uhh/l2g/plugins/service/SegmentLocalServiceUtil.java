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
 * Provides the local service utility for Segment. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.SegmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see SegmentLocalService
 * @see de.uhh.l2g.plugins.service.base.SegmentLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.SegmentLocalServiceImpl
 * @generated
 */
@ProviderType
public class SegmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.SegmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the segment to the database. Also notifies the appropriate model listeners.
	*
	* @param segment the segment
	* @return the segment that was added
	*/
	public static de.uhh.l2g.plugins.model.Segment addSegment(
		de.uhh.l2g.plugins.model.Segment segment) {
		return getService().addSegment(segment);
	}

	/**
	* Adds the segment to the database and generates thumb nail. Also notifies the appropriate model listeners.
	*
	* @param segment the segment
	* @return the segment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment createSegment(
		de.uhh.l2g.plugins.model.Segment segment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().createSegment(segment);
	}

	/**
	* Creates a new segment with the primary key. Does not add the segment to the database.
	*
	* @param segmentId the primary key for the new segment
	* @return the new segment
	*/
	public static de.uhh.l2g.plugins.model.Segment createSegment(long segmentId) {
		return getService().createSegment(segmentId);
	}

	/**
	* Deletes the segment from the database. Also notifies the appropriate model listeners.
	*
	* @param segment the segment
	* @return the segment that was removed
	*/
	public static de.uhh.l2g.plugins.model.Segment deleteSegment(
		de.uhh.l2g.plugins.model.Segment segment) {
		return getService().deleteSegment(segment);
	}

	/**
	* Deletes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param segmentId the primary key of the segment
	* @return the segment that was removed
	* @throws PortalException if a segment with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Segment deleteSegment(long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSegment(segmentId);
	}

	public static de.uhh.l2g.plugins.model.Segment fetchSegment(long segmentId) {
		return getService().fetchSegment(segmentId);
	}

	public static de.uhh.l2g.plugins.model.Segment fillWithProperties(
		de.uhh.l2g.plugins.model.Segment objectSegment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().fillWithProperties(objectSegment);
	}

	public static de.uhh.l2g.plugins.model.Segment getPreviusSegment(
		de.uhh.l2g.plugins.model.Segment segment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPreviusSegment(segment);
	}

	/**
	* Returns the segment with the primary key.
	*
	* @param segmentId the primary key of the segment
	* @return the segment
	* @throws PortalException if a segment with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Segment getSegment(long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSegment(segmentId);
	}

	public static de.uhh.l2g.plugins.model.Segment getSegmentById(
		java.lang.Long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSegmentById(segmentId);
	}

	public static de.uhh.l2g.plugins.model.Segment removeSegment(
		java.lang.Long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeSegment(segmentId);
	}

	/**
	* Updates the segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param segment the segment
	* @return the segment that was updated
	*/
	public static de.uhh.l2g.plugins.model.Segment updateSegment(
		de.uhh.l2g.plugins.model.Segment segment) {
		return getService().updateSegment(segment);
	}

	/**
	* Returns the number of segments.
	*
	* @return the number of segments
	*/
	public static int getSegmentsCount() {
		return getService().getSegmentsCount();
	}

	public static java.lang.Long getPreviusSegmentId(java.lang.Long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPreviusSegmentId(segmentId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns a range of all the segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segments
	* @param end the upper bound of the range of segments (not inclusive)
	* @return the range of segments
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment> getSegments(
		int start, int end) {
		return getService().getSegments(start, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Segment> getSegmentsByVideoId(
		java.lang.Long videoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSegmentsByVideoId(videoId);
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

	public static void deleteByVideoId(java.lang.Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteByVideoId(videoId);
	}

	public static void deleteThumbhailsFromSegment(
		de.uhh.l2g.plugins.model.Segment segment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThumbhailsFromSegment(segment);
	}

	public static void deleteThumbhailsFromSegments(
		java.util.List<de.uhh.l2g.plugins.model.Segment> segmentList)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThumbhailsFromSegments(segmentList);
	}

	public static SegmentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SegmentLocalService, SegmentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SegmentLocalService.class);
}