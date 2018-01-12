<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@

taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.model.User" %>
<%@page import="com.liferay.portal.kernel.model.PortletPreferences" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<%@page import="java.util.LinkedHashMap"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>

<%@page import="org.springframework.web.bind.ServletRequestUtils"%>

<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONException"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>

<%@page import="de.uhh.l2g.plugins.util.Lecture2GoRoleChecker"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	//check lecture2go user permissions
	User remoteUser = UserLocalServiceUtil.createUser(0);
	//l2go administrator is logged in
	boolean permissionAdmin = false;
	//l2go coordinator is logged in
	boolean permissionCoordinator = false;
	//l2go producer is logged in
	boolean permissionProducer = false;
	//l2go student is logged in
	boolean permissionStudent = false;

try{
	Lecture2GoRoleChecker rcheck = new Lecture2GoRoleChecker();
	remoteUser = UserLocalServiceUtil.getUser(new Long (request.getRemoteUser()));
	permissionAdmin = rcheck.isL2gAdmin(remoteUser);
	permissionCoordinator = rcheck.isCoordinator(remoteUser);
	permissionProducer = rcheck.isProducer(remoteUser);
	permissionStudent = rcheck.isStudent(remoteUser);
	if(permissionAdmin){
		permissionCoordinator=false;
		permissionProducer=false;
		permissionStudent=false;
	}else{
		if(permissionCoordinator){
			permissionProducer=false;
			permissionStudent=false;		
		}else{
			if(permissionProducer){
				permissionStudent=false;
			}
		}
	}
}catch(Exception e){
	//
	int i = 0;
}
%>