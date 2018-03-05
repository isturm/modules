<%@include file="init.jsp" %>
<%
	String jobTitle = ParamUtil.getString(request, "jobTitle");
	String firstName = ParamUtil.getString(request, "firstName");
	String middleName = ParamUtil.getString(request, "middleName");
	String lastName = ParamUtil.getString(request, "lastName");
	String fullName = ParamUtil.getString(request, "fullName");
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle buttonLabel="creators-search" displayTerms="<%= displayTerms %>" id="toggle_id_creators_search">
	<aui:input label="job-title" name="jobTitle" value='<%= jobTitle %>'/>
	<aui:input label="first-name" name="firstName" value='<%= firstName %>'/>
	<aui:input label="middle-name" name="middleName" value='<%= middleName %>'/>
	<aui:input label="last-name" name="lastName" value='<%= lastName %>'/>
	<aui:input label="full-name" name="fullName" value='<%= fullName %>'/>
</liferay-ui:search-toggle>

<br/>