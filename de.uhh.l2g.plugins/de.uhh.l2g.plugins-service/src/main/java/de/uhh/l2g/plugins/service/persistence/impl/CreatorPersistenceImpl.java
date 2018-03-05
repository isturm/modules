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

import de.uhh.l2g.plugins.exception.NoSuchCreatorException;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.impl.CreatorImpl;
import de.uhh.l2g.plugins.model.impl.CreatorModelImpl;
import de.uhh.l2g.plugins.service.persistence.CreatorPersistence;

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
 * The persistence implementation for the creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CreatorPersistence
 * @see de.uhh.l2g.plugins.service.persistence.CreatorUtil
 * @generated
 */
@ProviderType
public class CreatorPersistenceImpl extends BasePersistenceImpl<Creator>
	implements CreatorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CreatorUtil} to access the creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CreatorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFirstName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFirstName",
			new String[] { String.class.getName() },
			CreatorModelImpl.FIRSTNAME_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFirstName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the creators where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByFirstName(String firstName) {
		return findByFirstName(firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Creator> findByFirstName(String firstName, int start, int end) {
		return findByFirstName(firstName, start, end, null);
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
	@Override
	public List<Creator> findByFirstName(String firstName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {
		return findByFirstName(firstName, start, end, orderByComparator, true);
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
	@Override
	public List<Creator> findByFirstName(String firstName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME;
			finderArgs = new Object[] { firstName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME;
			finderArgs = new Object[] { firstName, start, end, orderByComparator };
		}

		List<Creator> list = null;

		if (retrieveFromCache) {
			list = (List<Creator>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (!Objects.equals(firstName, creator.getFirstName())) {
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

			query.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByFirstName_First(String firstName,
		OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = fetchByFirstName_First(firstName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the first creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByFirstName_First(String firstName,
		OrderByComparator<Creator> orderByComparator) {
		List<Creator> list = findByFirstName(firstName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByFirstName_Last(String firstName,
		OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = fetchByFirstName_Last(firstName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the last creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByFirstName_Last(String firstName,
		OrderByComparator<Creator> orderByComparator) {
		int count = countByFirstName(firstName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByFirstName(firstName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Creator[] findByFirstName_PrevAndNext(long creatorId,
		String firstName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByFirstName_PrevAndNext(session, creator, firstName,
					orderByComparator, true);

			array[1] = creator;

			array[2] = getByFirstName_PrevAndNext(session, creator, firstName,
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

	protected Creator getByFirstName_PrevAndNext(Session session,
		Creator creator, String firstName,
		OrderByComparator<Creator> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
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
			query.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstName) {
			qPos.add(firstName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 */
	@Override
	public void removeByFirstName(String firstName) {
		for (Creator creator : findByFirstName(firstName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching creators
	 */
	@Override
	public int countByFirstName(String firstName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIRSTNAME;

		Object[] finderArgs = new Object[] { firstName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
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

	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1 = "creator.firstName IS NULL";
	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2 = "creator.firstName = ?";
	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3 = "(creator.firstName IS NULL OR creator.firstName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLastName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLastName",
			new String[] { String.class.getName() },
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLastName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the creators where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByLastName(String lastName) {
		return findByLastName(lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Creator> findByLastName(String lastName, int start, int end) {
		return findByLastName(lastName, start, end, null);
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
	@Override
	public List<Creator> findByLastName(String lastName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {
		return findByLastName(lastName, start, end, orderByComparator, true);
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
	@Override
	public List<Creator> findByLastName(String lastName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME;
			finderArgs = new Object[] { lastName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAME;
			finderArgs = new Object[] { lastName, start, end, orderByComparator };
		}

		List<Creator> list = null;

		if (retrieveFromCache) {
			list = (List<Creator>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (!Objects.equals(lastName, creator.getLastName())) {
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

			query.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByLastName_First(String lastName,
		OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = fetchByLastName_First(lastName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the first creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByLastName_First(String lastName,
		OrderByComparator<Creator> orderByComparator) {
		List<Creator> list = findByLastName(lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByLastName_Last(String lastName,
		OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = fetchByLastName_Last(lastName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the last creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByLastName_Last(String lastName,
		OrderByComparator<Creator> orderByComparator) {
		int count = countByLastName(lastName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByLastName(lastName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Creator[] findByLastName_PrevAndNext(long creatorId,
		String lastName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByLastName_PrevAndNext(session, creator, lastName,
					orderByComparator, true);

			array[1] = creator;

			array[2] = getByLastName_PrevAndNext(session, creator, lastName,
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

	protected Creator getByLastName_PrevAndNext(Session session,
		Creator creator, String lastName,
		OrderByComparator<Creator> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
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
			query.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLastName) {
			qPos.add(lastName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	@Override
	public void removeByLastName(String lastName) {
		for (Creator creator : findByLastName(lastName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching creators
	 */
	@Override
	public int countByLastName(String lastName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LASTNAME;

		Object[] finderArgs = new Object[] { lastName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
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

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_1 = "creator.lastName IS NULL";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_2 = "creator.lastName = ?";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_3 = "(creator.lastName IS NULL OR creator.lastName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MIDDLENAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMiddleName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMiddleName",
			new String[] { String.class.getName() },
			CreatorModelImpl.MIDDLENAME_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MIDDLENAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMiddleName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the creators where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByMiddleName(String middleName) {
		return findByMiddleName(middleName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Creator> findByMiddleName(String middleName, int start, int end) {
		return findByMiddleName(middleName, start, end, null);
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
	@Override
	public List<Creator> findByMiddleName(String middleName, int start,
		int end, OrderByComparator<Creator> orderByComparator) {
		return findByMiddleName(middleName, start, end, orderByComparator, true);
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
	@Override
	public List<Creator> findByMiddleName(String middleName, int start,
		int end, OrderByComparator<Creator> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME;
			finderArgs = new Object[] { middleName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MIDDLENAME;
			finderArgs = new Object[] { middleName, start, end, orderByComparator };
		}

		List<Creator> list = null;

		if (retrieveFromCache) {
			list = (List<Creator>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (!Objects.equals(middleName, creator.getMiddleName())) {
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

			query.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindMiddleName = false;

			if (middleName == null) {
				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_1);
			}
			else if (middleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
			}
			else {
				bindMiddleName = true;

				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMiddleName) {
					qPos.add(middleName);
				}

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByMiddleName_First(String middleName,
		OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = fetchByMiddleName_First(middleName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("middleName=");
		msg.append(middleName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the first creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByMiddleName_First(String middleName,
		OrderByComparator<Creator> orderByComparator) {
		List<Creator> list = findByMiddleName(middleName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByMiddleName_Last(String middleName,
		OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = fetchByMiddleName_Last(middleName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("middleName=");
		msg.append(middleName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the last creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByMiddleName_Last(String middleName,
		OrderByComparator<Creator> orderByComparator) {
		int count = countByMiddleName(middleName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByMiddleName(middleName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Creator[] findByMiddleName_PrevAndNext(long creatorId,
		String middleName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByMiddleName_PrevAndNext(session, creator,
					middleName, orderByComparator, true);

			array[1] = creator;

			array[2] = getByMiddleName_PrevAndNext(session, creator,
					middleName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByMiddleName_PrevAndNext(Session session,
		Creator creator, String middleName,
		OrderByComparator<Creator> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindMiddleName = false;

		if (middleName == null) {
			query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_1);
		}
		else if (middleName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
		}
		else {
			bindMiddleName = true;

			query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
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
			query.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMiddleName) {
			qPos.add(middleName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where middleName = &#63; from the database.
	 *
	 * @param middleName the middle name
	 */
	@Override
	public void removeByMiddleName(String middleName) {
		for (Creator creator : findByMiddleName(middleName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the number of matching creators
	 */
	@Override
	public int countByMiddleName(String middleName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MIDDLENAME;

		Object[] finderArgs = new Object[] { middleName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindMiddleName = false;

			if (middleName == null) {
				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_1);
			}
			else if (middleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
			}
			else {
				bindMiddleName = true;

				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMiddleName) {
					qPos.add(middleName);
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

	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_1 = "creator.middleName IS NULL";
	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2 = "creator.middleName = ?";
	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3 = "(creator.middleName IS NULL OR creator.middleName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FULLNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFullName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFullName",
			new String[] { String.class.getName() },
			CreatorModelImpl.FULLNAME_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FULLNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFullName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the creators where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByFullName(String fullName) {
		return findByFullName(fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Creator> findByFullName(String fullName, int start, int end) {
		return findByFullName(fullName, start, end, null);
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
	@Override
	public List<Creator> findByFullName(String fullName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {
		return findByFullName(fullName, start, end, orderByComparator, true);
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
	@Override
	public List<Creator> findByFullName(String fullName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME;
			finderArgs = new Object[] { fullName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FULLNAME;
			finderArgs = new Object[] { fullName, start, end, orderByComparator };
		}

		List<Creator> list = null;

		if (retrieveFromCache) {
			list = (List<Creator>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (!Objects.equals(fullName, creator.getFullName())) {
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

			query.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFullName) {
					qPos.add(fullName);
				}

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByFullName_First(String fullName,
		OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = fetchByFullName_First(fullName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fullName=");
		msg.append(fullName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the first creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByFullName_First(String fullName,
		OrderByComparator<Creator> orderByComparator) {
		List<Creator> list = findByFullName(fullName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByFullName_Last(String fullName,
		OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = fetchByFullName_Last(fullName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fullName=");
		msg.append(fullName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the last creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByFullName_Last(String fullName,
		OrderByComparator<Creator> orderByComparator) {
		int count = countByFullName(fullName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByFullName(fullName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Creator[] findByFullName_PrevAndNext(long creatorId,
		String fullName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {
		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByFullName_PrevAndNext(session, creator, fullName,
					orderByComparator, true);

			array[1] = creator;

			array[2] = getByFullName_PrevAndNext(session, creator, fullName,
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

	protected Creator getByFullName_PrevAndNext(Session session,
		Creator creator, String fullName,
		OrderByComparator<Creator> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
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
			query.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFullName) {
			qPos.add(fullName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where fullName = &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	@Override
	public void removeByFullName(String fullName) {
		for (Creator creator : findByFullName(fullName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching creators
	 */
	@Override
	public int countByFullName(String fullName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FULLNAME;

		Object[] finderArgs = new Object[] { fullName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFullName) {
					qPos.add(fullName);
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

	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_1 = "creator.fullName IS NULL";
	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_2 = "creator.fullName = ?";
	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_3 = "(creator.fullName IS NULL OR creator.fullName = '')";

	public CreatorPersistenceImpl() {
		setModelClass(Creator.class);
	}

	/**
	 * Caches the creator in the entity cache if it is enabled.
	 *
	 * @param creator the creator
	 */
	@Override
	public void cacheResult(Creator creator) {
		entityCache.putResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorImpl.class, creator.getPrimaryKey(), creator);

		creator.resetOriginalValues();
	}

	/**
	 * Caches the creators in the entity cache if it is enabled.
	 *
	 * @param creators the creators
	 */
	@Override
	public void cacheResult(List<Creator> creators) {
		for (Creator creator : creators) {
			if (entityCache.getResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
						CreatorImpl.class, creator.getPrimaryKey()) == null) {
				cacheResult(creator);
			}
			else {
				creator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all creators.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CreatorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the creator.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Creator creator) {
		entityCache.removeResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorImpl.class, creator.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Creator> creators) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Creator creator : creators) {
			entityCache.removeResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
				CreatorImpl.class, creator.getPrimaryKey());
		}
	}

	/**
	 * Creates a new creator with the primary key. Does not add the creator to the database.
	 *
	 * @param creatorId the primary key for the new creator
	 * @return the new creator
	 */
	@Override
	public Creator create(long creatorId) {
		Creator creator = new CreatorImpl();

		creator.setNew(true);
		creator.setPrimaryKey(creatorId);

		creator.setCompanyId(companyProvider.getCompanyId());

		return creator;
	}

	/**
	 * Removes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator that was removed
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator remove(long creatorId) throws NoSuchCreatorException {
		return remove((Serializable)creatorId);
	}

	/**
	 * Removes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the creator
	 * @return the creator that was removed
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator remove(Serializable primaryKey)
		throws NoSuchCreatorException {
		Session session = null;

		try {
			session = openSession();

			Creator creator = (Creator)session.get(CreatorImpl.class, primaryKey);

			if (creator == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(creator);
		}
		catch (NoSuchCreatorException nsee) {
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
	protected Creator removeImpl(Creator creator) {
		creator = toUnwrappedModel(creator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creator)) {
				creator = (Creator)session.get(CreatorImpl.class,
						creator.getPrimaryKeyObj());
			}

			if (creator != null) {
				session.delete(creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (creator != null) {
			clearCache(creator);
		}

		return creator;
	}

	@Override
	public Creator updateImpl(Creator creator) {
		creator = toUnwrappedModel(creator);

		boolean isNew = creator.isNew();

		CreatorModelImpl creatorModelImpl = (CreatorModelImpl)creator;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (creator.getCreateDate() == null)) {
			if (serviceContext == null) {
				creator.setCreateDate(now);
			}
			else {
				creator.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!creatorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				creator.setModifiedDate(now);
			}
			else {
				creator.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (creator.isNew()) {
				session.save(creator);

				creator.setNew(false);
			}
			else {
				creator = (Creator)session.merge(creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CreatorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { creatorModelImpl.getFirstName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME,
				args);

			args = new Object[] { creatorModelImpl.getLastName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
				args);

			args = new Object[] { creatorModelImpl.getMiddleName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MIDDLENAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME,
				args);

			args = new Object[] { creatorModelImpl.getFullName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FULLNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((creatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creatorModelImpl.getOriginalFirstName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME,
					args);

				args = new Object[] { creatorModelImpl.getFirstName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME,
					args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creatorModelImpl.getOriginalLastName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
					args);

				args = new Object[] { creatorModelImpl.getLastName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
					args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creatorModelImpl.getOriginalMiddleName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MIDDLENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME,
					args);

				args = new Object[] { creatorModelImpl.getMiddleName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MIDDLENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME,
					args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creatorModelImpl.getOriginalFullName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FULLNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME,
					args);

				args = new Object[] { creatorModelImpl.getFullName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FULLNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME,
					args);
			}
		}

		entityCache.putResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorImpl.class, creator.getPrimaryKey(), creator, false);

		creator.resetOriginalValues();

		return creator;
	}

	protected Creator toUnwrappedModel(Creator creator) {
		if (creator instanceof CreatorImpl) {
			return creator;
		}

		CreatorImpl creatorImpl = new CreatorImpl();

		creatorImpl.setNew(creator.isNew());
		creatorImpl.setPrimaryKey(creator.getPrimaryKey());

		creatorImpl.setCreatorId(creator.getCreatorId());
		creatorImpl.setFirstName(creator.getFirstName());
		creatorImpl.setLastName(creator.getLastName());
		creatorImpl.setMiddleName(creator.getMiddleName());
		creatorImpl.setJobTitle(creator.getJobTitle());
		creatorImpl.setGender(creator.getGender());
		creatorImpl.setFullName(creator.getFullName());
		creatorImpl.setGroupId(creator.getGroupId());
		creatorImpl.setCompanyId(creator.getCompanyId());
		creatorImpl.setUserId(creator.getUserId());
		creatorImpl.setUserName(creator.getUserName());
		creatorImpl.setCreateDate(creator.getCreateDate());
		creatorImpl.setModifiedDate(creator.getModifiedDate());

		return creatorImpl;
	}

	/**
	 * Returns the creator with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the creator
	 * @return the creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreatorException {
		Creator creator = fetchByPrimaryKey(primaryKey);

		if (creator == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return creator;
	}

	/**
	 * Returns the creator with the primary key or throws a {@link NoSuchCreatorException} if it could not be found.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator findByPrimaryKey(long creatorId)
		throws NoSuchCreatorException {
		return findByPrimaryKey((Serializable)creatorId);
	}

	/**
	 * Returns the creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the creator
	 * @return the creator, or <code>null</code> if a creator with the primary key could not be found
	 */
	@Override
	public Creator fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
				CreatorImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Creator creator = (Creator)serializable;

		if (creator == null) {
			Session session = null;

			try {
				session = openSession();

				creator = (Creator)session.get(CreatorImpl.class, primaryKey);

				if (creator != null) {
					cacheResult(creator);
				}
				else {
					entityCache.putResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
						CreatorImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
					CreatorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return creator;
	}

	/**
	 * Returns the creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator, or <code>null</code> if a creator with the primary key could not be found
	 */
	@Override
	public Creator fetchByPrimaryKey(long creatorId) {
		return fetchByPrimaryKey((Serializable)creatorId);
	}

	@Override
	public Map<Serializable, Creator> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Creator> map = new HashMap<Serializable, Creator>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Creator creator = fetchByPrimaryKey(primaryKey);

			if (creator != null) {
				map.put(primaryKey, creator);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
					CreatorImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Creator)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CREATOR_WHERE_PKS_IN);

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

			for (Creator creator : (List<Creator>)q.list()) {
				map.put(creator.getPrimaryKeyObj(), creator);

				cacheResult(creator);

				uncachedPrimaryKeys.remove(creator.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
					CreatorImpl.class, primaryKey, nullModel);
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
	 * Returns all the creators.
	 *
	 * @return the creators
	 */
	@Override
	public List<Creator> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Creator> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Creator> findAll(int start, int end,
		OrderByComparator<Creator> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Creator> findAll(int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean retrieveFromCache) {
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

		List<Creator> list = null;

		if (retrieveFromCache) {
			list = (List<Creator>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CREATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CREATOR;

				if (pagination) {
					sql = sql.concat(CreatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the creators from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Creator creator : findAll()) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators.
	 *
	 * @return the number of creators
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CREATOR);

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
		return CreatorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the creator persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CreatorImpl.class.getName());
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
	private static final String _SQL_SELECT_CREATOR = "SELECT creator FROM Creator creator";
	private static final String _SQL_SELECT_CREATOR_WHERE_PKS_IN = "SELECT creator FROM Creator creator WHERE creatorId IN (";
	private static final String _SQL_SELECT_CREATOR_WHERE = "SELECT creator FROM Creator creator WHERE ";
	private static final String _SQL_COUNT_CREATOR = "SELECT COUNT(creator) FROM Creator creator";
	private static final String _SQL_COUNT_CREATOR_WHERE = "SELECT COUNT(creator) FROM Creator creator WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "creator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Creator exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Creator exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CreatorPersistenceImpl.class);
}