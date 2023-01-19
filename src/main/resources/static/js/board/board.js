$(function(){
	
	//클릭시 게시물 상세로
	$(document).on('click','[name=boardDetailGo]',function(){
		var bnum = this.dataset.bnum;
		
		location.href = "/board/detail?bnum="+bnum;
	});	
	
	//등록버튼
	$("#boardInsert").on('click',function(){
		location.href = "/board/insertpage";
	});	
	
})