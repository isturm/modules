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
 * This class is a wrapper for {@link Host}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Host
 * @generated
 */
@ProviderType
public class HostWrapper implements Host, ModelWrapper<Host> {
	public HostWrapper(Host host) {
		_host = host;
	}

	@Override
	public Class<?> getModelClass() {
		return Host.class;
	}

	@Override
	public String getModelClassName() {
		return Host.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hostId", getHostId());
		attributes.put("protocol", getProtocol());
		attributes.put("streamer", getStreamer());
		attributes.put("port", getPort());
		attributes.put("serverRoot", getServerRoot());
		attributes.put("name", getName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("defaultHost", getDefaultHost());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		String protocol = (String)attributes.get("protocol");

		if (protocol != null) {
			setProtocol(protocol);
		}

		String streamer = (String)attributes.get("streamer");

		if (streamer != null) {
			setStreamer(streamer);
		}

		Integer port = (Integer)attributes.get("port");

		if (port != null) {
			setPort(port);
		}

		String serverRoot = (String)attributes.get("serverRoot");

		if (serverRoot != null) {
			setServerRoot(serverRoot);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Integer defaultHost = (Integer)attributes.get("defaultHost");

		if (defaultHost != null) {
			setDefaultHost(defaultHost);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _host.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _host.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _host.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _host.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.uhh.l2g.plugins.model.Host> toCacheModel() {
		return _host.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Host toEscapedModel() {
		return new HostWrapper(_host.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Host toUnescapedModel() {
		return new HostWrapper(_host.toUnescapedModel());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Host host) {
		return _host.compareTo(host);
	}

	/**
	* Returns the default host of this host.
	*
	* @return the default host of this host
	*/
	@Override
	public int getDefaultHost() {
		return _host.getDefaultHost();
	}

	/**
	* Returns the port of this host.
	*
	* @return the port of this host
	*/
	@Override
	public int getPort() {
		return _host.getPort();
	}

	@Override
	public int hashCode() {
		return _host.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _host.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new HostWrapper((Host)_host.clone());
	}

	/**
	* Returns the name of this host.
	*
	* @return the name of this host
	*/
	@Override
	public java.lang.String getName() {
		return _host.getName();
	}

	/**
	* Returns the protocol of this host.
	*
	* @return the protocol of this host
	*/
	@Override
	public java.lang.String getProtocol() {
		return _host.getProtocol();
	}

	/**
	* Returns the server root of this host.
	*
	* @return the server root of this host
	*/
	@Override
	public java.lang.String getServerRoot() {
		return _host.getServerRoot();
	}

	/**
	* Returns the streamer of this host.
	*
	* @return the streamer of this host
	*/
	@Override
	public java.lang.String getStreamer() {
		return _host.getStreamer();
	}

	@Override
	public java.lang.String toString() {
		return _host.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _host.toXmlString();
	}

	/**
	* Returns the company ID of this host.
	*
	* @return the company ID of this host
	*/
	@Override
	public long getCompanyId() {
		return _host.getCompanyId();
	}

	/**
	* Returns the group ID of this host.
	*
	* @return the group ID of this host
	*/
	@Override
	public long getGroupId() {
		return _host.getGroupId();
	}

	/**
	* Returns the host ID of this host.
	*
	* @return the host ID of this host
	*/
	@Override
	public long getHostId() {
		return _host.getHostId();
	}

	/**
	* Returns the primary key of this host.
	*
	* @return the primary key of this host
	*/
	@Override
	public long getPrimaryKey() {
		return _host.getPrimaryKey();
	}

	@Override
	public void persist() {
		_host.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_host.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this host.
	*
	* @param companyId the company ID of this host
	*/
	@Override
	public void setCompanyId(long companyId) {
		_host.setCompanyId(companyId);
	}

	/**
	* Sets the default host of this host.
	*
	* @param defaultHost the default host of this host
	*/
	@Override
	public void setDefaultHost(int defaultHost) {
		_host.setDefaultHost(defaultHost);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_host.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_host.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_host.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this host.
	*
	* @param groupId the group ID of this host
	*/
	@Override
	public void setGroupId(long groupId) {
		_host.setGroupId(groupId);
	}

	/**
	* Sets the host ID of this host.
	*
	* @param hostId the host ID of this host
	*/
	@Override
	public void setHostId(long hostId) {
		_host.setHostId(hostId);
	}

	/**
	* Sets the name of this host.
	*
	* @param name the name of this host
	*/
	@Override
	public void setName(java.lang.String name) {
		_host.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_host.setNew(n);
	}

	/**
	* Sets the port of this host.
	*
	* @param port the port of this host
	*/
	@Override
	public void setPort(int port) {
		_host.setPort(port);
	}

	/**
	* Sets the primary key of this host.
	*
	* @param primaryKey the primary key of this host
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_host.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_host.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the protocol of this host.
	*
	* @param protocol the protocol of this host
	*/
	@Override
	public void setProtocol(java.lang.String protocol) {
		_host.setProtocol(protocol);
	}

	/**
	* Sets the server root of this host.
	*
	* @param serverRoot the server root of this host
	*/
	@Override
	public void setServerRoot(java.lang.String serverRoot) {
		_host.setServerRoot(serverRoot);
	}

	/**
	* Sets the streamer of this host.
	*
	* @param streamer the streamer of this host
	*/
	@Override
	public void setStreamer(java.lang.String streamer) {
		_host.setStreamer(streamer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HostWrapper)) {
			return false;
		}

		HostWrapper hostWrapper = (HostWrapper)obj;

		if (Objects.equals(_host, hostWrapper._host)) {
			return true;
		}

		return false;
	}

	@Override
	public Host getWrappedModel() {
		return _host;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _host.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _host.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_host.resetOriginalValues();
	}

	private final Host _host;
}