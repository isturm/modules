package de.uhh.l2g.plugins.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Session;

import de.uhh.l2g.plugins.service.persistence.StatisticFinder;

public class StatisticFinderImpl extends StatisticFinderBaseImpl implements StatisticFinder {

	public static final String CREATE_VIDEO_STATISTIC_VIEW = StatisticFinder.class.getName() + ".createVideoStatisticView";
	public static final String REMOVE_VIDEO_STATISTIC_TABLE = StatisticFinder.class.getName() + ".removeVideoStatisticTable";
	public static final String ADD_NEW_STATISTIC_ENTRY = StatisticFinder.class.getName() + ".addNewStatisticEntry";

	/**
	 * WARNING: As Custom Query is restricted executeQuery() 
	 * this methods uses Core DB functionality of Liferay 
	 */
	public int createVideoStatisticView() {
		Session session = null;
		int out = 0;
//		try {
//			session = openSession();
//			String sql = CustomSQLUtil.get(getClass(), CREATE_VIDEO_STATISTIC_VIEW);
//
//			DB db = DBFactoryUtil.getDB();
//			//This requires to use executeUpdate instead of executeQuery
//			db.runSQL(sql);
//			
//	      } catch (Exception e) {
//			try {
//				throw new SystemException(e);
//			} catch (SystemException se) {
//				se.printStackTrace();
//			}
//		} finally {
//			closeSession(session);
//		}
		return out;
	}

	/**
	 * WARNING: As Custom Query is restricted executeQuery() 
	 * this methods uses Core DB functionality of Liferay 
	 */
	public int removeVideoStatisticTable() {
		Session session = null;
		int out = 0;
//		try {
//			session = openSession();
//			String sql = CustomSQLUtil.get(getClass(), REMOVE_VIDEO_STATISTIC_TABLE);
//			
//			DB db = DBFactoryUtil.getDB();
//			//This requires to use executeUpdate instead of executeQuery
//			db.runSQL(sql);
//			
//	      } catch (Exception e) {
//			try {
//				throw new SystemException(e);
//			} catch (SystemException se) {
//				se.printStackTrace();
//			}
//		} finally {
//			closeSession(session);
//		}
		return out;
	}


}
