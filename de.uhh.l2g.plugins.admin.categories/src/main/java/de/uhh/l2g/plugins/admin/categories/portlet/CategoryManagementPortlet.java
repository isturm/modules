package de.uhh.l2g.plugins.admin.categories.portlet;

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

import de.uhh.l2g.plugins.admin.categories.constants.CategoryManagementPortletKeys;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;

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

	private static final Log _log = LogFactoryUtil.getLog(CategoryManagementPortlet.class);

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String mvcPath = "";
		Long catId = new Long(0);
		Category c = CategoryLocalServiceUtil.createCategory(0);
		//
		mvcPath = renderRequest.getParameter("mvcPath");
		String backURL = renderRequest.getParameter("backURL");
		try{
			try {
				catId = new Long(renderRequest.getParameter("categoryId"));
				c = CategoryLocalServiceUtil.getCategory(catId);
			}catch (Exception e) {}
			renderRequest.setAttribute("category", c);
			renderRequest.setAttribute("backURL", backURL);
			renderResponse.setProperty("jspPage", mvcPath);
		}
		//show all
		catch (Exception e) {}
		super.render(renderRequest, renderResponse);
	}
	
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = request.getParameter("backURL");
		String name=request.getParameter("name");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = new Long(0);
		long groupId = new Long(0); 
		try {
			Category category = CategoryLocalServiceUtil.createCategory(0);
			category.setName(name);
			category.setUserName(user.getScreenName());
			category.setCreateDate(new Date());
			category.setUserId(userId);
			//
			Company company = CompanyLocalServiceUtil.createCompany(0);
			companyId = CompanyLocalServiceUtil.getCompanyIdByUserId(userId);
			company = CompanyLocalServiceUtil.getCompany(companyId); 
			groupId = company.getGroup().getGroupId(); 
			category.setCompanyId(companyId);
			category.setGroupId(groupId);
			CategoryLocalServiceUtil.addCategory(category);
		} catch (Exception e) {
			_log.error("Unable to add new category entry!");
			SessionErrors.add(request, e.getClass().getName());
		}	
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCategoryId = new Long(request.getParameter("categoryId"));
		String backURL = request.getParameter("backURL");
		String name=request.getParameter("name");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		try {
			Category category = CategoryLocalServiceUtil.getCategory(reqCategoryId);
			category.setName(name);
			category.setUserName(user.getScreenName());
			category.setUserId(userId);
			CategoryLocalServiceUtil.updateCategory(category);
		} catch (Exception e) {
			_log.error("Unable to update category.");
			SessionErrors.add(request, e.getClass().getName());
		}
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCategoryId = new Long(request.getParameter("categoryId"));
		String backURL = request.getParameter("backURL");
		//Video_Term, Lecture_Term, Term
		CategoryLocalServiceUtil.deleteById(reqCategoryId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}