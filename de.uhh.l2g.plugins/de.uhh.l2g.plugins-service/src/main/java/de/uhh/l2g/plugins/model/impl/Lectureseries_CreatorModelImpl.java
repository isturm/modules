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

package de.uhh.l2g.plugins.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.model.Lectureseries_CreatorModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Lectureseries_Creator service. Represents a row in the &quot;LG_Lectureseries_Creator&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>Lectureseries_CreatorModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Lectureseries_CreatorImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CreatorImpl
 * @generated
 */
@ProviderType
public class Lectureseries_CreatorModelImpl
	extends BaseModelImpl<Lectureseries_Creator>
	implements Lectureseries_CreatorModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lectureseries_ creator model instance should use the <code>Lectureseries_Creator</code> interface instead.
	 */
	public static final String TABLE_NAME = "LG_Lectureseries_Creator";

	public static final Object[][] TABLE_COLUMNS = {
		{"lectureseriesCreatorId", Types.BIGINT},
		{"lectureseriesId", Types.BIGINT}, {"creatorId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("lectureseriesCreatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lectureseriesId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table LG_Lectureseries_Creator (lectureseriesCreatorId LONG not null primary key,lectureseriesId LONG,creatorId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table LG_Lectureseries_Creator";

	public static final String ORDER_BY_JPQL =
		" ORDER BY lectureseries_Creator.lectureseriesCreatorId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY LG_Lectureseries_Creator.lectureseriesCreatorId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		de.uhh.l2g.plugins.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Lectureseries_Creator"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		de.uhh.l2g.plugins.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Lectureseries_Creator"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		de.uhh.l2g.plugins.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Lectureseries_Creator"),
		true);

	public static final long CREATORID_COLUMN_BITMASK = 1L;

	public static final long LECTURESERIESID_COLUMN_BITMASK = 2L;

	public static final long LECTURESERIESCREATORID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		de.uhh.l2g.plugins.service.util.ServiceProps.get(
			"lock.expiration.time.de.uhh.l2g.plugins.model.Lectureseries_Creator"));

	public Lectureseries_CreatorModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _lectureseriesCreatorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLectureseriesCreatorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lectureseriesCreatorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Creator.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Creator.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Lectureseries_Creator, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Lectureseries_Creator, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Lectureseries_Creator, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Lectureseries_Creator)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Lectureseries_Creator, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Lectureseries_Creator, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Lectureseries_Creator)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Lectureseries_Creator, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Lectureseries_Creator, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Lectureseries_Creator>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Lectureseries_Creator.class.getClassLoader(),
			Lectureseries_Creator.class, ModelWrapper.class);

		try {
			Constructor<Lectureseries_Creator> constructor =
				(Constructor<Lectureseries_Creator>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Lectureseries_Creator, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Lectureseries_Creator, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Lectureseries_Creator, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<Lectureseries_Creator, Object>>();
		Map<String, BiConsumer<Lectureseries_Creator, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<Lectureseries_Creator, ?>>();

		attributeGetterFunctions.put(
			"lectureseriesCreatorId",
			Lectureseries_Creator::getLectureseriesCreatorId);
		attributeSetterBiConsumers.put(
			"lectureseriesCreatorId",
			(BiConsumer<Lectureseries_Creator, Long>)
				Lectureseries_Creator::setLectureseriesCreatorId);
		attributeGetterFunctions.put(
			"lectureseriesId", Lectureseries_Creator::getLectureseriesId);
		attributeSetterBiConsumers.put(
			"lectureseriesId",
			(BiConsumer<Lectureseries_Creator, Long>)
				Lectureseries_Creator::setLectureseriesId);
		attributeGetterFunctions.put(
			"creatorId", Lectureseries_Creator::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<Lectureseries_Creator, Long>)
				Lectureseries_Creator::setCreatorId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getLectureseriesCreatorId() {
		return _lectureseriesCreatorId;
	}

	@Override
	public void setLectureseriesCreatorId(long lectureseriesCreatorId) {
		_lectureseriesCreatorId = lectureseriesCreatorId;
	}

	@Override
	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_columnBitmask |= LECTURESERIESID_COLUMN_BITMASK;

		if (!_setOriginalLectureseriesId) {
			_setOriginalLectureseriesId = true;

			_originalLectureseriesId = _lectureseriesId;
		}

		_lectureseriesId = lectureseriesId;
	}

	public long getOriginalLectureseriesId() {
		return _originalLectureseriesId;
	}

	@Override
	public long getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(long creatorId) {
		_columnBitmask |= CREATORID_COLUMN_BITMASK;

		if (!_setOriginalCreatorId) {
			_setOriginalCreatorId = true;

			_originalCreatorId = _creatorId;
		}

		_creatorId = creatorId;
	}

	public long getOriginalCreatorId() {
		return _originalCreatorId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Lectureseries_Creator.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Lectureseries_Creator toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Lectureseries_CreatorImpl lectureseries_CreatorImpl =
			new Lectureseries_CreatorImpl();

		lectureseries_CreatorImpl.setLectureseriesCreatorId(
			getLectureseriesCreatorId());
		lectureseries_CreatorImpl.setLectureseriesId(getLectureseriesId());
		lectureseries_CreatorImpl.setCreatorId(getCreatorId());

		lectureseries_CreatorImpl.resetOriginalValues();

		return lectureseries_CreatorImpl;
	}

	@Override
	public int compareTo(Lectureseries_Creator lectureseries_Creator) {
		long primaryKey = lectureseries_Creator.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Lectureseries_Creator)) {
			return false;
		}

		Lectureseries_Creator lectureseries_Creator =
			(Lectureseries_Creator)obj;

		long primaryKey = lectureseries_Creator.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		Lectureseries_CreatorModelImpl lectureseries_CreatorModelImpl = this;

		lectureseries_CreatorModelImpl._originalLectureseriesId =
			lectureseries_CreatorModelImpl._lectureseriesId;

		lectureseries_CreatorModelImpl._setOriginalLectureseriesId = false;

		lectureseries_CreatorModelImpl._originalCreatorId =
			lectureseries_CreatorModelImpl._creatorId;

		lectureseries_CreatorModelImpl._setOriginalCreatorId = false;

		lectureseries_CreatorModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Lectureseries_Creator> toCacheModel() {
		Lectureseries_CreatorCacheModel lectureseries_CreatorCacheModel =
			new Lectureseries_CreatorCacheModel();

		lectureseries_CreatorCacheModel.lectureseriesCreatorId =
			getLectureseriesCreatorId();

		lectureseries_CreatorCacheModel.lectureseriesId = getLectureseriesId();

		lectureseries_CreatorCacheModel.creatorId = getCreatorId();

		return lectureseries_CreatorCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Lectureseries_Creator, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Lectureseries_Creator, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Lectureseries_Creator, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((Lectureseries_Creator)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Lectureseries_Creator, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Lectureseries_Creator, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Lectureseries_Creator, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((Lectureseries_Creator)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Lectureseries_Creator>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _lectureseriesCreatorId;
	private long _lectureseriesId;
	private long _originalLectureseriesId;
	private boolean _setOriginalLectureseriesId;
	private long _creatorId;
	private long _originalCreatorId;
	private boolean _setOriginalCreatorId;
	private long _columnBitmask;
	private Lectureseries_Creator _escapedModel;

}