package de.uhh.l2g.plugins.admin.institutions.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.admin.institutions.constants.AdminInstitutionManagementPortletKeys;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Admin Institutions",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AdminInstitutionManagementPortletKeys.AdminInstitutionManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminInstitutionManagementPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(AdminInstitutionManagementPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		Institution root = InstitutionLocalServiceUtil.getByParentId(0).iterator().next();
		List<Institution> institutionsList = InstitutionLocalServiceUtil.getByParentId(root.getInstitutionId());
		PortletURL portletURL = renderResponse.createRenderURL();
		//Remote user
		User remoteUser = UserLocalServiceUtil.createUser(0);
		try { remoteUser = UserLocalServiceUtil.getUser(new Long(renderRequest.getRemoteUser())); } catch (Exception e1) {
			_log.error("user can't be fatched!");
		} 
		Lecture2GoRoleChecker l2goRole = new Lecture2GoRoleChecker(remoteUser);
		
		renderRequest.setAttribute("root", root);
		renderRequest.setAttribute("institutionsList", institutionsList);	
		renderRequest.setAttribute("portletURL", portletURL);	
		//permissions
		renderRequest.setAttribute("permissionAdmin", l2goRole.isL2gAdmin());				
		renderRequest.setAttribute("permissionProducer", l2goRole.isProducer());				
		renderRequest.setAttribute("permissionCoordinator", l2goRole.isCoordinator());
		
		super.render(renderRequest, renderResponse);
	}
}