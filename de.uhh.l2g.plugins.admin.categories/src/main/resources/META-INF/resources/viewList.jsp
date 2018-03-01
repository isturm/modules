<%@page import="de.uhh.l2g.plugins.model.Video_Category"%>
<%@page import="de.uhh.l2g.plugins.model.Category"%>
<%@page import="de.uhh.l2g.plugins.service.CategoryLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil"%>

<%@include file="init.jsp"%>

<%
	int cId = ParamUtil.getInteger(request, "cId");
	String cName = ParamUtil.getString(request, "cName");
	PortletURL portletURL = renderResponse.createRenderURL();
	
	String delta = "";
	String cur = ""; 
	try{new Long(delta = request.getParameterMap().get("delta")[0]).toString();}catch(Exception e){}
	try{new Long(cur = request.getParameterMap().get("cur")[0]).toString();}catch(Exception e){}
	PortletURL backURL = portletURL;
	backURL.setParameter("delta", delta);
	backURL.setParameter("cur", cur);

	String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());
%> 
 
<liferay-portlet:renderURL varImpl="categoriesSearchURL">
    <portlet:param name="mvcPath" value="/viewList.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="addURL">
	<portlet:param name="backURL" value='<%=backURL.toString()%>' />
    <portlet:param name="mvcPath" value="/viewEdit.jsp" />
</liferay-portlet:renderURL>
	
<div class="view list">		
	<a href="${addURL}" class="add link">
	    <liferay-ui:message key="add-new-category"/> <span class="icon-large icon-plus-sign"/>
	</a>
			
	<aui:form action="<%= categoriesSearchURL %>" method="post" name="fm">
		<liferay-ui:search-container emptyResultsMessage="no-categories-found" delta="5" iteratorURL="<%= portletURL %>" displayTerms="<%= new DisplayTerms(renderRequest) %>">
			<liferay-ui:search-form page="/viewSearch.jsp" servletContext="<%= application %>" />
			<liferay-ui:search-container-results>
				<%
					DisplayTerms displayTerms =searchContainer.getDisplayTerms();
					String keywords = displayTerms.getKeywords(); 
					List<Category> categoriesList =  Collections.EMPTY_LIST;
					if (displayTerms.isAdvancedSearch()) {//Advance Search
						categoriesList = CategoryLocalServiceUtil.getByIdOrAndTitle(cId,cName,displayTerms.isAndOperator());

						searchContainer.setTotal(categoriesList.size());
		                searchContainer.setResults(ListUtil.subList(categoriesList,searchContainer.getStart(),searchContainer.getEnd()));
					
					} else if(!Validator.isBlank(keywords)){//Basic Search
						categoriesList = CategoryLocalServiceUtil.getByKeyWords(keywords);
						searchContainer.setTotal(categoriesList.size());
		                searchContainer.setResults(ListUtil.subList(categoriesList,searchContainer.getStart(),searchContainer.getEnd()));
					}
					else{//No Search
						 categoriesList = CategoryLocalServiceUtil.getAllCategories(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
						 searchContainer.setTotal(categoriesList.size());		 
						 searchContainer.setResults(ListUtil.subList(categoriesList,searchContainer.getStart(),searchContainer.getEnd()));
					}  
				%>
			</liferay-ui:search-container-results>
		
			<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Category" keyProperty="categoryId" modelVar="category">
				<% 
					Long catIdLong = category.getCategoryId();
					String catIdString = catIdLong.toString(); 
					//count videos from category
					List<Video_Category> vcl = Video_CategoryLocalServiceUtil.getByCategory(catIdLong);
					int count = vcl.size();
				%>
				
				<portlet:actionURL name="delete" var="removeURL">
					<portlet:param name="categoryId" value='<%=catIdString%>' />
					<portlet:param name="backURL" value='<%=backURL.toString()%>' />
				</portlet:actionURL>		

				<portlet:renderURL var="editURL">
					<portlet:param name="categoryId" value='<%=catIdString%>' />
					<portlet:param name="mvcPath" value="/viewEdit.jsp" />
					<portlet:param name="backURL" value='<%=backURL.toString()%>' />
				</portlet:renderURL>

				<liferay-ui:search-container-column-text>
					${category.name}
					<%if(count>0){%>
						<p><b><%=count%></b> <liferay-ui:message key="video-s"/></p>
					<%}%>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text>
						<a href="<%=editURL.toString()%>" title="<liferay-ui:message key='edit'/>">
						   <span class="icon-large icon-pencil"></span>
						</a>
						<%if(count==0){%>						
						<a href="<%=removeURL.toString()%>" title="<liferay-ui:message key='delete'/>">
							<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
						</a>	
						<%}%>				
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>	
	</aui:form>
</div>