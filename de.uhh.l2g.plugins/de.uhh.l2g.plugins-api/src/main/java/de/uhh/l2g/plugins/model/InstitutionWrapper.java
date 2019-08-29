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
 * This class is a wrapper for {@link Institution}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution
 * @generated
 */
@ProviderType
public class InstitutionWrapper
	implements Institution, ModelWrapper<Institution> {

	public InstitutionWrapper(Institution institution) {
		_institution = institution;
	}

	@Override
	public Class<?> getModelClass() {
		return Institution.class;
	}

	@Override
	public String getModelClassName() {
		return Institution.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("institutionId", getInstitutionId());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("typ", getTyp());
		attributes.put("www", getWww());
		attributes.put("level", getLevel());
		attributes.put("sort", getSort());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String typ = (String)attributes.get("typ");

		if (typ != null) {
			setTyp(typ);
		}

		String www = (String)attributes.get("www");

		if (www != null) {
			setWww(www);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Integer sort = (Integer)attributes.get("sort");

		if (sort != null) {
			setSort(sort);
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
		return new InstitutionWrapper((Institution)_institution.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Institution institution) {
		return _institution.compareTo(institution);
	}

	/**
	 * Returns the company ID of this institution.
	 *
	 * @return the company ID of this institution
	 */
	@Override
	public long getCompanyId() {
		return _institution.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _institution.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this institution.
	 *
	 * @return the group ID of this institution
	 */
	@Override
	public long getGroupId() {
		return _institution.getGroupId();
	}

	/**
	 * Returns the institution ID of this institution.
	 *
	 * @return the institution ID of this institution
	 */
	@Override
	public long getInstitutionId() {
		return _institution.getInstitutionId();
	}

	/**
	 * Returns the level of this institution.
	 *
	 * @return the level of this institution
	 */
	@Override
	public int getLevel() {
		return _institution.getLevel();
	}

	/**
	 * Returns the name of this institution.
	 *
	 * @return the name of this institution
	 */
	@Override
	public String getName() {
		return _institution.getName();
	}

	/**
	 * Returns the parent ID of this institution.
	 *
	 * @return the parent ID of this institution
	 */
	@Override
	public long getParentId() {
		return _institution.getParentId();
	}

	@Override
	public String getPath() {
		return _institution.getPath();
	}

	/**
	 * Returns the primary key of this institution.
	 *
	 * @return the primary key of this institution
	 */
	@Override
	public long getPrimaryKey() {
		return _institution.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _institution.getPrimaryKeyObj();
	}

	/**
	 * Returns the sort of this institution.
	 *
	 * @return the sort of this institution
	 */
	@Override
	public int getSort() {
		return _institution.getSort();
	}

	/**
	 * Returns the typ of this institution.
	 *
	 * @return the typ of this institution
	 */
	@Override
	public String getTyp() {
		return _institution.getTyp();
	}

	/**
	 * Returns the www of this institution.
	 *
	 * @return the www of this institution
	 */
	@Override
	public String getWww() {
		return _institution.getWww();
	}

	@Override
	public int hashCode() {
		return _institution.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _institution.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _institution.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _institution.isNew();
	}

	@Override
	public void persist() {
		_institution.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_institution.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this institution.
	 *
	 * @param companyId the company ID of this institution
	 */
	@Override
	public void setCompanyId(long companyId) {
		_institution.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_institution.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_institution.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_institution.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this institution.
	 *
	 * @param groupId the group ID of this institution
	 */
	@Override
	public void setGroupId(long groupId) {
		_institution.setGroupId(groupId);
	}

	/**
	 * Sets the institution ID of this institution.
	 *
	 * @param institutionId the institution ID of this institution
	 */
	@Override
	public void setInstitutionId(long institutionId) {
		_institution.setInstitutionId(institutionId);
	}

	/**
	 * Sets the level of this institution.
	 *
	 * @param level the level of this institution
	 */
	@Override
	public void setLevel(int level) {
		_institution.setLevel(level);
	}

	/**
	 * Sets the name of this institution.
	 *
	 * @param name the name of this institution
	 */
	@Override
	public void setName(String name) {
		_institution.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_institution.setNew(n);
	}

	/**
	 * Sets the parent ID of this institution.
	 *
	 * @param parentId the parent ID of this institution
	 */
	@Override
	public void setParentId(long parentId) {
		_institution.setParentId(parentId);
	}

	@Override
	public void setPath(String path) {
		_institution.setPath(path);
	}

	/**
	 * Sets the primary key of this institution.
	 *
	 * @param primaryKey the primary key of this institution
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_institution.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_institution.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the sort of this institution.
	 *
	 * @param sort the sort of this institution
	 */
	@Override
	public void setSort(int sort) {
		_institution.setSort(sort);
	}

	/**
	 * Sets the typ of this institution.
	 *
	 * @param typ the typ of this institution
	 */
	@Override
	public void setTyp(String typ) {
		_institution.setTyp(typ);
	}

	/**
	 * Sets the www of this institution.
	 *
	 * @param www the www of this institution
	 */
	@Override
	public void setWww(String www) {
		_institution.setWww(www);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Institution> toCacheModel() {

		return _institution.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution toEscapedModel() {
		return new InstitutionWrapper(_institution.toEscapedModel());
	}

	@Override
	public String toString() {
		return _institution.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution toUnescapedModel() {
		return new InstitutionWrapper(_institution.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _institution.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InstitutionWrapper)) {
			return false;
		}

		InstitutionWrapper institutionWrapper = (InstitutionWrapper)obj;

		if (Objects.equals(_institution, institutionWrapper._institution)) {
			return true;
		}

		return false;
	}

	@Override
	public Institution getWrappedModel() {
		return _institution;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _institution.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _institution.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_institution.resetOriginalValues();
	}

	private final Institution _institution;

}