package de.uhh.l2g.plugins.admin.threads.portlet;

import de.uhh.l2g.plugins.admin.threads.constants.ThreadManagementPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.cronjobs",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=de.uhh.l2g.plugins.admin.threads Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ThreadManagementPortletKeys.ThreadManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ThreadManagementPortlet extends MVCPortlet {
}