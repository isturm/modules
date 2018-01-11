package de.uhh.l2g.plugins.admin.creators.portlet;

import de.uhh.l2g.plugins.admin.creators.constants.CreatorsManagementPortletKeys;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Admin Creators",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + CreatorsManagementPortletKeys.CreatorsManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CreatorsManagementPortlet extends MVCPortlet {

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}
		
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = request.getParameterMap().get("backURL")[0];
		String fn=request.getParameter("firstName");
		String mn=request.getParameter("middleName");
		String ln=request.getParameter("lastName");
		String t=request.getParameter("jobTitle");
		if (isValid(fn, ln)) {
			Creator creator = CreatorLocalServiceUtil.createCreator(0);
			creator.setFirstName(fn);
			creator.setMiddleName(mn);
			creator.setLastName(ln);
			creator.setJobTitle(t);
			CreatorLocalServiceUtil.addCreator(creator);
			try {
				response.sendRedirect(backURL);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCreatorId = new Long(request.getParameterMap().get("creatorId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		String fn=request.getParameter("firstName");
		String mn=request.getParameter("middleName");
		String ln=request.getParameter("lastName");
		String t=request.getParameter("jobTitle");
		if (isValid(fn, ln)) {
			Creator creator = CreatorLocalServiceUtil.getCreator(reqCreatorId);
			creator.setFirstName(fn);
			creator.setMiddleName(mn);
			creator.setLastName(ln);
			creator.setJobTitle(t);
			creator.setFullName(fullName(fn, mn, ln, t));
			CreatorLocalServiceUtil.updateCreator(creator);
			try {
				response.sendRedirect(backURL);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCreatorId = new Long(request.getParameterMap().get("creatorId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		//Video_Creator, Lecture_Creator, Creator
		CreatorLocalServiceUtil.deleteById(reqCreatorId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isValid(String fn, String ln) {
		String _fn = fn.trim();
		String _ln = ln.trim();
		return !"".equals(_fn) && !"".equals(_ln) && _fn.length() > 1
				&& _ln.length() > 1;
	}

	private String fullName(String fn, String mn, String ln, String t) {
		return (t.trim() + " " + (fn.trim() + " " + mn.trim()).trim() + " " + ln
				.trim()).trim();
	}


}