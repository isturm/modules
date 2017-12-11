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
 * This class is a wrapper for {@link Lastvideolist}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lastvideolist
 * @generated
 */
@ProviderType
public class LastvideolistWrapper implements Lastvideolist,
	ModelWrapper<Lastvideolist> {
	public LastvideolistWrapper(Lastvideolist lastvideolist) {
		_lastvideolist = lastvideolist;
	}

	@Override
	public Class<?> getModelClass() {
		return Lastvideolist.class;
	}

	@Override
	public String getModelClassName() {
		return Lastvideolist.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lastvideolistId", getLastvideolistId());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer lastvideolistId = (Integer)attributes.get("lastvideolistId");

		if (lastvideolistId != null) {
			setLastvideolistId(lastvideolistId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _lastvideolist.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _lastvideolist.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _lastvideolist.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _lastvideolist.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.uhh.l2g.plugins.model.Lastvideolist> toCacheModel() {
		return _lastvideolist.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist toEscapedModel() {
		return new LastvideolistWrapper(_lastvideolist.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist toUnescapedModel() {
		return new LastvideolistWrapper(_lastvideolist.toUnescapedModel());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Lastvideolist lastvideolist) {
		return _lastvideolist.compareTo(lastvideolist);
	}

	/**
	* Returns the lastvideolist ID of this lastvideolist.
	*
	* @return the lastvideolist ID of this lastvideolist
	*/
	@Override
	public int getLastvideolistId() {
		return _lastvideolist.getLastvideolistId();
	}

	/**
	* Returns the primary key of this lastvideolist.
	*
	* @return the primary key of this lastvideolist
	*/
	@Override
	public int getPrimaryKey() {
		return _lastvideolist.getPrimaryKey();
	}

	@Override
	public int hashCode() {
		return _lastvideolist.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lastvideolist.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LastvideolistWrapper((Lastvideolist)_lastvideolist.clone());
	}

	@Override
	public java.lang.String toString() {
		return _lastvideolist.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lastvideolist.toXmlString();
	}

	/**
	* Returns the video ID of this lastvideolist.
	*
	* @return the video ID of this lastvideolist
	*/
	@Override
	public long getVideoId() {
		return _lastvideolist.getVideoId();
	}

	@Override
	public void persist() {
		_lastvideolist.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lastvideolist.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_lastvideolist.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_lastvideolist.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_lastvideolist.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the lastvideolist ID of this lastvideolist.
	*
	* @param lastvideolistId the lastvideolist ID of this lastvideolist
	*/
	@Override
	public void setLastvideolistId(int lastvideolistId) {
		_lastvideolist.setLastvideolistId(lastvideolistId);
	}

	@Override
	public void setNew(boolean n) {
		_lastvideolist.setNew(n);
	}

	/**
	* Sets the primary key of this lastvideolist.
	*
	* @param primaryKey the primary key of this lastvideolist
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_lastvideolist.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_lastvideolist.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the video ID of this lastvideolist.
	*
	* @param videoId the video ID of this lastvideolist
	*/
	@Override
	public void setVideoId(long videoId) {
		_lastvideolist.setVideoId(videoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LastvideolistWrapper)) {
			return false;
		}

		LastvideolistWrapper lastvideolistWrapper = (LastvideolistWrapper)obj;

		if (Objects.equals(_lastvideolist, lastvideolistWrapper._lastvideolist)) {
			return true;
		}

		return false;
	}

	@Override
	public Lastvideolist getWrappedModel() {
		return _lastvideolist;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _lastvideolist.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _lastvideolist.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_lastvideolist.resetOriginalValues();
	}

	private final Lastvideolist _lastvideolist;
}