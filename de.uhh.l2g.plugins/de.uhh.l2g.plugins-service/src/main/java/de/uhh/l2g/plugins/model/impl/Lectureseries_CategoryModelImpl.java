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

import de.uhh.l2g.plugins.model.Lectureseries_Category;
import de.uhh.l2g.plugins.model.Lectureseries_CategoryModel;

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
 * The base model implementation for the Lectureseries_Category service. Represents a row in the &quot;LG_Lectureseries_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>Lectureseries_CategoryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Lectureseries_CategoryImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryImpl
 * @generated
 */
@ProviderType
public class Lectureseries_CategoryModelImpl
	extends BaseModelImpl<Lectureseries_Category>
	implements Lectureseries_CategoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lectureseries_ category model instance should use the <code>Lectureseries_Category</code> interface instead.
	 */
	public static final String TABLE_NAME = "LG_Lectureseries_Category";

	public static final Object[][] TABLE_COLUMNS = {
		{"lectureseriesCategoryId", Types.BIGINT}, {"categoryId", Types.BIGINT},
		{"lectureseriesId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("lectureseriesCategoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("categoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lectureseriesId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table LG_Lectureseries_Category (lectureseriesCategoryId LONG not null primary key,categoryId LONG,lectureseriesId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table LG_Lectureseries_Category";

	public static final String ORDER_BY_JPQL =
		" ORDER BY lectureseries_Category.lectureseriesCategoryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY LG_Lectureseries_Category.lectureseriesCategoryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		de.uhh.l2g.plugins.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Lectureseries_Category"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		de.uhh.l2g.plugins.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Lectureseries_Category"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		de.uhh.l2g.plugins.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Lectureseries_Category"),
		true);

	public static final long CATEGORYID_COLUMN_BITMASK = 1L;

	public static final long LECTURESERIESID_COLUMN_BITMASK = 2L;

	public static final long LECTURESERIESCATEGORYID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		de.uhh.l2g.plugins.service.util.ServiceProps.get(
			"lock.expiration.time.de.uhh.l2g.plugins.model.Lectureseries_Category"));

	public Lectureseries_CategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _lectureseriesCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLectureseriesCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lectureseriesCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Category.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Lectureseries_Category, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Lectureseries_Category, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Lectureseries_Category, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Lectureseries_Category)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Lectureseries_Category, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Lectureseries_Category, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Lectureseries_Category)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Lectureseries_Category, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Lectureseries_Category, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Lectureseries_Category>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Lectureseries_Category.class.getClassLoader(),
			Lectureseries_Category.class, ModelWrapper.class);

		try {
			Constructor<Lectureseries_Category> constructor =
				(Constructor<Lectureseries_Category>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Lectureseries_Category, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Lectureseries_Category, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Lectureseries_Category, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<Lectureseries_Category, Object>>();
		Map<String, BiConsumer<Lectureseries_Category, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<Lectureseries_Category, ?>>();

		attributeGetterFunctions.put(
			"lectureseriesCategoryId",
			Lectureseries_Category::getLectureseriesCategoryId);
		attributeSetterBiConsumers.put(
			"lectureseriesCategoryId",
			(BiConsumer<Lectureseries_Category, Long>)
				Lectureseries_Category::setLectureseriesCategoryId);
		attributeGetterFunctions.put(
			"categoryId", Lectureseries_Category::getCategoryId);
		attributeSetterBiConsumers.put(
			"categoryId",
			(BiConsumer<Lectureseries_Category, Long>)
				Lectureseries_Category::setCategoryId);
		attributeGetterFunctions.put(
			"lectureseriesId", Lectureseries_Category::getLectureseriesId);
		attributeSetterBiConsumers.put(
			"lectureseriesId",
			(BiConsumer<Lectureseries_Category, Long>)
				Lectureseries_Category::setLectureseriesId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getLectureseriesCategoryId() {
		return _lectureseriesCategoryId;
	}

	@Override
	public void setLectureseriesCategoryId(long lectureseriesCategoryId) {
		_lectureseriesCategoryId = lectureseriesCategoryId;
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Lectureseries_Category.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Lectureseries_Category toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Lectureseries_CategoryImpl lectureseries_CategoryImpl =
			new Lectureseries_CategoryImpl();

		lectureseries_CategoryImpl.setLectureseriesCategoryId(
			getLectureseriesCategoryId());
		lectureseries_CategoryImpl.setCategoryId(getCategoryId());
		lectureseries_CategoryImpl.setLectureseriesId(getLectureseriesId());

		lectureseries_CategoryImpl.resetOriginalValues();

		return lectureseries_CategoryImpl;
	}

	@Override
	public int compareTo(Lectureseries_Category lectureseries_Category) {
		long primaryKey = lectureseries_Category.getPrimaryKey();

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

		if (!(obj instanceof Lectureseries_Category)) {
			return false;
		}

		Lectureseries_Category lectureseries_Category =
			(Lectureseries_Category)obj;

		long primaryKey = lectureseries_Category.getPrimaryKey();

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
		Lectureseries_CategoryModelImpl lectureseries_CategoryModelImpl = this;

		lectureseries_CategoryModelImpl._originalCategoryId =
			lectureseries_CategoryModelImpl._categoryId;

		lectureseries_CategoryModelImpl._setOriginalCategoryId = false;

		lectureseries_CategoryModelImpl._originalLectureseriesId =
			lectureseries_CategoryModelImpl._lectureseriesId;

		lectureseries_CategoryModelImpl._setOriginalLectureseriesId = false;

		lectureseries_CategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Lectureseries_Category> toCacheModel() {
		Lectureseries_CategoryCacheModel lectureseries_CategoryCacheModel =
			new Lectureseries_CategoryCacheModel();

		lectureseries_CategoryCacheModel.lectureseriesCategoryId =
			getLectureseriesCategoryId();

		lectureseries_CategoryCacheModel.categoryId = getCategoryId();

		lectureseries_CategoryCacheModel.lectureseriesId = getLectureseriesId();

		return lectureseries_CategoryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Lectureseries_Category, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Lectureseries_Category, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Lectureseries_Category, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((Lectureseries_Category)this));
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
		Map<String, Function<Lectureseries_Category, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Lectureseries_Category, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Lectureseries_Category, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((Lectureseries_Category)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Lectureseries_Category>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _lectureseriesCategoryId;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private long _lectureseriesId;
	private long _originalLectureseriesId;
	private boolean _setOriginalLectureseriesId;
	private long _columnBitmask;
	private Lectureseries_Category _escapedModel;

}