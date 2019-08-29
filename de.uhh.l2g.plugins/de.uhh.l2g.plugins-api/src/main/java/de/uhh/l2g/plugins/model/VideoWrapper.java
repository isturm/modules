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

package de.uhh.l2g.plugins.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Video}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video
 * @generated
 */
@ProviderType
public class VideoWrapper implements Video, ModelWrapper<Video> {

	public VideoWrapper(Video video) {
		_video = video;
	}

	@Override
	public Class<?> getModelClass() {
		return Video.class;
	}

	@Override
	public String getModelClassName() {
		return Video.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoId", getVideoId());
		attributes.put("title", getTitle());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("producerId", getProducerId());
		attributes.put("containerFormat", getContainerFormat());
		attributes.put("filename", getFilename());
		attributes.put("resolution", getResolution());
		attributes.put("duration", getDuration());
		attributes.put("hostId", getHostId());
		attributes.put("fileSize", getFileSize());
		attributes.put("generationDate", getGenerationDate());
		attributes.put("openAccess", getOpenAccess());
		attributes.put("downloadLink", getDownloadLink());
		attributes.put("metadataId", getMetadataId());
		attributes.put("secureFilename", getSecureFilename());
		attributes.put("hits", getHits());
		attributes.put("uploadDate", getUploadDate());
		attributes.put("permittedToSegment", getPermittedToSegment());
		attributes.put("rootInstitutionId", getRootInstitutionId());
		attributes.put("citation2go", getCitation2go());
		attributes.put("termId", getTermId());
		attributes.put("tags", getTags());
		attributes.put("password", getPassword());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}

		String containerFormat = (String)attributes.get("containerFormat");

		if (containerFormat != null) {
			setContainerFormat(containerFormat);
		}

		String filename = (String)attributes.get("filename");

		if (filename != null) {
			setFilename(filename);
		}

		String resolution = (String)attributes.get("resolution");

		if (resolution != null) {
			setResolution(resolution);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		String generationDate = (String)attributes.get("generationDate");

		if (generationDate != null) {
			setGenerationDate(generationDate);
		}

		Integer openAccess = (Integer)attributes.get("openAccess");

		if (openAccess != null) {
			setOpenAccess(openAccess);
		}

		Integer downloadLink = (Integer)attributes.get("downloadLink");

		if (downloadLink != null) {
			setDownloadLink(downloadLink);
		}

		Long metadataId = (Long)attributes.get("metadataId");

		if (metadataId != null) {
			setMetadataId(metadataId);
		}

		String secureFilename = (String)attributes.get("secureFilename");

		if (secureFilename != null) {
			setSecureFilename(secureFilename);
		}

		Long hits = (Long)attributes.get("hits");

		if (hits != null) {
			setHits(hits);
		}

		Date uploadDate = (Date)attributes.get("uploadDate");

		if (uploadDate != null) {
			setUploadDate(uploadDate);
		}

		Integer permittedToSegment = (Integer)attributes.get(
			"permittedToSegment");

		if (permittedToSegment != null) {
			setPermittedToSegment(permittedToSegment);
		}

		Long rootInstitutionId = (Long)attributes.get("rootInstitutionId");

		if (rootInstitutionId != null) {
			setRootInstitutionId(rootInstitutionId);
		}

		Integer citation2go = (Integer)attributes.get("citation2go");

		if (citation2go != null) {
			setCitation2go(citation2go);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new VideoWrapper((Video)_video.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Video video) {
		return _video.compareTo(video);
	}

	@Override
	public Integer getAccessPermitted() {
		return _video.getAccessPermitted();
	}

	@Override
	public String getBitrate() {
		return _video.getBitrate();
	}

	/**
	 * Returns the citation2go of this video.
	 *
	 * @return the citation2go of this video
	 */
	@Override
	public int getCitation2go() {
		return _video.getCitation2go();
	}

	/**
	 * Returns the company ID of this video.
	 *
	 * @return the company ID of this video
	 */
	@Override
	public long getCompanyId() {
		return _video.getCompanyId();
	}

	/**
	 * Returns the container format of this video.
	 *
	 * @return the container format of this video
	 */
	@Override
	public String getContainerFormat() {
		return _video.getContainerFormat();
	}

	/**
	 * Returns the create date of this video.
	 *
	 * @return the create date of this video
	 */
	@Override
	public Date getCreateDate() {
		return _video.getCreateDate();
	}

	@Override
	public String getCreatorFullName() {
		return _video.getCreatorFullName();
	}

	@Override
	public String getCreators() {
		return _video.getCreators();
	}

	/**
	 * Returns the current file name depending on openaccess field
	 */
	@Override
	public String getCurrentFilename() {
		return _video.getCurrentFilename();
	}

	/**
	 * Returns the current filename of the video with a reasonable _bitrate_, this is either the original file or, if multiple qualities are
	 * referenced from a _smil_ file, the version with the download suffix.
	 * Checks if prefix is _openaccess_ or secure and returns the correct one.
	 */
	@Override
	public String getCurrentMp4FilenameWithReasonableBitrate() {
		return _video.getCurrentMp4FilenameWithReasonableBitrate();
	}

	/**
	 * Returns the current file prefix depending on openaccess field
	 */
	@Override
	public String getCurrentPrefix() {
		return _video.getCurrentPrefix();
	}

	/**
	 * Returns the current URL depending on the openaccess field
	 */
	@Override
	public String getCurrentURL() {
		return _video.getCurrentURL();
	}

	/**
	 * Returns the formatted generation date with time
	 */
	@Override
	public String getDate() {
		return _video.getDate();
	}

	/**
	 * Returns the download link of this video.
	 *
	 * @return the download link of this video
	 */
	@Override
	public int getDownloadLink() {
		return _video.getDownloadLink();
	}

	/**
	 * Returns the duration of this video.
	 *
	 * @return the duration of this video
	 */
	@Override
	public String getDuration() {
		return _video.getDuration();
	}

	/**
	 * Returns the complete embed code for commsy depending on the openaccess field
	 */
	@Override
	public String getEmbedCommsy() {
		return _video.getEmbedCommsy();
	}

	/**
	 * Returns the complete html5 embed code depending on the openaccess field and container format
	 */
	@Override
	public String getEmbedHtml5() {
		return _video.getEmbedHtml5();
	}

	/**
	 * Returns the complete iframe embed code (usable for openaccess and non-openaccess videos)
	 */
	@Override
	public String getEmbedIframe() {
		return _video.getEmbedIframe();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _video.getExpandoBridge();
	}

	/**
	 * Returns the filename of this video.
	 *
	 * @return the filename of this video
	 */
	@Override
	public String getFilename() {
		return _video.getFilename();
	}

	/**
	 * Returns the file size of this video.
	 *
	 * @return the file size of this video
	 */
	@Override
	public String getFileSize() {
		return _video.getFileSize();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getFlvDownloadLink() {
		return _video.getFlvDownloadLink();
	}

	/**
	 * Returns the flv file (unchecked if existing)
	 */
	@Override
	public java.io.File getFlvFile() {
		return _video.getFlvFile();
	}

	@Override
	public String getFlvRssLink() {
		return _video.getFlvRssLink();
	}

	/**
	 * Returns the generation date of this video.
	 *
	 * @return the generation date of this video
	 */
	@Override
	public String getGenerationDate() {
		return _video.getGenerationDate();
	}

	/**
	 * Returns the group ID of this video.
	 *
	 * @return the group ID of this video
	 */
	@Override
	public long getGroupId() {
		return _video.getGroupId();
	}

	/**
	 * Returns the hits of this video.
	 *
	 * @return the hits of this video
	 */
	@Override
	public long getHits() {
		return _video.getHits();
	}

	@Override
	public de.uhh.l2g.plugins.model.Host getHost() {
		return _video.getHost();
	}

	/**
	 * Returns the host ID of this video.
	 *
	 * @return the host ID of this video
	 */
	@Override
	public long getHostId() {
		return _video.getHostId();
	}

	/**
	 * Returns the image in original size (checks which file should be used (thumbnail, audio, ... ))
	 */
	@Override
	public String getImage() {
		return _video.getImage();
	}

	/**
	 * Returns the image in medium size (checks which file should be used (thumbnail, audio, ... ))
	 */
	@Override
	public String getImageMedium() {
		return _video.getImageMedium();
	}

	/**
	 * Returns the image in small size (checks which file should be used (thumbnail, audio, ... ))
	 */
	@Override
	public String getImageSmall() {
		return _video.getImageSmall();
	}

	/**
	 * Returns and sets the URIs for the video player as a JSONAray
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray getJsonPlayerTracks() {
		return _video.getJsonPlayerTracks();
	}

	/**
	 * Returns and sets the URIs for the video player as a JSONAray
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray getJsonPlayerUris() {
		return _video.getJsonPlayerUris();
	}

	/**
	 * Returns the lectureseries ID of this video.
	 *
	 * @return the lectureseries ID of this video
	 */
	@Override
	public long getLectureseriesId() {
		return _video.getLectureseriesId();
	}

	@Override
	public String getLectureseriesName() {
		return _video.getLectureseriesName();
	}

	@Override
	public String getLectureseriesNumber() {
		return _video.getLectureseriesNumber();
	}

	/**
	 * Returns the complete URL to the lectureseries of this video
	 */
	@Override
	public String getLectureseriesUrl() {
		return _video.getLectureseriesUrl();
	}

	@Override
	public String getLinkedCreators() {
		return _video.getLinkedCreators();
	}

	/**
	 * Returns the download link to the audio file depending on the openaccess field
	 */
	@Override
	public String getM4aDownloadLink() {
		return _video.getM4aDownloadLink();
	}

	/**
	 * Returns the m4a file (unchecked if existing)
	 */
	@Override
	public java.io.File getM4aFile() {
		return _video.getM4aFile();
	}

	@Override
	public String getM4aRssLink() {
		return _video.getM4aRssLink();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getM4vDownloadLink() {
		return _video.getM4vDownloadLink();
	}

	/**
	 * Returns the m4v file (unchecked if existing)
	 */
	@Override
	public java.io.File getM4vFile() {
		return _video.getM4vFile();
	}

	@Override
	public String getM4vRssLink() {
		return _video.getM4vRssLink();
	}

	/**
	 * Returns the metadata ID of this video.
	 *
	 * @return the metadata ID of this video
	 */
	@Override
	public long getMetadataId() {
		return _video.getMetadataId();
	}

	/**
	 * Returns the modified date of this video.
	 *
	 * @return the modified date of this video
	 */
	@Override
	public Date getModifiedDate() {
		return _video.getModifiedDate();
	}

	/**
	 * Returns the download link to the audio file depending on the openaccess field
	 */
	@Override
	public String getMp3DownloadLink() {
		return _video.getMp3DownloadLink();
	}

	/**
	 * Returns the mp3 file (unchecked if existing)
	 */
	@Override
	public java.io.File getMp3File() {
		return _video.getMp3File();
	}

	@Override
	public String getMp3RssLink() {
		return _video.getMp3RssLink();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getMp4DownloadLink() {
		return _video.getMp4DownloadLink();
	}

	/**
	 * Returns the mp4 file (unchecked if existing)
	 */
	@Override
	public java.io.File getMp4File() {
		return _video.getMp4File();
	}

	/**
	 * Returns the _openaccess_ filename of the video with a reasonable _bitrate_, this is either the original file or, if multiple qualities are
	 * referenced from a _smil_ file, the version with the download suffix.
	 */
	@Override
	public String getMp4FilenameWithReasonableBitrate() {
		return _video.getMp4FilenameWithReasonableBitrate();
	}

	@Override
	public String getMp4RssLink() {
		return _video.getMp4RssLink();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getOggDownloadLink() {
		return _video.getOggDownloadLink();
	}

	/**
	 * Returns the ogg file (unchecked if existing)
	 */
	@Override
	public java.io.File getOggFile() {
		return _video.getOggFile();
	}

	@Override
	public String getOggRssLink() {
		return _video.getOggRssLink();
	}

	/**
	 * Returns the open access of this video.
	 *
	 * @return the open access of this video
	 */
	@Override
	public int getOpenAccess() {
		return _video.getOpenAccess();
	}

	/**
	 * Returns the password of this video.
	 *
	 * @return the password of this video
	 */
	@Override
	public String getPassword() {
		return _video.getPassword();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getPdfDownloadLink() {
		return _video.getPdfDownloadLink();
	}

	/**
	 * Returns the pdf file (unchecked if existing)
	 */
	@Override
	public java.io.File getPdfFile() {
		return _video.getPdfFile();
	}

	/**
	 * Returns the permitted to segment of this video.
	 *
	 * @return the permitted to segment of this video
	 */
	@Override
	public int getPermittedToSegment() {
		return _video.getPermittedToSegment();
	}

	@Override
	public java.util.ArrayList<String> getPlayerUris() {
		return _video.getPlayerUris();
	}

	/**
	 * Returns the open access prefix of the file (filename without extension)
	 */
	@Override
	public String getPreffix() {
		return _video.getPreffix();
	}

	/**
	 * Returns the primary key of this video.
	 *
	 * @return the primary key of this video
	 */
	@Override
	public long getPrimaryKey() {
		return _video.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _video.getPrimaryKeyObj();
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer getProducer() {
		return _video.getProducer();
	}

	/**
	 * Returns the producer ID of this video.
	 *
	 * @return the producer ID of this video
	 */
	@Override
	public long getProducerId() {
		return _video.getProducerId();
	}

	/**
	 * Returns the resolution of this video.
	 *
	 * @return the resolution of this video
	 */
	@Override
	public String getResolution() {
		return _video.getResolution();
	}

	/**
	 * Returns the root institution ID of this video.
	 *
	 * @return the root institution ID of this video
	 */
	@Override
	public long getRootInstitutionId() {
		return _video.getRootInstitutionId();
	}

	/**
	 * Returns the secure filename of this video.
	 *
	 * @return the secure filename of this video
	 */
	@Override
	public String getSecureFilename() {
		return _video.getSecureFilename();
	}

	/**
	 * Returns the secure filename of the video with a reasonable _bitrate_, this is either the original file or, if multiple qualities are
	 * referenced from a _smil_ file, the version with the download suffix.
	 */
	@Override
	public String getSecureMp4FilenameWithReasonableBitrate() {
		return _video.getSecureMp4FilenameWithReasonableBitrate();
	}

	/**
	 * Returns the complete secure URL to the NON open access video
	 */
	@Override
	public String getSecureUrl() {
		return _video.getSecureUrl();
	}

	/**
	 * Returns the title in a truncated form
	 */
	@Override
	public String getShortTitle() {
		return _video.getShortTitle();
	}

	/**
	 * Returns the formatted generation date without time
	 */
	@Override
	public String getSimpleDate() {
		return _video.getSimpleDate();
	}

	/**
	 * Returns the secure prefix of the file (filename without extension)
	 */
	@Override
	public String getSPreffix() {
		return _video.getSPreffix();
	}

	/**
	 * Returns the tags of this video.
	 *
	 * @return the tags of this video
	 */
	@Override
	public String getTags() {
		return _video.getTags();
	}

	/**
	 * Returns the term ID of this video.
	 *
	 * @return the term ID of this video
	 */
	@Override
	public long getTermId() {
		return _video.getTermId();
	}

	/**
	 * Returns the title of this video.
	 *
	 * @return the title of this video
	 */
	@Override
	public String getTitle() {
		return _video.getTitle();
	}

	/**
	 * Returns the upload date of this video.
	 *
	 * @return the upload date of this video
	 */
	@Override
	public Date getUploadDate() {
		return _video.getUploadDate();
	}

	/**
	 * Returns the complete URL to the open access video
	 */
	@Override
	public String getUrl() {
		return _video.getUrl();
	}

	/**
	 * Returns the user ID of this video.
	 *
	 * @return the user ID of this video
	 */
	@Override
	public long getUserId() {
		return _video.getUserId();
	}

	/**
	 * Returns the user name of this video.
	 *
	 * @return the user name of this video
	 */
	@Override
	public String getUserName() {
		return _video.getUserName();
	}

	/**
	 * Returns the user uuid of this video.
	 *
	 * @return the user uuid of this video
	 */
	@Override
	public String getUserUuid() {
		return _video.getUserUuid();
	}

	/**
	 * Returns the video ID of this video.
	 *
	 * @return the video ID of this video
	 */
	@Override
	public long getVideoId() {
		return _video.getVideoId();
	}

	/**
	 * Returns the url to the vtt-caption-file
	 */
	@Override
	public String getVttCaptionUrl() {
		return _video.getVttCaptionUrl();
	}

	/**
	 * Returns the path to the vtt-chapter-file
	 */
	@Override
	public String getVttChapterFile() {
		return _video.getVttChapterFile();
	}

	/**
	 * Returns the vtt file (unchecked if existing) from the user repository
	 */
	@Override
	public java.io.File getVttFile() {
		return _video.getVttFile();
	}

	@Override
	public String getVttThumbsFilde() {
		return _video.getVttThumbsFilde();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getWebmDownloadLink() {
		return _video.getWebmDownloadLink();
	}

	/**
	 * Returns the webm file (unchecked if existing)
	 */
	@Override
	public java.io.File getWebmFile() {
		return _video.getWebmFile();
	}

	@Override
	public String getWebmRssLink() {
		return _video.getWebmRssLink();
	}

	@Override
	public int hashCode() {
		return _video.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _video.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _video.isEscapedModel();
	}

	@Override
	public boolean isHasCaption() {
		return _video.isHasCaption();
	}

	/**
	 * Checks if file has chapters
	 */
	@Override
	public boolean isHasChapters() {
		return _video.isHasChapters();
	}

	@Override
	public boolean isHasComments() {
		return _video.isHasComments();
	}

	@Override
	public boolean isNew() {
		return _video.isNew();
	}

	@Override
	public void persist() {
		_video.persist();
	}

	@Override
	public void setAccessPermitted(Integer accessPermitted) {
		_video.setAccessPermitted(accessPermitted);
	}

	@Override
	public void setBitrate(String bitrate) {
		_video.setBitrate(bitrate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_video.setCachedModel(cachedModel);
	}

	/**
	 * Sets the citation2go of this video.
	 *
	 * @param citation2go the citation2go of this video
	 */
	@Override
	public void setCitation2go(int citation2go) {
		_video.setCitation2go(citation2go);
	}

	/**
	 * Sets the company ID of this video.
	 *
	 * @param companyId the company ID of this video
	 */
	@Override
	public void setCompanyId(long companyId) {
		_video.setCompanyId(companyId);
	}

	/**
	 * Sets the container format of this video.
	 *
	 * @param containerFormat the container format of this video
	 */
	@Override
	public void setContainerFormat(String containerFormat) {
		_video.setContainerFormat(containerFormat);
	}

	/**
	 * Sets the create date of this video.
	 *
	 * @param createDate the create date of this video
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_video.setCreateDate(createDate);
	}

	@Override
	public void setCreatorFullName(String creatorFullName) {
		_video.setCreatorFullName(creatorFullName);
	}

	@Override
	public void setCreators(String creators) {
		_video.setCreators(creators);
	}

	@Override
	public void setDate(String date) {
		_video.setDate(date);
	}

	/**
	 * Sets the download link of this video.
	 *
	 * @param downloadLink the download link of this video
	 */
	@Override
	public void setDownloadLink(int downloadLink) {
		_video.setDownloadLink(downloadLink);
	}

	/**
	 * Sets the duration of this video.
	 *
	 * @param duration the duration of this video
	 */
	@Override
	public void setDuration(String duration) {
		_video.setDuration(duration);
	}

	@Override
	public void setEmbedCommsy(String embedCommsy) {
		_video.setEmbedCommsy(embedCommsy);
	}

	@Override
	public void setEmbedHtml5(String embedHtml5) {
		_video.setEmbedHtml5(embedHtml5);
	}

	@Override
	public void setEmbedIframe(String embedIframe) {
		_video.setEmbedIframe(embedIframe);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_video.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_video.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_video.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the filename of this video.
	 *
	 * @param filename the filename of this video
	 */
	@Override
	public void setFilename(String filename) {
		_video.setFilename(filename);
	}

	/**
	 * Sets the file size of this video.
	 *
	 * @param fileSize the file size of this video
	 */
	@Override
	public void setFileSize(String fileSize) {
		_video.setFileSize(fileSize);
	}

	@Override
	public void setFlvDownloadLink(String flvDownloadLink) {
		_video.setFlvDownloadLink(flvDownloadLink);
	}

	@Override
	public void setFlvFile(java.io.File flvFile) {
		_video.setFlvFile(flvFile);
	}

	@Override
	public void setFlvRssLink(String flvRssLink) {
		_video.setFlvRssLink(flvRssLink);
	}

	/**
	 * Sets the generation date of this video.
	 *
	 * @param generationDate the generation date of this video
	 */
	@Override
	public void setGenerationDate(String generationDate) {
		_video.setGenerationDate(generationDate);
	}

	/**
	 * Sets the group ID of this video.
	 *
	 * @param groupId the group ID of this video
	 */
	@Override
	public void setGroupId(long groupId) {
		_video.setGroupId(groupId);
	}

	@Override
	public void setHasComments(boolean hasComments) {
		_video.setHasComments(hasComments);
	}

	/**
	 * Sets the hits of this video.
	 *
	 * @param hits the hits of this video
	 */
	@Override
	public void setHits(long hits) {
		_video.setHits(hits);
	}

	/**
	 * Sets the host ID of this video.
	 *
	 * @param hostId the host ID of this video
	 */
	@Override
	public void setHostId(long hostId) {
		_video.setHostId(hostId);
	}

	@Override
	public void setImage(String image) {
		_video.setImage(image);
	}

	@Override
	public void setImageMedium(String imageMedium) {
		_video.setImageMedium(imageMedium);
	}

	@Override
	public void setImageSmall(String imageSmall) {
		_video.setImageSmall(imageSmall);
	}

	@Override
	public void setJsonPlayerTracks(
		com.liferay.portal.kernel.json.JSONArray jsonPlayerTracks) {

		_video.setJsonPlayerTracks(jsonPlayerTracks);
	}

	@Override
	public void setJsonPlayerUris(
		com.liferay.portal.kernel.json.JSONArray jsonPlayerUris) {

		_video.setJsonPlayerUris(jsonPlayerUris);
	}

	/**
	 * Sets the lectureseries ID of this video.
	 *
	 * @param lectureseriesId the lectureseries ID of this video
	 */
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_video.setLectureseriesId(lectureseriesId);
	}

	@Override
	public void setLectureseriesName(String lectureseriesName) {
		_video.setLectureseriesName(lectureseriesName);
	}

	@Override
	public void setLectureseriesNumber(String lectureseriesNumber) {
		_video.setLectureseriesNumber(lectureseriesNumber);
	}

	@Override
	public void setLectureseriesUrl(String lectureseriesUrl) {
		_video.setLectureseriesUrl(lectureseriesUrl);
	}

	@Override
	public void setLinkedCreators(String linkedCreators) {
		_video.setLinkedCreators(linkedCreators);
	}

	@Override
	public void setM4aDownloadLink(String m4aDownloadLink) {
		_video.setM4aDownloadLink(m4aDownloadLink);
	}

	@Override
	public void setM4aFile(java.io.File m4aFile) {
		_video.setM4aFile(m4aFile);
	}

	@Override
	public void setM4aRssLink(String m4aRssLink) {
		_video.setM4aRssLink(m4aRssLink);
	}

	@Override
	public void setM4vDownloadLink(String m4vDownloadLink) {
		_video.setM4vDownloadLink(m4vDownloadLink);
	}

	@Override
	public void setM4vFile(java.io.File m4vFile) {
		_video.setM4vFile(m4vFile);
	}

	@Override
	public void setM4vRssLink(String m4vRssLink) {
		_video.setM4vRssLink(m4vRssLink);
	}

	/**
	 * Sets the metadata ID of this video.
	 *
	 * @param metadataId the metadata ID of this video
	 */
	@Override
	public void setMetadataId(long metadataId) {
		_video.setMetadataId(metadataId);
	}

	/**
	 * Sets the modified date of this video.
	 *
	 * @param modifiedDate the modified date of this video
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_video.setModifiedDate(modifiedDate);
	}

	@Override
	public void setMp3DownloadLink(String mp3DownloadLink) {
		_video.setMp3DownloadLink(mp3DownloadLink);
	}

	@Override
	public void setMp3File(java.io.File mp3File) {
		_video.setMp3File(mp3File);
	}

	@Override
	public void setMp3RssLink(String mp3RssLink) {
		_video.setMp3RssLink(mp3RssLink);
	}

	@Override
	public void setMp4DownloadLink(String mp4DownloadLink) {
		_video.setMp4DownloadLink(mp4DownloadLink);
	}

	@Override
	public void setMp4File(java.io.File mp4File) {
		_video.setMp4File(mp4File);
	}

	@Override
	public void setMp4RssLink(String mp4RssLink) {
		_video.setMp4RssLink(mp4RssLink);
	}

	@Override
	public void setNew(boolean n) {
		_video.setNew(n);
	}

	@Override
	public void setOggDownloadLink(String oggDownloadLink) {
		_video.setOggDownloadLink(oggDownloadLink);
	}

	@Override
	public void setOggFile(java.io.File oggFile) {
		_video.setOggFile(oggFile);
	}

	@Override
	public void setOggRssLink(String oggRssLink) {
		_video.setOggRssLink(oggRssLink);
	}

	/**
	 * Sets the open access of this video.
	 *
	 * @param openAccess the open access of this video
	 */
	@Override
	public void setOpenAccess(int openAccess) {
		_video.setOpenAccess(openAccess);
	}

	/**
	 * Sets the password of this video.
	 *
	 * @param password the password of this video
	 */
	@Override
	public void setPassword(String password) {
		_video.setPassword(password);
	}

	@Override
	public void setPdfDownloadLink(String pdfDownloadLink) {
		_video.setPdfDownloadLink(pdfDownloadLink);
	}

	@Override
	public void setPdfFile(java.io.File pdfFile) {
		_video.setPdfFile(pdfFile);
	}

	/**
	 * Sets the permitted to segment of this video.
	 *
	 * @param permittedToSegment the permitted to segment of this video
	 */
	@Override
	public void setPermittedToSegment(int permittedToSegment) {
		_video.setPermittedToSegment(permittedToSegment);
	}

	@Override
	public void setPlayerUris(java.util.ArrayList<String> playerUris) {
		_video.setPlayerUris(playerUris);
	}

	/**
	 * Sets the primary key of this video.
	 *
	 * @param primaryKey the primary key of this video
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_video.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_video.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the producer ID of this video.
	 *
	 * @param producerId the producer ID of this video
	 */
	@Override
	public void setProducerId(long producerId) {
		_video.setProducerId(producerId);
	}

	/**
	 * Sets the resolution of this video.
	 *
	 * @param resolution the resolution of this video
	 */
	@Override
	public void setResolution(String resolution) {
		_video.setResolution(resolution);
	}

	/**
	 * Sets the root institution ID of this video.
	 *
	 * @param rootInstitutionId the root institution ID of this video
	 */
	@Override
	public void setRootInstitutionId(long rootInstitutionId) {
		_video.setRootInstitutionId(rootInstitutionId);
	}

	/**
	 * Sets the secure filename of this video.
	 *
	 * @param secureFilename the secure filename of this video
	 */
	@Override
	public void setSecureFilename(String secureFilename) {
		_video.setSecureFilename(secureFilename);
	}

	@Override
	public void setSecureUrl(String secureUrl) {
		_video.setSecureUrl(secureUrl);
	}

	@Override
	public void setShortTitle(String shortTitle) {
		_video.setShortTitle(shortTitle);
	}

	@Override
	public void setSimpleDate(String simpleDate) {
		_video.setSimpleDate(simpleDate);
	}

	/**
	 * Sets the tags of this video.
	 *
	 * @param tags the tags of this video
	 */
	@Override
	public void setTags(String tags) {
		_video.setTags(tags);
	}

	/**
	 * Sets the term ID of this video.
	 *
	 * @param termId the term ID of this video
	 */
	@Override
	public void setTermId(long termId) {
		_video.setTermId(termId);
	}

	/**
	 * Sets the title of this video.
	 *
	 * @param title the title of this video
	 */
	@Override
	public void setTitle(String title) {
		_video.setTitle(title);
	}

	/**
	 * Sets the upload date of this video.
	 *
	 * @param uploadDate the upload date of this video
	 */
	@Override
	public void setUploadDate(Date uploadDate) {
		_video.setUploadDate(uploadDate);
	}

	@Override
	public void setUrl(String url) {
		_video.setUrl(url);
	}

	/**
	 * Sets the user ID of this video.
	 *
	 * @param userId the user ID of this video
	 */
	@Override
	public void setUserId(long userId) {
		_video.setUserId(userId);
	}

	/**
	 * Sets the user name of this video.
	 *
	 * @param userName the user name of this video
	 */
	@Override
	public void setUserName(String userName) {
		_video.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this video.
	 *
	 * @param userUuid the user uuid of this video
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_video.setUserUuid(userUuid);
	}

	/**
	 * Sets the video ID of this video.
	 *
	 * @param videoId the video ID of this video
	 */
	@Override
	public void setVideoId(long videoId) {
		_video.setVideoId(videoId);
	}

	@Override
	public void setVttCaptionUrl(String vttCaptionUrl) {
		_video.setVttCaptionUrl(vttCaptionUrl);
	}

	@Override
	public void setVttChapterFile(String vttChapterFile) {
		_video.setVttChapterFile(vttChapterFile);
	}

	@Override
	public void setVttFile(java.io.File vttFile) {
		_video.setVttFile(vttFile);
	}

	@Override
	public void setVttThumbsFilde(String vttThumbsFilde) {
		_video.setVttThumbsFilde(vttThumbsFilde);
	}

	@Override
	public void setWebmDownloadLink(String webmDownloadLink) {
		_video.setWebmDownloadLink(webmDownloadLink);
	}

	@Override
	public void setWebmFile(java.io.File webmFile) {
		_video.setWebmFile(webmFile);
	}

	@Override
	public void setWebmRssLink(String webmRssLink) {
		_video.setWebmRssLink(webmRssLink);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<de.uhh.l2g.plugins.model.Video> toCacheModel() {

		return _video.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video toEscapedModel() {
		return new VideoWrapper(_video.toEscapedModel());
	}

	@Override
	public String toString() {
		return _video.toString();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video toUnescapedModel() {
		return new VideoWrapper(_video.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _video.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoWrapper)) {
			return false;
		}

		VideoWrapper videoWrapper = (VideoWrapper)obj;

		if (Objects.equals(_video, videoWrapper._video)) {
			return true;
		}

		return false;
	}

	@Override
	public Video getWrappedModel() {
		return _video;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _video.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _video.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_video.resetOriginalValues();
	}

	private final Video _video;

}