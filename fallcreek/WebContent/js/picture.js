$(function(){
	
$(".runtime-detail").click(function(){
	var top = ($(window).height() - $(this).siblings(".img-runtime").height())/2;   
    var left = ($(window).width() - $(this).siblings(".img-runtime").width())/2; 
  
    var left_difference = ($(window).width() - $("#text").width()) / 2; 
    var scrollTop = $(document).scrollTop() - 60;   /* 滚动条顶部偏移 */
 
    var scrollLeft = $(document).scrollLeft() - left_difference; 
    $(this).siblings(".mask").css({position : 'absolute', 'top' : scrollTop, left : "-500px",top:"-500px", visibility:"visible", height: "8000px", width:"8000px"});   //将ID为mask的CSS属性改为显示
    $(this).siblings(".around").css({position : 'absolute', 'top' : scrollTop, left : "-500px",top:"-500px", visibility:"visible", height: "8000px", width:"8000px"});   //将ID为mask的CSS属性改为显示
    $(this).siblings(".img-runtime").css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).slideDown("normal");  
    $(this).siblings(".img-runtime").scrollTop(0);
    $("body").css({overflow:"hidden"});    //禁用滚动条
})

$(".around").click(function(){
	 $(this).siblings(".img-runtime").hide();
	 $("body").css({overflow:"auto"}); 
	 $(this).siblings(".mask").css({visibility:"hidden", height: "0", width:"0"});
	 $(this).css({visibility:"hidden", height: "0", width:"0"});
})
	

})