package de.uhh.l2g.plugins.guest.videos.portlet;

import de.uhh.l2g.plugins.exception.NoSuchLicenseException;
import de.uhh.l2g.plugins.exception.NoSuchVideoException;
import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.Cookie;

import org.osgi.service.component.annotations.Component;

/**
 * @author isturm
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.guest",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.tmpl.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery-ui-1.11.1.js",
		"com.liferay.portlet.header-portlet-javascript=/js/bootstrap.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.socialshareprivacy.js",
		"com.liferay.portlet.header-portlet-javascript=/js/qrc.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.cookie.js",
		"com.liferay.portlet.header-portlet-javascript=https://content.jwplatform.com/libraries/meCDJ4WV.js",
		"com.liferay.portlet.header-portlet-javascript=/js/mediaCheck-min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/readmore.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.dotdotdot.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.mark.js",
		"com.liferay.portlet.header-portlet-javascript=/js/catalog.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jwplayer.custom.util.js",		
		"javax.portlet.display-name=de.uhh.l2g.plugins.guest.videos Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + OpenAccessVideosPortletKeys.OpenAccessVideos,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OpenAccessVideosPortlet extends MVCPortlet {

	@Override
	public void serveResource( ResourceRequest resourceRequest, ResourceResponse resourceResponse ) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		if (cmd.equals("get_search_words")) {
			getSearchWords(resourceRequest, resourceResponse);
		}
		
		try{
			if(resourceID.equals("showSegments")){
				String vId = ParamUtil.getString(resourceRequest, "videoId");
				Long vID = new Long(vId);
				com.liferay.portal.kernel.json.JSONArray ja = JSONFactoryUtil.createJSONArray();
				//get segments for video and convert to json array
				try {
					List<Segment> sl= SegmentLocalServiceUtil.getSegmentsByVideoId(vID);
					ListIterator<Segment> sIt = sl.listIterator();
					while(sIt.hasNext()){
						Segment s = sIt.next();
						JSONObject jo = JSONFactoryUtil.createJSONObject();
						jo.put("chapter", s.getChapter());
						jo.put("description", s.getDescription());
						jo.put("end", s.getEnd());
						jo.put("image", s.getImage());
						jo.put("number", s.getNumber());
						jo.put("segmentId", s.getPrimaryKey());
						jo.put("seconds", s.getSeconds());
						jo.put("start", s.getStart());
						jo.put("title", s.getTitle());
						jo.put("userId", s.getUserId());
						jo.put("videoId", s.getVideoId());
						jo.put("previousSegmentId", SegmentLocalServiceUtil.getPreviusSegmentId(s.getSegmentId()));
						ja.put(jo);
					}
					
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
				writeJSON(resourceRequest, resourceResponse, ja);
			}			
		}catch (NullPointerException npe){}
		
	}
	
	public static JSONArray wordsJSONArray = JSONFactoryUtil.createJSONArray();
	private void getSearchWords(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		PrintWriter out = resourceResponse.getWriter();
		out.println(wordsJSONArray);
	}
	
	public void addFilter(ActionRequest request, ActionResponse response){
		String jspPage = request.getParameter("jspPage");
		Long institutionId = new Long(request.getParameter("institutionId"));
		Long parentInstitutionId = new Long(request.getParameter("parentInstitutionId"));
		Long termId = new Long(request.getParameter("termId"));
		Long categoryId = new Long(request.getParameter("categoryId"));
		Long creatorId = new Long(request.getParameter("creatorId"));
		String searchQuery = "";
		if (request.getParameter("searchQuery") != null) {
			searchQuery = request.getParameter("searchQuery");
		}

		response.setRenderParameter("institutionId", institutionId+"");
		response.setRenderParameter("parentInstitutionId", parentInstitutionId+"");
		response.setRenderParameter("termId", termId+"");
		response.setRenderParameter("categoryId", categoryId+"");
		response.setRenderParameter("creatorId", creatorId+"");
		response.setRenderParameter("searchQuery", searchQuery);
		response.setRenderParameter("jspPage", jspPage);
	}
	
	public void addSearch(ActionRequest request, ActionResponse response) {
		String jspPage = request.getParameter("jspPage");
		String searchQuery = request.getParameter("searchQuery");
		
		response.setRenderParameter("searchQuery", searchQuery);
		response.setRenderParameter("jspPage", jspPage);
	}

	public void viewOpenAccessVideo(ActionRequest request, ActionResponse response) {
		String objectType = ParamUtil.getString(request, "objectType");
		String password = request.getParameter("password");
		boolean objectExists = true;
		
		Long objectId = new Long(0);
		boolean secLink = false;
	   	String oid = request.getParameter("objectId");
		
	    try{
	    	objectId = new Long(oid);
	    }catch(NumberFormatException e){
		    if(objectType.equals("v")){ //for video objects
	    		try {
					objectId = VideoLocalServiceUtil.getBySecureUrl(oid).getVideoId();		
					secLink = true;
				} catch (NoSuchVideoException e1) {
				} catch (SystemException e1) {}
	    	 }
		    if(objectType.equals("l")){ //for lecture series objects
		    	objectId = LectureseriesLocalServiceUtil.getByUSID(oid).getLectureseriesId();
				secLink = true;
		    }
	    }

	    Long timeStart = new Long(0);
	    Long timeEnd = new Long(0);
	    
	    try{
	    	timeStart = new Long(ParamUtil.getString(request, "timeStart"));
	    	timeEnd = new Long(ParamUtil.getString(request, "timeEnd"));
	    }catch(Exception e){}
	   
	    Video video = VideoLocalServiceUtil.createVideo(0);
	    //lecture series object
	    Lectureseries lectureseries = LectureseriesLocalServiceUtil.createLectureseries(0);
	    
	    //Lecture series
	    if(objectType.equals("l")){
	    	try{
	    		lectureseries = LectureseriesLocalServiceUtil.getLectureseries(objectId);
	    		if(!secLink){
	    			video = VideoLocalServiceUtil.getFullVideo(lectureseries.getLatestOpenAccessVideoId());
	    		}else{
	    			Long videoId = VideoLocalServiceUtil.getLatestClosedAccessVideoId(objectId);
	    			video = VideoLocalServiceUtil.getFullVideo(videoId);
	    		}
	    	}catch(Exception e){
	    		objectExists = false;
	    		response.setRenderParameter("jspPage","/noVideosFound.jsp");	
	    	}
	    }else if(objectType.equals("v")){
	    	video = VideoLocalServiceUtil.getFullVideo(objectId);
	    	if(video.getVideoId()==0)objectExists=false;
	    	try{lectureseries = LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());}catch (Exception e){}
	    }
	    if(objectExists){
		    List<Video> relatedVideos = new ArrayList<Video>();
		    //related videos by lectureseries id
	    	try {
	    		int os = 0;
	    		if(video.getOpenAccess()==1)os=1;
				relatedVideos = VideoLocalServiceUtil.getByLectureseriesAndOpenaccess(lectureseries.getLectureseriesId(),os);
			} catch (SystemException e) {}
		    
		    //chapters and segments
		    List<Segment> segments= new ArrayList<Segment>();
			try {
				segments = SegmentLocalServiceUtil.getSegmentsByVideoId(objectId);
			} catch (PortalException e) {
			} catch (SystemException e) {}
		    
		    //lectureseries for video
		    List<Video_Lectureseries> vl = new ArrayList<Video_Lectureseries>();
		    try {
				vl = Video_LectureseriesLocalServiceUtil.getByVideo(video.getVideoId());
			} catch (SystemException e) {}
		    
		    //institutions for video
		    List<Video_Institution> vi = new ArrayList<Video_Institution>();
		    vi = Video_InstitutionLocalServiceUtil.getByVideo(video.getVideoId());
		    
		    //metadata for video
		    Metadata m = MetadataLocalServiceUtil.createMetadata(0);
		    try {
				m = MetadataLocalServiceUtil.getMetadata(video.getMetadataId());
			} catch (PortalException e) {
			} catch (SystemException e) {}
		    
		    //license for video
		    
		    License l = LicenseLocalServiceUtil.createLicense(0);
		    try {
				l = LicenseLocalServiceUtil.getByVideoId(video.getVideoId());
			} catch (NoSuchLicenseException e) {
			} catch (SystemException e) {}
		    
		    //update video hits
		    Long hits = video.getHits();
		    hits = hits+1;
		    video.setHits(hits);
		    try {
				VideoLocalServiceUtil.updateVideo(video);
			} catch (SystemException e) {}
		    
		    //check password access
		    if(secLink==false){
		    	if(video.getOpenAccess()==1) video.setAccessPermitted(1);
		    	else video.setAccessPermitted(2);
		    }else{
		    	//access denied by default
		    	video.setAccessPermitted(0);
		    	
	    		//1. authentication by lecture series password
				try{
			    	if(password.equals(lectureseries.getPassword()))video.setAccessPermitted(1);
		   			else video.setAccessPermitted(0);				
				}catch(Exception e){}

	   			
	    		//2. authentication by cookie
				Cookie[] c = request.getCookies();
				try{
					for(int i=0; i<c.length;i++){
						Cookie coo = c[i];
						String cooVal ="";
						if(coo.getName().equals("L2G_LSID"))cooVal=c[i].getValue();
						//has been already logged in
						if(cooVal.equals(video.getLectureseriesId()+"")){
							video.setAccessPermitted(1);
						}
					}
				}catch(java.lang.NullPointerException e){
					System.out.print(e);
				}
	    		
	    		//3. authentication by video password
	    		if(!video.getPassword().isEmpty()){
	    			try{
	        			if(password.equals(video.getPassword())){
	        				video.setAccessPermitted(1);
	        			}else{
	        				video.setAccessPermitted(0);
	        			}   				
	    			}catch(Exception e){
	    				video.setAccessPermitted(0);
	    			}
	    		}
	    	}
		    
		    request.setAttribute("videoLicense",l);
		    request.setAttribute("videoMetadata",m);
		    request.setAttribute("videoInstitutions",vi);
		    request.setAttribute("videoLectureseries",vl);
		    request.setAttribute("video",video);
		    request.setAttribute("relatedVideos",relatedVideos);
		    request.setAttribute("segments",segments);
		    request.setAttribute("lectureseries",lectureseries);
		    request.setAttribute("timeStart",timeStart);
		    request.setAttribute("timeEnd",timeEnd);
		    request.setAttribute("objectType",objectType);
		    request.setAttribute("objectId",oid);
		    
		    if(video.getVideoId()==0) response.setRenderParameter("jspPage","noVideosFound.jsp");	
		    else response.setRenderParameter("jspPage","/viewDetails.jsp");	    	
	    }
	}
	
}