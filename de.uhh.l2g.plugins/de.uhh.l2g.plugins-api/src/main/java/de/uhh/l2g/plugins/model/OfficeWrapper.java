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
 * This class is a wrapper for {@link Office}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Office
 * @generated
 */
@ProviderType
public class OfficeWrapper implements Office, ModelWrapper<Office> {

	public OfficeWrapper(Office office) {
		_office = office;
	}

	@Override
	public Class<?> getModelClass() {
		return Office.class;
	}

	@Override
	public String getModelClassName() {
		return Office.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeId", getOfficeId());
		attributes.put("name", getName());
		attributes.put("www", getWww());
		attributes.put("email", getEmail());
		attributes.put("institutionId", getInstitutionId());
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
		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String www = (String)attributes.get("www");

		if (www != null) {
			setWww(www);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
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
		return new OfficeWrapper((Office)_office.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Office office) {
		return _office.compareTo(office);
	}

	/**
	 * Returns the company ID of this office.
	 *
	 * @return the company ID of this office
	 */
	@Override
	public long getCompanyId() {
		return _office.getCompanyId();
	}

	/**
	 * Returns the create date of this office.
	 *
	 * @return the create date of this office
	 */
	@Override
	public Date getCreateDate() {
		return _office.getCreateDate();
	}

	/**
	 * Returns the email of this office.
	 *
	 * @return the email of this office
	 */
	@Override
	public String getEmail() {
		return _office.getEmail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _office.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this office.
	 *
	 * @return the group ID of this office
	 */
	@Override
	public long getGroupId() {
		return _office.getGroupId();
	}

	/**
	 * Returns the institution ID of this office.
	 *
	 * @return the institution ID of this office
	 */
	@Override
	public long getInstitutionId() {
		return _office.getInstitutionId();
	}

	/**
	 * Returns the modified date of this office.
	 *
	 * @return the modified date of this office
	 */
	@Override
	public Date getModifiedDate() {
		return _office.getModifiedDate();
	}

	/**
	 * Returns the name of this office.
	 *
	 * @return the name of this office
	 */
	@Override
	public String getName() {
		return _office.getName();
	}

	/**
	 * Returns the office ID of this office.
	 *
	 * @return the office ID of this office
	 */
	@Override
	public long getOfficeId() {
		return _office.getOfficeId();
	}

	/**
	 * Returns the primary key of this office.
	 *
	 * @return the primary key of this office
	 */
	@Override
	public long getPrimaryKey() {
		return _office.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _office.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this office.
	 *
	 * @return the user ID of this office
	 */
	@Override
	public long getUserId() {
		return _office.getUserId();
	}

	/**
	 * Returns the user name of this office.
	 *
	 * @return the user name of this office
	 */
	@Override
	public String getUserName() {
		return _office.getUserName();
	}

	/**
	 * Returns the user uuid of this office.
	 *
	 * @return the user uuid of this office
	 */
	@Override
	public String getUserUuid() {
		return _office.getUserUuid();
	}

	/**
	 * Returns the www of this office.
	 *
	 * @return the www of this office
	 */
	@Override
	public String getWww() {
		return _office.getWww();
	}

	@Override
	public int hashCode() {
		return _office.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _office.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _office.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _office.isNew();
	}

	@Override
	public void persist() {
		_office.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_office.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this office.
	 *
	 * @param companyId the company ID of this office
	 */
	@Override
	public void setCompanyId(long companyId) {
		_office.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this office.
	 *
	 * @param createDate the create date of this office
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_office.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this office.
	 *
	 * @param email the email of this office
	 */
	@Override
	public void setEmail(String email) {
		_office.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_office.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_office.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_office.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this office.
	 *
	 * @param groupId the group ID of this office
	 */
	@Override
	public void setGroupId(long groupId) {
		_office.setGroupId(groupId);
	}

	/**
	 * Sets the institution ID of this office.
	 *
	 * @param institutionId the institution ID of this office
	 */
	@Override
	public void setInstitutionId(long institutionId) {
		_office.setInstitutionId(institutionId);
	}

	/**
	 * Sets the modified date of this office.
	 *
	 * @param modifiedDate the modified date of this office
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_office.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this office.
	 *
	 * @param name the name of this office
	 */
	@Override
	public void setName(String name) {
		_office.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_office.setNew(n);
	}

	/**
	 * Sets the office ID of this office.
	 *
	 * @param officeId the office ID of this office
	 */
	@Override
	public void setOfficeId(long officeId) {
		_office.setOfficeId(officeId);
	}

	/**
	 * Sets the primary key of this office.
	 *
	 * @param primaryKey the primary key of this office
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_office.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_office.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this office.
	 *
	 * @param userId the user ID of this office
	 */
	@Override
	public void setUserId(long userId) {
		_office.setUserId(userId);
	}

	/**
	 * Sets the user name of this office.
	 *
	 * @param userName the user name of this office
	 */
	@Override
	public void setUserName(String userName) {
		_office.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this office.
	 *
	 * @param userUuid the user uuid of this office
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_office.setUserUuid(userUuid);
	}

	/**
	 * Sets the www of this office.
	 *
	 * @param www the www of this office
	 */
	@Override
	public void setWww(String www) {
		_office.setWww(www);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Office> toCacheModel() {

		return _office.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Office toEscapedModel() {
		return new OfficeWrapper(_office.toEscapedModel());
	}

	@Override
	public String toString() {
		return _office.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Office toUnescapedModel() {
		return new OfficeWrapper(_office.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _office.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeWrapper)) {
			return false;
		}

		OfficeWrapper officeWrapper = (OfficeWrapper)obj;

		if (Objects.equals(_office, officeWrapper._office)) {
			return true;
		}

		return false;
	}

	@Override
	public Office getWrappedModel() {
		return _office;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _office.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _office.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_office.resetOriginalValues();
	}

	private final Office _office;

}