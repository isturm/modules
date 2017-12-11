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

import de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException;
import de.uhh.l2g.plugins.model.ScheduledThread;

/**
 * The persistence interface for the scheduled thread service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.persistence.impl.ScheduledThreadPersistenceImpl
 * @see ScheduledThreadUtil
 * @generated
 */
@ProviderType
public interface ScheduledThreadPersistence extends BasePersistence<ScheduledThread> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScheduledThreadUtil} to access the scheduled thread persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the scheduled thread where schedulerClassName = &#63; or throws a {@link NoSuchScheduledThreadException} if it could not be found.
	*
	* @param schedulerClassName the scheduler class name
	* @return the matching scheduled thread
	* @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	*/
	public ScheduledThread findBySchedulerClassName(
		java.lang.String schedulerClassName)
		throws NoSuchScheduledThreadException;

	/**
	* Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param schedulerClassName the scheduler class name
	* @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	*/
	public ScheduledThread fetchBySchedulerClassName(
		java.lang.String schedulerClassName);

	/**
	* Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param schedulerClassName the scheduler class name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	*/
	public ScheduledThread fetchBySchedulerClassName(
		java.lang.String schedulerClassName, boolean retrieveFromCache);

	/**
	* Removes the scheduled thread where schedulerClassName = &#63; from the database.
	*
	* @param schedulerClassName the scheduler class name
	* @return the scheduled thread that was removed
	*/
	public ScheduledThread removeBySchedulerClassName(
		java.lang.String schedulerClassName)
		throws NoSuchScheduledThreadException;

	/**
	* Returns the number of scheduled threads where schedulerClassName = &#63;.
	*
	* @param schedulerClassName the scheduler class name
	* @return the number of matching scheduled threads
	*/
	public int countBySchedulerClassName(java.lang.String schedulerClassName);

	/**
	* Caches the scheduled thread in the entity cache if it is enabled.
	*
	* @param scheduledThread the scheduled thread
	*/
	public void cacheResult(ScheduledThread scheduledThread);

	/**
	* Caches the scheduled threads in the entity cache if it is enabled.
	*
	* @param scheduledThreads the scheduled threads
	*/
	public void cacheResult(java.util.List<ScheduledThread> scheduledThreads);

	/**
	* Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	*
	* @param scheduledThreadId the primary key for the new scheduled thread
	* @return the new scheduled thread
	*/
	public ScheduledThread create(long scheduledThreadId);

	/**
	* Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread that was removed
	* @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	*/
	public ScheduledThread remove(long scheduledThreadId)
		throws NoSuchScheduledThreadException;

	public ScheduledThread updateImpl(ScheduledThread scheduledThread);

	/**
	* Returns the scheduled thread with the primary key or throws a {@link NoSuchScheduledThreadException} if it could not be found.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread
	* @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	*/
	public ScheduledThread findByPrimaryKey(long scheduledThreadId)
		throws NoSuchScheduledThreadException;

	/**
	* Returns the scheduled thread with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread, or <code>null</code> if a scheduled thread with the primary key could not be found
	*/
	public ScheduledThread fetchByPrimaryKey(long scheduledThreadId);

	@Override
	public java.util.Map<java.io.Serializable, ScheduledThread> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the scheduled threads.
	*
	* @return the scheduled threads
	*/
	public java.util.List<ScheduledThread> findAll();

	/**
	* Returns a range of all the scheduled threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scheduled threads
	* @param end the upper bound of the range of scheduled threads (not inclusive)
	* @return the range of scheduled threads
	*/
	public java.util.List<ScheduledThread> findAll(int start, int end);

	/**
	* Returns an ordered range of all the scheduled threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scheduled threads
	* @param end the upper bound of the range of scheduled threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of scheduled threads
	*/
	public java.util.List<ScheduledThread> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScheduledThread> orderByComparator);

	/**
	* Returns an ordered range of all the scheduled threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scheduled threads
	* @param end the upper bound of the range of scheduled threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of scheduled threads
	*/
	public java.util.List<ScheduledThread> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScheduledThread> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the scheduled threads from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of scheduled threads.
	*
	* @return the number of scheduled threads
	*/
	public int countAll();
}