$(function(){

	var pageGo = function(){
		
		var pageId = "";
		
		$("#home").on('click',function(){
			location.href = "/";
		});
		$("#board").on('click',function(){
			pageId = "board";
			location.href = "/pageGo?pageId=" + pageId;
		});
		$("#event").on('click',function(){
			pageId = "event";
			location.href = "/pageGo?pageId=" + pageId;
		});
		$("#question").on('click',function(){
			pageId = "question";
			location.href = "/pageGo?pageId=" + pageId;
		});		
		$("#api").on('click',function(){
			pageId = "travelApi";
			location.href = "/pageGo?pageId=" + pageId;
		});		
		
	}
		
	pageGo();

});


