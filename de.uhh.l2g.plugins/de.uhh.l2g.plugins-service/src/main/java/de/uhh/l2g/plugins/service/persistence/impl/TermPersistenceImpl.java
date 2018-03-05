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
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchTermException;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.impl.TermImpl;
import de.uhh.l2g.plugins.model.impl.TermModelImpl;
import de.uhh.l2g.plugins.service.persistence.TermPersistence;

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

/**
 * The persistence implementation for the term service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TermPersistence
 * @see de.uhh.l2g.plugins.service.persistence.TermUtil
 * @generated
 */
@ProviderType
public class TermPersistenceImpl extends BasePersistenceImpl<Term>
	implements TermPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TermUtil} to access the term persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TermImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PREFIX = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrefix",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX =
		new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrefix",
			new String[] { String.class.getName() },
			TermModelImpl.PREFIX_COLUMN_BITMASK |
			TermModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PREFIX = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrefix",
			new String[] { String.class.getName() });

	/**
	 * Returns all the terms where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the matching terms
	 */
	@Override
	public List<Term> findByPrefix(String prefix) {
		return findByPrefix(prefix, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	@Override
	public List<Term> findByPrefix(String prefix, int start, int end) {
		return findByPrefix(prefix, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByPrefix(String prefix, int start, int end,
		OrderByComparator<Term> orderByComparator) {
		return findByPrefix(prefix, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByPrefix(String prefix, int start, int end,
		OrderByComparator<Term> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX;
			finderArgs = new Object[] { prefix };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PREFIX;
			finderArgs = new Object[] { prefix, start, end, orderByComparator };
		}

		List<Term> list = null;

		if (retrieveFromCache) {
			list = (List<Term>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Term term : list) {
					if (!Objects.equals(prefix, term.getPrefix())) {
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

			query.append(_SQL_SELECT_TERM_WHERE);

			boolean bindPrefix = false;

			if (prefix == null) {
				query.append(_FINDER_COLUMN_PREFIX_PREFIX_1);
			}
			else if (prefix.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PREFIX_PREFIX_3);
			}
			else {
				bindPrefix = true;

				query.append(_FINDER_COLUMN_PREFIX_PREFIX_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPrefix) {
					qPos.add(prefix);
				}

				if (!pagination) {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByPrefix_First(String prefix,
		OrderByComparator<Term> orderByComparator) throws NoSuchTermException {
		Term term = fetchByPrefix_First(prefix, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("prefix=");
		msg.append(prefix);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the first term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByPrefix_First(String prefix,
		OrderByComparator<Term> orderByComparator) {
		List<Term> list = findByPrefix(prefix, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByPrefix_Last(String prefix,
		OrderByComparator<Term> orderByComparator) throws NoSuchTermException {
		Term term = fetchByPrefix_Last(prefix, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("prefix=");
		msg.append(prefix);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByPrefix_Last(String prefix,
		OrderByComparator<Term> orderByComparator) {
		int count = countByPrefix(prefix);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByPrefix(prefix, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where prefix = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term[] findByPrefix_PrevAndNext(long termId, String prefix,
		OrderByComparator<Term> orderByComparator) throws NoSuchTermException {
		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByPrefix_PrevAndNext(session, term, prefix,
					orderByComparator, true);

			array[1] = term;

			array[2] = getByPrefix_PrevAndNext(session, term, prefix,
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

	protected Term getByPrefix_PrevAndNext(Session session, Term term,
		String prefix, OrderByComparator<Term> orderByComparator,
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

		query.append(_SQL_SELECT_TERM_WHERE);

		boolean bindPrefix = false;

		if (prefix == null) {
			query.append(_FINDER_COLUMN_PREFIX_PREFIX_1);
		}
		else if (prefix.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PREFIX_PREFIX_3);
		}
		else {
			bindPrefix = true;

			query.append(_FINDER_COLUMN_PREFIX_PREFIX_2);
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
			query.append(TermModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPrefix) {
			qPos.add(prefix);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(term);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Term> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where prefix = &#63; from the database.
	 *
	 * @param prefix the prefix
	 */
	@Override
	public void removeByPrefix(String prefix) {
		for (Term term : findByPrefix(prefix, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the number of matching terms
	 */
	@Override
	public int countByPrefix(String prefix) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PREFIX;

		Object[] finderArgs = new Object[] { prefix };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TERM_WHERE);

			boolean bindPrefix = false;

			if (prefix == null) {
				query.append(_FINDER_COLUMN_PREFIX_PREFIX_1);
			}
			else if (prefix.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PREFIX_PREFIX_3);
			}
			else {
				bindPrefix = true;

				query.append(_FINDER_COLUMN_PREFIX_PREFIX_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPrefix) {
					qPos.add(prefix);
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

	private static final String _FINDER_COLUMN_PREFIX_PREFIX_1 = "term.prefix IS NULL";
	private static final String _FINDER_COLUMN_PREFIX_PREFIX_2 = "term.prefix = ?";
	private static final String _FINDER_COLUMN_PREFIX_PREFIX_3 = "(term.prefix IS NULL OR term.prefix = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYear",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] { String.class.getName() },
			TermModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEAR = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] { String.class.getName() });

	/**
	 * Returns all the terms where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching terms
	 */
	@Override
	public List<Term> findByYear(String year) {
		return findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	@Override
	public List<Term> findByYear(String year, int start, int end) {
		return findByYear(year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByYear(String year, int start, int end,
		OrderByComparator<Term> orderByComparator) {
		return findByYear(year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByYear(String year, int start, int end,
		OrderByComparator<Term> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year, start, end, orderByComparator };
		}

		List<Term> list = null;

		if (retrieveFromCache) {
			list = (List<Term>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Term term : list) {
					if (!Objects.equals(year, term.getYear())) {
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

			query.append(_SQL_SELECT_TERM_WHERE);

			boolean bindYear = false;

			if (year == null) {
				query.append(_FINDER_COLUMN_YEAR_YEAR_1);
			}
			else if (year.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_YEAR_YEAR_3);
			}
			else {
				bindYear = true;

				query.append(_FINDER_COLUMN_YEAR_YEAR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindYear) {
					qPos.add(year);
				}

				if (!pagination) {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByYear_First(String year,
		OrderByComparator<Term> orderByComparator) throws NoSuchTermException {
		Term term = fetchByYear_First(year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the first term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByYear_First(String year,
		OrderByComparator<Term> orderByComparator) {
		List<Term> list = findByYear(year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByYear_Last(String year,
		OrderByComparator<Term> orderByComparator) throws NoSuchTermException {
		Term term = fetchByYear_Last(year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the last term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByYear_Last(String year,
		OrderByComparator<Term> orderByComparator) {
		int count = countByYear(year);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByYear(year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where year = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term[] findByYear_PrevAndNext(long termId, String year,
		OrderByComparator<Term> orderByComparator) throws NoSuchTermException {
		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByYear_PrevAndNext(session, term, year,
					orderByComparator, true);

			array[1] = term;

			array[2] = getByYear_PrevAndNext(session, term, year,
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

	protected Term getByYear_PrevAndNext(Session session, Term term,
		String year, OrderByComparator<Term> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TERM_WHERE);

		boolean bindYear = false;

		if (year == null) {
			query.append(_FINDER_COLUMN_YEAR_YEAR_1);
		}
		else if (year.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_YEAR_YEAR_3);
		}
		else {
			bindYear = true;

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);
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
			query.append(TermModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindYear) {
			qPos.add(year);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(term);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Term> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	@Override
	public void removeByYear(String year) {
		for (Term term : findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching terms
	 */
	@Override
	public int countByYear(String year) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_YEAR;

		Object[] finderArgs = new Object[] { year };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TERM_WHERE);

			boolean bindYear = false;

			if (year == null) {
				query.append(_FINDER_COLUMN_YEAR_YEAR_1);
			}
			else if (year.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_YEAR_YEAR_3);
			}
			else {
				bindYear = true;

				query.append(_FINDER_COLUMN_YEAR_YEAR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindYear) {
					qPos.add(year);
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

	private static final String _FINDER_COLUMN_YEAR_YEAR_1 = "term.year IS NULL";
	private static final String _FINDER_COLUMN_YEAR_YEAR_2 = "term.year = ?";
	private static final String _FINDER_COLUMN_YEAR_YEAR_3 = "(term.year IS NULL OR term.year = '')";

	public TermPersistenceImpl() {
		setModelClass(Term.class);
	}

	/**
	 * Caches the term in the entity cache if it is enabled.
	 *
	 * @param term the term
	 */
	@Override
	public void cacheResult(Term term) {
		entityCache.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermImpl.class, term.getPrimaryKey(), term);

		term.resetOriginalValues();
	}

	/**
	 * Caches the terms in the entity cache if it is enabled.
	 *
	 * @param terms the terms
	 */
	@Override
	public void cacheResult(List<Term> terms) {
		for (Term term : terms) {
			if (entityCache.getResult(TermModelImpl.ENTITY_CACHE_ENABLED,
						TermImpl.class, term.getPrimaryKey()) == null) {
				cacheResult(term);
			}
			else {
				term.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all terms.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TermImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the term.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Term term) {
		entityCache.removeResult(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermImpl.class, term.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Term> terms) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Term term : terms) {
			entityCache.removeResult(TermModelImpl.ENTITY_CACHE_ENABLED,
				TermImpl.class, term.getPrimaryKey());
		}
	}

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	@Override
	public Term create(long termId) {
		Term term = new TermImpl();

		term.setNew(true);
		term.setPrimaryKey(termId);

		term.setCompanyId(companyProvider.getCompanyId());

		return term;
	}

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param termId the primary key of the term
	 * @return the term that was removed
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term remove(long termId) throws NoSuchTermException {
		return remove((Serializable)termId);
	}

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term that was removed
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term remove(Serializable primaryKey) throws NoSuchTermException {
		Session session = null;

		try {
			session = openSession();

			Term term = (Term)session.get(TermImpl.class, primaryKey);

			if (term == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTermException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(term);
		}
		catch (NoSuchTermException nsee) {
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
	protected Term removeImpl(Term term) {
		term = toUnwrappedModel(term);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(term)) {
				term = (Term)session.get(TermImpl.class, term.getPrimaryKeyObj());
			}

			if (term != null) {
				session.delete(term);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (term != null) {
			clearCache(term);
		}

		return term;
	}

	@Override
	public Term updateImpl(Term term) {
		term = toUnwrappedModel(term);

		boolean isNew = term.isNew();

		TermModelImpl termModelImpl = (TermModelImpl)term;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (term.getCreateDate() == null)) {
			if (serviceContext == null) {
				term.setCreateDate(now);
			}
			else {
				term.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!termModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				term.setModifiedDate(now);
			}
			else {
				term.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (term.isNew()) {
				session.save(term);

				term.setNew(false);
			}
			else {
				term = (Term)session.merge(term);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TermModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { termModelImpl.getPrefix() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PREFIX, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX,
				args);

			args = new Object[] { termModelImpl.getYear() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((termModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { termModelImpl.getOriginalPrefix() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PREFIX, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX,
					args);

				args = new Object[] { termModelImpl.getPrefix() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PREFIX, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX,
					args);
			}

			if ((termModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { termModelImpl.getOriginalYear() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);

				args = new Object[] { termModelImpl.getYear() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);
			}
		}

		entityCache.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermImpl.class, term.getPrimaryKey(), term, false);

		term.resetOriginalValues();

		return term;
	}

	protected Term toUnwrappedModel(Term term) {
		if (term instanceof TermImpl) {
			return term;
		}

		TermImpl termImpl = new TermImpl();

		termImpl.setNew(term.isNew());
		termImpl.setPrimaryKey(term.getPrimaryKey());

		termImpl.setTermId(term.getTermId());
		termImpl.setParentId(term.getParentId());
		termImpl.setLanguageId(term.getLanguageId());
		termImpl.setPrefix(term.getPrefix());
		termImpl.setYear(term.getYear());
		termImpl.setTranslation(term.getTranslation());
		termImpl.setGroupId(term.getGroupId());
		termImpl.setCompanyId(term.getCompanyId());
		termImpl.setUserId(term.getUserId());
		termImpl.setUserName(term.getUserName());
		termImpl.setCreateDate(term.getCreateDate());
		termImpl.setModifiedDate(term.getModifiedDate());

		return termImpl;
	}

	/**
	 * Returns the term with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTermException {
		Term term = fetchByPrimaryKey(primaryKey);

		if (term == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTermException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return term;
	}

	/**
	 * Returns the term with the primary key or throws a {@link NoSuchTermException} if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term findByPrimaryKey(long termId) throws NoSuchTermException {
		return findByPrimaryKey((Serializable)termId);
	}

	/**
	 * Returns the term with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term, or <code>null</code> if a term with the primary key could not be found
	 */
	@Override
	public Term fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TermModelImpl.ENTITY_CACHE_ENABLED,
				TermImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Term term = (Term)serializable;

		if (term == null) {
			Session session = null;

			try {
				session = openSession();

				term = (Term)session.get(TermImpl.class, primaryKey);

				if (term != null) {
					cacheResult(term);
				}
				else {
					entityCache.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
						TermImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TermModelImpl.ENTITY_CACHE_ENABLED,
					TermImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return term;
	}

	/**
	 * Returns the term with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term, or <code>null</code> if a term with the primary key could not be found
	 */
	@Override
	public Term fetchByPrimaryKey(long termId) {
		return fetchByPrimaryKey((Serializable)termId);
	}

	@Override
	public Map<Serializable, Term> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Term> map = new HashMap<Serializable, Term>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Term term = fetchByPrimaryKey(primaryKey);

			if (term != null) {
				map.put(primaryKey, term);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TermModelImpl.ENTITY_CACHE_ENABLED,
					TermImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Term)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TERM_WHERE_PKS_IN);

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

			for (Term term : (List<Term>)q.list()) {
				map.put(term.getPrimaryKeyObj(), term);

				cacheResult(term);

				uncachedPrimaryKeys.remove(term.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
					TermImpl.class, primaryKey, nullModel);
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
	 * Returns all the terms.
	 *
	 * @return the terms
	 */
	@Override
	public List<Term> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of terms
	 */
	@Override
	public List<Term> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of terms
	 */
	@Override
	public List<Term> findAll(int start, int end,
		OrderByComparator<Term> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of terms
	 */
	@Override
	public List<Term> findAll(int start, int end,
		OrderByComparator<Term> orderByComparator, boolean retrieveFromCache) {
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

		List<Term> list = null;

		if (retrieveFromCache) {
			list = (List<Term>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TERM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TERM;

				if (pagination) {
					sql = sql.concat(TermModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the terms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Term term : findAll()) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TERM);

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
		return TermModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the term persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TermImpl.class.getName());
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
	private static final String _SQL_SELECT_TERM = "SELECT term FROM Term term";
	private static final String _SQL_SELECT_TERM_WHERE_PKS_IN = "SELECT term FROM Term term WHERE termId IN (";
	private static final String _SQL_SELECT_TERM_WHERE = "SELECT term FROM Term term WHERE ";
	private static final String _SQL_COUNT_TERM = "SELECT COUNT(term) FROM Term term";
	private static final String _SQL_COUNT_TERM_WHERE = "SELECT COUNT(term) FROM Term term WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "term.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Term exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Term exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TermPersistenceImpl.class);
}