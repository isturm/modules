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

package de.uhh.l2g.plugins.service.persistence.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import aQute.bnd.annotation.ProviderType;
import de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException;
import de.uhh.l2g.plugins.model.ScheduledThread;
import de.uhh.l2g.plugins.model.impl.ScheduledThreadImpl;
import de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl;
import de.uhh.l2g.plugins.service.persistence.ScheduledThreadPersistence;

/**
 * The persistence implementation for the scheduled thread service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ScheduledThreadPersistence
 * @see de.uhh.l2g.plugins.service.persistence.ScheduledThreadUtil
 * @generated
 */
@ProviderType
public class ScheduledThreadPersistenceImpl extends BasePersistenceImpl<ScheduledThread>
	implements ScheduledThreadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScheduledThreadUtil} to access the scheduled thread persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScheduledThreadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME = new FinderPath(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySchedulerClassName",
			new String[] { String.class.getName() },
			ScheduledThreadModelImpl.SCHEDULERCLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCHEDULERCLASSNAME = new FinderPath(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySchedulerClassName", new String[] { String.class.getName() });

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or throws a {@link NoSuchScheduledThreadException} if it could not be found.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread findBySchedulerClassName(String schedulerClassName)
		throws NoSuchScheduledThreadException {
		ScheduledThread scheduledThread = fetchBySchedulerClassName(schedulerClassName);

		if (scheduledThread == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("schedulerClassName=");
			msg.append(schedulerClassName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchScheduledThreadException(msg.toString());
		}

		return scheduledThread;
	}

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchBySchedulerClassName(String schedulerClassName) {
		return fetchBySchedulerClassName(schedulerClassName, true);
	}

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchBySchedulerClassName(
		String schedulerClassName, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { schedulerClassName };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME,
					finderArgs, this);
		}

		if (result instanceof ScheduledThread) {
			ScheduledThread scheduledThread = (ScheduledThread)result;

			if (!Objects.equals(schedulerClassName,
						scheduledThread.getSchedulerClassName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SCHEDULEDTHREAD_WHERE);

			boolean bindSchedulerClassName = false;

			if (schedulerClassName == null) {
				query.append(_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_1);
			}
			else if (schedulerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_3);
			}
			else {
				bindSchedulerClassName = true;

				query.append(_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSchedulerClassName) {
					qPos.add(schedulerClassName);
				}

				List<ScheduledThread> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ScheduledThreadPersistenceImpl.fetchBySchedulerClassName(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ScheduledThread scheduledThread = list.get(0);

					result = scheduledThread;

					cacheResult(scheduledThread);

					if ((scheduledThread.getSchedulerClassName() == null) ||
							!scheduledThread.getSchedulerClassName()
												.equals(schedulerClassName)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME,
							finderArgs, scheduledThread);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ScheduledThread)result;
		}
	}

	/**
	 * Removes the scheduled thread where schedulerClassName = &#63; from the database.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the scheduled thread that was removed
	 */
	@Override
	public ScheduledThread removeBySchedulerClassName(String schedulerClassName)
		throws NoSuchScheduledThreadException {
		ScheduledThread scheduledThread = findBySchedulerClassName(schedulerClassName);

		return remove(scheduledThread);
	}

	/**
	 * Returns the number of scheduled threads where schedulerClassName = &#63;.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the number of matching scheduled threads
	 */
	@Override
	public int countBySchedulerClassName(String schedulerClassName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCHEDULERCLASSNAME;

		Object[] finderArgs = new Object[] { schedulerClassName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCHEDULEDTHREAD_WHERE);

			boolean bindSchedulerClassName = false;

			if (schedulerClassName == null) {
				query.append(_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_1);
			}
			else if (schedulerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_3);
			}
			else {
				bindSchedulerClassName = true;

				query.append(_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSchedulerClassName) {
					qPos.add(schedulerClassName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_1 =
		"scheduledThread.schedulerClassName IS NULL";
	private static final String _FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_2 =
		"scheduledThread.schedulerClassName = ?";
	private static final String _FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_3 =
		"(scheduledThread.schedulerClassName IS NULL OR scheduledThread.schedulerClassName = '')";

	public ScheduledThreadPersistenceImpl() {
		setModelClass(ScheduledThread.class);
	}

	/**
	 * Caches the scheduled thread in the entity cache if it is enabled.
	 *
	 * @param scheduledThread the scheduled thread
	 */
	@Override
	public void cacheResult(ScheduledThread scheduledThread) {
		entityCache.putResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadImpl.class, scheduledThread.getPrimaryKey(),
			scheduledThread);

		finderCache.putResult(FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME,
			new Object[] { scheduledThread.getSchedulerClassName() },
			scheduledThread);

		scheduledThread.resetOriginalValues();
	}

	/**
	 * Caches the scheduled threads in the entity cache if it is enabled.
	 *
	 * @param scheduledThreads the scheduled threads
	 */
	@Override
	public void cacheResult(List<ScheduledThread> scheduledThreads) {
		for (ScheduledThread scheduledThread : scheduledThreads) {
			if (entityCache.getResult(
						ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
						ScheduledThreadImpl.class,
						scheduledThread.getPrimaryKey()) == null) {
				cacheResult(scheduledThread);
			}
			else {
				scheduledThread.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all scheduled threads.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ScheduledThreadImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the scheduled thread.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScheduledThread scheduledThread) {
		entityCache.removeResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadImpl.class, scheduledThread.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ScheduledThreadModelImpl)scheduledThread, true);
	}

	@Override
	public void clearCache(List<ScheduledThread> scheduledThreads) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScheduledThread scheduledThread : scheduledThreads) {
			entityCache.removeResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
				ScheduledThreadImpl.class, scheduledThread.getPrimaryKey());

			clearUniqueFindersCache((ScheduledThreadModelImpl)scheduledThread,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ScheduledThreadModelImpl scheduledThreadModelImpl) {
		Object[] args = new Object[] {
				scheduledThreadModelImpl.getSchedulerClassName()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_SCHEDULERCLASSNAME, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME, args,
			scheduledThreadModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ScheduledThreadModelImpl scheduledThreadModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					scheduledThreadModelImpl.getSchedulerClassName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SCHEDULERCLASSNAME,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME,
				args);
		}

		if ((scheduledThreadModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					scheduledThreadModelImpl.getOriginalSchedulerClassName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SCHEDULERCLASSNAME,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SCHEDULERCLASSNAME,
				args);
		}
	}

	/**
	 * Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	 *
	 * @param scheduledThreadId the primary key for the new scheduled thread
	 * @return the new scheduled thread
	 */
	@Override
	public ScheduledThread create(long scheduledThreadId) {
		ScheduledThread scheduledThread = new ScheduledThreadImpl();

		scheduledThread.setNew(true);
		scheduledThread.setPrimaryKey(scheduledThreadId);

		scheduledThread.setCompanyId(companyProvider.getCompanyId());

		return scheduledThread;
	}

	/**
	 * Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread that was removed
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread remove(long scheduledThreadId)
		throws NoSuchScheduledThreadException {
		return remove((Serializable)scheduledThreadId);
	}

	/**
	 * Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the scheduled thread
	 * @return the scheduled thread that was removed
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread remove(Serializable primaryKey)
		throws NoSuchScheduledThreadException {
		Session session = null;

		try {
			session = openSession();

			ScheduledThread scheduledThread = (ScheduledThread)session.get(ScheduledThreadImpl.class,
					primaryKey);

			if (scheduledThread == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScheduledThreadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scheduledThread);
		}
		catch (NoSuchScheduledThreadException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ScheduledThread removeImpl(ScheduledThread scheduledThread) {
		scheduledThread = toUnwrappedModel(scheduledThread);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scheduledThread)) {
				scheduledThread = (ScheduledThread)session.get(ScheduledThreadImpl.class,
						scheduledThread.getPrimaryKeyObj());
			}

			if (scheduledThread != null) {
				session.delete(scheduledThread);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scheduledThread != null) {
			clearCache(scheduledThread);
		}

		return scheduledThread;
	}

	@Override
	public ScheduledThread updateImpl(ScheduledThread scheduledThread) {
		scheduledThread = toUnwrappedModel(scheduledThread);

		boolean isNew = scheduledThread.isNew();

		ScheduledThreadModelImpl scheduledThreadModelImpl = (ScheduledThreadModelImpl)scheduledThread;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (scheduledThread.getCreateDate() == null)) {
			if (serviceContext == null) {
				scheduledThread.setCreateDate(now);
			}
			else {
				scheduledThread.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!scheduledThreadModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				scheduledThread.setModifiedDate(now);
			}
			else {
				scheduledThread.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (scheduledThread.isNew()) {
				session.save(scheduledThread);

				scheduledThread.setNew(false);
			}
			else {
				scheduledThread = (ScheduledThread)session.merge(scheduledThread);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ScheduledThreadModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadImpl.class, scheduledThread.getPrimaryKey(),
			scheduledThread, false);

		clearUniqueFindersCache(scheduledThreadModelImpl, false);
		cacheUniqueFindersCache(scheduledThreadModelImpl);

		scheduledThread.resetOriginalValues();

		return scheduledThread;
	}

	protected ScheduledThread toUnwrappedModel(ScheduledThread scheduledThread) {
		if (scheduledThread instanceof ScheduledThreadImpl) {
			return scheduledThread;
		}

		ScheduledThreadImpl scheduledThreadImpl = new ScheduledThreadImpl();

		scheduledThreadImpl.setNew(scheduledThread.isNew());
		scheduledThreadImpl.setPrimaryKey(scheduledThread.getPrimaryKey());

		scheduledThreadImpl.setScheduledThreadId(scheduledThread.getScheduledThreadId());
		scheduledThreadImpl.setGroupId(scheduledThread.getGroupId());
		scheduledThreadImpl.setCompanyId(scheduledThread.getCompanyId());
		scheduledThreadImpl.setUserId(scheduledThread.getUserId());
		scheduledThreadImpl.setUserName(scheduledThread.getUserName());
		scheduledThreadImpl.setCreateDate(scheduledThread.getCreateDate());
		scheduledThreadImpl.setModifiedDate(scheduledThread.getModifiedDate());
		scheduledThreadImpl.setSchedulerClassName(scheduledThread.getSchedulerClassName());
		scheduledThreadImpl.setCronText(scheduledThread.getCronText());

		return scheduledThreadImpl;
	}

	/**
	 * Returns the scheduled thread with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the scheduled thread
	 * @return the scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScheduledThreadException {
		ScheduledThread scheduledThread = fetchByPrimaryKey(primaryKey);

		if (scheduledThread == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScheduledThreadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scheduledThread;
	}

	/**
	 * Returns the scheduled thread with the primary key or throws a {@link NoSuchScheduledThreadException} if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread findByPrimaryKey(long scheduledThreadId)
		throws NoSuchScheduledThreadException {
		return findByPrimaryKey((Serializable)scheduledThreadId);
	}

	/**
	 * Returns the scheduled thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the scheduled thread
	 * @return the scheduled thread, or <code>null</code> if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
				ScheduledThreadImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ScheduledThread scheduledThread = (ScheduledThread)serializable;

		if (scheduledThread == null) {
			Session session = null;

			try {
				session = openSession();

				scheduledThread = (ScheduledThread)session.get(ScheduledThreadImpl.class,
						primaryKey);

				if (scheduledThread != null) {
					cacheResult(scheduledThread);
				}
				else {
					entityCache.putResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
						ScheduledThreadImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
					ScheduledThreadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scheduledThread;
	}

	/**
	 * Returns the scheduled thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread, or <code>null</code> if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread fetchByPrimaryKey(long scheduledThreadId) {
		return fetchByPrimaryKey((Serializable)scheduledThreadId);
	}

	@Override
	public Map<Serializable, ScheduledThread> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ScheduledThread> map = new HashMap<Serializable, ScheduledThread>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ScheduledThread scheduledThread = fetchByPrimaryKey(primaryKey);

			if (scheduledThread != null) {
				map.put(primaryKey, scheduledThread);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
					ScheduledThreadImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ScheduledThread)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SCHEDULEDTHREAD_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ScheduledThread scheduledThread : (List<ScheduledThread>)q.list()) {
				map.put(scheduledThread.getPrimaryKeyObj(), scheduledThread);

				cacheResult(scheduledThread);

				uncachedPrimaryKeys.remove(scheduledThread.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
					ScheduledThreadImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the scheduled threads.
	 *
	 * @return the scheduled threads
	 */
	@Override
	public List<ScheduledThread> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ScheduledThread> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ScheduledThread> findAll(int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ScheduledThread> findAll(int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ScheduledThread> list = null;

		if (retrieveFromCache) {
			list = (List<ScheduledThread>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SCHEDULEDTHREAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCHEDULEDTHREAD;

				if (pagination) {
					sql = sql.concat(ScheduledThreadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScheduledThread>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ScheduledThread>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the scheduled threads from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ScheduledThread scheduledThread : findAll()) {
			remove(scheduledThread);
		}
	}

	/**
	 * Returns the number of scheduled threads.
	 *
	 * @return the number of scheduled threads
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SCHEDULEDTHREAD);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ScheduledThreadModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the scheduled thread persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ScheduledThreadImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SCHEDULEDTHREAD = "SELECT scheduledThread FROM ScheduledThread scheduledThread";
	private static final String _SQL_SELECT_SCHEDULEDTHREAD_WHERE_PKS_IN = "SELECT scheduledThread FROM ScheduledThread scheduledThread WHERE scheduledThreadId IN (";
	private static final String _SQL_SELECT_SCHEDULEDTHREAD_WHERE = "SELECT scheduledThread FROM ScheduledThread scheduledThread WHERE ";
	private static final String _SQL_COUNT_SCHEDULEDTHREAD = "SELECT COUNT(scheduledThread) FROM ScheduledThread scheduledThread";
	private static final String _SQL_COUNT_SCHEDULEDTHREAD_WHERE = "SELECT COUNT(scheduledThread) FROM ScheduledThread scheduledThread WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scheduledThread.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScheduledThread exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ScheduledThread exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ScheduledThreadPersistenceImpl.class);
}