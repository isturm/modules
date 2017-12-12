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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException;
import de.uhh.l2g.plugins.model.Lectureseries_Category;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl;
import de.uhh.l2g.plugins.service.persistence.Lectureseries_CategoryPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the lectureseries_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryPersistence
 * @see de.uhh.l2g.plugins.service.persistence.Lectureseries_CategoryUtil
 * @generated
 */
@ProviderType
public class Lectureseries_CategoryPersistenceImpl extends BasePersistenceImpl<Lectureseries_Category>
	implements Lectureseries_CategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Lectureseries_CategoryUtil} to access the lectureseries_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Lectureseries_CategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseries",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseries",
			new String[] { Long.class.getName() },
			Lectureseries_CategoryModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIES = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseries",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ categories where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId) {
		return findByLectureseries(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ categories where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @return the range of matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end) {
		return findByLectureseries(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return findByLectureseries(lectureseriesId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES;
			finderArgs = new Object[] { lectureseriesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES;
			finderArgs = new Object[] {
					lectureseriesId,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries_Category> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries_Category>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries_Category lectureseries_Category : list) {
					if ((lectureseriesId != lectureseries_Category.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category findByLectureseries_First(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = fetchByLectureseries_First(lectureseriesId,
				orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category fetchByLectureseries_First(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		List<Lectureseries_Category> list = findByLectureseries(lectureseriesId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category findByLectureseries_Last(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = fetchByLectureseries_Last(lectureseriesId,
				orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category fetchByLectureseries_Last(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		int count = countByLectureseries(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Category> list = findByLectureseries(lectureseriesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public Lectureseries_Category[] findByLectureseries_PrevAndNext(
		long lectureseriesCategoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = findByPrimaryKey(lectureseriesCategoryId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Category[] array = new Lectureseries_CategoryImpl[3];

			array[0] = getByLectureseries_PrevAndNext(session,
					lectureseries_Category, lectureseriesId, orderByComparator,
					true);

			array[1] = lectureseries_Category;

			array[2] = getByLectureseries_PrevAndNext(session,
					lectureseries_Category, lectureseriesId, orderByComparator,
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

	protected Lectureseries_Category getByLectureseries_PrevAndNext(
		Session session, Lectureseries_Category lectureseries_Category,
		long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

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
			query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ categories where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	@Override
	public void removeByLectureseries(long lectureseriesId) {
		for (Lectureseries_Category lectureseries_Category : findByLectureseries(
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Category);
		}
	}

	/**
	 * Returns the number of lectureseries_ categories where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ categories
	 */
	@Override
	public int countByLectureseries(long lectureseriesId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIES;

		Object[] finderArgs = new Object[] { lectureseriesId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

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

	private static final String _FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2 = "lectureseries_Category.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			Lectureseries_CategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByCategory(long categoryId) {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lectureseries_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @return the range of matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByCategory(long categoryId,
		int start, int end) {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByCategory(long categoryId,
		int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return findByCategory(categoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByCategory(long categoryId,
		int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator,
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

		List<Lectureseries_Category> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries_Category>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries_Category lectureseries_Category : list) {
					if ((categoryId != lectureseries_Category.getCategoryId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category findByCategory_First(long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = fetchByCategory_First(categoryId,
				orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category fetchByCategory_First(long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		List<Lectureseries_Category> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category findByCategory_Last(long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category fetchByCategory_Last(long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		int count = countByCategory(categoryId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Category> list = findByCategory(categoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public Lectureseries_Category[] findByCategory_PrevAndNext(
		long lectureseriesCategoryId, long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = findByPrimaryKey(lectureseriesCategoryId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Category[] array = new Lectureseries_CategoryImpl[3];

			array[0] = getByCategory_PrevAndNext(session,
					lectureseries_Category, categoryId, orderByComparator, true);

			array[1] = lectureseries_Category;

			array[2] = getByCategory_PrevAndNext(session,
					lectureseries_Category, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries_Category getByCategory_PrevAndNext(
		Session session, Lectureseries_Category lectureseries_Category,
		long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

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
			query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByCategory(long categoryId) {
		for (Lectureseries_Category lectureseries_Category : findByCategory(
				categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Category);
		}
	}

	/**
	 * Returns the number of lectureseries_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching lectureseries_ categories
	 */
	@Override
	public int countByCategory(long categoryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_CATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "lectureseries_Category.categoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYLECTURESERIES =
		new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryLectureseries",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYLECTURESERIES =
		new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryLectureseries",
			new String[] { Long.class.getName(), Long.class.getName() },
			Lectureseries_CategoryModelImpl.CATEGORYID_COLUMN_BITMASK |
			Lectureseries_CategoryModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYLECTURESERIES = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryLectureseries",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId) {
		return findByCategoryLectureseries(categoryId, lectureseriesId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @return the range of matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId, int start, int end) {
		return findByCategoryLectureseries(categoryId, lectureseriesId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return findByCategoryLectureseries(categoryId, lectureseriesId, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYLECTURESERIES;
			finderArgs = new Object[] { categoryId, lectureseriesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYLECTURESERIES;
			finderArgs = new Object[] {
					categoryId, lectureseriesId,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries_Category> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries_Category>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries_Category lectureseries_Category : list) {
					if ((categoryId != lectureseries_Category.getCategoryId()) ||
							(lectureseriesId != lectureseries_Category.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYLECTURESERIES_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYLECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category findByCategoryLectureseries_First(
		long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = fetchByCategoryLectureseries_First(categoryId,
				lectureseriesId, orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category fetchByCategoryLectureseries_First(
		long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		List<Lectureseries_Category> list = findByCategoryLectureseries(categoryId,
				lectureseriesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category findByCategoryLectureseries_Last(
		long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = fetchByCategoryLectureseries_Last(categoryId,
				lectureseriesId, orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 */
	@Override
	public Lectureseries_Category fetchByCategoryLectureseries_Last(
		long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		int count = countByCategoryLectureseries(categoryId, lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Category> list = findByCategoryLectureseries(categoryId,
				lectureseriesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public Lectureseries_Category[] findByCategoryLectureseries_PrevAndNext(
		long lectureseriesCategoryId, long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = findByPrimaryKey(lectureseriesCategoryId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Category[] array = new Lectureseries_CategoryImpl[3];

			array[0] = getByCategoryLectureseries_PrevAndNext(session,
					lectureseries_Category, categoryId, lectureseriesId,
					orderByComparator, true);

			array[1] = lectureseries_Category;

			array[2] = getByCategoryLectureseries_PrevAndNext(session,
					lectureseries_Category, categoryId, lectureseriesId,
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

	protected Lectureseries_Category getByCategoryLectureseries_PrevAndNext(
		Session session, Lectureseries_Category lectureseries_Category,
		long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYLECTURESERIES_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYLECTURESERIES_LECTURESERIESID_2);

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
			query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 */
	@Override
	public void removeByCategoryLectureseries(long categoryId,
		long lectureseriesId) {
		for (Lectureseries_Category lectureseries_Category : findByCategoryLectureseries(
				categoryId, lectureseriesId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Category);
		}
	}

	/**
	 * Returns the number of lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ categories
	 */
	@Override
	public int countByCategoryLectureseries(long categoryId,
		long lectureseriesId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYLECTURESERIES;

		Object[] finderArgs = new Object[] { categoryId, lectureseriesId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LECTURESERIES_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYLECTURESERIES_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYLECTURESERIES_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(lectureseriesId);

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

	private static final String _FINDER_COLUMN_CATEGORYLECTURESERIES_CATEGORYID_2 =
		"lectureseries_Category.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYLECTURESERIES_LECTURESERIESID_2 =
		"lectureseries_Category.lectureseriesId = ?";

	public Lectureseries_CategoryPersistenceImpl() {
		setModelClass(Lectureseries_Category.class);
	}

	/**
	 * Caches the lectureseries_ category in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Category the lectureseries_ category
	 */
	@Override
	public void cacheResult(Lectureseries_Category lectureseries_Category) {
		entityCache.putResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			lectureseries_Category.getPrimaryKey(), lectureseries_Category);

		lectureseries_Category.resetOriginalValues();
	}

	/**
	 * Caches the lectureseries_ categories in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Categories the lectureseries_ categories
	 */
	@Override
	public void cacheResult(
		List<Lectureseries_Category> lectureseries_Categories) {
		for (Lectureseries_Category lectureseries_Category : lectureseries_Categories) {
			if (entityCache.getResult(
						Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_CategoryImpl.class,
						lectureseries_Category.getPrimaryKey()) == null) {
				cacheResult(lectureseries_Category);
			}
			else {
				lectureseries_Category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lectureseries_ categories.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Lectureseries_CategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lectureseries_ category.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lectureseries_Category lectureseries_Category) {
		entityCache.removeResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			lectureseries_Category.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Lectureseries_Category> lectureseries_Categories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lectureseries_Category lectureseries_Category : lectureseries_Categories) {
			entityCache.removeResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_CategoryImpl.class,
				lectureseries_Category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lectureseries_ category with the primary key. Does not add the lectureseries_ category to the database.
	 *
	 * @param lectureseriesCategoryId the primary key for the new lectureseries_ category
	 * @return the new lectureseries_ category
	 */
	@Override
	public Lectureseries_Category create(long lectureseriesCategoryId) {
		Lectureseries_Category lectureseries_Category = new Lectureseries_CategoryImpl();

		lectureseries_Category.setNew(true);
		lectureseries_Category.setPrimaryKey(lectureseriesCategoryId);

		return lectureseries_Category;
	}

	/**
	 * Removes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category that was removed
	 * @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public Lectureseries_Category remove(long lectureseriesCategoryId)
		throws NoSuchLectureseries_CategoryException {
		return remove((Serializable)lectureseriesCategoryId);
	}

	/**
	 * Removes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lectureseries_ category
	 * @return the lectureseries_ category that was removed
	 * @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public Lectureseries_Category remove(Serializable primaryKey)
		throws NoSuchLectureseries_CategoryException {
		Session session = null;

		try {
			session = openSession();

			Lectureseries_Category lectureseries_Category = (Lectureseries_Category)session.get(Lectureseries_CategoryImpl.class,
					primaryKey);

			if (lectureseries_Category == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLectureseries_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lectureseries_Category);
		}
		catch (NoSuchLectureseries_CategoryException nsee) {
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
	protected Lectureseries_Category removeImpl(
		Lectureseries_Category lectureseries_Category) {
		lectureseries_Category = toUnwrappedModel(lectureseries_Category);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lectureseries_Category)) {
				lectureseries_Category = (Lectureseries_Category)session.get(Lectureseries_CategoryImpl.class,
						lectureseries_Category.getPrimaryKeyObj());
			}

			if (lectureseries_Category != null) {
				session.delete(lectureseries_Category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lectureseries_Category != null) {
			clearCache(lectureseries_Category);
		}

		return lectureseries_Category;
	}

	@Override
	public Lectureseries_Category updateImpl(
		Lectureseries_Category lectureseries_Category) {
		lectureseries_Category = toUnwrappedModel(lectureseries_Category);

		boolean isNew = lectureseries_Category.isNew();

		Lectureseries_CategoryModelImpl lectureseries_CategoryModelImpl = (Lectureseries_CategoryModelImpl)lectureseries_Category;

		Session session = null;

		try {
			session = openSession();

			if (lectureseries_Category.isNew()) {
				session.save(lectureseries_Category);

				lectureseries_Category.setNew(false);
			}
			else {
				lectureseries_Category = (Lectureseries_Category)session.merge(lectureseries_Category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Lectureseries_CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					lectureseries_CategoryModelImpl.getLectureseriesId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
				args);

			args = new Object[] { lectureseries_CategoryModelImpl.getCategoryId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
				args);

			args = new Object[] {
					lectureseries_CategoryModelImpl.getCategoryId(),
					lectureseries_CategoryModelImpl.getLectureseriesId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORYLECTURESERIES,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYLECTURESERIES,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((lectureseries_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_CategoryModelImpl.getOriginalLectureseriesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);

				args = new Object[] {
						lectureseries_CategoryModelImpl.getLectureseriesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);
			}

			if ((lectureseries_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_CategoryModelImpl.getOriginalCategoryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						lectureseries_CategoryModelImpl.getCategoryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((lectureseries_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYLECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_CategoryModelImpl.getOriginalCategoryId(),
						lectureseries_CategoryModelImpl.getOriginalLectureseriesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORYLECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYLECTURESERIES,
					args);

				args = new Object[] {
						lectureseries_CategoryModelImpl.getCategoryId(),
						lectureseries_CategoryModelImpl.getLectureseriesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORYLECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYLECTURESERIES,
					args);
			}
		}

		entityCache.putResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			lectureseries_Category.getPrimaryKey(), lectureseries_Category,
			false);

		lectureseries_Category.resetOriginalValues();

		return lectureseries_Category;
	}

	protected Lectureseries_Category toUnwrappedModel(
		Lectureseries_Category lectureseries_Category) {
		if (lectureseries_Category instanceof Lectureseries_CategoryImpl) {
			return lectureseries_Category;
		}

		Lectureseries_CategoryImpl lectureseries_CategoryImpl = new Lectureseries_CategoryImpl();

		lectureseries_CategoryImpl.setNew(lectureseries_Category.isNew());
		lectureseries_CategoryImpl.setPrimaryKey(lectureseries_Category.getPrimaryKey());

		lectureseries_CategoryImpl.setLectureseriesCategoryId(lectureseries_Category.getLectureseriesCategoryId());
		lectureseries_CategoryImpl.setCategoryId(lectureseries_Category.getCategoryId());
		lectureseries_CategoryImpl.setLectureseriesId(lectureseries_Category.getLectureseriesId());

		return lectureseries_CategoryImpl;
	}

	/**
	 * Returns the lectureseries_ category with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ category
	 * @return the lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public Lectureseries_Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLectureseries_CategoryException {
		Lectureseries_Category lectureseries_Category = fetchByPrimaryKey(primaryKey);

		if (lectureseries_Category == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLectureseries_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lectureseries_Category;
	}

	/**
	 * Returns the lectureseries_ category with the primary key or throws a {@link NoSuchLectureseries_CategoryException} if it could not be found.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category
	 * @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public Lectureseries_Category findByPrimaryKey(long lectureseriesCategoryId)
		throws NoSuchLectureseries_CategoryException {
		return findByPrimaryKey((Serializable)lectureseriesCategoryId);
	}

	/**
	 * Returns the lectureseries_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ category
	 * @return the lectureseries_ category, or <code>null</code> if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public Lectureseries_Category fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_CategoryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Lectureseries_Category lectureseries_Category = (Lectureseries_Category)serializable;

		if (lectureseries_Category == null) {
			Session session = null;

			try {
				session = openSession();

				lectureseries_Category = (Lectureseries_Category)session.get(Lectureseries_CategoryImpl.class,
						primaryKey);

				if (lectureseries_Category != null) {
					cacheResult(lectureseries_Category);
				}
				else {
					entityCache.putResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_CategoryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
					Lectureseries_CategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lectureseries_Category;
	}

	/**
	 * Returns the lectureseries_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category, or <code>null</code> if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public Lectureseries_Category fetchByPrimaryKey(
		long lectureseriesCategoryId) {
		return fetchByPrimaryKey((Serializable)lectureseriesCategoryId);
	}

	@Override
	public Map<Serializable, Lectureseries_Category> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Lectureseries_Category> map = new HashMap<Serializable, Lectureseries_Category>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Lectureseries_Category lectureseries_Category = fetchByPrimaryKey(primaryKey);

			if (lectureseries_Category != null) {
				map.put(primaryKey, lectureseries_Category);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
					Lectureseries_CategoryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Lectureseries_Category)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE_PKS_IN);

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

			for (Lectureseries_Category lectureseries_Category : (List<Lectureseries_Category>)q.list()) {
				map.put(lectureseries_Category.getPrimaryKeyObj(),
					lectureseries_Category);

				cacheResult(lectureseries_Category);

				uncachedPrimaryKeys.remove(lectureseries_Category.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
					Lectureseries_CategoryImpl.class, primaryKey, nullModel);
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
	 * Returns all the lectureseries_ categories.
	 *
	 * @return the lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @return the range of lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findAll(int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lectureseries_ categories
	 */
	@Override
	public List<Lectureseries_Category> findAll(int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator,
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

		List<Lectureseries_Category> list = null;

		if (retrieveFromCache) {
			list = (List<Lectureseries_Category>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LECTURESERIES_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LECTURESERIES_CATEGORY;

				if (pagination) {
					sql = sql.concat(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
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
	 * Removes all the lectureseries_ categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Lectureseries_Category lectureseries_Category : findAll()) {
			remove(lectureseries_Category);
		}
	}

	/**
	 * Returns the number of lectureseries_ categories.
	 *
	 * @return the number of lectureseries_ categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LECTURESERIES_CATEGORY);

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
		return Lectureseries_CategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lectureseries_ category persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Lectureseries_CategoryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LECTURESERIES_CATEGORY = "SELECT lectureseries_Category FROM Lectureseries_Category lectureseries_Category";
	private static final String _SQL_SELECT_LECTURESERIES_CATEGORY_WHERE_PKS_IN = "SELECT lectureseries_Category FROM Lectureseries_Category lectureseries_Category WHERE lectureseriesCategoryId IN (";
	private static final String _SQL_SELECT_LECTURESERIES_CATEGORY_WHERE = "SELECT lectureseries_Category FROM Lectureseries_Category lectureseries_Category WHERE ";
	private static final String _SQL_COUNT_LECTURESERIES_CATEGORY = "SELECT COUNT(lectureseries_Category) FROM Lectureseries_Category lectureseries_Category";
	private static final String _SQL_COUNT_LECTURESERIES_CATEGORY_WHERE = "SELECT COUNT(lectureseries_Category) FROM Lectureseries_Category lectureseries_Category WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lectureseries_Category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lectureseries_Category exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Lectureseries_Category exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Lectureseries_CategoryPersistenceImpl.class);
}