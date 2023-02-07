$(function(){
	$(".nav-item #question").addClass('active');
	
	$(document).ready(function(){
		$(document).attr("title","고객문의");
	
		var param = {
				page : 1,
				recordSize : 10,
				pageSize : 5,
				keyword : '',
				searchType : '',
				categoryId : '4'
		}
		searchPage(param);
		
	});
	
	function searchPage(param){
		$.ajax({
			type:"GET",
			url:"/board/select",
			data: param,
			success: function(data){
				var _data = data || {};
				console.log("data: ",_data);
				
				const successYN = _data.successYN;
				
				if(successYN=='Y'){
					
					let boardList = _data.boardList;
					let pagination =_data.pagination;
					
					var boardhtml = "";
					var pagehtml = "";
					
					$("#boardHtml").empty();
					$("#pageHtml").empty();
					
					for(i=0;i<boardList.length;i++){
						let boardData = boardList[i]; 
						boardhtml 	+=  '<tr>'
									+	'	<td>'
									+	'		<input type="checkbox" name="chk" value="'+boardData.board_num+'">'
									+	' 	</td>'
									+	'	<th scope="row" class="bnum">'+boardData.board_num+'</th>'
									+	'	<td class="bcate">'+boardData.board_cgy_txt+'</td>'
									+	'	<td class="btitle">'
									+	'		<a class="boardDetailGo" data-bnum = "'+boardData.board_num+'">'
									+				boardData.board_title
									+	'		</a>'
									+	'	</td>'
									+	'	<td>'+boardData.user_name+'</td>'
									+	'	<td class="bcnt">'+boardData.board_viewcnt+'</td>'
									+	'	<td class="bdate">'+boardData.board_date+'</td>'
									+	'</tr>'
					}		
					
						
					console.log("pagination: ",pagination);
						
					const existPrevPage = pagination.existPrevPage;
					const existNextPage = pagination.existNextPage;
					let startPage = pagination.startPage;
					let endPage = pagination.endPage;
					
					if(existPrevPage==true){
						pagehtml +=	'<a class="pagecnt" data-cnt="'+ startPage-1 +'" href="javascript:void(0);">이전</a>'	
					}
					
					for(j=1;j<endPage+1;j++){
						pagehtml += '<a class="pagecnt" data-cnt="'+j+'" href ="javascript:void(0);"> '+j+' </a>'
					}
					
					if(existNextPage==true){
						pagehtml += '<a class="pagecnt" data-cnt="'+endPage+1+'" href="javascript:void(0);">다음</a>';
					}
					
					$("#boardHtml").append(boardhtml);
					$("#pageHtml").append(pagehtml);
					
				}else if(successYN=='L'){
					location.href=url
				}
			},
			error: function(e){
				
			}
		});		
	}
})