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
 * This class is a wrapper for {@link Producer_Lectureseries}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer_Lectureseries
 * @generated
 */
@ProviderType
public class Producer_LectureseriesWrapper
	implements Producer_Lectureseries, ModelWrapper<Producer_Lectureseries> {

	public Producer_LectureseriesWrapper(
		Producer_Lectureseries producer_Lectureseries) {

		_producer_Lectureseries = producer_Lectureseries;
	}

	@Override
	public Class<?> getModelClass() {
		return Producer_Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Producer_Lectureseries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("producerLectureseriesId", getProducerLectureseriesId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("producerId", getProducerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long producerLectureseriesId = (Long)attributes.get(
			"producerLectureseriesId");

		if (producerLectureseriesId != null) {
			setProducerLectureseriesId(producerLectureseriesId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}
	}

	@Override
	public Object clone() {
		return new Producer_LectureseriesWrapper(
			(Producer_Lectureseries)_producer_Lectureseries.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Producer_Lectureseries
			producer_Lectureseries) {

		return _producer_Lectureseries.compareTo(producer_Lectureseries);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _producer_Lectureseries.getExpandoBridge();
	}

	/**
	 * Returns the lectureseries ID of this producer_ lectureseries.
	 *
	 * @return the lectureseries ID of this producer_ lectureseries
	 */
	@Override
	public long getLectureseriesId() {
		return _producer_Lectureseries.getLectureseriesId();
	}

	/**
	 * Returns the primary key of this producer_ lectureseries.
	 *
	 * @return the primary key of this producer_ lectureseries
	 */
	@Override
	public long getPrimaryKey() {
		return _producer_Lectureseries.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _producer_Lectureseries.getPrimaryKeyObj();
	}

	/**
	 * Returns the producer ID of this producer_ lectureseries.
	 *
	 * @return the producer ID of this producer_ lectureseries
	 */
	@Override
	public long getProducerId() {
		return _producer_Lectureseries.getProducerId();
	}

	/**
	 * Returns the producer lectureseries ID of this producer_ lectureseries.
	 *
	 * @return the producer lectureseries ID of this producer_ lectureseries
	 */
	@Override
	public long getProducerLectureseriesId() {
		return _producer_Lectureseries.getProducerLectureseriesId();
	}

	@Override
	public int hashCode() {
		return _producer_Lectureseries.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _producer_Lectureseries.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _producer_Lectureseries.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _producer_Lectureseries.isNew();
	}

	@Override
	public void persist() {
		_producer_Lectureseries.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_producer_Lectureseries.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_producer_Lectureseries.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_producer_Lectureseries.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_producer_Lectureseries.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the lectureseries ID of this producer_ lectureseries.
	 *
	 * @param lectureseriesId the lectureseries ID of this producer_ lectureseries
	 */
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_producer_Lectureseries.setLectureseriesId(lectureseriesId);
	}

	@Override
	public void setNew(boolean n) {
		_producer_Lectureseries.setNew(n);
	}

	/**
	 * Sets the primary key of this producer_ lectureseries.
	 *
	 * @param primaryKey the primary key of this producer_ lectureseries
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_producer_Lectureseries.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_producer_Lectureseries.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the producer ID of this producer_ lectureseries.
	 *
	 * @param producerId the producer ID of this producer_ lectureseries
	 */
	@Override
	public void setProducerId(long producerId) {
		_producer_Lectureseries.setProducerId(producerId);
	}

	/**
	 * Sets the producer lectureseries ID of this producer_ lectureseries.
	 *
	 * @param producerLectureseriesId the producer lectureseries ID of this producer_ lectureseries
	 */
	@Override
	public void setProducerLectureseriesId(long producerLectureseriesId) {
		_producer_Lectureseries.setProducerLectureseriesId(
			producerLectureseriesId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Producer_Lectureseries> toCacheModel() {

		return _producer_Lectureseries.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer_Lectureseries toEscapedModel() {
		return new Producer_LectureseriesWrapper(
			_producer_Lectureseries.toEscapedModel());
	}

	@Override
	public String toString() {
		return _producer_Lectureseries.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer_Lectureseries toUnescapedModel() {
		return new Producer_LectureseriesWrapper(
			_producer_Lectureseries.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _producer_Lectureseries.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Producer_LectureseriesWrapper)) {
			return false;
		}

		Producer_LectureseriesWrapper producer_LectureseriesWrapper =
			(Producer_LectureseriesWrapper)obj;

		if (Objects.equals(
				_producer_Lectureseries,
				producer_LectureseriesWrapper._producer_Lectureseries)) {

			return true;
		}

		return false;
	}

	@Override
	public Producer_Lectureseries getWrappedModel() {
		return _producer_Lectureseries;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _producer_Lectureseries.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _producer_Lectureseries.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_producer_Lectureseries.resetOriginalValues();
	}

	private final Producer_Lectureseries _producer_Lectureseries;

}