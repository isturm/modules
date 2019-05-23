<%@ include file="init.jsp" %>

<jsp:useBean id="portletURL" type="javax.portlet.PortletURL" scope="request" />
<jsp:useBean id="l2goRoles" type="java.util.List<com.liferay.portal.kernel.model.Role>" scope="request" />
<jsp:useBean id="l2goUsers" type="java.util.List<User>" scope="request" />

<c:set var="application" value="<%=application%>"/>
<c:set var="displayTerms" value="<%=new DisplayTerms(renderRequest)%>"/>
<c:set var="backURL" value="<%=String.valueOf(PortalUtil.getCurrentCompleteURL(request))%>"/>

<div class="noresponsive">
	<aui:fieldset helpMessage="choose-filter" column="true" cssClass="list">
		<portlet:actionURL name="/select" var="selectURL" />
		<form  action="${selectURL}" method="post">
			<aui:select name="roleId" label="" onChange="submit();">
				<aui:option value=""><liferay-ui:message key="select-l2go-role"/></aui:option>
				<c:forEach items="${l2goRoles}" var ="role">
					<aui:option value='${role.roleId}'>${role.name}</aui:option>
				</c:forEach>
			</aui:select>
		</form>
	</aui:fieldset>
</div>

<liferay-ui:search-container emptyResultsMessage="no-users-found" delta="10" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
			<liferay-ui:search-form page="/viewSearch.jsp" servletContext="${application}" />
			<liferay-ui:search-container-results>
				<%
					DisplayTerms displayTerms =searchContainer.getDisplayTerms();
					String keywords = displayTerms.getKeywords(); 
					searchContainer.setTotal(l2goUsers.size());		 
					searchContainer.setResults(ListUtil.subList(l2goUsers, searchContainer.getStart(), searchContainer.getEnd()));
				%>
			</liferay-ui:search-container-results>
		
			<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User" keyProperty="userId" modelVar="usr">
				<c:set var="userId" value="<%=usr.getUserId()%>"/>
				
				<liferay-ui:search-container-column-text>
					${usr.fullName}
					<br/>
					<c:set var="roles" value="<%=usr.getRoles()%>"/>
					<c:set var="n" value=""/>
					<c:forEach items="${roles}" var="item">
						<c:set var="n" value="<%=TextManager.getRolesDescription(usr)%>"/>
					</c:forEach>
					${n}
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text>
					<portlet:renderURL var="editURL">
						<portlet:param name="userId" value='${userId}' />
						<portlet:param name="backURL" value='${backURL}' />
						<portlet:param name="mvcRenderCommandName" value="/edit"/>
					</portlet:renderURL>					
					<a href="${editURL}" title="<liferay-ui:message key='edit'/>">
					   <span class="icon-large icon-pencil"></span>
					</a>
				</liferay-ui:search-container-column-text>				
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>