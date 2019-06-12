<%@include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle buttonLabel="videos-search" displayTerms="<%= displayTerms %>" id="toggle_id_videos_search">
</liferay-ui:search-toggle>

