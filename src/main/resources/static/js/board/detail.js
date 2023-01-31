$(function(){
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
	//댓글 삭제
	$(document).on("click",".comment_delete",function(e){
		var comment_num = $(this).closest("div").data("commentnum");
		var bnum = $("#bnum").val();
				
		var param = {
			coment_num : comment_num,
			board_num : bnum
		};
				
		$.ajax({
			type: "GET",
			url : "/commentDelete",
			data : param,
			dataType:"JSON",
			success: function(data){
				var _data = data || {};
				comment_selete_html(_data);				
			},
			error: function(e){
				
			}
		})
	});
	//답글 페이지 오픈
	$(document).on("click",".comment_answer_div",function(e){
		var comment_num = $(this).closest("div").data("commentnum");
		
		if($("#answer_div").length>0){
			$("#answer_div").remove();
			
			var html = "";
			html += '<div id="answer_div">'
				 +	'	<input type="text" name="answer_add_value" data-commentnum = "'+comment_num+'"><button name="answer_add">등록</button>';
				 +  '</div>'
			$(this).closest("div").append(html);
		}else{
			var html = "";
			html += '<div id="answer_div">'
				 +	'	<input type="text" name="answer_add_value" data-commentnum = "'+comment_num+'"><button name="answer_add">등록</button>';
				 +  '</div>'
			$(this).closest("div").append(html);
		}
	});
	
	//답글 등록
	$(document).on("click","[name='answer_add']",function(){
		var comment_val = $(this).closest("div").find(":input[name=answer_add_value]").val();
		var comment_num = $(this).closest("div").find(":input[name=answer_add_value]").data("commentnum");
		var bnum = $("#bnum").val();
		
		var param = {
			comment_txt : comment_val,
			board_num : bnum,
			comment_order : 1,//순서
			group_num : comment_num
		}
		
		$.ajax({
			type:"GET",
			url: "/answer_add",
			data : param,
			success: function(data){
				console.log(data);
				
			},
			error: function(e){
				
			}
		})
		
	});
	
	//댓글 등록
	$("#comment_add").on('click',function(){
		var comment_val = $("#comment_add_value").val();
		var bnum = $("#bnum").val();
		
		var param = {};
		
		if(comment_val==""){
			alert("댓글 텍스트를 입력해주세요");
		}else{
		
			param = {
				comment_txt : comment_val,
				board_num : bnum
			}
			
			$.ajax({
				type:"GET",
				url:"/comment_add",
				data : param,
				success: function(data){
					var _data = data || {};
					
					comment_selete_html(_data);										
				},
				error: function(e){
					console.log(e);
				}
				
			});	
		}		
	});	
	
	function comment_selete_html(data){
		var successYN = data.successYN;
		var commentList = "";
		if(successYN=='Y'){
			commentList = data.commentList || {};
			
			$("#comment_html").empty();
			var html ="";
			$.each(commentList,function(i,data){
				html += '<div id ="comment" style="border:2px solid; padding:10px" data-commentnum="'+data.coment_num+'">';
				html += '	<b>'+data.user_name+'</b>';
				html += '	<button class = "comment_delete">삭제</button>';
				html += '	<button class = "comment_answer_div">답글</button>';
				html += '	<div>'+	data.comment_txt+ '	</div>';
				html += '</div>';	
			});
									
			$("#comment_html").append(html);
			
		}else if(successYN=='L'){
			location.href = url;
		}		
		
	}	
	
})