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
 * This class is a wrapper for {@link Metadata}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Metadata
 * @generated
 */
@ProviderType
public class MetadataWrapper implements Metadata, ModelWrapper<Metadata> {

	public MetadataWrapper(Metadata metadata) {
		_metadata = metadata;
	}

	@Override
	public Class<?> getModelClass() {
		return Metadata.class;
	}

	@Override
	public String getModelClassName() {
		return Metadata.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataId", getMetadataId());
		attributes.put("type", getType());
		attributes.put("language", getLanguage());
		attributes.put("title", getTitle());
		attributes.put("subject", getSubject());
		attributes.put("description", getDescription());
		attributes.put("publisher", getPublisher());
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
		Long metadataId = (Long)attributes.get("metadataId");

		if (metadataId != null) {
			setMetadataId(metadataId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String publisher = (String)attributes.get("publisher");

		if (publisher != null) {
			setPublisher(publisher);
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
		return new MetadataWrapper((Metadata)_metadata.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Metadata metadata) {
		return _metadata.compareTo(metadata);
	}

	/**
	 * Returns the company ID of this metadata.
	 *
	 * @return the company ID of this metadata
	 */
	@Override
	public long getCompanyId() {
		return _metadata.getCompanyId();
	}

	/**
	 * Returns the create date of this metadata.
	 *
	 * @return the create date of this metadata
	 */
	@Override
	public Date getCreateDate() {
		return _metadata.getCreateDate();
	}

	/**
	 * Returns the description of this metadata.
	 *
	 * @return the description of this metadata
	 */
	@Override
	public String getDescription() {
		return _metadata.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _metadata.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this metadata.
	 *
	 * @return the group ID of this metadata
	 */
	@Override
	public long getGroupId() {
		return _metadata.getGroupId();
	}

	/**
	 * Returns the language of this metadata.
	 *
	 * @return the language of this metadata
	 */
	@Override
	public String getLanguage() {
		return _metadata.getLanguage();
	}

	/**
	 * Returns the metadata ID of this metadata.
	 *
	 * @return the metadata ID of this metadata
	 */
	@Override
	public long getMetadataId() {
		return _metadata.getMetadataId();
	}

	/**
	 * Returns the modified date of this metadata.
	 *
	 * @return the modified date of this metadata
	 */
	@Override
	public Date getModifiedDate() {
		return _metadata.getModifiedDate();
	}

	/**
	 * Returns the primary key of this metadata.
	 *
	 * @return the primary key of this metadata
	 */
	@Override
	public long getPrimaryKey() {
		return _metadata.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _metadata.getPrimaryKeyObj();
	}

	/**
	 * Returns the publisher of this metadata.
	 *
	 * @return the publisher of this metadata
	 */
	@Override
	public String getPublisher() {
		return _metadata.getPublisher();
	}

	/**
	 * Returns the subject of this metadata.
	 *
	 * @return the subject of this metadata
	 */
	@Override
	public String getSubject() {
		return _metadata.getSubject();
	}

	/**
	 * Returns the title of this metadata.
	 *
	 * @return the title of this metadata
	 */
	@Override
	public String getTitle() {
		return _metadata.getTitle();
	}

	/**
	 * Returns the type of this metadata.
	 *
	 * @return the type of this metadata
	 */
	@Override
	public String getType() {
		return _metadata.getType();
	}

	/**
	 * Returns the user ID of this metadata.
	 *
	 * @return the user ID of this metadata
	 */
	@Override
	public long getUserId() {
		return _metadata.getUserId();
	}

	/**
	 * Returns the user name of this metadata.
	 *
	 * @return the user name of this metadata
	 */
	@Override
	public String getUserName() {
		return _metadata.getUserName();
	}

	/**
	 * Returns the user uuid of this metadata.
	 *
	 * @return the user uuid of this metadata
	 */
	@Override
	public String getUserUuid() {
		return _metadata.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _metadata.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _metadata.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _metadata.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _metadata.isNew();
	}

	@Override
	public void persist() {
		_metadata.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_metadata.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this metadata.
	 *
	 * @param companyId the company ID of this metadata
	 */
	@Override
	public void setCompanyId(long companyId) {
		_metadata.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this metadata.
	 *
	 * @param createDate the create date of this metadata
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_metadata.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this metadata.
	 *
	 * @param description the description of this metadata
	 */
	@Override
	public void setDescription(String description) {
		_metadata.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_metadata.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_metadata.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_metadata.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this metadata.
	 *
	 * @param groupId the group ID of this metadata
	 */
	@Override
	public void setGroupId(long groupId) {
		_metadata.setGroupId(groupId);
	}

	/**
	 * Sets the language of this metadata.
	 *
	 * @param language the language of this metadata
	 */
	@Override
	public void setLanguage(String language) {
		_metadata.setLanguage(language);
	}

	/**
	 * Sets the metadata ID of this metadata.
	 *
	 * @param metadataId the metadata ID of this metadata
	 */
	@Override
	public void setMetadataId(long metadataId) {
		_metadata.setMetadataId(metadataId);
	}

	/**
	 * Sets the modified date of this metadata.
	 *
	 * @param modifiedDate the modified date of this metadata
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_metadata.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_metadata.setNew(n);
	}

	/**
	 * Sets the primary key of this metadata.
	 *
	 * @param primaryKey the primary key of this metadata
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_metadata.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_metadata.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the publisher of this metadata.
	 *
	 * @param publisher the publisher of this metadata
	 */
	@Override
	public void setPublisher(String publisher) {
		_metadata.setPublisher(publisher);
	}

	/**
	 * Sets the subject of this metadata.
	 *
	 * @param subject the subject of this metadata
	 */
	@Override
	public void setSubject(String subject) {
		_metadata.setSubject(subject);
	}

	/**
	 * Sets the title of this metadata.
	 *
	 * @param title the title of this metadata
	 */
	@Override
	public void setTitle(String title) {
		_metadata.setTitle(title);
	}

	/**
	 * Sets the type of this metadata.
	 *
	 * @param type the type of this metadata
	 */
	@Override
	public void setType(String type) {
		_metadata.setType(type);
	}

	/**
	 * Sets the user ID of this metadata.
	 *
	 * @param userId the user ID of this metadata
	 */
	@Override
	public void setUserId(long userId) {
		_metadata.setUserId(userId);
	}

	/**
	 * Sets the user name of this metadata.
	 *
	 * @param userName the user name of this metadata
	 */
	@Override
	public void setUserName(String userName) {
		_metadata.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this metadata.
	 *
	 * @param userUuid the user uuid of this metadata
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_metadata.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Metadata> toCacheModel() {

		return _metadata.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Metadata toEscapedModel() {
		return new MetadataWrapper(_metadata.toEscapedModel());
	}

	@Override
	public String toString() {
		return _metadata.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Metadata toUnescapedModel() {
		return new MetadataWrapper(_metadata.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _metadata.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetadataWrapper)) {
			return false;
		}

		MetadataWrapper metadataWrapper = (MetadataWrapper)obj;

		if (Objects.equals(_metadata, metadataWrapper._metadata)) {
			return true;
		}

		return false;
	}

	@Override
	public Metadata getWrappedModel() {
		return _metadata;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _metadata.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _metadata.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_metadata.resetOriginalValues();
	}

	private final Metadata _metadata;

}