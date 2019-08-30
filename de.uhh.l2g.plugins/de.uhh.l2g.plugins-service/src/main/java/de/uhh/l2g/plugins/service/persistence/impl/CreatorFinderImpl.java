package de.uhh.l2g.plugins.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.impl.CreatorImpl;
import de.uhh.l2g.plugins.service.persistence.CreatorFinder;

public class CreatorFinderImpl extends CreatorFinderBaseImpl implements CreatorFinder {
	public static final String FIND_CREATORS_FOR_LECTURESERIES = CreatorFinder.class.getName() + ".findCreatorsForLectureseries";
	public static final String FIND_CREATORS_FOR_VIDEO = CreatorFinder.class.getName() + ".findCreatorsForVideo";
	public static final String FIND_CREATORS_FOR_LECTURESERIES_OVER_THE_ASSIGNED_VIDEOS = CreatorFinder.class.getName() + ".findCreatorsForLectureseriesOverTheAssigenedVideos";

	@Reference
	private CustomSQL _customSQL;
	
	public List<Creator> findCreatorsByLectureseries(long lectureseriesId) {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_CREATORS_FOR_LECTURESERIES);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("creatorId", Type.LONG);
			q.addScalar("firstName", Type.STRING);
			q.addScalar("lastName", Type.STRING);
			q.addScalar("middleName", Type.STRING);
			q.addScalar("jobTitle", Type.STRING);
			q.addScalar("gender", Type.STRING);
			q.addScalar("fullName", Type.STRING);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleCreators(fl);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Creator> findCreatorsByVideo(long videoId) {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_CREATORS_FOR_VIDEO);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("creatorId", Type.LONG);
			q.addScalar("firstName", Type.STRING);
			q.addScalar("lastName", Type.STRING);
			q.addScalar("middleName", Type.STRING);
			q.addScalar("jobTitle", Type.STRING);
			q.addScalar("gender", Type.STRING);
			q.addScalar("fullName", Type.STRING);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(videoId);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleCreators(fl);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Creator> findCreatorsForLectureseriesOverTheAssigenedVideos(long lectureseriesId) {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_CREATORS_FOR_LECTURESERIES_OVER_THE_ASSIGNED_VIDEOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("creatorId", Type.LONG);
			q.addScalar("firstName", Type.STRING);
			q.addScalar("lastName", Type.STRING);
			q.addScalar("middleName", Type.STRING);
			q.addScalar("jobTitle", Type.STRING);
			q.addScalar("gender", Type.STRING);
			q.addScalar("fullName", Type.STRING);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleCreators(fl);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Creator> findCreatorsByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds)  {
		Session session = null;
		try {
			session = openSession();
			String sql = sqlCreatorsByLectureseriesIdsAndVideoIds(lectureseriesIds,videoIds);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("creatorId", Type.LONG);
			q.addScalar("firstName", Type.STRING);
			q.addScalar("lastName", Type.STRING);
			q.addScalar("middleName", Type.STRING);
			q.addScalar("jobTitle", Type.STRING);
			q.addScalar("gender", Type.STRING);
			q.addScalar("fullName", Type.STRING);
			q.setCacheable(false);
			@SuppressWarnings("unchecked")
			List <Object[]> fl =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assembleCreators(fl);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	private String sqlCreatorsByLectureseriesIdsAndVideoIds (ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds) {
		boolean hasLectureseries 	= !lectureseriesIds.isEmpty();
		boolean hasVideos 			= !videoIds.isEmpty();
		String lquery = "";
		String vquery = "";
		
		if (hasLectureseries) {
			// convert the list of ids to a comma-seperated string for the sql query
			String lectureseriesIdsQuery = StringUtils.join(lectureseriesIds, ',');
			lquery = "SELECT creatorId FROM LG_Lectureseries_Creator WHERE lectureseriesId IN (" + lectureseriesIdsQuery + ")";
		}
		if (hasVideos) {
			// convert the list of ids to a comma-seperated string for the sql query
			String videoIdsQuery = StringUtils.join(videoIds, ',');
			vquery = "SELECT creatorId FROM LG_Video_Creator WHERE videoId IN (" + videoIdsQuery + ")";
		}
				
		String query =  "SELECT DISTINCT c.creatorId,c.firstName,c.lastName,c.middleName,c.jobTitle,c.gender,c.fullName FROM (";
		
		if (hasLectureseries && hasVideos) {
			query += lquery + " UNION " + vquery;
 		} else if (hasLectureseries) {
			query += lquery;
		} else if (hasVideos) {
			query += vquery;
		}
		else { ////surpress sql error on empty lists 
			query += "SELECT creatorId FROM LG_Video_Creator WHERE videoId IN (0)";
		}
		
		query += ") AS a JOIN LG_Creator AS c	ON a.creatorId = c.creatorId ORDER BY c.lastName";
					
		return query;
	}
	
	
	private List<Creator> assembleCreators(List<Object[]> objectList){
		List<Creator> fl = new ArrayList<Creator>();
		for (Object[] creator: objectList){
			CreatorImpl f = new CreatorImpl();
			f.setCreatorId((Long) creator[0]);
			f.setFirstName((String) creator[1]);
			f.setLastName((String) creator[2]);
			f.setMiddleName((String) creator[3]);
			f.setJobTitle((String) creator[4]);
			f.setGender((String) creator[5]);
			f.setFullName((String) creator[6]);
			fl.add(f);
		}
		return fl;
	}
}
