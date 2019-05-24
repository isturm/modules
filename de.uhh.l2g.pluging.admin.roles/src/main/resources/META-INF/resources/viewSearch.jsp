<%@ include file="init.jsp" %>

<%
	String fullName = ParamUtil.getString(request, "fullName");
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle buttonLabel="user-search" displayTerms="<%= displayTerms %>" id="toggle_id_user_search">
</liferay-ui:search-toggle>

<br/>