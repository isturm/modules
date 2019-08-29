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
 * This class is a wrapper for {@link Sys}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Sys
 * @generated
 */
@ProviderType
public class SysWrapper implements Sys, ModelWrapper<Sys> {

	public SysWrapper(Sys sys) {
		_sys = sys;
	}

	@Override
	public Class<?> getModelClass() {
		return Sys.class;
	}

	@Override
	public String getModelClassName() {
		return Sys.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sysId", getSysId());
		attributes.put("version", getVersion());
		attributes.put("setupWizard", getSetupWizard());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer sysId = (Integer)attributes.get("sysId");

		if (sysId != null) {
			setSysId(sysId);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Integer setupWizard = (Integer)attributes.get("setupWizard");

		if (setupWizard != null) {
			setSetupWizard(setupWizard);
		}
	}

	@Override
	public Object clone() {
		return new SysWrapper((Sys)_sys.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Sys sys) {
		return _sys.compareTo(sys);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sys.getExpandoBridge();
	}

	/**
	 * Returns the primary key of this sys.
	 *
	 * @return the primary key of this sys
	 */
	@Override
	public int getPrimaryKey() {
		return _sys.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sys.getPrimaryKeyObj();
	}

	/**
	 * Returns the setup wizard of this sys.
	 *
	 * @return the setup wizard of this sys
	 */
	@Override
	public int getSetupWizard() {
		return _sys.getSetupWizard();
	}

	/**
	 * Returns the sys ID of this sys.
	 *
	 * @return the sys ID of this sys
	 */
	@Override
	public int getSysId() {
		return _sys.getSysId();
	}

	/**
	 * Returns the version of this sys.
	 *
	 * @return the version of this sys
	 */
	@Override
	public String getVersion() {
		return _sys.getVersion();
	}

	@Override
	public int hashCode() {
		return _sys.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _sys.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _sys.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _sys.isNew();
	}

	@Override
	public void persist() {
		_sys.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sys.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_sys.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sys.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sys.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_sys.setNew(n);
	}

	/**
	 * Sets the primary key of this sys.
	 *
	 * @param primaryKey the primary key of this sys
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		_sys.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sys.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the setup wizard of this sys.
	 *
	 * @param setupWizard the setup wizard of this sys
	 */
	@Override
	public void setSetupWizard(int setupWizard) {
		_sys.setSetupWizard(setupWizard);
	}

	/**
	 * Sets the sys ID of this sys.
	 *
	 * @param sysId the sys ID of this sys
	 */
	@Override
	public void setSysId(int sysId) {
		_sys.setSysId(sysId);
	}

	/**
	 * Sets the version of this sys.
	 *
	 * @param version the version of this sys
	 */
	@Override
	public void setVersion(String version) {
		_sys.setVersion(version);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Sys> toCacheModel() {

		return _sys.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Sys toEscapedModel() {
		return new SysWrapper(_sys.toEscapedModel());
	}

	@Override
	public String toString() {
		return _sys.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Sys toUnescapedModel() {
		return new SysWrapper(_sys.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _sys.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SysWrapper)) {
			return false;
		}

		SysWrapper sysWrapper = (SysWrapper)obj;

		if (Objects.equals(_sys, sysWrapper._sys)) {
			return true;
		}

		return false;
	}

	@Override
	public Sys getWrappedModel() {
		return _sys;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sys.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sys.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sys.resetOriginalValues();
	}

	private final Sys _sys;

}