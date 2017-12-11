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

import de.uhh.l2g.plugins.model.Office;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the office service. This utility wraps {@link de.uhh.l2g.plugins.service.persistence.impl.OfficePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OfficePersistence
 * @see de.uhh.l2g.plugins.service.persistence.impl.OfficePersistenceImpl
 * @generated
 */
@ProviderType
public class OfficeUtil {
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
	public static void clearCache(Office office) {
		getPersistence().clearCache(office);
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
	public static List<Office> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Office> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Office> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Office> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Office update(Office office) {
		return getPersistence().update(office);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Office update(Office office, ServiceContext serviceContext) {
		return getPersistence().update(office, serviceContext);
	}

	/**
	* Returns the office where institutionId = &#63; or throws a {@link NoSuchOfficeException} if it could not be found.
	*
	* @param institutionId the institution ID
	* @return the matching office
	* @throws NoSuchOfficeException if a matching office could not be found
	*/
	public static Office findByInstitution(long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchOfficeException {
		return getPersistence().findByInstitution(institutionId);
	}

	/**
	* Returns the office where institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param institutionId the institution ID
	* @return the matching office, or <code>null</code> if a matching office could not be found
	*/
	public static Office fetchByInstitution(long institutionId) {
		return getPersistence().fetchByInstitution(institutionId);
	}

	/**
	* Returns the office where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param institutionId the institution ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching office, or <code>null</code> if a matching office could not be found
	*/
	public static Office fetchByInstitution(long institutionId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByInstitution(institutionId, retrieveFromCache);
	}

	/**
	* Removes the office where institutionId = &#63; from the database.
	*
	* @param institutionId the institution ID
	* @return the office that was removed
	*/
	public static Office removeByInstitution(long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchOfficeException {
		return getPersistence().removeByInstitution(institutionId);
	}

	/**
	* Returns the number of offices where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the number of matching offices
	*/
	public static int countByInstitution(long institutionId) {
		return getPersistence().countByInstitution(institutionId);
	}

	/**
	* Caches the office in the entity cache if it is enabled.
	*
	* @param office the office
	*/
	public static void cacheResult(Office office) {
		getPersistence().cacheResult(office);
	}

	/**
	* Caches the offices in the entity cache if it is enabled.
	*
	* @param offices the offices
	*/
	public static void cacheResult(List<Office> offices) {
		getPersistence().cacheResult(offices);
	}

	/**
	* Creates a new office with the primary key. Does not add the office to the database.
	*
	* @param officeId the primary key for the new office
	* @return the new office
	*/
	public static Office create(long officeId) {
		return getPersistence().create(officeId);
	}

	/**
	* Removes the office with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeId the primary key of the office
	* @return the office that was removed
	* @throws NoSuchOfficeException if a office with the primary key could not be found
	*/
	public static Office remove(long officeId)
		throws de.uhh.l2g.plugins.exception.NoSuchOfficeException {
		return getPersistence().remove(officeId);
	}

	public static Office updateImpl(Office office) {
		return getPersistence().updateImpl(office);
	}

	/**
	* Returns the office with the primary key or throws a {@link NoSuchOfficeException} if it could not be found.
	*
	* @param officeId the primary key of the office
	* @return the office
	* @throws NoSuchOfficeException if a office with the primary key could not be found
	*/
	public static Office findByPrimaryKey(long officeId)
		throws de.uhh.l2g.plugins.exception.NoSuchOfficeException {
		return getPersistence().findByPrimaryKey(officeId);
	}

	/**
	* Returns the office with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param officeId the primary key of the office
	* @return the office, or <code>null</code> if a office with the primary key could not be found
	*/
	public static Office fetchByPrimaryKey(long officeId) {
		return getPersistence().fetchByPrimaryKey(officeId);
	}

	public static java.util.Map<java.io.Serializable, Office> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the offices.
	*
	* @return the offices
	*/
	public static List<Office> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the offices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of offices
	* @param end the upper bound of the range of offices (not inclusive)
	* @return the range of offices
	*/
	public static List<Office> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the offices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of offices
	* @param end the upper bound of the range of offices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of offices
	*/
	public static List<Office> findAll(int start, int end,
		OrderByComparator<Office> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the offices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of offices
	* @param end the upper bound of the range of offices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of offices
	*/
	public static List<Office> findAll(int start, int end,
		OrderByComparator<Office> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the offices from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of offices.
	*
	* @return the number of offices
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OfficePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OfficePersistence, OfficePersistence> _serviceTracker =
		ServiceTrackerFactory.open(OfficePersistence.class);
}