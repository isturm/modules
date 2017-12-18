package de.uhh.l2g.plugins.guest.openaccessvideos.portlet;

import de.uhh.l2g.plugins.guest.openaccessvideos.constants.OpenAccessVideosPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.openaccessvideos",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=de.uhh.l2g.plugins.guest.openaccessvideos Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + OpenAccessVideosPortletKeys.OpenAccessVideos,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OpenAccessVideosPortlet extends MVCPortlet {
}