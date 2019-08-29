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
 * This class is a wrapper for {@link Lectureseries}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries
 * @generated
 */
@ProviderType
public class LectureseriesWrapper
	implements Lectureseries, ModelWrapper<Lectureseries> {

	public LectureseriesWrapper(Lectureseries lectureseries) {
		_lectureseries = lectureseries;
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("number", getNumber());
		attributes.put("eventType", getEventType());
		attributes.put("categoryId", getCategoryId());
		attributes.put("name", getName());
		attributes.put("shortDesc", getShortDesc());
		attributes.put("termId", getTermId());
		attributes.put("language", getLanguage());
		attributes.put("facultyName", getFacultyName());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("password", getPassword());
		attributes.put("approved", getApproved());
		attributes.put("longDesc", getLongDesc());
		attributes.put("latestOpenAccessVideoId", getLatestOpenAccessVideoId());
		attributes.put("latestVideoUploadDate", getLatestVideoUploadDate());
		attributes.put(
			"latestVideoGenerationDate", getLatestVideoGenerationDate());
		attributes.put("videoSort", getVideoSort());
		attributes.put("USID", getUSID());
		attributes.put("previewVideoId", getPreviewVideoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDesc = (String)attributes.get("shortDesc");

		if (shortDesc != null) {
			setShortDesc(shortDesc);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String facultyName = (String)attributes.get("facultyName");

		if (facultyName != null) {
			setFacultyName(facultyName);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		String longDesc = (String)attributes.get("longDesc");

		if (longDesc != null) {
			setLongDesc(longDesc);
		}

		Long latestOpenAccessVideoId = (Long)attributes.get(
			"latestOpenAccessVideoId");

		if (latestOpenAccessVideoId != null) {
			setLatestOpenAccessVideoId(latestOpenAccessVideoId);
		}

		Date latestVideoUploadDate = (Date)attributes.get(
			"latestVideoUploadDate");

		if (latestVideoUploadDate != null) {
			setLatestVideoUploadDate(latestVideoUploadDate);
		}

		String latestVideoGenerationDate = (String)attributes.get(
			"latestVideoGenerationDate");

		if (latestVideoGenerationDate != null) {
			setLatestVideoGenerationDate(latestVideoGenerationDate);
		}

		Integer videoSort = (Integer)attributes.get("videoSort");

		if (videoSort != null) {
			setVideoSort(videoSort);
		}

		String USID = (String)attributes.get("USID");

		if (USID != null) {
			setUSID(USID);
		}

		Long previewVideoId = (Long)attributes.get("previewVideoId");

		if (previewVideoId != null) {
			setPreviewVideoId(previewVideoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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
		return new LectureseriesWrapper((Lectureseries)_lectureseries.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Lectureseries lectureseries) {
		return _lectureseries.compareTo(lectureseries);
	}

	/**
	 * Returns the approved of this lectureseries.
	 *
	 * @return the approved of this lectureseries
	 */
	@Override
	public int getApproved() {
		return _lectureseries.getApproved();
	}

	/**
	 * Returns the category ID of this lectureseries.
	 *
	 * @return the category ID of this lectureseries
	 */
	@Override
	public long getCategoryId() {
		return _lectureseries.getCategoryId();
	}

	@Override
	public String getClosedAccessURI() {
		return _lectureseries.getClosedAccessURI();
	}

	/**
	 * Returns the company ID of this lectureseries.
	 *
	 * @return the company ID of this lectureseries
	 */
	@Override
	public long getCompanyId() {
		return _lectureseries.getCompanyId();
	}

	/**
	 * Returns the create date of this lectureseries.
	 *
	 * @return the create date of this lectureseries
	 */
	@Override
	public Date getCreateDate() {
		return _lectureseries.getCreateDate();
	}

	/**
	 * Returns the event type of this lectureseries.
	 *
	 * @return the event type of this lectureseries
	 */
	@Override
	public String getEventType() {
		return _lectureseries.getEventType();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _lectureseries.getExpandoBridge();
	}

	/**
	 * Returns the faculty name of this lectureseries.
	 *
	 * @return the faculty name of this lectureseries
	 */
	@Override
	public String getFacultyName() {
		return _lectureseries.getFacultyName();
	}

	/**
	 * Returns the group ID of this lectureseries.
	 *
	 * @return the group ID of this lectureseries
	 */
	@Override
	public long getGroupId() {
		return _lectureseries.getGroupId();
	}

	/**
	 * Returns the language of this lectureseries.
	 *
	 * @return the language of this lectureseries
	 */
	@Override
	public String getLanguage() {
		return _lectureseries.getLanguage();
	}

	/**
	 * Returns the latest open access video ID of this lectureseries.
	 *
	 * @return the latest open access video ID of this lectureseries
	 */
	@Override
	public long getLatestOpenAccessVideoId() {
		return _lectureseries.getLatestOpenAccessVideoId();
	}

	/**
	 * Returns the latest video generation date of this lectureseries.
	 *
	 * @return the latest video generation date of this lectureseries
	 */
	@Override
	public String getLatestVideoGenerationDate() {
		return _lectureseries.getLatestVideoGenerationDate();
	}

	/**
	 * Returns the latest video upload date of this lectureseries.
	 *
	 * @return the latest video upload date of this lectureseries
	 */
	@Override
	public Date getLatestVideoUploadDate() {
		return _lectureseries.getLatestVideoUploadDate();
	}

	/**
	 * Returns the lectureseries ID of this lectureseries.
	 *
	 * @return the lectureseries ID of this lectureseries
	 */
	@Override
	public long getLectureseriesId() {
		return _lectureseries.getLectureseriesId();
	}

	/**
	 * Returns the long desc of this lectureseries.
	 *
	 * @return the long desc of this lectureseries
	 */
	@Override
	public String getLongDesc() {
		return _lectureseries.getLongDesc();
	}

	/**
	 * Returns the modified date of this lectureseries.
	 *
	 * @return the modified date of this lectureseries
	 */
	@Override
	public Date getModifiedDate() {
		return _lectureseries.getModifiedDate();
	}

	/**
	 * Returns the name of this lectureseries.
	 *
	 * @return the name of this lectureseries
	 */
	@Override
	public String getName() {
		return _lectureseries.getName();
	}

	/**
	 * Returns the number of this lectureseries.
	 *
	 * @return the number of this lectureseries
	 */
	@Override
	public String getNumber() {
		return _lectureseries.getNumber();
	}

	@Override
	public int getNumberOfOpenAccessVideos() {
		return _lectureseries.getNumberOfOpenAccessVideos();
	}

	@Override
	public int getNumberOfVideos() {
		return _lectureseries.getNumberOfVideos();
	}

	@Override
	public String getOpenAccessURI() {
		return _lectureseries.getOpenAccessURI();
	}

	/**
	 * Returns the password of this lectureseries.
	 *
	 * @return the password of this lectureseries
	 */
	@Override
	public String getPassword() {
		return _lectureseries.getPassword();
	}

	/**
	 * Returns the preview video ID of this lectureseries.
	 *
	 * @return the preview video ID of this lectureseries
	 */
	@Override
	public long getPreviewVideoId() {
		return _lectureseries.getPreviewVideoId();
	}

	/**
	 * Returns the primary key of this lectureseries.
	 *
	 * @return the primary key of this lectureseries
	 */
	@Override
	public long getPrimaryKey() {
		return _lectureseries.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lectureseries.getPrimaryKeyObj();
	}

	/**
	 * Returns the short desc of this lectureseries.
	 *
	 * @return the short desc of this lectureseries
	 */
	@Override
	public String getShortDesc() {
		return _lectureseries.getShortDesc();
	}

	/**
	 * Returns the term ID of this lectureseries.
	 *
	 * @return the term ID of this lectureseries
	 */
	@Override
	public long getTermId() {
		return _lectureseries.getTermId();
	}

	@Override
	public String getType() {
		return _lectureseries.getType();
	}

	/**
	 * Returns the user ID of this lectureseries.
	 *
	 * @return the user ID of this lectureseries
	 */
	@Override
	public long getUserId() {
		return _lectureseries.getUserId();
	}

	/**
	 * Returns the user name of this lectureseries.
	 *
	 * @return the user name of this lectureseries
	 */
	@Override
	public String getUserName() {
		return _lectureseries.getUserName();
	}

	/**
	 * Returns the user uuid of this lectureseries.
	 *
	 * @return the user uuid of this lectureseries
	 */
	@Override
	public String getUserUuid() {
		return _lectureseries.getUserUuid();
	}

	/**
	 * Returns the usid of this lectureseries.
	 *
	 * @return the usid of this lectureseries
	 */
	@Override
	public String getUSID() {
		return _lectureseries.getUSID();
	}

	/**
	 * Returns the video sort of this lectureseries.
	 *
	 * @return the video sort of this lectureseries
	 */
	@Override
	public int getVideoSort() {
		return _lectureseries.getVideoSort();
	}

	@Override
	public int hashCode() {
		return _lectureseries.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _lectureseries.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _lectureseries.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _lectureseries.isNew();
	}

	@Override
	public void persist() {
		_lectureseries.persist();
	}

	/**
	 * Sets the approved of this lectureseries.
	 *
	 * @param approved the approved of this lectureseries
	 */
	@Override
	public void setApproved(int approved) {
		_lectureseries.setApproved(approved);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lectureseries.setCachedModel(cachedModel);
	}

	/**
	 * Sets the category ID of this lectureseries.
	 *
	 * @param categoryId the category ID of this lectureseries
	 */
	@Override
	public void setCategoryId(long categoryId) {
		_lectureseries.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this lectureseries.
	 *
	 * @param companyId the company ID of this lectureseries
	 */
	@Override
	public void setCompanyId(long companyId) {
		_lectureseries.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this lectureseries.
	 *
	 * @param createDate the create date of this lectureseries
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_lectureseries.setCreateDate(createDate);
	}

	/**
	 * Sets the event type of this lectureseries.
	 *
	 * @param eventType the event type of this lectureseries
	 */
	@Override
	public void setEventType(String eventType) {
		_lectureseries.setEventType(eventType);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_lectureseries.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_lectureseries.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_lectureseries.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the faculty name of this lectureseries.
	 *
	 * @param facultyName the faculty name of this lectureseries
	 */
	@Override
	public void setFacultyName(String facultyName) {
		_lectureseries.setFacultyName(facultyName);
	}

	/**
	 * Sets the group ID of this lectureseries.
	 *
	 * @param groupId the group ID of this lectureseries
	 */
	@Override
	public void setGroupId(long groupId) {
		_lectureseries.setGroupId(groupId);
	}

	/**
	 * Sets the language of this lectureseries.
	 *
	 * @param language the language of this lectureseries
	 */
	@Override
	public void setLanguage(String language) {
		_lectureseries.setLanguage(language);
	}

	/**
	 * Sets the latest open access video ID of this lectureseries.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID of this lectureseries
	 */
	@Override
	public void setLatestOpenAccessVideoId(long latestOpenAccessVideoId) {
		_lectureseries.setLatestOpenAccessVideoId(latestOpenAccessVideoId);
	}

	/**
	 * Sets the latest video generation date of this lectureseries.
	 *
	 * @param latestVideoGenerationDate the latest video generation date of this lectureseries
	 */
	@Override
	public void setLatestVideoGenerationDate(String latestVideoGenerationDate) {
		_lectureseries.setLatestVideoGenerationDate(latestVideoGenerationDate);
	}

	/**
	 * Sets the latest video upload date of this lectureseries.
	 *
	 * @param latestVideoUploadDate the latest video upload date of this lectureseries
	 */
	@Override
	public void setLatestVideoUploadDate(Date latestVideoUploadDate) {
		_lectureseries.setLatestVideoUploadDate(latestVideoUploadDate);
	}

	/**
	 * Sets the lectureseries ID of this lectureseries.
	 *
	 * @param lectureseriesId the lectureseries ID of this lectureseries
	 */
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_lectureseries.setLectureseriesId(lectureseriesId);
	}

	/**
	 * Sets the long desc of this lectureseries.
	 *
	 * @param longDesc the long desc of this lectureseries
	 */
	@Override
	public void setLongDesc(String longDesc) {
		_lectureseries.setLongDesc(longDesc);
	}

	/**
	 * Sets the modified date of this lectureseries.
	 *
	 * @param modifiedDate the modified date of this lectureseries
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_lectureseries.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this lectureseries.
	 *
	 * @param name the name of this lectureseries
	 */
	@Override
	public void setName(String name) {
		_lectureseries.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_lectureseries.setNew(n);
	}

	/**
	 * Sets the number of this lectureseries.
	 *
	 * @param number the number of this lectureseries
	 */
	@Override
	public void setNumber(String number) {
		_lectureseries.setNumber(number);
	}

	@Override
	public void setNumberOfOpenAccessVideos(int numberOfOpenAccessVideos) {
		_lectureseries.setNumberOfOpenAccessVideos(numberOfOpenAccessVideos);
	}

	@Override
	public void setNumberOfVideos(int numberOfVideos) {
		_lectureseries.setNumberOfVideos(numberOfVideos);
	}

	/**
	 * Sets the password of this lectureseries.
	 *
	 * @param password the password of this lectureseries
	 */
	@Override
	public void setPassword(String password) {
		_lectureseries.setPassword(password);
	}

	/**
	 * Sets the preview video ID of this lectureseries.
	 *
	 * @param previewVideoId the preview video ID of this lectureseries
	 */
	@Override
	public void setPreviewVideoId(long previewVideoId) {
		_lectureseries.setPreviewVideoId(previewVideoId);
	}

	/**
	 * Sets the primary key of this lectureseries.
	 *
	 * @param primaryKey the primary key of this lectureseries
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lectureseries.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_lectureseries.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the short desc of this lectureseries.
	 *
	 * @param shortDesc the short desc of this lectureseries
	 */
	@Override
	public void setShortDesc(String shortDesc) {
		_lectureseries.setShortDesc(shortDesc);
	}

	/**
	 * Sets the term ID of this lectureseries.
	 *
	 * @param termId the term ID of this lectureseries
	 */
	@Override
	public void setTermId(long termId) {
		_lectureseries.setTermId(termId);
	}

	@Override
	public void setType(String type) {
		_lectureseries.setType(type);
	}

	/**
	 * Sets the user ID of this lectureseries.
	 *
	 * @param userId the user ID of this lectureseries
	 */
	@Override
	public void setUserId(long userId) {
		_lectureseries.setUserId(userId);
	}

	/**
	 * Sets the user name of this lectureseries.
	 *
	 * @param userName the user name of this lectureseries
	 */
	@Override
	public void setUserName(String userName) {
		_lectureseries.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lectureseries.
	 *
	 * @param userUuid the user uuid of this lectureseries
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_lectureseries.setUserUuid(userUuid);
	}

	/**
	 * Sets the usid of this lectureseries.
	 *
	 * @param USID the usid of this lectureseries
	 */
	@Override
	public void setUSID(String USID) {
		_lectureseries.setUSID(USID);
	}

	/**
	 * Sets the video sort of this lectureseries.
	 *
	 * @param videoSort the video sort of this lectureseries
	 */
	@Override
	public void setVideoSort(int videoSort) {
		_lectureseries.setVideoSort(videoSort);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Lectureseries> toCacheModel() {

		return _lectureseries.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries toEscapedModel() {
		return new LectureseriesWrapper(_lectureseries.toEscapedModel());
	}

	@Override
	public String toString() {
		return _lectureseries.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries toUnescapedModel() {
		return new LectureseriesWrapper(_lectureseries.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _lectureseries.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LectureseriesWrapper)) {
			return false;
		}

		LectureseriesWrapper lectureseriesWrapper = (LectureseriesWrapper)obj;

		if (Objects.equals(
				_lectureseries, lectureseriesWrapper._lectureseries)) {

			return true;
		}

		return false;
	}

	@Override
	public Lectureseries getWrappedModel() {
		return _lectureseries;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _lectureseries.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _lectureseries.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_lectureseries.resetOriginalValues();
	}

	private final Lectureseries _lectureseries;

}