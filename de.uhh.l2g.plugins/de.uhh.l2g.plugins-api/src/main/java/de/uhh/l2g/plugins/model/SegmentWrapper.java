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

package de.uhh.l2g.plugins.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Segment}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Segment
 * @generated
 */
@ProviderType
public class SegmentWrapper implements Segment, ModelWrapper<Segment> {
	public SegmentWrapper(Segment segment) {
		_segment = segment;
	}

	@Override
	public Class<?> getModelClass() {
		return Segment.class;
	}

	@Override
	public String getModelClassName() {
		return Segment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("segmentId", getSegmentId());
		attributes.put("videoId", getVideoId());
		attributes.put("start", getStart());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("end", getEnd());
		attributes.put("chapter", getChapter());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long segmentId = (Long)attributes.get("segmentId");

		if (segmentId != null) {
			setSegmentId(segmentId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String start = (String)attributes.get("start");

		if (start != null) {
			setStart(start);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String end = (String)attributes.get("end");

		if (end != null) {
			setEnd(end);
		}

		Integer chapter = (Integer)attributes.get("chapter");

		if (chapter != null) {
			setChapter(chapter);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _segment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _segment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _segment.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _segment.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.uhh.l2g.plugins.model.Segment> toCacheModel() {
		return _segment.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment toEscapedModel() {
		return new SegmentWrapper(_segment.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment toUnescapedModel() {
		return new SegmentWrapper(_segment.toUnescapedModel());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Segment segment) {
		return _segment.compareTo(segment);
	}

	/**
	* Returns the chapter of this segment.
	*
	* @return the chapter of this segment
	*/
	@Override
	public int getChapter() {
		return _segment.getChapter();
	}

	@Override
	public int hashCode() {
		return _segment.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _segment.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SegmentWrapper((Segment)_segment.clone());
	}

	/**
	* Returns the description of this segment.
	*
	* @return the description of this segment
	*/
	@Override
	public java.lang.String getDescription() {
		return _segment.getDescription();
	}

	/**
	* Returns the end of this segment.
	*
	* @return the end of this segment
	*/
	@Override
	public java.lang.String getEnd() {
		return _segment.getEnd();
	}

	/**
	* Returns the start of this segment.
	*
	* @return the start of this segment
	*/
	@Override
	public java.lang.String getStart() {
		return _segment.getStart();
	}

	/**
	* Returns the title of this segment.
	*
	* @return the title of this segment
	*/
	@Override
	public java.lang.String getTitle() {
		return _segment.getTitle();
	}

	/**
	* Returns the user uuid of this segment.
	*
	* @return the user uuid of this segment
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _segment.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _segment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _segment.toXmlString();
	}

	/**
	* Returns the primary key of this segment.
	*
	* @return the primary key of this segment
	*/
	@Override
	public long getPrimaryKey() {
		return _segment.getPrimaryKey();
	}

	/**
	* Returns the segment ID of this segment.
	*
	* @return the segment ID of this segment
	*/
	@Override
	public long getSegmentId() {
		return _segment.getSegmentId();
	}

	/**
	* Returns the user ID of this segment.
	*
	* @return the user ID of this segment
	*/
	@Override
	public long getUserId() {
		return _segment.getUserId();
	}

	/**
	* Returns the video ID of this segment.
	*
	* @return the video ID of this segment
	*/
	@Override
	public long getVideoId() {
		return _segment.getVideoId();
	}

	@Override
	public void persist() {
		_segment.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_segment.setCachedModel(cachedModel);
	}

	/**
	* Sets the chapter of this segment.
	*
	* @param chapter the chapter of this segment
	*/
	@Override
	public void setChapter(int chapter) {
		_segment.setChapter(chapter);
	}

	/**
	* Sets the description of this segment.
	*
	* @param description the description of this segment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_segment.setDescription(description);
	}

	/**
	* Sets the end of this segment.
	*
	* @param end the end of this segment
	*/
	@Override
	public void setEnd(java.lang.String end) {
		_segment.setEnd(end);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_segment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_segment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_segment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_segment.setNew(n);
	}

	/**
	* Sets the primary key of this segment.
	*
	* @param primaryKey the primary key of this segment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_segment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_segment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the segment ID of this segment.
	*
	* @param segmentId the segment ID of this segment
	*/
	@Override
	public void setSegmentId(long segmentId) {
		_segment.setSegmentId(segmentId);
	}

	/**
	* Sets the start of this segment.
	*
	* @param start the start of this segment
	*/
	@Override
	public void setStart(java.lang.String start) {
		_segment.setStart(start);
	}

	/**
	* Sets the title of this segment.
	*
	* @param title the title of this segment
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_segment.setTitle(title);
	}

	/**
	* Sets the user ID of this segment.
	*
	* @param userId the user ID of this segment
	*/
	@Override
	public void setUserId(long userId) {
		_segment.setUserId(userId);
	}

	/**
	* Sets the user uuid of this segment.
	*
	* @param userUuid the user uuid of this segment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_segment.setUserUuid(userUuid);
	}

	/**
	* Sets the video ID of this segment.
	*
	* @param videoId the video ID of this segment
	*/
	@Override
	public void setVideoId(long videoId) {
		_segment.setVideoId(videoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegmentWrapper)) {
			return false;
		}

		SegmentWrapper segmentWrapper = (SegmentWrapper)obj;

		if (Objects.equals(_segment, segmentWrapper._segment)) {
			return true;
		}

		return false;
	}

	@Override
	public Segment getWrappedModel() {
		return _segment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _segment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _segment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_segment.resetOriginalValues();
	}

	private final Segment _segment;
}