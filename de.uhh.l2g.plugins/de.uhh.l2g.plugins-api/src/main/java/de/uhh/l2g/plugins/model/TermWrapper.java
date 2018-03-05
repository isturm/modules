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
 * This class is a wrapper for {@link Term}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Term
 * @generated
 */
@ProviderType
public class TermWrapper implements Term, ModelWrapper<Term> {
	public TermWrapper(Term term) {
		_term = term;
	}

	@Override
	public Class<?> getModelClass() {
		return Term.class;
	}

	@Override
	public String getModelClassName() {
		return Term.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("termId", getTermId());
		attributes.put("parentId", getParentId());
		attributes.put("languageId", getLanguageId());
		attributes.put("prefix", getPrefix());
		attributes.put("year", getYear());
		attributes.put("translation", getTranslation());
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
		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String prefix = (String)attributes.get("prefix");

		if (prefix != null) {
			setPrefix(prefix);
		}

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String translation = (String)attributes.get("translation");

		if (translation != null) {
			setTranslation(translation);
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
	public boolean isCachedModel() {
		return _term.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _term.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _term.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _term.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.uhh.l2g.plugins.model.Term> toCacheModel() {
		return _term.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Term toEscapedModel() {
		return new TermWrapper(_term.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Term toUnescapedModel() {
		return new TermWrapper(_term.toUnescapedModel());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Term term) {
		return _term.compareTo(term);
	}

	@Override
	public int hashCode() {
		return _term.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _term.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TermWrapper((Term)_term.clone());
	}

	@Override
	public java.lang.String getFullName() {
		return _term.getFullName();
	}

	/**
	* Returns the language ID of this term.
	*
	* @return the language ID of this term
	*/
	@Override
	public java.lang.String getLanguageId() {
		return _term.getLanguageId();
	}

	/**
	* Returns the prefix of this term.
	*
	* @return the prefix of this term
	*/
	@Override
	public java.lang.String getPrefix() {
		return _term.getPrefix();
	}

	/**
	* @return the full termName (prefix + year)
	*/
	@Override
	public java.lang.String getTermName() {
		return _term.getTermName();
	}

	/**
	* Returns the translation of this term.
	*
	* @return the translation of this term
	*/
	@Override
	public java.lang.String getTranslation() {
		return _term.getTranslation();
	}

	/**
	* Returns the user name of this term.
	*
	* @return the user name of this term
	*/
	@Override
	public java.lang.String getUserName() {
		return _term.getUserName();
	}

	/**
	* Returns the user uuid of this term.
	*
	* @return the user uuid of this term
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _term.getUserUuid();
	}

	/**
	* Returns the year of this term.
	*
	* @return the year of this term
	*/
	@Override
	public java.lang.String getYear() {
		return _term.getYear();
	}

	@Override
	public java.lang.String toString() {
		return _term.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _term.toXmlString();
	}

	/**
	* Returns the create date of this term.
	*
	* @return the create date of this term
	*/
	@Override
	public Date getCreateDate() {
		return _term.getCreateDate();
	}

	/**
	* Returns the modified date of this term.
	*
	* @return the modified date of this term
	*/
	@Override
	public Date getModifiedDate() {
		return _term.getModifiedDate();
	}

	/**
	* Returns the company ID of this term.
	*
	* @return the company ID of this term
	*/
	@Override
	public long getCompanyId() {
		return _term.getCompanyId();
	}

	/**
	* Returns the group ID of this term.
	*
	* @return the group ID of this term
	*/
	@Override
	public long getGroupId() {
		return _term.getGroupId();
	}

	/**
	* Returns the parent ID of this term.
	*
	* @return the parent ID of this term
	*/
	@Override
	public long getParentId() {
		return _term.getParentId();
	}

	/**
	* Returns the primary key of this term.
	*
	* @return the primary key of this term
	*/
	@Override
	public long getPrimaryKey() {
		return _term.getPrimaryKey();
	}

	/**
	* Returns the term ID of this term.
	*
	* @return the term ID of this term
	*/
	@Override
	public long getTermId() {
		return _term.getTermId();
	}

	/**
	* Returns the user ID of this term.
	*
	* @return the user ID of this term
	*/
	@Override
	public long getUserId() {
		return _term.getUserId();
	}

	@Override
	public void persist() {
		_term.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_term.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this term.
	*
	* @param companyId the company ID of this term
	*/
	@Override
	public void setCompanyId(long companyId) {
		_term.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this term.
	*
	* @param createDate the create date of this term
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_term.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_term.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_term.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_term.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setFullName(java.lang.String fullName) {
		_term.setFullName(fullName);
	}

	/**
	* Sets the group ID of this term.
	*
	* @param groupId the group ID of this term
	*/
	@Override
	public void setGroupId(long groupId) {
		_term.setGroupId(groupId);
	}

	/**
	* Sets the language ID of this term.
	*
	* @param languageId the language ID of this term
	*/
	@Override
	public void setLanguageId(java.lang.String languageId) {
		_term.setLanguageId(languageId);
	}

	/**
	* Sets the modified date of this term.
	*
	* @param modifiedDate the modified date of this term
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_term.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_term.setNew(n);
	}

	/**
	* Sets the parent ID of this term.
	*
	* @param parentId the parent ID of this term
	*/
	@Override
	public void setParentId(long parentId) {
		_term.setParentId(parentId);
	}

	/**
	* Sets the prefix of this term.
	*
	* @param prefix the prefix of this term
	*/
	@Override
	public void setPrefix(java.lang.String prefix) {
		_term.setPrefix(prefix);
	}

	/**
	* Sets the primary key of this term.
	*
	* @param primaryKey the primary key of this term
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_term.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_term.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the term ID of this term.
	*
	* @param termId the term ID of this term
	*/
	@Override
	public void setTermId(long termId) {
		_term.setTermId(termId);
	}

	/**
	* Sets the translation of this term.
	*
	* @param translation the translation of this term
	*/
	@Override
	public void setTranslation(java.lang.String translation) {
		_term.setTranslation(translation);
	}

	/**
	* Sets the user ID of this term.
	*
	* @param userId the user ID of this term
	*/
	@Override
	public void setUserId(long userId) {
		_term.setUserId(userId);
	}

	/**
	* Sets the user name of this term.
	*
	* @param userName the user name of this term
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_term.setUserName(userName);
	}

	/**
	* Sets the user uuid of this term.
	*
	* @param userUuid the user uuid of this term
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_term.setUserUuid(userUuid);
	}

	/**
	* Sets the year of this term.
	*
	* @param year the year of this term
	*/
	@Override
	public void setYear(java.lang.String year) {
		_term.setYear(year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TermWrapper)) {
			return false;
		}

		TermWrapper termWrapper = (TermWrapper)obj;

		if (Objects.equals(_term, termWrapper._term)) {
			return true;
		}

		return false;
	}

	@Override
	public Term getWrappedModel() {
		return _term;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _term.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _term.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_term.resetOriginalValues();
	}

	private final Term _term;
}