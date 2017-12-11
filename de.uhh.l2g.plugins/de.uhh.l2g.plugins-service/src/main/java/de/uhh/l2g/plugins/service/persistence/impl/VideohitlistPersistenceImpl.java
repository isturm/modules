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
import com.liferay.portal.spring.extender.service.ServiceReference;

import aQute.bnd.annotation.ProviderType;
import de.uhh.l2g.plugins.exception.NoSuchVideohitlistException;
import de.uhh.l2g.plugins.model.Videohitlist;
import de.uhh.l2g.plugins.model.impl.VideohitlistImpl;
import de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl;
import de.uhh.l2g.plugins.service.persistence.VideohitlistPersistence;

/**
 * The persistence implementation for the videohitlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideohitlistPersistence
 * @see de.uhh.l2g.plugins.service.persistence.VideohitlistUtil
 * @generated
 */
@ProviderType
public class VideohitlistPersistenceImpl extends BasePersistenceImpl<Videohitlist>
	implements VideohitlistPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideohitlistUtil} to access the videohitlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideohitlistImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			VideohitlistModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the videohitlists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByVideo(long videoId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {
		return findByVideo(videoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByVideo(long videoId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
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

		List<Videohitlist> list = null;

		if (retrieveFromCache) {
			list = (List<Videohitlist>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Videohitlist videohitlist : list) {
					if ((videoId != videohitlist.getVideoId())) {
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

			query.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideohitlistModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Videohitlist>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Videohitlist>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByVideo_First(long videoId,
		OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {
		Videohitlist videohitlist = fetchByVideo_First(videoId,
				orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideohitlistException(msg.toString());
	}

	/**
	 * Returns the first videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByVideo_First(long videoId,
		OrderByComparator<Videohitlist> orderByComparator) {
		List<Videohitlist> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByVideo_Last(long videoId,
		OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {
		Videohitlist videohitlist = fetchByVideo_Last(videoId, orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideohitlistException(msg.toString());
	}

	/**
	 * Returns the last videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByVideo_Last(long videoId,
		OrderByComparator<Videohitlist> orderByComparator) {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Videohitlist> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist[] findByVideo_PrevAndNext(long videohitlistId,
		long videoId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {
		Videohitlist videohitlist = findByPrimaryKey(videohitlistId);

		Session session = null;

		try {
			session = openSession();

			Videohitlist[] array = new VideohitlistImpl[3];

			array[0] = getByVideo_PrevAndNext(session, videohitlist, videoId,
					orderByComparator, true);

			array[1] = videohitlist;

			array[2] = getByVideo_PrevAndNext(session, videohitlist, videoId,
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

	protected Videohitlist getByVideo_PrevAndNext(Session session,
		Videohitlist videohitlist, long videoId,
		OrderByComparator<Videohitlist> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

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
			query.append(VideohitlistModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videohitlist);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Videohitlist> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videohitlists where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Videohitlist videohitlist : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(videohitlist);
		}
	}

	/**
	 * Returns the number of videohitlists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching videohitlists
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOHITLIST_WHERE);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "videohitlist.videoId = ?";

	public VideohitlistPersistenceImpl() {
		setModelClass(Videohitlist.class);
	}

	/**
	 * Caches the videohitlist in the entity cache if it is enabled.
	 *
	 * @param videohitlist the videohitlist
	 */
	@Override
	public void cacheResult(Videohitlist videohitlist) {
		entityCache.putResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistImpl.class, videohitlist.getPrimaryKey(), videohitlist);

		videohitlist.resetOriginalValues();
	}

	/**
	 * Caches the videohitlists in the entity cache if it is enabled.
	 *
	 * @param videohitlists the videohitlists
	 */
	@Override
	public void cacheResult(List<Videohitlist> videohitlists) {
		for (Videohitlist videohitlist : videohitlists) {
			if (entityCache.getResult(
						VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
						VideohitlistImpl.class, videohitlist.getPrimaryKey()) == null) {
				cacheResult(videohitlist);
			}
			else {
				videohitlist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all videohitlists.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VideohitlistImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the videohitlist.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Videohitlist videohitlist) {
		entityCache.removeResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistImpl.class, videohitlist.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Videohitlist> videohitlists) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Videohitlist videohitlist : videohitlists) {
			entityCache.removeResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
				VideohitlistImpl.class, videohitlist.getPrimaryKey());
		}
	}

	/**
	 * Creates a new videohitlist with the primary key. Does not add the videohitlist to the database.
	 *
	 * @param videohitlistId the primary key for the new videohitlist
	 * @return the new videohitlist
	 */
	@Override
	public Videohitlist create(long videohitlistId) {
		Videohitlist videohitlist = new VideohitlistImpl();

		videohitlist.setNew(true);
		videohitlist.setPrimaryKey(videohitlistId);

		return videohitlist;
	}

	/**
	 * Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist that was removed
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist remove(long videohitlistId)
		throws NoSuchVideohitlistException {
		return remove((Serializable)videohitlistId);
	}

	/**
	 * Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the videohitlist
	 * @return the videohitlist that was removed
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist remove(Serializable primaryKey)
		throws NoSuchVideohitlistException {
		Session session = null;

		try {
			session = openSession();

			Videohitlist videohitlist = (Videohitlist)session.get(VideohitlistImpl.class,
					primaryKey);

			if (videohitlist == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideohitlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videohitlist);
		}
		catch (NoSuchVideohitlistException nsee) {
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
	protected Videohitlist removeImpl(Videohitlist videohitlist) {
		videohitlist = toUnwrappedModel(videohitlist);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(videohitlist)) {
				videohitlist = (Videohitlist)session.get(VideohitlistImpl.class,
						videohitlist.getPrimaryKeyObj());
			}

			if (videohitlist != null) {
				session.delete(videohitlist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (videohitlist != null) {
			clearCache(videohitlist);
		}

		return videohitlist;
	}

	@Override
	public Videohitlist updateImpl(Videohitlist videohitlist) {
		videohitlist = toUnwrappedModel(videohitlist);

		boolean isNew = videohitlist.isNew();

		VideohitlistModelImpl videohitlistModelImpl = (VideohitlistModelImpl)videohitlist;

		Session session = null;

		try {
			session = openSession();

			if (videohitlist.isNew()) {
				session.save(videohitlist);

				videohitlist.setNew(false);
			}
			else {
				videohitlist = (Videohitlist)session.merge(videohitlist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!VideohitlistModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { videohitlistModelImpl.getVideoId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((videohitlistModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videohitlistModelImpl.getOriginalVideoId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { videohitlistModelImpl.getVideoId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}
		}

		entityCache.putResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistImpl.class, videohitlist.getPrimaryKey(), videohitlist,
			false);

		videohitlist.resetOriginalValues();

		return videohitlist;
	}

	protected Videohitlist toUnwrappedModel(Videohitlist videohitlist) {
		if (videohitlist instanceof VideohitlistImpl) {
			return videohitlist;
		}

		VideohitlistImpl videohitlistImpl = new VideohitlistImpl();

		videohitlistImpl.setNew(videohitlist.isNew());
		videohitlistImpl.setPrimaryKey(videohitlist.getPrimaryKey());

		videohitlistImpl.setVideohitlistId(videohitlist.getVideohitlistId());
		videohitlistImpl.setHitsPerDay(videohitlist.getHitsPerDay());
		videohitlistImpl.setHitsPerWeek(videohitlist.getHitsPerWeek());
		videohitlistImpl.setHitsPerMonth(videohitlist.getHitsPerMonth());
		videohitlistImpl.setHitsPerYear(videohitlist.getHitsPerYear());
		videohitlistImpl.setVideoId(videohitlist.getVideoId());

		return videohitlistImpl;
	}

	/**
	 * Returns the videohitlist with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the videohitlist
	 * @return the videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideohitlistException {
		Videohitlist videohitlist = fetchByPrimaryKey(primaryKey);

		if (videohitlist == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideohitlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return videohitlist;
	}

	/**
	 * Returns the videohitlist with the primary key or throws a {@link NoSuchVideohitlistException} if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist findByPrimaryKey(long videohitlistId)
		throws NoSuchVideohitlistException {
		return findByPrimaryKey((Serializable)videohitlistId);
	}

	/**
	 * Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the videohitlist
	 * @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
				VideohitlistImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Videohitlist videohitlist = (Videohitlist)serializable;

		if (videohitlist == null) {
			Session session = null;

			try {
				session = openSession();

				videohitlist = (Videohitlist)session.get(VideohitlistImpl.class,
						primaryKey);

				if (videohitlist != null) {
					cacheResult(videohitlist);
				}
				else {
					entityCache.putResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
						VideohitlistImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
					VideohitlistImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return videohitlist;
	}

	/**
	 * Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist fetchByPrimaryKey(long videohitlistId) {
		return fetchByPrimaryKey((Serializable)videohitlistId);
	}

	@Override
	public Map<Serializable, Videohitlist> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Videohitlist> map = new HashMap<Serializable, Videohitlist>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Videohitlist videohitlist = fetchByPrimaryKey(primaryKey);

			if (videohitlist != null) {
				map.put(primaryKey, videohitlist);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
					VideohitlistImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Videohitlist)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VIDEOHITLIST_WHERE_PKS_IN);

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

			for (Videohitlist videohitlist : (List<Videohitlist>)q.list()) {
				map.put(videohitlist.getPrimaryKeyObj(), videohitlist);

				cacheResult(videohitlist);

				uncachedPrimaryKeys.remove(videohitlist.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
					VideohitlistImpl.class, primaryKey, nullModel);
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
	 * Returns all the videohitlists.
	 *
	 * @return the videohitlists
	 */
	@Override
	public List<Videohitlist> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of videohitlists
	 */
	@Override
	public List<Videohitlist> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of videohitlists
	 */
	@Override
	public List<Videohitlist> findAll(int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of videohitlists
	 */
	@Override
	public List<Videohitlist> findAll(int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
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

		List<Videohitlist> list = null;

		if (retrieveFromCache) {
			list = (List<Videohitlist>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VIDEOHITLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOHITLIST;

				if (pagination) {
					sql = sql.concat(VideohitlistModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Videohitlist>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Videohitlist>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the videohitlists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Videohitlist videohitlist : findAll()) {
			remove(videohitlist);
		}
	}

	/**
	 * Returns the number of videohitlists.
	 *
	 * @return the number of videohitlists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOHITLIST);

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
		return VideohitlistModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the videohitlist persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VideohitlistImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VIDEOHITLIST = "SELECT videohitlist FROM Videohitlist videohitlist";
	private static final String _SQL_SELECT_VIDEOHITLIST_WHERE_PKS_IN = "SELECT videohitlist FROM Videohitlist videohitlist WHERE videohitlistId IN (";
	private static final String _SQL_SELECT_VIDEOHITLIST_WHERE = "SELECT videohitlist FROM Videohitlist videohitlist WHERE ";
	private static final String _SQL_COUNT_VIDEOHITLIST = "SELECT COUNT(videohitlist) FROM Videohitlist videohitlist";
	private static final String _SQL_COUNT_VIDEOHITLIST_WHERE = "SELECT COUNT(videohitlist) FROM Videohitlist videohitlist WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videohitlist.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Videohitlist exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Videohitlist exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(VideohitlistPersistenceImpl.class);
}