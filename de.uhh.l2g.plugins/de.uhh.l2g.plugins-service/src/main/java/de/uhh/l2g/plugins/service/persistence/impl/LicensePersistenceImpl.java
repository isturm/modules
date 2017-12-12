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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.impl.LicenseModelImpl;
import de.uhh.l2g.plugins.service.persistence.LicensePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LicensePersistence
 * @see de.uhh.l2g.plugins.service.persistence.LicenseUtil
 * @generated
 */
@ProviderType
public class LicensePersistenceImpl extends BasePersistenceImpl<License>
	implements LicensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LicenseUtil} to access the license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LicenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_VIDEO = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByVideo",
			new String[] { Long.class.getName() },
			LicenseModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns the license where videoId = &#63; or throws a {@link NoSuchLicenseException} if it could not be found.
	 *
	 * @param videoId the video ID
	 * @return the matching license
	 * @throws NoSuchLicenseException if a matching license could not be found
	 */
	@Override
	public License findByVideo(long videoId) throws NoSuchLicenseException {
		License license = fetchByVideo(videoId);

		if (license == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLicenseException(msg.toString());
		}

		return license;
	}

	/**
	 * Returns the license where videoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param videoId the video ID
	 * @return the matching license, or <code>null</code> if a matching license could not be found
	 */
	@Override
	public License fetchByVideo(long videoId) {
		return fetchByVideo(videoId, true);
	}

	/**
	 * Returns the license where videoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param videoId the video ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching license, or <code>null</code> if a matching license could not be found
	 */
	@Override
	public License fetchByVideo(long videoId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { videoId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_VIDEO,
					finderArgs, this);
		}

		if (result instanceof License) {
			License license = (License)result;

			if ((videoId != license.getVideoId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LICENSE_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				List<License> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_VIDEO,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LicensePersistenceImpl.fetchByVideo(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					License license = list.get(0);

					result = license;

					cacheResult(license);

					if ((license.getVideoId() != videoId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_VIDEO,
							finderArgs, license);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_VIDEO, finderArgs);

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
			return (License)result;
		}
	}

	/**
	 * Removes the license where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @return the license that was removed
	 */
	@Override
	public License removeByVideo(long videoId) throws NoSuchLicenseException {
		License license = findByVideo(videoId);

		return remove(license);
	}

	/**
	 * Returns the number of licenses where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching licenses
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICENSE_WHERE);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "license.videoId = ?";

	public LicensePersistenceImpl() {
		setModelClass(License.class);
	}

	/**
	 * Caches the license in the entity cache if it is enabled.
	 *
	 * @param license the license
	 */
	@Override
	public void cacheResult(License license) {
		entityCache.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseImpl.class, license.getPrimaryKey(), license);

		finderCache.putResult(FINDER_PATH_FETCH_BY_VIDEO,
			new Object[] { license.getVideoId() }, license);

		license.resetOriginalValues();
	}

	/**
	 * Caches the licenses in the entity cache if it is enabled.
	 *
	 * @param licenses the licenses
	 */
	@Override
	public void cacheResult(List<License> licenses) {
		for (License license : licenses) {
			if (entityCache.getResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
						LicenseImpl.class, license.getPrimaryKey()) == null) {
				cacheResult(license);
			}
			else {
				license.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all licenses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LicenseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the license.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(License license) {
		entityCache.removeResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseImpl.class, license.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LicenseModelImpl)license, true);
	}

	@Override
	public void clearCache(List<License> licenses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (License license : licenses) {
			entityCache.removeResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
				LicenseImpl.class, license.getPrimaryKey());

			clearUniqueFindersCache((LicenseModelImpl)license, true);
		}
	}

	protected void cacheUniqueFindersCache(LicenseModelImpl licenseModelImpl) {
		Object[] args = new Object[] { licenseModelImpl.getVideoId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_VIDEO, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_VIDEO, args,
			licenseModelImpl, false);
	}

	protected void clearUniqueFindersCache(LicenseModelImpl licenseModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { licenseModelImpl.getVideoId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_VIDEO, args);
		}

		if ((licenseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_VIDEO.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { licenseModelImpl.getOriginalVideoId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_VIDEO, args);
		}
	}

	/**
	 * Creates a new license with the primary key. Does not add the license to the database.
	 *
	 * @param licenseId the primary key for the new license
	 * @return the new license
	 */
	@Override
	public License create(long licenseId) {
		License license = new LicenseImpl();

		license.setNew(true);
		license.setPrimaryKey(licenseId);

		return license;
	}

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license that was removed
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	@Override
	public License remove(long licenseId) throws NoSuchLicenseException {
		return remove((Serializable)licenseId);
	}

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license that was removed
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	@Override
	public License remove(Serializable primaryKey)
		throws NoSuchLicenseException {
		Session session = null;

		try {
			session = openSession();

			License license = (License)session.get(LicenseImpl.class, primaryKey);

			if (license == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(license);
		}
		catch (NoSuchLicenseException nsee) {
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
	protected License removeImpl(License license) {
		license = toUnwrappedModel(license);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(license)) {
				license = (License)session.get(LicenseImpl.class,
						license.getPrimaryKeyObj());
			}

			if (license != null) {
				session.delete(license);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (license != null) {
			clearCache(license);
		}

		return license;
	}

	@Override
	public License updateImpl(License license) {
		license = toUnwrappedModel(license);

		boolean isNew = license.isNew();

		LicenseModelImpl licenseModelImpl = (LicenseModelImpl)license;

		Session session = null;

		try {
			session = openSession();

			if (license.isNew()) {
				session.save(license);

				license.setNew(false);
			}
			else {
				license = (License)session.merge(license);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LicenseModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseImpl.class, license.getPrimaryKey(), license, false);

		clearUniqueFindersCache(licenseModelImpl, false);
		cacheUniqueFindersCache(licenseModelImpl);

		license.resetOriginalValues();

		return license;
	}

	protected License toUnwrappedModel(License license) {
		if (license instanceof LicenseImpl) {
			return license;
		}

		LicenseImpl licenseImpl = new LicenseImpl();

		licenseImpl.setNew(license.isNew());
		licenseImpl.setPrimaryKey(license.getPrimaryKey());

		licenseImpl.setLicenseId(license.getLicenseId());
		licenseImpl.setVideoId(license.getVideoId());
		licenseImpl.setCcby(license.getCcby());
		licenseImpl.setCcbybc(license.getCcbybc());
		licenseImpl.setCcbyncnd(license.getCcbyncnd());
		licenseImpl.setCcbyncsa(license.getCcbyncsa());
		licenseImpl.setCcbysa(license.getCcbysa());
		licenseImpl.setCcbync(license.getCcbync());
		licenseImpl.setL2go(license.getL2go());

		return licenseImpl;
	}

	/**
	 * Returns the license with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	@Override
	public License findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLicenseException {
		License license = fetchByPrimaryKey(primaryKey);

		if (license == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return license;
	}

	/**
	 * Returns the license with the primary key or throws a {@link NoSuchLicenseException} if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	@Override
	public License findByPrimaryKey(long licenseId)
		throws NoSuchLicenseException {
		return findByPrimaryKey((Serializable)licenseId);
	}

	/**
	 * Returns the license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license, or <code>null</code> if a license with the primary key could not be found
	 */
	@Override
	public License fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
				LicenseImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		License license = (License)serializable;

		if (license == null) {
			Session session = null;

			try {
				session = openSession();

				license = (License)session.get(LicenseImpl.class, primaryKey);

				if (license != null) {
					cacheResult(license);
				}
				else {
					entityCache.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
						LicenseImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
					LicenseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return license;
	}

	/**
	 * Returns the license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license, or <code>null</code> if a license with the primary key could not be found
	 */
	@Override
	public License fetchByPrimaryKey(long licenseId) {
		return fetchByPrimaryKey((Serializable)licenseId);
	}

	@Override
	public Map<Serializable, License> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, License> map = new HashMap<Serializable, License>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			License license = fetchByPrimaryKey(primaryKey);

			if (license != null) {
				map.put(primaryKey, license);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
					LicenseImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (License)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LICENSE_WHERE_PKS_IN);

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

			for (License license : (List<License>)q.list()) {
				map.put(license.getPrimaryKeyObj(), license);

				cacheResult(license);

				uncachedPrimaryKeys.remove(license.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
					LicenseImpl.class, primaryKey, nullModel);
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
	 * Returns all the licenses.
	 *
	 * @return the licenses
	 */
	@Override
	public List<License> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of licenses
	 */
	@Override
	public List<License> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licenses
	 */
	@Override
	public List<License> findAll(int start, int end,
		OrderByComparator<License> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of licenses
	 */
	@Override
	public List<License> findAll(int start, int end,
		OrderByComparator<License> orderByComparator, boolean retrieveFromCache) {
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

		List<License> list = null;

		if (retrieveFromCache) {
			list = (List<License>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LICENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LICENSE;

				if (pagination) {
					sql = sql.concat(LicenseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<License>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<License>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the licenses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (License license : findAll()) {
			remove(license);
		}
	}

	/**
	 * Returns the number of licenses.
	 *
	 * @return the number of licenses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LICENSE);

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
		return LicenseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the license persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LicenseImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LICENSE = "SELECT license FROM License license";
	private static final String _SQL_SELECT_LICENSE_WHERE_PKS_IN = "SELECT license FROM License license WHERE licenseId IN (";
	private static final String _SQL_SELECT_LICENSE_WHERE = "SELECT license FROM License license WHERE ";
	private static final String _SQL_COUNT_LICENSE = "SELECT COUNT(license) FROM License license";
	private static final String _SQL_COUNT_LICENSE_WHERE = "SELECT COUNT(license) FROM License license WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "license.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No License exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No License exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LicensePersistenceImpl.class);
}