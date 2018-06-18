<%@include file="init.jsp"%>

<jsp:useBean id="categories" type="java.util.List<de.uhh.l2g.plugins.model.Category>" scope="request" />
<jsp:useBean id="lectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="institutions" type="java.util.LinkedHashMap" scope="request" />
<jsp:useBean id="institutionId" type="java.lang.Long" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />
<jsp:useBean id="terms" type="java.util.List<de.uhh.l2g.plugins.model.Term>" scope="request" />
<jsp:useBean id="term" type="de.uhh.l2g.plugins.model.Term" scope="request" />

<c:set var="lectureseriesId" value="${lectureseries.lectureseriesId}"/>
<c:set var="readOnly" value="false"/>

<c:choose>
	  <c:when test="${(permissionProducer  || permissionAdmin || permissionCoordinator) && lectureseries.approved==1}">
			<c:set var="readOnly" value="<%=false%>"/>
	  </c:when>
	  <c:otherwise>
			<c:set var="readOnly" value="<%=true%>"/>
	  </c:otherwise>
</c:choose>

<c:choose>
	  <c:when test="${lectureseries.lectureseriesId > 0}">
		<portlet:actionURL name="edit" var="actionURL">
			<portlet:param name="lectureseriesId" value='${lectureseries.lectureseriesId}' />
			<portlet:param name="backURL" value='${backURL}' />
		</portlet:actionURL>
	  </c:when>
	  
	  <c:otherwise>
		<portlet:actionURL name="add" var="actionURL">
			<portlet:param name="backURL" value='${backURL}' />
		</portlet:actionURL>
	  </c:otherwise>
</c:choose>

<div class="viewedit">
	<aui:form action="${actionURL}" commandName="model">
		<aui:container cssClass='super-awesome-container'>
		        <aui:row>
		                <aui:col>
								<c:choose>
									  <c:when test="${readOnly}">
											<aui:input name="number" label="lectureseries-number" required="false" helpMessage="number-help-text" value="${lectureseries.number}" readonly="${readOnly}"/>
									  </c:when>
									  <c:otherwise>
											<aui:input name="number" label="lectureseries-number" required="false" helpMessage="number-help-text" value="${lectureseries.number}"/>
									  </c:otherwise>
								</c:choose>	
								<c:choose>
									  <c:when test="${readOnly}">
											<aui:input name="name" label="lectureseries-title" required="true" value="${lectureseries.name}" readonly="${readOnly}"/>
									  </c:when>
									  <c:otherwise>
									  		<aui:input name="name" label="lectureseries-title" required="true" value="${lectureseries.name}"/>
									  </c:otherwise>
								</c:choose>	
					
								<c:choose>
									  <c:when test="${!readOnly}">
											<aui:select size="1" name="categoryId" label="category" required="true">
												<aui:option value=""><liferay-ui:message key="select-category"/></aui:option>
												<c:forEach items="${categories}" var="item">
													<aui:option value='${item.categoryId}' selected="true">${item.name}</aui:option>
												</c:forEach>
											</aui:select>
									  </c:when>
									  <c:otherwise>
											<aui:input name="cat" label="category" required="true" value="${item.name}" readonly="${readOnly}"/>
											<aui:input type="hidden" name="categoryId" value="${lectureseries.categoryId}"/>
									  </c:otherwise>
								</c:choose>	
					
								<c:choose>
									  <c:when test="${!readOnly}">
											<aui:select size="1" name="institutionId" label="institution" required="true">
												<aui:option value=""><liferay-ui:message key="select-institution"/></aui:option>
												<c:forEach items="${institutions}" var="item"> 
													<c:choose>
														  <c:when test="${item.key == institutionId}">
																<aui:option value='${item.key}' selected="true" disabled="${!fn:startsWith(item.value, '----') && (permissionCoordinator || permissionProducer || permissionAdmin)}">${item.value}</aui:option>
														  </c:when>
														  <c:otherwise>
														  		<aui:option value='${item.key}' selected="false" disabled="${!fn:startsWith(item.value, '----') && (permissionCoordinator || permissionProducer || permissionAdmin)}">${item.value}</aui:option>
														  </c:otherwise>
													</c:choose>
												</c:forEach>
											</aui:select>
											<div class="facilCont">
												<c:set var="institutionsByLectureseries" value="<%=InstitutionLocalServiceUtil.getByLectureseriesId((Long)pageContext.getAttribute("lectureseriesId"), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS)%>"/>
												<c:forEach items="${institutionsByLectureseries}" var="item">
													<div id='${item.institutionId}'> 
														${item.name} &nbsp;&nbsp;&nbsp;
														<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("${item.institutionId}").remove(); resetInstitution();'></a>
														<aui:input type="hidden" name="institutions" id="institutions" value="${item.institutionId}"/>
													</div>							
												</c:forEach>
											</div>
									  </c:when>
									  <c:otherwise>
											<aui:input type="hidden" name="institutions" id="institutions" value="${institutionId}"/>
											<aui:input type="hidden" name="institutionId" id="institutionId" value="${institutionId}"/>
									  </c:otherwise>
								</c:choose>									
								
								<c:choose>
									  <c:when test="${!permissionProducer}">
											<aui:select size="1" name="producerId" label="producer" required="true" helpMessage="please-add-at-lest-one-producer">
												<aui:option value=""><liferay-ui:message key="select-producer"/></aui:option>
												<c:forEach items="${producers}" var="item">
													<c:choose>
														  <c:when test="${item.producerId == pIds.get(0)}">
																<aui:option value='${item.producerId}' selected="true"> ${item.lastName},  ${item.firstName}</aui:option>
														  </c:when>
														  <c:otherwise>
														  		<aui:option value='${item.producerId}' selected="false"> ${item.lastName},  ${item.firstName}</aui:option>
														  </c:otherwise>
													</c:choose>								
												</c:forEach>							
											</aui:select>	
					
											<div class="prodCont">
												<c:forEach items="${pIds}" var="item">
													<c:if test="${item > 0}">
														<c:set var="p" value="<%=ProducerLocalServiceUtil.getProdUcer(new Long(pageContext.getAttribute("item")+""))%>"/>
														<div id='${p.producerId}'> 
															${p.lastName}, ${p.firstName} &nbsp;&nbsp;&nbsp; 
															<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("${p.producerId}").remove(); resetProducer();'></a>
															<aui:input type="hidden" name="producers" id="producers" value="${p.producerId}"/>
														</div>								
													</c:if>
												</c:forEach>
											</div>
									  </c:when>
									  <c:otherwise>
											<aui:input type="hidden" name="producers" id="producers" value="${producerId}"/>
											<aui:input type="hidden" name="producerId" id="producerId" value="${producerId}"/>				  
									  </c:otherwise>
								</c:choose>
					
								<c:choose>
									<c:when test="${readOnly}">
										<aui:input name="term" label="term" required="true" value='${term.prefix} ${term.year}' readonly="${readOnly}"/>
										<aui:input type="hidden" name="termId" value="${term.termId}"/>
									</c:when>
									<c:otherwise>
										<aui:select id="allterms" size="1" name="termId" label="term" required="true">
											<c:forEach items="${terms}" var="item">
												<c:choose>
													  <c:when test="${term.termId==item.termId}">
															<aui:option value='${item.termId}' selected="true">${item.prefix} ${item.year}</aui:option>
													  </c:when>
													  <c:otherwise>
													  		<aui:option value='${item.termId}' selected="false">${item.prefix} ${item.year}</aui:option>
													  </c:otherwise>
												</c:choose>						
											</c:forEach>
										</aui:select>
									</c:otherwise>
								</c:choose>
								
								<c:if test="${!readOnly}">
									<!-- do not show creators yet! 
									<aui:input id="creator" name="creator" label="creators" required="false" />
									<div id="creators"></div>
									-->
								</c:if>
								
								<aui:input name="password" label="password" helpMessage="password-help-text" value="${lPassword}"/>
					
								<aui:select id="videosort" size="1" name="videoSort" label="sortvideo">
									<aui:option value="1" selected="${isSortVideosASC}" label="sortvideoAsc"></aui:option>		
									<aui:option value="0" selected="${!isSortVideosASC}" label="sortvideoDesc"></aui:option>		
								</aui:select>
				
								<c:choose>
									  <c:when test="${!readOnly}">
											<aui:field-wrapper label="description">
											    <liferay-ui:input-editor name="longDesc" toolbarSet="simple" initMethod="initEditor" cssClass="ta"/>
											    <script type="text/javascript">
											        function <portlet:namespace />initEditor() { return "${lLongDesc}";}
											    </script>
											</aui:field-wrapper>
									  </c:when>
									  <c:otherwise>
									  		<c:if test="${fn:length(lLongDesc)>0}">
									  			<aui:input type="textarea" name="longDesc" value="${lLongDesc}" label="description" readonly="true"/>
									  		</c:if>
									  </c:otherwise>
								</c:choose>		                    
		                </aui:col>
						<aui:col>
							<c:choose>
							  <c:when test="${lectureseries.lectureseriesId > 0}">
				                     <aui:button type="submit" value="edit" id="edit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
							  </c:when>
							  <c:otherwise>
				                     <aui:button type="submit" value="add" id="add" onclick="<portlet:namespace />extractCodeFromEditor()"/>
							  </c:otherwise>
							</c:choose>		
							<aui:button type="cancel" value="cancel" href="${backURL}"/>
						</aui:col>
		        </aui:row>
		</aui:container>
	</aui:form>
</div>

<%@include file="includeCreatorTemplates.jsp" %>