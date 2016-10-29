//控制页面跳转
$(function(){
	$(".article-line").click(function(){
		var id = $(this).children(".article-id").text()
		var url = "leetcode/" + id + ".html"
		location.href = url
		
	})	
})


$(function(){
	$.ajax({
		type: "POST",
		url:"recentleetcodeaction",
		dataType:"html",
		success:function(strValue){ 
			/* alert(strValue) */
			$("#wrap-showwindow #wrap-item").html(strValue);
		}
	})
})

//控制难度选择
$(function(){
	$("#wrap-difficulty #select-difficulty").change(function(){	
		selectChange()
	})
	
})	

//控制标签选择
$(function(){
	$("#wrap-tag #select-tag").change(function(){
		selectChange()
	})
	
})
//根据选择控制目录的呈现
function selectChange()
{
	var difficulty = $("#wrap-difficulty #select-difficulty").find("option:selected").text() 
	var tag = $("#wrap-tag #select-tag").find("option:selected").text() 
	$("#wrap-content #wrap-item .article-line").each(function(i,n){
		
		var thisdifficulty = $(n).children(".article-difficulty").html()
		var thistag = $(n).children(".article-tag").html()
		
		if(((thisdifficulty == difficulty || difficulty == "All") && 
						(thistag.indexOf(tag) != -1 || tag == "All")))
		{
			$(n).css({display:"block"})
		}
		else
		{
			$(n).hide()
		}	
	})
}


