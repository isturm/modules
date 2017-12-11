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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Producer_Lectureseries service. Represents a row in the &quot;LG_Producer_Lectureseries&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see Producer_LectureseriesModel
 * @see de.uhh.l2g.plugins.model.impl.Producer_LectureseriesImpl
 * @see de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl
 * @generated
 */
@ImplementationClassName("de.uhh.l2g.plugins.model.impl.Producer_LectureseriesImpl")
@ProviderType
public interface Producer_Lectureseries extends Producer_LectureseriesModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Producer_Lectureseries, Long> PRODUCER_LECTURESERIES_ID_ACCESSOR =
		new Accessor<Producer_Lectureseries, Long>() {
			@Override
			public Long get(Producer_Lectureseries producer_Lectureseries) {
				return producer_Lectureseries.getProducerLectureseriesId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Producer_Lectureseries> getTypeClass() {
				return Producer_Lectureseries.class;
			}
		};
}