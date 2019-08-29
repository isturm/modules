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
 * This class is a wrapper for {@link Creator}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Creator
 * @generated
 */
@ProviderType
public class CreatorWrapper implements Creator, ModelWrapper<Creator> {

	public CreatorWrapper(Creator creator) {
		_creator = creator;
	}

	@Override
	public Class<?> getModelClass() {
		return Creator.class;
	}

	@Override
	public String getModelClassName() {
		return Creator.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("creatorId", getCreatorId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("middleName", getMiddleName());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("gender", getGender());
		attributes.put("fullName", getFullName());
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
		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
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
		return new CreatorWrapper((Creator)_creator.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Creator creator) {
		return _creator.compareTo(creator);
	}

	/**
	 * Returns the company ID of this creator.
	 *
	 * @return the company ID of this creator
	 */
	@Override
	public long getCompanyId() {
		return _creator.getCompanyId();
	}

	/**
	 * Returns the create date of this creator.
	 *
	 * @return the create date of this creator
	 */
	@Override
	public Date getCreateDate() {
		return _creator.getCreateDate();
	}

	/**
	 * Returns the creator ID of this creator.
	 *
	 * @return the creator ID of this creator
	 */
	@Override
	public long getCreatorId() {
		return _creator.getCreatorId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _creator.getExpandoBridge();
	}

	/**
	 * Returns the first name of this creator.
	 *
	 * @return the first name of this creator
	 */
	@Override
	public String getFirstName() {
		return _creator.getFirstName();
	}

	/**
	 * Returns the full name of this creator.
	 *
	 * @return the full name of this creator
	 */
	@Override
	public String getFullName() {
		return _creator.getFullName();
	}

	/**
	 * Returns the gender of this creator.
	 *
	 * @return the gender of this creator
	 */
	@Override
	public String getGender() {
		return _creator.getGender();
	}

	/**
	 * Returns the group ID of this creator.
	 *
	 * @return the group ID of this creator
	 */
	@Override
	public long getGroupId() {
		return _creator.getGroupId();
	}

	/**
	 * Returns the job title of this creator.
	 *
	 * @return the job title of this creator
	 */
	@Override
	public String getJobTitle() {
		return _creator.getJobTitle();
	}

	/**
	 * Returns the last name of this creator.
	 *
	 * @return the last name of this creator
	 */
	@Override
	public String getLastName() {
		return _creator.getLastName();
	}

	/**
	 * Returns the middle name of this creator.
	 *
	 * @return the middle name of this creator
	 */
	@Override
	public String getMiddleName() {
		return _creator.getMiddleName();
	}

	/**
	 * Returns the modified date of this creator.
	 *
	 * @return the modified date of this creator
	 */
	@Override
	public Date getModifiedDate() {
		return _creator.getModifiedDate();
	}

	/**
	 * Returns the primary key of this creator.
	 *
	 * @return the primary key of this creator
	 */
	@Override
	public long getPrimaryKey() {
		return _creator.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _creator.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this creator.
	 *
	 * @return the user ID of this creator
	 */
	@Override
	public long getUserId() {
		return _creator.getUserId();
	}

	/**
	 * Returns the user name of this creator.
	 *
	 * @return the user name of this creator
	 */
	@Override
	public String getUserName() {
		return _creator.getUserName();
	}

	/**
	 * Returns the user uuid of this creator.
	 *
	 * @return the user uuid of this creator
	 */
	@Override
	public String getUserUuid() {
		return _creator.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _creator.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _creator.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _creator.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _creator.isNew();
	}

	@Override
	public void persist() {
		_creator.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_creator.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this creator.
	 *
	 * @param companyId the company ID of this creator
	 */
	@Override
	public void setCompanyId(long companyId) {
		_creator.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this creator.
	 *
	 * @param createDate the create date of this creator
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_creator.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this creator.
	 *
	 * @param creatorId the creator ID of this creator
	 */
	@Override
	public void setCreatorId(long creatorId) {
		_creator.setCreatorId(creatorId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_creator.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_creator.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_creator.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the first name of this creator.
	 *
	 * @param firstName the first name of this creator
	 */
	@Override
	public void setFirstName(String firstName) {
		_creator.setFirstName(firstName);
	}

	/**
	 * Sets the full name of this creator.
	 *
	 * @param fullName the full name of this creator
	 */
	@Override
	public void setFullName(String fullName) {
		_creator.setFullName(fullName);
	}

	/**
	 * Sets the gender of this creator.
	 *
	 * @param gender the gender of this creator
	 */
	@Override
	public void setGender(String gender) {
		_creator.setGender(gender);
	}

	/**
	 * Sets the group ID of this creator.
	 *
	 * @param groupId the group ID of this creator
	 */
	@Override
	public void setGroupId(long groupId) {
		_creator.setGroupId(groupId);
	}

	/**
	 * Sets the job title of this creator.
	 *
	 * @param jobTitle the job title of this creator
	 */
	@Override
	public void setJobTitle(String jobTitle) {
		_creator.setJobTitle(jobTitle);
	}

	/**
	 * Sets the last name of this creator.
	 *
	 * @param lastName the last name of this creator
	 */
	@Override
	public void setLastName(String lastName) {
		_creator.setLastName(lastName);
	}

	/**
	 * Sets the middle name of this creator.
	 *
	 * @param middleName the middle name of this creator
	 */
	@Override
	public void setMiddleName(String middleName) {
		_creator.setMiddleName(middleName);
	}

	/**
	 * Sets the modified date of this creator.
	 *
	 * @param modifiedDate the modified date of this creator
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_creator.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_creator.setNew(n);
	}

	/**
	 * Sets the primary key of this creator.
	 *
	 * @param primaryKey the primary key of this creator
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_creator.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_creator.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this creator.
	 *
	 * @param userId the user ID of this creator
	 */
	@Override
	public void setUserId(long userId) {
		_creator.setUserId(userId);
	}

	/**
	 * Sets the user name of this creator.
	 *
	 * @param userName the user name of this creator
	 */
	@Override
	public void setUserName(String userName) {
		_creator.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this creator.
	 *
	 * @param userUuid the user uuid of this creator
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_creator.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Creator> toCacheModel() {

		return _creator.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Creator toEscapedModel() {
		return new CreatorWrapper(_creator.toEscapedModel());
	}

	@Override
	public String toString() {
		return _creator.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Creator toUnescapedModel() {
		return new CreatorWrapper(_creator.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _creator.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreatorWrapper)) {
			return false;
		}

		CreatorWrapper creatorWrapper = (CreatorWrapper)obj;

		if (Objects.equals(_creator, creatorWrapper._creator)) {
			return true;
		}

		return false;
	}

	@Override
	public Creator getWrappedModel() {
		return _creator;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _creator.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _creator.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_creator.resetOriginalValues();
	}

	private final Creator _creator;

}