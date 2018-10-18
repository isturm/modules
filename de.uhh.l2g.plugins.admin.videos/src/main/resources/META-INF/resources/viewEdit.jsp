<%@include file="init.jsp"%>

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
<liferay-portlet:resourceURL id="updateHtaccess" var="updateHtaccessURL" />
<liferay-portlet:resourceURL id="defaultContainer" var="defaultContainerURL" />

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
										<div id="progress" class="progress" style="width:0%;">
									    	<div class="bar" style="width:0%;"></div>
											<div id="percent" style="float:right;"></div>
										</div>
										<div id="uploaded-files"></div>
									</div>
							</aui:fieldset>
						</div>
				</aui:col>
			</aui:row>
		</aui:container>
	</div>
	<div class="viewedit">
			<aui:form action="" commandName="model" name="metadata">
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
												
												<aui:field-wrapper label="description" name="description">
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
													  		<aui:input name="citationAllowedCheckbox" type="checkbox" label="citation-allowed" id="citationAllowedCheckbox"></aui:input>
														</c:if>
														<c:if test="${reqVideo.citation2go==1}">
														  	<aui:input name="citationAllowedCheckbox" type="checkbox" label="citation-allowed" id="citationAllowedCheckbox" checked="true"></aui:input>
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
													<aui:input name="embed_code3" label="video-url" helpMessage="about-video-url" required="false" id="embed_code3" readonly="true" value="${vurl}" onclick="selectEmbed()"/>
													<aui:input name="embed_code" label="embed-iframe" helpMessage="about-iframe-embed" required="false" id="embed_code" readonly="true" value="${reqVideo.embedIframe}" onclick="selectEmbed()"/>
													<c:if test="${reqVideo.downloadLink==1}">
														<aui:input name="embed_code1" label="embed-html5" helpMessage="about-html5-embed" required="false" id="embed_code1" readonly="true" value="${reqVideo.embedHtml5}" onclick="selectEmbed()"/>							
													</c:if>
													<aui:input name="embed_code4" label="embed-commsy" helpMessage="about-commsy-embed" required="false" id="embed_code4" readonly="true" value="${reqVideo.embedCommsy}" onclick="selectEmbed()"/>
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
										<aui:button type="cancel" value="cancel" href="${backURL}" id="cancel"/>
										<aui:input name="videoId" type="hidden" value="${reqVideo.videoId}"/>
										<aui:input name="fileName" type="hidden" value="${reqVideo.filename}"/>
										<aui:input name="secureFileName" type="hidden" value="${reqVideo.secureFilename}"/>
									</aui:col>
					        </aui:row>
					</aui:container>		
			</aui:form>								
	</div>
</div>

<script>
	var nameSpace = "<portlet:namespace></portlet:namespace>";
	var videoId ="${reqVideo.videoId}";
	var $options = $( "#options" );
	var getGenerationDateURL = "${getGenerationDateURL}";
	var isFirstUploadURL = "${isFirstUploadURL}";
	var getFileNameURL = "${getFileNameURL}";
	var getSecureFileNameURL = "${getSecureFileNameURL}";
	var updateHtaccessURL = "${updateHtaccessURL}";
	var assignedCreators = ${assignedCreators};
	var uploadRepository = "${uploadRepository}";
	var updateVideoFileNameURL = "${updateVideoFileNameURL}";
	var defaultContainerURL = "${defaultContainerURL}";
	var c = 0;
	var vidtitle = $('#htmlTitle').text();
	var videoOpenAccess = "${reqVideo.openAccess}";
	var lectureSeriesNumber = "${reqLectureseries.number}";
	var getShareURL = "${getShareURL}";
	var allCreatorsInJQueryAutocompleteFormat = ${allCreatorsJSON.toString()};
	var getJSONCreatorURL = "${getJSONCreatorURL}";	
	var getJSONVideoURL = "${getJSONVideoURL}";	
	
	$(function () {
	  
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
		    
		//load upload function 
		lecture2goFileUpload();
		
		//load uploaded files
		loadUploadedFiles()
		
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
		autocompleteCreator($("#<portlet:namespace/>creator"));
	    if(assignedCreators) {
			$("#creators").loadTemplate("#created", assignedCreators, {error: function(e) { console.log(e); }});
	    }
		    
		var descData=$('#htmlTemplate').text();
		function <portlet:namespace/>setDescriptionData(data){
			descData = data;
		}
		
		function remb(c){
			//TODO remove sub ids
			$("#"+c).remove();
		}	
	});

	
	function toggleLectureseries(){
		var selector = "#"+nameSpace+"lectureseriesId option:selected";
		var $lId = $( selector ).val();
		//
		if($lId==0){
			$options.fadeIn( 500 ); 	
		}else{
			$options.hide();
		}
	}

	function updateNumberOfProductions(){
		var ret="";
		AUI().use('aui-io-request', function(A){
			A.io.request('${updateNumberOfProductionsURL}', {
	            method: 'post',
	            dataType: 'json',
		  		data: {
				   	"<portlet:namespace/>videoId": videoId
				},
	            on: {
	                 success: function() {
	                	 //json object
	                	 var data =  this.get('responseData');
	                	 ret = data.containerFormat;
	                 }
	            }
	         });
		});
		return ret;
	}

	function fileUploadAllowed(data){
		var ret = false;
	    var acceptFileTypes = /(mp4|audio\/mp3|audio\/mpeg|audio)$/i;//allowed file types
	    data.forEach(function(entry) {
	    	if(acceptFileTypes.test(entry['type'])){
	        	ret = true;
	        }
	    });
	    return ret;
	}

	function selectEmbed(){
		$("input[type='text']").on("click", function () {
			   $(this).select();
		});		
	}
	
	function defaultContainer(){
		var ret = "";
		AUI().use('aui-io-request', function(A){
			A.io.request(defaultContainerURL, {
		            method: 'post',
		            dataType: 'json',
		            sync: true,
			  		data: {
			  			"<portlet:namespace/>videoId": videoId
			  		},
		            on: {
		                 success: function() {
		                	 //json object
		                	 var data =  this.get('responseData');
		                	 ret = data.containerFormat;
		                 }
		            }
		     });
		});
		console.log(ret);
		return ret;
	}
	
	function isFirstUpload(){
		var ret = 0;
		AUI().use('aui-io-request', function(A){
			A.io.request(isFirstUploadURL, {
	            method: 'post',
	            dataType: 'json',
	            sync: true,
		  		data: {
		  			"<portlet:namespace/>videoId": videoId
		  		},
	            on: {
	                 success: function() {
	                	 //json object
	                	 var data =  this.get('responseData');
	                	 ret = data.firstUpload;
	                 }
	            }
	         });
		});
		return ret;
	}

	function videoFileNameExistsInDatabase(fileName){
		var ret = 0;
		AUI().use('aui-io-request', function(A){
			A.io.request('${videoFileNameExistsURL}', {
	            method: 'post',
	            dataType: 'json',
		  		data: {
		  			"<portlet:namespace/>fileName": fileName,
		  			"<portlet:namespace/>videoId": videoId
				},
	            on: {
	                 success: function() {
	                	 //json object
	                	 var data =  this.get('responseData');
	                	 ret = data.exist;
	                 }
	            }
	         });
		});
		return ret;
	}

	function updateVideoFileName(file){
		AUI().use('aui-base','aui-io-request', function(A){			
			A.io.request(updateVideoFileNameURL, {
	            method: 'post',
	            dataType: 'json', 
			 	data: {
			 		"<portlet:namespace/>videoId": videoId,
		  			"<portlet:namespace/>fileName": file.fileName, 
		  			"<portlet:namespace/>secureFileName": file.secureFileName, 
		  			"<portlet:namespace/>generationDate": file.generationDate 
		 		},
	            on: {
	                 success: function() { 
	                	 //json object 
	                	 var data =  this.get('responseData');
	                	 //toggleShare();
	                 }
	            }
	         }); 
		});
	}	

	function updateupdateOpenAccessForLectureseries(){
		AUI().use('aui-io-request', function(A){
			A.io.request('${updateupdateOpenAccessForLectureseriesURL}', {
	            method: 'post',
	            dataType: 'json',
	            data: {
			 	   	"<portlet:namespace/>videoId": A.one('#<portlet:namespace/>videoId').get('value'),
			 	},
	            on: {
	                 success: function() {
	                	 //json object
	                	 var data =  this.get('responseData');
	                 }
	            }
	         });
		});
	}

	function updateMetadata(){
		var termId=0;
		var categoryId=0;
		if (!$("#options").is(':hidden')) {
			   termId = A.one('#<portlet:namespace/>termId').get('value');
			   categoryId = A.one('#<portlet:namespace/>categoryId').get('value');
		}
		//
		AUI().use('aui-io-request', function(A){
			A.io.request('${updateupdateOpenAccessForLectureseriesURL}', {
	            method: 'post',
	            dataType: 'json',
	            data: {
			 	    "<portlet:namespace/>videoId": videoId,
			 	   	"<portlet:namespace/>lectureseriesId": A.one('#<portlet:namespace/>lectureseriesId').get('value'),
			 	   	"<portlet:namespace/>language": A.one('#<portlet:namespace/>language').get('value'),
			 	   	"<portlet:namespace/>title": A.one('#<portlet:namespace/>title').get('value'),
			 	   	"<portlet:namespace/>tags": A.one('#<portlet:namespace/>tags').get('value'),
			 	   	"<portlet:namespace/>publisher": A.one('#<portlet:namespace/>publisher').get('value'),
			 	   	"<portlet:namespace/>citationAllowedCheckbox": A.one('#<portlet:namespace/>citationAllowedCheckbox').get('checked'),
			 	   	"<portlet:namespace/>categoryId": categoryId,
			 	   	"<portlet:namespace/>termId": termId,
			 	   	"<portlet:namespace/>password": A.one('#<portlet:namespace/>password').get('value')
			 	},
			 	async:true,
		        on: {
		             success: function() {
		               	//json object
		                var data =  this.get('responseData');
		             }
		        }
	       });
		});
	}

	function updateLicense(data){
		AUI().use('aui-io-request', function(A){
			A.io.request('${updateLicenseURL}', {
	            method: 'post',
	            dataType: 'json',
	            data: {
	            	"<portlet:namespace/>videoId": videoId,
			 	   	"<portlet:namespace/>license": data
		 		},
		 		async:true,
	            on: {
	                 success: function() {
	                	 //json object
	                	 var data =  this.get('responseData');
	                 }
	            }
	         });
		});
	}

	function applyAllMetadataChanges(){
		AUI().use(
				'aui-node',
				function(A) {
					validate();//inpul correct?
					if($("#<portlet:namespace/>title").val() && $("#creators > div").length>0){
						// Select the node(s) using a css selector string
					    var license = A.one("input[name=<portlet:namespace/>license]:checked").get("value");
					    //alert(license2.get('value'));
					    updateDescription(descData);
					    updateLicense(license);
					    updateCreators();
					    updateSubInstitutions();
					    updateMetadata();//last place, important!
					 	//reset creator class
					    $("#creators-custom").css({"background-color": "white", "color": "#555555"});
					    $("#creators-custom .control-label").css({"color": "#488f06"});
					    $("#metadata-upload #creators").css({"color": "#488f06"});
						updateThumbnail();
					    alert("<liferay-ui:message key='changes-applied'/>");					
					}
				}
		);
	}


	function validate(){
		AUI().use(
				'aui-node',
				function(A) {
					var selector = "#"+nameSpace+"cancel";
					if($("#creators > div").length==0){
					    //update creator class
					    $("#creators-custom").css({"background-color": "#b50303", "color": "white"});
					    $("#creators-custom .control-label").css({"color": "white"});
						$('html, body').animate({
			                   scrollTop: $("#creators-custom").offset().top
			               }, 1000);
				        if($(selector).is(":visible")){
				        	$(selector).hide();	
				        }	
						//alert("<liferay-ui:message key='please-add-creators'/>");
					}else{
						$(selector).show();
					}
				}
		);
	}

	function updateDescription(data){
		AUI().use('aui-io-request', function(A){
			var selectorD = "#"+nameSpace+"description";
			var selectorV = "#"+nameSpace+"videoId";
			A.io.request('${updateDescriptionURL}', {
	            method: 'post',
	            dataType: 'json',
	            data: {
	            	"<portlet:namespace/>videoId": videoId,
	            	selectorD: data,
	            	selectorV: A.one(selectorV).get('value'),
		 		},
		 		async:true,
	            on: {
	                 success: function() {
	                	 //json object
	                	 var data =  this.get('responseData');
	                 }
	            }
	         });
		});
	}

	function deleteFile(fileName){
		if(confirm('<liferay-ui:message key="really-delete-question"/>')){
			AUI().use('aui-io-request', function(A){
				A.io.request('${deleteFileURL}', {
		            method: 'post',
		            dataType: 'json',
		            data: {
				 	   	"<portlet:namespace/>videoId": videoId,
				 	   	"<portlet:namespace/>fileName": fileName
				    },
		            on: {
		                 success: function() {
		                	 //json object
		                	 var data =  this.get('responseData');
		     		         //since we are using jQuery, you don't need to parse response
		     		         for (var i = 0; i < data.length; i++) {
		     		             var obj = data[i];
		     			         var id = "#"+obj.fileId;
		     			         $(id).remove();
		     		         }
		     		         //update view
		     		         if (isFirstUpload()==1){
		     		      	   	 $('#date-time-form').fadeIn( 500 );
		     		    	  	 $("#upload-form").hide(); 
		     		    	  	 $("#date-time").hide();
		     		    	  	 $("#first-title").show();
		     		    	  	 $("#<portlet:namespace/>meta-ebene").hide();
		     		         }
		     		         //player.remove();
		     		         //initialize and show player
		     			     initializePlayer();
		     		         //hide date fild
		     		         $("#l2gdate").hide();
		     		         //toggle share
		     		         toggleShare();	                	 
		                 }
		            }
		         });
			});
		}
	}

	function updateCreatorOnServer(jsonArray){
		AUI().use('aui-io-request', function(A){
			A.io.request('${updateCreatorsURL}', {
	            method: 'post',
	            dataType: 'json',
		  		data: {
				   	"<portlet:namespace/>videoId": videoId,
				   	"<portlet:namespace/>creator": JSON.stringify(jsonArray)
				},
		 		async:true,
	            on: {
		      		  success: function() {
		      			var data =  this.get('responseData');
		      		    //remove all creators 
		      		    $( "#creators" ).empty();
		      		    //and show new creators list
		      		    showCreatorsList(data);    
		      		  }
	            }
	         });
		});
	}

	function applyDateTime(){
		var genDate = $('#<portlet:namespace/>datetimepicker').val();
		AUI().use('aui-io-request', function(A){
			A.io.request('${videoUpdateGenerationDateURL}', {
	            method: 'post',
	            dataType: 'json',
				data: {
				  	"<portlet:namespace/>videoId": videoId,
				  	"<portlet:namespace/>generationDate": genDate
				},
				global: false,
				async:false,
	            on: {
		      		  success: function() {
		      			var data =  this.get('responseData');
		      			$('#date-time-form').hide();
						$("#upload-form").fadeIn(500); 	
						$("#tm").text(getDateTime());
						$("#<portlet:namespace/>lecture2go-date").val(genDate);
						$("#l2gdate").fadeIn(1000);
						$("#<portlet:namespace/>meta-ebene").show();   
		      		  }
	            }
	         });
		});
	}

	function applyFirstTitle(){
		var title = $('#<portlet:namespace/>firsttitle').val();
		AUI().use('aui-io-request', function(A){
			A.io.request('${videoUpdateFirstTitleURL}', {
	            method: 'post',
	            dataType: 'json',
	            data: {
				 	  "<portlet:namespace/>videoId": videoId,
					  "<portlet:namespace/>firsttitle": title
				},
				global: false,
				async:false,
	            on: {
		      		success: function() {
		      			var data =  this.get('responseData');
						if(!data.firsttitle){
							alert('<liferay-ui:message key="please-enter-a-title"/>');
						}else{
							$('#first-title').hide();
							$("#date-time").show();	
							$("#<portlet:namespace/>title").val(data.firsttitle);
						}
					}
	            }
	         });
		});
	}

	function loadUploadedFiles(){
		//load files
		var vars = <%=VideoLocalServiceUtil.getJSONVideo(reqVideo.getVideoId()).toString()%>;
	    
		//remove the current files
		//$( "#uploaded-files" ).remove( "div" );
		if(vars) {
			$("#uploaded-files").loadTemplate("#remove-video-file", vars, {error: function(e) { console.log(e); }});
	    }
	    
	}
	
	
	function lecture2goFileUpload(){
		
		
		//file upload 
	    $('#fileupload').fileupload({
	            dataType: 'json',
	            add: function(e, data) {
	                var uploadErrors = [];
	    			var acceptFileTypes = /(mp4|mp3|pdf)$/i;//file types
	    			//
    				console.log(data);
	    			for(i=0;i<data.originalFiles.length; i++){
	    				var file = data.originalFiles[i]['name'];
	    				var extension = file.substr( (file.lastIndexOf('.') +1) );
	    	            if (!acceptFileTypes.test(extension)) {
	    	                uploadErrors.push('<liferay-ui:message key="not-an-accepted-file-type"/>');
	    	            }
	    	            if ( data.originalFiles[i]['size'] > 5368709120) { //5 GB
	    	                uploadErrors.push('<liferay-ui:message key="max-file-size"/>');
	    	            }
	    			}
	              	//check for first upload
	            	if (isFirstUpload()==1) {
	            		if (!fileUploadAllowed(data.originalFiles)){
	            			uploadErrors.push('<liferay-ui:message key="first-upload-requirements"/>');   
	            		} else {
	            			if(videoFileNameExistsInDatabase(data.originalFiles[0]['name'])==1) uploadErrors.push('<liferay-ui:message key="file-exists-in-database"/>');  
	            		}
	            	}
	              	//
	                if (uploadErrors.length > 0) {
	                    alert(uploadErrors.join("\n"));
	                } else {
	                    data.submit();
	                }
	            },
	            done: function (e, data) {
	               var vars = data.jqXHR.responseJSON;
	               //$.template( "filesTemplate", $("#template") );
	               //$("#"+vars[0].id).remove();
	               //$.tmpl( "filesTemplate", vars ).appendTo( ".table" );
	               
	               if(isFirstUpload()==1){//update
	            	   	var f1 = "mp4";
	               		var f2 = "mp3";
	               		var f3 = vars[0].fileName;
	               		//mp4 file
	               		if(f3.indexOf(f1) > -1){
	    	           		updateVideoFileName(vars[0]);
	    	           		validate();
	               		}
	               		//mp3 file, do not trigger the post processing
	               		if(f3.indexOf(f2) > -1){
	    	           		updateVideoFileName(vars[0]);
	    	           		validate();
	               		}
	               }else{ 
	    				//update only for mp3 and mp4, but without changing the container
	    				var f1 = vars[0].fileName;
	    				var f2 = defaultContainer();
	    				var f3 = "mp4";
	    				//for mp3 and mp4 files
	    				if(f1.indexOf(f2) > -1 || f1.indexOf(f3) > -1){
	    	           		updateVideoFileName(vars[0]);
	    	           		validate();
	    				}
	               }
	               
	               //htaccess update function for physical file protectiom
	               updateHtaccess();
	           	   var st = false;
	               
	           	   //
	           	   jwplayer().remove();
	               //initialize and show player
	               setTimeout(
	    	           function(){
	    	        	   initializePlayer();
	    	        	   jwplayer().seek(0);
	    	        	   jwplayer().on('play',function(){
	    	            		  if(st==false){
	    	            			  jwplayer().pause();
	    	            			   st=true;
	    	            		  }
	    	     		   });	        	   
	    	           }, 2000
	               );
	               
			       //hide progress bar
			       $('#percent').text("0%");
	   		       $('#progress').css("width", "0%"); 
	   		        
	   		       //load uploaded files
	   		       loadUploadedFiles()
	            },
	            progressall: function (e, data) {
	    	        var progress = parseInt(data.loaded / data.total * 100, 10);
	    	        if (progress==100){
	    		        $('#percent').text("100%");
	    		        $('#progress').css("width", "100%"); 
	    	        }else{
	    		        var selector = "#"+nameSpace+"cancel";
	    		        var o = progress+ "%";
	    		        $('#percent').text(o);
	    		        $('#progress').css("width", progress + "%");
	    		        if($(selector).is(":visible")){
	    		        	$(selector).hide();	
	    		        }
	    	        }
	       		},
	    		dropZone: $('#dropzone')
	        }).bind('fileuploadsubmit', function (e, data) {
	            	// The example input, doesn't have to be part of the upload form:
	            	var selectorDate = "#"+nameSpace+"lecture2go-date";
	            	var selectorFileName = "#"+nameSpace+"fileName";
	            	var selectorSecureFileName = "#"+nameSpace+"secureFileName";
	            	//
	            	data.formData = {
	            	    repository: uploadRepository,
	            		openaccess: videoOpenAccess,
	            		lectureseriesNumber: lectureSeriesNumber,
	            		fileName: $(selectorFileName).val(),
	            		secureFileName: $(selectorSecureFileName).val(),
	            		l2gDateTime: $(selectorDate).val(),
	            		videoId: videoId
	            };        
	        });	    
	}

	function getDBFilename(){
		return AUI().use('aui-io-request', function(A){
			A.io.request(getFileNameURL, {
	            method: 'post',
	            dataType: 'json',
	            data: {
				 	  "<portlet:namespace/>videoId": videoId
				},
	            on: {
		      		  success: function() {
		      			var data =  this.get('responseData');
		      			var ret=data.fileName;   
		      			return ret;
		      		  }
	            }
	         });
		});
	}

	function updateHtaccess (){
		var ret = 0;
		$.ajax({
			  type: "POST",
			  url: updateHtaccessURL,
			  dataType: 'json',
			  data: {
				  "<portlet:namespace/>videoId": videoId
			  },
			  global: false,
			  async: false,
			  success: function(data) {
			    ret = 1;
			  }
		});
		return ret;
	}

	function getSecureFilename(){
		var ret = "";
		AUI().use('aui-io-request', function(A){
			A.io.request(getSecureFileNameURL, {
	            method: 'post',
	            dataType: 'json',
	            data: {
				 	  "<portlet:namespace/>videoId": videoId
				},
				global: false,
				async:false,
	            on: {
		      		  success: function() {
		      			var data =  this.get('responseData');
		      			ret=data.secureFileName;  
		      		  }
	            }
	         });
		});
		return ret;
	}

	function getShare(){
		var ret = "";
		AUI().use('aui-io-request', function(A){
			A.io.request('${getShareURL}', {
	            method: 'post',
	            dataType: 'json',
	            data: {
				 	  "<portlet:namespace/>videoId": videoId
				},
				global: false,
				async:false,
	            on: {
		      		  success: function() {
		      			var data =  this.get('responseData');
		      			ret=data;  
		      		  }
	            }
	         });
		});
		return ret;
	}

	function toggleShare(){
		var mediaFilename = getDBFilename();
		var data = getShare();
		if(mediaFilename.length>0){
			 $("#embed").show();
			  $("#<portlet:namespace/>embed_code").val(data.iframeEmbed);//iframe
			  $("#<portlet:namespace/>embed_code1").val(data.html5Embed);//html5
			  $("#<portlet:namespace/>embed_code3").val(data.url);//url
			  $("#<portlet:namespace/>embed_code4").val(data.commsyEmbed);//commsy
		}else{
			 $("#embed").hide();
		}
	}

	function setLecture2GoDateTime(token){
		return AUI().use('aui-io-request', function(A){
			A.io.request(getGenerationDateURL, {
				method: 'post',
				dataType: 'json',
				data: {
					"<portlet:namespace/>videoId": videoId
				},
				global: false,
				async:false,
				on: {
					success: function() {
						var dat = this.get('responseData').generationDate;
						 $(token).val(dat);
					}
				}
			});
		});
	}

	function updateSubInstitutions(){
		var namespace="<portlet:namespace/>";
		var jsonArray = [];
		$('.subInstitutions').children().each(function(n){
			var parameters = {};
			var $div = $(this);
			var id = $div.attr('id');
			parameters['institutionId'] = id;
			jsonArray[n]=parameters;
		});
		//set parameter to server for update 
		AUI().use('aui-io-request', function(A){
			A.io.request('${updateSubInstitutionsURL}', {
	            method: 'post',
	            dataType: 'json',
	  		  	data: {
			 	   	"<portlet:namespace/>videoId": videoId,
			 	   	"<portlet:namespace/>subInstitution": JSON.stringify(jsonArray)
			  	},
				global: false,
				async:false,
	            on: {
		      		  success: function() {
		      			var data =  this.get('responseData');
		      		  }
	            }
	         });
		});
	}

	function updateThumbnail(){
		AUI().use('aui-io-request', function(A){
			A.io.request('${updateThumbnailURL}', {
	            method: 'post',
	            dataType: 'json',
	  		  	data: {
			 	   		"<portlet:namespace/>videoId": videoId,
			 	   		"<portlet:namespace/>inputTime": Math.floor(player.getPosition())
			  	},
				global: false,
				async:false,
	            on: {
		      		  success: function() {
		      			var data =  this.get('responseData');
		      		  }
	            }
	         });
		});
	}

	function remb(c){
		console.log(c);
		$("#"+c).remove();
	}

	//load subinstitution 
	AUI().use('aui-node',
			  function(A){
				// Select the node(s) using a css selector string
			    var subInstitutionId = A.one('#<portlet:namespace/>subInstitutionId');
			    var subInstitutions = A.one('.subInstitutions');
			    
			    subInstitutionId.on(
			          'change',
			          function(A) {
			      			if(subInstitutionId.get('value')>0){
			      	   	 		var n = subInstitutionId.get(subInstitutionId.get('selectedIndex')).get('value');
			      	    		var t = subInstitutionId.get(subInstitutionId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
			      	    		subInstitutions.append("<div id='"+n+"'> "+t+" <a class='icon-large icon-remove style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove();'/><input id='<portlet:namespace></portlet:namespace>institutions' name='<portlet:namespace></portlet:namespace>institutions' value='"+n+"' type='hidden'/></div>");
			      			}
			          }
			     );
			 
			  }
	);
	
</script>

<!-- Template -->
<script id="htmlTemplate" type="text/html">
    ${reqMetadata.description} 
</script>

<!-- Template -->
<script type="text/html" id="newCreator">
	<div id="0">
		<aui:input type="hidden" name="gender"/>
		<aui:input name="jobTitle" type="text" helpMessage="job-title-help-text"/>
		<aui:input name="firstName" type="text"/>
		<aui:input name="middleName" type="text"/>
		<aui:input name="lastName" type="text"/>
		<aui:input name="creatorId" value="0" type="hidden"/>
		<a class="icon-large icon-remove" onclick="remb($(this).closest('div').attr('id'))"></a>
	</div>
</script>

<!-- Template -->
<script type="text/html" id="created">
   	<div data-id="creatorId">
    	<div data-content="fullName"/> <a class="icon-large icon-remove" onclick="remb($(this).closest('div').attr('id'))"></a>
	</div>
</script>

<!-- Template -->
<script type="text/html" id="remove-video-file">
   	<div data-id="id">
    	<div data-content="name"/> <a class="icon-large icon-remove" onclick="deleteFile($(this).closest('div').text())"></a>
	</div>
</script>
