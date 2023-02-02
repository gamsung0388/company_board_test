$(function(){
	
	//게시글 수정페이지
	$("#boardUpdate").on('click',function(){
		var bnum = $(this).val();
		location.href = "/board/updatepage?bnum="+bnum;
	});
	
	//게시글 삭제페이지
	$("#boardDelete").on('click',function(){
		var bnum = $(this).val();
		location.href = "/board/delete?bnum="+bnum;
	});
	/***********************************************************************/
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
				board_num : bnum,
				comment_class : 0,
				comment_order : 0
			}
			
			$.ajax({
				type:"GET",
				url:"/comment_add",
				data : param,
				success: function(data){
					var _data = data || {};
					
					console.log(_data);
										
					comment_selete_html(_data);									
				},
				error: function(e){
					console.log(e);
				}
				
			});	
		}		
	});	
	
	//댓글 삭제
	$(document).on("click",".comment_delete",function(e){
		var comment_num = $(this).closest("div").data("commentnum");
				
		var param = {
			coment_num : comment_num,
		};
		console.log("dd ",param)
		
		$.ajax({
			type: "GET",
			url : "/commentDelete",
			data : param,
			dataType:"JSON",
			success: function(data){
				var _data = data || {};
				
				console.log("_data: "+_data);
				comment_selete_html();				
			},
			error: function(e){
				
			}
		})
	});
	
	//답글 페이지 오픈
	$(document).on("click",".comment_answer_div",function(e){
		var comment_num = $(this).closest("div").data("commentnum");
		var comment_class = $(this).closest("div").data("commentclass");
		var comment_order = $(this).closest("div").data("commentorder");
		
		console.log(comment_num+"  "+ comment_class +" " + comment_order)
		
		if($("#answer_div").length>0){
			$("#answer_div").remove();
			var html = "";
			html += '<div id="answer_div">'
				 +	'	<input type="text" name="answer_add_value" data-commentnum = "'+comment_num+'" data-commentclass= "'+ comment_class +'" + data-commentorder="'+comment_order+'"><button name="answer_add">등록</button>'
				 +  '</div>';
			$(this).closest("div").append(html);
		}else{
			var html = "";
			html += '<div id="answer_div">'
				 +	'	<input type="text" name="answer_add_value" data-commentnum = "'+comment_num+'"data-commentclass= "'+ comment_class +'" + data-commentorder="'+comment_order+'"><button name="answer_add">등록</button>'
				 +  '</div>';
			$(this).closest("div").append(html);
		}
	});
	
	//답글 등록
	$(document).on("click","[name='answer_add']",function(){
		var comment_val = $(this).closest("div").find(":input[name=answer_add_value]").val();
		var comment_num = $(this).closest("div").find(":input[name=answer_add_value]").data("commentnum");
		var commentclass = $(this).closest("div").find(":input[name=answer_add_value]").data("commentclass");
		var commentorder = $(this).closest("div").find(":input[name=answer_add_value]").data("commentorder");
		var bnum = $("#bnum").val();
		
		if(comment_val==""){
			alert("댓글 텍스트를 입력해주세요");
		}else{
		
			var param = {
				comment_txt : comment_val,
				board_num : bnum,
				comment_class : commentclass,
				comment_order : commentorder,
				group_num : comment_num
			}
			
			console.log(param);
			$.ajax({
				type:"GET",
				url: "/answer_add",
				data : param,
				success: function(data){
					var _data = data || {};
						
					comment_selete_html();	
				},
				error: function(e){
					
				}
			})
		}
	});
	
	function comment_selete_html(){
		
		var bnum = $("#bnum").val();
		
		var param = {
			board_num : bnum
		}
		
		$.ajax({
			type:"GET",
			url:"/comment_select",
			data : param,
			success: function(data){
				var _data = data || {};
				
				console.log("_data: "+JSON.stringify(_data));
				
				var successYN = _data.successYN;
				var commentList = "";
				if(successYN=='Y'){
					commentList = _data.commentList || {};
					console.log("commentList: "+ JSON.stringify(_data.commentList));
					$("#comment_html").empty();
					var html ="";
					$.each(commentList,function(i,data){
						html	+= '<div id ="comment" style="border:2px solid; padding:10px" data-commentnum="'+data.coment_num+'" data-commentnum="'+data.coment_num+'" data-commentclass = "'+data.comment_class+'" data-commentorder = "'+data.comment_order+'">'
							 	+ '	<b>'+data.user_name+'</b>'
							 	+ '	<button class = "comment_delete">삭제</button>'
							 	+ '	<button class = "comment_answer_div">답글</button>'
							 	+ '	<div>'+	data.comment_txt+ '	</div>'
							 	+ '	<div class="coment_reply">'
							 	+ '	</div>';
							 
							 $.each(data.answerList,function(j,adata){
								 console.log("adata: ",adata);
								 html 	+='<div data-commentnum="'+adata.coment_num+'" data-commentnum="'+adata.coment_num+'" data-commentclass = "'+adata.comment_class+'" data-commentorder = "'+adata.comment_order+'">'
								 		+ '	<img src="/static/img/turn.png" style="width: 20px;">'
										+ '	<b>'+adata.user_name+'</b>'
								 		+ '	<button class = "comment_delete">삭제</button>'
								 		+ '	<button class = "comment_answer_div">답글</button>'
								 	  	+ '	<div>' + adata.comment_txt + '</div>'
									  	+ '	<div class="coment_reply">'
									  	+ '	</div>'
									  	+ '</div>';
							 });
							 
						html += '</div>';	
					});					
					$("#comment_html").append(html);
					
				}else if(successYN=='L'){
					location.href = url;
				}
			},
			error: function(e){
				console.log(e);
			}		
				
		});		
		
	}	
	
});