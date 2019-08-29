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
 * This class is a wrapper for {@link Tagcloud}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Tagcloud
 * @generated
 */
@ProviderType
public class TagcloudWrapper implements Tagcloud, ModelWrapper<Tagcloud> {

	public TagcloudWrapper(Tagcloud tagcloud) {
		_tagcloud = tagcloud;
	}

	@Override
	public Class<?> getModelClass() {
		return Tagcloud.class;
	}

	@Override
	public String getModelClassName() {
		return Tagcloud.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagcloudId", getTagcloudId());
		attributes.put("objectClassType", getObjectClassType());
		attributes.put("objectId", getObjectId());
		attributes.put("tags", getTags());
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
		Long tagcloudId = (Long)attributes.get("tagcloudId");

		if (tagcloudId != null) {
			setTagcloudId(tagcloudId);
		}

		String objectClassType = (String)attributes.get("objectClassType");

		if (objectClassType != null) {
			setObjectClassType(objectClassType);
		}

		Long objectId = (Long)attributes.get("objectId");

		if (objectId != null) {
			setObjectId(objectId);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
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
		return new TagcloudWrapper((Tagcloud)_tagcloud.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Tagcloud tagcloud) {
		return _tagcloud.compareTo(tagcloud);
	}

	/**
	 * Returns the company ID of this tagcloud.
	 *
	 * @return the company ID of this tagcloud
	 */
	@Override
	public long getCompanyId() {
		return _tagcloud.getCompanyId();
	}

	/**
	 * Returns the create date of this tagcloud.
	 *
	 * @return the create date of this tagcloud
	 */
	@Override
	public Date getCreateDate() {
		return _tagcloud.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tagcloud.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this tagcloud.
	 *
	 * @return the group ID of this tagcloud
	 */
	@Override
	public long getGroupId() {
		return _tagcloud.getGroupId();
	}

	/**
	 * Returns the modified date of this tagcloud.
	 *
	 * @return the modified date of this tagcloud
	 */
	@Override
	public Date getModifiedDate() {
		return _tagcloud.getModifiedDate();
	}

	/**
	 * Returns the object class type of this tagcloud.
	 *
	 * @return the object class type of this tagcloud
	 */
	@Override
	public String getObjectClassType() {
		return _tagcloud.getObjectClassType();
	}

	/**
	 * Returns the object ID of this tagcloud.
	 *
	 * @return the object ID of this tagcloud
	 */
	@Override
	public long getObjectId() {
		return _tagcloud.getObjectId();
	}

	/**
	 * Returns the primary key of this tagcloud.
	 *
	 * @return the primary key of this tagcloud
	 */
	@Override
	public long getPrimaryKey() {
		return _tagcloud.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tagcloud.getPrimaryKeyObj();
	}

	/**
	 * Returns the tagcloud ID of this tagcloud.
	 *
	 * @return the tagcloud ID of this tagcloud
	 */
	@Override
	public long getTagcloudId() {
		return _tagcloud.getTagcloudId();
	}

	/**
	 * Returns the tags of this tagcloud.
	 *
	 * @return the tags of this tagcloud
	 */
	@Override
	public String getTags() {
		return _tagcloud.getTags();
	}

	/**
	 * Returns the user ID of this tagcloud.
	 *
	 * @return the user ID of this tagcloud
	 */
	@Override
	public long getUserId() {
		return _tagcloud.getUserId();
	}

	/**
	 * Returns the user name of this tagcloud.
	 *
	 * @return the user name of this tagcloud
	 */
	@Override
	public String getUserName() {
		return _tagcloud.getUserName();
	}

	/**
	 * Returns the user uuid of this tagcloud.
	 *
	 * @return the user uuid of this tagcloud
	 */
	@Override
	public String getUserUuid() {
		return _tagcloud.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _tagcloud.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _tagcloud.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tagcloud.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tagcloud.isNew();
	}

	@Override
	public void persist() {
		_tagcloud.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tagcloud.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this tagcloud.
	 *
	 * @param companyId the company ID of this tagcloud
	 */
	@Override
	public void setCompanyId(long companyId) {
		_tagcloud.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this tagcloud.
	 *
	 * @param createDate the create date of this tagcloud
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_tagcloud.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_tagcloud.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tagcloud.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tagcloud.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this tagcloud.
	 *
	 * @param groupId the group ID of this tagcloud
	 */
	@Override
	public void setGroupId(long groupId) {
		_tagcloud.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this tagcloud.
	 *
	 * @param modifiedDate the modified date of this tagcloud
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_tagcloud.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_tagcloud.setNew(n);
	}

	/**
	 * Sets the object class type of this tagcloud.
	 *
	 * @param objectClassType the object class type of this tagcloud
	 */
	@Override
	public void setObjectClassType(String objectClassType) {
		_tagcloud.setObjectClassType(objectClassType);
	}

	/**
	 * Sets the object ID of this tagcloud.
	 *
	 * @param objectId the object ID of this tagcloud
	 */
	@Override
	public void setObjectId(long objectId) {
		_tagcloud.setObjectId(objectId);
	}

	/**
	 * Sets the primary key of this tagcloud.
	 *
	 * @param primaryKey the primary key of this tagcloud
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tagcloud.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tagcloud.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the tagcloud ID of this tagcloud.
	 *
	 * @param tagcloudId the tagcloud ID of this tagcloud
	 */
	@Override
	public void setTagcloudId(long tagcloudId) {
		_tagcloud.setTagcloudId(tagcloudId);
	}

	/**
	 * Sets the tags of this tagcloud.
	 *
	 * @param tags the tags of this tagcloud
	 */
	@Override
	public void setTags(String tags) {
		_tagcloud.setTags(tags);
	}

	/**
	 * Sets the user ID of this tagcloud.
	 *
	 * @param userId the user ID of this tagcloud
	 */
	@Override
	public void setUserId(long userId) {
		_tagcloud.setUserId(userId);
	}

	/**
	 * Sets the user name of this tagcloud.
	 *
	 * @param userName the user name of this tagcloud
	 */
	@Override
	public void setUserName(String userName) {
		_tagcloud.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this tagcloud.
	 *
	 * @param userUuid the user uuid of this tagcloud
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_tagcloud.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Tagcloud> toCacheModel() {

		return _tagcloud.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud toEscapedModel() {
		return new TagcloudWrapper(_tagcloud.toEscapedModel());
	}

	@Override
	public String toString() {
		return _tagcloud.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud toUnescapedModel() {
		return new TagcloudWrapper(_tagcloud.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _tagcloud.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TagcloudWrapper)) {
			return false;
		}

		TagcloudWrapper tagcloudWrapper = (TagcloudWrapper)obj;

		if (Objects.equals(_tagcloud, tagcloudWrapper._tagcloud)) {
			return true;
		}

		return false;
	}

	@Override
	public Tagcloud getWrappedModel() {
		return _tagcloud;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tagcloud.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tagcloud.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tagcloud.resetOriginalValues();
	}

	private final Tagcloud _tagcloud;

}