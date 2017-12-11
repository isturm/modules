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
	public java.lang.String toString() {
		return _coordinator.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _coordinator.toXmlString();
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

	@Override
	public void persist() {
		_coordinator.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_coordinator.setCachedModel(cachedModel);
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