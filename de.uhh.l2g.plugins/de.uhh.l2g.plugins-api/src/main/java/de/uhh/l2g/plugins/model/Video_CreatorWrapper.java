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
 * This class is a wrapper for {@link Video_Creator}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_Creator
 * @generated
 */
@ProviderType
public class Video_CreatorWrapper
	implements Video_Creator, ModelWrapper<Video_Creator> {

	public Video_CreatorWrapper(Video_Creator video_Creator) {
		_video_Creator = video_Creator;
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Creator.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Creator.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoCreatorId", getVideoCreatorId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoCreatorId = (Long)attributes.get("videoCreatorId");

		if (videoCreatorId != null) {
			setVideoCreatorId(videoCreatorId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	@Override
	public Object clone() {
		return new Video_CreatorWrapper((Video_Creator)_video_Creator.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Video_Creator video_Creator) {
		return _video_Creator.compareTo(video_Creator);
	}

	/**
	 * Returns the creator ID of this video_ creator.
	 *
	 * @return the creator ID of this video_ creator
	 */
	@Override
	public long getCreatorId() {
		return _video_Creator.getCreatorId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _video_Creator.getExpandoBridge();
	}

	/**
	 * Returns the primary key of this video_ creator.
	 *
	 * @return the primary key of this video_ creator
	 */
	@Override
	public long getPrimaryKey() {
		return _video_Creator.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _video_Creator.getPrimaryKeyObj();
	}

	/**
	 * Returns the video creator ID of this video_ creator.
	 *
	 * @return the video creator ID of this video_ creator
	 */
	@Override
	public long getVideoCreatorId() {
		return _video_Creator.getVideoCreatorId();
	}

	/**
	 * Returns the video ID of this video_ creator.
	 *
	 * @return the video ID of this video_ creator
	 */
	@Override
	public long getVideoId() {
		return _video_Creator.getVideoId();
	}

	@Override
	public int hashCode() {
		return _video_Creator.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _video_Creator.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _video_Creator.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _video_Creator.isNew();
	}

	@Override
	public void persist() {
		_video_Creator.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_video_Creator.setCachedModel(cachedModel);
	}

	/**
	 * Sets the creator ID of this video_ creator.
	 *
	 * @param creatorId the creator ID of this video_ creator
	 */
	@Override
	public void setCreatorId(long creatorId) {
		_video_Creator.setCreatorId(creatorId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_video_Creator.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_video_Creator.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_video_Creator.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_video_Creator.setNew(n);
	}

	/**
	 * Sets the primary key of this video_ creator.
	 *
	 * @param primaryKey the primary key of this video_ creator
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_video_Creator.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_video_Creator.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the video creator ID of this video_ creator.
	 *
	 * @param videoCreatorId the video creator ID of this video_ creator
	 */
	@Override
	public void setVideoCreatorId(long videoCreatorId) {
		_video_Creator.setVideoCreatorId(videoCreatorId);
	}

	/**
	 * Sets the video ID of this video_ creator.
	 *
	 * @param videoId the video ID of this video_ creator
	 */
	@Override
	public void setVideoId(long videoId) {
		_video_Creator.setVideoId(videoId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Video_Creator> toCacheModel() {

		return _video_Creator.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Creator toEscapedModel() {
		return new Video_CreatorWrapper(_video_Creator.toEscapedModel());
	}

	@Override
	public String toString() {
		return _video_Creator.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Creator toUnescapedModel() {
		return new Video_CreatorWrapper(_video_Creator.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _video_Creator.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Video_CreatorWrapper)) {
			return false;
		}

		Video_CreatorWrapper video_CreatorWrapper = (Video_CreatorWrapper)obj;

		if (Objects.equals(
				_video_Creator, video_CreatorWrapper._video_Creator)) {

			return true;
		}

		return false;
	}

	@Override
	public Video_Creator getWrappedModel() {
		return _video_Creator;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _video_Creator.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _video_Creator.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_video_Creator.resetOriginalValues();
	}

	private final Video_Creator _video_Creator;

}