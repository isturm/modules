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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import de.uhh.l2g.plugins.model.License;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing License in entity cache.
 *
 * @author Iavor Sturm
 * @see License
 * @generated
 */
@ProviderType
public class LicenseCacheModel implements CacheModel<License>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LicenseCacheModel)) {
			return false;
		}

		LicenseCacheModel licenseCacheModel = (LicenseCacheModel)obj;

		if (licenseId == licenseCacheModel.licenseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, licenseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{licenseId=");
		sb.append(licenseId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", ccby=");
		sb.append(ccby);
		sb.append(", ccbybc=");
		sb.append(ccbybc);
		sb.append(", ccbyncnd=");
		sb.append(ccbyncnd);
		sb.append(", ccbyncsa=");
		sb.append(ccbyncsa);
		sb.append(", ccbysa=");
		sb.append(ccbysa);
		sb.append(", ccbync=");
		sb.append(ccbync);
		sb.append(", l2go=");
		sb.append(l2go);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public License toEntityModel() {
		LicenseImpl licenseImpl = new LicenseImpl();

		licenseImpl.setLicenseId(licenseId);
		licenseImpl.setVideoId(videoId);
		licenseImpl.setCcby(ccby);
		licenseImpl.setCcbybc(ccbybc);
		licenseImpl.setCcbyncnd(ccbyncnd);
		licenseImpl.setCcbyncsa(ccbyncsa);
		licenseImpl.setCcbysa(ccbysa);
		licenseImpl.setCcbync(ccbync);
		licenseImpl.setL2go(l2go);
		licenseImpl.setGroupId(groupId);
		licenseImpl.setCompanyId(companyId);
		licenseImpl.setUserId(userId);

		if (userName == null) {
			licenseImpl.setUserName(StringPool.BLANK);
		}
		else {
			licenseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			licenseImpl.setCreateDate(null);
		}
		else {
			licenseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			licenseImpl.setModifiedDate(null);
		}
		else {
			licenseImpl.setModifiedDate(new Date(modifiedDate));
		}

		licenseImpl.resetOriginalValues();

		return licenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		licenseId = objectInput.readLong();

		videoId = objectInput.readLong();

		ccby = objectInput.readInt();

		ccbybc = objectInput.readInt();

		ccbyncnd = objectInput.readInt();

		ccbyncsa = objectInput.readInt();

		ccbysa = objectInput.readInt();

		ccbync = objectInput.readInt();

		l2go = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(licenseId);

		objectOutput.writeLong(videoId);

		objectOutput.writeInt(ccby);

		objectOutput.writeInt(ccbybc);

		objectOutput.writeInt(ccbyncnd);

		objectOutput.writeInt(ccbyncsa);

		objectOutput.writeInt(ccbysa);

		objectOutput.writeInt(ccbync);

		objectOutput.writeInt(l2go);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long licenseId;
	public long videoId;
	public int ccby;
	public int ccbybc;
	public int ccbyncnd;
	public int ccbyncsa;
	public int ccbysa;
	public int ccbync;
	public int l2go;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}