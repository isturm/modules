<script>
	$(function() {
		initializePlayer();
	});
	
	function showPlayer(vidJ){
		jwplayer('player1').setup({
            width: "100%",
            aspectratio: "16:9",
            playbackRateControls: [0.75, 1, 1.25, 1.5],
            image: vidJ.thumbnail,
            sources: vidJ.playerUris,
            hlshtml: true,
            androidhls: true
        });
	} 
	
	function initializePlayer(){
		AUI().use('aui-io-request', function(A){
			A.io.request(getJSONVideoURL, {
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
		                	 ret = data;
		                	 showPlayer(ret)
		                 }
		            }
		     });
		});
	}
</script>

<div id="player1"></div>


