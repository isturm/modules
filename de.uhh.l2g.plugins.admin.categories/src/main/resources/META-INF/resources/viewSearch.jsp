<%@include file="init.jsp" %>

<%
	int cId = ParamUtil.getInteger(request, "cId");
	String cName = ParamUtil.getString(request, "cName");
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle buttonLabel="category-search" displayTerms="<%= displayTerms %>" id="toggle_id_category_search">
	<aui:input label="id" name="cId" value='<%= cId==0 ? " ":cId %>'/> <!-- If Id = 0 then set blank in field -->
	<aui:input label="name" name="cName" value='<%= cName %>'/>
</liferay-ui:search-toggle>

<br/>