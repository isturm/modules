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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SegmentLocalService}.
 *
 * @author Iavor Sturm
 * @see SegmentLocalService
 * @generated
 */
@ProviderType
public class SegmentLocalServiceWrapper implements SegmentLocalService,
	ServiceWrapper<SegmentLocalService> {
	public SegmentLocalServiceWrapper(SegmentLocalService segmentLocalService) {
		_segmentLocalService = segmentLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _segmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _segmentLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _segmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segmentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the segment to the database. Also notifies the appropriate model listeners.
	*
	* @param segment the segment
	* @return the segment that was added
	*/
	@Override
	public de.uhh.l2g.plugins.model.Segment addSegment(
		de.uhh.l2g.plugins.model.Segment segment) {
		return _segmentLocalService.addSegment(segment);
	}

	/**
	* Creates a new segment with the primary key. Does not add the segment to the database.
	*
	* @param segmentId the primary key for the new segment
	* @return the new segment
	*/
	@Override
	public de.uhh.l2g.plugins.model.Segment createSegment(long segmentId) {
		return _segmentLocalService.createSegment(segmentId);
	}

	/**
	* Deletes the segment from the database. Also notifies the appropriate model listeners.
	*
	* @param segment the segment
	* @return the segment that was removed
	*/
	@Override
	public de.uhh.l2g.plugins.model.Segment deleteSegment(
		de.uhh.l2g.plugins.model.Segment segment) {
		return _segmentLocalService.deleteSegment(segment);
	}

	/**
	* Deletes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param segmentId the primary key of the segment
	* @return the segment that was removed
	* @throws PortalException if a segment with the primary key could not be found
	*/
	@Override
	public de.uhh.l2g.plugins.model.Segment deleteSegment(long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segmentLocalService.deleteSegment(segmentId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment fetchSegment(long segmentId) {
		return _segmentLocalService.fetchSegment(segmentId);
	}

	/**
	* Returns the segment with the primary key.
	*
	* @param segmentId the primary key of the segment
	* @return the segment
	* @throws PortalException if a segment with the primary key could not be found
	*/
	@Override
	public de.uhh.l2g.plugins.model.Segment getSegment(long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segmentLocalService.getSegment(segmentId);
	}

	/**
	* Updates the segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param segment the segment
	* @return the segment that was updated
	*/
	@Override
	public de.uhh.l2g.plugins.model.Segment updateSegment(
		de.uhh.l2g.plugins.model.Segment segment) {
		return _segmentLocalService.updateSegment(segment);
	}

	/**
	* Returns the number of segments.
	*
	* @return the number of segments
	*/
	@Override
	public int getSegmentsCount() {
		return _segmentLocalService.getSegmentsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _segmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _segmentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _segmentLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _segmentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Segment> getSegments(
		int start, int end) {
		return _segmentLocalService.getSegments(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _segmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _segmentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public SegmentLocalService getWrappedService() {
		return _segmentLocalService;
	}

	@Override
	public void setWrappedService(SegmentLocalService segmentLocalService) {
		_segmentLocalService = segmentLocalService;
	}

	private SegmentLocalService _segmentLocalService;
}