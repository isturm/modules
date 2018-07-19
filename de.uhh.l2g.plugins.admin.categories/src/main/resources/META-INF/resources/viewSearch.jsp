<%@include file="init.jsp" %>

<%
	int cId = ParamUtil.getInteger(request, "cId");
	String cName = ParamUtil.getString(request, "cName");
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<c:set var="cId" value="<%= cId==0 ? " ":cId %>"/>
<c:set var="cName" value="<%=ParamUtil.getString(request, "cName")%>"/>
<c:set var="displayTerms" value="<%=displayTerms%>"/>

<liferay-ui:search-toggle buttonLabel="category-search" displayTerms="${displayTerms}" id="toggle_id_category_search">
	<aui:input label="id" name="cId" value='${cId}'/> <!-- If Id = 0 then set blank in field -->
	<aui:input label="name" name="cName" value='${cName}'/>
</liferay-ui:search-toggle>

