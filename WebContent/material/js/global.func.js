$(document).ready( function(){
    /* ScrollBar */
    var settings = {
        showArrows: false
    };
    var pane = $('.scroll-pane');
    pane.jScrollPane(settings);
    var api = pane.data('jsp');


    $(".tweet").tweet({
        username: "designic",
        join_text: "auto",
        avatar_size: 30,
        count: 10,
        auto_join_text_default: " イケア通販, ",
        auto_join_text_ed: " 私",
        auto_join_text_ing: " 私は",
        auto_join_text_reply: " 返信しました",
        auto_join_text_url: " 確認中",
        loading_text: "ロード中..."
    }).bind("loaded",function(){
            api.reinitialise();
            var obj=$('.cntTwitter .tweet_list li');
            obj.each(function(){
                $(this).find('span').wrapAll('<div class="cntInfo" /> ');
            });
        });

    $('#goToTop').click(function(e){
        $('html, body').animate({ scrollTop: 0 },'slow');
    });


    $('._blank').click(function(e){
        e.preventDefault();
        var url=$(this).attr('href');
        window.open(url);
    });
	$('.contCarousel').bxSlider({
        displaySlideQty: 2,
        moveSlideQty: 2,
        auto : true ,
        pause : 4000,
        autoHover : true
    });

});
