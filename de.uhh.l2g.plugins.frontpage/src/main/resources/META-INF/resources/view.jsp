<%@page import="de.uhh.l2g.plugins.service.VideoLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.model.Video"%>

<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>

<%
	//get popular videos
	//example -> top 10
	List<Video> popular = VideoLocalServiceUtil.getPopular(12);
	ListIterator<Video> pli = popular.listIterator();
%>

<%@ include file="/init.jsp" %>
<p>
	<b><liferay-ui:message key="de.uhh.l2g.plugins.frontpage.caption"/></b>
</p>