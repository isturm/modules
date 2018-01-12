package de.uhh.l2g.plugins.admin.terms.portlet;

import de.uhh.l2g.plugins.admin.terms.constants.TermsManagementPortletKeys;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;

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
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}
		
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = request.getParameterMap().get("backURL")[0];
		String y=request.getParameter("year");
		String p=request.getParameter("prefix");
		Term term = TermLocalServiceUtil.createTerm(0);
		term.setYear(y);
		term.setPrefix(p);
		TermLocalServiceUtil.addTerm(term);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqTermId = new Long(request.getParameterMap().get("termId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		String y=request.getParameter("year");
		String p=request.getParameter("prefix");
		Term term = TermLocalServiceUtil.getTerm(reqTermId);
		term.setYear(y);
		term.setPrefix(p);
		TermLocalServiceUtil.updateTerm(term);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqTermId = new Long(request.getParameterMap().get("termId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		//Video_Term, Lecture_Term, Term
		TermLocalServiceUtil.deleteById(reqTermId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}