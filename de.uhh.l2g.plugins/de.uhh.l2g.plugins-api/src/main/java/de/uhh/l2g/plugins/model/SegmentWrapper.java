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

import java.util.Date;
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
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new SegmentWrapper((Segment)_segment.clone());
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

	/**
	 * Returns the company ID of this segment.
	 *
	 * @return the company ID of this segment
	 */
	@Override
	public long getCompanyId() {
		return _segment.getCompanyId();
	}

	/**
	 * Returns the create date of this segment.
	 *
	 * @return the create date of this segment
	 */
	@Override
	public Date getCreateDate() {
		return _segment.getCreateDate();
	}

	/**
	 * Returns the description of this segment.
	 *
	 * @return the description of this segment
	 */
	@Override
	public String getDescription() {
		return _segment.getDescription();
	}

	/**
	 * Returns the end of this segment.
	 *
	 * @return the end of this segment
	 */
	@Override
	public String getEnd() {
		return _segment.getEnd();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _segment.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this segment.
	 *
	 * @return the group ID of this segment
	 */
	@Override
	public long getGroupId() {
		return _segment.getGroupId();
	}

	@Override
	public String getImage() {
		return _segment.getImage();
	}

	/**
	 * Returns the modified date of this segment.
	 *
	 * @return the modified date of this segment
	 */
	@Override
	public Date getModifiedDate() {
		return _segment.getModifiedDate();
	}

	@Override
	public int getNumber() {
		return _segment.getNumber();
	}

	@Override
	public long getPreviusSegmentId() {
		return _segment.getPreviusSegmentId();
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

	@Override
	public Serializable getPrimaryKeyObj() {
		return _segment.getPrimaryKeyObj();
	}

	@Override
	public int getSeconds() {
		return _segment.getSeconds();
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
	 * Returns the start of this segment.
	 *
	 * @return the start of this segment
	 */
	@Override
	public String getStart() {
		return _segment.getStart();
	}

	/**
	 * Returns the title of this segment.
	 *
	 * @return the title of this segment
	 */
	@Override
	public String getTitle() {
		return _segment.getTitle();
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
	 * Returns the user name of this segment.
	 *
	 * @return the user name of this segment
	 */
	@Override
	public String getUserName() {
		return _segment.getUserName();
	}

	/**
	 * Returns the user uuid of this segment.
	 *
	 * @return the user uuid of this segment
	 */
	@Override
	public String getUserUuid() {
		return _segment.getUserUuid();
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
	public int hashCode() {
		return _segment.hashCode();
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
	 * Sets the company ID of this segment.
	 *
	 * @param companyId the company ID of this segment
	 */
	@Override
	public void setCompanyId(long companyId) {
		_segment.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this segment.
	 *
	 * @param createDate the create date of this segment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_segment.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this segment.
	 *
	 * @param description the description of this segment
	 */
	@Override
	public void setDescription(String description) {
		_segment.setDescription(description);
	}

	/**
	 * Sets the end of this segment.
	 *
	 * @param end the end of this segment
	 */
	@Override
	public void setEnd(String end) {
		_segment.setEnd(end);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_segment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_segment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_segment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this segment.
	 *
	 * @param groupId the group ID of this segment
	 */
	@Override
	public void setGroupId(long groupId) {
		_segment.setGroupId(groupId);
	}

	@Override
	public void setImage(String image) {
		_segment.setImage(image);
	}

	/**
	 * Sets the modified date of this segment.
	 *
	 * @param modifiedDate the modified date of this segment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_segment.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_segment.setNew(n);
	}

	@Override
	public void setNumber(int number) {
		_segment.setNumber(number);
	}

	@Override
	public void setPreviusSegmentId(long previusSegmentId) {
		_segment.setPreviusSegmentId(previusSegmentId);
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

	@Override
	public void setSeconds(int seconds) {
		_segment.setSeconds(seconds);
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
	public void setStart(String start) {
		_segment.setStart(start);
	}

	/**
	 * Sets the title of this segment.
	 *
	 * @param title the title of this segment
	 */
	@Override
	public void setTitle(String title) {
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
	 * Sets the user name of this segment.
	 *
	 * @param userName the user name of this segment
	 */
	@Override
	public void setUserName(String userName) {
		_segment.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this segment.
	 *
	 * @param userUuid the user uuid of this segment
	 */
	@Override
	public void setUserUuid(String userUuid) {
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
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Segment> toCacheModel() {

		return _segment.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment toEscapedModel() {
		return new SegmentWrapper(_segment.toEscapedModel());
	}

	@Override
	public String toString() {
		return _segment.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment toUnescapedModel() {
		return new SegmentWrapper(_segment.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _segment.toXmlString();
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