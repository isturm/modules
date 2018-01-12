package de.uhh.l2g.plugins.admin.categories.portlet;

import de.uhh.l2g.plugins.admin.categories.constants.CategoryManagementPortletKeys;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;

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
		"javax.portlet.display-name=Admin Categories",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + CategoryManagementPortletKeys.CategoryManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class CategoryManagementPortlet extends MVCPortlet {

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}
		
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = request.getParameterMap().get("backURL")[0];
		String name=request.getParameter("name");
		Category category = CategoryLocalServiceUtil.createCategory(0);
		category.setName(name);
		CategoryLocalServiceUtil.addCategory(category);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCategoryId = new Long(request.getParameterMap().get("categoryId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		String name=request.getParameter("name");

		Category category = CategoryLocalServiceUtil.getCategory(reqCategoryId);
		category.setName(name);
		CategoryLocalServiceUtil.updateCategory(category);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCategoryId = new Long(request.getParameterMap().get("categoryId")[0]);
		String backURL = request.getParameterMap().get("backURL")[0];
		//Video_Term, Lecture_Term, Term
		CategoryLocalServiceUtil.deleteById(reqCategoryId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}