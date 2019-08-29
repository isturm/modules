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
 * This class is a wrapper for {@link Institution_Host}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution_Host
 * @generated
 */
@ProviderType
public class Institution_HostWrapper
	implements Institution_Host, ModelWrapper<Institution_Host> {

	public Institution_HostWrapper(Institution_Host institution_Host) {
		_institution_Host = institution_Host;
	}

	@Override
	public Class<?> getModelClass() {
		return Institution_Host.class;
	}

	@Override
	public String getModelClassName() {
		return Institution_Host.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("institutionHostId", getInstitutionHostId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("hostId", getHostId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long institutionHostId = (Long)attributes.get("institutionHostId");

		if (institutionHostId != null) {
			setInstitutionHostId(institutionHostId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public Object clone() {
		return new Institution_HostWrapper(
			(Institution_Host)_institution_Host.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Institution_Host institution_Host) {

		return _institution_Host.compareTo(institution_Host);
	}

	/**
	 * Returns the company ID of this institution_ host.
	 *
	 * @return the company ID of this institution_ host
	 */
	@Override
	public long getCompanyId() {
		return _institution_Host.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _institution_Host.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this institution_ host.
	 *
	 * @return the group ID of this institution_ host
	 */
	@Override
	public long getGroupId() {
		return _institution_Host.getGroupId();
	}

	/**
	 * Returns the host ID of this institution_ host.
	 *
	 * @return the host ID of this institution_ host
	 */
	@Override
	public long getHostId() {
		return _institution_Host.getHostId();
	}

	/**
	 * Returns the institution host ID of this institution_ host.
	 *
	 * @return the institution host ID of this institution_ host
	 */
	@Override
	public long getInstitutionHostId() {
		return _institution_Host.getInstitutionHostId();
	}

	/**
	 * Returns the institution ID of this institution_ host.
	 *
	 * @return the institution ID of this institution_ host
	 */
	@Override
	public long getInstitutionId() {
		return _institution_Host.getInstitutionId();
	}

	/**
	 * Returns the primary key of this institution_ host.
	 *
	 * @return the primary key of this institution_ host
	 */
	@Override
	public long getPrimaryKey() {
		return _institution_Host.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _institution_Host.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _institution_Host.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _institution_Host.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _institution_Host.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _institution_Host.isNew();
	}

	@Override
	public void persist() {
		_institution_Host.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_institution_Host.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this institution_ host.
	 *
	 * @param companyId the company ID of this institution_ host
	 */
	@Override
	public void setCompanyId(long companyId) {
		_institution_Host.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_institution_Host.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_institution_Host.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_institution_Host.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this institution_ host.
	 *
	 * @param groupId the group ID of this institution_ host
	 */
	@Override
	public void setGroupId(long groupId) {
		_institution_Host.setGroupId(groupId);
	}

	/**
	 * Sets the host ID of this institution_ host.
	 *
	 * @param hostId the host ID of this institution_ host
	 */
	@Override
	public void setHostId(long hostId) {
		_institution_Host.setHostId(hostId);
	}

	/**
	 * Sets the institution host ID of this institution_ host.
	 *
	 * @param institutionHostId the institution host ID of this institution_ host
	 */
	@Override
	public void setInstitutionHostId(long institutionHostId) {
		_institution_Host.setInstitutionHostId(institutionHostId);
	}

	/**
	 * Sets the institution ID of this institution_ host.
	 *
	 * @param institutionId the institution ID of this institution_ host
	 */
	@Override
	public void setInstitutionId(long institutionId) {
		_institution_Host.setInstitutionId(institutionId);
	}

	@Override
	public void setNew(boolean n) {
		_institution_Host.setNew(n);
	}

	/**
	 * Sets the primary key of this institution_ host.
	 *
	 * @param primaryKey the primary key of this institution_ host
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_institution_Host.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_institution_Host.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Institution_Host> toCacheModel() {

		return _institution_Host.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution_Host toEscapedModel() {
		return new Institution_HostWrapper(_institution_Host.toEscapedModel());
	}

	@Override
	public String toString() {
		return _institution_Host.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution_Host toUnescapedModel() {
		return new Institution_HostWrapper(
			_institution_Host.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _institution_Host.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Institution_HostWrapper)) {
			return false;
		}

		Institution_HostWrapper institution_HostWrapper =
			(Institution_HostWrapper)obj;

		if (Objects.equals(
				_institution_Host, institution_HostWrapper._institution_Host)) {

			return true;
		}

		return false;
	}

	@Override
	public Institution_Host getWrappedModel() {
		return _institution_Host;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _institution_Host.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _institution_Host.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_institution_Host.resetOriginalValues();
	}

	private final Institution_Host _institution_Host;

}