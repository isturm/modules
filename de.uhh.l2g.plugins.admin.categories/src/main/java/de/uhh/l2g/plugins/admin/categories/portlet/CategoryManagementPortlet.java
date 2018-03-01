package de.uhh.l2g.plugins.admin.categories.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
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
import com.liferay.portal.kernel.util.PropertiesParamUtil;

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
		try{
			catId = new Long(renderRequest.getParameter("categoryId"));
			mvcPath = renderRequest.getParameter("mvcPath");
			String backURL = renderRequest.getParameterMap().get("backURL")[0];
			try {
				c = CategoryLocalServiceUtil.getCategory(catId);
				renderRequest.setAttribute("category", c);
				renderRequest.setAttribute("backURL", backURL);
				renderResponse.setProperty("jspPage", mvcPath);
			} catch (PortalException e) {
				_log.error("Category fatching failed!");
			}
		}catch (Exception e) {
			_log.info("Show category list!");
		}
		super.render(renderRequest, renderResponse);
	}
	
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = request.getParameterMap().get("backURL")[0];
		String name=request.getParameter("name");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = new Long(0);
		long groupId = new Long(0); 
		//
		Category category = CategoryLocalServiceUtil.createCategory(0);
		category.setName(name);
		category.setUserName(user.getScreenName());
		category.setCreateDate(new Date());
		category.setUserName(user.getScreenName());
		category.setUserId(userId);
		//
		Company company = CompanyLocalServiceUtil.createCompany(0);
		try {
			companyId = CompanyLocalServiceUtil.getCompanyIdByUserId(userId);
			company = CompanyLocalServiceUtil.getCompany(companyId); 
			groupId = company.getGroup().getGroupId(); 
			category.setCompanyId(companyId);
			category.setGroupId(groupId);
			CategoryLocalServiceUtil.addCategory(category);
		} catch (Exception e1) {
			_log.warn("Unable to add new category entry!");
		}	
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
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = new Long(0);
		long groupId = new Long(0); 
		Category category = CategoryLocalServiceUtil.getCategory(reqCategoryId);
		category.setName(name);
		category.setUserName(user.getScreenName());
		category.setUserId(userId);
		//
		Company company = CompanyLocalServiceUtil.createCompany(0);
		try {
				companyId = CompanyLocalServiceUtil.getCompanyIdByUserId(userId);
				company = CompanyLocalServiceUtil.getCompany(companyId); 
				groupId = company.getGroup().getGroupId(); 
				category.setCompanyId(companyId);
				category.setGroupId(groupId);
		} catch (Exception e1) {
			_log.warn("Unable to fulfill companyId for categoryId: "+category.getCategoryId());
		}
		//
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