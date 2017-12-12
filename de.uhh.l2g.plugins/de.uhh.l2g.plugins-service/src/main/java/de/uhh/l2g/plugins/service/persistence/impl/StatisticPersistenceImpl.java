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

import aQute.bnd.annotation.ProviderType;

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

import de.uhh.l2g.plugins.exception.NoSuchStatisticException;
import de.uhh.l2g.plugins.model.Statistic;
import de.uhh.l2g.plugins.model.impl.StatisticImpl;
import de.uhh.l2g.plugins.model.impl.StatisticModelImpl;
import de.uhh.l2g.plugins.service.persistence.StatisticPersistence;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the statistic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see StatisticPersistence
 * @see de.uhh.l2g.plugins.service.persistence.StatisticUtil
 * @generated
 */
@ProviderType
public class StatisticPersistenceImpl extends BasePersistenceImpl<Statistic>
	implements StatisticPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatisticUtil} to access the statistic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatisticImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_STATISTICID = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStatisticId",
			new String[] { Long.class.getName() },
			StatisticModelImpl.STATISTICID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATISTICID = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatisticId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the statistic where statisticId = &#63; or throws a {@link NoSuchStatisticException} if it could not be found.
	 *
	 * @param statisticId the statistic ID
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByStatisticId(long statisticId)
		throws NoSuchStatisticException {
		Statistic statistic = fetchByStatisticId(statisticId);

		if (statistic == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("statisticId=");
			msg.append(statisticId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchStatisticException(msg.toString());
		}

		return statistic;
	}

	/**
	 * Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param statisticId the statistic ID
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByStatisticId(long statisticId) {
		return fetchByStatisticId(statisticId, true);
	}

	/**
	 * Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param statisticId the statistic ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByStatisticId(long statisticId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { statisticId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_STATISTICID,
					finderArgs, this);
		}

		if (result instanceof Statistic) {
			Statistic statistic = (Statistic)result;

			if ((statisticId != statistic.getStatisticId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STATISTIC_WHERE);

			query.append(_FINDER_COLUMN_STATISTICID_STATISTICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statisticId);

				List<Statistic> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_STATISTICID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"StatisticPersistenceImpl.fetchByStatisticId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Statistic statistic = list.get(0);

					result = statistic;

					cacheResult(statistic);

					if ((statistic.getStatisticId() != statisticId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_STATISTICID,
							finderArgs, statistic);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_STATISTICID,
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
			return (Statistic)result;
		}
	}

	/**
	 * Removes the statistic where statisticId = &#63; from the database.
	 *
	 * @param statisticId the statistic ID
	 * @return the statistic that was removed
	 */
	@Override
	public Statistic removeByStatisticId(long statisticId)
		throws NoSuchStatisticException {
		Statistic statistic = findByStatisticId(statisticId);

		return remove(statistic);
	}

	/**
	 * Returns the number of statistics where statisticId = &#63;.
	 *
	 * @param statisticId the statistic ID
	 * @return the number of matching statistics
	 */
	@Override
	public int countByStatisticId(long statisticId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATISTICID;

		Object[] finderArgs = new Object[] { statisticId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATISTIC_WHERE);

			query.append(_FINDER_COLUMN_STATISTICID_STATISTICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statisticId);

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

	private static final String _FINDER_COLUMN_STATISTICID_STATISTICID_2 = "statistic.statisticId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_S = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			StatisticModelImpl.COMPANYID_COLUMN_BITMASK |
			StatisticModelImpl.GROUPID_COLUMN_BITMASK |
			StatisticModelImpl.STATISTICID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_S = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or throws a {@link NoSuchStatisticException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByC_G_S(long companyId, long groupId, long statisticId)
		throws NoSuchStatisticException {
		Statistic statistic = fetchByC_G_S(companyId, groupId, statisticId);

		if (statistic == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", statisticId=");
			msg.append(statisticId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchStatisticException(msg.toString());
		}

		return statistic;
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByC_G_S(long companyId, long groupId, long statisticId) {
		return fetchByC_G_S(companyId, groupId, statisticId, true);
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
	@Override
	public Statistic fetchByC_G_S(long companyId, long groupId,
		long statisticId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { companyId, groupId, statisticId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_G_S,
					finderArgs, this);
		}

		if (result instanceof Statistic) {
			Statistic statistic = (Statistic)result;

			if ((companyId != statistic.getCompanyId()) ||
					(groupId != statistic.getGroupId()) ||
					(statisticId != statistic.getStatisticId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_STATISTIC_WHERE);

			query.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_S_STATISTICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(statisticId);

				List<Statistic> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_G_S,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"StatisticPersistenceImpl.fetchByC_G_S(long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Statistic statistic = list.get(0);

					result = statistic;

					cacheResult(statistic);

					if ((statistic.getCompanyId() != companyId) ||
							(statistic.getGroupId() != groupId) ||
							(statistic.getStatisticId() != statisticId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_G_S,
							finderArgs, statistic);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_G_S, finderArgs);

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
			return (Statistic)result;
		}
	}

	/**
	 * Removes the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the statistic that was removed
	 */
	@Override
	public Statistic removeByC_G_S(long companyId, long groupId,
		long statisticId) throws NoSuchStatisticException {
		Statistic statistic = findByC_G_S(companyId, groupId, statisticId);

		return remove(statistic);
	}

	/**
	 * Returns the number of statistics where companyId = &#63; and groupId = &#63; and statisticId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the number of matching statistics
	 */
	@Override
	public int countByC_G_S(long companyId, long groupId, long statisticId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_S;

		Object[] finderArgs = new Object[] { companyId, groupId, statisticId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STATISTIC_WHERE);

			query.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_S_STATISTICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(statisticId);

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

	private static final String _FINDER_COLUMN_C_G_S_COMPANYID_2 = "statistic.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_S_GROUPID_2 = "statistic.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_S_STATISTICID_2 = "statistic.statisticId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_D = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_D",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			StatisticModelImpl.COMPANYID_COLUMN_BITMASK |
			StatisticModelImpl.GROUPID_COLUMN_BITMASK |
			StatisticModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_D = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_D",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or throws a {@link NoSuchStatisticException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByC_G_D(long companyId, long groupId, Date createDate)
		throws NoSuchStatisticException {
		Statistic statistic = fetchByC_G_D(companyId, groupId, createDate);

		if (statistic == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", createDate=");
			msg.append(createDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchStatisticException(msg.toString());
		}

		return statistic;
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByC_G_D(long companyId, long groupId, Date createDate) {
		return fetchByC_G_D(companyId, groupId, createDate, true);
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
	@Override
	public Statistic fetchByC_G_D(long companyId, long groupId,
		Date createDate, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { companyId, groupId, createDate };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_G_D,
					finderArgs, this);
		}

		if (result instanceof Statistic) {
			Statistic statistic = (Statistic)result;

			if ((companyId != statistic.getCompanyId()) ||
					(groupId != statistic.getGroupId()) ||
					!Objects.equals(createDate, statistic.getCreateDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_STATISTIC_WHERE);

			query.append(_FINDER_COLUMN_C_G_D_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_D_GROUPID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_G_D_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_G_D_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				List<Statistic> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_G_D,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"StatisticPersistenceImpl.fetchByC_G_D(long, long, Date, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Statistic statistic = list.get(0);

					result = statistic;

					cacheResult(statistic);

					if ((statistic.getCompanyId() != companyId) ||
							(statistic.getGroupId() != groupId) ||
							(statistic.getCreateDate() == null) ||
							!statistic.getCreateDate().equals(createDate)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_G_D,
							finderArgs, statistic);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_G_D, finderArgs);

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
			return (Statistic)result;
		}
	}

	/**
	 * Removes the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the statistic that was removed
	 */
	@Override
	public Statistic removeByC_G_D(long companyId, long groupId, Date createDate)
		throws NoSuchStatisticException {
		Statistic statistic = findByC_G_D(companyId, groupId, createDate);

		return remove(statistic);
	}

	/**
	 * Returns the number of statistics where companyId = &#63; and groupId = &#63; and createDate = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the number of matching statistics
	 */
	@Override
	public int countByC_G_D(long companyId, long groupId, Date createDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_D;

		Object[] finderArgs = new Object[] { companyId, groupId, createDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STATISTIC_WHERE);

			query.append(_FINDER_COLUMN_C_G_D_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_D_GROUPID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_G_D_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_G_D_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_C_G_D_COMPANYID_2 = "statistic.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_D_GROUPID_2 = "statistic.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_D_CREATEDATE_1 = "statistic.createDate IS NULL";
	private static final String _FINDER_COLUMN_C_G_D_CREATEDATE_2 = "statistic.createDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			StatisticModelImpl.COMPANYID_COLUMN_BITMASK |
			StatisticModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the statistics where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching statistics
	 */
	@Override
	public List<Statistic> findByC_G(long companyId, long groupId) {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Statistic> findByC_G(long companyId, long groupId, int start,
		int end) {
		return findByC_G(companyId, groupId, start, end, null);
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
	@Override
	public List<Statistic> findByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator<Statistic> orderByComparator) {
		return findByC_G(companyId, groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Statistic> findByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator<Statistic> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Statistic> list = null;

		if (retrieveFromCache) {
			list = (List<Statistic>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Statistic statistic : list) {
					if ((companyId != statistic.getCompanyId()) ||
							(groupId != statistic.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STATISTIC_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatisticModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Statistic>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Statistic>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByC_G_First(long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {
		Statistic statistic = fetchByC_G_First(companyId, groupId,
				orderByComparator);

		if (statistic != null) {
			return statistic;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatisticException(msg.toString());
	}

	/**
	 * Returns the first statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByC_G_First(long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator) {
		List<Statistic> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Statistic findByC_G_Last(long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {
		Statistic statistic = fetchByC_G_Last(companyId, groupId,
				orderByComparator);

		if (statistic != null) {
			return statistic;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatisticException(msg.toString());
	}

	/**
	 * Returns the last statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator) {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Statistic> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Statistic[] findByC_G_PrevAndNext(long statisticId, long companyId,
		long groupId, OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {
		Statistic statistic = findByPrimaryKey(statisticId);

		Session session = null;

		try {
			session = openSession();

			Statistic[] array = new StatisticImpl[3];

			array[0] = getByC_G_PrevAndNext(session, statistic, companyId,
					groupId, orderByComparator, true);

			array[1] = statistic;

			array[2] = getByC_G_PrevAndNext(session, statistic, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Statistic getByC_G_PrevAndNext(Session session,
		Statistic statistic, long companyId, long groupId,
		OrderByComparator<Statistic> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_STATISTIC_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StatisticModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statistic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Statistic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the statistics where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByC_G(long companyId, long groupId) {
		for (Statistic statistic : findByC_G(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statistic);
		}
	}

	/**
	 * Returns the number of statistics where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching statistics
	 */
	@Override
	public int countByC_G(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STATISTIC_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "statistic.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "statistic.groupId = ?";

	public StatisticPersistenceImpl() {
		setModelClass(Statistic.class);
	}

	/**
	 * Caches the statistic in the entity cache if it is enabled.
	 *
	 * @param statistic the statistic
	 */
	@Override
	public void cacheResult(Statistic statistic) {
		entityCache.putResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticImpl.class, statistic.getPrimaryKey(), statistic);

		finderCache.putResult(FINDER_PATH_FETCH_BY_STATISTICID,
			new Object[] { statistic.getStatisticId() }, statistic);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_G_S,
			new Object[] {
				statistic.getCompanyId(), statistic.getGroupId(),
				statistic.getStatisticId()
			}, statistic);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_G_D,
			new Object[] {
				statistic.getCompanyId(), statistic.getGroupId(),
				statistic.getCreateDate()
			}, statistic);

		statistic.resetOriginalValues();
	}

	/**
	 * Caches the statistics in the entity cache if it is enabled.
	 *
	 * @param statistics the statistics
	 */
	@Override
	public void cacheResult(List<Statistic> statistics) {
		for (Statistic statistic : statistics) {
			if (entityCache.getResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
						StatisticImpl.class, statistic.getPrimaryKey()) == null) {
				cacheResult(statistic);
			}
			else {
				statistic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all statistics.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatisticImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the statistic.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Statistic statistic) {
		entityCache.removeResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticImpl.class, statistic.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((StatisticModelImpl)statistic, true);
	}

	@Override
	public void clearCache(List<Statistic> statistics) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Statistic statistic : statistics) {
			entityCache.removeResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
				StatisticImpl.class, statistic.getPrimaryKey());

			clearUniqueFindersCache((StatisticModelImpl)statistic, true);
		}
	}

	protected void cacheUniqueFindersCache(
		StatisticModelImpl statisticModelImpl) {
		Object[] args = new Object[] { statisticModelImpl.getStatisticId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_STATISTICID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_STATISTICID, args,
			statisticModelImpl, false);

		args = new Object[] {
				statisticModelImpl.getCompanyId(),
				statisticModelImpl.getGroupId(),
				statisticModelImpl.getStatisticId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_C_G_S, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_C_G_S, args,
			statisticModelImpl, false);

		args = new Object[] {
				statisticModelImpl.getCompanyId(),
				statisticModelImpl.getGroupId(),
				statisticModelImpl.getCreateDate()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_C_G_D, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_C_G_D, args,
			statisticModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		StatisticModelImpl statisticModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { statisticModelImpl.getStatisticId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATISTICID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_STATISTICID, args);
		}

		if ((statisticModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STATISTICID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					statisticModelImpl.getOriginalStatisticId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATISTICID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_STATISTICID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					statisticModelImpl.getCompanyId(),
					statisticModelImpl.getGroupId(),
					statisticModelImpl.getStatisticId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_G_S, args);
		}

		if ((statisticModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_S.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					statisticModelImpl.getOriginalCompanyId(),
					statisticModelImpl.getOriginalGroupId(),
					statisticModelImpl.getOriginalStatisticId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_G_S, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					statisticModelImpl.getCompanyId(),
					statisticModelImpl.getGroupId(),
					statisticModelImpl.getCreateDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G_D, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_G_D, args);
		}

		if ((statisticModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_D.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					statisticModelImpl.getOriginalCompanyId(),
					statisticModelImpl.getOriginalGroupId(),
					statisticModelImpl.getOriginalCreateDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G_D, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_G_D, args);
		}
	}

	/**
	 * Creates a new statistic with the primary key. Does not add the statistic to the database.
	 *
	 * @param statisticId the primary key for the new statistic
	 * @return the new statistic
	 */
	@Override
	public Statistic create(long statisticId) {
		Statistic statistic = new StatisticImpl();

		statistic.setNew(true);
		statistic.setPrimaryKey(statisticId);

		statistic.setCompanyId(companyProvider.getCompanyId());

		return statistic;
	}

	/**
	 * Removes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic that was removed
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic remove(long statisticId) throws NoSuchStatisticException {
		return remove((Serializable)statisticId);
	}

	/**
	 * Removes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the statistic
	 * @return the statistic that was removed
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic remove(Serializable primaryKey)
		throws NoSuchStatisticException {
		Session session = null;

		try {
			session = openSession();

			Statistic statistic = (Statistic)session.get(StatisticImpl.class,
					primaryKey);

			if (statistic == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatisticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statistic);
		}
		catch (NoSuchStatisticException nsee) {
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
	protected Statistic removeImpl(Statistic statistic) {
		statistic = toUnwrappedModel(statistic);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statistic)) {
				statistic = (Statistic)session.get(StatisticImpl.class,
						statistic.getPrimaryKeyObj());
			}

			if (statistic != null) {
				session.delete(statistic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statistic != null) {
			clearCache(statistic);
		}

		return statistic;
	}

	@Override
	public Statistic updateImpl(Statistic statistic) {
		statistic = toUnwrappedModel(statistic);

		boolean isNew = statistic.isNew();

		StatisticModelImpl statisticModelImpl = (StatisticModelImpl)statistic;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (statistic.getCreateDate() == null)) {
			if (serviceContext == null) {
				statistic.setCreateDate(now);
			}
			else {
				statistic.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!statisticModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				statistic.setModifiedDate(now);
			}
			else {
				statistic.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (statistic.isNew()) {
				session.save(statistic);

				statistic.setNew(false);
			}
			else {
				statistic = (Statistic)session.merge(statistic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!StatisticModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					statisticModelImpl.getCompanyId(),
					statisticModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((statisticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statisticModelImpl.getOriginalCompanyId(),
						statisticModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						statisticModelImpl.getCompanyId(),
						statisticModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}
		}

		entityCache.putResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticImpl.class, statistic.getPrimaryKey(), statistic, false);

		clearUniqueFindersCache(statisticModelImpl, false);
		cacheUniqueFindersCache(statisticModelImpl);

		statistic.resetOriginalValues();

		return statistic;
	}

	protected Statistic toUnwrappedModel(Statistic statistic) {
		if (statistic instanceof StatisticImpl) {
			return statistic;
		}

		StatisticImpl statisticImpl = new StatisticImpl();

		statisticImpl.setNew(statistic.isNew());
		statisticImpl.setPrimaryKey(statistic.getPrimaryKey());

		statisticImpl.setCreateDate(statistic.getCreateDate());
		statisticImpl.setPublicVideos(statistic.getPublicVideos());
		statisticImpl.setPrivateVideos(statistic.getPrivateVideos());
		statisticImpl.setAutofillRow(statistic.getAutofillRow());
		statisticImpl.setStatisticId(statistic.getStatisticId());
		statisticImpl.setGroupId(statistic.getGroupId());
		statisticImpl.setCompanyId(statistic.getCompanyId());
		statisticImpl.setUserId(statistic.getUserId());
		statisticImpl.setUserName(statistic.getUserName());
		statisticImpl.setModifiedDate(statistic.getModifiedDate());

		return statisticImpl;
	}

	/**
	 * Returns the statistic with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the statistic
	 * @return the statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatisticException {
		Statistic statistic = fetchByPrimaryKey(primaryKey);

		if (statistic == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatisticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statistic;
	}

	/**
	 * Returns the statistic with the primary key or throws a {@link NoSuchStatisticException} if it could not be found.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic findByPrimaryKey(long statisticId)
		throws NoSuchStatisticException {
		return findByPrimaryKey((Serializable)statisticId);
	}

	/**
	 * Returns the statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the statistic
	 * @return the statistic, or <code>null</code> if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
				StatisticImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Statistic statistic = (Statistic)serializable;

		if (statistic == null) {
			Session session = null;

			try {
				session = openSession();

				statistic = (Statistic)session.get(StatisticImpl.class,
						primaryKey);

				if (statistic != null) {
					cacheResult(statistic);
				}
				else {
					entityCache.putResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
						StatisticImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
					StatisticImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statistic;
	}

	/**
	 * Returns the statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic, or <code>null</code> if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic fetchByPrimaryKey(long statisticId) {
		return fetchByPrimaryKey((Serializable)statisticId);
	}

	@Override
	public Map<Serializable, Statistic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Statistic> map = new HashMap<Serializable, Statistic>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Statistic statistic = fetchByPrimaryKey(primaryKey);

			if (statistic != null) {
				map.put(primaryKey, statistic);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
					StatisticImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Statistic)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STATISTIC_WHERE_PKS_IN);

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

			for (Statistic statistic : (List<Statistic>)q.list()) {
				map.put(statistic.getPrimaryKeyObj(), statistic);

				cacheResult(statistic);

				uncachedPrimaryKeys.remove(statistic.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StatisticModelImpl.ENTITY_CACHE_ENABLED,
					StatisticImpl.class, primaryKey, nullModel);
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
	 * Returns all the statistics.
	 *
	 * @return the statistics
	 */
	@Override
	public List<Statistic> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Statistic> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Statistic> findAll(int start, int end,
		OrderByComparator<Statistic> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Statistic> findAll(int start, int end,
		OrderByComparator<Statistic> orderByComparator,
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

		List<Statistic> list = null;

		if (retrieveFromCache) {
			list = (List<Statistic>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STATISTIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATISTIC;

				if (pagination) {
					sql = sql.concat(StatisticModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Statistic>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Statistic>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the statistics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Statistic statistic : findAll()) {
			remove(statistic);
		}
	}

	/**
	 * Returns the number of statistics.
	 *
	 * @return the number of statistics
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATISTIC);

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
		return StatisticModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the statistic persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StatisticImpl.class.getName());
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
	private static final String _SQL_SELECT_STATISTIC = "SELECT statistic FROM Statistic statistic";
	private static final String _SQL_SELECT_STATISTIC_WHERE_PKS_IN = "SELECT statistic FROM Statistic statistic WHERE statisticId IN (";
	private static final String _SQL_SELECT_STATISTIC_WHERE = "SELECT statistic FROM Statistic statistic WHERE ";
	private static final String _SQL_COUNT_STATISTIC = "SELECT COUNT(statistic) FROM Statistic statistic";
	private static final String _SQL_COUNT_STATISTIC_WHERE = "SELECT COUNT(statistic) FROM Statistic statistic WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statistic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Statistic exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Statistic exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StatisticPersistenceImpl.class);
}