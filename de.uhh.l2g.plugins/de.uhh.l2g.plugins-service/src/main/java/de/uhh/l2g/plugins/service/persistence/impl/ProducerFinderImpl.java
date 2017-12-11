package de.uhh.l2g.plugins.service.persistence.impl;

import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.service.persistence.ProducerFinder;

public class ProducerFinderImpl extends ProducerFinderBaseImpl implements ProducerFinder {

	
	public static final String FIND_PRODUCER_IDS = ProducerFinder.class.getName() + ".findProducerIds";

	public List<Long> findProducerIds(Long lectureseriesId, int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(getClass(), FIND_PRODUCER_IDS);
			SQLQuery q = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lectureseriesId);
			List <Long> sl =  (List<Long>) QueryUtil.list(q, getDialect(), begin, end);
			return sl;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

}
