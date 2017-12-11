package de.uhh.l2g.plugins.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.service.ServiceContext;

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Videohitlist;
import de.uhh.l2g.plugins.model.impl.VideohitlistImpl;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideohitlistLocalServiceUtil;

/**
 * The Class DatabaseThread.
 */
public final class VideohitlistScheduler extends PortletScheduler implements MessageListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Log LOG;	
	
    public VideohitlistScheduler(){
    	super();
    	LOG = LogFactoryUtil.getLog(VideohitlistScheduler.class.getName());
    }
    
	public VideohitlistScheduler(String schedulerClassName, ServiceContext serviceContext) {
		super(VideohitlistScheduler.class.getName(), serviceContext);
	    this.schedulerClassName = VideohitlistScheduler.class.getName();
	    LOG = LogFactoryUtil.getLog(this.schedulerClassName);
	}
	
//	@Override
//    public void receive(Message message) throws MessageListenerException {
//	   //uncoment for further debug messages
//	   //super.receive(message);
//		LOG.info("Videohitlist Scheduler running "+message.getValues().get(SchedulerEngine.JOB_NAME).toString()+"...");
//	   //Do Job
//		ThreadManagement tm = new ThreadManagement();
//		try {
//			tm.createPopularVideoList();
//			LOG.info("Videohitlist Scheduler finished.");
//		} catch (SystemException e) {
//			LOG.info("Videohitlist Scheduler failed.");
//		}
//    }	
	
	public void start() {
        super.schedule();
        LOG.info("Videohitlist Scheduler start.");
	}
	
	public void stop() {
		super.unschedule();
		LOG.info("Videohitlist Scheduler stop.");
	}

	public void init(String schedulerClassName, ServiceContext serviceContext) {
        super.initScheduler(schedulerClassName,serviceContext);
	}

	private static Long HITS=new Long(20);

	public void createPopularVideoList() throws SystemException {
		List<Video> returnList = new ArrayList<Video>();
		//1.get open access videos with more than 20 clicks 
		returnList = VideoLocalServiceUtil.getByHitsAndOpenAccess(HITS);
		//2.truncate table videohitlist
		VideohitlistLocalServiceUtil.deleteAll();
		//3.fill table with data
		Calendar calendar = new GregorianCalendar(); 
		calendar.setTimeZone( TimeZone.getTimeZone("CET") );
		long msnow = calendar.getTimeInMillis();

		Date d1 = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm");

		for(Video v : returnList){
			try {
				d1 = df.parse(v.getGenerationDate()); 
				long ms1   = d1.getTime();
				long hits = v.getHits();
				long timeinms = msnow - ms1;

				// Durschnittswerte berechnen
				//Berechne alter des Videos in...
				long days = timeinms / (1000*60*60*24); //...Tagen
				long week = timeinms / (1000*60*60*24*7); //...Wochen
				long month = timeinms / 2628000000l; //....Monaten
				long year = timeinms / (2628000000l*12l); //....Jahren
				
				//Berechne die Hits pro...
				long clicksperday = calcHitsPro(days, hits);
				long clicksperweek = calcHitsPro(week, hits);
				long clickspermonth = calcHitsPro(month, hits);
				long clicksperyear = calcHitsPro(year, hits);

				Videohitlist vhl = new VideohitlistImpl();
				vhl.setVideoId(v.getVideoId());
				vhl.setHitsPerDay(clicksperday);
				vhl.setHitsPerWeek(clicksperweek);
				vhl.setHitsPerMonth(clickspermonth);
				vhl.setHitsPerYear(clicksperyear);
				//save
				VideohitlistLocalServiceUtil.addVideohitlist(vhl);
				}catch (ParseException e) {
					System.out.println("Simple Date Parsen Error!!");
				}
		}
	}	
	
	private long calcHitsPro(long einheit, long hits){
		if(einheit>=1)return (long) (hits/einheit); //Hits pro Einheit (tag, woche, monat, jahr...)
		else return hits; //else: Das Video ist noch kein volles Jahr vollen Monat etc alt.
	}
}
