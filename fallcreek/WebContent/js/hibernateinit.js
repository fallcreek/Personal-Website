$(function(){
	$.ajax({
		type: "POST",
		url:"modifyPriceAction.action",
		dataType:"html",
		data:{price:Price},
		success:function(strValue){ 
			$("#infoResultPrice").html(strValue);
		}
	})
})