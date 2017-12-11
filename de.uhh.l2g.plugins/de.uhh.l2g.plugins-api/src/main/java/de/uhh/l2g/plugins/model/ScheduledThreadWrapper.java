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
 * This class is a wrapper for {@link ScheduledThread}.
 * </p>
 *
 * @author Iavor Sturm
 * @see ScheduledThread
 * @generated
 */
@ProviderType
public class ScheduledThreadWrapper implements ScheduledThread,
	ModelWrapper<ScheduledThread> {
	public ScheduledThreadWrapper(ScheduledThread scheduledThread) {
		_scheduledThread = scheduledThread;
	}

	@Override
	public Class<?> getModelClass() {
		return ScheduledThread.class;
	}

	@Override
	public String getModelClassName() {
		return ScheduledThread.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scheduledThreadId", getScheduledThreadId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("schedulerClassName", getSchedulerClassName());
		attributes.put("cronText", getCronText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scheduledThreadId = (Long)attributes.get("scheduledThreadId");

		if (scheduledThreadId != null) {
			setScheduledThreadId(scheduledThreadId);
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

		String schedulerClassName = (String)attributes.get("schedulerClassName");

		if (schedulerClassName != null) {
			setSchedulerClassName(schedulerClassName);
		}

		String cronText = (String)attributes.get("cronText");

		if (cronText != null) {
			setCronText(cronText);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _scheduledThread.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _scheduledThread.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _scheduledThread.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _scheduledThread.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.uhh.l2g.plugins.model.ScheduledThread> toCacheModel() {
		return _scheduledThread.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread toEscapedModel() {
		return new ScheduledThreadWrapper(_scheduledThread.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread toUnescapedModel() {
		return new ScheduledThreadWrapper(_scheduledThread.toUnescapedModel());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread) {
		return _scheduledThread.compareTo(scheduledThread);
	}

	@Override
	public int hashCode() {
		return _scheduledThread.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scheduledThread.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ScheduledThreadWrapper((ScheduledThread)_scheduledThread.clone());
	}

	/**
	* Returns the cron text of this scheduled thread.
	*
	* @return the cron text of this scheduled thread
	*/
	@Override
	public java.lang.String getCronText() {
		return _scheduledThread.getCronText();
	}

	/**
	* Returns the scheduler class name of this scheduled thread.
	*
	* @return the scheduler class name of this scheduled thread
	*/
	@Override
	public java.lang.String getSchedulerClassName() {
		return _scheduledThread.getSchedulerClassName();
	}

	/**
	* Returns the user name of this scheduled thread.
	*
	* @return the user name of this scheduled thread
	*/
	@Override
	public java.lang.String getUserName() {
		return _scheduledThread.getUserName();
	}

	/**
	* Returns the user uuid of this scheduled thread.
	*
	* @return the user uuid of this scheduled thread
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _scheduledThread.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _scheduledThread.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scheduledThread.toXmlString();
	}

	/**
	* Returns the create date of this scheduled thread.
	*
	* @return the create date of this scheduled thread
	*/
	@Override
	public Date getCreateDate() {
		return _scheduledThread.getCreateDate();
	}

	/**
	* Returns the modified date of this scheduled thread.
	*
	* @return the modified date of this scheduled thread
	*/
	@Override
	public Date getModifiedDate() {
		return _scheduledThread.getModifiedDate();
	}

	/**
	* Returns the company ID of this scheduled thread.
	*
	* @return the company ID of this scheduled thread
	*/
	@Override
	public long getCompanyId() {
		return _scheduledThread.getCompanyId();
	}

	/**
	* Returns the group ID of this scheduled thread.
	*
	* @return the group ID of this scheduled thread
	*/
	@Override
	public long getGroupId() {
		return _scheduledThread.getGroupId();
	}

	/**
	* Returns the primary key of this scheduled thread.
	*
	* @return the primary key of this scheduled thread
	*/
	@Override
	public long getPrimaryKey() {
		return _scheduledThread.getPrimaryKey();
	}

	/**
	* Returns the scheduled thread ID of this scheduled thread.
	*
	* @return the scheduled thread ID of this scheduled thread
	*/
	@Override
	public long getScheduledThreadId() {
		return _scheduledThread.getScheduledThreadId();
	}

	/**
	* Returns the user ID of this scheduled thread.
	*
	* @return the user ID of this scheduled thread
	*/
	@Override
	public long getUserId() {
		return _scheduledThread.getUserId();
	}

	@Override
	public void persist() {
		_scheduledThread.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scheduledThread.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this scheduled thread.
	*
	* @param companyId the company ID of this scheduled thread
	*/
	@Override
	public void setCompanyId(long companyId) {
		_scheduledThread.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this scheduled thread.
	*
	* @param createDate the create date of this scheduled thread
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_scheduledThread.setCreateDate(createDate);
	}

	/**
	* Sets the cron text of this scheduled thread.
	*
	* @param cronText the cron text of this scheduled thread
	*/
	@Override
	public void setCronText(java.lang.String cronText) {
		_scheduledThread.setCronText(cronText);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_scheduledThread.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_scheduledThread.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_scheduledThread.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this scheduled thread.
	*
	* @param groupId the group ID of this scheduled thread
	*/
	@Override
	public void setGroupId(long groupId) {
		_scheduledThread.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this scheduled thread.
	*
	* @param modifiedDate the modified date of this scheduled thread
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_scheduledThread.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_scheduledThread.setNew(n);
	}

	/**
	* Sets the primary key of this scheduled thread.
	*
	* @param primaryKey the primary key of this scheduled thread
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scheduledThread.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_scheduledThread.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the scheduled thread ID of this scheduled thread.
	*
	* @param scheduledThreadId the scheduled thread ID of this scheduled thread
	*/
	@Override
	public void setScheduledThreadId(long scheduledThreadId) {
		_scheduledThread.setScheduledThreadId(scheduledThreadId);
	}

	/**
	* Sets the scheduler class name of this scheduled thread.
	*
	* @param schedulerClassName the scheduler class name of this scheduled thread
	*/
	@Override
	public void setSchedulerClassName(java.lang.String schedulerClassName) {
		_scheduledThread.setSchedulerClassName(schedulerClassName);
	}

	/**
	* Sets the user ID of this scheduled thread.
	*
	* @param userId the user ID of this scheduled thread
	*/
	@Override
	public void setUserId(long userId) {
		_scheduledThread.setUserId(userId);
	}

	/**
	* Sets the user name of this scheduled thread.
	*
	* @param userName the user name of this scheduled thread
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_scheduledThread.setUserName(userName);
	}

	/**
	* Sets the user uuid of this scheduled thread.
	*
	* @param userUuid the user uuid of this scheduled thread
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_scheduledThread.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScheduledThreadWrapper)) {
			return false;
		}

		ScheduledThreadWrapper scheduledThreadWrapper = (ScheduledThreadWrapper)obj;

		if (Objects.equals(_scheduledThread,
					scheduledThreadWrapper._scheduledThread)) {
			return true;
		}

		return false;
	}

	@Override
	public ScheduledThread getWrappedModel() {
		return _scheduledThread;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _scheduledThread.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _scheduledThread.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_scheduledThread.resetOriginalValues();
	}

	private final ScheduledThread _scheduledThread;
}