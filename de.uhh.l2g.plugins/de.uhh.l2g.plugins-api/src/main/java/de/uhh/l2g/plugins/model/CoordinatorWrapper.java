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
 * This class is a wrapper for {@link Coordinator}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Coordinator
 * @generated
 */
@ProviderType
public class CoordinatorWrapper implements Coordinator,
	ModelWrapper<Coordinator> {
	public CoordinatorWrapper(Coordinator coordinator) {
		_coordinator = coordinator;
	}

	@Override
	public Class<?> getModelClass() {
		return Coordinator.class;
	}

	@Override
	public String getModelClassName() {
		return Coordinator.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("coordinatorId", getCoordinatorId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("officeId", getOfficeId());
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
		Long coordinatorId = (Long)attributes.get("coordinatorId");

		if (coordinatorId != null) {
			setCoordinatorId(coordinatorId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
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
	public boolean isCachedModel() {
		return _coordinator.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _coordinator.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _coordinator.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _coordinator.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.uhh.l2g.plugins.model.Coordinator> toCacheModel() {
		return _coordinator.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Coordinator toEscapedModel() {
		return new CoordinatorWrapper(_coordinator.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Coordinator toUnescapedModel() {
		return new CoordinatorWrapper(_coordinator.toUnescapedModel());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Coordinator coordinator) {
		return _coordinator.compareTo(coordinator);
	}

	@Override
	public int hashCode() {
		return _coordinator.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _coordinator.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CoordinatorWrapper((Coordinator)_coordinator.clone());
	}

	@Override
	public java.lang.String getEmailAddress() {
		return _coordinator.getEmailAddress();
	}

	@Override
	public java.lang.String getFirstName() {
		return _coordinator.getFirstName();
	}

	@Override
	public java.lang.String getLastName() {
		return _coordinator.getLastName();
	}

	/**
	* Returns the user name of this coordinator.
	*
	* @return the user name of this coordinator
	*/
	@Override
	public java.lang.String getUserName() {
		return _coordinator.getUserName();
	}

	/**
	* Returns the user uuid of this coordinator.
	*
	* @return the user uuid of this coordinator
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _coordinator.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _coordinator.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _coordinator.toXmlString();
	}

	/**
	* Returns the create date of this coordinator.
	*
	* @return the create date of this coordinator
	*/
	@Override
	public Date getCreateDate() {
		return _coordinator.getCreateDate();
	}

	@Override
	public Date getLastLoginDate() {
		return _coordinator.getLastLoginDate();
	}

	/**
	* Returns the modified date of this coordinator.
	*
	* @return the modified date of this coordinator
	*/
	@Override
	public Date getModifiedDate() {
		return _coordinator.getModifiedDate();
	}

	/**
	* Returns the company ID of this coordinator.
	*
	* @return the company ID of this coordinator
	*/
	@Override
	public long getCompanyId() {
		return _coordinator.getCompanyId();
	}

	/**
	* Returns the coordinator ID of this coordinator.
	*
	* @return the coordinator ID of this coordinator
	*/
	@Override
	public long getCoordinatorId() {
		return _coordinator.getCoordinatorId();
	}

	/**
	* Returns the group ID of this coordinator.
	*
	* @return the group ID of this coordinator
	*/
	@Override
	public long getGroupId() {
		return _coordinator.getGroupId();
	}

	/**
	* Returns the institution ID of this coordinator.
	*
	* @return the institution ID of this coordinator
	*/
	@Override
	public long getInstitutionId() {
		return _coordinator.getInstitutionId();
	}

	/**
	* Returns the office ID of this coordinator.
	*
	* @return the office ID of this coordinator
	*/
	@Override
	public long getOfficeId() {
		return _coordinator.getOfficeId();
	}

	/**
	* Returns the primary key of this coordinator.
	*
	* @return the primary key of this coordinator
	*/
	@Override
	public long getPrimaryKey() {
		return _coordinator.getPrimaryKey();
	}

	/**
	* Returns the user ID of this coordinator.
	*
	* @return the user ID of this coordinator
	*/
	@Override
	public long getUserId() {
		return _coordinator.getUserId();
	}

	@Override
	public void persist() {
		_coordinator.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_coordinator.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this coordinator.
	*
	* @param companyId the company ID of this coordinator
	*/
	@Override
	public void setCompanyId(long companyId) {
		_coordinator.setCompanyId(companyId);
	}

	/**
	* Sets the coordinator ID of this coordinator.
	*
	* @param coordinatorId the coordinator ID of this coordinator
	*/
	@Override
	public void setCoordinatorId(long coordinatorId) {
		_coordinator.setCoordinatorId(coordinatorId);
	}

	/**
	* Sets the create date of this coordinator.
	*
	* @param createDate the create date of this coordinator
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_coordinator.setCreateDate(createDate);
	}

	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_coordinator.setEmailAddress(emailAddress);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_coordinator.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_coordinator.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_coordinator.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setFirstName(java.lang.String firstName) {
		_coordinator.setFirstName(firstName);
	}

	/**
	* Sets the group ID of this coordinator.
	*
	* @param groupId the group ID of this coordinator
	*/
	@Override
	public void setGroupId(long groupId) {
		_coordinator.setGroupId(groupId);
	}

	/**
	* Sets the institution ID of this coordinator.
	*
	* @param institutionId the institution ID of this coordinator
	*/
	@Override
	public void setInstitutionId(long institutionId) {
		_coordinator.setInstitutionId(institutionId);
	}

	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		_coordinator.setLastLoginDate(lastLoginDate);
	}

	@Override
	public void setLastName(java.lang.String lastName) {
		_coordinator.setLastName(lastName);
	}

	/**
	* Sets the modified date of this coordinator.
	*
	* @param modifiedDate the modified date of this coordinator
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_coordinator.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_coordinator.setNew(n);
	}

	/**
	* Sets the office ID of this coordinator.
	*
	* @param officeId the office ID of this coordinator
	*/
	@Override
	public void setOfficeId(long officeId) {
		_coordinator.setOfficeId(officeId);
	}

	/**
	* Sets the primary key of this coordinator.
	*
	* @param primaryKey the primary key of this coordinator
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_coordinator.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_coordinator.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this coordinator.
	*
	* @param userId the user ID of this coordinator
	*/
	@Override
	public void setUserId(long userId) {
		_coordinator.setUserId(userId);
	}

	/**
	* Sets the user name of this coordinator.
	*
	* @param userName the user name of this coordinator
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_coordinator.setUserName(userName);
	}

	/**
	* Sets the user uuid of this coordinator.
	*
	* @param userUuid the user uuid of this coordinator
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_coordinator.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CoordinatorWrapper)) {
			return false;
		}

		CoordinatorWrapper coordinatorWrapper = (CoordinatorWrapper)obj;

		if (Objects.equals(_coordinator, coordinatorWrapper._coordinator)) {
			return true;
		}

		return false;
	}

	@Override
	public Coordinator getWrappedModel() {
		return _coordinator;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _coordinator.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _coordinator.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_coordinator.resetOriginalValues();
	}

	private final Coordinator _coordinator;
}