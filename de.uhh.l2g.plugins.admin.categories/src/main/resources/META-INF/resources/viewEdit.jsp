<%@page import="de.uhh.l2g.plugins.model.Category" %>
<%@include file="init.jsp" %>

<jsp:useBean id="category" type="de.uhh.l2g.plugins.model.Category" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />

<portlet:actionURL name="edit" var="editURL">
	<portlet:param name="categoryId" value='${category.categoryId}' />
	<portlet:param name="backURL" value='${backURL}' />
</portlet:actionURL>

<div class="noresponsive">
	<aui:form action="<%=editURL%>" commandName="model">
		<aui:container cssClass='super-awesome-container'>
		        <aui:row>
		                <aui:col>
		                    <aui:input name="name" value="${category.name}" type="text" label="name"/> 
		                    <aui:input name="categoryId" value="${category.categoryId}" type="hidden"/>  
		                </aui:col>
		                <aui:col>
		                     <aui:button type="submit" value="edit" id="edit"/>
		                </aui:col>
		        </aui:row>
		</aui:container>
	</aui:form>
</div>