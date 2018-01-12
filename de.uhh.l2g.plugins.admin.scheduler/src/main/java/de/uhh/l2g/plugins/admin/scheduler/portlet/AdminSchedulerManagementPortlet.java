package de.uhh.l2g.plugins.admin.scheduler.portlet;

import de.uhh.l2g.plugins.admin.scheduler.constants.AdminSchedulerManagementPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.scheduler.SchedulerException;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=de.uhh.l2g.plugins.admin.scheduler Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AdminSchedulerManagementPortletKeys.AdminSchedulerManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminSchedulerManagementPortlet extends MVCPortlet {
	
	public AdminSchedulerManagementPortlet(){
		AutocompleteScheduler acs = new AutocompleteScheduler();
		Map<String, Object> properties = new HashMap<>();
		properties.put("cron.expression", "0 */1 * * * ?");
		try {
			acs.activate(properties);
		} catch (SchedulerException e) {
			//
			e.printStackTrace();
		}
	}
}