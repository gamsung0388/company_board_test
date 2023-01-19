$(function(){
	//뒤로
	$("#backPage").on('click',function(){
		history.back();
	});
	//수정페이지
	$("#boardUpdate").on('click',function(){
		var bnum = $(this).val();
		location.href = "/board/updatepage?bnum="+bnum;
	});
	//삭제페이지
	$("#boardDelete").on('click',function(){
		var bnum = $(this).val();
		location.href = "/board/delete?bnum="+bnum;
	});
		
})