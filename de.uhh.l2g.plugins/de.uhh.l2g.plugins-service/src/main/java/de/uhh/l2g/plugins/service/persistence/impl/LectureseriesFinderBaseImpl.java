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

package de.uhh.l2g.plugins.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ReflectionUtil;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.service.persistence.LectureseriesPersistence;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Iavor Sturm
 * @generated
 */
public class LectureseriesFinderBaseImpl extends BasePersistenceImpl<Lectureseries> {
	public LectureseriesFinderBaseImpl() {
		setModelClass(Lectureseries.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("number", "number_");
			dbColumnNames.put("password", "password_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getLectureseriesPersistence().getBadColumnNames();
	}

	/**
	 * Returns the lectureseries persistence.
	 *
	 * @return the lectureseries persistence
	 */
	public LectureseriesPersistence getLectureseriesPersistence() {
		return lectureseriesPersistence;
	}

	/**
	 * Sets the lectureseries persistence.
	 *
	 * @param lectureseriesPersistence the lectureseries persistence
	 */
	public void setLectureseriesPersistence(
		LectureseriesPersistence lectureseriesPersistence) {
		this.lectureseriesPersistence = lectureseriesPersistence;
	}

	@BeanReference(type = LectureseriesPersistence.class)
	protected LectureseriesPersistence lectureseriesPersistence;
	private static final Log _log = LogFactoryUtil.getLog(LectureseriesFinderBaseImpl.class);
}