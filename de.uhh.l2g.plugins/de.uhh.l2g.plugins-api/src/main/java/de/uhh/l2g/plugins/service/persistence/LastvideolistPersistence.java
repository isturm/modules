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

import de.uhh.l2g.plugins.exception.NoSuchLastvideolistException;
import de.uhh.l2g.plugins.model.Lastvideolist;

/**
 * The persistence interface for the lastvideolist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.persistence.impl.LastvideolistPersistenceImpl
 * @see LastvideolistUtil
 * @generated
 */
@ProviderType
public interface LastvideolistPersistence extends BasePersistence<Lastvideolist> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LastvideolistUtil} to access the lastvideolist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the lastvideolists where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching lastvideolists
	*/
	public java.util.List<Lastvideolist> findByVideo(long videoId);

	/**
	* Returns a range of all the lastvideolists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @return the range of matching lastvideolists
	*/
	public java.util.List<Lastvideolist> findByVideo(long videoId, int start,
		int end);

	/**
	* Returns an ordered range of all the lastvideolists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lastvideolists
	*/
	public java.util.List<Lastvideolist> findByVideo(long videoId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist> orderByComparator);

	/**
	* Returns an ordered range of all the lastvideolists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lastvideolists
	*/
	public java.util.List<Lastvideolist> findByVideo(long videoId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lastvideolist
	* @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	*/
	public Lastvideolist findByVideo_First(long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	* Returns the first lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	*/
	public Lastvideolist fetchByVideo_First(long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist> orderByComparator);

	/**
	* Returns the last lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lastvideolist
	* @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	*/
	public Lastvideolist findByVideo_Last(long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	* Returns the last lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	*/
	public Lastvideolist fetchByVideo_Last(long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist> orderByComparator);

	/**
	* Returns the lastvideolists before and after the current lastvideolist in the ordered set where videoId = &#63;.
	*
	* @param lastvideolistId the primary key of the current lastvideolist
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lastvideolist
	* @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	*/
	public Lastvideolist[] findByVideo_PrevAndNext(int lastvideolistId,
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	* Removes all the lastvideolists where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	*/
	public void removeByVideo(long videoId);

	/**
	* Returns the number of lastvideolists where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching lastvideolists
	*/
	public int countByVideo(long videoId);

	/**
	* Caches the lastvideolist in the entity cache if it is enabled.
	*
	* @param lastvideolist the lastvideolist
	*/
	public void cacheResult(Lastvideolist lastvideolist);

	/**
	* Caches the lastvideolists in the entity cache if it is enabled.
	*
	* @param lastvideolists the lastvideolists
	*/
	public void cacheResult(java.util.List<Lastvideolist> lastvideolists);

	/**
	* Creates a new lastvideolist with the primary key. Does not add the lastvideolist to the database.
	*
	* @param lastvideolistId the primary key for the new lastvideolist
	* @return the new lastvideolist
	*/
	public Lastvideolist create(int lastvideolistId);

	/**
	* Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lastvideolistId the primary key of the lastvideolist
	* @return the lastvideolist that was removed
	* @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	*/
	public Lastvideolist remove(int lastvideolistId)
		throws NoSuchLastvideolistException;

	public Lastvideolist updateImpl(Lastvideolist lastvideolist);

	/**
	* Returns the lastvideolist with the primary key or throws a {@link NoSuchLastvideolistException} if it could not be found.
	*
	* @param lastvideolistId the primary key of the lastvideolist
	* @return the lastvideolist
	* @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	*/
	public Lastvideolist findByPrimaryKey(int lastvideolistId)
		throws NoSuchLastvideolistException;

	/**
	* Returns the lastvideolist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lastvideolistId the primary key of the lastvideolist
	* @return the lastvideolist, or <code>null</code> if a lastvideolist with the primary key could not be found
	*/
	public Lastvideolist fetchByPrimaryKey(int lastvideolistId);

	@Override
	public java.util.Map<java.io.Serializable, Lastvideolist> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lastvideolists.
	*
	* @return the lastvideolists
	*/
	public java.util.List<Lastvideolist> findAll();

	/**
	* Returns a range of all the lastvideolists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @return the range of lastvideolists
	*/
	public java.util.List<Lastvideolist> findAll(int start, int end);

	/**
	* Returns an ordered range of all the lastvideolists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lastvideolists
	*/
	public java.util.List<Lastvideolist> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist> orderByComparator);

	/**
	* Returns an ordered range of all the lastvideolists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lastvideolists
	*/
	public java.util.List<Lastvideolist> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lastvideolists from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lastvideolists.
	*
	* @return the number of lastvideolists
	*/
	public int countAll();
}