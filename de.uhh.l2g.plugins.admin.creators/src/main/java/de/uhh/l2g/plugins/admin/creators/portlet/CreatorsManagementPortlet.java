package de.uhh.l2g.plugins.admin.creators.portlet;

import de.uhh.l2g.plugins.admin.creators.constants.CreatorsManagementPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.creators",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=de.uhh.l2g.plugins.admin.creators Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CreatorsManagementPortletKeys.CreatorsManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CreatorsManagementPortlet extends MVCPortlet {
}