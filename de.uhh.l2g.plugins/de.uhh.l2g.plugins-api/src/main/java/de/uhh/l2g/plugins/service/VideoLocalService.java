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

package de.uhh.l2g.plugins.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.exception.NoSuchVideoException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Video;

import org.json.JSONArray;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Video. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Iavor Sturm
 * @see VideoLocalServiceUtil
 * @see de.uhh.l2g.plugins.service.base.VideoLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.VideoLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VideoLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoLocalServiceUtil} to access the video local service. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.VideoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the video to the database. Also notifies the appropriate model listeners.
	*
	* @param video the video
	* @return the video that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Video addVideo(Video video);

	/**
	* Creates a new video with the primary key. Does not add the video to the database.
	*
	* @param videoId the primary key for the new video
	* @return the new video
	*/
	public Video createVideo(long videoId);

	/**
	* Deletes the video from the database. Also notifies the appropriate model listeners.
	*
	* @param video the video
	* @return the video that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Video deleteVideo(Video video);

	/**
	* Deletes the video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the video
	* @return the video that was removed
	* @throws PortalException if a video with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Video deleteVideo(long videoId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Video fetchVideo(long videoId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Video getBySecureUrl(java.lang.String surl)
		throws SystemException, NoSuchVideoException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Video getFullVideo(java.lang.Long videoId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Video getLatestOpenAccessVideoForLectureseries(
		java.lang.Long lectureseriesId);

	/**
	* Returns the video with the primary key.
	*
	* @param videoId the primary key of the video
	* @return the video
	* @throws PortalException if a video with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Video getVideo(long videoId) throws PortalException;

	/**
	* Updates the video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param video the video
	* @return the video that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Video updateVideo(Video video);

	/**
	* Returns the number of videos.
	*
	* @return the number of videos
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVideosCount();

	public int unlinkLectureseriesFromVideos(java.lang.Long lectureseriesId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.Long getLatestClosedAccessVideoId(
		java.lang.Long lectureseriesId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getAll() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByAllSearchWords() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByFilename(java.lang.String filename)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByHits();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByHits(java.lang.Long hits);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByHitsAndOpenAccess(java.lang.Long hits);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByLectureseries(java.lang.Long lectureseriesId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByLectureseriesAndOpenaccess(
		java.lang.Long lectureseriesId, int openAccess)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByOpenAccess(int bool) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByProducer(java.lang.Long producerId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByProducerAndDownloadLink(java.lang.Long producerId,
		int downloadLink) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByProducerAndLectureseries(
		java.lang.Long producerId, java.lang.Long lectureseriesId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByRootInstitution(java.lang.Long rootInstitutionId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getBySearchWord(java.lang.String word, int limit)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getBySearchWordAndLectureseriesId(
		java.lang.String word, java.lang.Long lectureseriesId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByTerm(java.lang.Long termId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getLatestVideos();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getPopular(int limit);

	/**
	* Returns a range of all the videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of videos
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getVideos(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getJSONVideo(java.lang.Long videoId);

	/**
	* required properties for jwplayer in portal-ext.properties file
	*
	* [host]=configured host in database (automatically e.g. streaming.server.com)
	* [ext]=file extension (automatically e.g mp3)
	* [l2go_path]=generated lecture2go file path (automatically e.g. 3l2gproducer1)
	* [filename]=video file name (automatically e.g 00.000_video_2015-06-08_08-06.mp4)
	* [protocol]=host protocol (automatically e.g rtmpt)
	* [port]=host port (automatically e.g 80)
	* [smilfile]=adaptive streaming file
	*
	* example for lecture2go configuration
	* lecture2go.uri1.player.template=https://[host]/vod/_definst/smil:[l2go_path]/[smilfile]/playlist.m3u8
	* lecture2go.uri2.player.template=https://[host]/vod/_definst/[ext]:[l2go_path]/[filename]/playlist.m3u8
	* lecture2go.uri3.player.template=rtmpt://[host]/vod/_definst/[ext]:[l2go_path]/[filename]
	* lecture2go.uri4.player.template=${lecture2go.downloadserver.web.root}/abo/[filename]
	* lecture2go.uri5.player.template=rtsp://[host]:[port]/vod/_definst/[ext]:[l2go_path]/[filename]
	*/
	public void addPlayerUris2Video(Host host, Video video, Producer producer);

	public void createLastVideoList() throws SystemException;
}