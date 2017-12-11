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
 * This class is a wrapper for {@link Video_Institution}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_Institution
 * @generated
 */
@ProviderType
public class Video_InstitutionWrapper implements Video_Institution,
	ModelWrapper<Video_Institution> {
	public Video_InstitutionWrapper(Video_Institution video_Institution) {
		_video_Institution = video_Institution;
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Institution.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Institution.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoInstitutionId", getVideoInstitutionId());
		attributes.put("videoId", getVideoId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("institutionParentId", getInstitutionParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoInstitutionId = (Long)attributes.get("videoInstitutionId");

		if (videoInstitutionId != null) {
			setVideoInstitutionId(videoInstitutionId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long institutionParentId = (Long)attributes.get("institutionParentId");

		if (institutionParentId != null) {
			setInstitutionParentId(institutionParentId);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _video_Institution.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _video_Institution.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _video_Institution.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _video_Institution.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.uhh.l2g.plugins.model.Video_Institution> toCacheModel() {
		return _video_Institution.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Institution toEscapedModel() {
		return new Video_InstitutionWrapper(_video_Institution.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Institution toUnescapedModel() {
		return new Video_InstitutionWrapper(_video_Institution.toUnescapedModel());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Video_Institution video_Institution) {
		return _video_Institution.compareTo(video_Institution);
	}

	@Override
	public int hashCode() {
		return _video_Institution.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _video_Institution.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Video_InstitutionWrapper((Video_Institution)_video_Institution.clone());
	}

	@Override
	public java.lang.String toString() {
		return _video_Institution.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _video_Institution.toXmlString();
	}

	/**
	* Returns the institution ID of this video_ institution.
	*
	* @return the institution ID of this video_ institution
	*/
	@Override
	public long getInstitutionId() {
		return _video_Institution.getInstitutionId();
	}

	/**
	* Returns the institution parent ID of this video_ institution.
	*
	* @return the institution parent ID of this video_ institution
	*/
	@Override
	public long getInstitutionParentId() {
		return _video_Institution.getInstitutionParentId();
	}

	/**
	* Returns the primary key of this video_ institution.
	*
	* @return the primary key of this video_ institution
	*/
	@Override
	public long getPrimaryKey() {
		return _video_Institution.getPrimaryKey();
	}

	/**
	* Returns the video ID of this video_ institution.
	*
	* @return the video ID of this video_ institution
	*/
	@Override
	public long getVideoId() {
		return _video_Institution.getVideoId();
	}

	/**
	* Returns the video institution ID of this video_ institution.
	*
	* @return the video institution ID of this video_ institution
	*/
	@Override
	public long getVideoInstitutionId() {
		return _video_Institution.getVideoInstitutionId();
	}

	@Override
	public void persist() {
		_video_Institution.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_video_Institution.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_video_Institution.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_video_Institution.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_video_Institution.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the institution ID of this video_ institution.
	*
	* @param institutionId the institution ID of this video_ institution
	*/
	@Override
	public void setInstitutionId(long institutionId) {
		_video_Institution.setInstitutionId(institutionId);
	}

	/**
	* Sets the institution parent ID of this video_ institution.
	*
	* @param institutionParentId the institution parent ID of this video_ institution
	*/
	@Override
	public void setInstitutionParentId(long institutionParentId) {
		_video_Institution.setInstitutionParentId(institutionParentId);
	}

	@Override
	public void setNew(boolean n) {
		_video_Institution.setNew(n);
	}

	/**
	* Sets the primary key of this video_ institution.
	*
	* @param primaryKey the primary key of this video_ institution
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_video_Institution.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_video_Institution.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the video ID of this video_ institution.
	*
	* @param videoId the video ID of this video_ institution
	*/
	@Override
	public void setVideoId(long videoId) {
		_video_Institution.setVideoId(videoId);
	}

	/**
	* Sets the video institution ID of this video_ institution.
	*
	* @param videoInstitutionId the video institution ID of this video_ institution
	*/
	@Override
	public void setVideoInstitutionId(long videoInstitutionId) {
		_video_Institution.setVideoInstitutionId(videoInstitutionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Video_InstitutionWrapper)) {
			return false;
		}

		Video_InstitutionWrapper video_InstitutionWrapper = (Video_InstitutionWrapper)obj;

		if (Objects.equals(_video_Institution,
					video_InstitutionWrapper._video_Institution)) {
			return true;
		}

		return false;
	}

	@Override
	public Video_Institution getWrappedModel() {
		return _video_Institution;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _video_Institution.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _video_Institution.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_video_Institution.resetOriginalValues();
	}

	private final Video_Institution _video_Institution;
}