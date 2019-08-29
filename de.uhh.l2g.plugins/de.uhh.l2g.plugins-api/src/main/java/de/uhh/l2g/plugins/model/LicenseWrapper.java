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
 * This class is a wrapper for {@link License}.
 * </p>
 *
 * @author Iavor Sturm
 * @see License
 * @generated
 */
@ProviderType
public class LicenseWrapper implements License, ModelWrapper<License> {

	public LicenseWrapper(License license) {
		_license = license;
	}

	@Override
	public Class<?> getModelClass() {
		return License.class;
	}

	@Override
	public String getModelClassName() {
		return License.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("licenseId", getLicenseId());
		attributes.put("videoId", getVideoId());
		attributes.put("ccby", getCcby());
		attributes.put("ccbybc", getCcbybc());
		attributes.put("ccbyncnd", getCcbyncnd());
		attributes.put("ccbyncsa", getCcbyncsa());
		attributes.put("ccbysa", getCcbysa());
		attributes.put("ccbync", getCcbync());
		attributes.put("l2go", getL2go());
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
		Long licenseId = (Long)attributes.get("licenseId");

		if (licenseId != null) {
			setLicenseId(licenseId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Integer ccby = (Integer)attributes.get("ccby");

		if (ccby != null) {
			setCcby(ccby);
		}

		Integer ccbybc = (Integer)attributes.get("ccbybc");

		if (ccbybc != null) {
			setCcbybc(ccbybc);
		}

		Integer ccbyncnd = (Integer)attributes.get("ccbyncnd");

		if (ccbyncnd != null) {
			setCcbyncnd(ccbyncnd);
		}

		Integer ccbyncsa = (Integer)attributes.get("ccbyncsa");

		if (ccbyncsa != null) {
			setCcbyncsa(ccbyncsa);
		}

		Integer ccbysa = (Integer)attributes.get("ccbysa");

		if (ccbysa != null) {
			setCcbysa(ccbysa);
		}

		Integer ccbync = (Integer)attributes.get("ccbync");

		if (ccbync != null) {
			setCcbync(ccbync);
		}

		Integer l2go = (Integer)attributes.get("l2go");

		if (l2go != null) {
			setL2go(l2go);
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
		return new LicenseWrapper((License)_license.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.License license) {
		return _license.compareTo(license);
	}

	/**
	 * Returns the ccby of this license.
	 *
	 * @return the ccby of this license
	 */
	@Override
	public int getCcby() {
		return _license.getCcby();
	}

	/**
	 * Returns the ccbybc of this license.
	 *
	 * @return the ccbybc of this license
	 */
	@Override
	public int getCcbybc() {
		return _license.getCcbybc();
	}

	/**
	 * Returns the ccbync of this license.
	 *
	 * @return the ccbync of this license
	 */
	@Override
	public int getCcbync() {
		return _license.getCcbync();
	}

	/**
	 * Returns the ccbyncnd of this license.
	 *
	 * @return the ccbyncnd of this license
	 */
	@Override
	public int getCcbyncnd() {
		return _license.getCcbyncnd();
	}

	/**
	 * Returns the ccbyncsa of this license.
	 *
	 * @return the ccbyncsa of this license
	 */
	@Override
	public int getCcbyncsa() {
		return _license.getCcbyncsa();
	}

	/**
	 * Returns the ccbysa of this license.
	 *
	 * @return the ccbysa of this license
	 */
	@Override
	public int getCcbysa() {
		return _license.getCcbysa();
	}

	/**
	 * Returns the company ID of this license.
	 *
	 * @return the company ID of this license
	 */
	@Override
	public long getCompanyId() {
		return _license.getCompanyId();
	}

	/**
	 * Returns the create date of this license.
	 *
	 * @return the create date of this license
	 */
	@Override
	public Date getCreateDate() {
		return _license.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _license.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this license.
	 *
	 * @return the group ID of this license
	 */
	@Override
	public long getGroupId() {
		return _license.getGroupId();
	}

	/**
	 * Returns the l2go of this license.
	 *
	 * @return the l2go of this license
	 */
	@Override
	public int getL2go() {
		return _license.getL2go();
	}

	/**
	 * Returns the license ID of this license.
	 *
	 * @return the license ID of this license
	 */
	@Override
	public long getLicenseId() {
		return _license.getLicenseId();
	}

	/**
	 * Returns the modified date of this license.
	 *
	 * @return the modified date of this license
	 */
	@Override
	public Date getModifiedDate() {
		return _license.getModifiedDate();
	}

	/**
	 * Returns the primary key of this license.
	 *
	 * @return the primary key of this license
	 */
	@Override
	public long getPrimaryKey() {
		return _license.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _license.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this license.
	 *
	 * @return the user ID of this license
	 */
	@Override
	public long getUserId() {
		return _license.getUserId();
	}

	/**
	 * Returns the user name of this license.
	 *
	 * @return the user name of this license
	 */
	@Override
	public String getUserName() {
		return _license.getUserName();
	}

	/**
	 * Returns the user uuid of this license.
	 *
	 * @return the user uuid of this license
	 */
	@Override
	public String getUserUuid() {
		return _license.getUserUuid();
	}

	/**
	 * Returns the video ID of this license.
	 *
	 * @return the video ID of this license
	 */
	@Override
	public long getVideoId() {
		return _license.getVideoId();
	}

	@Override
	public int hashCode() {
		return _license.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _license.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _license.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _license.isNew();
	}

	@Override
	public void persist() {
		_license.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_license.setCachedModel(cachedModel);
	}

	/**
	 * Sets the ccby of this license.
	 *
	 * @param ccby the ccby of this license
	 */
	@Override
	public void setCcby(int ccby) {
		_license.setCcby(ccby);
	}

	/**
	 * Sets the ccbybc of this license.
	 *
	 * @param ccbybc the ccbybc of this license
	 */
	@Override
	public void setCcbybc(int ccbybc) {
		_license.setCcbybc(ccbybc);
	}

	/**
	 * Sets the ccbync of this license.
	 *
	 * @param ccbync the ccbync of this license
	 */
	@Override
	public void setCcbync(int ccbync) {
		_license.setCcbync(ccbync);
	}

	/**
	 * Sets the ccbyncnd of this license.
	 *
	 * @param ccbyncnd the ccbyncnd of this license
	 */
	@Override
	public void setCcbyncnd(int ccbyncnd) {
		_license.setCcbyncnd(ccbyncnd);
	}

	/**
	 * Sets the ccbyncsa of this license.
	 *
	 * @param ccbyncsa the ccbyncsa of this license
	 */
	@Override
	public void setCcbyncsa(int ccbyncsa) {
		_license.setCcbyncsa(ccbyncsa);
	}

	/**
	 * Sets the ccbysa of this license.
	 *
	 * @param ccbysa the ccbysa of this license
	 */
	@Override
	public void setCcbysa(int ccbysa) {
		_license.setCcbysa(ccbysa);
	}

	/**
	 * Sets the company ID of this license.
	 *
	 * @param companyId the company ID of this license
	 */
	@Override
	public void setCompanyId(long companyId) {
		_license.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this license.
	 *
	 * @param createDate the create date of this license
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_license.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_license.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_license.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_license.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this license.
	 *
	 * @param groupId the group ID of this license
	 */
	@Override
	public void setGroupId(long groupId) {
		_license.setGroupId(groupId);
	}

	/**
	 * Sets the l2go of this license.
	 *
	 * @param l2go the l2go of this license
	 */
	@Override
	public void setL2go(int l2go) {
		_license.setL2go(l2go);
	}

	/**
	 * Sets the license ID of this license.
	 *
	 * @param licenseId the license ID of this license
	 */
	@Override
	public void setLicenseId(long licenseId) {
		_license.setLicenseId(licenseId);
	}

	/**
	 * Sets the modified date of this license.
	 *
	 * @param modifiedDate the modified date of this license
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_license.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_license.setNew(n);
	}

	/**
	 * Sets the primary key of this license.
	 *
	 * @param primaryKey the primary key of this license
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_license.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_license.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this license.
	 *
	 * @param userId the user ID of this license
	 */
	@Override
	public void setUserId(long userId) {
		_license.setUserId(userId);
	}

	/**
	 * Sets the user name of this license.
	 *
	 * @param userName the user name of this license
	 */
	@Override
	public void setUserName(String userName) {
		_license.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this license.
	 *
	 * @param userUuid the user uuid of this license
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_license.setUserUuid(userUuid);
	}

	/**
	 * Sets the video ID of this license.
	 *
	 * @param videoId the video ID of this license
	 */
	@Override
	public void setVideoId(long videoId) {
		_license.setVideoId(videoId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.License> toCacheModel() {

		return _license.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.License toEscapedModel() {
		return new LicenseWrapper(_license.toEscapedModel());
	}

	@Override
	public String toString() {
		return _license.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.License toUnescapedModel() {
		return new LicenseWrapper(_license.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _license.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LicenseWrapper)) {
			return false;
		}

		LicenseWrapper licenseWrapper = (LicenseWrapper)obj;

		if (Objects.equals(_license, licenseWrapper._license)) {
			return true;
		}

		return false;
	}

	@Override
	public License getWrappedModel() {
		return _license;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _license.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _license.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_license.resetOriginalValues();
	}

	private final License _license;

}