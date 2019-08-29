/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package de.uhh.l2g.plugins.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.exception.InstitutionNameException;
import de.uhh.l2g.plugins.exception.NoSuchInstitutionException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.InstitutionLocalServiceBaseImpl;

/**
 * The implementation of the institution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.uhh.l2g.plugins.service.InstitutionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.InstitutionLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil
 */
public class InstitutionLocalServiceImpl extends InstitutionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil} to access the
	 * institution local service.
	 */
	protected static Log LOG = LogFactoryUtil.getLog(Institution.class.getName());	
	 
	public Institution getById(long institutionId) throws SystemException {
		return institutionPersistence.fetchByPrimaryKey(institutionId);
	}

	public List<Institution> getByGroupId(long groupId) throws SystemException {
		return institutionPersistence.findByGroupId(groupId);
	}

	public List<Institution> getRootInstitutionsByOpenAccessVideos() throws SystemException {
		return institutionFinder.findRootInstitutionsByOpenAccessVideos(); 
	}
	
	public Institution getByGroupIdAndId(long groupId, long institutionId) throws SystemException {
		return institutionPersistence.fetchByG_I(groupId, institutionId);
	}

	public Institution getRootByGroupId(long companyId, long groupId) throws SystemException {
		return (Institution) institutionPersistence.fetchByRoot(companyId, groupId);
	}

	public List<Institution> getByGroupIdAndParent(long groupId, long parentId) throws SystemException {
		return institutionPersistence.findByG_P(groupId, parentId);
	}

	public List<Institution> getByGroupIdAndParent(long groupId, long parentId, int start, int end) throws SystemException {
		return institutionPersistence.findByG_P(groupId, parentId, start, end);
	}

	public int getByGroupIdAndParentCount(long groupId, long parentId) throws SystemException {
		return institutionPersistence.countByG_P(groupId, parentId);
	}

	public List<Institution> getByParentId(long parentId, String type) throws SystemException {
		return institutionPersistence.findByParent(parentId);
	}

	public Institution getRoot(long companyId, long groupId) throws NoSuchInstitutionException, SystemException{
		return institutionPersistence.findByRoot(companyId, groupId);
	}
	
	public Institution getRootByParentAndCompanyAndGroup(long parentId, long companyId, long groupId) throws NoSuchInstitutionException, SystemException{
		return institutionPersistence.findByParentAndCompanyAndGroup(parentId, companyId, groupId);
	}
	
	public  List<Institution> getByParentId(long parentId) throws SystemException {
		List<Institution> institutions = institutionPersistence.findByParent(parentId);
		return institutions;
	}
	
	public Map<String, String> getByParent(long parentId) throws SystemException {
		Map<String, String> institutions = new LinkedHashMap<String, String>();
		List<Institution> fList = institutionPersistence.findByParent(parentId);

		for (Institution institution : fList) {
			String id = "" + institution.getInstitutionId();
			String name = "" + institution.getName();
			institutions.put(id, name);
		}
		return institutions;
	}

	public List<Institution> getByLevel(int level) throws SystemException {
		return institutionPersistence.findByLevel(level);
	}

	public List<Institution> getByLectureseriesId(long lectureseriesId, int begin, int end) throws SystemException {
		return institutionFinder.findByLectureseriesId(lectureseriesId, begin, end);
	}

	public Map<String, String> getAllSortedAsTree(int begin, int end) throws SystemException {
		Map<String, String> allInstitutions = new LinkedHashMap<String, String>();
		List<Institution> einListAll = institutionFinder.findAllSortedAsTree(begin, end);

		for (Institution institution : einListAll) {
			String id = "" + institution.getInstitutionId();
			String name = _indentFromPath(institution.getPath(), "/") + institution.getName();
			allInstitutions.put(id, name);
		}

		return allInstitutions;
	}

	public int getMaxSortByParentId(long parentId) throws SystemException {
		return institutionFinder.findMaxSortByParent(parentId);
	}

	public int getLockingElements(long institutionId) throws SystemException {
		return institutionFinder.findLockingElements(institutionId);
	}

	public List<Institution> getInstitutionsFromLectureseriesIdsAndVideoIds(ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds) {
		return institutionFinder.findInstitutionsByLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds, new Long(0));
	}

	public List<Institution> getInstitutionsFromLectureseriesIdsAndVideoIds(ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds, Long parentId) {
		return institutionFinder.findInstitutionsByLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds, parentId);
	}

	private String _indentFromPath(String path, String sep) {
		String s = "";
		for (int i = 1; i <= path.split(sep).length - 1; i++) {
			s += "--";
		}
		return s;
	}

	protected void validate(String name) throws PortalException {

		if (Validator.isNull(name)) {
			throw new InstitutionNameException();
		}

	}

	protected void up(){}

	protected void down() {}


    /** Refreshes sort number for given institution
     *  Adds new number on insert (newpos > 0) - shifts numbers on delete (newpos = 0)
     *
     */
	protected int updateSort(Institution inst, int newpos) throws SystemException{
		int validPosition = 0;
		int curPos = 1;
		int prevPos = inst.getSort();

		//System.out.println(inst.getSort());
		int subElements = InstitutionLocalServiceUtil.getByGroupIdAndParentCount(inst.getGroupId(), inst.getParentId());

		if (subElements < 1) validPosition = 1; // There is nothing to reorder and only one valid position
		else{ // sort Elements newpos <= 1 => shift all, newpos > max attach at back
			List<Institution> subtree = InstitutionLocalServiceUtil.getByGroupIdAndParent(inst.getGroupId(), inst.getParentId());

			//delete (virtually append to end and shift all other down)
			int increment = 0;
			//System.out.println("Start: " + curPos + " " + newpos + " " + prevPos  + " " +increment+ " " +validPosition);
			for (Institution subInstitution: subtree){
				 if (newpos <= curPos && increment == 0){ //insert new Institution here
					 if (newpos > 0) {
						 validPosition = curPos;
						 increment = 1; //shift all follwing up
					 }
					 else { //newpos = 0 <=> remove 
						 if (curPos > prevPos) increment = -1;
							//System.out.println(subInstitution.getInstitutionId() +" "+ subInstitution.getName()+ " " + curPos + " " + increment+ " " +validPosition);
							
					 }
				 }
				 subInstitution.setSort(curPos + increment);
				 institutionPersistence.update(subInstitution);
				 //System.out.println(subInstitution.getInstitutionId() +" "+ subInstitution.getName()+ " " + curPos + " " + increment+ " " +validPosition);
				 curPos++;

			}
			if (increment == 0) validPosition = curPos;

		}


		//System.out.println(validPosition);

		return validPosition;
	}
	
    /** Refreshes sort of subinstitutions for given parent
     *  Brings values in natural order starting with 1
     *  
     *  Finder results must be preorderd by sort
     */
	protected void reorderChildren(Institution inst) throws SystemException{

		int subElements = InstitutionLocalServiceUtil.getByGroupIdAndParentCount(inst.getGroupId(), inst.getPrimaryKey());

		// There is nothing to reorder if number of children is smaller 1   
		int startPos = 1;
		if (subElements > 1) { // sort Elements newpos <= 1 => shift all
			List<Institution> subtree = InstitutionLocalServiceUtil.getByGroupIdAndParent(inst.getGroupId(), inst.getPrimaryKey());

			int increment = 0;
			for (Institution subInstitution: subtree){
				//System.out.println("Reorder: "+startPos + increment);
				 subInstitution.setSort(startPos + increment);
				 institutionPersistence.update(subInstitution);
				 increment++;

			}

		}
	}
	
	public Institution updateInstitution(long institutionId, String name, int sort,
		       ServiceContext serviceContext) throws PortalException,
		       SystemException {
		    long groupId = serviceContext.getScopeGroupId();
		    long companyId = serviceContext.getCompanyId();
		    long userId = serviceContext.getUserId();

		    User user = userPersistence.findByPrimaryKey(userId);


			validate(name);

		    Institution institution = getInstitution(institutionId);

		    institution.setName(name);
			institution.setGroupId(groupId);
			institution.setCompanyId(companyId);

			if(sort <= 0) sort = 1;
			institution.setSort(updateSort(institution,sort));

			institution.setExpandoBridgeAttributes(serviceContext);

			//System.out.println(institutionId+" "+institution.getPrimaryKey() );

			institutionPersistence.update(institution);
			//refresh order
			if(institution.getParentId()>0) reorderChildren(getById(institution.getParentId()));
			
			//Refresh LinkTable Resources if existing
			try{
				Host host = Institution_HostLocalServiceUtil.getByGroupIdAndInstitutionId(companyId, groupId, institutionId);
				//Dummy Call: Actually never change Host 
				Institution_HostLocalServiceUtil.updateEntry(institutionId, host.getPrimaryKey(), serviceContext);
			} catch (Exception e) {
			    //TODO: Update Parent...
			}

		    resourceLocalService.updateResources(user.getCompanyId(), groupId,
		         Institution.class.getName(), institutionId,
		         serviceContext.getGroupPermissions(),
		         serviceContext.getGuestPermissions());

		    return institution;

		}

}
