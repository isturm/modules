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
 * The extended model interface for the Metadata service. Represents a row in the &quot;LG_Metadata&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see MetadataModel
 * @see de.uhh.l2g.plugins.model.impl.MetadataImpl
 * @see de.uhh.l2g.plugins.model.impl.MetadataModelImpl
 * @generated
 */
@ImplementationClassName("de.uhh.l2g.plugins.model.impl.MetadataImpl")
@ProviderType
public interface Metadata extends MetadataModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.uhh.l2g.plugins.model.impl.MetadataImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Metadata, Long> METADATA_ID_ACCESSOR = new Accessor<Metadata, Long>() {
			@Override
			public Long get(Metadata metadata) {
				return metadata.getMetadataId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Metadata> getTypeClass() {
				return Metadata.class;
			}
		};
}