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
import java.lang.reflect.Field;
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
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import aQute.bnd.annotation.ProviderType;
import de.uhh.l2g.plugins.exception.NoSuchLectureseriesException;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl;
import de.uhh.l2g.plugins.service.persistence.LectureseriesPersistence;

/**
 * The persistence implementation for the lectureseries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LectureseriesPersistence
 * @see de.uhh.l2g.plugins.service.persistence.LectureseriesUtil
 * @generated
 */
@ProviderType
public class LectureseriesPersistenceImpl extends BasePersistenceImpl<Lectureseries>
	implements LectureseriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LectureseriesUtil} to access the lectureseries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LectureseriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TERM = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTerm",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTerm", new String[] { Long.class.getName() },
			LectureseriesModelImpl.TERMID_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TERM = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTerm",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureserieses where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByTerm(long termId) {
		return findByTerm(termId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureserieses where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByTerm(long termId, int start, int end) {
		return findByTerm(termId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByTerm(long termId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findByTerm(termId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByTerm(long termId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM;
			finderArgs = new Object[] { termId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TERM;
			finderArgs = new Object[] { termId, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if ((termId != lectureseries.getTermId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_TERM_TERMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(termId);

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByTerm_First(long termId,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByTerm_First(termId,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("termId=");
		msg.append(termId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByTerm_First(long termId,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByTerm(termId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByTerm_Last(long termId,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByTerm_Last(termId, orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("termId=");
		msg.append(termId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByTerm_Last(long termId,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByTerm(termId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByTerm(termId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByTerm_PrevAndNext(long lectureseriesId,
		long termId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByTerm_PrevAndNext(session, lectureseries, termId,
					orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByTerm_PrevAndNext(session, lectureseries, termId,
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

	protected Lectureseries getByTerm_PrevAndNext(Session session,
		Lectureseries lectureseries, long termId,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_TERM_TERMID_2);

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(termId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where termId = &#63; from the database.
	 *
	 * @param termId the term ID
	 */
	@Override
	public void removeByTerm(long termId) {
		for (Lectureseries lectureseries : findByTerm(termId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByTerm(long termId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TERM;

		Object[] finderArgs = new Object[] { termId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_TERM_TERMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(termId);

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

	private static final String _FINDER_COLUMN_TERM_TERMID_2 = "lectureseries.termId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGE = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLanguage",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLanguage", new String[] { String.class.getName() },
			LectureseriesModelImpl.LANGUAGE_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGE = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLanguage",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lectureserieses where language = &#63;.
	 *
	 * @param language the language
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLanguage(String language) {
		return findByLanguage(language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lectureserieses where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param language the language
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLanguage(String language, int start,
		int end) {
		return findByLanguage(language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param language the language
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLanguage(String language, int start,
		int end, OrderByComparator<Lectureseries> orderByComparator) {
		return findByLanguage(language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param language the language
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLanguage(String language, int start,
		int end, OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE;
			finderArgs = new Object[] { language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGE;
			finderArgs = new Object[] { language, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if (!Objects.equals(language, lectureseries.getLanguage())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			boolean bindLanguage = false;

			if (language == null) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_1);
			}
			else if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLanguage) {
					qPos.add(language);
				}

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByLanguage_First(String language,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByLanguage_First(language,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("language=");
		msg.append(language);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByLanguage_First(String language,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByLanguage(language, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByLanguage_Last(String language,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByLanguage_Last(language,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("language=");
		msg.append(language);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByLanguage_Last(String language,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByLanguage(language);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByLanguage(language, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where language = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByLanguage_PrevAndNext(long lectureseriesId,
		String language, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByLanguage_PrevAndNext(session, lectureseries,
					language, orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByLanguage_PrevAndNext(session, lectureseries,
					language, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries getByLanguage_PrevAndNext(Session session,
		Lectureseries lectureseries, String language,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		boolean bindLanguage = false;

		if (language == null) {
			query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_1);
		}
		else if (language.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_2);
		}

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where language = &#63; from the database.
	 *
	 * @param language the language
	 */
	@Override
	public void removeByLanguage(String language) {
		for (Lectureseries lectureseries : findByLanguage(language,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where language = &#63;.
	 *
	 * @param language the language
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByLanguage(String language) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LANGUAGE;

		Object[] finderArgs = new Object[] { language };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			boolean bindLanguage = false;

			if (language == null) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_1);
			}
			else if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLanguage) {
					qPos.add(language);
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

	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_1 = "lectureseries.language IS NULL";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_2 = "lectureseries.language = ?";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_3 = "(lectureseries.language IS NULL OR lectureseries.language = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMBER = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNumber",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNumber", new String[] { String.class.getName() },
			LectureseriesModelImpl.NUMBER_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMBER = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumber",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lectureserieses where number = &#63;.
	 *
	 * @param number the number
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByNumber(String number) {
		return findByNumber(number, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureserieses where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByNumber(String number, int start, int end) {
		return findByNumber(number, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByNumber(String number, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findByNumber(number, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByNumber(String number, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER;
			finderArgs = new Object[] { number };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMBER;
			finderArgs = new Object[] { number, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if (!Objects.equals(number, lectureseries.getNumber())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			boolean bindNumber = false;

			if (number == null) {
				query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
			}
			else if (number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(number);
				}

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByNumber_First(String number,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByNumber_First(number,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("number=");
		msg.append(number);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByNumber_First(String number,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByNumber(number, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByNumber_Last(String number,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByNumber_Last(number,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("number=");
		msg.append(number);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByNumber_Last(String number,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByNumber(number);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByNumber(number, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where number = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByNumber_PrevAndNext(long lectureseriesId,
		String number, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByNumber_PrevAndNext(session, lectureseries, number,
					orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByNumber_PrevAndNext(session, lectureseries, number,
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

	protected Lectureseries getByNumber_PrevAndNext(Session session,
		Lectureseries lectureseries, String number,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		boolean bindNumber = false;

		if (number == null) {
			query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
		}
		else if (number.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
		}
		else {
			bindNumber = true;

			query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
		}

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNumber) {
			qPos.add(number);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where number = &#63; from the database.
	 *
	 * @param number the number
	 */
	@Override
	public void removeByNumber(String number) {
		for (Lectureseries lectureseries : findByNumber(number,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where number = &#63;.
	 *
	 * @param number the number
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByNumber(String number) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NUMBER;

		Object[] finderArgs = new Object[] { number };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			boolean bindNumber = false;

			if (number == null) {
				query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
			}
			else if (number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(number);
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

	private static final String _FINDER_COLUMN_NUMBER_NUMBER_1 = "lectureseries.number IS NULL";
	private static final String _FINDER_COLUMN_NUMBER_NUMBER_2 = "lectureseries.number = ?";
	private static final String _FINDER_COLUMN_NUMBER_NUMBER_3 = "(lectureseries.number IS NULL OR lectureseries.number = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByType", new String[] { String.class.getName() },
			LectureseriesModelImpl.EVENTTYPE_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lectureserieses where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByType(String eventType) {
		return findByType(eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureserieses where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByType(String eventType, int start, int end) {
		return findByType(eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByType(String eventType, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findByType(eventType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByType(String eventType, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { eventType, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if (!Objects.equals(eventType, lectureseries.getEventType())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_TYPE_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_TYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(StringUtil.toLowerCase(eventType));
				}

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByType_First(String eventType,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByType_First(eventType,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByType_First(String eventType,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByType(eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByType_Last(String eventType,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByType_Last(eventType,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByType_Last(String eventType,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByType(eventType);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByType(eventType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByType_PrevAndNext(long lectureseriesId,
		String eventType, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByType_PrevAndNext(session, lectureseries, eventType,
					orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByType_PrevAndNext(session, lectureseries, eventType,
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

	protected Lectureseries getByType_PrevAndNext(Session session,
		Lectureseries lectureseries, String eventType,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_TYPE_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_TYPE_EVENTTYPE_2);
		}

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEventType) {
			qPos.add(StringUtil.toLowerCase(eventType));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	@Override
	public void removeByType(String eventType) {
		for (Lectureseries lectureseries : findByType(eventType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByType(String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { eventType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_TYPE_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_TYPE_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(StringUtil.toLowerCase(eventType));
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

	private static final String _FINDER_COLUMN_TYPE_EVENTTYPE_1 = "lectureseries.eventType IS NULL";
	private static final String _FINDER_COLUMN_TYPE_EVENTTYPE_2 = "lower(lectureseries.eventType) = ?";
	private static final String _FINDER_COLUMN_TYPE_EVENTTYPE_3 = "(lectureseries.eventType IS NULL OR lectureseries.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategory", new String[] { Long.class.getName() },
			LectureseriesModelImpl.CATEGORYID_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureserieses where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByCategory(long categoryId) {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lectureserieses where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByCategory(long categoryId, int start,
		int end) {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByCategory(long categoryId, int start,
		int end, OrderByComparator<Lectureseries> orderByComparator) {
		return findByCategory(categoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByCategory(long categoryId, int start,
		int end, OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if ((categoryId != lectureseries.getCategoryId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByCategory_First(long categoryId,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByCategory_First(categoryId,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByCategory_First(long categoryId,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByCategory_Last(long categoryId,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByCategory_Last(long categoryId,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByCategory(categoryId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByCategory(categoryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByCategory_PrevAndNext(long lectureseriesId,
		long categoryId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByCategory_PrevAndNext(session, lectureseries,
					categoryId, orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByCategory_PrevAndNext(session, lectureseries,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries getByCategory_PrevAndNext(Session session,
		Lectureseries lectureseries, long categoryId,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByCategory(long categoryId) {
		for (Lectureseries lectureseries : findByCategory(categoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByCategory(long categoryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "lectureseries.categoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByName", new String[] { String.class.getName() },
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lectureserieses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureserieses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByName(String name, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByName(String name, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if (!Objects.equals(name, lectureseries.getName())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByName_First(String name,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByName_First(name, orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByName_First(String name,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByName_Last(String name,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByName_Last(name, orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByName_Last(String name,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where name = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByName_PrevAndNext(long lectureseriesId,
		String name, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByName_PrevAndNext(session, lectureseries, name,
					orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByName_PrevAndNext(session, lectureseries, name,
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

	protected Lectureseries getByName_PrevAndNext(Session session,
		Lectureseries lectureseries, String name,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (Lectureseries lectureseries : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByName(String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "lectureseries.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "lectureseries.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(lectureseries.name IS NULL OR lectureseries.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FACULTY = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFaculty",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTY =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFaculty", new String[] { String.class.getName() },
			LectureseriesModelImpl.FACULTYNAME_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACULTY = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFaculty",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lectureserieses where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByFaculty(String facultyName) {
		return findByFaculty(facultyName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lectureserieses where facultyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facultyName the faculty name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByFaculty(String facultyName, int start,
		int end) {
		return findByFaculty(facultyName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where facultyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facultyName the faculty name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByFaculty(String facultyName, int start,
		int end, OrderByComparator<Lectureseries> orderByComparator) {
		return findByFaculty(facultyName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where facultyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facultyName the faculty name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByFaculty(String facultyName, int start,
		int end, OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTY;
			finderArgs = new Object[] { facultyName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FACULTY;
			finderArgs = new Object[] { facultyName, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if (!Objects.equals(facultyName,
								lectureseries.getFacultyName())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			boolean bindFacultyName = false;

			if (facultyName == null) {
				query.append(_FINDER_COLUMN_FACULTY_FACULTYNAME_1);
			}
			else if (facultyName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FACULTY_FACULTYNAME_3);
			}
			else {
				bindFacultyName = true;

				query.append(_FINDER_COLUMN_FACULTY_FACULTYNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFacultyName) {
					qPos.add(facultyName);
				}

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByFaculty_First(String facultyName,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByFaculty_First(facultyName,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facultyName=");
		msg.append(facultyName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByFaculty_First(String facultyName,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByFaculty(facultyName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByFaculty_Last(String facultyName,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByFaculty_Last(facultyName,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facultyName=");
		msg.append(facultyName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByFaculty_Last(String facultyName,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByFaculty(facultyName);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByFaculty(facultyName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByFaculty_PrevAndNext(long lectureseriesId,
		String facultyName, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByFaculty_PrevAndNext(session, lectureseries,
					facultyName, orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByFaculty_PrevAndNext(session, lectureseries,
					facultyName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries getByFaculty_PrevAndNext(Session session,
		Lectureseries lectureseries, String facultyName,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		boolean bindFacultyName = false;

		if (facultyName == null) {
			query.append(_FINDER_COLUMN_FACULTY_FACULTYNAME_1);
		}
		else if (facultyName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FACULTY_FACULTYNAME_3);
		}
		else {
			bindFacultyName = true;

			query.append(_FINDER_COLUMN_FACULTY_FACULTYNAME_2);
		}

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFacultyName) {
			qPos.add(facultyName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where facultyName = &#63; from the database.
	 *
	 * @param facultyName the faculty name
	 */
	@Override
	public void removeByFaculty(String facultyName) {
		for (Lectureseries lectureseries : findByFaculty(facultyName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByFaculty(String facultyName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FACULTY;

		Object[] finderArgs = new Object[] { facultyName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			boolean bindFacultyName = false;

			if (facultyName == null) {
				query.append(_FINDER_COLUMN_FACULTY_FACULTYNAME_1);
			}
			else if (facultyName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FACULTY_FACULTYNAME_3);
			}
			else {
				bindFacultyName = true;

				query.append(_FINDER_COLUMN_FACULTY_FACULTYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFacultyName) {
					qPos.add(facultyName);
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

	private static final String _FINDER_COLUMN_FACULTY_FACULTYNAME_1 = "lectureseries.facultyName IS NULL";
	private static final String _FINDER_COLUMN_FACULTY_FACULTYNAME_2 = "lectureseries.facultyName = ?";
	private static final String _FINDER_COLUMN_FACULTY_FACULTYNAME_3 = "(lectureseries.facultyName IS NULL OR lectureseries.facultyName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVED = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByApproved",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApproved", new String[] { Integer.class.getName() },
			LectureseriesModelImpl.APPROVED_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVED = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApproved",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the lectureserieses where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByApproved(int approved) {
		return findByApproved(approved, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lectureserieses where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByApproved(int approved, int start, int end) {
		return findByApproved(approved, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByApproved(int approved, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findByApproved(approved, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByApproved(int approved, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED;
			finderArgs = new Object[] { approved };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVED;
			finderArgs = new Object[] { approved, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if ((approved != lectureseries.getApproved())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_APPROVED_APPROVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved);

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByApproved_First(int approved,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByApproved_First(approved,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approved=");
		msg.append(approved);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByApproved_First(int approved,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByApproved(approved, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByApproved_Last(int approved,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByApproved_Last(approved,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approved=");
		msg.append(approved);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByApproved_Last(int approved,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByApproved(approved);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByApproved(approved, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByApproved_PrevAndNext(long lectureseriesId,
		int approved, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByApproved_PrevAndNext(session, lectureseries,
					approved, orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByApproved_PrevAndNext(session, lectureseries,
					approved, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries getByApproved_PrevAndNext(Session session,
		Lectureseries lectureseries, int approved,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_APPROVED_APPROVED_2);

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(approved);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where approved = &#63; from the database.
	 *
	 * @param approved the approved
	 */
	@Override
	public void removeByApproved(int approved) {
		for (Lectureseries lectureseries : findByApproved(approved,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByApproved(int approved) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPROVED;

		Object[] finderArgs = new Object[] { approved };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_APPROVED_APPROVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved);

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

	private static final String _FINDER_COLUMN_APPROVED_APPROVED_2 = "lectureseries.approved = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PASSWORD = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPassword",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPassword", new String[] { String.class.getName() },
			LectureseriesModelImpl.PASSWORD_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PASSWORD = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPassword",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lectureserieses where password = &#63;.
	 *
	 * @param password the password
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByPassword(String password) {
		return findByPassword(password, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lectureserieses where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByPassword(String password, int start,
		int end) {
		return findByPassword(password, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByPassword(String password, int start,
		int end, OrderByComparator<Lectureseries> orderByComparator) {
		return findByPassword(password, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByPassword(String password, int start,
		int end, OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD;
			finderArgs = new Object[] { password };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PASSWORD;
			finderArgs = new Object[] { password, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if (!Objects.equals(password, lectureseries.getPassword())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			boolean bindPassword = false;

			if (password == null) {
				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_1);
			}
			else if (password.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPassword) {
					qPos.add(password);
				}

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByPassword_First(String password,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByPassword_First(password,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("password=");
		msg.append(password);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByPassword_First(String password,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByPassword(password, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByPassword_Last(String password,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByPassword_Last(password,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("password=");
		msg.append(password);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByPassword_Last(String password,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByPassword(password);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByPassword(password, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where password = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByPassword_PrevAndNext(long lectureseriesId,
		String password, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByPassword_PrevAndNext(session, lectureseries,
					password, orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByPassword_PrevAndNext(session, lectureseries,
					password, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries getByPassword_PrevAndNext(Session session,
		Lectureseries lectureseries, String password,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		boolean bindPassword = false;

		if (password == null) {
			query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_1);
		}
		else if (password.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_3);
		}
		else {
			bindPassword = true;

			query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_2);
		}

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPassword) {
			qPos.add(password);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where password = &#63; from the database.
	 *
	 * @param password the password
	 */
	@Override
	public void removeByPassword(String password) {
		for (Lectureseries lectureseries : findByPassword(password,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where password = &#63;.
	 *
	 * @param password the password
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByPassword(String password) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PASSWORD;

		Object[] finderArgs = new Object[] { password };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			boolean bindPassword = false;

			if (password == null) {
				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_1);
			}
			else if (password.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPassword) {
					qPos.add(password);
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

	private static final String _FINDER_COLUMN_PASSWORD_PASSWORD_1 = "lectureseries.password IS NULL";
	private static final String _FINDER_COLUMN_PASSWORD_PASSWORD_2 = "lectureseries.password = ?";
	private static final String _FINDER_COLUMN_PASSWORD_PASSWORD_3 = "(lectureseries.password IS NULL OR lectureseries.password = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LATESTOPENACCESSVIDEO =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLatestOpenAccessVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTOPENACCESSVIDEO =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLatestOpenAccessVideo",
			new String[] { Long.class.getName() },
			LectureseriesModelImpl.LATESTOPENACCESSVIDEOID_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LATESTOPENACCESSVIDEO = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLatestOpenAccessVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId) {
		return findByLatestOpenAccessVideo(latestOpenAccessVideoId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end) {
		return findByLatestOpenAccessVideo(latestOpenAccessVideoId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findByLatestOpenAccessVideo(latestOpenAccessVideoId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTOPENACCESSVIDEO;
			finderArgs = new Object[] { latestOpenAccessVideoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LATESTOPENACCESSVIDEO;
			finderArgs = new Object[] {
					latestOpenAccessVideoId,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if ((latestOpenAccessVideoId != lectureseries.getLatestOpenAccessVideoId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LATESTOPENACCESSVIDEO_LATESTOPENACCESSVIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(latestOpenAccessVideoId);

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByLatestOpenAccessVideo_First(
		long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByLatestOpenAccessVideo_First(latestOpenAccessVideoId,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("latestOpenAccessVideoId=");
		msg.append(latestOpenAccessVideoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByLatestOpenAccessVideo_First(
		long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByLatestOpenAccessVideo(latestOpenAccessVideoId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByLatestOpenAccessVideo_Last(
		long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByLatestOpenAccessVideo_Last(latestOpenAccessVideoId,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("latestOpenAccessVideoId=");
		msg.append(latestOpenAccessVideoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByLatestOpenAccessVideo_Last(
		long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByLatestOpenAccessVideo(latestOpenAccessVideoId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByLatestOpenAccessVideo(latestOpenAccessVideoId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByLatestOpenAccessVideo_PrevAndNext(
		long lectureseriesId, long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByLatestOpenAccessVideo_PrevAndNext(session,
					lectureseries, latestOpenAccessVideoId, orderByComparator,
					true);

			array[1] = lectureseries;

			array[2] = getByLatestOpenAccessVideo_PrevAndNext(session,
					lectureseries, latestOpenAccessVideoId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries getByLatestOpenAccessVideo_PrevAndNext(
		Session session, Lectureseries lectureseries,
		long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_LATESTOPENACCESSVIDEO_LATESTOPENACCESSVIDEOID_2);

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(latestOpenAccessVideoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where latestOpenAccessVideoId = &#63; from the database.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 */
	@Override
	public void removeByLatestOpenAccessVideo(long latestOpenAccessVideoId) {
		for (Lectureseries lectureseries : findByLatestOpenAccessVideo(
				latestOpenAccessVideoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByLatestOpenAccessVideo(long latestOpenAccessVideoId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LATESTOPENACCESSVIDEO;

		Object[] finderArgs = new Object[] { latestOpenAccessVideoId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LATESTOPENACCESSVIDEO_LATESTOPENACCESSVIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(latestOpenAccessVideoId);

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

	private static final String _FINDER_COLUMN_LATESTOPENACCESSVIDEO_LATESTOPENACCESSVIDEOID_2 =
		"lectureseries.latestOpenAccessVideoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LATESTVIDEOUPLOADDATE =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLatestVideoUploadDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOUPLOADDATE =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLatestVideoUploadDate",
			new String[] { Date.class.getName() },
			LectureseriesModelImpl.LATESTVIDEOUPLOADDATE_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LATESTVIDEOUPLOADDATE = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLatestVideoUploadDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate) {
		return findByLatestVideoUploadDate(latestVideoUploadDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate, int start, int end) {
		return findByLatestVideoUploadDate(latestVideoUploadDate, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findByLatestVideoUploadDate(latestVideoUploadDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOUPLOADDATE;
			finderArgs = new Object[] { latestVideoUploadDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LATESTVIDEOUPLOADDATE;
			finderArgs = new Object[] {
					latestVideoUploadDate,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if (!Objects.equals(latestVideoUploadDate,
								lectureseries.getLatestVideoUploadDate())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			boolean bindLatestVideoUploadDate = false;

			if (latestVideoUploadDate == null) {
				query.append(_FINDER_COLUMN_LATESTVIDEOUPLOADDATE_LATESTVIDEOUPLOADDATE_1);
			}
			else {
				bindLatestVideoUploadDate = true;

				query.append(_FINDER_COLUMN_LATESTVIDEOUPLOADDATE_LATESTVIDEOUPLOADDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLatestVideoUploadDate) {
					qPos.add(new Timestamp(latestVideoUploadDate.getTime()));
				}

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByLatestVideoUploadDate_First(
		Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByLatestVideoUploadDate_First(latestVideoUploadDate,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("latestVideoUploadDate=");
		msg.append(latestVideoUploadDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByLatestVideoUploadDate_First(
		Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByLatestVideoUploadDate(latestVideoUploadDate,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByLatestVideoUploadDate_Last(
		Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByLatestVideoUploadDate_Last(latestVideoUploadDate,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("latestVideoUploadDate=");
		msg.append(latestVideoUploadDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByLatestVideoUploadDate_Last(
		Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByLatestVideoUploadDate(latestVideoUploadDate);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByLatestVideoUploadDate(latestVideoUploadDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByLatestVideoUploadDate_PrevAndNext(
		long lectureseriesId, Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByLatestVideoUploadDate_PrevAndNext(session,
					lectureseries, latestVideoUploadDate, orderByComparator,
					true);

			array[1] = lectureseries;

			array[2] = getByLatestVideoUploadDate_PrevAndNext(session,
					lectureseries, latestVideoUploadDate, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries getByLatestVideoUploadDate_PrevAndNext(
		Session session, Lectureseries lectureseries,
		Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		boolean bindLatestVideoUploadDate = false;

		if (latestVideoUploadDate == null) {
			query.append(_FINDER_COLUMN_LATESTVIDEOUPLOADDATE_LATESTVIDEOUPLOADDATE_1);
		}
		else {
			bindLatestVideoUploadDate = true;

			query.append(_FINDER_COLUMN_LATESTVIDEOUPLOADDATE_LATESTVIDEOUPLOADDATE_2);
		}

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLatestVideoUploadDate) {
			qPos.add(new Timestamp(latestVideoUploadDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where latestVideoUploadDate = &#63; from the database.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 */
	@Override
	public void removeByLatestVideoUploadDate(Date latestVideoUploadDate) {
		for (Lectureseries lectureseries : findByLatestVideoUploadDate(
				latestVideoUploadDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByLatestVideoUploadDate(Date latestVideoUploadDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LATESTVIDEOUPLOADDATE;

		Object[] finderArgs = new Object[] { latestVideoUploadDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			boolean bindLatestVideoUploadDate = false;

			if (latestVideoUploadDate == null) {
				query.append(_FINDER_COLUMN_LATESTVIDEOUPLOADDATE_LATESTVIDEOUPLOADDATE_1);
			}
			else {
				bindLatestVideoUploadDate = true;

				query.append(_FINDER_COLUMN_LATESTVIDEOUPLOADDATE_LATESTVIDEOUPLOADDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLatestVideoUploadDate) {
					qPos.add(new Timestamp(latestVideoUploadDate.getTime()));
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

	private static final String _FINDER_COLUMN_LATESTVIDEOUPLOADDATE_LATESTVIDEOUPLOADDATE_1 =
		"lectureseries.latestVideoUploadDate IS NULL";
	private static final String _FINDER_COLUMN_LATESTVIDEOUPLOADDATE_LATESTVIDEOUPLOADDATE_2 =
		"lectureseries.latestVideoUploadDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LATESTVIDEOGENERATIONDATE =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLatestVideoGenerationDate",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOGENERATIONDATE =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLatestVideoGenerationDate",
			new String[] { String.class.getName() },
			LectureseriesModelImpl.LATESTVIDEOGENERATIONDATE_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LATESTVIDEOGENERATIONDATE =
		new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLatestVideoGenerationDate",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate) {
		return findByLatestVideoGenerationDate(latestVideoGenerationDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate, int start, int end) {
		return findByLatestVideoGenerationDate(latestVideoGenerationDate,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findByLatestVideoGenerationDate(latestVideoGenerationDate,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOGENERATIONDATE;
			finderArgs = new Object[] { latestVideoGenerationDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LATESTVIDEOGENERATIONDATE;
			finderArgs = new Object[] {
					latestVideoGenerationDate,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if (!Objects.equals(latestVideoGenerationDate,
								lectureseries.getLatestVideoGenerationDate())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			boolean bindLatestVideoGenerationDate = false;

			if (latestVideoGenerationDate == null) {
				query.append(_FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_1);
			}
			else if (latestVideoGenerationDate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_3);
			}
			else {
				bindLatestVideoGenerationDate = true;

				query.append(_FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLatestVideoGenerationDate) {
					qPos.add(latestVideoGenerationDate);
				}

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByLatestVideoGenerationDate_First(
		String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByLatestVideoGenerationDate_First(latestVideoGenerationDate,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("latestVideoGenerationDate=");
		msg.append(latestVideoGenerationDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByLatestVideoGenerationDate_First(
		String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByLatestVideoGenerationDate(latestVideoGenerationDate,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByLatestVideoGenerationDate_Last(
		String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByLatestVideoGenerationDate_Last(latestVideoGenerationDate,
				orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("latestVideoGenerationDate=");
		msg.append(latestVideoGenerationDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByLatestVideoGenerationDate_Last(
		String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByLatestVideoGenerationDate(latestVideoGenerationDate);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByLatestVideoGenerationDate(latestVideoGenerationDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByLatestVideoGenerationDate_PrevAndNext(
		long lectureseriesId, String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByLatestVideoGenerationDate_PrevAndNext(session,
					lectureseries, latestVideoGenerationDate,
					orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByLatestVideoGenerationDate_PrevAndNext(session,
					lectureseries, latestVideoGenerationDate,
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

	protected Lectureseries getByLatestVideoGenerationDate_PrevAndNext(
		Session session, Lectureseries lectureseries,
		String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		boolean bindLatestVideoGenerationDate = false;

		if (latestVideoGenerationDate == null) {
			query.append(_FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_1);
		}
		else if (latestVideoGenerationDate.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_3);
		}
		else {
			bindLatestVideoGenerationDate = true;

			query.append(_FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_2);
		}

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLatestVideoGenerationDate) {
			qPos.add(latestVideoGenerationDate);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where latestVideoGenerationDate = &#63; from the database.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 */
	@Override
	public void removeByLatestVideoGenerationDate(
		String latestVideoGenerationDate) {
		for (Lectureseries lectureseries : findByLatestVideoGenerationDate(
				latestVideoGenerationDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByLatestVideoGenerationDate(
		String latestVideoGenerationDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LATESTVIDEOGENERATIONDATE;

		Object[] finderArgs = new Object[] { latestVideoGenerationDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			boolean bindLatestVideoGenerationDate = false;

			if (latestVideoGenerationDate == null) {
				query.append(_FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_1);
			}
			else if (latestVideoGenerationDate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_3);
			}
			else {
				bindLatestVideoGenerationDate = true;

				query.append(_FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLatestVideoGenerationDate) {
					qPos.add(latestVideoGenerationDate);
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

	private static final String _FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_1 =
		"lectureseries.latestVideoGenerationDate IS NULL";
	private static final String _FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_2 =
		"lectureseries.latestVideoGenerationDate = ?";
	private static final String _FINDER_COLUMN_LATESTVIDEOGENERATIONDATE_LATESTVIDEOGENERATIONDATE_3 =
		"(lectureseries.latestVideoGenerationDate IS NULL OR lectureseries.latestVideoGenerationDate = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USID = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUSID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USID = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			LectureseriesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUSID", new String[] { String.class.getName() },
			LectureseriesModelImpl.USID_COLUMN_BITMASK |
			LectureseriesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USID = new FinderPath(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lectureserieses where USID = &#63;.
	 *
	 * @param USID the usid
	 * @return the matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByUSID(String USID) {
		return findByUSID(USID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureserieses where USID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USID the usid
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByUSID(String USID, int start, int end) {
		return findByUSID(USID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where USID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USID the usid
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByUSID(String USID, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findByUSID(USID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses where USID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USID the usid
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Override
	public List<Lectureseries> findByUSID(String USID, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USID;
			finderArgs = new Object[] { USID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USID;
			finderArgs = new Object[] { USID, start, end, orderByComparator };
		}

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries lectureseries : list) {
					if (!Objects.equals(USID, lectureseries.getUSID())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_WHERE);

			boolean bindUSID = false;

			if (USID == null) {
				query.append(_FINDER_COLUMN_USID_USID_1);
			}
			else if (USID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USID_USID_3);
			}
			else {
				bindUSID = true;

				query.append(_FINDER_COLUMN_USID_USID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUSID) {
					qPos.add(USID);
				}

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByUSID_First(String USID,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByUSID_First(USID, orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USID=");
		msg.append(USID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the first lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByUSID_First(String USID,
		OrderByComparator<Lectureseries> orderByComparator) {
		List<Lectureseries> list = findByUSID(USID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries findByUSID_Last(String USID,
		OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByUSID_Last(USID, orderByComparator);

		if (lectureseries != null) {
			return lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USID=");
		msg.append(USID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseriesException(msg.toString());
	}

	/**
	 * Returns the last lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	@Override
	public Lectureseries fetchByUSID_Last(String USID,
		OrderByComparator<Lectureseries> orderByComparator) {
		int count = countByUSID(USID);

		if (count == 0) {
			return null;
		}

		List<Lectureseries> list = findByUSID(USID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries[] findByUSID_PrevAndNext(long lectureseriesId,
		String USID, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = findByPrimaryKey(lectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries[] array = new LectureseriesImpl[3];

			array[0] = getByUSID_PrevAndNext(session, lectureseries, USID,
					orderByComparator, true);

			array[1] = lectureseries;

			array[2] = getByUSID_PrevAndNext(session, lectureseries, USID,
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

	protected Lectureseries getByUSID_PrevAndNext(Session session,
		Lectureseries lectureseries, String USID,
		OrderByComparator<Lectureseries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_WHERE);

		boolean bindUSID = false;

		if (USID == null) {
			query.append(_FINDER_COLUMN_USID_USID_1);
		}
		else if (USID.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USID_USID_3);
		}
		else {
			bindUSID = true;

			query.append(_FINDER_COLUMN_USID_USID_2);
		}

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
			query.append(LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUSID) {
			qPos.add(USID);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureserieses where USID = &#63; from the database.
	 *
	 * @param USID the usid
	 */
	@Override
	public void removeByUSID(String USID) {
		for (Lectureseries lectureseries : findByUSID(USID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses where USID = &#63;.
	 *
	 * @param USID the usid
	 * @return the number of matching lectureserieses
	 */
	@Override
	public int countByUSID(String USID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USID;

		Object[] finderArgs = new Object[] { USID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_WHERE);

			boolean bindUSID = false;

			if (USID == null) {
				query.append(_FINDER_COLUMN_USID_USID_1);
			}
			else if (USID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USID_USID_3);
			}
			else {
				bindUSID = true;

				query.append(_FINDER_COLUMN_USID_USID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUSID) {
					qPos.add(USID);
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

	private static final String _FINDER_COLUMN_USID_USID_1 = "lectureseries.USID IS NULL";
	private static final String _FINDER_COLUMN_USID_USID_2 = "lectureseries.USID = ?";
	private static final String _FINDER_COLUMN_USID_USID_3 = "(lectureseries.USID IS NULL OR lectureseries.USID = '')";

	public LectureseriesPersistenceImpl() {
		setModelClass(Lectureseries.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("number", "number_");
			dbColumnNames.put("password", "password_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the lectureseries in the entity cache if it is enabled.
	 *
	 * @param lectureseries the lectureseries
	 */
	@Override
	public void cacheResult(Lectureseries lectureseries) {
		entityCache.putResult(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesImpl.class, lectureseries.getPrimaryKey(),
			lectureseries);

		lectureseries.resetOriginalValues();
	}

	/**
	 * Caches the lectureserieses in the entity cache if it is enabled.
	 *
	 * @param lectureserieses the lectureserieses
	 */
	@Override
	public void cacheResult(List<Lectureseries> lectureserieses) {
		for (Lectureseries lectureseries : lectureserieses) {
			if (entityCache.getResult(
						LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
						LectureseriesImpl.class, lectureseries.getPrimaryKey()) == null) {
				cacheResult(lectureseries);
			}
			else {
				lectureseries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lectureserieses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LectureseriesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lectureseries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lectureseries lectureseries) {
		entityCache.removeResult(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesImpl.class, lectureseries.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lectureseries> lectureserieses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lectureseries lectureseries : lectureserieses) {
			entityCache.removeResult(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				LectureseriesImpl.class, lectureseries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	 *
	 * @param lectureseriesId the primary key for the new lectureseries
	 * @return the new lectureseries
	 */
	@Override
	public Lectureseries create(long lectureseriesId) {
		Lectureseries lectureseries = new LectureseriesImpl();

		lectureseries.setNew(true);
		lectureseries.setPrimaryKey(lectureseriesId);

		return lectureseries;
	}

	/**
	 * Removes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries that was removed
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries remove(long lectureseriesId)
		throws NoSuchLectureseriesException {
		return remove((Serializable)lectureseriesId);
	}

	/**
	 * Removes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lectureseries
	 * @return the lectureseries that was removed
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries remove(Serializable primaryKey)
		throws NoSuchLectureseriesException {
		Session session = null;

		try {
			session = openSession();

			Lectureseries lectureseries = (Lectureseries)session.get(LectureseriesImpl.class,
					primaryKey);

			if (lectureseries == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLectureseriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lectureseries);
		}
		catch (NoSuchLectureseriesException nsee) {
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
	protected Lectureseries removeImpl(Lectureseries lectureseries) {
		lectureseries = toUnwrappedModel(lectureseries);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lectureseries)) {
				lectureseries = (Lectureseries)session.get(LectureseriesImpl.class,
						lectureseries.getPrimaryKeyObj());
			}

			if (lectureseries != null) {
				session.delete(lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lectureseries != null) {
			clearCache(lectureseries);
		}

		return lectureseries;
	}

	@Override
	public Lectureseries updateImpl(Lectureseries lectureseries) {
		lectureseries = toUnwrappedModel(lectureseries);

		boolean isNew = lectureseries.isNew();

		LectureseriesModelImpl lectureseriesModelImpl = (LectureseriesModelImpl)lectureseries;

		Session session = null;

		try {
			session = openSession();

			if (lectureseries.isNew()) {
				session.save(lectureseries);

				lectureseries.setNew(false);
			}
			else {
				lectureseries = (Lectureseries)session.merge(lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LectureseriesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { lectureseriesModelImpl.getTermId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TERM, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM,
				args);

			args = new Object[] { lectureseriesModelImpl.getLanguage() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LANGUAGE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE,
				args);

			args = new Object[] { lectureseriesModelImpl.getNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER,
				args);

			args = new Object[] { lectureseriesModelImpl.getEventType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
				args);

			args = new Object[] { lectureseriesModelImpl.getCategoryId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
				args);

			args = new Object[] { lectureseriesModelImpl.getName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
				args);

			args = new Object[] { lectureseriesModelImpl.getFacultyName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FACULTY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTY,
				args);

			args = new Object[] { lectureseriesModelImpl.getApproved() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPROVED, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED,
				args);

			args = new Object[] { lectureseriesModelImpl.getPassword() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PASSWORD, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD,
				args);

			args = new Object[] {
					lectureseriesModelImpl.getLatestOpenAccessVideoId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LATESTOPENACCESSVIDEO,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTOPENACCESSVIDEO,
				args);

			args = new Object[] {
					lectureseriesModelImpl.getLatestVideoUploadDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LATESTVIDEOUPLOADDATE,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOUPLOADDATE,
				args);

			args = new Object[] {
					lectureseriesModelImpl.getLatestVideoGenerationDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LATESTVIDEOGENERATIONDATE,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOGENERATIONDATE,
				args);

			args = new Object[] { lectureseriesModelImpl.getUSID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalTermId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TERM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM,
					args);

				args = new Object[] { lectureseriesModelImpl.getTermId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TERM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalLanguage()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LANGUAGE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE,
					args);

				args = new Object[] { lectureseriesModelImpl.getLanguage() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LANGUAGE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalNumber()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER,
					args);

				args = new Object[] { lectureseriesModelImpl.getNumber() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { lectureseriesModelImpl.getEventType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalCategoryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] { lectureseriesModelImpl.getCategoryId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { lectureseriesModelImpl.getName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalFacultyName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FACULTY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTY,
					args);

				args = new Object[] { lectureseriesModelImpl.getFacultyName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FACULTY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTY,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalApproved()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPROVED, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED,
					args);

				args = new Object[] { lectureseriesModelImpl.getApproved() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPROVED, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalPassword()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PASSWORD, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD,
					args);

				args = new Object[] { lectureseriesModelImpl.getPassword() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PASSWORD, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTOPENACCESSVIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalLatestOpenAccessVideoId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LATESTOPENACCESSVIDEO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTOPENACCESSVIDEO,
					args);

				args = new Object[] {
						lectureseriesModelImpl.getLatestOpenAccessVideoId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LATESTOPENACCESSVIDEO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTOPENACCESSVIDEO,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOUPLOADDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalLatestVideoUploadDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LATESTVIDEOUPLOADDATE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOUPLOADDATE,
					args);

				args = new Object[] {
						lectureseriesModelImpl.getLatestVideoUploadDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LATESTVIDEOUPLOADDATE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOUPLOADDATE,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOGENERATIONDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalLatestVideoGenerationDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LATESTVIDEOGENERATIONDATE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOGENERATIONDATE,
					args);

				args = new Object[] {
						lectureseriesModelImpl.getLatestVideoGenerationDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LATESTVIDEOGENERATIONDATE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LATESTVIDEOGENERATIONDATE,
					args);
			}

			if ((lectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseriesModelImpl.getOriginalUSID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USID,
					args);

				args = new Object[] { lectureseriesModelImpl.getUSID() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USID,
					args);
			}
		}

		entityCache.putResult(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			LectureseriesImpl.class, lectureseries.getPrimaryKey(),
			lectureseries, false);

		lectureseries.resetOriginalValues();

		return lectureseries;
	}

	protected Lectureseries toUnwrappedModel(Lectureseries lectureseries) {
		if (lectureseries instanceof LectureseriesImpl) {
			return lectureseries;
		}

		LectureseriesImpl lectureseriesImpl = new LectureseriesImpl();

		lectureseriesImpl.setNew(lectureseries.isNew());
		lectureseriesImpl.setPrimaryKey(lectureseries.getPrimaryKey());

		lectureseriesImpl.setNumber(lectureseries.getNumber());
		lectureseriesImpl.setEventType(lectureseries.getEventType());
		lectureseriesImpl.setCategoryId(lectureseries.getCategoryId());
		lectureseriesImpl.setName(lectureseries.getName());
		lectureseriesImpl.setShortDesc(lectureseries.getShortDesc());
		lectureseriesImpl.setTermId(lectureseries.getTermId());
		lectureseriesImpl.setLanguage(lectureseries.getLanguage());
		lectureseriesImpl.setFacultyName(lectureseries.getFacultyName());
		lectureseriesImpl.setLectureseriesId(lectureseries.getLectureseriesId());
		lectureseriesImpl.setPassword(lectureseries.getPassword());
		lectureseriesImpl.setApproved(lectureseries.getApproved());
		lectureseriesImpl.setLongDesc(lectureseries.getLongDesc());
		lectureseriesImpl.setLatestOpenAccessVideoId(lectureseries.getLatestOpenAccessVideoId());
		lectureseriesImpl.setLatestVideoUploadDate(lectureseries.getLatestVideoUploadDate());
		lectureseriesImpl.setLatestVideoGenerationDate(lectureseries.getLatestVideoGenerationDate());
		lectureseriesImpl.setVideoSort(lectureseries.getVideoSort());
		lectureseriesImpl.setUSID(lectureseries.getUSID());
		lectureseriesImpl.setPreviewVideoId(lectureseries.getPreviewVideoId());

		return lectureseriesImpl;
	}

	/**
	 * Returns the lectureseries with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries
	 * @return the lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLectureseriesException {
		Lectureseries lectureseries = fetchByPrimaryKey(primaryKey);

		if (lectureseries == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLectureseriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lectureseries;
	}

	/**
	 * Returns the lectureseries with the primary key or throws a {@link NoSuchLectureseriesException} if it could not be found.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries findByPrimaryKey(long lectureseriesId)
		throws NoSuchLectureseriesException {
		return findByPrimaryKey((Serializable)lectureseriesId);
	}

	/**
	 * Returns the lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries
	 * @return the lectureseries, or <code>null</code> if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				LectureseriesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Lectureseries lectureseries = (Lectureseries)serializable;

		if (lectureseries == null) {
			Session session = null;

			try {
				session = openSession();

				lectureseries = (Lectureseries)session.get(LectureseriesImpl.class,
						primaryKey);

				if (lectureseries != null) {
					cacheResult(lectureseries);
				}
				else {
					entityCache.putResult(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
						LectureseriesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
					LectureseriesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lectureseries;
	}

	/**
	 * Returns the lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries, or <code>null</code> if a lectureseries with the primary key could not be found
	 */
	@Override
	public Lectureseries fetchByPrimaryKey(long lectureseriesId) {
		return fetchByPrimaryKey((Serializable)lectureseriesId);
	}

	@Override
	public Map<Serializable, Lectureseries> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Lectureseries> map = new HashMap<Serializable, Lectureseries>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Lectureseries lectureseries = fetchByPrimaryKey(primaryKey);

			if (lectureseries != null) {
				map.put(primaryKey, lectureseries);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
					LectureseriesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Lectureseries)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LECTURESERIES_WHERE_PKS_IN);

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

			for (Lectureseries lectureseries : (List<Lectureseries>)q.list()) {
				map.put(lectureseries.getPrimaryKeyObj(), lectureseries);

				cacheResult(lectureseries);

				uncachedPrimaryKeys.remove(lectureseries.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
					LectureseriesImpl.class, primaryKey, nullModel);
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
	 * Returns all the lectureserieses.
	 *
	 * @return the lectureserieses
	 */
	@Override
	public List<Lectureseries> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of lectureserieses
	 */
	@Override
	public List<Lectureseries> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureserieses
	 */
	@Override
	public List<Lectureseries> findAll(int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lectureserieses
	 */
	@Override
	public List<Lectureseries> findAll(int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
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

		List<Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LECTURESERIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LECTURESERIES;

				if (pagination) {
					sql = sql.concat(LectureseriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the lectureserieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Lectureseries lectureseries : findAll()) {
			remove(lectureseries);
		}
	}

	/**
	 * Returns the number of lectureserieses.
	 *
	 * @return the number of lectureserieses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LECTURESERIES);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LectureseriesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lectureseries persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LectureseriesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LECTURESERIES = "SELECT lectureseries FROM Lectureseries lectureseries";
	private static final String _SQL_SELECT_LECTURESERIES_WHERE_PKS_IN = "SELECT lectureseries FROM Lectureseries lectureseries WHERE lectureseriesId IN (";
	private static final String _SQL_SELECT_LECTURESERIES_WHERE = "SELECT lectureseries FROM Lectureseries lectureseries WHERE ";
	private static final String _SQL_COUNT_LECTURESERIES = "SELECT COUNT(lectureseries) FROM Lectureseries lectureseries";
	private static final String _SQL_COUNT_LECTURESERIES_WHERE = "SELECT COUNT(lectureseries) FROM Lectureseries lectureseries WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lectureseries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lectureseries exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Lectureseries exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LectureseriesPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"number", "password"
			});
}