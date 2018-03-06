package de.uhh.l2g.plugins.admin.terms.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;

import de.uhh.l2g.plugins.admin.terms.constants.TermsManagementPortletKeys;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Admin Terms",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + TermsManagementPortletKeys.TermsManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TermsManagementPortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(TermsManagementPortlet.class);

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String mvcPath = "";
		Long termId = new Long(0);
		Term t = TermLocalServiceUtil.createTerm(0);
		//
		mvcPath = renderRequest.getParameter("mvcPath");
		String backURL = renderRequest.getParameter("backURL");
		try{
			try {
				termId = new Long(renderRequest.getParameter("termId"));
				t = TermLocalServiceUtil.getTerm(termId);
			} catch (Exception e) {}
			renderRequest.setAttribute("term", t);
			renderRequest.setAttribute("backURL", backURL);
			renderResponse.setProperty("jspPage", mvcPath);
		}
		//show all
		catch (Exception e) {}
		super.render(renderRequest, renderResponse);
	}
	
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = request.getParameter("backURL");
		String y=request.getParameter("year");
		String p=request.getParameter("prefix");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		try {
			Term term = TermLocalServiceUtil.createTerm(0);
			term.setYear(y);
			term.setPrefix(p);
			term.setCreateDate(new Date());
			term.setUserName(user.getScreenName());
			term.setUserId(userId);
			TermLocalServiceUtil.addTerm(term);
			//
			TermLocalServiceUtil.addTerm(term);
		} catch (Exception e) {
			_log.warn("Unable to add new term entry!");
			SessionErrors.add(request, e.getClass().getName());
		}	
		//
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqTermId = new Long(request.getParameter("termId"));
		String backURL = request.getParameter("backURL");
		String y=request.getParameter("year");
		String p=request.getParameter("prefix");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = new Long(0);
		long groupId = new Long(0); 
		try {
			Term term = TermLocalServiceUtil.getTerm(reqTermId);
			term.setYear(y);
			term.setPrefix(p);
			term.setUserId(userId);
			term.setUserName(user.getScreenName());
			Company company = CompanyLocalServiceUtil.createCompany(0);
			companyId = CompanyLocalServiceUtil.getCompanyIdByUserId(userId);
			company = CompanyLocalServiceUtil.getCompany(companyId); 
			groupId = company.getGroup().getGroupId(); 
			term.setCompanyId(companyId);
			term.setGroupId(groupId);
			//
			TermLocalServiceUtil.updateTerm(term);
		} catch (Exception e) {
			_log.warn("Unable to update category.");
			SessionErrors.add(request, e.getClass().getName());
		}
		
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqTermId = new Long(request.getParameter("termId"));
		String backURL = request.getParameter("backURL");
		//Video_Term, Lecture_Term, Term
		TermLocalServiceUtil.deleteById(reqTermId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}