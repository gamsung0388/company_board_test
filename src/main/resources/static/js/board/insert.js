//파일 현재 필드 갯수
var fileCount = 0;

//전체 업로드 갯수
var totalCount = 10;

//파일 고유 넘버
var fileNum = 0;

//첨부파일 배열
var content_files = new Array();

//파일 시퀀스들
var fileIdxs = "";

//삭제된 파일 리스트
var delete_files = [];


$(function(){
		
	//뒤로
	$("#backPage").on('click',function(){
		history.back();
	});
	
	//파일 클릭
	$(document).on('click',"#board_file",function(e){
		e.preventDefault();
		$("#input_file").click();
	});
	
	//파일 수정
	$(document).on("change","#input_file",function(e){
		var files = e.target.files;
		
		var filesArr = Array.prototype.slice.call(files);
		
		if(fileCount + filesArr.length > totalCount){
			alert("파일은 최대 "+totalCount+"개까지 업로드 할 수 있습니다.");
			return false;
		}else{
			fileCount = fileCount + filesArr.length;
		}
		filesArr.forEach(function(f){
			var reader = new FileReader();
			FileReader.result
			reader.onload = function () {
				content_files.push(f);
				content_files[fileNum].is_delete = false;
				//console.log(content_files);
				$('#articleFileChange').append(
		       		'<div name="files" data-file="'+fileNum+'">'
		       		+ '<font style="font-size:12px">' + f.name + '</font>'  
		       		+ '<img name="file_delete" src="/static/img/delete.png" style="width:20px; height:auto; vertical-align: middle; cursor: pointer;"/>' 
		       		+ '<div/>'
				);
				fileNum++;
			}			
			reader.readAsDataURL(f);
		})
		
		$("#input_file").val("");
		
	});				
	//파일 삭제
	$(document).on("click","[name='file_delete']",function(){
		var no = $(this).closest("div").data("file"); 	
		content_files[no].is_delete = true;
		$(this).closest("div").remove();
		fileCount --;		
		
	});	
	
	$(document).on('click',"[name='before_file_delete']",function(){
		var no = $(this).closest("div").data("file");
		delete_files.push(no);
		$(this).closest("div").remove();
	});
		
	//취소버튼
	$("#cancel").on('click',function(){
		history.back();
	});
	
	//등록,수정 버튼
	$(document).on('click',"#insert",function(){
		
		if(fileCount>0){
			console.log("추가파일이 있을때")
			var form = $("#fileForm");
			var formData = new FormData(form[0]);
			for(i=0;i<content_files.length;i++){
				
				if(!content_files[i].is_delete){
					formData.append("article_file",content_files[i]);
					formData.append("filePath","/board/main");
				}
			}
			$.ajax({
				type:"POST",
				enctype: "mutipart/form-data",
				url: "/file-upload",
				data: formData,
				processData: false,
				contentType: false,
				success: function(data){
					console.log(data);
					
					//파일 시퀀스
					fileIdxs = data.fileIdxs;
					if(data.result == "OK"){
							var btype = $("#insert").data("btype");
							if(btype=='insert'){
								insertfn();
							}else if(btype=='update'){
								updatefn();
							}
					} else
							alert("서버내 오류로 처리가 지연되고있습니다. 잠시 후 다시 시도해주세요");
			   	    },
				error: function (xhr, status, error) {
			   	    	alert("서버오류로 지연되고있습니다. 잠시 후 다시 시도해주시기 바랍니다.");
				}
										
			});
		}else{
			console.log("추가파일이 없을때")
			var btype = $("#insert").data("btype");
			if(btype=='insert'){
				insertfn();
			}else if(btype=='update'){
				updatefn();
			}
		}
						
	});
	
	function insertfn(){
		var chked = insertCheck();
		if(chked==true){
			 
			var board_num = $("#board_num").val();
			var board_cgy_num = $("[name=board_cgy_num]").val();
			var board_title = $("#board_title").val();
			var board_txt = $("#board_txt").val();
			var board_tag = $("#board_tag").val();
			
			var insertdata = {
				board_num : board_num,
				board_cgy_num : board_cgy_num,
				board_title : board_title,
				board_txt : board_txt,
				board_tag : board_tag,
				fileIdxs : fileIdxs
			}	
			
			console.log(insertdata);
			
			$.ajax({
				type:"GET",
				url: "/board/insert",
				data: insertdata,
				success: function(data){
					console.log("data: ",data);
					if(data.successYN=='Y'){
						location.href="/board/board"	
					}
				
			   		},
			   	error: function (xhr, status, error) {
			   	    	alert("서버오류로 지연되고있습니다. 잠시 후 다시 시도해주시기 바랍니다.");
				}	
									
			});
		}
	}
	function updatefn(){
		var chked = insertCheck();
		if(chked==true){
			 
			var board_num = $("#board_num").val();
			var board_cgy_num = $("[name=board_cgy_num]").val();
			var board_title = $("#board_title").val();
			var board_txt = $("#board_txt").val();
			var board_tag = $("#board_tag").val();
			
			var insertdata = {
				board_num : board_num,
				board_cgy_num : board_cgy_num,
				board_title : board_title,
				board_txt : board_txt,
				board_tag : board_tag,
				fileIdxs : fileIdxs,
				delete_files : delete_files
			}	
			
			console.log(insertdata);
			
			$.ajax({
				type:"GET",
				url: "/board/update",
				data: insertdata,
				success: function(data){
					console.log("data: "+data);
					if(data.successYN=='Y'){
						location.href="/board/board"	
					}
				
			   		},
			   	error: function (xhr, status, error) {
			   	    	alert("서버오류로 지연되고있습니다. 잠시 후 다시 시도해주시기 바랍니다.");
				}	
									
			});
		}
	}
	
	//게시물 등록, 수정시 체크
	function insertCheck(){
		var board_title = $("#board_title").val();
		var board_txt = $("#board_txt").val();
		
		if(board_title==''){
			alert("제목을 입력해주세요");
			retrun;
		}else if(board_txt==''){
			alert("내용을 입력해주세요");
			retrun;
		}else{
			return true;
		}
	}
})
