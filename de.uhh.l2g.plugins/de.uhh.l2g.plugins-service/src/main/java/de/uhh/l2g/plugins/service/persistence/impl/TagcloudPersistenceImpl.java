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
import de.uhh.l2g.plugins.exception.NoSuchTagcloudException;
import de.uhh.l2g.plugins.model.Tagcloud;
import de.uhh.l2g.plugins.model.impl.TagcloudImpl;
import de.uhh.l2g.plugins.model.impl.TagcloudModelImpl;
import de.uhh.l2g.plugins.service.persistence.TagcloudPersistence;

/**
 * The persistence implementation for the tagcloud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TagcloudPersistence
 * @see de.uhh.l2g.plugins.service.persistence.TagcloudUtil
 * @generated
 */
@ProviderType
public class TagcloudPersistenceImpl extends BasePersistenceImpl<Tagcloud>
	implements TagcloudPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TagcloudUtil} to access the tagcloud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TagcloudImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTCLASSTYPE =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByObjectClassType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObjectClassType",
			new String[] { String.class.getName() },
			TagcloudModelImpl.OBJECTCLASSTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OBJECTCLASSTYPE = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByObjectClassType", new String[] { String.class.getName() });

	/**
	 * Returns all the tagclouds where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @return the matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(String objectClassType) {
		return findByObjectClassType(objectClassType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(String objectClassType,
		int start, int end) {
		return findByObjectClassType(objectClassType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(String objectClassType,
		int start, int end, OrderByComparator<Tagcloud> orderByComparator) {
		return findByObjectClassType(objectClassType, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(String objectClassType,
		int start, int end, OrderByComparator<Tagcloud> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE;
			finderArgs = new Object[] { objectClassType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTCLASSTYPE;
			finderArgs = new Object[] {
					objectClassType,
					
					start, end, orderByComparator
				};
		}

		List<Tagcloud> list = null;

		if (retrieveFromCache) {
			list = (List<Tagcloud>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Tagcloud tagcloud : list) {
					if (!Objects.equals(objectClassType,
								tagcloud.getObjectClassType())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType == null) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_1);
			}
			else if (objectClassType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectClassType_First(String objectClassType,
		OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {
		Tagcloud tagcloud = fetchByObjectClassType_First(objectClassType,
				orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectClassType=");
		msg.append(objectClassType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectClassType_First(String objectClassType,
		OrderByComparator<Tagcloud> orderByComparator) {
		List<Tagcloud> list = findByObjectClassType(objectClassType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectClassType_Last(String objectClassType,
		OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {
		Tagcloud tagcloud = fetchByObjectClassType_Last(objectClassType,
				orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectClassType=");
		msg.append(objectClassType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectClassType_Last(String objectClassType,
		OrderByComparator<Tagcloud> orderByComparator) {
		int count = countByObjectClassType(objectClassType);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByObjectClassType(objectClassType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud[] findByObjectClassType_PrevAndNext(long tagcloudId,
		String objectClassType, OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {
		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByObjectClassType_PrevAndNext(session, tagcloud,
					objectClassType, orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByObjectClassType_PrevAndNext(session, tagcloud,
					objectClassType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tagcloud getByObjectClassType_PrevAndNext(Session session,
		Tagcloud tagcloud, String objectClassType,
		OrderByComparator<Tagcloud> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		boolean bindObjectClassType = false;

		if (objectClassType == null) {
			query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_1);
		}
		else if (objectClassType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3);
		}
		else {
			bindObjectClassType = true;

			query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2);
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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindObjectClassType) {
			qPos.add(objectClassType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tagcloud);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where objectClassType = &#63; from the database.
	 *
	 * @param objectClassType the object class type
	 */
	@Override
	public void removeByObjectClassType(String objectClassType) {
		for (Tagcloud tagcloud : findByObjectClassType(objectClassType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @return the number of matching tagclouds
	 */
	@Override
	public int countByObjectClassType(String objectClassType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OBJECTCLASSTYPE;

		Object[] finderArgs = new Object[] { objectClassType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType == null) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_1);
			}
			else if (objectClassType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
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

	private static final String _FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_1 =
		"tagcloud.objectClassType IS NULL";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2 =
		"tagcloud.objectClassType = ?";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3 =
		"(tagcloud.objectClassType IS NULL OR tagcloud.objectClassType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTID = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByObjectId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObjectId",
			new String[] { Long.class.getName() },
			TagcloudModelImpl.OBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OBJECTID = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByObjectId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tagclouds where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @return the matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectId(long objectId) {
		return findByObjectId(objectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectId(long objectId, int start, int end) {
		return findByObjectId(objectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectId(long objectId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {
		return findByObjectId(objectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectId(long objectId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID;
			finderArgs = new Object[] { objectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTID;
			finderArgs = new Object[] { objectId, start, end, orderByComparator };
		}

		List<Tagcloud> list = null;

		if (retrieveFromCache) {
			list = (List<Tagcloud>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Tagcloud tagcloud : list) {
					if ((objectId != tagcloud.getObjectId())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_OBJECTID_OBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(objectId);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectId_First(long objectId,
		OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {
		Tagcloud tagcloud = fetchByObjectId_First(objectId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectId=");
		msg.append(objectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectId_First(long objectId,
		OrderByComparator<Tagcloud> orderByComparator) {
		List<Tagcloud> list = findByObjectId(objectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectId_Last(long objectId,
		OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {
		Tagcloud tagcloud = fetchByObjectId_Last(objectId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectId=");
		msg.append(objectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectId_Last(long objectId,
		OrderByComparator<Tagcloud> orderByComparator) {
		int count = countByObjectId(objectId);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByObjectId(objectId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud[] findByObjectId_PrevAndNext(long tagcloudId,
		long objectId, OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {
		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByObjectId_PrevAndNext(session, tagcloud, objectId,
					orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByObjectId_PrevAndNext(session, tagcloud, objectId,
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

	protected Tagcloud getByObjectId_PrevAndNext(Session session,
		Tagcloud tagcloud, long objectId,
		OrderByComparator<Tagcloud> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		query.append(_FINDER_COLUMN_OBJECTID_OBJECTID_2);

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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(objectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tagcloud);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where objectId = &#63; from the database.
	 *
	 * @param objectId the object ID
	 */
	@Override
	public void removeByObjectId(long objectId) {
		for (Tagcloud tagcloud : findByObjectId(objectId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @return the number of matching tagclouds
	 */
	@Override
	public int countByObjectId(long objectId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OBJECTID;

		Object[] finderArgs = new Object[] { objectId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_OBJECTID_OBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(objectId);

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

	private static final String _FINDER_COLUMN_OBJECTID_OBJECTID_2 = "tagcloud.objectId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByObjectClassTypeAndObjectId",
			new String[] { String.class.getName(), Long.class.getName() },
			TagcloudModelImpl.OBJECTCLASSTYPE_COLUMN_BITMASK |
			TagcloudModelImpl.OBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByObjectClassTypeAndObjectId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or throws a {@link NoSuchTagcloudException} if it could not be found.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectClassTypeAndObjectId(String objectClassType,
		long objectId) throws NoSuchTagcloudException {
		Tagcloud tagcloud = fetchByObjectClassTypeAndObjectId(objectClassType,
				objectId);

		if (tagcloud == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("objectClassType=");
			msg.append(objectClassType);

			msg.append(", objectId=");
			msg.append(objectId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTagcloudException(msg.toString());
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectClassTypeAndObjectId(String objectClassType,
		long objectId) {
		return fetchByObjectClassTypeAndObjectId(objectClassType, objectId, true);
	}

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectClassTypeAndObjectId(String objectClassType,
		long objectId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { objectClassType, objectId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
					finderArgs, this);
		}

		if (result instanceof Tagcloud) {
			Tagcloud tagcloud = (Tagcloud)result;

			if (!Objects.equals(objectClassType, tagcloud.getObjectClassType()) ||
					(objectId != tagcloud.getObjectId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType == null) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_1);
			}
			else if (objectClassType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_2);
			}

			query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

				qPos.add(objectId);

				List<Tagcloud> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TagcloudPersistenceImpl.fetchByObjectClassTypeAndObjectId(String, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Tagcloud tagcloud = list.get(0);

					result = tagcloud;

					cacheResult(tagcloud);

					if ((tagcloud.getObjectClassType() == null) ||
							!tagcloud.getObjectClassType()
										 .equals(objectClassType) ||
							(tagcloud.getObjectId() != objectId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
							finderArgs, tagcloud);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
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
			return (Tagcloud)result;
		}
	}

	/**
	 * Removes the tagcloud where objectClassType = &#63; and objectId = &#63; from the database.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the tagcloud that was removed
	 */
	@Override
	public Tagcloud removeByObjectClassTypeAndObjectId(String objectClassType,
		long objectId) throws NoSuchTagcloudException {
		Tagcloud tagcloud = findByObjectClassTypeAndObjectId(objectClassType,
				objectId);

		return remove(tagcloud);
	}

	/**
	 * Returns the number of tagclouds where objectClassType = &#63; and objectId = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the number of matching tagclouds
	 */
	@Override
	public int countByObjectClassTypeAndObjectId(String objectClassType,
		long objectId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID;

		Object[] finderArgs = new Object[] { objectClassType, objectId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType == null) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_1);
			}
			else if (objectClassType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_2);
			}

			query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

				qPos.add(objectId);

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

	private static final String _FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_1 =
		"tagcloud.objectClassType IS NULL AND ";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_2 =
		"tagcloud.objectClassType = ? AND ";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_3 =
		"(tagcloud.objectClassType IS NULL OR tagcloud.objectClassType = '') AND ";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTID_2 =
		"tagcloud.objectId = ?";

	public TagcloudPersistenceImpl() {
		setModelClass(Tagcloud.class);
	}

	/**
	 * Caches the tagcloud in the entity cache if it is enabled.
	 *
	 * @param tagcloud the tagcloud
	 */
	@Override
	public void cacheResult(Tagcloud tagcloud) {
		entityCache.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudImpl.class, tagcloud.getPrimaryKey(), tagcloud);

		finderCache.putResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
			new Object[] { tagcloud.getObjectClassType(), tagcloud.getObjectId() },
			tagcloud);

		tagcloud.resetOriginalValues();
	}

	/**
	 * Caches the tagclouds in the entity cache if it is enabled.
	 *
	 * @param tagclouds the tagclouds
	 */
	@Override
	public void cacheResult(List<Tagcloud> tagclouds) {
		for (Tagcloud tagcloud : tagclouds) {
			if (entityCache.getResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
						TagcloudImpl.class, tagcloud.getPrimaryKey()) == null) {
				cacheResult(tagcloud);
			}
			else {
				tagcloud.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tagclouds.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TagcloudImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tagcloud.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tagcloud tagcloud) {
		entityCache.removeResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudImpl.class, tagcloud.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TagcloudModelImpl)tagcloud, true);
	}

	@Override
	public void clearCache(List<Tagcloud> tagclouds) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tagcloud tagcloud : tagclouds) {
			entityCache.removeResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
				TagcloudImpl.class, tagcloud.getPrimaryKey());

			clearUniqueFindersCache((TagcloudModelImpl)tagcloud, true);
		}
	}

	protected void cacheUniqueFindersCache(TagcloudModelImpl tagcloudModelImpl) {
		Object[] args = new Object[] {
				tagcloudModelImpl.getObjectClassType(),
				tagcloudModelImpl.getObjectId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
			args, tagcloudModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TagcloudModelImpl tagcloudModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					tagcloudModelImpl.getObjectClassType(),
					tagcloudModelImpl.getObjectId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
				args);
		}

		if ((tagcloudModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					tagcloudModelImpl.getOriginalObjectClassType(),
					tagcloudModelImpl.getOriginalObjectId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
				args);
		}
	}

	/**
	 * Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	 *
	 * @param tagcloudId the primary key for the new tagcloud
	 * @return the new tagcloud
	 */
	@Override
	public Tagcloud create(long tagcloudId) {
		Tagcloud tagcloud = new TagcloudImpl();

		tagcloud.setNew(true);
		tagcloud.setPrimaryKey(tagcloudId);

		return tagcloud;
	}

	/**
	 * Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud remove(long tagcloudId) throws NoSuchTagcloudException {
		return remove((Serializable)tagcloudId);
	}

	/**
	 * Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud remove(Serializable primaryKey)
		throws NoSuchTagcloudException {
		Session session = null;

		try {
			session = openSession();

			Tagcloud tagcloud = (Tagcloud)session.get(TagcloudImpl.class,
					primaryKey);

			if (tagcloud == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTagcloudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tagcloud);
		}
		catch (NoSuchTagcloudException nsee) {
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
	protected Tagcloud removeImpl(Tagcloud tagcloud) {
		tagcloud = toUnwrappedModel(tagcloud);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tagcloud)) {
				tagcloud = (Tagcloud)session.get(TagcloudImpl.class,
						tagcloud.getPrimaryKeyObj());
			}

			if (tagcloud != null) {
				session.delete(tagcloud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tagcloud != null) {
			clearCache(tagcloud);
		}

		return tagcloud;
	}

	@Override
	public Tagcloud updateImpl(Tagcloud tagcloud) {
		tagcloud = toUnwrappedModel(tagcloud);

		boolean isNew = tagcloud.isNew();

		TagcloudModelImpl tagcloudModelImpl = (TagcloudModelImpl)tagcloud;

		Session session = null;

		try {
			session = openSession();

			if (tagcloud.isNew()) {
				session.save(tagcloud);

				tagcloud.setNew(false);
			}
			else {
				tagcloud = (Tagcloud)session.merge(tagcloud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TagcloudModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { tagcloudModelImpl.getObjectClassType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE,
				args);

			args = new Object[] { tagcloudModelImpl.getObjectId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_OBJECTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((tagcloudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tagcloudModelImpl.getOriginalObjectClassType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE,
					args);

				args = new Object[] { tagcloudModelImpl.getObjectClassType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE,
					args);
			}

			if ((tagcloudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tagcloudModelImpl.getOriginalObjectId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OBJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID,
					args);

				args = new Object[] { tagcloudModelImpl.getObjectId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OBJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID,
					args);
			}
		}

		entityCache.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudImpl.class, tagcloud.getPrimaryKey(), tagcloud, false);

		clearUniqueFindersCache(tagcloudModelImpl, false);
		cacheUniqueFindersCache(tagcloudModelImpl);

		tagcloud.resetOriginalValues();

		return tagcloud;
	}

	protected Tagcloud toUnwrappedModel(Tagcloud tagcloud) {
		if (tagcloud instanceof TagcloudImpl) {
			return tagcloud;
		}

		TagcloudImpl tagcloudImpl = new TagcloudImpl();

		tagcloudImpl.setNew(tagcloud.isNew());
		tagcloudImpl.setPrimaryKey(tagcloud.getPrimaryKey());

		tagcloudImpl.setTagcloudId(tagcloud.getTagcloudId());
		tagcloudImpl.setObjectClassType(tagcloud.getObjectClassType());
		tagcloudImpl.setObjectId(tagcloud.getObjectId());
		tagcloudImpl.setTags(tagcloud.getTags());

		return tagcloudImpl;
	}

	/**
	 * Returns the tagcloud with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTagcloudException {
		Tagcloud tagcloud = fetchByPrimaryKey(primaryKey);

		if (tagcloud == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTagcloudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud with the primary key or throws a {@link NoSuchTagcloudException} if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud findByPrimaryKey(long tagcloudId)
		throws NoSuchTagcloudException {
		return findByPrimaryKey((Serializable)tagcloudId);
	}

	/**
	 * Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
				TagcloudImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Tagcloud tagcloud = (Tagcloud)serializable;

		if (tagcloud == null) {
			Session session = null;

			try {
				session = openSession();

				tagcloud = (Tagcloud)session.get(TagcloudImpl.class, primaryKey);

				if (tagcloud != null) {
					cacheResult(tagcloud);
				}
				else {
					entityCache.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
						TagcloudImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
					TagcloudImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud fetchByPrimaryKey(long tagcloudId) {
		return fetchByPrimaryKey((Serializable)tagcloudId);
	}

	@Override
	public Map<Serializable, Tagcloud> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Tagcloud> map = new HashMap<Serializable, Tagcloud>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Tagcloud tagcloud = fetchByPrimaryKey(primaryKey);

			if (tagcloud != null) {
				map.put(primaryKey, tagcloud);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
					TagcloudImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Tagcloud)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TAGCLOUD_WHERE_PKS_IN);

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

			for (Tagcloud tagcloud : (List<Tagcloud>)q.list()) {
				map.put(tagcloud.getPrimaryKeyObj(), tagcloud);

				cacheResult(tagcloud);

				uncachedPrimaryKeys.remove(tagcloud.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
					TagcloudImpl.class, primaryKey, nullModel);
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
	 * Returns all the tagclouds.
	 *
	 * @return the tagclouds
	 */
	@Override
	public List<Tagcloud> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of tagclouds
	 */
	@Override
	public List<Tagcloud> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tagclouds
	 */
	@Override
	public List<Tagcloud> findAll(int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tagclouds
	 */
	@Override
	public List<Tagcloud> findAll(int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean retrieveFromCache) {
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

		List<Tagcloud> list = null;

		if (retrieveFromCache) {
			list = (List<Tagcloud>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TAGCLOUD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAGCLOUD;

				if (pagination) {
					sql = sql.concat(TagcloudModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tagclouds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Tagcloud tagcloud : findAll()) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds.
	 *
	 * @return the number of tagclouds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAGCLOUD);

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
		return TagcloudModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tagcloud persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TagcloudImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TAGCLOUD = "SELECT tagcloud FROM Tagcloud tagcloud";
	private static final String _SQL_SELECT_TAGCLOUD_WHERE_PKS_IN = "SELECT tagcloud FROM Tagcloud tagcloud WHERE tagcloudId IN (";
	private static final String _SQL_SELECT_TAGCLOUD_WHERE = "SELECT tagcloud FROM Tagcloud tagcloud WHERE ";
	private static final String _SQL_COUNT_TAGCLOUD = "SELECT COUNT(tagcloud) FROM Tagcloud tagcloud";
	private static final String _SQL_COUNT_TAGCLOUD_WHERE = "SELECT COUNT(tagcloud) FROM Tagcloud tagcloud WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tagcloud.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tagcloud exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tagcloud exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TagcloudPersistenceImpl.class);
}