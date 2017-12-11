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
 * This class is a wrapper for {@link Producer}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer
 * @generated
 */
@ProviderType
public class ProducerWrapper implements Producer, ModelWrapper<Producer> {
	public ProducerWrapper(Producer producer) {
		_producer = producer;
	}

	@Override
	public Class<?> getModelClass() {
		return Producer.class;
	}

	@Override
	public String getModelClassName() {
		return Producer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("producerId", getProducerId());
		attributes.put("idNum", getIdNum());
		attributes.put("homeDir", getHomeDir());
		attributes.put("hostId", getHostId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("numberOfProductions", getNumberOfProductions());
		attributes.put("approved", getApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}

		String idNum = (String)attributes.get("idNum");

		if (idNum != null) {
			setIdNum(idNum);
		}

		String homeDir = (String)attributes.get("homeDir");

		if (homeDir != null) {
			setHomeDir(homeDir);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long numberOfProductions = (Long)attributes.get("numberOfProductions");

		if (numberOfProductions != null) {
			setNumberOfProductions(numberOfProductions);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _producer.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _producer.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _producer.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _producer.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.uhh.l2g.plugins.model.Producer> toCacheModel() {
		return _producer.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer toEscapedModel() {
		return new ProducerWrapper(_producer.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer toUnescapedModel() {
		return new ProducerWrapper(_producer.toUnescapedModel());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Producer producer) {
		return _producer.compareTo(producer);
	}

	/**
	* Returns the approved of this producer.
	*
	* @return the approved of this producer
	*/
	@Override
	public int getApproved() {
		return _producer.getApproved();
	}

	@Override
	public int hashCode() {
		return _producer.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _producer.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ProducerWrapper((Producer)_producer.clone());
	}

	@Override
	public java.lang.String getEmailAddress() {
		return _producer.getEmailAddress();
	}

	@Override
	public java.lang.String getFirstName() {
		return _producer.getFirstName();
	}

	/**
	* Returns the home dir of this producer.
	*
	* @return the home dir of this producer
	*/
	@Override
	public java.lang.String getHomeDir() {
		return _producer.getHomeDir();
	}

	/**
	* Returns the id num of this producer.
	*
	* @return the id num of this producer
	*/
	@Override
	public java.lang.String getIdNum() {
		return _producer.getIdNum();
	}

	@Override
	public java.lang.String getLastName() {
		return _producer.getLastName();
	}

	@Override
	public java.lang.String toString() {
		return _producer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _producer.toXmlString();
	}

	@Override
	public Date getLastLoginDate() {
		return _producer.getLastLoginDate();
	}

	/**
	* Returns the host ID of this producer.
	*
	* @return the host ID of this producer
	*/
	@Override
	public long getHostId() {
		return _producer.getHostId();
	}

	/**
	* Returns the institution ID of this producer.
	*
	* @return the institution ID of this producer
	*/
	@Override
	public long getInstitutionId() {
		return _producer.getInstitutionId();
	}

	/**
	* Returns the number of productions of this producer.
	*
	* @return the number of productions of this producer
	*/
	@Override
	public long getNumberOfProductions() {
		return _producer.getNumberOfProductions();
	}

	/**
	* Returns the primary key of this producer.
	*
	* @return the primary key of this producer
	*/
	@Override
	public long getPrimaryKey() {
		return _producer.getPrimaryKey();
	}

	/**
	* Returns the producer ID of this producer.
	*
	* @return the producer ID of this producer
	*/
	@Override
	public long getProducerId() {
		return _producer.getProducerId();
	}

	@Override
	public void persist() {
		_producer.persist();
	}

	/**
	* Sets the approved of this producer.
	*
	* @param approved the approved of this producer
	*/
	@Override
	public void setApproved(int approved) {
		_producer.setApproved(approved);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_producer.setCachedModel(cachedModel);
	}

	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_producer.setEmailAddress(emailAddress);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_producer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_producer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_producer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setFirstName(java.lang.String firstName) {
		_producer.setFirstName(firstName);
	}

	/**
	* Sets the home dir of this producer.
	*
	* @param homeDir the home dir of this producer
	*/
	@Override
	public void setHomeDir(java.lang.String homeDir) {
		_producer.setHomeDir(homeDir);
	}

	/**
	* Sets the host ID of this producer.
	*
	* @param hostId the host ID of this producer
	*/
	@Override
	public void setHostId(long hostId) {
		_producer.setHostId(hostId);
	}

	/**
	* Sets the id num of this producer.
	*
	* @param idNum the id num of this producer
	*/
	@Override
	public void setIdNum(java.lang.String idNum) {
		_producer.setIdNum(idNum);
	}

	/**
	* Sets the institution ID of this producer.
	*
	* @param institutionId the institution ID of this producer
	*/
	@Override
	public void setInstitutionId(long institutionId) {
		_producer.setInstitutionId(institutionId);
	}

	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		_producer.setLastLoginDate(lastLoginDate);
	}

	@Override
	public void setLastName(java.lang.String lastName) {
		_producer.setLastName(lastName);
	}

	@Override
	public void setNew(boolean n) {
		_producer.setNew(n);
	}

	/**
	* Sets the number of productions of this producer.
	*
	* @param numberOfProductions the number of productions of this producer
	*/
	@Override
	public void setNumberOfProductions(long numberOfProductions) {
		_producer.setNumberOfProductions(numberOfProductions);
	}

	/**
	* Sets the primary key of this producer.
	*
	* @param primaryKey the primary key of this producer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_producer.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_producer.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the producer ID of this producer.
	*
	* @param producerId the producer ID of this producer
	*/
	@Override
	public void setProducerId(long producerId) {
		_producer.setProducerId(producerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProducerWrapper)) {
			return false;
		}

		ProducerWrapper producerWrapper = (ProducerWrapper)obj;

		if (Objects.equals(_producer, producerWrapper._producer)) {
			return true;
		}

		return false;
	}

	@Override
	public Producer getWrappedModel() {
		return _producer;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _producer.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _producer.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_producer.resetOriginalValues();
	}

	private final Producer _producer;
}