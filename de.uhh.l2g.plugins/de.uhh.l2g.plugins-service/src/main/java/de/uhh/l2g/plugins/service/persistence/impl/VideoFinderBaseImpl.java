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

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ReflectionUtil;

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.persistence.VideoPersistence;

/**
 * @author Iavor Sturm
 * @generated
 */
public class VideoFinderBaseImpl extends BasePersistenceImpl<Video> {
	public VideoFinderBaseImpl() {
		setModelClass(Video.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

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
		return getVideoPersistence().getBadColumnNames();
	}

	/**
	 * Returns the video persistence.
	 *
	 * @return the video persistence
	 */
	public VideoPersistence getVideoPersistence() {
		return videoPersistence;
	}

	/**
	 * Sets the video persistence.
	 *
	 * @param videoPersistence the video persistence
	 */
	public void setVideoPersistence(VideoPersistence videoPersistence) {
		this.videoPersistence = videoPersistence;
	}

	@BeanReference(type = VideoPersistence.class)
	protected VideoPersistence videoPersistence;
	private static final Log _log = LogFactoryUtil.getLog(VideoFinderBaseImpl.class);
}