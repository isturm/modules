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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import aQute.bnd.annotation.ProviderType;
import de.uhh.l2g.plugins.exception.NoSuchCoordinatorException;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.impl.CoordinatorImpl;
import de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl;
import de.uhh.l2g.plugins.service.persistence.CoordinatorPersistence;

/**
 * The persistence implementation for the coordinator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CoordinatorPersistence
 * @see de.uhh.l2g.plugins.service.persistence.CoordinatorUtil
 * @generated
 */
@ProviderType
public class CoordinatorPersistenceImpl extends BasePersistenceImpl<Coordinator>
	implements CoordinatorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CoordinatorUtil} to access the coordinator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CoordinatorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_INSTITUTION = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByInstitution",
			new String[] { Long.class.getName() },
			CoordinatorModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTION = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstitution",
			new String[] { Long.class.getName() });

	/**
	 * Returns the coordinator where institutionId = &#63; or throws a {@link NoSuchCoordinatorException} if it could not be found.
	 *
	 * @param institutionId the institution ID
	 * @return the matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByInstitution(long institutionId)
		throws NoSuchCoordinatorException {
		Coordinator coordinator = fetchByInstitution(institutionId);

		if (coordinator == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("institutionId=");
			msg.append(institutionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCoordinatorException(msg.toString());
		}

		return coordinator;
	}

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByInstitution(long institutionId) {
		return fetchByInstitution(institutionId, true);
	}

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByInstitution(long institutionId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { institutionId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_INSTITUTION,
					finderArgs, this);
		}

		if (result instanceof Coordinator) {
			Coordinator coordinator = (Coordinator)result;

			if ((institutionId != coordinator.getInstitutionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				List<Coordinator> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"CoordinatorPersistenceImpl.fetchByInstitution(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Coordinator coordinator = list.get(0);

					result = coordinator;

					cacheResult(coordinator);

					if ((coordinator.getInstitutionId() != institutionId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
							finderArgs, coordinator);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_INSTITUTION,
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
			return (Coordinator)result;
		}
	}

	/**
	 * Removes the coordinator where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @return the coordinator that was removed
	 */
	@Override
	public Coordinator removeByInstitution(long institutionId)
		throws NoSuchCoordinatorException {
		Coordinator coordinator = findByInstitution(institutionId);

		return remove(coordinator);
	}

	/**
	 * Returns the number of coordinators where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching coordinators
	 */
	@Override
	public int countByInstitution(long institutionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTION;

		Object[] finderArgs = new Object[] { institutionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

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

	private static final String _FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2 = "coordinator.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OFFICE = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOffice",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE =
		new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOffice",
			new String[] { Long.class.getName() },
			CoordinatorModelImpl.OFFICEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OFFICE = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOffice",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the matching coordinators
	 */
	@Override
	public List<Coordinator> findByOffice(long officeId) {
		return findByOffice(officeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByOffice(long officeId, int start, int end) {
		return findByOffice(officeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByOffice(long officeId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {
		return findByOffice(officeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByOffice(long officeId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE;
			finderArgs = new Object[] { officeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OFFICE;
			finderArgs = new Object[] { officeId, start, end, orderByComparator };
		}

		List<Coordinator> list = null;

		if (retrieveFromCache) {
			list = (List<Coordinator>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Coordinator coordinator : list) {
					if ((officeId != coordinator.getOfficeId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_OFFICE_OFFICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeId);

				if (!pagination) {
					list = (List<Coordinator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Coordinator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByOffice_First(long officeId,
		OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {
		Coordinator coordinator = fetchByOffice_First(officeId,
				orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeId=");
		msg.append(officeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByOffice_First(long officeId,
		OrderByComparator<Coordinator> orderByComparator) {
		List<Coordinator> list = findByOffice(officeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByOffice_Last(long officeId,
		OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {
		Coordinator coordinator = fetchByOffice_Last(officeId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeId=");
		msg.append(officeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByOffice_Last(long officeId,
		OrderByComparator<Coordinator> orderByComparator) {
		int count = countByOffice(officeId);

		if (count == 0) {
			return null;
		}

		List<Coordinator> list = findByOffice(officeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator[] findByOffice_PrevAndNext(long coordinatorId,
		long officeId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {
		Coordinator coordinator = findByPrimaryKey(coordinatorId);

		Session session = null;

		try {
			session = openSession();

			Coordinator[] array = new CoordinatorImpl[3];

			array[0] = getByOffice_PrevAndNext(session, coordinator, officeId,
					orderByComparator, true);

			array[1] = coordinator;

			array[2] = getByOffice_PrevAndNext(session, coordinator, officeId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Coordinator getByOffice_PrevAndNext(Session session,
		Coordinator coordinator, long officeId,
		OrderByComparator<Coordinator> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COORDINATOR_WHERE);

		query.append(_FINDER_COLUMN_OFFICE_OFFICEID_2);

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
			query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(officeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coordinator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Coordinator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the coordinators where officeId = &#63; from the database.
	 *
	 * @param officeId the office ID
	 */
	@Override
	public void removeByOffice(long officeId) {
		for (Coordinator coordinator : findByOffice(officeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(coordinator);
		}
	}

	/**
	 * Returns the number of coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the number of matching coordinators
	 */
	@Override
	public int countByOffice(long officeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OFFICE;

		Object[] finderArgs = new Object[] { officeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_OFFICE_OFFICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeId);

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

	private static final String _FINDER_COLUMN_OFFICE_OFFICEID_2 = "coordinator.officeId = ?";

	public CoordinatorPersistenceImpl() {
		setModelClass(Coordinator.class);
	}

	/**
	 * Caches the coordinator in the entity cache if it is enabled.
	 *
	 * @param coordinator the coordinator
	 */
	@Override
	public void cacheResult(Coordinator coordinator) {
		entityCache.putResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorImpl.class, coordinator.getPrimaryKey(), coordinator);

		finderCache.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
			new Object[] { coordinator.getInstitutionId() }, coordinator);

		coordinator.resetOriginalValues();
	}

	/**
	 * Caches the coordinators in the entity cache if it is enabled.
	 *
	 * @param coordinators the coordinators
	 */
	@Override
	public void cacheResult(List<Coordinator> coordinators) {
		for (Coordinator coordinator : coordinators) {
			if (entityCache.getResult(
						CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
						CoordinatorImpl.class, coordinator.getPrimaryKey()) == null) {
				cacheResult(coordinator);
			}
			else {
				coordinator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all coordinators.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CoordinatorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the coordinator.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Coordinator coordinator) {
		entityCache.removeResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorImpl.class, coordinator.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CoordinatorModelImpl)coordinator, true);
	}

	@Override
	public void clearCache(List<Coordinator> coordinators) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Coordinator coordinator : coordinators) {
			entityCache.removeResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
				CoordinatorImpl.class, coordinator.getPrimaryKey());

			clearUniqueFindersCache((CoordinatorModelImpl)coordinator, true);
		}
	}

	protected void cacheUniqueFindersCache(
		CoordinatorModelImpl coordinatorModelImpl) {
		Object[] args = new Object[] { coordinatorModelImpl.getInstitutionId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_INSTITUTION, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_INSTITUTION, args,
			coordinatorModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CoordinatorModelImpl coordinatorModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { coordinatorModelImpl.getInstitutionId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_INSTITUTION, args);
		}

		if ((coordinatorModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_INSTITUTION.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					coordinatorModelImpl.getOriginalInstitutionId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_INSTITUTION, args);
		}
	}

	/**
	 * Creates a new coordinator with the primary key. Does not add the coordinator to the database.
	 *
	 * @param coordinatorId the primary key for the new coordinator
	 * @return the new coordinator
	 */
	@Override
	public Coordinator create(long coordinatorId) {
		Coordinator coordinator = new CoordinatorImpl();

		coordinator.setNew(true);
		coordinator.setPrimaryKey(coordinatorId);

		return coordinator;
	}

	/**
	 * Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator remove(long coordinatorId)
		throws NoSuchCoordinatorException {
		return remove((Serializable)coordinatorId);
	}

	/**
	 * Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator remove(Serializable primaryKey)
		throws NoSuchCoordinatorException {
		Session session = null;

		try {
			session = openSession();

			Coordinator coordinator = (Coordinator)session.get(CoordinatorImpl.class,
					primaryKey);

			if (coordinator == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoordinatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coordinator);
		}
		catch (NoSuchCoordinatorException nsee) {
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
	protected Coordinator removeImpl(Coordinator coordinator) {
		coordinator = toUnwrappedModel(coordinator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coordinator)) {
				coordinator = (Coordinator)session.get(CoordinatorImpl.class,
						coordinator.getPrimaryKeyObj());
			}

			if (coordinator != null) {
				session.delete(coordinator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (coordinator != null) {
			clearCache(coordinator);
		}

		return coordinator;
	}

	@Override
	public Coordinator updateImpl(Coordinator coordinator) {
		coordinator = toUnwrappedModel(coordinator);

		boolean isNew = coordinator.isNew();

		CoordinatorModelImpl coordinatorModelImpl = (CoordinatorModelImpl)coordinator;

		Session session = null;

		try {
			session = openSession();

			if (coordinator.isNew()) {
				session.save(coordinator);

				coordinator.setNew(false);
			}
			else {
				coordinator = (Coordinator)session.merge(coordinator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CoordinatorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { coordinatorModelImpl.getOfficeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_OFFICE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((coordinatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coordinatorModelImpl.getOriginalOfficeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OFFICE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE,
					args);

				args = new Object[] { coordinatorModelImpl.getOfficeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OFFICE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE,
					args);
			}
		}

		entityCache.putResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorImpl.class, coordinator.getPrimaryKey(), coordinator,
			false);

		clearUniqueFindersCache(coordinatorModelImpl, false);
		cacheUniqueFindersCache(coordinatorModelImpl);

		coordinator.resetOriginalValues();

		return coordinator;
	}

	protected Coordinator toUnwrappedModel(Coordinator coordinator) {
		if (coordinator instanceof CoordinatorImpl) {
			return coordinator;
		}

		CoordinatorImpl coordinatorImpl = new CoordinatorImpl();

		coordinatorImpl.setNew(coordinator.isNew());
		coordinatorImpl.setPrimaryKey(coordinator.getPrimaryKey());

		coordinatorImpl.setCoordinatorId(coordinator.getCoordinatorId());
		coordinatorImpl.setInstitutionId(coordinator.getInstitutionId());
		coordinatorImpl.setOfficeId(coordinator.getOfficeId());

		return coordinatorImpl;
	}

	/**
	 * Returns the coordinator with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the coordinator
	 * @return the coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCoordinatorException {
		Coordinator coordinator = fetchByPrimaryKey(primaryKey);

		if (coordinator == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCoordinatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return coordinator;
	}

	/**
	 * Returns the coordinator with the primary key or throws a {@link NoSuchCoordinatorException} if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator findByPrimaryKey(long coordinatorId)
		throws NoSuchCoordinatorException {
		return findByPrimaryKey((Serializable)coordinatorId);
	}

	/**
	 * Returns the coordinator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the coordinator
	 * @return the coordinator, or <code>null</code> if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
				CoordinatorImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Coordinator coordinator = (Coordinator)serializable;

		if (coordinator == null) {
			Session session = null;

			try {
				session = openSession();

				coordinator = (Coordinator)session.get(CoordinatorImpl.class,
						primaryKey);

				if (coordinator != null) {
					cacheResult(coordinator);
				}
				else {
					entityCache.putResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
						CoordinatorImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
					CoordinatorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return coordinator;
	}

	/**
	 * Returns the coordinator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator, or <code>null</code> if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator fetchByPrimaryKey(long coordinatorId) {
		return fetchByPrimaryKey((Serializable)coordinatorId);
	}

	@Override
	public Map<Serializable, Coordinator> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Coordinator> map = new HashMap<Serializable, Coordinator>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Coordinator coordinator = fetchByPrimaryKey(primaryKey);

			if (coordinator != null) {
				map.put(primaryKey, coordinator);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
					CoordinatorImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Coordinator)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COORDINATOR_WHERE_PKS_IN);

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

			for (Coordinator coordinator : (List<Coordinator>)q.list()) {
				map.put(coordinator.getPrimaryKeyObj(), coordinator);

				cacheResult(coordinator);

				uncachedPrimaryKeys.remove(coordinator.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
					CoordinatorImpl.class, primaryKey, nullModel);
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
	 * Returns all the coordinators.
	 *
	 * @return the coordinators
	 */
	@Override
	public List<Coordinator> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of coordinators
	 */
	@Override
	public List<Coordinator> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coordinators
	 */
	@Override
	public List<Coordinator> findAll(int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of coordinators
	 */
	@Override
	public List<Coordinator> findAll(int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
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

		List<Coordinator> list = null;

		if (retrieveFromCache) {
			list = (List<Coordinator>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COORDINATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COORDINATOR;

				if (pagination) {
					sql = sql.concat(CoordinatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Coordinator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Coordinator>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the coordinators from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Coordinator coordinator : findAll()) {
			remove(coordinator);
		}
	}

	/**
	 * Returns the number of coordinators.
	 *
	 * @return the number of coordinators
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COORDINATOR);

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
		return CoordinatorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the coordinator persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CoordinatorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_COORDINATOR = "SELECT coordinator FROM Coordinator coordinator";
	private static final String _SQL_SELECT_COORDINATOR_WHERE_PKS_IN = "SELECT coordinator FROM Coordinator coordinator WHERE coordinatorId IN (";
	private static final String _SQL_SELECT_COORDINATOR_WHERE = "SELECT coordinator FROM Coordinator coordinator WHERE ";
	private static final String _SQL_COUNT_COORDINATOR = "SELECT COUNT(coordinator) FROM Coordinator coordinator";
	private static final String _SQL_COUNT_COORDINATOR_WHERE = "SELECT COUNT(coordinator) FROM Coordinator coordinator WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coordinator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Coordinator exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Coordinator exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CoordinatorPersistenceImpl.class);
}