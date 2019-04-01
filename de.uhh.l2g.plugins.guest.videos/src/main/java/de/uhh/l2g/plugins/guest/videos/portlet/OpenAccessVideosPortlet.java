package de.uhh.l2g.plugins.guest.videos.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.Cookie;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import de.uhh.l2g.plugins.exception.NoSuchLicenseException;
import de.uhh.l2g.plugins.exception.NoSuchVideoException;
import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;

/**
 * @author isturm
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
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
		"com.liferay.portlet.header-portlet-javascript=/js/de.uhh.l2g.plugins.guest.videos.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jwplayer.custom.util.js",		
		"javax.portlet.display-name=Guest Videos",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + OpenAccessVideosPortletKeys.OpenAccessVideos,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OpenAccessVideosPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(OpenAccessVideosPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String view = ParamUtil.getString(renderRequest, "jspPage");

		switch (view) {
		case "/viewDetails.jsp":
			renderDetails(renderRequest, renderResponse);
			break;

		default:
			renderList(renderRequest, renderResponse);
			break;
		}
		
		
		super.render(renderRequest, renderResponse);
	}
	
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
					//e.printStackTrace();
				} catch (SystemException e) {
					//e.printStackTrace();
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
	
	public void renderList(RenderRequest renderRequest, RenderResponse renderResponse) {
		Long parentInstitutionId = ParamUtil.getLong(renderRequest, "parentInstitutionId");
		Long institutionId 	= ParamUtil.getLong(renderRequest, "institutionId", 0);
		Long termId = ParamUtil.getLong(renderRequest, "termId", 0);
		Long categoryId = ParamUtil.getLong(renderRequest, "categoryId", 0);
		Long creatorId = ParamUtil.getLong(renderRequest, "creatorId", 0);
		String searchQuery = ParamUtil.getString(renderRequest, "searchQuery", "");
		int maxTerms = 4;
		boolean hasInstitutionFiltered 	= (institutionId != 0);
		boolean hasParentInstitutionFiltered = (parentInstitutionId != 0);
		boolean hasTermFiltered	= (termId != 0);
		boolean hasCategoryFiltered	= (categoryId != 0);
		boolean isSearched = (searchQuery.trim().length()>0);
		//
		long companyId = PortalUtil.getCompanyId(renderRequest);
		long groupId = new Long(0);
		try {
			groupId = PortalUtil.getCompany(renderRequest).getGroupId();
		} catch (PortalException e) {
			_log.error("can't feth any group id");
		}
		// the institution is dependent on the parentinstitution, do not allow institution-filters without parentinstitution-filter
		if (hasInstitutionFiltered && !hasParentInstitutionFiltered) {
			institutionId = new Long(0);
		}		
		// get filtered lectureseries and single videos
		List<Lectureseries> reqLectureseries = LectureseriesLocalServiceUtil.getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(institutionId, parentInstitutionId, termId, categoryId, creatorId, searchQuery, groupId, companyId);
		// differentiate returned lectureseries in real lectureseries and fake video lectureseries (openAccessVideoId is negative on videos)
		ArrayList<Long> lectureseriesIds = new ArrayList<Long>();
		ArrayList<Long> videoIds = new ArrayList<Long>();
		long id;
	 	for (Lectureseries lecture : reqLectureseries) {
			id = lecture.getLectureseriesId();
			if (lecture.getLatestOpenAccessVideoId() < 0) {
				videoIds.add(id);
			} else {
				lectureseriesIds.add(id);
			}
		} 
	 	//
	 	// get the institutions, parentinstitutuons, terms, categories and creators which are part of the dataset. those are displayed so the user can do further filtering
		List<Institution> presentParentInstitutions 	= new ArrayList<Institution>();
		List<Institution> presentInstitutions 			= new ArrayList<Institution>();
		List<Term> presentTerms 						= new ArrayList<Term>();
		List<Creator> presentCreators 					= new ArrayList<Creator>();
		List<Category> presentCategories 				= new ArrayList<Category>();

		// if a filter is selected, only show the selected one else show all
	 	if (hasParentInstitutionFiltered) {
			presentParentInstitutions.add(InstitutionLocalServiceUtil.getById(parentInstitutionId));
		} else {
			presentParentInstitutions = InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
		} 
		
	 	if (hasParentInstitutionFiltered && hasInstitutionFiltered) {
			presentInstitutions.add(InstitutionLocalServiceUtil.getById(institutionId));
		} else {
			presentInstitutions = InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds, parentInstitutionId);
		}
		
		if (hasTermFiltered) {
			try {
				presentTerms.add(TermLocalServiceUtil.getById(termId));
			} catch (Exception e) {
				_log.error("can't add term id" + termId);
			} 
		} else {
			presentTerms = TermLocalServiceUtil.getTermsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
		}
		
		if (hasCategoryFiltered) {
			try {
				presentCategories.add(CategoryLocalServiceUtil.getById(categoryId));
			} catch (Exception e) {
				_log.error("can't add category with id" + categoryId);
			}
		} else {
			presentCategories = CategoryLocalServiceUtil.getCategoriesFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
		}
		//
		PortletURL portletURL = renderResponse.createRenderURL();
		// set parameter for search iterator or possible backURL
		portletURL.setParameter("parentInstitutionId", parentInstitutionId.toString());
		portletURL.setParameter("institutionId", institutionId.toString());
		portletURL.setParameter("termId", termId.toString());
		portletURL.setParameter("categoryId", categoryId.toString());
		portletURL.setParameter("creatorId", creatorId.toString());
		portletURL.setParameter("searchQuery", searchQuery);
		//
		boolean resultSetEmpty = true;
		if(presentParentInstitutions.size()>0||presentInstitutions.size()>0||presentTerms.size()>0||presentCategories.size()>0){
			resultSetEmpty=false;
		}
		//
		Institution insti = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			if(institutionId>0)insti=InstitutionLocalServiceUtil.getById(institutionId);
		} catch (Exception e) {
			_log.error("can't get insti bei id");
		}
		//
		Institution pInst = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			if(parentInstitutionId>0)pInst=InstitutionLocalServiceUtil.getById(parentInstitutionId);
		} catch (Exception e) {
			_log.error("can't get pInst bei id");
		}
		//
		Institution rInst = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			rInst=InstitutionLocalServiceUtil.getRootByParentAndCompanyAndGroup(0, companyId, groupId);
		} catch (Exception e) {
			_log.error("can't get rInst bei company and group id");
		}
		//
		renderRequest.setAttribute("parentInstitutionId", parentInstitutionId);
		renderRequest.setAttribute("institutionId", institutionId);
		renderRequest.setAttribute("termId", termId);
		renderRequest.setAttribute("categoryId", categoryId);
		renderRequest.setAttribute("creatorId", creatorId);
		renderRequest.setAttribute("searchQuery", searchQuery);
		renderRequest.setAttribute("maxTerms", maxTerms);
		renderRequest.setAttribute("hasInstitutionFiltered", hasInstitutionFiltered);
		renderRequest.setAttribute("hasParentInstitutionFiltered", hasParentInstitutionFiltered);
		renderRequest.setAttribute("hasTermFiltered", hasTermFiltered);
		renderRequest.setAttribute("hasCategoryFiltered", hasCategoryFiltered);
		renderRequest.setAttribute("isSearched", isSearched);
		renderRequest.setAttribute("reqLectureseries", reqLectureseries);
		renderRequest.setAttribute("lectureseriesIds", lectureseriesIds);
		renderRequest.setAttribute("videoIds", videoIds);
		renderRequest.setAttribute("presentParentInstitutions", presentParentInstitutions);
		renderRequest.setAttribute("presentInstitutions", presentInstitutions);
		renderRequest.setAttribute("presentTerms", presentTerms);
		renderRequest.setAttribute("presentCreators", presentCreators);
		renderRequest.setAttribute("presentCategories", presentCategories);
		renderRequest.setAttribute("portletURL", portletURL);
		renderRequest.setAttribute("resultSetEmpty", resultSetEmpty);
		//
		renderRequest.setAttribute("insti", insti);
		renderRequest.setAttribute("pInst", pInst);
		renderRequest.setAttribute("rInst", rInst);
		//		
	}
	public void renderDetails(RenderRequest renderRequest, RenderResponse renderResponse) {
		String objectType = ParamUtil.getString(renderRequest, "objectType");
		String password = renderRequest.getParameter("password");
		boolean objectExists = true;
		
		Long objectId = new Long(0);
		boolean secLink = false;
	   	String oid = renderRequest.getParameter("objectId");
		
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
	    	timeStart = new Long(ParamUtil.getString(renderRequest, "timeStart"));
	    	timeEnd = new Long(ParamUtil.getString(renderRequest, "timeEnd"));
	    }catch(Exception e){}
	   
	    Video video = VideoLocalServiceUtil.createVideo(0);
	    //lecture series object
	    Lectureseries lectureseries = LectureseriesLocalServiceUtil.createLectureseries(0);
	    
	    //Lecture series
	    if(objectType.equals("l")){
	    	try{
	    		lectureseries = LectureseriesLocalServiceUtil.getLectureseries(objectId);
	    		if(!secLink){
	    			try {video = VideoLocalServiceUtil.getVideo(lectureseries.getLatestOpenAccessVideoId());} catch (PortalException e1) {}
	    		}else{
	    			Long videoId = VideoLocalServiceUtil.getLatestClosedAccessVideoId(objectId);
	    			try {video = VideoLocalServiceUtil.getVideo(videoId);} catch (PortalException e1) {}
	    		}
	    	}catch(Exception e){ 
	    		objectExists = false;
	    		//response.setRenderParameter("jspPage","/noVideosFound.jsp");	
	    	}
	    }else if(objectType.equals("v")){
			try {video = VideoLocalServiceUtil.getVideo(objectId);} catch (PortalException e1) {}
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
				Cookie[] c = renderRequest.getCookies();
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
		    
		    renderRequest.setAttribute("videoLicense",l);
		    renderRequest.setAttribute("videoMetadata",m);
		    renderRequest.setAttribute("videoInstitutions",vi);
		    renderRequest.setAttribute("videoLectureseries",vl);
		    renderRequest.setAttribute("video",video);
		    renderRequest.setAttribute("relatedVideos",relatedVideos);
		    renderRequest.setAttribute("segments",segments);
		    renderRequest.setAttribute("lectureseries",lectureseries);
		    renderRequest.setAttribute("timeStart",timeStart);
		    renderRequest.setAttribute("timeEnd",timeEnd);
		    renderRequest.setAttribute("objectType",objectType);
		    renderRequest.setAttribute("objectId",oid);
		    
//		    if(video.getVideoId()==0) renderResponse.setProperty("jspPage","/noVideosFound.jsp");	
//		    else renderResponse.setProperty("jspPage","/viewDetails.jsp");	    	
	    }
	}
	
}