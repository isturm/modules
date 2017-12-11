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

import de.uhh.l2g.plugins.exception.NoSuchLastvideolistException;
import de.uhh.l2g.plugins.model.Lastvideolist;
import de.uhh.l2g.plugins.model.impl.LastvideolistImpl;
import de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl;
import de.uhh.l2g.plugins.service.persistence.LastvideolistPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the lastvideolist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LastvideolistPersistence
 * @see de.uhh.l2g.plugins.service.persistence.LastvideolistUtil
 * @generated
 */
@ProviderType
public class LastvideolistPersistenceImpl extends BasePersistenceImpl<Lastvideolist>
	implements LastvideolistPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LastvideolistUtil} to access the lastvideolist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LastvideolistImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideo", new String[] { Long.class.getName() },
			LastvideolistModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lastvideolists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByVideo(long videoId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {
		return findByVideo(videoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByVideo(long videoId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId, start, end, orderByComparator };
		}

		List<Lastvideolist> list = null;

		if (retrieveFromCache) {
			list = (List<Lastvideolist>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lastvideolist lastvideolist : list) {
					if ((videoId != lastvideolist.getVideoId())) {
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

			query.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LastvideolistModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Lastvideolist>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lastvideolist>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByVideo_First(long videoId,
		OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {
		Lastvideolist lastvideolist = fetchByVideo_First(videoId,
				orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLastvideolistException(msg.toString());
	}

	/**
	 * Returns the first lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByVideo_First(long videoId,
		OrderByComparator<Lastvideolist> orderByComparator) {
		List<Lastvideolist> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByVideo_Last(long videoId,
		OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {
		Lastvideolist lastvideolist = fetchByVideo_Last(videoId,
				orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLastvideolistException(msg.toString());
	}

	/**
	 * Returns the last lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByVideo_Last(long videoId,
		OrderByComparator<Lastvideolist> orderByComparator) {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Lastvideolist> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist[] findByVideo_PrevAndNext(int lastvideolistId,
		long videoId, OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {
		Lastvideolist lastvideolist = findByPrimaryKey(lastvideolistId);

		Session session = null;

		try {
			session = openSession();

			Lastvideolist[] array = new LastvideolistImpl[3];

			array[0] = getByVideo_PrevAndNext(session, lastvideolist, videoId,
					orderByComparator, true);

			array[1] = lastvideolist;

			array[2] = getByVideo_PrevAndNext(session, lastvideolist, videoId,
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

	protected Lastvideolist getByVideo_PrevAndNext(Session session,
		Lastvideolist lastvideolist, long videoId,
		OrderByComparator<Lastvideolist> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

		query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

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
			query.append(LastvideolistModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lastvideolist);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lastvideolist> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lastvideolists where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Lastvideolist lastvideolist : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lastvideolist);
		}
	}

	/**
	 * Returns the number of lastvideolists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching lastvideolists
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LASTVIDEOLIST_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "lastvideolist.videoId = ?";

	public LastvideolistPersistenceImpl() {
		setModelClass(Lastvideolist.class);
	}

	/**
	 * Caches the lastvideolist in the entity cache if it is enabled.
	 *
	 * @param lastvideolist the lastvideolist
	 */
	@Override
	public void cacheResult(Lastvideolist lastvideolist) {
		entityCache.putResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistImpl.class, lastvideolist.getPrimaryKey(),
			lastvideolist);

		lastvideolist.resetOriginalValues();
	}

	/**
	 * Caches the lastvideolists in the entity cache if it is enabled.
	 *
	 * @param lastvideolists the lastvideolists
	 */
	@Override
	public void cacheResult(List<Lastvideolist> lastvideolists) {
		for (Lastvideolist lastvideolist : lastvideolists) {
			if (entityCache.getResult(
						LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
						LastvideolistImpl.class, lastvideolist.getPrimaryKey()) == null) {
				cacheResult(lastvideolist);
			}
			else {
				lastvideolist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lastvideolists.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LastvideolistImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lastvideolist.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lastvideolist lastvideolist) {
		entityCache.removeResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistImpl.class, lastvideolist.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lastvideolist> lastvideolists) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lastvideolist lastvideolist : lastvideolists) {
			entityCache.removeResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
				LastvideolistImpl.class, lastvideolist.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lastvideolist with the primary key. Does not add the lastvideolist to the database.
	 *
	 * @param lastvideolistId the primary key for the new lastvideolist
	 * @return the new lastvideolist
	 */
	@Override
	public Lastvideolist create(int lastvideolistId) {
		Lastvideolist lastvideolist = new LastvideolistImpl();

		lastvideolist.setNew(true);
		lastvideolist.setPrimaryKey(lastvideolistId);

		return lastvideolist;
	}

	/**
	 * Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist that was removed
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist remove(int lastvideolistId)
		throws NoSuchLastvideolistException {
		return remove((Serializable)lastvideolistId);
	}

	/**
	 * Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lastvideolist
	 * @return the lastvideolist that was removed
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist remove(Serializable primaryKey)
		throws NoSuchLastvideolistException {
		Session session = null;

		try {
			session = openSession();

			Lastvideolist lastvideolist = (Lastvideolist)session.get(LastvideolistImpl.class,
					primaryKey);

			if (lastvideolist == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLastvideolistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lastvideolist);
		}
		catch (NoSuchLastvideolistException nsee) {
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
	protected Lastvideolist removeImpl(Lastvideolist lastvideolist) {
		lastvideolist = toUnwrappedModel(lastvideolist);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lastvideolist)) {
				lastvideolist = (Lastvideolist)session.get(LastvideolistImpl.class,
						lastvideolist.getPrimaryKeyObj());
			}

			if (lastvideolist != null) {
				session.delete(lastvideolist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lastvideolist != null) {
			clearCache(lastvideolist);
		}

		return lastvideolist;
	}

	@Override
	public Lastvideolist updateImpl(Lastvideolist lastvideolist) {
		lastvideolist = toUnwrappedModel(lastvideolist);

		boolean isNew = lastvideolist.isNew();

		LastvideolistModelImpl lastvideolistModelImpl = (LastvideolistModelImpl)lastvideolist;

		Session session = null;

		try {
			session = openSession();

			if (lastvideolist.isNew()) {
				session.save(lastvideolist);

				lastvideolist.setNew(false);
			}
			else {
				lastvideolist = (Lastvideolist)session.merge(lastvideolist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LastvideolistModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { lastvideolistModelImpl.getVideoId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((lastvideolistModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lastvideolistModelImpl.getOriginalVideoId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { lastvideolistModelImpl.getVideoId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}
		}

		entityCache.putResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistImpl.class, lastvideolist.getPrimaryKey(),
			lastvideolist, false);

		lastvideolist.resetOriginalValues();

		return lastvideolist;
	}

	protected Lastvideolist toUnwrappedModel(Lastvideolist lastvideolist) {
		if (lastvideolist instanceof LastvideolistImpl) {
			return lastvideolist;
		}

		LastvideolistImpl lastvideolistImpl = new LastvideolistImpl();

		lastvideolistImpl.setNew(lastvideolist.isNew());
		lastvideolistImpl.setPrimaryKey(lastvideolist.getPrimaryKey());

		lastvideolistImpl.setLastvideolistId(lastvideolist.getLastvideolistId());
		lastvideolistImpl.setVideoId(lastvideolist.getVideoId());

		return lastvideolistImpl;
	}

	/**
	 * Returns the lastvideolist with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lastvideolist
	 * @return the lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLastvideolistException {
		Lastvideolist lastvideolist = fetchByPrimaryKey(primaryKey);

		if (lastvideolist == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLastvideolistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lastvideolist;
	}

	/**
	 * Returns the lastvideolist with the primary key or throws a {@link NoSuchLastvideolistException} if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist findByPrimaryKey(int lastvideolistId)
		throws NoSuchLastvideolistException {
		return findByPrimaryKey((Serializable)lastvideolistId);
	}

	/**
	 * Returns the lastvideolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lastvideolist
	 * @return the lastvideolist, or <code>null</code> if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
				LastvideolistImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Lastvideolist lastvideolist = (Lastvideolist)serializable;

		if (lastvideolist == null) {
			Session session = null;

			try {
				session = openSession();

				lastvideolist = (Lastvideolist)session.get(LastvideolistImpl.class,
						primaryKey);

				if (lastvideolist != null) {
					cacheResult(lastvideolist);
				}
				else {
					entityCache.putResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
						LastvideolistImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
					LastvideolistImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lastvideolist;
	}

	/**
	 * Returns the lastvideolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist, or <code>null</code> if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist fetchByPrimaryKey(int lastvideolistId) {
		return fetchByPrimaryKey((Serializable)lastvideolistId);
	}

	@Override
	public Map<Serializable, Lastvideolist> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Lastvideolist> map = new HashMap<Serializable, Lastvideolist>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Lastvideolist lastvideolist = fetchByPrimaryKey(primaryKey);

			if (lastvideolist != null) {
				map.put(primaryKey, lastvideolist);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
					LastvideolistImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Lastvideolist)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LASTVIDEOLIST_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((int)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Lastvideolist lastvideolist : (List<Lastvideolist>)q.list()) {
				map.put(lastvideolist.getPrimaryKeyObj(), lastvideolist);

				cacheResult(lastvideolist);

				uncachedPrimaryKeys.remove(lastvideolist.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
					LastvideolistImpl.class, primaryKey, nullModel);
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
	 * Returns all the lastvideolists.
	 *
	 * @return the lastvideolists
	 */
	@Override
	public List<Lastvideolist> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of lastvideolists
	 */
	@Override
	public List<Lastvideolist> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lastvideolists
	 */
	@Override
	public List<Lastvideolist> findAll(int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lastvideolists
	 */
	@Override
	public List<Lastvideolist> findAll(int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
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

		List<Lastvideolist> list = null;

		if (retrieveFromCache) {
			list = (List<Lastvideolist>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LASTVIDEOLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LASTVIDEOLIST;

				if (pagination) {
					sql = sql.concat(LastvideolistModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lastvideolist>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lastvideolist>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the lastvideolists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Lastvideolist lastvideolist : findAll()) {
			remove(lastvideolist);
		}
	}

	/**
	 * Returns the number of lastvideolists.
	 *
	 * @return the number of lastvideolists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LASTVIDEOLIST);

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
		return LastvideolistModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lastvideolist persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LastvideolistImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LASTVIDEOLIST = "SELECT lastvideolist FROM Lastvideolist lastvideolist";
	private static final String _SQL_SELECT_LASTVIDEOLIST_WHERE_PKS_IN = "SELECT lastvideolist FROM Lastvideolist lastvideolist WHERE lastvideolistId IN (";
	private static final String _SQL_SELECT_LASTVIDEOLIST_WHERE = "SELECT lastvideolist FROM Lastvideolist lastvideolist WHERE ";
	private static final String _SQL_COUNT_LASTVIDEOLIST = "SELECT COUNT(lastvideolist) FROM Lastvideolist lastvideolist";
	private static final String _SQL_COUNT_LASTVIDEOLIST_WHERE = "SELECT COUNT(lastvideolist) FROM Lastvideolist lastvideolist WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lastvideolist.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lastvideolist exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Lastvideolist exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LastvideolistPersistenceImpl.class);
}