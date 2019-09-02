<script>
    $(function() {
        // herausfinden ob es ein tablet/smartphone ist
        var isTouchDevice = 'ontouchstart' in document.documentElement;

        // Die Adresse des Web- und Videoservers ermitteln
        var server = "#";

        // Diese Funktion wird genutzt um die Url Parameter auszulesen
        var getUrlParameter = function(sParam){
            var sPageURL = window.location.search.substring(1);
            var sURLVariables = sPageURL.split('&');
            for (var i = 0; i < sURLVariables.length; i++){
                var sParameterName = sURLVariables[i].split('=');
                if (sParameterName[0] == sParam){
                    return sParameterName[1];
                }
            }
        };
        
        // Start- und Endzeit der Zitatfunktion ermitteln (Durch die URL Parameter)
        var frameStart = getUrlParameter('start');
        var frameEnd = getUrlParameter('end');
        var fs = ${timeStart};
        var fe = ${timeEnd};
        var citationAllowed = ${video.citation2go};
        
		if(citationAllowed==1 && fs>0 && fe>fs){
	        frameStart = ${timeStart};
	        frameEnd = ${timeEnd};		
		}
		
		// Hier wird der JW-Player initialisiert
        // Interessant ist hierbei, dass es mehrere Quellen geben kann
        var pla = jwplayer('player1').setup({
            width: "100%",
            aspectratio: "16:9",
            playbackRateControls: [0.75, 1, 1.25, 1.5],
            image: "${video.image}",
            cast: {},
            sources: ${video.jsonPlayerUris},
            <c:if test="${video.hasCaption || video.hasChapters}">
	            tracks: ${video.jsonPlayerTracks},
            </c:if>
            hlshtml: true,
            androidhls: true
        });
        
        pla.on('ready', function(){

         	// Inputfelder f�r Start und Ende der Zitate / Kapitel speichern 
            var $inputTimeStart = $("#<portlet:namespace></portlet:namespace>timeStart").val("");
            var $inputTimeEnd = $("#<portlet:namespace></portlet:namespace>timeEnd").val("");
            var $citation = $("#<portlet:namespace></portlet:namespace>citation").val("");
            var $citationiframe = $("#<portlet:namespace></portlet:namespace>citationiframe").val("");

            var $chapters = $('#chapters');
            var $chapterDivs = $chapters.find("div.chaptertile");
            
            // Chapter ids und Zeiten in Object f�r sp�tere Abfragen speichern
            var chapters = [];
            for (var i = 0; i < $chapterDivs.length; i++) {
            	// Array chapters enth�lt Triple aus id, Anfangs- und Endzeit der Kapitel
            	var chapter = {
            			id : $chapterDivs.eq(i).attr("id"),
            			begin : timeToSeconds($chapterDivs.eq(i).attr("begin")),
                    	end : timeToSeconds($chapterDivs.eq(i).attr("end"))
            	};
            	chapters[i] = chapter;
            }

            if (frameStart && frameEnd) {
                // Sollten sich die Start- und Endzeit in den URL Parametern befinden
                // wird in diesen Abschnitt daf�r gesorgt das man auch nur das Entsprechende
                // Videomaterial zu sehen bekommt


                // iOS und Android unterst�tzen seek nur wenn der Nutzer
                // selbst manuell das vide gestartet hat. Wir werden den start des Zitates
                // sp�ter anders l�sen
                if (!isTouchDevice) {
                	jwplayer().on('firstFrame', function() { 
                		jwplayer().play();
                		jwplayer().seek(frameStart);
                	});
                }
            }

                
            // Event listener alle 100 ms w�hrend playback
            jwplayer().onTime( function(event){

                // Sicher stellen, dass der gew�hlte Zeitraum eingehalten wird

                var pos =  Math.floor(event.position);

                if (pos < frameStart && isTouchDevice) {
                    // Nur unter iOS und Android n�tig,
                    jwplayer().seek(frameStart);
                } else if (pos > frameEnd) {
                    jwplayer().seek(frameStart);
                    jwplayer().pause();
                }
            
                // Falls neues Kapitel beginnt, zu Kapitel scrollen und hervorheben
                for (var i = 0; i < chapters.length; i++) {
                    // Falls Player in ein Kapitel eintritt, Kapitel Klasse 'active' setzen
                    var $cur = $("#" + chapters[i].id);
                	if ( pos == chapters[i].begin && !$cur.hasClass("active")) {
                		$cur.addClass("active").siblings().removeClass("active");
                		
                		var off1 = Math.floor( $cur.offset().top );
                		var off2 = Math.floor( $chapters.offset().top );
                		var diff = off1 - off2;
                		var target = $chapters.scrollTop() + diff;
                		
                		$chapters.animate({ scrollTop: target}, 600);
                		
                	} else if ( pos == chapters[i].end + 1 ){
                		$cur.removeClass("active");
                	}
                }
            });

            // Diese Stelle ist wiederum nur auf PC n�tig.
            // Hiermit wird verhindert, dass der Nutzer per Tastatur
            // aus den Zitatsbereich herausspult
            if (!isTouchDevice) {
                jwplayer().onSeek( function(event){
                    var pos =  event.position;

                    if (Math.ceil(pos) < Math.ceil(frameStart) || Math.ceil(pos) > Math.ceil(frameEnd)) {
                        jwplayer().seek(frameStart);
                        jwplayer().pause();
                    }
                });
            }

            $('#fullVideo').show();
        
        	// Sollte der Nutzer auf die Kapitel klicken,
            // wird zur entsprechenden Stelle gesprungen
            $chapters.find('div.chaptertile').on('click', function(event) {
                
            	$(this).addClass("active").siblings().removeClass("active");
            	var sec = $(this).attr("begin");
            	sec = timeToSeconds(sec);
                jwplayer().seek(sec);
                $("html, body").animate({ scrollTop: 0 }, "slow");
            });
            
            $chapters.find("input[alt='delete']").on("click", function(event) {
            	event.stopPropagation();
            });

            // Im nachfolgenden Abschnitt wird den Nutzer erm�glicht
            // eigene Zitate zu erstellen und zu teilen
            var player = jwplayer();

            var startFrameTime = undefined;
            var endFrameTime = undefined;
            var startTimeStr = undefined;
            var endTimeStr = undefined;

            // Benutzer setzt Start des Clips
            $inputTimeStart.click(function() {
                	startFrameTime = Math.round(player.getPosition());
                    startTimeStr = secondsToTime(Math.floor(startFrameTime));

                    $inputTimeStart.val(startTimeStr);
                    
                    if (startFrameTime && endFrameTime) {
                    	// Falls Startzeit nach Endzeit liegt, Zeiten angleichen
                    	if (startFrameTime > endFrameTime) {
                    		endFrameTime = startFrameTime;
                    		endTimeStr = secondsToTime(Math.floor(endFrameTime));
                    		$inputTimeEnd.val(endTimeStr);
                    		
                    	}
                    	generateClipLink (Math.round(startFrameTime), Math.round(endFrameTime));
                    	console.log("start: " + startFrameTime + ", end: " + endFrameTime);
                    }
            });

            // Benutzer setzt Ende des Clips
            $inputTimeEnd.click(function() {
            	endFrameTime = player.getPosition();
                EndTimeStr = secondsToTime(Math.floor(endFrameTime));

                $inputTimeEnd.val(EndTimeStr);

                if (startFrameTime && endFrameTime && startFrameTime<endFrameTime) {
                	// Falls Startzeit nach Endzeit liegt, Zeiten angleichen
                	if (startFrameTime > endFrameTime) {
                		startFrameTime = endFrameTime;
                		startTimeStr = secondsToTime(Math.floor(startFrameTime));
                		$inputTimeStart.val(startTimeStr);
                		
                	}
                	generateClipLink (Math.round(startFrameTime), Math.round(endFrameTime));
                	console.log("start: " + startFrameTime + ", end: " + endFrameTime);
                }
            });
            
            function generateClipLink (firstFrame, lastFrame) {
            	$citation.val("${video.url}"+"/"+firstFrame+"/"+lastFrame);
            	var vid = "${video.videoId}"; 
            	var host ="${lecture2goWebRoot}";
            	
            	var iframe="<iframe src='"+host+"/TODO/?v="+vid+"/"+firstFrame+"/"+lastFrame+"' frameborder='0' width='647' height='373' allowfullscreen></iframe>";
            	$citationiframe.val(iframe);
            }
            
        });
    });

</script>

<div id="player1"></div>


