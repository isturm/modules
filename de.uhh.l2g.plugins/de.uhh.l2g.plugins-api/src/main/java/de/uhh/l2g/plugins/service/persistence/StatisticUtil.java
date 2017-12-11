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

import de.uhh.l2g.plugins.model.Statistic;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the statistic service. This utility wraps {@link de.uhh.l2g.plugins.service.persistence.impl.StatisticPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see StatisticPersistence
 * @see de.uhh.l2g.plugins.service.persistence.impl.StatisticPersistenceImpl
 * @generated
 */
@ProviderType
public class StatisticUtil {
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
	public static void clearCache(Statistic statistic) {
		getPersistence().clearCache(statistic);
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
	public static List<Statistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Statistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Statistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Statistic> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Statistic update(Statistic statistic) {
		return getPersistence().update(statistic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Statistic update(Statistic statistic,
		ServiceContext serviceContext) {
		return getPersistence().update(statistic, serviceContext);
	}

	/**
	* Returns the statistic where statisticId = &#63; or throws a {@link NoSuchStatisticException} if it could not be found.
	*
	* @param statisticId the statistic ID
	* @return the matching statistic
	* @throws NoSuchStatisticException if a matching statistic could not be found
	*/
	public static Statistic findByStatisticId(long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence().findByStatisticId(statisticId);
	}

	/**
	* Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param statisticId the statistic ID
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	*/
	public static Statistic fetchByStatisticId(long statisticId) {
		return getPersistence().fetchByStatisticId(statisticId);
	}

	/**
	* Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param statisticId the statistic ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	*/
	public static Statistic fetchByStatisticId(long statisticId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByStatisticId(statisticId, retrieveFromCache);
	}

	/**
	* Removes the statistic where statisticId = &#63; from the database.
	*
	* @param statisticId the statistic ID
	* @return the statistic that was removed
	*/
	public static Statistic removeByStatisticId(long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence().removeByStatisticId(statisticId);
	}

	/**
	* Returns the number of statistics where statisticId = &#63;.
	*
	* @param statisticId the statistic ID
	* @return the number of matching statistics
	*/
	public static int countByStatisticId(long statisticId) {
		return getPersistence().countByStatisticId(statisticId);
	}

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or throws a {@link NoSuchStatisticException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @return the matching statistic
	* @throws NoSuchStatisticException if a matching statistic could not be found
	*/
	public static Statistic findByC_G_S(long companyId, long groupId,
		long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence().findByC_G_S(companyId, groupId, statisticId);
	}

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	*/
	public static Statistic fetchByC_G_S(long companyId, long groupId,
		long statisticId) {
		return getPersistence().fetchByC_G_S(companyId, groupId, statisticId);
	}

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	*/
	public static Statistic fetchByC_G_S(long companyId, long groupId,
		long statisticId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_G_S(companyId, groupId, statisticId,
			retrieveFromCache);
	}

	/**
	* Removes the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @return the statistic that was removed
	*/
	public static Statistic removeByC_G_S(long companyId, long groupId,
		long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence().removeByC_G_S(companyId, groupId, statisticId);
	}

	/**
	* Returns the number of statistics where companyId = &#63; and groupId = &#63; and statisticId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @return the number of matching statistics
	*/
	public static int countByC_G_S(long companyId, long groupId,
		long statisticId) {
		return getPersistence().countByC_G_S(companyId, groupId, statisticId);
	}

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or throws a {@link NoSuchStatisticException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @return the matching statistic
	* @throws NoSuchStatisticException if a matching statistic could not be found
	*/
	public static Statistic findByC_G_D(long companyId, long groupId,
		Date createDate)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence().findByC_G_D(companyId, groupId, createDate);
	}

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	*/
	public static Statistic fetchByC_G_D(long companyId, long groupId,
		Date createDate) {
		return getPersistence().fetchByC_G_D(companyId, groupId, createDate);
	}

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	*/
	public static Statistic fetchByC_G_D(long companyId, long groupId,
		Date createDate, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_G_D(companyId, groupId, createDate,
			retrieveFromCache);
	}

	/**
	* Removes the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @return the statistic that was removed
	*/
	public static Statistic removeByC_G_D(long companyId, long groupId,
		Date createDate)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence().removeByC_G_D(companyId, groupId, createDate);
	}

	/**
	* Returns the number of statistics where companyId = &#63; and groupId = &#63; and createDate = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @return the number of matching statistics
	*/
	public static int countByC_G_D(long companyId, long groupId, Date createDate) {
		return getPersistence().countByC_G_D(companyId, groupId, createDate);
	}

	/**
	* Returns all the statistics where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching statistics
	*/
	public static List<Statistic> findByC_G(long companyId, long groupId) {
		return getPersistence().findByC_G(companyId, groupId);
	}

	/**
	* Returns a range of all the statistics where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @return the range of matching statistics
	*/
	public static List<Statistic> findByC_G(long companyId, long groupId,
		int start, int end) {
		return getPersistence().findByC_G(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the statistics where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching statistics
	*/
	public static List<Statistic> findByC_G(long companyId, long groupId,
		int start, int end, OrderByComparator<Statistic> orderByComparator) {
		return getPersistence()
				   .findByC_G(companyId, groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the statistics where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching statistics
	*/
	public static List<Statistic> findByC_G(long companyId, long groupId,
		int start, int end, OrderByComparator<Statistic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_G(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching statistic
	* @throws NoSuchStatisticException if a matching statistic could not be found
	*/
	public static Statistic findByC_G_First(long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence()
				   .findByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	*/
	public static Statistic fetchByC_G_First(long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator) {
		return getPersistence()
				   .fetchByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching statistic
	* @throws NoSuchStatisticException if a matching statistic could not be found
	*/
	public static Statistic findByC_G_Last(long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence()
				   .findByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	*/
	public static Statistic fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator) {
		return getPersistence()
				   .fetchByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the statistics before and after the current statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param statisticId the primary key of the current statistic
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next statistic
	* @throws NoSuchStatisticException if a statistic with the primary key could not be found
	*/
	public static Statistic[] findByC_G_PrevAndNext(long statisticId,
		long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence()
				   .findByC_G_PrevAndNext(statisticId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the statistics where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByC_G(long companyId, long groupId) {
		getPersistence().removeByC_G(companyId, groupId);
	}

	/**
	* Returns the number of statistics where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching statistics
	*/
	public static int countByC_G(long companyId, long groupId) {
		return getPersistence().countByC_G(companyId, groupId);
	}

	/**
	* Caches the statistic in the entity cache if it is enabled.
	*
	* @param statistic the statistic
	*/
	public static void cacheResult(Statistic statistic) {
		getPersistence().cacheResult(statistic);
	}

	/**
	* Caches the statistics in the entity cache if it is enabled.
	*
	* @param statistics the statistics
	*/
	public static void cacheResult(List<Statistic> statistics) {
		getPersistence().cacheResult(statistics);
	}

	/**
	* Creates a new statistic with the primary key. Does not add the statistic to the database.
	*
	* @param statisticId the primary key for the new statistic
	* @return the new statistic
	*/
	public static Statistic create(long statisticId) {
		return getPersistence().create(statisticId);
	}

	/**
	* Removes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic that was removed
	* @throws NoSuchStatisticException if a statistic with the primary key could not be found
	*/
	public static Statistic remove(long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence().remove(statisticId);
	}

	public static Statistic updateImpl(Statistic statistic) {
		return getPersistence().updateImpl(statistic);
	}

	/**
	* Returns the statistic with the primary key or throws a {@link NoSuchStatisticException} if it could not be found.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic
	* @throws NoSuchStatisticException if a statistic with the primary key could not be found
	*/
	public static Statistic findByPrimaryKey(long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {
		return getPersistence().findByPrimaryKey(statisticId);
	}

	/**
	* Returns the statistic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic, or <code>null</code> if a statistic with the primary key could not be found
	*/
	public static Statistic fetchByPrimaryKey(long statisticId) {
		return getPersistence().fetchByPrimaryKey(statisticId);
	}

	public static java.util.Map<java.io.Serializable, Statistic> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the statistics.
	*
	* @return the statistics
	*/
	public static List<Statistic> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @return the range of statistics
	*/
	public static List<Statistic> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of statistics
	*/
	public static List<Statistic> findAll(int start, int end,
		OrderByComparator<Statistic> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of statistics
	*/
	public static List<Statistic> findAll(int start, int end,
		OrderByComparator<Statistic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the statistics from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of statistics.
	*
	* @return the number of statistics
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatisticPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatisticPersistence, StatisticPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StatisticPersistence.class);
}