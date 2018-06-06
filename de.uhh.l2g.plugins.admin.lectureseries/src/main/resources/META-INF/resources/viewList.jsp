<%@page import="de.uhh.l2g.plugins.service.CategoryLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.TermLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.CreatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.model.Producer"%>
<%@page import="de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.ProducerLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries"%>
<%@page import="de.uhh.l2g.plugins.model.Producer"%>
<%@page import="de.uhh.l2g.plugins.model.Coordinator"%>
<%@page import="de.uhh.l2g.plugins.model.Institution"%>
<%@page import="de.uhh.l2g.plugins.model.Creator"%>
<%@page import="de.uhh.l2g.plugins.model.Term"%>
<%@page import="de.uhh.l2g.plugins.model.Category"%>

<%@include file="init.jsp"%>

<%
	Long companyId = company.getCompanyId();
	Long groupId = company.getGroup().getGroupId();		

	String name = User.class.getName();
	User u = UserLocalServiceUtil.getUser(new Long (request.getRemoteUser()));

	Map<String,String> institutions = new LinkedHashMap<String, String>();
	List<Producer> producers = new ArrayList<Producer>();
	
	List<Lectureseries> tempLectureseriesList = new ArrayList();
	List<Term> semesters = TermLocalServiceUtil.getAllSemesters();
	
	Long institutionId = ParamUtil.getLong(request, "institutionId");
	Long producerId = ParamUtil.getLong(request, "producerId");
	Long semesterId = ParamUtil.getLong(request, "semesterId");
	Integer statusId = ParamUtil.getInteger(request, "statusId");
	//
	String delta = request.getParameter("delta");
	String cur = request.getParameter("cur");
	//
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("institutionId", institutionId+"");
	portletURL.setParameter("producerId", producerId+"");
	portletURL.setParameter("semesterId", semesterId+"");
	portletURL.setParameter("statusId", statusId+"");

	if(permissionAdmin){
		institutions = InstitutionLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		producers = ProducerLocalServiceUtil.getAllProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		permissionCoordinator = false;
		permissionProducer = false;
	}
	
	if(permissionCoordinator){
		Coordinator c = CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId());
		if(institutionId==0)institutionId = c.getInstitutionId();
		institutions = InstitutionLocalServiceUtil.getByParent(c.getInstitutionId());
		producers = ProducerLocalServiceUtil.getProducersByInstitutionId(c.getInstitutionId());
	}	
	
	if(permissionProducer){
		Producer p = ProducerLocalServiceUtil.getProducer(remoteUser.getUserId());
		producerId = p.getProducerId();
	}
	PortletURL backURL = portletURL;
	backURL.setParameter("delta", delta);
	backURL.setParameter("cur", cur);

	String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());
%>

<c:set var="backURL" value="<%=backURL%>"/>
<c:set var="pageName" value="<%=pageName%>"/>

<c:set var="portletURL" value="<%=portletURL%>"/>
<c:set var="application" value="<%=application%>"/>
<c:set var="displayTerms" value="<%=new DisplayTerms(renderRequest)%>"/>

<liferay-portlet:renderURL var="addURL">
	<portlet:param name="backURL" value='${backURL}' />
    <portlet:param name="mvcPath" value="/viewEdit.jsp" />
</liferay-portlet:renderURL>

<div class="view list">		
	<aui:fieldset helpMessage='<liferay-ui:message key="choose-filter"/>' column="true" cssClass="list">
					<%if(permissionAdmin || permissionCoordinator){ %>
							<portlet:renderURL var="sortByInstitution">
								<portlet:param name="jspPage" value="/viewList.jsp" />
								<portlet:param name="producerId" value="<%=producerId.toString()%>"/>
								<portlet:param name="semesterId" value="<%=semesterId.toString()%>"/>
								<portlet:param name="statusId" value="<%=statusId.toString()%>"/>
							</portlet:renderURL>
							<aui:form action="<%= sortByInstitution.toString() %>" method="post">
								<aui:select name="institutionId" label="" onChange="submit();">
									<aui:option value=""><liferay-ui:message key="select-institution"/></aui:option>
									<%for (Map.Entry<String, String> f : institutions.entrySet()) {
											if(f.getKey().equals(institutionId.toString())){
												%>
												<aui:option value='<%=f.getKey()%>' selected="true"><%=f.getValue()%></aui:option>
												<%}else{%>
												<aui:option value='<%=f.getKey()%>'><%=f.getValue()%></aui:option>
												<%}	
									}%>
								</aui:select>
							</aui:form>	

							<portlet:renderURL var="sortByProducer">
								<portlet:param name="jspPage" value="/viewList.jsp" />
								<portlet:param name="institutionId" value="<%=institutionId.toString()%>"/>
								<portlet:param name="semesterId" value="<%=semesterId.toString()%>"/>
								<portlet:param name="statusId" value="<%=statusId.toString()%>"/>
							</portlet:renderURL>
							<aui:form action="<%=sortByProducer.toString() %>" method="post">
								<aui:select name="producerId" label="" onChange="submit();">
									<aui:option value=""><liferay-ui:message key="select-producer"/></aui:option>
									<%for (int i = 0; i < producers.size(); i++) {
											if(producers.get(i).getProducerId()==producerId){
												%>
												<aui:option value='<%=producers.get(i).getProducerId()%>' selected="true"><%=producers.get(i).getLastName()+", "+producers.get(i).getFirstName()%></aui:option>
												<%}else{%>
												<aui:option value='<%=producers.get(i).getProducerId()%>'><%=producers.get(i).getLastName()+", "+producers.get(i).getFirstName()%></aui:option>
												<%}					
									}%>
								</aui:select>
							</aui:form>	
					<%}%>		
							<portlet:renderURL var="sortBySemester">
								<portlet:param name="jspPage" value="/viewList.jsp" />
								<portlet:param name="institutionId" value="<%=institutionId.toString()%>"/>
								<portlet:param name="statusId" value="<%=statusId.toString()%>"/>
								<portlet:param name="producerId" value="<%=producerId.toString()%>"/>
							</portlet:renderURL>
							<aui:form action="<%= sortBySemester.toString() %>" method="post">
								<aui:select name="semesterId" label="" onChange="submit();">
									<aui:option value=""><liferay-ui:message key="select-semester"/></aui:option>
									<%for (int i = 0; i < semesters.size(); i++) {
											if(semesterId==semesters.get(i).getTermId()){
												%>
												<aui:option value='<%=semesters.get(i).getTermId()%>' selected="true"><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
												<%}else{%>
												<aui:option value='<%=semesters.get(i).getTermId()%>'><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
												<%}					
									}%>
								</aui:select>
							</aui:form>		
									
							<portlet:renderURL var="sortByStatus">
								<portlet:param name="jspPage" value="/viewList.jsp" />
								<portlet:param name="institutionId" value="<%=institutionId.toString()%>"/>
								<portlet:param name="producerId" value="<%=producerId.toString()%>"/>
								<portlet:param name="semesterId" value="<%=semesterId.toString()%>"/>
							</portlet:renderURL>
							<aui:form action="<%= sortByStatus.toString() %>" method="post">
								<aui:select name="statusId" label="" onChange="submit();">
									<aui:option value="3"><liferay-ui:message key="select-status"/></aui:option>
											<%if(statusId==0){%>
												<aui:option value='0' selected="true"><liferay-ui:message key="approved-false"/></aui:option>
											<%}else{%>
												<aui:option value='0'><liferay-ui:message key="approved-false"/></aui:option>
											<%}%>				
											<%if(statusId==1){%>
												<aui:option value='1' selected="true"><liferay-ui:message key="approved-true"/></aui:option>
											<%}else{%>
												<aui:option value='1'><liferay-ui:message key="approved-true"/></aui:option>
											<%}%>
								</aui:select>
							</aui:form>
	</aui:fieldset>   

	<a href="${addURL}" class="add link">
	    <liferay-ui:message key="add-new-lectureseries"/> <span class="icon-large icon-plus-sign"/>
	</a>

	<liferay-ui:search-container emptyResultsMessage="no-lectureseries-found" delta="10" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
	<liferay-ui:search-form page="/viewSearch.jsp" servletContext="${application}" />
		<liferay-ui:search-container-results>
			<%
				DisplayTerms displayTerms =searchContainer.getDisplayTerms();
				String keywords = displayTerms.getKeywords(); 
				List<Lectureseries> lectureseriesList =  Collections.EMPTY_LIST;
				if (displayTerms.isAdvancedSearch()) {//Advance Search

				} else if(!Validator.isBlank(keywords)){//Basic Search
					//lectureseriesList = LectureseriesLocalServiceUtil.getByKeyWords(keywords);
				} else{//No Search
					lectureseriesList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(statusId, semesterId, new Long(institutionId), new Long(producerId), groupId, companyId);
				}  
			    searchContainer.setTotal(lectureseriesList.size());		 
			    searchContainer.setResults(ListUtil.subList(lectureseriesList, searchContainer.getStart(), searchContainer.getEnd()));
			%>				
		</liferay-ui:search-container-results>
	
		<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Lectureseries" keyProperty="lectureseriesId" modelVar="lectser">
			<portlet:actionURL name="viewLectureseries" var="editURL">
				<portlet:param name="lectureseriesId" value="<%= String.valueOf(lectser.getLectureseriesId())%>" />
				<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>
			</portlet:actionURL>
			<%
				String lTerm=TermLocalServiceUtil.getById(lectser.getTermId()).getTermName();
			%>
			<liferay-ui:search-container-column-text name="name">
				<div class="adminrow wide">
					<div class="admintile wide">
						<strong><%=lectser.getName()%> (<%=lTerm%>)</strong><br/>
						<p><a href="<%=lectser.getClosedAccessURI() %>" target="blank"><liferay-ui:message key="lecture-series-closed-access-uri"/></a>&nbsp;|&nbsp;<a href="<%=lectser.getOpenAccessURI() %>" target="blank"><liferay-ui:message key="lecture-series-open-access-uri"/></a></p>
						<br/>
						<%
						List<Long> pIds = new ArrayList<Long>();
						String prds = "";
							try{
								pIds = ProducerLocalServiceUtil.getAllProducerIds(lectser.getLectureseriesId());
								for (int i = 0; i < pIds.size(); i++) {
									Long pLid = new Long(pIds.get(i)+"");
									Producer p = ProducerLocalServiceUtil.createProducer(0);
									p=ProducerLocalServiceUtil.getProdUcer(pLid);
									prds+="<p>"+p.getLastName()+", "+ p.getFirstName()+"</p>";
								}
							}catch(Exception e){}
			 			%>
			 			<%=prds %>
			 			<br />
			 			<c:if test="<%= lectser.getNumberOfVideos() >0 %>">
			 				<p>
				 				<%= lectser.getNumberOfVideos() %> 
				 				<c:if test="<%= lectser.getNumberOfVideos() >1 %>"><liferay-ui:message key="video-datasets"/></c:if>
				 				<c:if test="<%= lectser.getNumberOfVideos() ==1 %>"><liferay-ui:message key="video-dataset"/></c:if>
			 				</p>
			 			</c:if>
			 			<c:if test="<%= lectser.getNumberOfVideos() ==0 %>">
			 				<p><liferay-ui:message key="no-videos-uploaded"/></p>
			 			</c:if>			 			
			 		</div>
			 		<div class="admintile wide icons">
						<portlet:actionURL name="removeLectureseries" var="removeURL">
							<portlet:param name="lectureseriesId" value='<%=""+lectser.getLectureseriesId()%>' />
							<portlet:param name="backURL" value='<%=String.valueOf(portletURL)%>' />
						</portlet:actionURL>
						<%if(lectser.getNumberOfVideos()>0 || (permissionProducer && lectser.getApproved()==1)){ %>
						<%}else{%>
							<a href="<%=removeURL.toString()%>">
								<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
							</a>
						<%}%>
						<a href="<%=editURL.toString()%>">
					   		<span class="icon-large icon-pencil"></span>
						</a>					
					</div>
				</div>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>