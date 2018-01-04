package de.uhh.l2g.plugins.admin.statistics.portlet;

import de.uhh.l2g.plugins.admin.statistics.constants.StatisticManagementPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=de.uhh.l2g.plugins.admin.statistics Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StatisticManagementPortletKeys.StatisticManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StatisticManagementPortlet extends MVCPortlet {
}