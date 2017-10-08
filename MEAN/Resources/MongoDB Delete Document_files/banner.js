$(document).ready(function() {
    TweenLite.set("#atAd300x250", {
        visibility: "visible"
    });
    var tl, frame1, frame2, frame3, frame4, frame5, frame6, landing;


    CSSPlugin.useSVGTransformAttr = true

    tl = new TimelineMax();


     tl.from("#frame1", 0.3, {
       autoAlpha:0,
    });

    tl.to("#frame1", 0.3, {
        autoAlpha:0,
        delay:2
    });

    tl.from("#frame2", 0.3, {
      autoAlpha:0,
    });

    tl.to("#frame2", 0.3, {
        autoAlpha:0,
        delay:2
    });

    tl.to("#bkgColor", 0.3, {
        autoAlpha:1,
    });

   tl.to("#endFrame", 0.3, {
        autoAlpha:1,
    });

   tl.to("#Allstate", 0.3, {
        bottom:40,
    });


    tl.to("#btn_cta", 0.3, {
        right: -12,
        autoAlpha: 1
    });

    tl.to("#btn_cta", 0.3, {
        right: -17,
        repeat: 2,
        yoyo: true,
        ease: Linear.easeNone
    });

});


var div1 = $("div#btn_cta"),
    tn1 = TweenMax.to(div1, .3, {
        right: -25,
        repeat: -1,
        yoyo: true,
        ease: Linear.easeNone,
        paused: true

    });

div1.mouseover(function() {
    tn1.play();
});

div1.mouseleave(function() {
    var currentTime = tn1.time();
    tn1.reverse(currentTime);
});
