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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.License;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the license service. This utility wraps {@link de.uhh.l2g.plugins.service.persistence.impl.LicensePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LicensePersistence
 * @see de.uhh.l2g.plugins.service.persistence.impl.LicensePersistenceImpl
 * @generated
 */
@ProviderType
public class LicenseUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(License license) {
		getPersistence().clearCache(license);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<License> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<License> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<License> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<License> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static License update(License license) {
		return getPersistence().update(license);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static License update(License license, ServiceContext serviceContext) {
		return getPersistence().update(license, serviceContext);
	}

	/**
	* Returns the license where videoId = &#63; or throws a {@link NoSuchLicenseException} if it could not be found.
	*
	* @param videoId the video ID
	* @return the matching license
	* @throws NoSuchLicenseException if a matching license could not be found
	*/
	public static License findByVideo(long videoId)
		throws de.uhh.l2g.plugins.exception.NoSuchLicenseException {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns the license where videoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param videoId the video ID
	* @return the matching license, or <code>null</code> if a matching license could not be found
	*/
	public static License fetchByVideo(long videoId) {
		return getPersistence().fetchByVideo(videoId);
	}

	/**
	* Returns the license where videoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param videoId the video ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching license, or <code>null</code> if a matching license could not be found
	*/
	public static License fetchByVideo(long videoId, boolean retrieveFromCache) {
		return getPersistence().fetchByVideo(videoId, retrieveFromCache);
	}

	/**
	* Removes the license where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @return the license that was removed
	*/
	public static License removeByVideo(long videoId)
		throws de.uhh.l2g.plugins.exception.NoSuchLicenseException {
		return getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of licenses where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching licenses
	*/
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Caches the license in the entity cache if it is enabled.
	*
	* @param license the license
	*/
	public static void cacheResult(License license) {
		getPersistence().cacheResult(license);
	}

	/**
	* Caches the licenses in the entity cache if it is enabled.
	*
	* @param licenses the licenses
	*/
	public static void cacheResult(List<License> licenses) {
		getPersistence().cacheResult(licenses);
	}

	/**
	* Creates a new license with the primary key. Does not add the license to the database.
	*
	* @param licenseId the primary key for the new license
	* @return the new license
	*/
	public static License create(long licenseId) {
		return getPersistence().create(licenseId);
	}

	/**
	* Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param licenseId the primary key of the license
	* @return the license that was removed
	* @throws NoSuchLicenseException if a license with the primary key could not be found
	*/
	public static License remove(long licenseId)
		throws de.uhh.l2g.plugins.exception.NoSuchLicenseException {
		return getPersistence().remove(licenseId);
	}

	public static License updateImpl(License license) {
		return getPersistence().updateImpl(license);
	}

	/**
	* Returns the license with the primary key or throws a {@link NoSuchLicenseException} if it could not be found.
	*
	* @param licenseId the primary key of the license
	* @return the license
	* @throws NoSuchLicenseException if a license with the primary key could not be found
	*/
	public static License findByPrimaryKey(long licenseId)
		throws de.uhh.l2g.plugins.exception.NoSuchLicenseException {
		return getPersistence().findByPrimaryKey(licenseId);
	}

	/**
	* Returns the license with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param licenseId the primary key of the license
	* @return the license, or <code>null</code> if a license with the primary key could not be found
	*/
	public static License fetchByPrimaryKey(long licenseId) {
		return getPersistence().fetchByPrimaryKey(licenseId);
	}

	public static java.util.Map<java.io.Serializable, License> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the licenses.
	*
	* @return the licenses
	*/
	public static List<License> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<License> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<License> findAll(int start, int end,
		OrderByComparator<License> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<License> findAll(int start, int end,
		OrderByComparator<License> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the licenses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of licenses.
	*
	* @return the number of licenses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LicensePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LicensePersistence, LicensePersistence> _serviceTracker =
		ServiceTrackerFactory.open(LicensePersistence.class);
}