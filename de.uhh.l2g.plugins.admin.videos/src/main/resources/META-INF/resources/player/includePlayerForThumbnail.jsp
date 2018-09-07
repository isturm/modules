<script type="text/javascript">jwplayer.key="qKvU61clkb6v98R2Yoc/cL6x7dFfJ3we+r6nxD6iB0Q=";</script>

<script>
    // Hier wird der JW-Player initialisiert
    // Interessant ist hierbei, dass es mehrere Quellen geben kann
     jwplayer('player1').setup({
            width: "100%",
            aspectratio: "16:9",
            playbackRateControls: [0.75, 1, 1.25, 1.5],
            image: "${reqVideo.image}",
            cast: {},
            sources: ${reqVideo.jsonPlayerUris},
            tracks: [{
                file: "${video.vttChapterFile}",
                kind:'chapters'
            }],
            hlshtml: true,
            androidhls: true
        });
</script>

<div id="player1"></div>


