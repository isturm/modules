<script>
        var isTouchDevice = 'ontouchstart' in document.documentElement;

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
        var containerFormat = "${reqVideo.containerFormat}";
        
        // Hier wird der JW-Player initialisiert
        // Interessant ist hierbei, dass es mehrere Quellen geben kann
        // Hier wird der JW-Player initialisiert
        // Interessant ist hierbei, dass es mehrere Quellen geben kann
		//var vttFile ="${reqVideo.vttChapterFile}";
		
        // Hier wird der JW-Player initialisiert
        // Interessant ist hierbei, dass es mehrere Quellen geben kann
        var pla = jwplayer('player1').setup({
            width: "100%",
            aspectratio: "16:9",
            playbackRateControls: [0.75, 1, 1.25, 1.5],
            image: "${reqVideo.image}",
            cast: {},
            sources: ${reqVideo.jsonPlayerUris},
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
            var $buttonAddSegment = $(".btn-primary");
            $("#<portlet:namespace></portlet:namespace>chortTitle").val("");


            var $chapters = $('#chapters');
            var $chapterDivs = $chapters.find("li.chaptertile");
            
            // Chapter ids und Zeiten in Object f�r sp�tere Abfragen speichern
            var chapters = [];
            for (var i = 0; i < $chapterDivs.length; i++) {
            	// Array chapters enth�lt Triple aus id, Anfangs- und Endzeit der Kapitel
            	var chapter = {
            			id : $chapterDivs.eq(i).attr("id"),
            			begin : timeToSeconds($chapterDivs.eq(i).attr("begin")),
                    	end : timeToSeconds($chapterDivs.eq(i).attr("end"))
            	}
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
                    jwplayer().seek(frameStart);
                    jwplayer().pause();
                }
            }

                
            // Event listener alle 100 ms w�hrend playback
			pla.on('time', function(event) {
            
				// Sicher stellen, dass der gew�hlte Zeitraum eingehalten wird

                var pos =  Math.floor(event.position);
                console.log(pos);

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
            	
                pla.on('seek', function(event) {
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
            $chapters.on('click', 'li.chaptertile', function(event) {
                console.log($(this).text());
            	$(this).addClass("active").siblings().removeClass("active");
            	var sec = $(this).attr("begin");
            	sec = timeToSeconds(sec);
                jwplayer().seek(sec);
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
            var entTimeStr = undefined;
            

            // Benutzer setzt Start des Clips
            $inputTimeStart.click(function() {
            	startFrameTime = player.getPosition();
                startTimeStr = secondsToTime(Math.floor(startFrameTime));

                $inputTimeStart.val(startTimeStr);
                
                if (startFrameTime && endFrameTime) {
                	// Falls Startzeit nach Endzeit liegt, Zeiten angleichen
                	if (startFrameTime > endFrameTime) {
                		endFrameTime = startFrameTime;
                		endTimeStr = secondsToTime(Math.floor(endFrameTime));
                		$inputTimeEnd.val(endTimeStr);
                		
                	}
                	//generateClipLink (startFrameTime, endFrameTime);
                	console.log("start: " + startFrameTime + ", end: " + endFrameTime);
                }
                validateClipTime();
            });

            // Benutzer setzt Ende des Clips
            $inputTimeEnd.click(function() {
            	endFrameTime = player.getPosition();
                EndTimeStr = secondsToTime(Math.floor(endFrameTime));

                $inputTimeEnd.val(EndTimeStr);

                if (startFrameTime && endFrameTime) {
                	// Falls Startzeit nach Endzeit liegt, Zeiten angleichen
                	if (startFrameTime > endFrameTime) {
                		startFrameTime = endFrameTime;
                		startTimeStr = secondsToTime(Math.floor(startFrameTime));
                		$inputTimeStart.val(startTimeStr);
                		
                	}
                	//generateClipLink (startFrameTime, endFrameTime);
                	//console.log("start: " + startFrameTime + ", end: " + endFrameTime);
                }
                validateClipTime();
            });
            
            function generateClipLink (firstFrame, lastFrame) {
            	var href = location.href + "?start="  + firstFrame + "&end=" + lastFrame;
                $('#clipLink').val(href).fadeIn(600);
                $('#clipLink2').show();
                $('#clipLink2 a').attr('href', href);
            }
            
            function validateClipTime () {
            	// Button addSegment disablen, falls Zeiten leer oder gleich sind
            	if ( ( $inputTimeStart.val() != "" )
            		&& ( $inputTimeEnd.val() != "" )
            		&& ( $inputTimeStart.val() != $inputTimeEnd.val() )) {
            		console.log("enable");
            		$buttonAddSegment.prop('disabled', false);
            	}else{
            		console.log("disabled");
            		$buttonAddSegment.prop('disabled', true);
            	}
            }

        });

</script>


<div id="player1"></div>

