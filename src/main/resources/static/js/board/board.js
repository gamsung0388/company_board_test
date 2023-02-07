$(function(){
	$(".nav-item #board").addClass('active');
	
	$(document).ready(function(){
		
		$(document).attr("title","보통 게시글");
				
			var param = {
				page : 1,
				recordSize : 10,
				pageSize : 5,
				keyword : '',
				searchType : '',
				categoryId : '1'
			}
		
			searchPage(param);
		}
	);	
	
	//클릭시 게시물 상세로
	$(document).on('click','.boardDetailGo',function(){
		var bnum = this.dataset.bnum;
		
		let pageId = "board";
		
		location.href = "/board/detail?bnum="+bnum + "&pageId="+ pageId;
	});	
	
	//전체 삭제
	$("#allChk").on("click",function(){
		let chked = $(this).is(":checked");
		
		if(chked==false){
			$("[name='chk']").prop("checked", false)
		}else{
			$("[name='chk']").prop("checked", true)	
		}
	});
	
	//하나 체크시 전체 삭제 풀림
	$(document).on("click","[name='chk']",function(){
		let total = $("[name='chk']").length;
		let checked = $("[name='chk']:checked").length;
		
		if(total != checked){
			$("#allChk").prop("checked",false);
		} else{
			$("#allChk").prop("checked",true);
		}
		
	});
	//등록버튼
	$("#boardInsert").on('click',function(){
		let pageId = "board";
		location.href = "/board/insertpage?pageId="+pageId;
	});
	//삭제버튼
	$("#boardDelete").on("click",function(){
		
		var chk_arr = [];
		$("[name='chk']:checked").each(function(){
			var chk = $(this).val();
			chk_arr.push(chk);
		});
		
		console.log("chk_arr: ",chk_arr);
		
		boardDelte(chk_arr);	
	});	
	
	//페이지
	$(document).on("click",".pagecnt",function(){
		
		var cnt = $(this).data("cnt");
		var searchType = $("#searchType").val();
		var searchtxt = $("#searchtxt").val();
		
		var param = {
			page : cnt,
			recordSize : 10,
			pageSize : 5,
			keyword : searchtxt,
			searchType : searchType,
			categoryId : '1'
		}
		searchPage(param)
		//location.href = "/board/board?"+new URLSearchParams(param);
						
	});
	
	$("#searchBtn").on("click",function(){
		
		var cnt = $(this).data("cnt");
		var searchType = $("#searchType").val();
		var searchtxt = $("#searchtxt").val();
		
		var param = {
			page : cnt,
			recordSize : 10,
			pageSize : 5,
			keyword : searchtxt,
			searchType : searchType
		}
		searchPage(param)
		//location.href = "/board/board?"+new URLSearchParams(params);
	});	
	
	function boardDelte(chkArr){
		
		const param = {
			chkArr : chkArr
		}
		
		$.ajax({
			type:"GET",
			url:"/board/alldelete",
			data:param,
			success: function(data){
				var successYN =data.successYN;
				
				if(successYN=='Y'){
					
					var sparam = {
						page : 1,
						recordSize : 10,
						pageSize : 5,
						keyword : '',
						categoryId : '1'
					}
					
					searchPage(sparam);
				}else if(successYN=='L'){
					
					location.href = url;
					
				}
				
			},
			error: function(e){
				
			}
		})
	}
	
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
			error: function(){
				
			}
			
		})
	}
	
	
	
	
})