<%@include file="init.jsp"%>

<jsp:useBean id="reqLectureseriesList" type="java.util.List<de.uhh.l2g.plugins.model.Lectureseries>" scope="request" />
<jsp:useBean id="reqLectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="reqLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="reqProducer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="reqMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<jsp:useBean id="reqSubInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Video_Institution>" scope="request" />
<jsp:useBean id="reqHost" type="de.uhh.l2g.plugins.model.Host" scope="request" />
<jsp:useBean id="languages" type="java.lang.String"  scope="request" />

<jsp:useBean id="permissionAdmin" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionProducer" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionCoordinator" type="java.lang.Boolean" scope="request" />

<jsp:useBean id="remoteUser" type="com.liferay.portal.kernel.model.User" scope="request" />
<jsp:useBean id="allCreatorsJSON" type="com.liferay.portal.kernel.json.JSONArray" scope="request" />
<jsp:useBean id="terms" type="java.util.List<de.uhh.l2g.plugins.model.Term>" scope="request" />
<jsp:useBean id="categories" type="java.util.List<de.uhh.l2g.plugins.model.Category>"  scope="request" />
<jsp:useBean id="uploadRepository" type="java.lang.String"  scope="request" />
<jsp:useBean id="backURL" type="java.lang.String"  scope="request" />
<jsp:useBean id="assignedCreators" type="com.liferay.portal.json.JSONArrayImpl"  scope="request" />

<liferay-portlet:resourceURL id="updateMetadata" var="updateURL" />
<liferay-portlet:resourceURL id="updateDescription" var="updateDescriptionURL" />
<liferay-portlet:resourceURL id="updateLicense" var="updateLicenseURL" />
<liferay-portlet:resourceURL id="updateVideoFileName" var="updateVideoFileNameURL" />
<liferay-portlet:resourceURL id="videoFileNameExists" var="videoFileNameExistsURL" />
<liferay-portlet:resourceURL id="deleteFile" var="deleteFileURL" />
<liferay-portlet:resourceURL id="isFirstUpload" var="isFirstUploadURL" />
<liferay-portlet:resourceURL id="defaultContainer" var="defaultContainerURL" />
<liferay-portlet:resourceURL id="updateCreators" var="updateCreatorsURL" />
<liferay-portlet:resourceURL id="updateSubInstitutions" var="updateSubInstitutionsURL" />
<liferay-portlet:resourceURL id="getJSONCreator" var="getJSONCreatorURL" />
<liferay-portlet:resourceURL id="updateupdateOpenAccessForLectureseries" var="updateupdateOpenAccessForLectureseriesURL" />
<liferay-portlet:resourceURL id="videoUpdateGenerationDate" var="videoUpdateGenerationDateURL" />
<liferay-portlet:resourceURL id="getGenerationDate" var="getGenerationDateURL" />
<liferay-portlet:resourceURL id="videoUpdateFirstTitle" var="videoUpdateFirstTitleURL" />
<liferay-portlet:resourceURL id="getFileName" var="getFileNameURL" />
<liferay-portlet:resourceURL id="getSecureFileName" var="getSecureFileNameURL" />
<liferay-portlet:resourceURL id="getShare" var="getShareURL" />
<liferay-portlet:resourceURL id="updateNumberOfProductions" var="updateNumberOfProductionsURL" />
<liferay-portlet:resourceURL id="updateThumbnail" var="updateThumbnailURL" />
<liferay-portlet:resourceURL id="getJSONVideo" var="getJSONVideoURL" />

<c:set var="uploadProgressId" value="<%=PwdGenerator.getPassword(PwdGenerator.KEY3, 4)%>"/>
<c:if test="${reqVideo.openAccess==1}">
	<c:set var="vurl" value="${reqVideo.url}"/>
</c:if>
<c:if test="${reqVideo.openAccess==0}">
	<c:set var="vurl" value="${reqVideo.secureUrl}"/>
</c:if>
<c:set var="jsonReqVideo" value="<%=VideoLocalServiceUtil.getJSONVideo(reqVideo.getVideoId()).toJSONString()%>"/>

<script id="htmlTitle" type="text/x-tmpl">
	${reqVideo.title}
</script>

<div class="noresponsive">
	<div id="upload">
		<aui:container>
			<aui:row>
				<aui:col>
						<label class="edit-video-lable"><liferay-ui:message key="upload"/></label>
						<div id="date-time-form">
							<aui:fieldset column="true">
									<div id="first-title">
										<aui:input id="firsttitle" name="firsttitle" label="first-title" value="${reqVideo.title}" />
										<aui:button-row>
											<aui:button id="apply-first-title" name="apply-first-title" value="apply-first-title" onClick="applyFirstTitle();"/>
										</aui:button-row>
									</div>
									<div id="date-time">
										<aui:input id="datetimepicker" name="datetimepicker" label="select-date-time-bevor-upload"/>
										<aui:button-row>
											<aui:button id="apply-date-time" name="apply-date-time" value="apply-date-time" onClick="applyDateTime();"/>
										</aui:button-row>
									</div>
							</aui:fieldset>
						</div>
						<div id="upload-form">
							<aui:fieldset column="true">
									<div>
										<input id="fileupload" type="file" name="files[]" data-url="/servlet-file-upload/upload" multiple/>
										<input type="hidden" id="l2gDateTime" value=""/>
										<br/>
										<div id="progress" class="progress">
									    	<div class="bar" style="width: 0%;"></div>
										</div>
										<table id="uploaded-files" class="table"></table>
									</div>
							</aui:fieldset>
						</div>
				</aui:col>
			</aui:row>
		</aui:container>
	</div>
	<div class="viewedit">
			<aui:form action="" commandName="model">
					<aui:container>
					        <aui:row>
					                <aui:col>
											<label class="edit-video-lable" id="edit-video-lable-1">
												<i id="l1" class="aui icon-chevron-down thumb"></i>
												<liferay-ui:message key="metadata"/>
											</label>
											<div id="metadata-upload">
												<aui:input id="stayhere" name="stayhere" label="" required="true" value="" type="hidden"/>
												
												<div id="titledefault"><aui:input id="title" name="title" label="title" required="true" value="${reqVideo.title}" /></div>
												
												<div id="creators-custom">
													<aui:input id="creator" name="creator" label="creators-required" helpMessage="creator-explanation"/>
													<div id="creators"></div>
												</div>		
														
												<aui:select size="1" name="lectureseriesId" label="lecture-series" helpMessage="video-with-or-without-lectureseries" onChange="toggleLectureseries()">
													<aui:option value="0">-<liferay-ui:message key="without-lecture-series"/>-</aui:option>
													<c:forEach items="${lectureseriesAsTreeList}" var="item">
														<aui:option value='0' disabled="true">&#9472; ${item.key.termName} &#9472;</aui:option>
														<c:forEach items="${item.value}" var="lect">
															<c:set var="selected" value="false"/>
															<c:if test="${lect.lectureseriesId==reqVideo.lectureseriesId}">
																<c:set var="selected" value="true"/>
															</c:if>
															<aui:option value='${lect.lectureseriesId}' selected="${selected}">${lect.name}</aui:option>
														</c:forEach>
													</c:forEach>
												</aui:select>
												
												<div id="options">
													<aui:select id="subInstitutionId" size="1" name="subInstitutionId" label="sub-institution">
														<aui:option value="" selected="true"><liferay-ui:message key="select-sub-institution"/></aui:option>
														<c:forEach items="${reqSubInstitutions}" var="item">
															<aui:option value='${item.institutionId}'>${item.institutionId}</aui:option>
														</c:forEach>
													</aui:select>
													
													<div class="subInstitutions" >
														<c:forEach items="${reqSubInstitutions}" var="item">
																<div id='${item.institutionId}'> 
																	${item.institutionId} &nbsp;&nbsp;&nbsp; 
																	<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("${item.institutionId}").remove();'></a>
																	<aui:input type="hidden" name="institutions" id="institutions" value="${item.institutionId}"/>
																</div>
														</c:forEach>							
													</div>	
																
													<aui:select id="termId" size="1" name="termId" label="term" required="true">
														<c:forEach items="${terms}" var="item">
															<aui:option value='${term.termId}'>${item.prefix} &nbsp; ${item.year}</aui:option>
														</c:forEach>						
													</aui:select>
									
													<aui:select size="1" id="categoryId" name="categoryId" label="category" required="true">
														<c:forEach items="${categories}" var="item">
															<aui:option value='${item.categoryId}'>${item.name}</aui:option>
														</c:forEach>	
													</aui:select>
												</div>
									
												<aui:select size="1" name="language" label="language" required="true">
													<c:forEach items="${languages}" var="item">
														<aui:option value='${item}'>${item}</aui:option>
													</c:forEach>					
												</aui:select>
												
												<div id="l2gdate"><aui:input id="lecture2go-date" name="lecture2go-date" label="lecture2go-date" required="false" value="" disabled="true"/></div>
									
												<aui:input name="tags" label="tags" required="false" value="${reqVideo.tags}"/>
									
												<aui:input name="publisher" label="publisher" required="false" value="${reqMetadata.publisher}"/>
												
												<aui:field-wrapper label="description">
												    <liferay-ui:input-editor  name="longDesc" toolbarSet="simple" initMethod="initEditor" onChangeMethod="setDescriptionData" cssClass="ta"/>
												    <script type="text/javascript">
												        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(reqMetadata.getDescription()) %>"; }
												    </script>
												</aui:field-wrapper>
											</div>
											<script>
												$( "#edit-video-lable-1" ).click(function() {
												  $( "#metadata-upload" ).slideToggle( "slow" );
												  $("#l1", this).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
											
											<div id="permissions">
												<label class="edit-video-lable" id="edit-video-lable-2">
													<i id="l2" class="aui icon-chevron-down thumb"></i>
													<liferay-ui:message key="permissions"/>
												</label>
												<div id="permissions-content">
													<c:if test="${reqVideo.getOpenAccess()==0}">
														<div>
															<aui:input id="password" name="password" label="password" required="false" value="${reqVideo.password}" />
														</div>
													</c:if>
													<c:if test="${reqVideo.getOpenAccess()==1}">
														<aui:input name="password" id="password" type="hidden" value="${reqVideo.password}"/>
													</c:if>
													<div id="c2g">
														<c:if test="${reqVideo.citation2go==0}">
													  		<aui:input name="citationAllowed" type="checkbox" label="citation-allowed" id="citationAllowed"></aui:input>
														</c:if>
														<c:if test="${reqVideo.citation2go==1}">
														  	<aui:input name="citationAllowed" type="checkbox" label="citation-allowed" id="citationAllowed" checked="true"></aui:input>
														</c:if>
													</div>
												</div>
											</div>
											<script>
												$( "#edit-video-lable-2" ).click( function() {
												  	$( "#permissions-content" ).slideToggle( "slow" );
												  	$("#l2", this).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
											
											<div id="license">
												<label class="edit-video-lable" id="edit-video-lable-3">
													<i id="l3" class="aui icon-chevron-down thumb"></i>
													<liferay-ui:message key="license"/>
												</label>
												<div id="license-content">
													<div>
														<c:if test="${reqLicense.l2go==1}"><aui:input name="license"  id="uhhl2go" label="" value="uhhl2go" checked="true" type="radio"/></c:if>
														<c:if test="${reqLicense.l2go==0}"><aui:input name="license" id="uhhl2go" label="" value="uhhl2go" type="radio"/></c:if>
														<a href="/web/vod/licence-l2go" target="_blank"><liferay-ui:message key="lecture2go-licence"/> </a>	 	      	      
													</div>	
													<div>
														<c:if test="${reqLicense.ccbyncsa==1}"><aui:input name="license" label="" id="ccbyncsa" value="ccbyncsa" checked="true" type="radio" /></c:if>
														<c:if test="${reqLicense.ccbyncsa==0}"><aui:input name="license" label="" id="ccbyncsa" value="ccbyncsa" type="radio"/></c:if>
														<a href="http://creativecommons.org/licenses/by-nc-sa/3.0/" target="_blank"> <liferay-ui:message key="cc-license-click-for-info"/> </a>
													</div>
												</div>
											</div>
											<script>
												$( "#edit-video-lable-3" ).click( function() {
												  	$( "#license-content" ).slideToggle( "slow" );
												  	$( "#l3", this ).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
							
											<div id="embed">
												<label class="edit-video-lable" id="edit-video-lable-4">
													<i id="l4" class="aui icon-chevron-down"></i>
													<liferay-ui:message key="share"/>
												</label>
												<div id="embed-content">
													<!-- embed start -->
													<aui:input name="embed_code3" label="video-url" helpMessage="about-video-url" required="false" id="embed_code3" readonly="true" value="${vurl}" onclick="document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code3.focus();document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code3.select();"/>
													<aui:input name="embed_code" label="embed-iframe" helpMessage="about-iframe-embed" required="false" id="embed_code" readonly="true" value="${reqVideo.embedIframe}" onclick="document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code.focus();document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code.select();"/>
													<c:if test="${reqVideo.downloadLink==1}">
														<aui:input name="embed_code1" label="embed-html5" helpMessage="about-html5-embed" required="false" id="embed_code1" readonly="true" value="${reqVideo.embedHtml5}" onclick="document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code1.focus();document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code1.select();"/>							
													</c:if>
													<aui:input name="embed_code4" label="embed-commsy" helpMessage="about-commsy-embed" required="false" id="embed_code4" readonly="true" value="${reqVideo.embedCommsy}" onclick="document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code4.focus();document.embed-content._lgadminvideomanagement_WAR_lecture2goportlet_embed_code4.select();"/>
													<!-- embed end -->	      	      
												</div>
											</div>
											<script>
												$( "#edit-video-lable-4" ).click( function() {
												  	$( "#embed-content" ).slideToggle( "slow" );
												  	$( "#l4", this).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
							
											<div id="video-thumbnail">
												<label class="edit-video-lable" id="edit-video-lable-5">
													<i id="l5" class="aui icon-chevron-right"></i>
													<liferay-ui:message key="video-thumbnail" />
												</label>
												
												<div id="thumbnail-content">
													<!-- thumbnail start --> 
														<liferay-ui:message key="video-thumbnail-about"/>
														<%@include file="/player/includePlayerForThumbnail.jsp"%>
													<!-- thumbnail end -->	      	      
												</div>
											</div>
											<script>
												$(function(){ $( "#thumbnail-content" ).hide(); });
												$( "#edit-video-lable-5" ).click( function() {
												  	$( "#thumbnail-content" ).slideToggle( "slow" );
												  	$( "#l5", this).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
									</aui:col>
									<aui:col>
										<aui:button type="submit" value="apply-changes" onclick="applyAllMetadataChanges()" cssClass="btn-primary"/>	
										<aui:button type="cancel" value="cancel" href="${backURL}"/>
										<aui:input name="videoId" type="hidden" value="${reqVideo.videoId}"/>
									</aui:col>
					        </aui:row>
					</aui:container>		
			</aui:form>								
	</div>
</div>

<script>
	/* these variables are set here but used in the external autocomplete-creator.js 
	file, be sure to include this js AFTER the jsp is rendered */
	var videoId ="${reqVideo.videoId}";
	var $options = $( "#options" );
	var getGenerationDateURL = "${getGenerationDateURL}";
	var isFirstUploadURL = "${isFirstUploadURL}";
	var assignedCreators = ${assignedCreators};
	var c = 0;
	/*variables end*/
	
	$(function(){
		var vidtitle = $('#htmlTitle').text();
	    if(isFirstUpload()==1 && getDateTime().length==0){
	   	  	$("#date-time-form").fadeIn(1000);
	    	$("#upload-form").hide();
	    	$("#l2gdate").hide();
	    	if(vidtitle.trim()>""){
	    		$("#first-title").hide();
	    		$("#date-time").show();
	    	}else{
	    		$("#date-time").hide();
	    	}
	    	$("#<portlet:namespace/>meta-ebene").hide();
	    }else{
	  	  $("#date-time-form").hide();
		  $("#upload-form").fadeIn(1000); 	
		  setLecture2GoDateTime("#<portlet:namespace/>lecture2go-date");
		  $("#<portlet:namespace/>meta-ebene").show();
	    }
	    //load date time picker
	    $('#<portlet:namespace/>datetimepicker').datetimepicker({
	    	format:'Y-m-d_H-i',
	    	dayOfWeekStart : 1,
	    	lang:'en',
	    	startDate:	new Date(),
	    	value: new Date(),
	    	maxDate: '+1970/01/30',
	    	minDate: false,
	    	step:10
	    });
	    //load creators
    	if(assignedCreators) {
	    	/* load creators template */
    		$("#creators").loadTemplate("#created", assignedCreators, {error: function(e) { console.log(e); }});
    	}
	});
  
	var descData=$('#htmlTemplate').text();
	function <portlet:namespace/>setDescriptionData(data){
		descData = data;
	}
	
	function remb(c){
		//TODO remove sub ids
		$("#"+c).remove();
	}	
</script>

<!-- Template -->
<script id="htmlTemplate" type="text/html">
    ${reqMetadata.description} 
</script>

<!-- Template -->
<script type="text/html" id="template">
   	<tr data-id="id">
    	<td data-content="name"></td>
    	<td>
			<a class="icon-large icon-remove" onclick="deleteFile('#');"></a>
		</td>
   	</tr>
</script>

<!-- Template -->
<script type="text/html"  id="newCreator">
	<div data-id="id">
	<aui:input type="hidden" name="gender"/>
	<aui:input name="jobTitle" type="text" helpMessage="job-title-help-text"/>
	<aui:input name="firstName" type="text"/>
	<aui:input name="middleName" type="text"/>
	<aui:input name="lastName" type="text"/>
	<aui:input name="creatorId" value="0" type="hidden"/>
	<a class="icon-large icon-remove" onclick="remb('#');"></a>
	</div>
</script>

<!-- Template -->
<script type="text/html" id="created">
   	<div data-id="creatorId">
    	<div data-content="fullName"/> <a class="icon-large icon-remove" onclick="remb($(this).closest('div').attr('id'))"></a>
	</div>
</script>