$(function(){

	var pageGo = function(){
		
		var pageId = "";
		
		$("#home").on('click',function(){
			location.href = "/";
		});
		//공지사항
		$("#announcement").on('click',function(){
			pageId = "announcement";
			location.href = "/pageGo?pageId=" + pageId;
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
		$("#logout").on('click',function(){
			location.href = "/logout"
		});
		$("#memberUpdate").click(function(){
			location.href = "/setting"
		});
		$("#memberManage").click(function(){
			location.href = "/memberManage";
		});
	}
		
	pageGo();

	$(".navbar-toggler").on('click',function(){
		
		var ariaExpandedYn = $('.navbar-toggler').attr("aria-expanded");
		
		if(ariaExpandedYn=='true'){
			$('.navbar-toggler').addClass('collapsed');
			$('.navbar-toggler').attr("aria-expanded",false);
			$('.navbar-collapse').removeClass('show');
		}else{
			$('.navbar-toggler').removeClass('collapsed');
			$('.navbar-toggler').attr("aria-expanded",true);
			$('.navbar-collapse').addClass('show');
		}
		
	});



});


