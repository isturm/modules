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

import de.uhh.l2g.plugins.model.Creator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the creator service. This utility wraps {@link de.uhh.l2g.plugins.service.persistence.impl.CreatorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CreatorPersistence
 * @see de.uhh.l2g.plugins.service.persistence.impl.CreatorPersistenceImpl
 * @generated
 */
@ProviderType
public class CreatorUtil {
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
	public static void clearCache(Creator creator) {
		getPersistence().clearCache(creator);
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
	public static List<Creator> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Creator update(Creator creator) {
		return getPersistence().update(creator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Creator update(Creator creator, ServiceContext serviceContext) {
		return getPersistence().update(creator, serviceContext);
	}

	/**
	* Returns all the creators where firstName = &#63;.
	*
	* @param firstName the first name
	* @return the matching creators
	*/
	public static List<Creator> findByFirstName(java.lang.String firstName) {
		return getPersistence().findByFirstName(firstName);
	}

	/**
	* Returns a range of all the creators where firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @return the range of matching creators
	*/
	public static List<Creator> findByFirstName(java.lang.String firstName,
		int start, int end) {
		return getPersistence().findByFirstName(firstName, start, end);
	}

	/**
	* Returns an ordered range of all the creators where firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching creators
	*/
	public static List<Creator> findByFirstName(java.lang.String firstName,
		int start, int end, OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .findByFirstName(firstName, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the creators where firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching creators
	*/
	public static List<Creator> findByFirstName(java.lang.String firstName,
		int start, int end, OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFirstName(firstName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first creator in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public static Creator findByFirstName_First(java.lang.String firstName,
		OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence()
				   .findByFirstName_First(firstName, orderByComparator);
	}

	/**
	* Returns the first creator in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public static Creator fetchByFirstName_First(java.lang.String firstName,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .fetchByFirstName_First(firstName, orderByComparator);
	}

	/**
	* Returns the last creator in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public static Creator findByFirstName_Last(java.lang.String firstName,
		OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence()
				   .findByFirstName_Last(firstName, orderByComparator);
	}

	/**
	* Returns the last creator in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public static Creator fetchByFirstName_Last(java.lang.String firstName,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .fetchByFirstName_Last(firstName, orderByComparator);
	}

	/**
	* Returns the creators before and after the current creator in the ordered set where firstName = &#63;.
	*
	* @param creatorId the primary key of the current creator
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public static Creator[] findByFirstName_PrevAndNext(long creatorId,
		java.lang.String firstName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence()
				   .findByFirstName_PrevAndNext(creatorId, firstName,
			orderByComparator);
	}

	/**
	* Removes all the creators where firstName = &#63; from the database.
	*
	* @param firstName the first name
	*/
	public static void removeByFirstName(java.lang.String firstName) {
		getPersistence().removeByFirstName(firstName);
	}

	/**
	* Returns the number of creators where firstName = &#63;.
	*
	* @param firstName the first name
	* @return the number of matching creators
	*/
	public static int countByFirstName(java.lang.String firstName) {
		return getPersistence().countByFirstName(firstName);
	}

	/**
	* Returns all the creators where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the matching creators
	*/
	public static List<Creator> findByLastName(java.lang.String lastName) {
		return getPersistence().findByLastName(lastName);
	}

	/**
	* Returns a range of all the creators where lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lastName the last name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @return the range of matching creators
	*/
	public static List<Creator> findByLastName(java.lang.String lastName,
		int start, int end) {
		return getPersistence().findByLastName(lastName, start, end);
	}

	/**
	* Returns an ordered range of all the creators where lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lastName the last name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching creators
	*/
	public static List<Creator> findByLastName(java.lang.String lastName,
		int start, int end, OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .findByLastName(lastName, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the creators where lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lastName the last name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching creators
	*/
	public static List<Creator> findByLastName(java.lang.String lastName,
		int start, int end, OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByLastName(lastName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first creator in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public static Creator findByLastName_First(java.lang.String lastName,
		OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence().findByLastName_First(lastName, orderByComparator);
	}

	/**
	* Returns the first creator in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public static Creator fetchByLastName_First(java.lang.String lastName,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .fetchByLastName_First(lastName, orderByComparator);
	}

	/**
	* Returns the last creator in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public static Creator findByLastName_Last(java.lang.String lastName,
		OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence().findByLastName_Last(lastName, orderByComparator);
	}

	/**
	* Returns the last creator in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public static Creator fetchByLastName_Last(java.lang.String lastName,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence().fetchByLastName_Last(lastName, orderByComparator);
	}

	/**
	* Returns the creators before and after the current creator in the ordered set where lastName = &#63;.
	*
	* @param creatorId the primary key of the current creator
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public static Creator[] findByLastName_PrevAndNext(long creatorId,
		java.lang.String lastName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence()
				   .findByLastName_PrevAndNext(creatorId, lastName,
			orderByComparator);
	}

	/**
	* Removes all the creators where lastName = &#63; from the database.
	*
	* @param lastName the last name
	*/
	public static void removeByLastName(java.lang.String lastName) {
		getPersistence().removeByLastName(lastName);
	}

	/**
	* Returns the number of creators where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the number of matching creators
	*/
	public static int countByLastName(java.lang.String lastName) {
		return getPersistence().countByLastName(lastName);
	}

	/**
	* Returns all the creators where middleName = &#63;.
	*
	* @param middleName the middle name
	* @return the matching creators
	*/
	public static List<Creator> findByMiddleName(java.lang.String middleName) {
		return getPersistence().findByMiddleName(middleName);
	}

	/**
	* Returns a range of all the creators where middleName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param middleName the middle name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @return the range of matching creators
	*/
	public static List<Creator> findByMiddleName(java.lang.String middleName,
		int start, int end) {
		return getPersistence().findByMiddleName(middleName, start, end);
	}

	/**
	* Returns an ordered range of all the creators where middleName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param middleName the middle name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching creators
	*/
	public static List<Creator> findByMiddleName(java.lang.String middleName,
		int start, int end, OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .findByMiddleName(middleName, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the creators where middleName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param middleName the middle name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching creators
	*/
	public static List<Creator> findByMiddleName(java.lang.String middleName,
		int start, int end, OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMiddleName(middleName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first creator in the ordered set where middleName = &#63;.
	*
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public static Creator findByMiddleName_First(java.lang.String middleName,
		OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence()
				   .findByMiddleName_First(middleName, orderByComparator);
	}

	/**
	* Returns the first creator in the ordered set where middleName = &#63;.
	*
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public static Creator fetchByMiddleName_First(java.lang.String middleName,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .fetchByMiddleName_First(middleName, orderByComparator);
	}

	/**
	* Returns the last creator in the ordered set where middleName = &#63;.
	*
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public static Creator findByMiddleName_Last(java.lang.String middleName,
		OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence()
				   .findByMiddleName_Last(middleName, orderByComparator);
	}

	/**
	* Returns the last creator in the ordered set where middleName = &#63;.
	*
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public static Creator fetchByMiddleName_Last(java.lang.String middleName,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .fetchByMiddleName_Last(middleName, orderByComparator);
	}

	/**
	* Returns the creators before and after the current creator in the ordered set where middleName = &#63;.
	*
	* @param creatorId the primary key of the current creator
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public static Creator[] findByMiddleName_PrevAndNext(long creatorId,
		java.lang.String middleName,
		OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence()
				   .findByMiddleName_PrevAndNext(creatorId, middleName,
			orderByComparator);
	}

	/**
	* Removes all the creators where middleName = &#63; from the database.
	*
	* @param middleName the middle name
	*/
	public static void removeByMiddleName(java.lang.String middleName) {
		getPersistence().removeByMiddleName(middleName);
	}

	/**
	* Returns the number of creators where middleName = &#63;.
	*
	* @param middleName the middle name
	* @return the number of matching creators
	*/
	public static int countByMiddleName(java.lang.String middleName) {
		return getPersistence().countByMiddleName(middleName);
	}

	/**
	* Returns all the creators where fullName = &#63;.
	*
	* @param fullName the full name
	* @return the matching creators
	*/
	public static List<Creator> findByFullName(java.lang.String fullName) {
		return getPersistence().findByFullName(fullName);
	}

	/**
	* Returns a range of all the creators where fullName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fullName the full name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @return the range of matching creators
	*/
	public static List<Creator> findByFullName(java.lang.String fullName,
		int start, int end) {
		return getPersistence().findByFullName(fullName, start, end);
	}

	/**
	* Returns an ordered range of all the creators where fullName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fullName the full name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching creators
	*/
	public static List<Creator> findByFullName(java.lang.String fullName,
		int start, int end, OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .findByFullName(fullName, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the creators where fullName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fullName the full name
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching creators
	*/
	public static List<Creator> findByFullName(java.lang.String fullName,
		int start, int end, OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFullName(fullName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first creator in the ordered set where fullName = &#63;.
	*
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public static Creator findByFullName_First(java.lang.String fullName,
		OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence().findByFullName_First(fullName, orderByComparator);
	}

	/**
	* Returns the first creator in the ordered set where fullName = &#63;.
	*
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public static Creator fetchByFullName_First(java.lang.String fullName,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence()
				   .fetchByFullName_First(fullName, orderByComparator);
	}

	/**
	* Returns the last creator in the ordered set where fullName = &#63;.
	*
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public static Creator findByFullName_Last(java.lang.String fullName,
		OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence().findByFullName_Last(fullName, orderByComparator);
	}

	/**
	* Returns the last creator in the ordered set where fullName = &#63;.
	*
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public static Creator fetchByFullName_Last(java.lang.String fullName,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence().fetchByFullName_Last(fullName, orderByComparator);
	}

	/**
	* Returns the creators before and after the current creator in the ordered set where fullName = &#63;.
	*
	* @param creatorId the primary key of the current creator
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public static Creator[] findByFullName_PrevAndNext(long creatorId,
		java.lang.String fullName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence()
				   .findByFullName_PrevAndNext(creatorId, fullName,
			orderByComparator);
	}

	/**
	* Removes all the creators where fullName = &#63; from the database.
	*
	* @param fullName the full name
	*/
	public static void removeByFullName(java.lang.String fullName) {
		getPersistence().removeByFullName(fullName);
	}

	/**
	* Returns the number of creators where fullName = &#63;.
	*
	* @param fullName the full name
	* @return the number of matching creators
	*/
	public static int countByFullName(java.lang.String fullName) {
		return getPersistence().countByFullName(fullName);
	}

	/**
	* Caches the creator in the entity cache if it is enabled.
	*
	* @param creator the creator
	*/
	public static void cacheResult(Creator creator) {
		getPersistence().cacheResult(creator);
	}

	/**
	* Caches the creators in the entity cache if it is enabled.
	*
	* @param creators the creators
	*/
	public static void cacheResult(List<Creator> creators) {
		getPersistence().cacheResult(creators);
	}

	/**
	* Creates a new creator with the primary key. Does not add the creator to the database.
	*
	* @param creatorId the primary key for the new creator
	* @return the new creator
	*/
	public static Creator create(long creatorId) {
		return getPersistence().create(creatorId);
	}

	/**
	* Removes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creatorId the primary key of the creator
	* @return the creator that was removed
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public static Creator remove(long creatorId)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence().remove(creatorId);
	}

	public static Creator updateImpl(Creator creator) {
		return getPersistence().updateImpl(creator);
	}

	/**
	* Returns the creator with the primary key or throws a {@link NoSuchCreatorException} if it could not be found.
	*
	* @param creatorId the primary key of the creator
	* @return the creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public static Creator findByPrimaryKey(long creatorId)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {
		return getPersistence().findByPrimaryKey(creatorId);
	}

	/**
	* Returns the creator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param creatorId the primary key of the creator
	* @return the creator, or <code>null</code> if a creator with the primary key could not be found
	*/
	public static Creator fetchByPrimaryKey(long creatorId) {
		return getPersistence().fetchByPrimaryKey(creatorId);
	}

	public static java.util.Map<java.io.Serializable, Creator> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the creators.
	*
	* @return the creators
	*/
	public static List<Creator> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @return the range of creators
	*/
	public static List<Creator> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of creators
	*/
	public static List<Creator> findAll(int start, int end,
		OrderByComparator<Creator> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of creators
	*/
	public static List<Creator> findAll(int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the creators from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of creators.
	*
	* @return the number of creators
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CreatorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CreatorPersistence, CreatorPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CreatorPersistence.class);
}