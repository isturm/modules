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

import de.uhh.l2g.plugins.exception.NoSuchCreatorException;
import de.uhh.l2g.plugins.model.Creator;

/**
 * The persistence interface for the creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.persistence.impl.CreatorPersistenceImpl
 * @see CreatorUtil
 * @generated
 */
@ProviderType
public interface CreatorPersistence extends BasePersistence<Creator> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CreatorUtil} to access the creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the creators where firstName = &#63;.
	*
	* @param firstName the first name
	* @return the matching creators
	*/
	public java.util.List<Creator> findByFirstName(java.lang.String firstName);

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
	public java.util.List<Creator> findByFirstName(java.lang.String firstName,
		int start, int end);

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
	public java.util.List<Creator> findByFirstName(java.lang.String firstName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

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
	public java.util.List<Creator> findByFirstName(java.lang.String firstName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first creator in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public Creator findByFirstName_First(java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Returns the first creator in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public Creator fetchByFirstName_First(java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

	/**
	* Returns the last creator in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public Creator findByFirstName_Last(java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Returns the last creator in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public Creator fetchByFirstName_Last(java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

	/**
	* Returns the creators before and after the current creator in the ordered set where firstName = &#63;.
	*
	* @param creatorId the primary key of the current creator
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public Creator[] findByFirstName_PrevAndNext(long creatorId,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Removes all the creators where firstName = &#63; from the database.
	*
	* @param firstName the first name
	*/
	public void removeByFirstName(java.lang.String firstName);

	/**
	* Returns the number of creators where firstName = &#63;.
	*
	* @param firstName the first name
	* @return the number of matching creators
	*/
	public int countByFirstName(java.lang.String firstName);

	/**
	* Returns all the creators where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the matching creators
	*/
	public java.util.List<Creator> findByLastName(java.lang.String lastName);

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
	public java.util.List<Creator> findByLastName(java.lang.String lastName,
		int start, int end);

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
	public java.util.List<Creator> findByLastName(java.lang.String lastName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

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
	public java.util.List<Creator> findByLastName(java.lang.String lastName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first creator in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public Creator findByLastName_First(java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Returns the first creator in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public Creator fetchByLastName_First(java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

	/**
	* Returns the last creator in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public Creator findByLastName_Last(java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Returns the last creator in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public Creator fetchByLastName_Last(java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

	/**
	* Returns the creators before and after the current creator in the ordered set where lastName = &#63;.
	*
	* @param creatorId the primary key of the current creator
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public Creator[] findByLastName_PrevAndNext(long creatorId,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Removes all the creators where lastName = &#63; from the database.
	*
	* @param lastName the last name
	*/
	public void removeByLastName(java.lang.String lastName);

	/**
	* Returns the number of creators where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the number of matching creators
	*/
	public int countByLastName(java.lang.String lastName);

	/**
	* Returns all the creators where middleName = &#63;.
	*
	* @param middleName the middle name
	* @return the matching creators
	*/
	public java.util.List<Creator> findByMiddleName(java.lang.String middleName);

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
	public java.util.List<Creator> findByMiddleName(
		java.lang.String middleName, int start, int end);

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
	public java.util.List<Creator> findByMiddleName(
		java.lang.String middleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

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
	public java.util.List<Creator> findByMiddleName(
		java.lang.String middleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first creator in the ordered set where middleName = &#63;.
	*
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public Creator findByMiddleName_First(java.lang.String middleName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Returns the first creator in the ordered set where middleName = &#63;.
	*
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public Creator fetchByMiddleName_First(java.lang.String middleName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

	/**
	* Returns the last creator in the ordered set where middleName = &#63;.
	*
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public Creator findByMiddleName_Last(java.lang.String middleName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Returns the last creator in the ordered set where middleName = &#63;.
	*
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public Creator fetchByMiddleName_Last(java.lang.String middleName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

	/**
	* Returns the creators before and after the current creator in the ordered set where middleName = &#63;.
	*
	* @param creatorId the primary key of the current creator
	* @param middleName the middle name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public Creator[] findByMiddleName_PrevAndNext(long creatorId,
		java.lang.String middleName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Removes all the creators where middleName = &#63; from the database.
	*
	* @param middleName the middle name
	*/
	public void removeByMiddleName(java.lang.String middleName);

	/**
	* Returns the number of creators where middleName = &#63;.
	*
	* @param middleName the middle name
	* @return the number of matching creators
	*/
	public int countByMiddleName(java.lang.String middleName);

	/**
	* Returns all the creators where fullName = &#63;.
	*
	* @param fullName the full name
	* @return the matching creators
	*/
	public java.util.List<Creator> findByFullName(java.lang.String fullName);

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
	public java.util.List<Creator> findByFullName(java.lang.String fullName,
		int start, int end);

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
	public java.util.List<Creator> findByFullName(java.lang.String fullName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

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
	public java.util.List<Creator> findByFullName(java.lang.String fullName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first creator in the ordered set where fullName = &#63;.
	*
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public Creator findByFullName_First(java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Returns the first creator in the ordered set where fullName = &#63;.
	*
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public Creator fetchByFullName_First(java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

	/**
	* Returns the last creator in the ordered set where fullName = &#63;.
	*
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator
	* @throws NoSuchCreatorException if a matching creator could not be found
	*/
	public Creator findByFullName_Last(java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Returns the last creator in the ordered set where fullName = &#63;.
	*
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching creator, or <code>null</code> if a matching creator could not be found
	*/
	public Creator fetchByFullName_Last(java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

	/**
	* Returns the creators before and after the current creator in the ordered set where fullName = &#63;.
	*
	* @param creatorId the primary key of the current creator
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public Creator[] findByFullName_PrevAndNext(long creatorId,
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException;

	/**
	* Removes all the creators where fullName = &#63; from the database.
	*
	* @param fullName the full name
	*/
	public void removeByFullName(java.lang.String fullName);

	/**
	* Returns the number of creators where fullName = &#63;.
	*
	* @param fullName the full name
	* @return the number of matching creators
	*/
	public int countByFullName(java.lang.String fullName);

	/**
	* Caches the creator in the entity cache if it is enabled.
	*
	* @param creator the creator
	*/
	public void cacheResult(Creator creator);

	/**
	* Caches the creators in the entity cache if it is enabled.
	*
	* @param creators the creators
	*/
	public void cacheResult(java.util.List<Creator> creators);

	/**
	* Creates a new creator with the primary key. Does not add the creator to the database.
	*
	* @param creatorId the primary key for the new creator
	* @return the new creator
	*/
	public Creator create(long creatorId);

	/**
	* Removes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creatorId the primary key of the creator
	* @return the creator that was removed
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public Creator remove(long creatorId) throws NoSuchCreatorException;

	public Creator updateImpl(Creator creator);

	/**
	* Returns the creator with the primary key or throws a {@link NoSuchCreatorException} if it could not be found.
	*
	* @param creatorId the primary key of the creator
	* @return the creator
	* @throws NoSuchCreatorException if a creator with the primary key could not be found
	*/
	public Creator findByPrimaryKey(long creatorId)
		throws NoSuchCreatorException;

	/**
	* Returns the creator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param creatorId the primary key of the creator
	* @return the creator, or <code>null</code> if a creator with the primary key could not be found
	*/
	public Creator fetchByPrimaryKey(long creatorId);

	@Override
	public java.util.Map<java.io.Serializable, Creator> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the creators.
	*
	* @return the creators
	*/
	public java.util.List<Creator> findAll();

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
	public java.util.List<Creator> findAll(int start, int end);

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
	public java.util.List<Creator> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator);

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
	public java.util.List<Creator> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the creators from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of creators.
	*
	* @return the number of creators
	*/
	public int countAll();
}