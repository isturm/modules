package de.uhh.l2g.plugins.guest.videos.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.util.AutocompleteManager;

/**
 * @author isturm
 */

@Component(
	immediate = true,
	property = {
	    "com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
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
		"javax.portlet.name=" + OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS ,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class 
)
public class OpenAccessVideosPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(OpenAccessVideosPortlet.class);
	
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
		
		//--- Autocomplete start
		//getting task name to do
	    String task = resourceRequest.getParameter("task");
	    if (Validator.isNull(task)) {
	        return;
	    }
	    switch (task) {
	        case"findVideos":
	        	// get writer for write data
	        	PrintWriter out = resourceResponse.getWriter();
	        	JSONArray searchWordsJsonArray = JSONFactoryUtil.createJSONArray();
	            searchWordsJsonArray = AutocompleteManager.SEARCH_WORDS_JSONArray;
	            _log.info("Search words array size" + searchWordsJsonArray.length());
	            out.println(searchWordsJsonArray.toString());
	            _log.info("End serveResource method");	
	            break;
	    }
		//--- Autocomplete end
	}
	
	public static JSONArray wordsJSONArray = JSONFactoryUtil.createJSONArray();
	
	private void getSearchWords(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		PrintWriter out = resourceResponse.getWriter();
		out.println(wordsJSONArray);
	}
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String searchQuery = ParamUtil.getString(actionRequest, "findVideos", "");
		System.out.println(searchQuery);
		actionResponse.addProperty("findVideos",searchQuery);
	}
	
}