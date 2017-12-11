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

package de.uhh.l2g.plugins.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.exception.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.License;

/**
 * The persistence interface for the license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.persistence.impl.LicensePersistenceImpl
 * @see LicenseUtil
 * @generated
 */
@ProviderType
public interface LicensePersistence extends BasePersistence<License> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LicenseUtil} to access the license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the license where videoId = &#63; or throws a {@link NoSuchLicenseException} if it could not be found.
	*
	* @param videoId the video ID
	* @return the matching license
	* @throws NoSuchLicenseException if a matching license could not be found
	*/
	public License findByVideo(long videoId) throws NoSuchLicenseException;

	/**
	* Returns the license where videoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param videoId the video ID
	* @return the matching license, or <code>null</code> if a matching license could not be found
	*/
	public License fetchByVideo(long videoId);

	/**
	* Returns the license where videoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param videoId the video ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching license, or <code>null</code> if a matching license could not be found
	*/
	public License fetchByVideo(long videoId, boolean retrieveFromCache);

	/**
	* Removes the license where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @return the license that was removed
	*/
	public License removeByVideo(long videoId) throws NoSuchLicenseException;

	/**
	* Returns the number of licenses where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching licenses
	*/
	public int countByVideo(long videoId);

	/**
	* Caches the license in the entity cache if it is enabled.
	*
	* @param license the license
	*/
	public void cacheResult(License license);

	/**
	* Caches the licenses in the entity cache if it is enabled.
	*
	* @param licenses the licenses
	*/
	public void cacheResult(java.util.List<License> licenses);

	/**
	* Creates a new license with the primary key. Does not add the license to the database.
	*
	* @param licenseId the primary key for the new license
	* @return the new license
	*/
	public License create(long licenseId);

	/**
	* Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param licenseId the primary key of the license
	* @return the license that was removed
	* @throws NoSuchLicenseException if a license with the primary key could not be found
	*/
	public License remove(long licenseId) throws NoSuchLicenseException;

	public License updateImpl(License license);

	/**
	* Returns the license with the primary key or throws a {@link NoSuchLicenseException} if it could not be found.
	*
	* @param licenseId the primary key of the license
	* @return the license
	* @throws NoSuchLicenseException if a license with the primary key could not be found
	*/
	public License findByPrimaryKey(long licenseId)
		throws NoSuchLicenseException;

	/**
	* Returns the license with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param licenseId the primary key of the license
	* @return the license, or <code>null</code> if a license with the primary key could not be found
	*/
	public License fetchByPrimaryKey(long licenseId);

	@Override
	public java.util.Map<java.io.Serializable, License> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the licenses.
	*
	* @return the licenses
	*/
	public java.util.List<License> findAll();

	/**
	* Returns a range of all the licenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of licenses
	* @param end the upper bound of the range of licenses (not inclusive)
	* @return the range of licenses
	*/
	public java.util.List<License> findAll(int start, int end);

	/**
	* Returns an ordered range of all the licenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of licenses
	* @param end the upper bound of the range of licenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of licenses
	*/
	public java.util.List<License> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<License> orderByComparator);

	/**
	* Returns an ordered range of all the licenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of licenses
	* @param end the upper bound of the range of licenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of licenses
	*/
	public java.util.List<License> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<License> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the licenses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of licenses.
	*
	* @return the number of licenses
	*/
	public int countAll();
}