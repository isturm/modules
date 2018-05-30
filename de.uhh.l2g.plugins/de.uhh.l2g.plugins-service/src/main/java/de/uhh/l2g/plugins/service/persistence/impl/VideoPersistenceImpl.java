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
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchVideoException;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.model.impl.VideoModelImpl;
import de.uhh.l2g.plugins.service.persistence.VideoPersistence;

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

/**
 * The persistence implementation for the video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideoPersistence
 * @see de.uhh.l2g.plugins.service.persistence.VideoUtil
 * @generated
 */
@ProviderType
public class VideoPersistenceImpl extends BasePersistenceImpl<Video>
	implements VideoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoUtil} to access the video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCER = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProducer",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProducer",
			new String[] { Long.class.getName() },
			VideoModelImpl.PRODUCERID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCER = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProducer",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the videos where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByProducer(long producerId) {
		return findByProducer(producerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the videos where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByProducer(long producerId, int start, int end) {
		return findByProducer(producerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByProducer(long producerId, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByProducer(producerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByProducer(long producerId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER;
			finderArgs = new Object[] { producerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCER;
			finderArgs = new Object[] { producerId, start, end, orderByComparator };
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((producerId != video.getProducerId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCER_PRODUCERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducer_First(long producerId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByProducer_First(producerId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducer_First(long producerId,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByProducer(producerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducer_Last(long producerId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByProducer_Last(producerId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducer_Last(long producerId,
		OrderByComparator<Video> orderByComparator) {
		int count = countByProducer(producerId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByProducer(producerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where producerId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByProducer_PrevAndNext(long videoId, long producerId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByProducer_PrevAndNext(session, video, producerId,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByProducer_PrevAndNext(session, video, producerId,
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

	protected Video getByProducer_PrevAndNext(Session session, Video video,
		long producerId, OrderByComparator<Video> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_PRODUCER_PRODUCERID_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where producerId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 */
	@Override
	public void removeByProducer(long producerId) {
		for (Video video : findByProducer(producerId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByProducer(long producerId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCER;

		Object[] finderArgs = new Object[] { producerId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCER_PRODUCERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

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

	private static final String _FINDER_COLUMN_PRODUCER_PRODUCERID_2 = "video.producerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseries",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseries",
			new String[] { Long.class.getName() },
			VideoModelImpl.LECTURESERIESID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIES = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseries",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the videos where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByLectureseries(long lectureseriesId) {
		return findByLectureseries(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByLectureseries(long lectureseriesId, int start,
		int end) {
		return findByLectureseries(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByLectureseries(long lectureseriesId, int start,
		int end, OrderByComparator<Video> orderByComparator) {
		return findByLectureseries(lectureseriesId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByLectureseries(long lectureseriesId, int start,
		int end, OrderByComparator<Video> orderByComparator,
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

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((lectureseriesId != video.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByLectureseries_First(long lectureseriesId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByLectureseries_First(lectureseriesId,
				orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLectureseries_First(long lectureseriesId,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByLectureseries(lectureseriesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByLectureseries_Last(long lectureseriesId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByLectureseries_Last(lectureseriesId,
				orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLectureseries_Last(long lectureseriesId,
		OrderByComparator<Video> orderByComparator) {
		int count = countByLectureseries(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByLectureseries(lectureseriesId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByLectureseries_PrevAndNext(long videoId,
		long lectureseriesId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByLectureseries_PrevAndNext(session, video,
					lectureseriesId, orderByComparator, true);

			array[1] = video;

			array[2] = getByLectureseries_PrevAndNext(session, video,
					lectureseriesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByLectureseries_PrevAndNext(Session session,
		Video video, long lectureseriesId,
		OrderByComparator<Video> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	@Override
	public void removeByLectureseries(long lectureseriesId) {
		for (Video video : findByLectureseries(lectureseriesId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByLectureseries(long lectureseriesId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIES;

		Object[] finderArgs = new Object[] { lectureseriesId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

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

	private static final String _FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2 = "video.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProducerAndLectureseries",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProducerAndLectureseries",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoModelImpl.PRODUCERID_COLUMN_BITMASK |
			VideoModelImpl.LECTURESERIESID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCERANDLECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProducerAndLectureseries",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByProducerAndLectureseries(long producerId,
		long lectureseriesId) {
		return findByProducerAndLectureseries(producerId, lectureseriesId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByProducerAndLectureseries(long producerId,
		long lectureseriesId, int start, int end) {
		return findByProducerAndLectureseries(producerId, lectureseriesId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByProducerAndLectureseries(long producerId,
		long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByProducerAndLectureseries(producerId, lectureseriesId,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByProducerAndLectureseries(long producerId,
		long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES;
			finderArgs = new Object[] { producerId, lectureseriesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES;
			finderArgs = new Object[] {
					producerId, lectureseriesId,
					
					start, end, orderByComparator
				};
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((producerId != video.getProducerId()) ||
							(lectureseriesId != video.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducerAndLectureseries_First(long producerId,
		long lectureseriesId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {
		Video video = fetchByProducerAndLectureseries_First(producerId,
				lectureseriesId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducerAndLectureseries_First(long producerId,
		long lectureseriesId, OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByProducerAndLectureseries(producerId,
				lectureseriesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducerAndLectureseries_Last(long producerId,
		long lectureseriesId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {
		Video video = fetchByProducerAndLectureseries_Last(producerId,
				lectureseriesId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducerAndLectureseries_Last(long producerId,
		long lectureseriesId, OrderByComparator<Video> orderByComparator) {
		int count = countByProducerAndLectureseries(producerId, lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByProducerAndLectureseries(producerId,
				lectureseriesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByProducerAndLectureseries_PrevAndNext(long videoId,
		long producerId, long lectureseriesId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByProducerAndLectureseries_PrevAndNext(session,
					video, producerId, lectureseriesId, orderByComparator, true);

			array[1] = video;

			array[2] = getByProducerAndLectureseries_PrevAndNext(session,
					video, producerId, lectureseriesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByProducerAndLectureseries_PrevAndNext(Session session,
		Video video, long producerId, long lectureseriesId,
		OrderByComparator<Video> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2);

		query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where producerId = &#63; and lectureseriesId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 */
	@Override
	public void removeByProducerAndLectureseries(long producerId,
		long lectureseriesId) {
		for (Video video : findByProducerAndLectureseries(producerId,
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByProducerAndLectureseries(long producerId,
		long lectureseriesId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCERANDLECTURESERIES;

		Object[] finderArgs = new Object[] { producerId, lectureseriesId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

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

	private static final String _FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2 =
		"video.producerId = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2 =
		"video.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCERANDDOWNLOADLINK =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProducerAndDownloadLink",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDDOWNLOADLINK =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProducerAndDownloadLink",
			new String[] { Long.class.getName(), Integer.class.getName() },
			VideoModelImpl.PRODUCERID_COLUMN_BITMASK |
			VideoModelImpl.DOWNLOADLINK_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCERANDDOWNLOADLINK = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProducerAndDownloadLink",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByProducerAndDownloadLink(long producerId,
		int downloadLink) {
		return findByProducerAndDownloadLink(producerId, downloadLink,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByProducerAndDownloadLink(long producerId,
		int downloadLink, int start, int end) {
		return findByProducerAndDownloadLink(producerId, downloadLink, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByProducerAndDownloadLink(long producerId,
		int downloadLink, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByProducerAndDownloadLink(producerId, downloadLink, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByProducerAndDownloadLink(long producerId,
		int downloadLink, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDDOWNLOADLINK;
			finderArgs = new Object[] { producerId, downloadLink };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCERANDDOWNLOADLINK;
			finderArgs = new Object[] {
					producerId, downloadLink,
					
					start, end, orderByComparator
				};
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((producerId != video.getProducerId()) ||
							(downloadLink != video.getDownloadLink())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_PRODUCERID_2);

			query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_DOWNLOADLINK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				qPos.add(downloadLink);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducerAndDownloadLink_First(long producerId,
		int downloadLink, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {
		Video video = fetchByProducerAndDownloadLink_First(producerId,
				downloadLink, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", downloadLink=");
		msg.append(downloadLink);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducerAndDownloadLink_First(long producerId,
		int downloadLink, OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByProducerAndDownloadLink(producerId,
				downloadLink, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducerAndDownloadLink_Last(long producerId,
		int downloadLink, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {
		Video video = fetchByProducerAndDownloadLink_Last(producerId,
				downloadLink, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", downloadLink=");
		msg.append(downloadLink);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducerAndDownloadLink_Last(long producerId,
		int downloadLink, OrderByComparator<Video> orderByComparator) {
		int count = countByProducerAndDownloadLink(producerId, downloadLink);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByProducerAndDownloadLink(producerId,
				downloadLink, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByProducerAndDownloadLink_PrevAndNext(long videoId,
		long producerId, int downloadLink,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByProducerAndDownloadLink_PrevAndNext(session, video,
					producerId, downloadLink, orderByComparator, true);

			array[1] = video;

			array[2] = getByProducerAndDownloadLink_PrevAndNext(session, video,
					producerId, downloadLink, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByProducerAndDownloadLink_PrevAndNext(Session session,
		Video video, long producerId, int downloadLink,
		OrderByComparator<Video> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_PRODUCERID_2);

		query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_DOWNLOADLINK_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		qPos.add(downloadLink);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where producerId = &#63; and downloadLink = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 */
	@Override
	public void removeByProducerAndDownloadLink(long producerId,
		int downloadLink) {
		for (Video video : findByProducerAndDownloadLink(producerId,
				downloadLink, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @return the number of matching videos
	 */
	@Override
	public int countByProducerAndDownloadLink(long producerId, int downloadLink) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCERANDDOWNLOADLINK;

		Object[] finderArgs = new Object[] { producerId, downloadLink };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_PRODUCERID_2);

			query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_DOWNLOADLINK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				qPos.add(downloadLink);

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

	private static final String _FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_PRODUCERID_2 =
		"video.producerId = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_DOWNLOADLINK_2 =
		"video.downloadLink = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLectureseriesAndOpenaccess",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLectureseriesAndOpenaccess",
			new String[] { Long.class.getName(), Integer.class.getName() },
			VideoModelImpl.LECTURESERIESID_COLUMN_BITMASK |
			VideoModelImpl.OPENACCESS_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesAndOpenaccess",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess) {
		return findByLectureseriesAndOpenaccess(lectureseriesId, openAccess,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess, int start, int end) {
		return findByLectureseriesAndOpenaccess(lectureseriesId, openAccess,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByLectureseriesAndOpenaccess(lectureseriesId, openAccess,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS;
			finderArgs = new Object[] { lectureseriesId, openAccess };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS;
			finderArgs = new Object[] {
					lectureseriesId, openAccess,
					
					start, end, orderByComparator
				};
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((lectureseriesId != video.getLectureseriesId()) ||
							(openAccess != video.getOpenAccess())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(openAccess);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByLectureseriesAndOpenaccess_First(long lectureseriesId,
		int openAccess, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {
		Video video = fetchByLectureseriesAndOpenaccess_First(lectureseriesId,
				openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", openAccess=");
		msg.append(openAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLectureseriesAndOpenaccess_First(long lectureseriesId,
		int openAccess, OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByLectureseriesAndOpenaccess(lectureseriesId,
				openAccess, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByLectureseriesAndOpenaccess_Last(long lectureseriesId,
		int openAccess, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {
		Video video = fetchByLectureseriesAndOpenaccess_Last(lectureseriesId,
				openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", openAccess=");
		msg.append(openAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLectureseriesAndOpenaccess_Last(long lectureseriesId,
		int openAccess, OrderByComparator<Video> orderByComparator) {
		int count = countByLectureseriesAndOpenaccess(lectureseriesId,
				openAccess);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByLectureseriesAndOpenaccess(lectureseriesId,
				openAccess, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByLectureseriesAndOpenaccess_PrevAndNext(long videoId,
		long lectureseriesId, int openAccess,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByLectureseriesAndOpenaccess_PrevAndNext(session,
					video, lectureseriesId, openAccess, orderByComparator, true);

			array[1] = video;

			array[2] = getByLectureseriesAndOpenaccess_PrevAndNext(session,
					video, lectureseriesId, openAccess, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByLectureseriesAndOpenaccess_PrevAndNext(
		Session session, Video video, long lectureseriesId, int openAccess,
		OrderByComparator<Video> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2);

		query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		qPos.add(openAccess);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where lectureseriesId = &#63; and openAccess = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 */
	@Override
	public void removeByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess) {
		for (Video video : findByLectureseriesAndOpenaccess(lectureseriesId,
				openAccess, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @return the number of matching videos
	 */
	@Override
	public int countByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS;

		Object[] finderArgs = new Object[] { lectureseriesId, openAccess };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(openAccess);

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

	private static final String _FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2 =
		"video.lectureseriesId = ? AND ";
	private static final String _FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2 =
		"video.openAccess = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILENAME = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFilename",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFilename",
			new String[] { String.class.getName() },
			VideoModelImpl.FILENAME_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILENAME = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFilename",
			new String[] { String.class.getName() });

	/**
	 * Returns all the videos where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByFilename(String filename) {
		return findByFilename(filename, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the videos where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByFilename(String filename, int start, int end) {
		return findByFilename(filename, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByFilename(String filename, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByFilename(filename, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByFilename(String filename, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME;
			finderArgs = new Object[] { filename };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILENAME;
			finderArgs = new Object[] { filename, start, end, orderByComparator };
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if (!Objects.equals(filename, video.getFilename())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			boolean bindFilename = false;

			if (filename == null) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_1);
			}
			else if (filename.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
			}
			else {
				bindFilename = true;

				query.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFilename) {
					qPos.add(filename);
				}

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByFilename_First(String filename,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByFilename_First(filename, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("filename=");
		msg.append(filename);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByFilename_First(String filename,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByFilename(filename, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByFilename_Last(String filename,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByFilename_Last(filename, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("filename=");
		msg.append(filename);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByFilename_Last(String filename,
		OrderByComparator<Video> orderByComparator) {
		int count = countByFilename(filename);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByFilename(filename, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where filename = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByFilename_PrevAndNext(long videoId, String filename,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByFilename_PrevAndNext(session, video, filename,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByFilename_PrevAndNext(session, video, filename,
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

	protected Video getByFilename_PrevAndNext(Session session, Video video,
		String filename, OrderByComparator<Video> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEO_WHERE);

		boolean bindFilename = false;

		if (filename == null) {
			query.append(_FINDER_COLUMN_FILENAME_FILENAME_1);
		}
		else if (filename.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
		}
		else {
			bindFilename = true;

			query.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFilename) {
			qPos.add(filename);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where filename = &#63; from the database.
	 *
	 * @param filename the filename
	 */
	@Override
	public void removeByFilename(String filename) {
		for (Video video : findByFilename(filename, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the number of matching videos
	 */
	@Override
	public int countByFilename(String filename) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILENAME;

		Object[] finderArgs = new Object[] { filename };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			boolean bindFilename = false;

			if (filename == null) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_1);
			}
			else if (filename.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
			}
			else {
				bindFilename = true;

				query.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFilename) {
					qPos.add(filename);
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

	private static final String _FINDER_COLUMN_FILENAME_FILENAME_1 = "video.filename IS NULL";
	private static final String _FINDER_COLUMN_FILENAME_FILENAME_2 = "video.filename = ?";
	private static final String _FINDER_COLUMN_FILENAME_FILENAME_3 = "(video.filename IS NULL OR video.filename = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UPLOADDATE =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUploadDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADDATE =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUploadDate",
			new String[] { Date.class.getName() },
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UPLOADDATE = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUploadDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the videos where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByUploadDate(Date uploadDate) {
		return findByUploadDate(uploadDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where uploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uploadDate the upload date
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByUploadDate(Date uploadDate, int start, int end) {
		return findByUploadDate(uploadDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where uploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uploadDate the upload date
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByUploadDate(Date uploadDate, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByUploadDate(uploadDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where uploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uploadDate the upload date
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByUploadDate(Date uploadDate, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADDATE;
			finderArgs = new Object[] { uploadDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UPLOADDATE;
			finderArgs = new Object[] { uploadDate, start, end, orderByComparator };
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if (!Objects.equals(uploadDate, video.getUploadDate())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			boolean bindUploadDate = false;

			if (uploadDate == null) {
				query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_1);
			}
			else {
				bindUploadDate = true;

				query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUploadDate) {
					qPos.add(new Timestamp(uploadDate.getTime()));
				}

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByUploadDate_First(Date uploadDate,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByUploadDate_First(uploadDate, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uploadDate=");
		msg.append(uploadDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByUploadDate_First(Date uploadDate,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByUploadDate(uploadDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByUploadDate_Last(Date uploadDate,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByUploadDate_Last(uploadDate, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uploadDate=");
		msg.append(uploadDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByUploadDate_Last(Date uploadDate,
		OrderByComparator<Video> orderByComparator) {
		int count = countByUploadDate(uploadDate);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByUploadDate(uploadDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where uploadDate = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByUploadDate_PrevAndNext(long videoId, Date uploadDate,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByUploadDate_PrevAndNext(session, video, uploadDate,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByUploadDate_PrevAndNext(session, video, uploadDate,
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

	protected Video getByUploadDate_PrevAndNext(Session session, Video video,
		Date uploadDate, OrderByComparator<Video> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEO_WHERE);

		boolean bindUploadDate = false;

		if (uploadDate == null) {
			query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_1);
		}
		else {
			bindUploadDate = true;

			query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_2);
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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUploadDate) {
			qPos.add(new Timestamp(uploadDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where uploadDate = &#63; from the database.
	 *
	 * @param uploadDate the upload date
	 */
	@Override
	public void removeByUploadDate(Date uploadDate) {
		for (Video video : findByUploadDate(uploadDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @return the number of matching videos
	 */
	@Override
	public int countByUploadDate(Date uploadDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UPLOADDATE;

		Object[] finderArgs = new Object[] { uploadDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			boolean bindUploadDate = false;

			if (uploadDate == null) {
				query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_1);
			}
			else {
				bindUploadDate = true;

				query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUploadDate) {
					qPos.add(new Timestamp(uploadDate.getTime()));
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

	private static final String _FINDER_COLUMN_UPLOADDATE_UPLOADDATE_1 = "video.uploadDate IS NULL";
	private static final String _FINDER_COLUMN_UPLOADDATE_UPLOADDATE_2 = "video.uploadDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOTINSTITUTION =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRootInstitution",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTINSTITUTION =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRootInstitution",
			new String[] { Long.class.getName() },
			VideoModelImpl.ROOTINSTITUTIONID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTINSTITUTION = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRootInstitution", new String[] { Long.class.getName() });

	/**
	 * Returns all the videos where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByRootInstitution(long rootInstitutionId) {
		return findByRootInstitution(rootInstitutionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where rootInstitutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByRootInstitution(long rootInstitutionId, int start,
		int end) {
		return findByRootInstitution(rootInstitutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where rootInstitutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByRootInstitution(long rootInstitutionId, int start,
		int end, OrderByComparator<Video> orderByComparator) {
		return findByRootInstitution(rootInstitutionId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where rootInstitutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByRootInstitution(long rootInstitutionId, int start,
		int end, OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTINSTITUTION;
			finderArgs = new Object[] { rootInstitutionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOTINSTITUTION;
			finderArgs = new Object[] {
					rootInstitutionId,
					
					start, end, orderByComparator
				};
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((rootInstitutionId != video.getRootInstitutionId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_ROOTINSTITUTION_ROOTINSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootInstitutionId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByRootInstitution_First(long rootInstitutionId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByRootInstitution_First(rootInstitutionId,
				orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rootInstitutionId=");
		msg.append(rootInstitutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByRootInstitution_First(long rootInstitutionId,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByRootInstitution(rootInstitutionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByRootInstitution_Last(long rootInstitutionId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByRootInstitution_Last(rootInstitutionId,
				orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rootInstitutionId=");
		msg.append(rootInstitutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByRootInstitution_Last(long rootInstitutionId,
		OrderByComparator<Video> orderByComparator) {
		int count = countByRootInstitution(rootInstitutionId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByRootInstitution(rootInstitutionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByRootInstitution_PrevAndNext(long videoId,
		long rootInstitutionId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByRootInstitution_PrevAndNext(session, video,
					rootInstitutionId, orderByComparator, true);

			array[1] = video;

			array[2] = getByRootInstitution_PrevAndNext(session, video,
					rootInstitutionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByRootInstitution_PrevAndNext(Session session,
		Video video, long rootInstitutionId,
		OrderByComparator<Video> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_ROOTINSTITUTION_ROOTINSTITUTIONID_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rootInstitutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where rootInstitutionId = &#63; from the database.
	 *
	 * @param rootInstitutionId the root institution ID
	 */
	@Override
	public void removeByRootInstitution(long rootInstitutionId) {
		for (Video video : findByRootInstitution(rootInstitutionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByRootInstitution(long rootInstitutionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROOTINSTITUTION;

		Object[] finderArgs = new Object[] { rootInstitutionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_ROOTINSTITUTION_ROOTINSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootInstitutionId);

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

	private static final String _FINDER_COLUMN_ROOTINSTITUTION_ROOTINSTITUTIONID_2 =
		"video.rootInstitutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PASSWORD = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPassword",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPassword",
			new String[] { String.class.getName() },
			VideoModelImpl.PASSWORD_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PASSWORD = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPassword",
			new String[] { String.class.getName() });

	/**
	 * Returns all the videos where password = &#63;.
	 *
	 * @param password the password
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByPassword(String password) {
		return findByPassword(password, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the videos where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByPassword(String password, int start, int end) {
		return findByPassword(password, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByPassword(String password, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByPassword(password, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByPassword(String password, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
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

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if (!Objects.equals(password, video.getPassword())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

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
				query.append(VideoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByPassword_First(String password,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByPassword_First(password, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("password=");
		msg.append(password);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByPassword_First(String password,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByPassword(password, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByPassword_Last(String password,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByPassword_Last(password, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("password=");
		msg.append(password);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByPassword_Last(String password,
		OrderByComparator<Video> orderByComparator) {
		int count = countByPassword(password);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByPassword(password, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where password = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByPassword_PrevAndNext(long videoId, String password,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByPassword_PrevAndNext(session, video, password,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByPassword_PrevAndNext(session, video, password,
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

	protected Video getByPassword_PrevAndNext(Session session, Video video,
		String password, OrderByComparator<Video> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEO_WHERE);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where password = &#63; from the database.
	 *
	 * @param password the password
	 */
	@Override
	public void removeByPassword(String password) {
		for (Video video : findByPassword(password, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where password = &#63;.
	 *
	 * @param password the password
	 * @return the number of matching videos
	 */
	@Override
	public int countByPassword(String password) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PASSWORD;

		Object[] finderArgs = new Object[] { password };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

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

	private static final String _FINDER_COLUMN_PASSWORD_PASSWORD_1 = "video.password IS NULL";
	private static final String _FINDER_COLUMN_PASSWORD_PASSWORD_2 = "video.password = ?";
	private static final String _FINDER_COLUMN_PASSWORD_PASSWORD_3 = "(video.password IS NULL OR video.password = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPENACCESS =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOpenAccess",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOpenAccess",
			new String[] { Integer.class.getName() },
			VideoModelImpl.OPENACCESS_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPENACCESS = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOpenAccess",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByOpenAccess(int openAccess) {
		return findByOpenAccess(openAccess, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByOpenAccess(int openAccess, int start, int end) {
		return findByOpenAccess(openAccess, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByOpenAccess(int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByOpenAccess(openAccess, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByOpenAccess(int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS;
			finderArgs = new Object[] { openAccess };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPENACCESS;
			finderArgs = new Object[] { openAccess, start, end, orderByComparator };
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((openAccess != video.getOpenAccess())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_OPENACCESS_OPENACCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(openAccess);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByOpenAccess_First(int openAccess,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByOpenAccess_First(openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openAccess=");
		msg.append(openAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByOpenAccess_First(int openAccess,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByOpenAccess(openAccess, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByOpenAccess_Last(int openAccess,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByOpenAccess_Last(openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openAccess=");
		msg.append(openAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByOpenAccess_Last(int openAccess,
		OrderByComparator<Video> orderByComparator) {
		int count = countByOpenAccess(openAccess);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByOpenAccess(openAccess, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where openAccess = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByOpenAccess_PrevAndNext(long videoId, int openAccess,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByOpenAccess_PrevAndNext(session, video, openAccess,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByOpenAccess_PrevAndNext(session, video, openAccess,
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

	protected Video getByOpenAccess_PrevAndNext(Session session, Video video,
		int openAccess, OrderByComparator<Video> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_OPENACCESS_OPENACCESS_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(openAccess);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where openAccess = &#63; from the database.
	 *
	 * @param openAccess the open access
	 */
	@Override
	public void removeByOpenAccess(int openAccess) {
		for (Video video : findByOpenAccess(openAccess, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the number of matching videos
	 */
	@Override
	public int countByOpenAccess(int openAccess) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPENACCESS;

		Object[] finderArgs = new Object[] { openAccess };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_OPENACCESS_OPENACCESS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(openAccess);

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

	private static final String _FINDER_COLUMN_OPENACCESS_OPENACCESS_2 = "video.openAccess = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TERM = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTerm",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTerm",
			new String[] { Long.class.getName() },
			VideoModelImpl.TERMID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TERM = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTerm",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the videos where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByTerm(long termId) {
		return findByTerm(termId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByTerm(long termId, int start, int end) {
		return findByTerm(termId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByTerm(long termId, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByTerm(termId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByTerm(long termId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
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

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((termId != video.getTermId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_TERM_TERMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(termId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByTerm_First(long termId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByTerm_First(termId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("termId=");
		msg.append(termId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByTerm_First(long termId,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByTerm(termId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByTerm_Last(long termId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByTerm_Last(termId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("termId=");
		msg.append(termId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByTerm_Last(long termId,
		OrderByComparator<Video> orderByComparator) {
		int count = countByTerm(termId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByTerm(termId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where termId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByTerm_PrevAndNext(long videoId, long termId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByTerm_PrevAndNext(session, video, termId,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByTerm_PrevAndNext(session, video, termId,
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

	protected Video getByTerm_PrevAndNext(Session session, Video video,
		long termId, OrderByComparator<Video> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEO_WHERE);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(termId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where termId = &#63; from the database.
	 *
	 * @param termId the term ID
	 */
	@Override
	public void removeByTerm(long termId) {
		for (Video video : findByTerm(termId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByTerm(long termId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TERM;

		Object[] finderArgs = new Object[] { termId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

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

	private static final String _FINDER_COLUMN_TERM_TERMID_2 = "video.termId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VideoModelImpl.GROUPID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the videos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByGroup(long groupId, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByGroup(long groupId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((groupId != video.getGroupId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByGroup_First(long groupId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByGroup_First(groupId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByGroup_First(long groupId,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByGroup_Last(long groupId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByGroup_Last(groupId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByGroup_Last(long groupId,
		OrderByComparator<Video> orderByComparator) {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where groupId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByGroup_PrevAndNext(long videoId, long groupId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByGroup_PrevAndNext(session, video, groupId,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByGroup_PrevAndNext(session, video, groupId,
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

	protected Video getByGroup_PrevAndNext(Session session, Video video,
		long groupId, OrderByComparator<Video> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Video video : findByGroup(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "video.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			VideoModelImpl.COMPANYID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the videos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByCompany(long companyId) {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the videos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByCompany(long companyId, int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByCompany(long companyId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((companyId != video.getCompanyId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByCompany_First(long companyId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByCompany_First(companyId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByCompany_First(long companyId,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByCompany_Last(long companyId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByCompany_Last(companyId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByCompany_Last(long companyId,
		OrderByComparator<Video> orderByComparator) {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where companyId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByCompany_PrevAndNext(long videoId, long companyId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByCompany_PrevAndNext(session, video, companyId,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByCompany_PrevAndNext(session, video, companyId,
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

	protected Video getByCompany_PrevAndNext(Session session, Video video,
		long companyId, OrderByComparator<Video> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Video video : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANY;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "video.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDCOMPANY =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoModelImpl.GROUPID_COLUMN_BITMASK |
			VideoModelImpl.COMPANYID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDCOMPANY = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the videos where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByGroupAndCompany(long groupId, long companyId) {
		return findByGroupAndCompany(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	@Override
	public List<Video> findByGroupAndCompany(long groupId, long companyId,
		int start, int end) {
		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByGroupAndCompany(long groupId, long companyId,
		int start, int end, OrderByComparator<Video> orderByComparator) {
		return findByGroupAndCompany(groupId, companyId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching videos
	 */
	@Override
	public List<Video> findByGroupAndCompany(long groupId, long companyId,
		int start, int end, OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY;
			finderArgs = new Object[] { groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDCOMPANY;
			finderArgs = new Object[] {
					groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if ((groupId != video.getGroupId()) ||
							(companyId != video.getCompanyId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByGroupAndCompany_First(long groupId, long companyId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByGroupAndCompany_First(groupId, companyId,
				orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByGroupAndCompany_First(long groupId, long companyId,
		OrderByComparator<Video> orderByComparator) {
		List<Video> list = findByGroupAndCompany(groupId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByGroupAndCompany_Last(long groupId, long companyId,
		OrderByComparator<Video> orderByComparator) throws NoSuchVideoException {
		Video video = fetchByGroupAndCompany_Last(groupId, companyId,
				orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByGroupAndCompany_Last(long groupId, long companyId,
		OrderByComparator<Video> orderByComparator) {
		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByGroupAndCompany(groupId, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video[] findByGroupAndCompany_PrevAndNext(long videoId,
		long groupId, long companyId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(session, video,
					groupId, companyId, orderByComparator, true);

			array[1] = video;

			array[2] = getByGroupAndCompany_PrevAndNext(session, video,
					groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByGroupAndCompany_PrevAndNext(Session session,
		Video video, long groupId, long companyId,
		OrderByComparator<Video> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Video video : findByGroupAndCompany(groupId, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDCOMPANY;

		Object[] finderArgs = new Object[] { groupId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2 = "video.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 = "video.companyId = ?";

	public VideoPersistenceImpl() {
		setModelClass(Video.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

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
	 * Caches the video in the entity cache if it is enabled.
	 *
	 * @param video the video
	 */
	@Override
	public void cacheResult(Video video) {
		entityCache.putResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoImpl.class, video.getPrimaryKey(), video);

		video.resetOriginalValues();
	}

	/**
	 * Caches the videos in the entity cache if it is enabled.
	 *
	 * @param videos the videos
	 */
	@Override
	public void cacheResult(List<Video> videos) {
		for (Video video : videos) {
			if (entityCache.getResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
						VideoImpl.class, video.getPrimaryKey()) == null) {
				cacheResult(video);
			}
			else {
				video.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all videos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VideoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video video) {
		entityCache.removeResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoImpl.class, video.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video> videos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video video : videos) {
			entityCache.removeResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoImpl.class, video.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param videoId the primary key for the new video
	 * @return the new video
	 */
	@Override
	public Video create(long videoId) {
		Video video = new VideoImpl();

		video.setNew(true);
		video.setPrimaryKey(videoId);

		video.setCompanyId(companyProvider.getCompanyId());

		return video;
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the video
	 * @return the video that was removed
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video remove(long videoId) throws NoSuchVideoException {
		return remove((Serializable)videoId);
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video that was removed
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video remove(Serializable primaryKey) throws NoSuchVideoException {
		Session session = null;

		try {
			session = openSession();

			Video video = (Video)session.get(VideoImpl.class, primaryKey);

			if (video == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video);
		}
		catch (NoSuchVideoException nsee) {
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
	protected Video removeImpl(Video video) {
		video = toUnwrappedModel(video);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video)) {
				video = (Video)session.get(VideoImpl.class,
						video.getPrimaryKeyObj());
			}

			if (video != null) {
				session.delete(video);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video != null) {
			clearCache(video);
		}

		return video;
	}

	@Override
	public Video updateImpl(Video video) {
		video = toUnwrappedModel(video);

		boolean isNew = video.isNew();

		VideoModelImpl videoModelImpl = (VideoModelImpl)video;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (video.getCreateDate() == null)) {
			if (serviceContext == null) {
				video.setCreateDate(now);
			}
			else {
				video.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!videoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				video.setModifiedDate(now);
			}
			else {
				video.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (video.isNew()) {
				session.save(video);

				video.setNew(false);
			}
			else {
				video = (Video)session.merge(video);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!VideoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { videoModelImpl.getProducerId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER,
				args);

			args = new Object[] { videoModelImpl.getLectureseriesId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
				args);

			args = new Object[] {
					videoModelImpl.getProducerId(),
					videoModelImpl.getLectureseriesId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCERANDLECTURESERIES,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES,
				args);

			args = new Object[] {
					videoModelImpl.getProducerId(),
					videoModelImpl.getDownloadLink()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCERANDDOWNLOADLINK,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDDOWNLOADLINK,
				args);

			args = new Object[] {
					videoModelImpl.getLectureseriesId(),
					videoModelImpl.getOpenAccess()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS,
				args);

			args = new Object[] { videoModelImpl.getFilename() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FILENAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME,
				args);

			args = new Object[] { videoModelImpl.getUploadDate() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UPLOADDATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADDATE,
				args);

			args = new Object[] { videoModelImpl.getRootInstitutionId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ROOTINSTITUTION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTINSTITUTION,
				args);

			args = new Object[] { videoModelImpl.getPassword() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PASSWORD, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD,
				args);

			args = new Object[] { videoModelImpl.getOpenAccess() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_OPENACCESS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS,
				args);

			args = new Object[] { videoModelImpl.getTermId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TERM, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM,
				args);

			args = new Object[] { videoModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
				args);

			args = new Object[] { videoModelImpl.getCompanyId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
				args);

			args = new Object[] {
					videoModelImpl.getGroupId(), videoModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPANY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalProducerId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER,
					args);

				args = new Object[] { videoModelImpl.getProducerId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalLectureseriesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);

				args = new Object[] { videoModelImpl.getLectureseriesId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalProducerId(),
						videoModelImpl.getOriginalLectureseriesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCERANDLECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES,
					args);

				args = new Object[] {
						videoModelImpl.getProducerId(),
						videoModelImpl.getLectureseriesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCERANDLECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDDOWNLOADLINK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalProducerId(),
						videoModelImpl.getOriginalDownloadLink()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCERANDDOWNLOADLINK,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDDOWNLOADLINK,
					args);

				args = new Object[] {
						videoModelImpl.getProducerId(),
						videoModelImpl.getDownloadLink()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCERANDDOWNLOADLINK,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDDOWNLOADLINK,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalLectureseriesId(),
						videoModelImpl.getOriginalOpenAccess()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS,
					args);

				args = new Object[] {
						videoModelImpl.getLectureseriesId(),
						videoModelImpl.getOpenAccess()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalFilename()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FILENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME,
					args);

				args = new Object[] { videoModelImpl.getFilename() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FILENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalUploadDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UPLOADDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADDATE,
					args);

				args = new Object[] { videoModelImpl.getUploadDate() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UPLOADDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADDATE,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTINSTITUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalRootInstitutionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROOTINSTITUTION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTINSTITUTION,
					args);

				args = new Object[] { videoModelImpl.getRootInstitutionId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROOTINSTITUTION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTINSTITUTION,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalPassword()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PASSWORD, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD,
					args);

				args = new Object[] { videoModelImpl.getPassword() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PASSWORD, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PASSWORD,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalOpenAccess()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OPENACCESS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS,
					args);

				args = new Object[] { videoModelImpl.getOpenAccess() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OPENACCESS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { videoModelImpl.getOriginalTermId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TERM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM,
					args);

				args = new Object[] { videoModelImpl.getTermId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TERM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERM,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { videoModelImpl.getOriginalGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { videoModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { videoModelImpl.getCompanyId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalGroupId(),
						videoModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPANY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY,
					args);

				args = new Object[] {
						videoModelImpl.getGroupId(),
						videoModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPANY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY,
					args);
			}
		}

		entityCache.putResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoImpl.class, video.getPrimaryKey(), video, false);

		video.resetOriginalValues();

		return video;
	}

	protected Video toUnwrappedModel(Video video) {
		if (video instanceof VideoImpl) {
			return video;
		}

		VideoImpl videoImpl = new VideoImpl();

		videoImpl.setNew(video.isNew());
		videoImpl.setPrimaryKey(video.getPrimaryKey());

		videoImpl.setVideoId(video.getVideoId());
		videoImpl.setTitle(video.getTitle());
		videoImpl.setLectureseriesId(video.getLectureseriesId());
		videoImpl.setProducerId(video.getProducerId());
		videoImpl.setContainerFormat(video.getContainerFormat());
		videoImpl.setFilename(video.getFilename());
		videoImpl.setResolution(video.getResolution());
		videoImpl.setDuration(video.getDuration());
		videoImpl.setHostId(video.getHostId());
		videoImpl.setFileSize(video.getFileSize());
		videoImpl.setGenerationDate(video.getGenerationDate());
		videoImpl.setOpenAccess(video.getOpenAccess());
		videoImpl.setDownloadLink(video.getDownloadLink());
		videoImpl.setMetadataId(video.getMetadataId());
		videoImpl.setSecureFilename(video.getSecureFilename());
		videoImpl.setHits(video.getHits());
		videoImpl.setUploadDate(video.getUploadDate());
		videoImpl.setPermittedToSegment(video.getPermittedToSegment());
		videoImpl.setRootInstitutionId(video.getRootInstitutionId());
		videoImpl.setCitation2go(video.getCitation2go());
		videoImpl.setTermId(video.getTermId());
		videoImpl.setTags(video.getTags());
		videoImpl.setPassword(video.getPassword());
		videoImpl.setGroupId(video.getGroupId());
		videoImpl.setCompanyId(video.getCompanyId());
		videoImpl.setUserId(video.getUserId());
		videoImpl.setUserName(video.getUserName());
		videoImpl.setCreateDate(video.getCreateDate());
		videoImpl.setModifiedDate(video.getModifiedDate());

		return videoImpl;
	}

	/**
	 * Returns the video with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideoException {
		Video video = fetchByPrimaryKey(primaryKey);

		if (video == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video;
	}

	/**
	 * Returns the video with the primary key or throws a {@link NoSuchVideoException} if it could not be found.
	 *
	 * @param videoId the primary key of the video
	 * @return the video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video findByPrimaryKey(long videoId) throws NoSuchVideoException {
		return findByPrimaryKey((Serializable)videoId);
	}

	/**
	 * Returns the video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video, or <code>null</code> if a video with the primary key could not be found
	 */
	@Override
	public Video fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Video video = (Video)serializable;

		if (video == null) {
			Session session = null;

			try {
				session = openSession();

				video = (Video)session.get(VideoImpl.class, primaryKey);

				if (video != null) {
					cacheResult(video);
				}
				else {
					entityCache.putResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
						VideoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
					VideoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video;
	}

	/**
	 * Returns the video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoId the primary key of the video
	 * @return the video, or <code>null</code> if a video with the primary key could not be found
	 */
	@Override
	public Video fetchByPrimaryKey(long videoId) {
		return fetchByPrimaryKey((Serializable)videoId);
	}

	@Override
	public Map<Serializable, Video> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Video> map = new HashMap<Serializable, Video>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Video video = fetchByPrimaryKey(primaryKey);

			if (video != null) {
				map.put(primaryKey, video);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
					VideoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Video)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VIDEO_WHERE_PKS_IN);

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

			for (Video video : (List<Video>)q.list()) {
				map.put(video.getPrimaryKeyObj(), video);

				cacheResult(video);

				uncachedPrimaryKeys.remove(video.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
					VideoImpl.class, primaryKey, nullModel);
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
	 * Returns all the videos.
	 *
	 * @return the videos
	 */
	@Override
	public List<Video> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of videos
	 */
	@Override
	public List<Video> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of videos
	 */
	@Override
	public List<Video> findAll(int start, int end,
		OrderByComparator<Video> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of videos
	 */
	@Override
	public List<Video> findAll(int start, int end,
		OrderByComparator<Video> orderByComparator, boolean retrieveFromCache) {
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

		List<Video> list = null;

		if (retrieveFromCache) {
			list = (List<Video>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VIDEO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO;

				if (pagination) {
					sql = sql.concat(VideoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the videos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Video video : findAll()) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEO);

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
		return VideoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VideoImpl.class.getName());
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
	private static final String _SQL_SELECT_VIDEO = "SELECT video FROM Video video";
	private static final String _SQL_SELECT_VIDEO_WHERE_PKS_IN = "SELECT video FROM Video video WHERE videoId IN (";
	private static final String _SQL_SELECT_VIDEO_WHERE = "SELECT video FROM Video video WHERE ";
	private static final String _SQL_COUNT_VIDEO = "SELECT COUNT(video) FROM Video video";
	private static final String _SQL_COUNT_VIDEO_WHERE = "SELECT COUNT(video) FROM Video video WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(VideoPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"password"
			});
}