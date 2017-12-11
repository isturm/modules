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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import aQute.bnd.annotation.ProviderType;
import de.uhh.l2g.plugins.exception.NoSuchProducerException;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.model.impl.ProducerModelImpl;
import de.uhh.l2g.plugins.service.persistence.ProducerPersistence;

/**
 * The persistence implementation for the producer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ProducerPersistence
 * @see de.uhh.l2g.plugins.service.persistence.ProducerUtil
 * @generated
 */
@ProviderType
public class ProducerPersistenceImpl extends BasePersistenceImpl<Producer>
	implements ProducerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProducerUtil} to access the producer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProducerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HOST = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHost",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHost",
			new String[] { Long.class.getName() },
			ProducerModelImpl.HOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOST = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHost",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the producers where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the matching producers
	 */
	@Override
	public List<Producer> findByHost(long hostId) {
		return findByHost(hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	@Override
	public List<Producer> findByHost(long hostId, int start, int end) {
		return findByHost(hostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	@Override
	public List<Producer> findByHost(long hostId, int start, int end,
		OrderByComparator<Producer> orderByComparator) {
		return findByHost(hostId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching producers
	 */
	@Override
	public List<Producer> findByHost(long hostId, int start, int end,
		OrderByComparator<Producer> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST;
			finderArgs = new Object[] { hostId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HOST;
			finderArgs = new Object[] { hostId, start, end, orderByComparator };
		}

		List<Producer> list = null;

		if (retrieveFromCache) {
			list = (List<Producer>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Producer producer : list) {
					if ((hostId != producer.getHostId())) {
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

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_HOST_HOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProducerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hostId);

				if (!pagination) {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	@Override
	public Producer findByHost_First(long hostId,
		OrderByComparator<Producer> orderByComparator)
		throws NoSuchProducerException {
		Producer producer = fetchByHost_First(hostId, orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hostId=");
		msg.append(hostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the first producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByHost_First(long hostId,
		OrderByComparator<Producer> orderByComparator) {
		List<Producer> list = findByHost(hostId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	@Override
	public Producer findByHost_Last(long hostId,
		OrderByComparator<Producer> orderByComparator)
		throws NoSuchProducerException {
		Producer producer = fetchByHost_Last(hostId, orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hostId=");
		msg.append(hostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the last producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByHost_Last(long hostId,
		OrderByComparator<Producer> orderByComparator) {
		int count = countByHost(hostId);

		if (count == 0) {
			return null;
		}

		List<Producer> list = findByHost(hostId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where hostId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	@Override
	public Producer[] findByHost_PrevAndNext(long producerId, long hostId,
		OrderByComparator<Producer> orderByComparator)
		throws NoSuchProducerException {
		Producer producer = findByPrimaryKey(producerId);

		Session session = null;

		try {
			session = openSession();

			Producer[] array = new ProducerImpl[3];

			array[0] = getByHost_PrevAndNext(session, producer, hostId,
					orderByComparator, true);

			array[1] = producer;

			array[2] = getByHost_PrevAndNext(session, producer, hostId,
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

	protected Producer getByHost_PrevAndNext(Session session,
		Producer producer, long hostId,
		OrderByComparator<Producer> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_WHERE);

		query.append(_FINDER_COLUMN_HOST_HOSTID_2);

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
			query.append(ProducerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hostId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(producer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Producer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producers where hostId = &#63; from the database.
	 *
	 * @param hostId the host ID
	 */
	@Override
	public void removeByHost(long hostId) {
		for (Producer producer : findByHost(hostId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(producer);
		}
	}

	/**
	 * Returns the number of producers where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the number of matching producers
	 */
	@Override
	public int countByHost(long hostId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HOST;

		Object[] finderArgs = new Object[] { hostId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_HOST_HOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_HOST_HOSTID_2 = "producer.hostId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTION =
		new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInstitution",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION =
		new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstitution",
			new String[] { Long.class.getName() },
			ProducerModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTION = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstitution",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the producers where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching producers
	 */
	@Override
	public List<Producer> findByInstitution(long institutionId) {
		return findByInstitution(institutionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	@Override
	public List<Producer> findByInstitution(long institutionId, int start,
		int end) {
		return findByInstitution(institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	@Override
	public List<Producer> findByInstitution(long institutionId, int start,
		int end, OrderByComparator<Producer> orderByComparator) {
		return findByInstitution(institutionId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching producers
	 */
	@Override
	public List<Producer> findByInstitution(long institutionId, int start,
		int end, OrderByComparator<Producer> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION;
			finderArgs = new Object[] { institutionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTION;
			finderArgs = new Object[] {
					institutionId,
					
					start, end, orderByComparator
				};
		}

		List<Producer> list = null;

		if (retrieveFromCache) {
			list = (List<Producer>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Producer producer : list) {
					if ((institutionId != producer.getInstitutionId())) {
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

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProducerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				if (!pagination) {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	@Override
	public Producer findByInstitution_First(long institutionId,
		OrderByComparator<Producer> orderByComparator)
		throws NoSuchProducerException {
		Producer producer = fetchByInstitution_First(institutionId,
				orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the first producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByInstitution_First(long institutionId,
		OrderByComparator<Producer> orderByComparator) {
		List<Producer> list = findByInstitution(institutionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	@Override
	public Producer findByInstitution_Last(long institutionId,
		OrderByComparator<Producer> orderByComparator)
		throws NoSuchProducerException {
		Producer producer = fetchByInstitution_Last(institutionId,
				orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the last producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByInstitution_Last(long institutionId,
		OrderByComparator<Producer> orderByComparator) {
		int count = countByInstitution(institutionId);

		if (count == 0) {
			return null;
		}

		List<Producer> list = findByInstitution(institutionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where institutionId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	@Override
	public Producer[] findByInstitution_PrevAndNext(long producerId,
		long institutionId, OrderByComparator<Producer> orderByComparator)
		throws NoSuchProducerException {
		Producer producer = findByPrimaryKey(producerId);

		Session session = null;

		try {
			session = openSession();

			Producer[] array = new ProducerImpl[3];

			array[0] = getByInstitution_PrevAndNext(session, producer,
					institutionId, orderByComparator, true);

			array[1] = producer;

			array[2] = getByInstitution_PrevAndNext(session, producer,
					institutionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Producer getByInstitution_PrevAndNext(Session session,
		Producer producer, long institutionId,
		OrderByComparator<Producer> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_WHERE);

		query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

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
			query.append(ProducerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(institutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(producer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Producer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producers where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	@Override
	public void removeByInstitution(long institutionId) {
		for (Producer producer : findByInstitution(institutionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(producer);
		}
	}

	/**
	 * Returns the number of producers where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching producers
	 */
	@Override
	public int countByInstitution(long institutionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTION;

		Object[] finderArgs = new Object[] { institutionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_WHERE);

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

	private static final String _FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2 = "producer.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ProducerModelImpl.APPROVED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the producers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the matching producers
	 */
	@Override
	public List<Producer> findByStatus(int approved) {
		return findByStatus(approved, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	@Override
	public List<Producer> findByStatus(int approved, int start, int end) {
		return findByStatus(approved, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	@Override
	public List<Producer> findByStatus(int approved, int start, int end,
		OrderByComparator<Producer> orderByComparator) {
		return findByStatus(approved, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching producers
	 */
	@Override
	public List<Producer> findByStatus(int approved, int start, int end,
		OrderByComparator<Producer> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { approved };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { approved, start, end, orderByComparator };
		}

		List<Producer> list = null;

		if (retrieveFromCache) {
			list = (List<Producer>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Producer producer : list) {
					if ((approved != producer.getApproved())) {
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

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_APPROVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProducerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved);

				if (!pagination) {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	@Override
	public Producer findByStatus_First(int approved,
		OrderByComparator<Producer> orderByComparator)
		throws NoSuchProducerException {
		Producer producer = fetchByStatus_First(approved, orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approved=");
		msg.append(approved);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the first producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByStatus_First(int approved,
		OrderByComparator<Producer> orderByComparator) {
		List<Producer> list = findByStatus(approved, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	@Override
	public Producer findByStatus_Last(int approved,
		OrderByComparator<Producer> orderByComparator)
		throws NoSuchProducerException {
		Producer producer = fetchByStatus_Last(approved, orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approved=");
		msg.append(approved);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the last producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByStatus_Last(int approved,
		OrderByComparator<Producer> orderByComparator) {
		int count = countByStatus(approved);

		if (count == 0) {
			return null;
		}

		List<Producer> list = findByStatus(approved, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where approved = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	@Override
	public Producer[] findByStatus_PrevAndNext(long producerId, int approved,
		OrderByComparator<Producer> orderByComparator)
		throws NoSuchProducerException {
		Producer producer = findByPrimaryKey(producerId);

		Session session = null;

		try {
			session = openSession();

			Producer[] array = new ProducerImpl[3];

			array[0] = getByStatus_PrevAndNext(session, producer, approved,
					orderByComparator, true);

			array[1] = producer;

			array[2] = getByStatus_PrevAndNext(session, producer, approved,
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

	protected Producer getByStatus_PrevAndNext(Session session,
		Producer producer, int approved,
		OrderByComparator<Producer> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_WHERE);

		query.append(_FINDER_COLUMN_STATUS_APPROVED_2);

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
			query.append(ProducerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(approved);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(producer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Producer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producers where approved = &#63; from the database.
	 *
	 * @param approved the approved
	 */
	@Override
	public void removeByStatus(int approved) {
		for (Producer producer : findByStatus(approved, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(producer);
		}
	}

	/**
	 * Returns the number of producers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the number of matching producers
	 */
	@Override
	public int countByStatus(int approved) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { approved };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_APPROVED_2);

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

	private static final String _FINDER_COLUMN_STATUS_APPROVED_2 = "producer.approved = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_DIRECTORY = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDirectory",
			new String[] { String.class.getName() },
			ProducerModelImpl.HOMEDIR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIRECTORY = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDirectory",
			new String[] { String.class.getName() });

	/**
	 * Returns the producer where homeDir = &#63; or throws a {@link NoSuchProducerException} if it could not be found.
	 *
	 * @param homeDir the home dir
	 * @return the matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	@Override
	public Producer findByDirectory(String homeDir)
		throws NoSuchProducerException {
		Producer producer = fetchByDirectory(homeDir);

		if (producer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("homeDir=");
			msg.append(homeDir);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProducerException(msg.toString());
		}

		return producer;
	}

	/**
	 * Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param homeDir the home dir
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByDirectory(String homeDir) {
		return fetchByDirectory(homeDir, true);
	}

	/**
	 * Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param homeDir the home dir
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByDirectory(String homeDir, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { homeDir };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_DIRECTORY,
					finderArgs, this);
		}

		if (result instanceof Producer) {
			Producer producer = (Producer)result;

			if (!Objects.equals(homeDir, producer.getHomeDir())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			boolean bindHomeDir = false;

			if (homeDir == null) {
				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_1);
			}
			else if (homeDir.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_3);
			}
			else {
				bindHomeDir = true;

				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHomeDir) {
					qPos.add(homeDir);
				}

				List<Producer> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_DIRECTORY,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProducerPersistenceImpl.fetchByDirectory(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Producer producer = list.get(0);

					result = producer;

					cacheResult(producer);

					if ((producer.getHomeDir() == null) ||
							!producer.getHomeDir().equals(homeDir)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_DIRECTORY,
							finderArgs, producer);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_DIRECTORY,
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
			return (Producer)result;
		}
	}

	/**
	 * Removes the producer where homeDir = &#63; from the database.
	 *
	 * @param homeDir the home dir
	 * @return the producer that was removed
	 */
	@Override
	public Producer removeByDirectory(String homeDir)
		throws NoSuchProducerException {
		Producer producer = findByDirectory(homeDir);

		return remove(producer);
	}

	/**
	 * Returns the number of producers where homeDir = &#63;.
	 *
	 * @param homeDir the home dir
	 * @return the number of matching producers
	 */
	@Override
	public int countByDirectory(String homeDir) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIRECTORY;

		Object[] finderArgs = new Object[] { homeDir };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_WHERE);

			boolean bindHomeDir = false;

			if (homeDir == null) {
				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_1);
			}
			else if (homeDir.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_3);
			}
			else {
				bindHomeDir = true;

				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHomeDir) {
					qPos.add(homeDir);
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

	private static final String _FINDER_COLUMN_DIRECTORY_HOMEDIR_1 = "producer.homeDir IS NULL";
	private static final String _FINDER_COLUMN_DIRECTORY_HOMEDIR_2 = "producer.homeDir = ?";
	private static final String _FINDER_COLUMN_DIRECTORY_HOMEDIR_3 = "(producer.homeDir IS NULL OR producer.homeDir = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UID = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUID",
			new String[] { String.class.getName() },
			ProducerModelImpl.IDNUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UID = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUID",
			new String[] { String.class.getName() });

	/**
	 * Returns the producer where idNum = &#63; or throws a {@link NoSuchProducerException} if it could not be found.
	 *
	 * @param idNum the id num
	 * @return the matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	@Override
	public Producer findByUID(String idNum) throws NoSuchProducerException {
		Producer producer = fetchByUID(idNum);

		if (producer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("idNum=");
			msg.append(idNum);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProducerException(msg.toString());
		}

		return producer;
	}

	/**
	 * Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idNum the id num
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByUID(String idNum) {
		return fetchByUID(idNum, true);
	}

	/**
	 * Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idNum the id num
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Override
	public Producer fetchByUID(String idNum, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { idNum };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UID,
					finderArgs, this);
		}

		if (result instanceof Producer) {
			Producer producer = (Producer)result;

			if (!Objects.equals(idNum, producer.getIdNum())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			boolean bindIdNum = false;

			if (idNum == null) {
				query.append(_FINDER_COLUMN_UID_IDNUM_1);
			}
			else if (idNum.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UID_IDNUM_3);
			}
			else {
				bindIdNum = true;

				query.append(_FINDER_COLUMN_UID_IDNUM_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdNum) {
					qPos.add(idNum);
				}

				List<Producer> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UID, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProducerPersistenceImpl.fetchByUID(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Producer producer = list.get(0);

					result = producer;

					cacheResult(producer);

					if ((producer.getIdNum() == null) ||
							!producer.getIdNum().equals(idNum)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UID,
							finderArgs, producer);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UID, finderArgs);

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
			return (Producer)result;
		}
	}

	/**
	 * Removes the producer where idNum = &#63; from the database.
	 *
	 * @param idNum the id num
	 * @return the producer that was removed
	 */
	@Override
	public Producer removeByUID(String idNum) throws NoSuchProducerException {
		Producer producer = findByUID(idNum);

		return remove(producer);
	}

	/**
	 * Returns the number of producers where idNum = &#63;.
	 *
	 * @param idNum the id num
	 * @return the number of matching producers
	 */
	@Override
	public int countByUID(String idNum) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UID;

		Object[] finderArgs = new Object[] { idNum };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_WHERE);

			boolean bindIdNum = false;

			if (idNum == null) {
				query.append(_FINDER_COLUMN_UID_IDNUM_1);
			}
			else if (idNum.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UID_IDNUM_3);
			}
			else {
				bindIdNum = true;

				query.append(_FINDER_COLUMN_UID_IDNUM_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdNum) {
					qPos.add(idNum);
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

	private static final String _FINDER_COLUMN_UID_IDNUM_1 = "producer.idNum IS NULL";
	private static final String _FINDER_COLUMN_UID_IDNUM_2 = "producer.idNum = ?";
	private static final String _FINDER_COLUMN_UID_IDNUM_3 = "(producer.idNum IS NULL OR producer.idNum = '')";

	public ProducerPersistenceImpl() {
		setModelClass(Producer.class);
	}

	/**
	 * Caches the producer in the entity cache if it is enabled.
	 *
	 * @param producer the producer
	 */
	@Override
	public void cacheResult(Producer producer) {
		entityCache.putResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerImpl.class, producer.getPrimaryKey(), producer);

		finderCache.putResult(FINDER_PATH_FETCH_BY_DIRECTORY,
			new Object[] { producer.getHomeDir() }, producer);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UID,
			new Object[] { producer.getIdNum() }, producer);

		producer.resetOriginalValues();
	}

	/**
	 * Caches the producers in the entity cache if it is enabled.
	 *
	 * @param producers the producers
	 */
	@Override
	public void cacheResult(List<Producer> producers) {
		for (Producer producer : producers) {
			if (entityCache.getResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
						ProducerImpl.class, producer.getPrimaryKey()) == null) {
				cacheResult(producer);
			}
			else {
				producer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all producers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProducerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the producer.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Producer producer) {
		entityCache.removeResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerImpl.class, producer.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProducerModelImpl)producer, true);
	}

	@Override
	public void clearCache(List<Producer> producers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Producer producer : producers) {
			entityCache.removeResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
				ProducerImpl.class, producer.getPrimaryKey());

			clearUniqueFindersCache((ProducerModelImpl)producer, true);
		}
	}

	protected void cacheUniqueFindersCache(ProducerModelImpl producerModelImpl) {
		Object[] args = new Object[] { producerModelImpl.getHomeDir() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_DIRECTORY, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_DIRECTORY, args,
			producerModelImpl, false);

		args = new Object[] { producerModelImpl.getIdNum() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_UID, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UID, args,
			producerModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ProducerModelImpl producerModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { producerModelImpl.getHomeDir() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DIRECTORY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DIRECTORY, args);
		}

		if ((producerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DIRECTORY.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { producerModelImpl.getOriginalHomeDir() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DIRECTORY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DIRECTORY, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { producerModelImpl.getIdNum() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UID, args);
		}

		if ((producerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { producerModelImpl.getOriginalIdNum() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UID, args);
		}
	}

	/**
	 * Creates a new producer with the primary key. Does not add the producer to the database.
	 *
	 * @param producerId the primary key for the new producer
	 * @return the new producer
	 */
	@Override
	public Producer create(long producerId) {
		Producer producer = new ProducerImpl();

		producer.setNew(true);
		producer.setPrimaryKey(producerId);

		return producer;
	}

	/**
	 * Removes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer that was removed
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	@Override
	public Producer remove(long producerId) throws NoSuchProducerException {
		return remove((Serializable)producerId);
	}

	/**
	 * Removes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the producer
	 * @return the producer that was removed
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	@Override
	public Producer remove(Serializable primaryKey)
		throws NoSuchProducerException {
		Session session = null;

		try {
			session = openSession();

			Producer producer = (Producer)session.get(ProducerImpl.class,
					primaryKey);

			if (producer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProducerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(producer);
		}
		catch (NoSuchProducerException nsee) {
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
	protected Producer removeImpl(Producer producer) {
		producer = toUnwrappedModel(producer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(producer)) {
				producer = (Producer)session.get(ProducerImpl.class,
						producer.getPrimaryKeyObj());
			}

			if (producer != null) {
				session.delete(producer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (producer != null) {
			clearCache(producer);
		}

		return producer;
	}

	@Override
	public Producer updateImpl(Producer producer) {
		producer = toUnwrappedModel(producer);

		boolean isNew = producer.isNew();

		ProducerModelImpl producerModelImpl = (ProducerModelImpl)producer;

		Session session = null;

		try {
			session = openSession();

			if (producer.isNew()) {
				session.save(producer);

				producer.setNew(false);
			}
			else {
				producer = (Producer)session.merge(producer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProducerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { producerModelImpl.getHostId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_HOST, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST,
				args);

			args = new Object[] { producerModelImpl.getInstitutionId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
				args);

			args = new Object[] { producerModelImpl.getApproved() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((producerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						producerModelImpl.getOriginalHostId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_HOST, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST,
					args);

				args = new Object[] { producerModelImpl.getHostId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_HOST, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST,
					args);
			}

			if ((producerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						producerModelImpl.getOriginalInstitutionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
					args);

				args = new Object[] { producerModelImpl.getInstitutionId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
					args);
			}

			if ((producerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						producerModelImpl.getOriginalApproved()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { producerModelImpl.getApproved() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerImpl.class, producer.getPrimaryKey(), producer, false);

		clearUniqueFindersCache(producerModelImpl, false);
		cacheUniqueFindersCache(producerModelImpl);

		producer.resetOriginalValues();

		return producer;
	}

	protected Producer toUnwrappedModel(Producer producer) {
		if (producer instanceof ProducerImpl) {
			return producer;
		}

		ProducerImpl producerImpl = new ProducerImpl();

		producerImpl.setNew(producer.isNew());
		producerImpl.setPrimaryKey(producer.getPrimaryKey());

		producerImpl.setProducerId(producer.getProducerId());
		producerImpl.setIdNum(producer.getIdNum());
		producerImpl.setHomeDir(producer.getHomeDir());
		producerImpl.setHostId(producer.getHostId());
		producerImpl.setInstitutionId(producer.getInstitutionId());
		producerImpl.setNumberOfProductions(producer.getNumberOfProductions());
		producerImpl.setApproved(producer.getApproved());

		return producerImpl;
	}

	/**
	 * Returns the producer with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the producer
	 * @return the producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	@Override
	public Producer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProducerException {
		Producer producer = fetchByPrimaryKey(primaryKey);

		if (producer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProducerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return producer;
	}

	/**
	 * Returns the producer with the primary key or throws a {@link NoSuchProducerException} if it could not be found.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	@Override
	public Producer findByPrimaryKey(long producerId)
		throws NoSuchProducerException {
		return findByPrimaryKey((Serializable)producerId);
	}

	/**
	 * Returns the producer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the producer
	 * @return the producer, or <code>null</code> if a producer with the primary key could not be found
	 */
	@Override
	public Producer fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
				ProducerImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Producer producer = (Producer)serializable;

		if (producer == null) {
			Session session = null;

			try {
				session = openSession();

				producer = (Producer)session.get(ProducerImpl.class, primaryKey);

				if (producer != null) {
					cacheResult(producer);
				}
				else {
					entityCache.putResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
						ProducerImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
					ProducerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return producer;
	}

	/**
	 * Returns the producer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer, or <code>null</code> if a producer with the primary key could not be found
	 */
	@Override
	public Producer fetchByPrimaryKey(long producerId) {
		return fetchByPrimaryKey((Serializable)producerId);
	}

	@Override
	public Map<Serializable, Producer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Producer> map = new HashMap<Serializable, Producer>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Producer producer = fetchByPrimaryKey(primaryKey);

			if (producer != null) {
				map.put(primaryKey, producer);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
					ProducerImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Producer)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PRODUCER_WHERE_PKS_IN);

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

			for (Producer producer : (List<Producer>)q.list()) {
				map.put(producer.getPrimaryKeyObj(), producer);

				cacheResult(producer);

				uncachedPrimaryKeys.remove(producer.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
					ProducerImpl.class, primaryKey, nullModel);
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
	 * Returns all the producers.
	 *
	 * @return the producers
	 */
	@Override
	public List<Producer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of producers
	 */
	@Override
	public List<Producer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producers
	 */
	@Override
	public List<Producer> findAll(int start, int end,
		OrderByComparator<Producer> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of producers
	 */
	@Override
	public List<Producer> findAll(int start, int end,
		OrderByComparator<Producer> orderByComparator, boolean retrieveFromCache) {
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

		List<Producer> list = null;

		if (retrieveFromCache) {
			list = (List<Producer>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PRODUCER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCER;

				if (pagination) {
					sql = sql.concat(ProducerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the producers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Producer producer : findAll()) {
			remove(producer);
		}
	}

	/**
	 * Returns the number of producers.
	 *
	 * @return the number of producers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCER);

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
		return ProducerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the producer persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProducerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PRODUCER = "SELECT producer FROM Producer producer";
	private static final String _SQL_SELECT_PRODUCER_WHERE_PKS_IN = "SELECT producer FROM Producer producer WHERE producerId IN (";
	private static final String _SQL_SELECT_PRODUCER_WHERE = "SELECT producer FROM Producer producer WHERE ";
	private static final String _SQL_COUNT_PRODUCER = "SELECT COUNT(producer) FROM Producer producer";
	private static final String _SQL_COUNT_PRODUCER_WHERE = "SELECT COUNT(producer) FROM Producer producer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "producer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Producer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Producer exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProducerPersistenceImpl.class);
}