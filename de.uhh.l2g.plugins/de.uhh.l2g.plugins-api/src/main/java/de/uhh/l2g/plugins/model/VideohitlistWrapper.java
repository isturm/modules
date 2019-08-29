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
 * This class is a wrapper for {@link Videohitlist}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Videohitlist
 * @generated
 */
@ProviderType
public class VideohitlistWrapper
	implements Videohitlist, ModelWrapper<Videohitlist> {

	public VideohitlistWrapper(Videohitlist videohitlist) {
		_videohitlist = videohitlist;
	}

	@Override
	public Class<?> getModelClass() {
		return Videohitlist.class;
	}

	@Override
	public String getModelClassName() {
		return Videohitlist.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videohitlistId", getVideohitlistId());
		attributes.put("hitsPerDay", getHitsPerDay());
		attributes.put("hitsPerWeek", getHitsPerWeek());
		attributes.put("hitsPerMonth", getHitsPerMonth());
		attributes.put("hitsPerYear", getHitsPerYear());
		attributes.put("videoId", getVideoId());
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
		Long videohitlistId = (Long)attributes.get("videohitlistId");

		if (videohitlistId != null) {
			setVideohitlistId(videohitlistId);
		}

		Long hitsPerDay = (Long)attributes.get("hitsPerDay");

		if (hitsPerDay != null) {
			setHitsPerDay(hitsPerDay);
		}

		Long hitsPerWeek = (Long)attributes.get("hitsPerWeek");

		if (hitsPerWeek != null) {
			setHitsPerWeek(hitsPerWeek);
		}

		Long hitsPerMonth = (Long)attributes.get("hitsPerMonth");

		if (hitsPerMonth != null) {
			setHitsPerMonth(hitsPerMonth);
		}

		Long hitsPerYear = (Long)attributes.get("hitsPerYear");

		if (hitsPerYear != null) {
			setHitsPerYear(hitsPerYear);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
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
		return new VideohitlistWrapper((Videohitlist)_videohitlist.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Videohitlist videohitlist) {
		return _videohitlist.compareTo(videohitlist);
	}

	/**
	 * Returns the company ID of this videohitlist.
	 *
	 * @return the company ID of this videohitlist
	 */
	@Override
	public long getCompanyId() {
		return _videohitlist.getCompanyId();
	}

	/**
	 * Returns the create date of this videohitlist.
	 *
	 * @return the create date of this videohitlist
	 */
	@Override
	public Date getCreateDate() {
		return _videohitlist.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _videohitlist.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this videohitlist.
	 *
	 * @return the group ID of this videohitlist
	 */
	@Override
	public long getGroupId() {
		return _videohitlist.getGroupId();
	}

	/**
	 * Returns the hits per day of this videohitlist.
	 *
	 * @return the hits per day of this videohitlist
	 */
	@Override
	public long getHitsPerDay() {
		return _videohitlist.getHitsPerDay();
	}

	/**
	 * Returns the hits per month of this videohitlist.
	 *
	 * @return the hits per month of this videohitlist
	 */
	@Override
	public long getHitsPerMonth() {
		return _videohitlist.getHitsPerMonth();
	}

	/**
	 * Returns the hits per week of this videohitlist.
	 *
	 * @return the hits per week of this videohitlist
	 */
	@Override
	public long getHitsPerWeek() {
		return _videohitlist.getHitsPerWeek();
	}

	/**
	 * Returns the hits per year of this videohitlist.
	 *
	 * @return the hits per year of this videohitlist
	 */
	@Override
	public long getHitsPerYear() {
		return _videohitlist.getHitsPerYear();
	}

	/**
	 * Returns the modified date of this videohitlist.
	 *
	 * @return the modified date of this videohitlist
	 */
	@Override
	public Date getModifiedDate() {
		return _videohitlist.getModifiedDate();
	}

	/**
	 * Returns the primary key of this videohitlist.
	 *
	 * @return the primary key of this videohitlist
	 */
	@Override
	public long getPrimaryKey() {
		return _videohitlist.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videohitlist.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this videohitlist.
	 *
	 * @return the user ID of this videohitlist
	 */
	@Override
	public long getUserId() {
		return _videohitlist.getUserId();
	}

	/**
	 * Returns the user name of this videohitlist.
	 *
	 * @return the user name of this videohitlist
	 */
	@Override
	public String getUserName() {
		return _videohitlist.getUserName();
	}

	/**
	 * Returns the user uuid of this videohitlist.
	 *
	 * @return the user uuid of this videohitlist
	 */
	@Override
	public String getUserUuid() {
		return _videohitlist.getUserUuid();
	}

	/**
	 * Returns the videohitlist ID of this videohitlist.
	 *
	 * @return the videohitlist ID of this videohitlist
	 */
	@Override
	public long getVideohitlistId() {
		return _videohitlist.getVideohitlistId();
	}

	/**
	 * Returns the video ID of this videohitlist.
	 *
	 * @return the video ID of this videohitlist
	 */
	@Override
	public long getVideoId() {
		return _videohitlist.getVideoId();
	}

	@Override
	public int hashCode() {
		return _videohitlist.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _videohitlist.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _videohitlist.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _videohitlist.isNew();
	}

	@Override
	public void persist() {
		_videohitlist.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_videohitlist.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this videohitlist.
	 *
	 * @param companyId the company ID of this videohitlist
	 */
	@Override
	public void setCompanyId(long companyId) {
		_videohitlist.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this videohitlist.
	 *
	 * @param createDate the create date of this videohitlist
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_videohitlist.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_videohitlist.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_videohitlist.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_videohitlist.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this videohitlist.
	 *
	 * @param groupId the group ID of this videohitlist
	 */
	@Override
	public void setGroupId(long groupId) {
		_videohitlist.setGroupId(groupId);
	}

	/**
	 * Sets the hits per day of this videohitlist.
	 *
	 * @param hitsPerDay the hits per day of this videohitlist
	 */
	@Override
	public void setHitsPerDay(long hitsPerDay) {
		_videohitlist.setHitsPerDay(hitsPerDay);
	}

	/**
	 * Sets the hits per month of this videohitlist.
	 *
	 * @param hitsPerMonth the hits per month of this videohitlist
	 */
	@Override
	public void setHitsPerMonth(long hitsPerMonth) {
		_videohitlist.setHitsPerMonth(hitsPerMonth);
	}

	/**
	 * Sets the hits per week of this videohitlist.
	 *
	 * @param hitsPerWeek the hits per week of this videohitlist
	 */
	@Override
	public void setHitsPerWeek(long hitsPerWeek) {
		_videohitlist.setHitsPerWeek(hitsPerWeek);
	}

	/**
	 * Sets the hits per year of this videohitlist.
	 *
	 * @param hitsPerYear the hits per year of this videohitlist
	 */
	@Override
	public void setHitsPerYear(long hitsPerYear) {
		_videohitlist.setHitsPerYear(hitsPerYear);
	}

	/**
	 * Sets the modified date of this videohitlist.
	 *
	 * @param modifiedDate the modified date of this videohitlist
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_videohitlist.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_videohitlist.setNew(n);
	}

	/**
	 * Sets the primary key of this videohitlist.
	 *
	 * @param primaryKey the primary key of this videohitlist
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_videohitlist.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_videohitlist.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this videohitlist.
	 *
	 * @param userId the user ID of this videohitlist
	 */
	@Override
	public void setUserId(long userId) {
		_videohitlist.setUserId(userId);
	}

	/**
	 * Sets the user name of this videohitlist.
	 *
	 * @param userName the user name of this videohitlist
	 */
	@Override
	public void setUserName(String userName) {
		_videohitlist.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this videohitlist.
	 *
	 * @param userUuid the user uuid of this videohitlist
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_videohitlist.setUserUuid(userUuid);
	}

	/**
	 * Sets the videohitlist ID of this videohitlist.
	 *
	 * @param videohitlistId the videohitlist ID of this videohitlist
	 */
	@Override
	public void setVideohitlistId(long videohitlistId) {
		_videohitlist.setVideohitlistId(videohitlistId);
	}

	/**
	 * Sets the video ID of this videohitlist.
	 *
	 * @param videoId the video ID of this videohitlist
	 */
	@Override
	public void setVideoId(long videoId) {
		_videohitlist.setVideoId(videoId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Videohitlist> toCacheModel() {

		return _videohitlist.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Videohitlist toEscapedModel() {
		return new VideohitlistWrapper(_videohitlist.toEscapedModel());
	}

	@Override
	public String toString() {
		return _videohitlist.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Videohitlist toUnescapedModel() {
		return new VideohitlistWrapper(_videohitlist.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _videohitlist.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideohitlistWrapper)) {
			return false;
		}

		VideohitlistWrapper videohitlistWrapper = (VideohitlistWrapper)obj;

		if (Objects.equals(_videohitlist, videohitlistWrapper._videohitlist)) {
			return true;
		}

		return false;
	}

	@Override
	public Videohitlist getWrappedModel() {
		return _videohitlist;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _videohitlist.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _videohitlist.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_videohitlist.resetOriginalValues();
	}

	private final Videohitlist _videohitlist;

}