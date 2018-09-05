function toggleLectureseries(){
	var $lId = $( "#<portlet:namespace/>lectureseriesId option:selected" ).val();
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

function defaultContainer(){
	var ret="";
	AUI().use('aui-io-request', function(A){
		A.io.request('${addSegmentURL}', {
            method: 'post',
            dataType: 'json',
	  		data: {
			   	"<portlet:namespace/>videoId": videoId
			},
            on: {
                 success: function() {
                	 //json object
                	 var ret =  this.get('responseData');
                	 ret = data.containerFormat;
                 }
            }
         });
	});
	return ret;
}

function isFirstUpload(){
	var ret = 0;
	AUI().use('aui-io-request', function(A){
		A.io.request(isFirstUploadURL, {
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

function videoFileNameExistsInDatabase(fileName){
	var ret = 0;
	AUI().use('aui-io-request', function(A){
		A.io.request('${videoFileNameExistsURL}', {
            method: 'post',
            dataType: 'json',
	  		data: {
	  			"<portlet:namespace/>fileName": fileName
			},
            on: {
                 success: function() {
                	 //json object
                	 var ret =  this.get('responseData');
                	 ret = data.exist;
                 }
            }
         });
	});
	return ret;
}

function updateVideoFileName(file){
	AUI().use('aui-io-request', function(A){
		A.io.request('${updateVideoFileNameURL}', {
            method: 'post',
            dataType: 'json',
		 	data: {
		 	   	"<portlet:namespace/>videoId": A.one('#"<portlet:namespace/>videoId"').get('value'),
		 	   	"<portlet:namespace/>fileName": file.fileName,
		 	   "<portlet:namespace/>secureFileName": file.secureFileName,
		 	   "<portlet:namespace/>generationDate": file.generationDate
	 		},
            on: {
                 success: function() {
                	 //json object
                	 var ret =  this.get('responseData');
                	 toggleShare();
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
                	 var ret =  this.get('responseData');
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
		 	   	"<portlet:namespace/>lectureseriesId": A.one('#<portlet:namespace/>lectureseriesId').get('value'),
		 	   	"<portlet:namespace/>videoId": A.one('#<portlet:namespace/>videoId').get('value'),
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
	                var ret =  this.get('responseData');
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
		 	   	"<portlet:namespace/>license": data,
		 	   	"<portlet:namespace/>videoId": A.one('#"<portlet:namespace/>videoId"').get('value'),
	 		},
	 		async:true,
            on: {
                 success: function() {
                	 //json object
                	 var ret =  this.get('responseData');
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
				if($("#creators > div").length==0){
				    //update creator class
				    $("#creators-custom").css({"background-color": "#b50303", "color": "white"});
				    $("#creators-custom .control-label").css({"color": "white"});
					$('html, body').animate({
		                   scrollTop: $("#creators-custom").offset().top
		               }, 1000);
			        if($('#<portlet:namespace></portlet:namespace>cancel').is(":visible")){
			        	$('#<portlet:namespace></portlet:namespace>cancel').hide();	
			        }	
					//alert("<liferay-ui:message key='please-add-creators'/>");
				}else{
					$('#<portlet:namespace></portlet:namespace>cancel').show();
				}
			}
	);
}

function updateDescription(data){
	AUI().use('aui-io-request', function(A){
		A.io.request('${updateDescriptionURL}', {
            method: 'post',
            dataType: 'json',
            data: {
		 	   	"<portlet:namespace/>description": data,
		 	   	"<portlet:namespace/>videoId": A.one('#"<portlet:namespace/>videoId"').get('value'),
	 		},
	 		async:true,
            on: {
                 success: function() {
                	 //json object
                	 var ret =  this.get('responseData');
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
			 	   	"<portlet:namespace/>fileName": fileName,
			 	   	"<portlet:namespace/>videoId": videoId,
			    },
	            on: {
	                 success: function() {
	                	 //json object
	                	 var data =  this.get('responseData');
	     		         //since we are using jQuery, you don't need to parse response
	     		         console.log(data);
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
	     		         player.remove();
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
			   	"<portlet:namespace/>creator": JSON.stringify(jsonArray),
			   	"<portlet:namespace/>videoId": videoId,
			},
	 		async:true,
            on: {
	      		  success: function(data) {
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
			  	"<portlet:namespace/>generationDate": genDate,
			  	"<portlet:namespace/>videoId": videoId
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
				  "<portlet:namespace/>firsttitle": title,
			 	  "<portlet:namespace/>videoId": videoId
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

function getDBFilename(){
	var ret = "";
	AUI().use('aui-io-request', function(A){
		A.io.request('${getFileNameURL}', {
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
	      			ret=data.fileName;   
	      		  }
            }
         });
	});
	return ret;
}

function getSecureFilename(){
	var ret = "";
	AUI().use('aui-io-request', function(A){
		A.io.request('${getSecureFileNameURL}', {
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
					console.log("log 1 --> "+dat);
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
		 	   	"<portlet:namespace/>subInstitution": JSON.stringify(jsonArray),
		 	   	"<portlet:namespace/>videoId": videoId
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
		 	   		"<portlet:namespace/>inputTime": Math.floor(player.getPosition()),
		 	   		"<portlet:namespace/>videoId": videoId,
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
	$("#"+c).remove();
}

