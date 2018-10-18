<script type="text/javascript">jwplayer.key="qKvU61clkb6v98R2Yoc/cL6x7dFfJ3we+r6nxD6iB0Q=";</script>

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
            sources: $.parseJSON(vidJ.playerUris),
            hlshtml: true,
            androidhls: true
        });
	}
	
	function initializePlayer(){
		var ret ;
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
		return ret;
	}
</script>

<div id="player1"></div>


