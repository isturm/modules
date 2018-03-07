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

import de.uhh.l2g.plugins.exception.NoSuchHostException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.impl.HostImpl;
import de.uhh.l2g.plugins.model.impl.HostModelImpl;
import de.uhh.l2g.plugins.service.persistence.HostPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see HostPersistence
 * @see de.uhh.l2g.plugins.service.persistence.HostUtil
 * @generated
 */
@ProviderType
public class HostPersistenceImpl extends BasePersistenceImpl<Host>
	implements HostPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HostUtil} to access the host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			HostModelImpl.GROUPID_COLUMN_BITMASK |
			HostModelImpl.SERVERROOT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hosts
	 */
	@Override
	public List<Host> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	@Override
	public List<Host> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Host> list = null;

		if (retrieveFromCache) {
			list = (List<Host>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Host host : list) {
					if ((groupId != host.getGroupId())) {
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

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByGroupId_First(long groupId,
		OrderByComparator<Host> orderByComparator) throws NoSuchHostException {
		Host host = fetchByGroupId_First(groupId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the first host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByGroupId_First(long groupId,
		OrderByComparator<Host> orderByComparator) {
		List<Host> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByGroupId_Last(long groupId,
		OrderByComparator<Host> orderByComparator) throws NoSuchHostException {
		Host host = fetchByGroupId_Last(groupId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByGroupId_Last(long groupId,
		OrderByComparator<Host> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Host> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where groupId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host[] findByGroupId_PrevAndNext(long hostId, long groupId,
		OrderByComparator<Host> orderByComparator) throws NoSuchHostException {
		Host host = findByPrimaryKey(hostId);

		Session session = null;

		try {
			session = openSession();

			Host[] array = new HostImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, host, groupId,
					orderByComparator, true);

			array[1] = host;

			array[2] = getByGroupId_PrevAndNext(session, host, groupId,
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

	protected Host getByGroupId_PrevAndNext(Session session, Host host,
		long groupId, OrderByComparator<Host> orderByComparator,
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

		query.append(_SQL_SELECT_HOST_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(host);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hosts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Host host : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(host);
		}
	}

	/**
	 * Returns the number of hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "host.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
		new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
		new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			HostModelImpl.COMPANYID_COLUMN_BITMASK |
			HostModelImpl.GROUPID_COLUMN_BITMASK |
			HostModelImpl.SERVERROOT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching hosts
	 */
	@Override
	public List<Host> findByCompanyIdAndGroupId(long companyId, long groupId) {
		return findByCompanyIdAndGroupId(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyIdAndGroupId(long companyId, long groupId,
		int start, int end) {
		return findByCompanyIdAndGroupId(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyIdAndGroupId(long companyId, long groupId,
		int start, int end, OrderByComparator<Host> orderByComparator) {
		return findByCompanyIdAndGroupId(companyId, groupId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyIdAndGroupId(long companyId, long groupId,
		int start, int end, OrderByComparator<Host> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Host> list = null;

		if (retrieveFromCache) {
			list = (List<Host>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Host host : list) {
					if ((companyId != host.getCompanyId()) ||
							(groupId != host.getGroupId())) {
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

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HostModelImpl.ORDER_BY_JPQL);
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
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompanyIdAndGroupId_First(long companyId, long groupId,
		OrderByComparator<Host> orderByComparator) throws NoSuchHostException {
		Host host = fetchByCompanyIdAndGroupId_First(companyId, groupId,
				orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompanyIdAndGroupId_First(long companyId, long groupId,
		OrderByComparator<Host> orderByComparator) {
		List<Host> list = findByCompanyIdAndGroupId(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompanyIdAndGroupId_Last(long companyId, long groupId,
		OrderByComparator<Host> orderByComparator) throws NoSuchHostException {
		Host host = fetchByCompanyIdAndGroupId_Last(companyId, groupId,
				orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompanyIdAndGroupId_Last(long companyId, long groupId,
		OrderByComparator<Host> orderByComparator) {
		int count = countByCompanyIdAndGroupId(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Host> list = findByCompanyIdAndGroupId(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host[] findByCompanyIdAndGroupId_PrevAndNext(long hostId,
		long companyId, long groupId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {
		Host host = findByPrimaryKey(hostId);

		Session session = null;

		try {
			session = openSession();

			Host[] array = new HostImpl[3];

			array[0] = getByCompanyIdAndGroupId_PrevAndNext(session, host,
					companyId, groupId, orderByComparator, true);

			array[1] = host;

			array[2] = getByCompanyIdAndGroupId_PrevAndNext(session, host,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Host getByCompanyIdAndGroupId_PrevAndNext(Session session,
		Host host, long companyId, long groupId,
		OrderByComparator<Host> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_HOST_WHERE);

		query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

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
			query.append(HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(host);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hosts where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCompanyIdAndGroupId(long companyId, long groupId) {
		for (Host host : findByCompanyIdAndGroupId(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(host);
		}
	}

	/**
	 * Returns the number of hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByCompanyIdAndGroupId(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2 = "host.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2 = "host.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_H = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_H",
			new String[] { Long.class.getName(), Long.class.getName() },
			HostModelImpl.GROUPID_COLUMN_BITMASK |
			HostModelImpl.HOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_H = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_H",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or throws a {@link NoSuchHostException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByG_H(long groupId, long hostId) throws NoSuchHostException {
		Host host = fetchByG_H(groupId, hostId);

		if (host == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", hostId=");
			msg.append(hostId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchHostException(msg.toString());
		}

		return host;
	}

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByG_H(long groupId, long hostId) {
		return fetchByG_H(groupId, hostId, true);
	}

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByG_H(long groupId, long hostId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { groupId, hostId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_G_H,
					finderArgs, this);
		}

		if (result instanceof Host) {
			Host host = (Host)result;

			if ((groupId != host.getGroupId()) || (hostId != host.getHostId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_G_H_GROUPID_2);

			query.append(_FINDER_COLUMN_G_H_HOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(hostId);

				List<Host> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_G_H, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"HostPersistenceImpl.fetchByG_H(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Host host = list.get(0);

					result = host;

					cacheResult(host);

					if ((host.getGroupId() != groupId) ||
							(host.getHostId() != hostId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_G_H,
							finderArgs, host);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_G_H, finderArgs);

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
			return (Host)result;
		}
	}

	/**
	 * Removes the host where groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the host that was removed
	 */
	@Override
	public Host removeByG_H(long groupId, long hostId)
		throws NoSuchHostException {
		Host host = findByG_H(groupId, hostId);

		return remove(host);
	}

	/**
	 * Returns the number of hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByG_H(long groupId, long hostId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_H;

		Object[] finderArgs = new Object[] { groupId, hostId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_G_H_GROUPID_2);

			query.append(_FINDER_COLUMN_G_H_HOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(hostId);

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

	private static final String _FINDER_COLUMN_G_H_GROUPID_2 = "host.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_H_HOSTID_2 = "host.hostId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_DEFAULTHOST = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDefaultHost",
			new String[] { Long.class.getName(), Long.class.getName() },
			HostModelImpl.COMPANYID_COLUMN_BITMASK |
			HostModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEFAULTHOST = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDefaultHost",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or throws a {@link NoSuchHostException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByDefaultHost(long companyId, long groupId)
		throws NoSuchHostException {
		Host host = fetchByDefaultHost(companyId, groupId);

		if (host == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchHostException(msg.toString());
		}

		return host;
	}

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByDefaultHost(long companyId, long groupId) {
		return fetchByDefaultHost(companyId, groupId, true);
	}

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByDefaultHost(long companyId, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_DEFAULTHOST,
					finderArgs, this);
		}

		if (result instanceof Host) {
			Host host = (Host)result;

			if ((companyId != host.getCompanyId()) ||
					(groupId != host.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_DEFAULTHOST_COMPANYID_2);

			query.append(_FINDER_COLUMN_DEFAULTHOST_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				List<Host> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_DEFAULTHOST,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"HostPersistenceImpl.fetchByDefaultHost(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Host host = list.get(0);

					result = host;

					cacheResult(host);

					if ((host.getCompanyId() != companyId) ||
							(host.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_DEFAULTHOST,
							finderArgs, host);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_DEFAULTHOST,
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
			return (Host)result;
		}
	}

	/**
	 * Removes the host where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the host that was removed
	 */
	@Override
	public Host removeByDefaultHost(long companyId, long groupId)
		throws NoSuchHostException {
		Host host = findByDefaultHost(companyId, groupId);

		return remove(host);
	}

	/**
	 * Returns the number of hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByDefaultHost(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEFAULTHOST;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_DEFAULTHOST_COMPANYID_2);

			query.append(_FINDER_COLUMN_DEFAULTHOST_GROUPID_2);

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

	private static final String _FINDER_COLUMN_DEFAULTHOST_COMPANYID_2 = "host.companyId = ? AND ";
	private static final String _FINDER_COLUMN_DEFAULTHOST_GROUPID_2 = "host.groupId = ? AND host.defaultHost > 0";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			HostModelImpl.COMPANYID_COLUMN_BITMASK |
			HostModelImpl.SERVERROOT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	@Override
	public List<Host> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyId(long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator) {
		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyId(long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Host> list = null;

		if (retrieveFromCache) {
			list = (List<Host>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Host host : list) {
					if ((companyId != host.getCompanyId())) {
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

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompanyId_First(long companyId,
		OrderByComparator<Host> orderByComparator) throws NoSuchHostException {
		Host host = fetchByCompanyId_First(companyId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompanyId_First(long companyId,
		OrderByComparator<Host> orderByComparator) {
		List<Host> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompanyId_Last(long companyId,
		OrderByComparator<Host> orderByComparator) throws NoSuchHostException {
		Host host = fetchByCompanyId_Last(companyId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompanyId_Last(long companyId,
		OrderByComparator<Host> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Host> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host[] findByCompanyId_PrevAndNext(long hostId, long companyId,
		OrderByComparator<Host> orderByComparator) throws NoSuchHostException {
		Host host = findByPrimaryKey(hostId);

		Session session = null;

		try {
			session = openSession();

			Host[] array = new HostImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, host, companyId,
					orderByComparator, true);

			array[1] = host;

			array[2] = getByCompanyId_PrevAndNext(session, host, companyId,
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

	protected Host getByCompanyId_PrevAndNext(Session session, Host host,
		long companyId, OrderByComparator<Host> orderByComparator,
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

		query.append(_SQL_SELECT_HOST_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(host);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hosts where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (Host host : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(host);
		}
	}

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "host.companyId = ?";

	public HostPersistenceImpl() {
		setModelClass(Host.class);
	}

	/**
	 * Caches the host in the entity cache if it is enabled.
	 *
	 * @param host the host
	 */
	@Override
	public void cacheResult(Host host) {
		entityCache.putResult(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostImpl.class, host.getPrimaryKey(), host);

		finderCache.putResult(FINDER_PATH_FETCH_BY_G_H,
			new Object[] { host.getGroupId(), host.getHostId() }, host);

		finderCache.putResult(FINDER_PATH_FETCH_BY_DEFAULTHOST,
			new Object[] { host.getCompanyId(), host.getGroupId() }, host);

		host.resetOriginalValues();
	}

	/**
	 * Caches the hosts in the entity cache if it is enabled.
	 *
	 * @param hosts the hosts
	 */
	@Override
	public void cacheResult(List<Host> hosts) {
		for (Host host : hosts) {
			if (entityCache.getResult(HostModelImpl.ENTITY_CACHE_ENABLED,
						HostImpl.class, host.getPrimaryKey()) == null) {
				cacheResult(host);
			}
			else {
				host.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hosts.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HostImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the host.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Host host) {
		entityCache.removeResult(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostImpl.class, host.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((HostModelImpl)host, true);
	}

	@Override
	public void clearCache(List<Host> hosts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Host host : hosts) {
			entityCache.removeResult(HostModelImpl.ENTITY_CACHE_ENABLED,
				HostImpl.class, host.getPrimaryKey());

			clearUniqueFindersCache((HostModelImpl)host, true);
		}
	}

	protected void cacheUniqueFindersCache(HostModelImpl hostModelImpl) {
		Object[] args = new Object[] {
				hostModelImpl.getGroupId(), hostModelImpl.getHostId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_G_H, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_G_H, args, hostModelImpl,
			false);

		args = new Object[] {
				hostModelImpl.getCompanyId(), hostModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_DEFAULTHOST, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_DEFAULTHOST, args,
			hostModelImpl, false);
	}

	protected void clearUniqueFindersCache(HostModelImpl hostModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					hostModelImpl.getGroupId(), hostModelImpl.getHostId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_H, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_G_H, args);
		}

		if ((hostModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_H.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					hostModelImpl.getOriginalGroupId(),
					hostModelImpl.getOriginalHostId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_H, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_G_H, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					hostModelImpl.getCompanyId(), hostModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DEFAULTHOST, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DEFAULTHOST, args);
		}

		if ((hostModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DEFAULTHOST.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					hostModelImpl.getOriginalCompanyId(),
					hostModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DEFAULTHOST, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DEFAULTHOST, args);
		}
	}

	/**
	 * Creates a new host with the primary key. Does not add the host to the database.
	 *
	 * @param hostId the primary key for the new host
	 * @return the new host
	 */
	@Override
	public Host create(long hostId) {
		Host host = new HostImpl();

		host.setNew(true);
		host.setPrimaryKey(hostId);

		host.setCompanyId(companyProvider.getCompanyId());

		return host;
	}

	/**
	 * Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hostId the primary key of the host
	 * @return the host that was removed
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host remove(long hostId) throws NoSuchHostException {
		return remove((Serializable)hostId);
	}

	/**
	 * Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the host
	 * @return the host that was removed
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host remove(Serializable primaryKey) throws NoSuchHostException {
		Session session = null;

		try {
			session = openSession();

			Host host = (Host)session.get(HostImpl.class, primaryKey);

			if (host == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(host);
		}
		catch (NoSuchHostException nsee) {
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
	protected Host removeImpl(Host host) {
		host = toUnwrappedModel(host);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(host)) {
				host = (Host)session.get(HostImpl.class, host.getPrimaryKeyObj());
			}

			if (host != null) {
				session.delete(host);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (host != null) {
			clearCache(host);
		}

		return host;
	}

	@Override
	public Host updateImpl(Host host) {
		host = toUnwrappedModel(host);

		boolean isNew = host.isNew();

		HostModelImpl hostModelImpl = (HostModelImpl)host;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (host.getCreateDate() == null)) {
			if (serviceContext == null) {
				host.setCreateDate(now);
			}
			else {
				host.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!hostModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				host.setModifiedDate(now);
			}
			else {
				host.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (host.isNew()) {
				session.save(host);

				host.setNew(false);
			}
			else {
				host = (Host)session.merge(host);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!HostModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { hostModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] {
					hostModelImpl.getCompanyId(), hostModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
				args);

			args = new Object[] { hostModelImpl.getCompanyId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((hostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { hostModelImpl.getOriginalGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { hostModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((hostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hostModelImpl.getOriginalCompanyId(),
						hostModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
					args);

				args = new Object[] {
						hostModelImpl.getCompanyId(), hostModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
					args);
			}

			if ((hostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hostModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { hostModelImpl.getCompanyId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		entityCache.putResult(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostImpl.class, host.getPrimaryKey(), host, false);

		clearUniqueFindersCache(hostModelImpl, false);
		cacheUniqueFindersCache(hostModelImpl);

		host.resetOriginalValues();

		return host;
	}

	protected Host toUnwrappedModel(Host host) {
		if (host instanceof HostImpl) {
			return host;
		}

		HostImpl hostImpl = new HostImpl();

		hostImpl.setNew(host.isNew());
		hostImpl.setPrimaryKey(host.getPrimaryKey());

		hostImpl.setHostId(host.getHostId());
		hostImpl.setProtocol(host.getProtocol());
		hostImpl.setStreamer(host.getStreamer());
		hostImpl.setPort(host.getPort());
		hostImpl.setServerRoot(host.getServerRoot());
		hostImpl.setName(host.getName());
		hostImpl.setDefaultHost(host.getDefaultHost());
		hostImpl.setGroupId(host.getGroupId());
		hostImpl.setCompanyId(host.getCompanyId());
		hostImpl.setUserId(host.getUserId());
		hostImpl.setUserName(host.getUserName());
		hostImpl.setCreateDate(host.getCreateDate());
		hostImpl.setModifiedDate(host.getModifiedDate());

		return hostImpl;
	}

	/**
	 * Returns the host with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the host
	 * @return the host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHostException {
		Host host = fetchByPrimaryKey(primaryKey);

		if (host == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return host;
	}

	/**
	 * Returns the host with the primary key or throws a {@link NoSuchHostException} if it could not be found.
	 *
	 * @param hostId the primary key of the host
	 * @return the host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host findByPrimaryKey(long hostId) throws NoSuchHostException {
		return findByPrimaryKey((Serializable)hostId);
	}

	/**
	 * Returns the host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the host
	 * @return the host, or <code>null</code> if a host with the primary key could not be found
	 */
	@Override
	public Host fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(HostModelImpl.ENTITY_CACHE_ENABLED,
				HostImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Host host = (Host)serializable;

		if (host == null) {
			Session session = null;

			try {
				session = openSession();

				host = (Host)session.get(HostImpl.class, primaryKey);

				if (host != null) {
					cacheResult(host);
				}
				else {
					entityCache.putResult(HostModelImpl.ENTITY_CACHE_ENABLED,
						HostImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(HostModelImpl.ENTITY_CACHE_ENABLED,
					HostImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return host;
	}

	/**
	 * Returns the host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hostId the primary key of the host
	 * @return the host, or <code>null</code> if a host with the primary key could not be found
	 */
	@Override
	public Host fetchByPrimaryKey(long hostId) {
		return fetchByPrimaryKey((Serializable)hostId);
	}

	@Override
	public Map<Serializable, Host> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Host> map = new HashMap<Serializable, Host>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Host host = fetchByPrimaryKey(primaryKey);

			if (host != null) {
				map.put(primaryKey, host);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(HostModelImpl.ENTITY_CACHE_ENABLED,
					HostImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Host)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_HOST_WHERE_PKS_IN);

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

			for (Host host : (List<Host>)q.list()) {
				map.put(host.getPrimaryKeyObj(), host);

				cacheResult(host);

				uncachedPrimaryKeys.remove(host.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(HostModelImpl.ENTITY_CACHE_ENABLED,
					HostImpl.class, primaryKey, nullModel);
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
	 * Returns all the hosts.
	 *
	 * @return the hosts
	 */
	@Override
	public List<Host> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of hosts
	 */
	@Override
	public List<Host> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hosts
	 */
	@Override
	public List<Host> findAll(int start, int end,
		OrderByComparator<Host> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of hosts
	 */
	@Override
	public List<Host> findAll(int start, int end,
		OrderByComparator<Host> orderByComparator, boolean retrieveFromCache) {
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

		List<Host> list = null;

		if (retrieveFromCache) {
			list = (List<Host>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_HOST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOST;

				if (pagination) {
					sql = sql.concat(HostModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the hosts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Host host : findAll()) {
			remove(host);
		}
	}

	/**
	 * Returns the number of hosts.
	 *
	 * @return the number of hosts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOST);

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
		return HostModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the host persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(HostImpl.class.getName());
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
	private static final String _SQL_SELECT_HOST = "SELECT host FROM Host host";
	private static final String _SQL_SELECT_HOST_WHERE_PKS_IN = "SELECT host FROM Host host WHERE hostId IN (";
	private static final String _SQL_SELECT_HOST_WHERE = "SELECT host FROM Host host WHERE ";
	private static final String _SQL_COUNT_HOST = "SELECT COUNT(host) FROM Host host";
	private static final String _SQL_COUNT_HOST_WHERE = "SELECT COUNT(host) FROM Host host WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "host.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Host exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Host exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(HostPersistenceImpl.class);
}