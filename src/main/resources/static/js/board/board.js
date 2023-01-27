$(function(){
	
	//클릭시 게시물 상세로
	$(document).on('click','.boardDetailGo',function(){
		var bnum = this.dataset.bnum;
		
		location.href = "/board/detail?bnum="+bnum;
	});	
	
	//등록버튼
	$("#boardInsert").on('click',function(){
		location.href = "/board/insertpage";
	});	
	
	//페이지
	$(document).on("click",".pagecnt",function(){
		
		var cnt = $(this).data("cnt");
		
		var param = {
			page : cnt,
			recordSize : 10,
			pageSize : 5
		}
		
		location.href = "/board/board?"+new URLSearchParams(param);
						
	});
	
	$("#searchBtn").on("click",function(){
		
		var searchType = $("#searchVal").val();
		var searchtxt = $("#searchtxt").val();
		
		var params = {
			keyword : searchtxt,
			searchType: searchType
		}
		location.href = "/board/board?"+new URLSearchParams(params);
	});	
})