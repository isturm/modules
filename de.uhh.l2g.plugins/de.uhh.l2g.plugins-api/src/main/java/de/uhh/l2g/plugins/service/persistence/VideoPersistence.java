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

package de.uhh.l2g.plugins.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.exception.NoSuchVideoException;
import de.uhh.l2g.plugins.model.Video;

import java.util.Date;

/**
 * The persistence interface for the video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.persistence.impl.VideoPersistenceImpl
 * @see VideoUtil
 * @generated
 */
@ProviderType
public interface VideoPersistence extends BasePersistence<Video> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoUtil} to access the video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the videos where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the matching videos
	*/
	public java.util.List<Video> findByProducer(long producerId);

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
	public java.util.List<Video> findByProducer(long producerId, int start,
		int end);

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
	public java.util.List<Video> findByProducer(long producerId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByProducer(long producerId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByProducer_First(long producerId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByProducer_First(long producerId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByProducer_Last(long producerId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByProducer_Last(long producerId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where producerId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByProducer_PrevAndNext(long videoId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where producerId = &#63; from the database.
	*
	* @param producerId the producer ID
	*/
	public void removeByProducer(long producerId);

	/**
	* Returns the number of videos where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the number of matching videos
	*/
	public int countByProducer(long producerId);

	/**
	* Returns all the videos where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching videos
	*/
	public java.util.List<Video> findByLectureseries(long lectureseriesId);

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
	public java.util.List<Video> findByLectureseries(long lectureseriesId,
		int start, int end);

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
	public java.util.List<Video> findByLectureseries(long lectureseriesId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByLectureseries(long lectureseriesId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByLectureseries_First(long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByLectureseries_First(long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByLectureseries_Last(long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByLectureseries_Last(long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where lectureseriesId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByLectureseries_PrevAndNext(long videoId,
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	*/
	public void removeByLectureseries(long lectureseriesId);

	/**
	* Returns the number of videos where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching videos
	*/
	public int countByLectureseries(long lectureseriesId);

	/**
	* Returns all the videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @return the matching videos
	*/
	public java.util.List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId);

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
	public java.util.List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end);

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
	public java.util.List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByProducerAndLectureseries_First(long producerId,
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByProducerAndLectureseries_First(long producerId,
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByProducerAndLectureseries_Last(long producerId,
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByProducerAndLectureseries_Last(long producerId,
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public Video[] findByProducerAndLectureseries_PrevAndNext(long videoId,
		long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where producerId = &#63; and lectureseriesId = &#63; from the database.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	*/
	public void removeByProducerAndLectureseries(long producerId,
		long lectureseriesId);

	/**
	* Returns the number of videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching videos
	*/
	public int countByProducerAndLectureseries(long producerId,
		long lectureseriesId);

	/**
	* Returns all the videos where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @return the matching videos
	*/
	public java.util.List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink);

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
	public java.util.List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end);

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
	public java.util.List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByProducerAndDownloadLink_First(long producerId,
		int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByProducerAndDownloadLink_First(long producerId,
		int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByProducerAndDownloadLink_Last(long producerId,
		int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByProducerAndDownloadLink_Last(long producerId,
		int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public Video[] findByProducerAndDownloadLink_PrevAndNext(long videoId,
		long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where producerId = &#63; and downloadLink = &#63; from the database.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	*/
	public void removeByProducerAndDownloadLink(long producerId,
		int downloadLink);

	/**
	* Returns the number of videos where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @return the number of matching videos
	*/
	public int countByProducerAndDownloadLink(long producerId, int downloadLink);

	/**
	* Returns all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @return the matching videos
	*/
	public java.util.List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess);

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
	public java.util.List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end);

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
	public java.util.List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByLectureseriesAndOpenaccess_First(long lectureseriesId,
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByLectureseriesAndOpenaccess_First(long lectureseriesId,
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByLectureseriesAndOpenaccess_Last(long lectureseriesId,
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByLectureseriesAndOpenaccess_Last(long lectureseriesId,
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public Video[] findByLectureseriesAndOpenaccess_PrevAndNext(long videoId,
		long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where lectureseriesId = &#63; and openAccess = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	*/
	public void removeByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess);

	/**
	* Returns the number of videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @return the number of matching videos
	*/
	public int countByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess);

	/**
	* Returns all the videos where filename = &#63;.
	*
	* @param filename the filename
	* @return the matching videos
	*/
	public java.util.List<Video> findByFilename(java.lang.String filename);

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
	public java.util.List<Video> findByFilename(java.lang.String filename,
		int start, int end);

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
	public java.util.List<Video> findByFilename(java.lang.String filename,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByFilename(java.lang.String filename,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByFilename_First(java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByFilename_First(java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByFilename_Last(java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByFilename_Last(java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where filename = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByFilename_PrevAndNext(long videoId,
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where filename = &#63; from the database.
	*
	* @param filename the filename
	*/
	public void removeByFilename(java.lang.String filename);

	/**
	* Returns the number of videos where filename = &#63;.
	*
	* @param filename the filename
	* @return the number of matching videos
	*/
	public int countByFilename(java.lang.String filename);

	/**
	* Returns all the videos where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @return the matching videos
	*/
	public java.util.List<Video> findByUploadDate(Date uploadDate);

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
	public java.util.List<Video> findByUploadDate(Date uploadDate, int start,
		int end);

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
	public java.util.List<Video> findByUploadDate(Date uploadDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByUploadDate(Date uploadDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByUploadDate_First(Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByUploadDate_First(Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByUploadDate_Last(Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByUploadDate_Last(Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where uploadDate = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByUploadDate_PrevAndNext(long videoId, Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where uploadDate = &#63; from the database.
	*
	* @param uploadDate the upload date
	*/
	public void removeByUploadDate(Date uploadDate);

	/**
	* Returns the number of videos where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @return the number of matching videos
	*/
	public int countByUploadDate(Date uploadDate);

	/**
	* Returns all the videos where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @return the matching videos
	*/
	public java.util.List<Video> findByRootInstitution(long rootInstitutionId);

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
	public java.util.List<Video> findByRootInstitution(long rootInstitutionId,
		int start, int end);

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
	public java.util.List<Video> findByRootInstitution(long rootInstitutionId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByRootInstitution(long rootInstitutionId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByRootInstitution_First(long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByRootInstitution_First(long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByRootInstitution_Last(long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByRootInstitution_Last(long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByRootInstitution_PrevAndNext(long videoId,
		long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where rootInstitutionId = &#63; from the database.
	*
	* @param rootInstitutionId the root institution ID
	*/
	public void removeByRootInstitution(long rootInstitutionId);

	/**
	* Returns the number of videos where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @return the number of matching videos
	*/
	public int countByRootInstitution(long rootInstitutionId);

	/**
	* Returns all the videos where password = &#63;.
	*
	* @param password the password
	* @return the matching videos
	*/
	public java.util.List<Video> findByPassword(java.lang.String password);

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
	public java.util.List<Video> findByPassword(java.lang.String password,
		int start, int end);

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
	public java.util.List<Video> findByPassword(java.lang.String password,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByPassword(java.lang.String password,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByPassword_First(java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByPassword_First(java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByPassword_Last(java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByPassword_Last(java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where password = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByPassword_PrevAndNext(long videoId,
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where password = &#63; from the database.
	*
	* @param password the password
	*/
	public void removeByPassword(java.lang.String password);

	/**
	* Returns the number of videos where password = &#63;.
	*
	* @param password the password
	* @return the number of matching videos
	*/
	public int countByPassword(java.lang.String password);

	/**
	* Returns all the videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the matching videos
	*/
	public java.util.List<Video> findByOpenAccess(int openAccess);

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
	public java.util.List<Video> findByOpenAccess(int openAccess, int start,
		int end);

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
	public java.util.List<Video> findByOpenAccess(int openAccess, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByOpenAccess(int openAccess, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByOpenAccess_First(int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByOpenAccess_First(int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByOpenAccess_Last(int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByOpenAccess_Last(int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where openAccess = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByOpenAccess_PrevAndNext(long videoId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where openAccess = &#63; from the database.
	*
	* @param openAccess the open access
	*/
	public void removeByOpenAccess(int openAccess);

	/**
	* Returns the number of videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the number of matching videos
	*/
	public int countByOpenAccess(int openAccess);

	/**
	* Returns all the videos where termId = &#63;.
	*
	* @param termId the term ID
	* @return the matching videos
	*/
	public java.util.List<Video> findByTerm(long termId);

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
	public java.util.List<Video> findByTerm(long termId, int start, int end);

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
	public java.util.List<Video> findByTerm(long termId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByTerm(long termId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByTerm_First(long termId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByTerm_First(long termId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByTerm_Last(long termId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByTerm_Last(long termId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where termId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByTerm_PrevAndNext(long videoId, long termId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where termId = &#63; from the database.
	*
	* @param termId the term ID
	*/
	public void removeByTerm(long termId);

	/**
	* Returns the number of videos where termId = &#63;.
	*
	* @param termId the term ID
	* @return the number of matching videos
	*/
	public int countByTerm(long termId);

	/**
	* Returns all the videos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching videos
	*/
	public java.util.List<Video> findByGroup(long groupId);

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
	public java.util.List<Video> findByGroup(long groupId, int start, int end);

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
	public java.util.List<Video> findByGroup(long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByGroup(long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where groupId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByGroup_PrevAndNext(long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroup(long groupId);

	/**
	* Returns the number of videos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching videos
	*/
	public int countByGroup(long groupId);

	/**
	* Returns all the videos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching videos
	*/
	public java.util.List<Video> findByCompany(long companyId);

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
	public java.util.List<Video> findByCompany(long companyId, int start,
		int end);

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
	public java.util.List<Video> findByCompany(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByCompany(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByCompany_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByCompany_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByCompany_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByCompany_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where companyId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByCompany_PrevAndNext(long videoId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompany(long companyId);

	/**
	* Returns the number of videos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching videos
	*/
	public int countByCompany(long companyId);

	/**
	* Returns all the videos where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching videos
	*/
	public java.util.List<Video> findByGroupAndCompany(long groupId,
		long companyId);

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
	public java.util.List<Video> findByGroupAndCompany(long groupId,
		long companyId, int start, int end);

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
	public java.util.List<Video> findByGroupAndCompany(long groupId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByGroupAndCompany(long groupId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByGroupAndCompany_First(long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByGroupAndCompany_First(long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByGroupAndCompany_Last(long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByGroupAndCompany_Last(long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public Video[] findByGroupAndCompany_PrevAndNext(long videoId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	*/
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	* Returns the number of videos where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching videos
	*/
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	* Returns all the videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the matching videos
	*/
	public java.util.List<Video> findByOpenAccessAndUploadedFile(int openAccess);

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
	public java.util.List<Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end);

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
	public java.util.List<Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByOpenAccessAndUploadedFile_First(int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByOpenAccessAndUploadedFile_First(int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws NoSuchVideoException if a matching video could not be found
	*/
	public Video findByOpenAccessAndUploadedFile_Last(int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	*/
	public Video fetchByOpenAccessAndUploadedFile_Last(int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

	/**
	* Returns the videos before and after the current video in the ordered set where openAccess = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video[] findByOpenAccessAndUploadedFile_PrevAndNext(long videoId,
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException;

	/**
	* Removes all the videos where openAccess = &#63; from the database.
	*
	* @param openAccess the open access
	*/
	public void removeByOpenAccessAndUploadedFile(int openAccess);

	/**
	* Returns the number of videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the number of matching videos
	*/
	public int countByOpenAccessAndUploadedFile(int openAccess);

	/**
	* Caches the video in the entity cache if it is enabled.
	*
	* @param video the video
	*/
	public void cacheResult(Video video);

	/**
	* Caches the videos in the entity cache if it is enabled.
	*
	* @param videos the videos
	*/
	public void cacheResult(java.util.List<Video> videos);

	/**
	* Creates a new video with the primary key. Does not add the video to the database.
	*
	* @param videoId the primary key for the new video
	* @return the new video
	*/
	public Video create(long videoId);

	/**
	* Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the video
	* @return the video that was removed
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video remove(long videoId) throws NoSuchVideoException;

	public Video updateImpl(Video video);

	/**
	* Returns the video with the primary key or throws a {@link NoSuchVideoException} if it could not be found.
	*
	* @param videoId the primary key of the video
	* @return the video
	* @throws NoSuchVideoException if a video with the primary key could not be found
	*/
	public Video findByPrimaryKey(long videoId) throws NoSuchVideoException;

	/**
	* Returns the video with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoId the primary key of the video
	* @return the video, or <code>null</code> if a video with the primary key could not be found
	*/
	public Video fetchByPrimaryKey(long videoId);

	@Override
	public java.util.Map<java.io.Serializable, Video> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the videos.
	*
	* @return the videos
	*/
	public java.util.List<Video> findAll();

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
	public java.util.List<Video> findAll(int start, int end);

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
	public java.util.List<Video> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator);

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
	public java.util.List<Video> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the videos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of videos.
	*
	* @return the number of videos
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}