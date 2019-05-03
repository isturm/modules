<%@ include file="init.jsp" %>

<jsp:useBean id="permissionAdmin" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionProducer" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionCoordinator" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="portletURL" type="javax.portlet.PortletURL" scope="request" />

<jsp:useBean id="root" type="de.uhh.l2g.plugins.model.Institution" scope="request" />
<jsp:useBean id="institutionsList" type="java.util.List<Institution>" scope="request" />

<portlet:renderURL var="viewURL">
	<portlet:param name="jspPage" value="/admin/institutionList.jsp" />
</portlet:renderURL>

<div class="noresponsive">
		<%--ADD START--%>
		<c:if test="${permissionAdmin}">
			<aui:fieldset column="false" label="${pageName}" cssClass="add-institution" >
				<aui:fieldset>
					<aui:form action="${addURL}">
						<aui:input name="institution" label="institution" required="true" inlineField="true"/>
		            		<aui:select name="serverselect" id="select-streamer" label="streaming-server-name">
								<c:forEach items="${hostList}" var="host">
									<aui:option label="${host.name}" value="${host.hostId}"/>
								</c:forEach>
						    </aui:select>
					    <aui:input name='parent' type='hidden' inlineField="true" value='${root.institutionId}'/>
						<aui:button type="submit" value="add" ></aui:button>
					</aui:form>
		    	</aui:fieldset>
			</aui:fieldset>
		</c:if>
		<%--ADD END--%>
	
		<%--INSTITUTIONS START--%>
			<liferay-ui:search-container emptyResultsMessage="no-institutions-found" delta="10"  iteratorURL="${portletURL}">
				<liferay-ui:search-container-results>
					<%
						DisplayTerms displayTerms =searchContainer.getDisplayTerms();
						//String keywords = displayTerms.getKeywords(); 
						searchContainer.setTotal(institutionsList.size());		 
						searchContainer.setResults(ListUtil.subList(institutionsList, searchContainer.getStart(), searchContainer.getEnd()));
					%>
				</liferay-ui:search-container-results>
			
				<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Institution" modelVar="institution" keyProperty="institutionId"  escapedModel="<%= false %>" indexVar="i">
				        <liferay-ui:search-container-column-text name="institution" cssClass="toplevel-institutions">
								<portlet:actionURL name="delete" var="deleteURL">
									<portlet:param name="institutionId" value="${institution.institutionId}" />
								</portlet:actionURL>
									
						 		<aui:fieldset>
				 						<aui:form action="${updateURL}">
											<aui:input name="name" label="name" inlineField="true" value = "${institution.name}" />
											<aui:input name="order" label="order" inlineField="true" value='${institution.sort}'/>
											<%-- Only display streamer if user is allowed to view host and institution is child of top level --%>
											<c:if test='${institution.parentId == root.institutionId}'>
												<aui:input name="streaming-server-name" label="streaming-server-name" inlineField="true" value = "${istHost.name}" disabled="true"/>
											</c:if>
											<aui:input name="institutionId" type='hidden' inlineField="true" value = "${institution.institutionId}"/>
											<aui:input name="hostId" type='hidden' inlineField="true" value = "${host.hostId}"/>
											<aui:button type="submit" value="edit"></aui:button>
								 		</aui:form>
										<c:if test='<%=  InstitutionLocalServiceUtil.getLockingElements(institution.getInstitutionId()) < 1 %>'>
											<aui:button cssClass="subdelete" name="delete" value="delete" type="button" href="${deleteInstitutionURL}" />
										</c:if>
								</aui:fieldset>
						</liferay-ui:search-container-column-text>
		    	</liferay-ui:search-container-row>
		   	 	<liferay-ui:search-iterator searchContainer="${searchInstitutionContainer}" />
		</liferay-ui:search-container>
	<%--INSTITUTIONS END--%>

</div>