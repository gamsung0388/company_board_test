$(function(){
	$(".nav-item #memberManage").addClass('active');
	$("#updateBtn").click(function(){
		console.log("111111");
		var userId = $("#userId").val();
		var userPw = $("#userPw").val();
		var userName = $("#userName").val();
		var userAge = $("#userAge").val();
		var userGrade = $("[name=userGrade]:checked").val();
		
		if(userId==""){
			alert("아이디를 입력하세요");
			$("#userId").focus();
		}else if(userPw==""){
			alert("비밀번호를 입력하세요");
			$("#userPw").focus();
		}else if(userName==""){
			alert("이름을 입력하세요");
			$("#userName").focus();
		}else if(userAge==""){
			alert("나이을 입력하세요");
			$("#userAge").focus();
		}else if(userGrade==""){
			alert("등급을 선택하세요");
			$("[name=userGrade]").focus();
		}else{
			var param = {
				user_id : userId,
				user_pw : userPw,
				user_name : userName,
				user_age : userAge,
				grade : userGrade 
			}
			
			memeberUpdate(param);
		}
	});
	
	$("#cancleBtn").click(function(){
		history.back();
	});
	
	var memeberUpdate = function(param){
		$.ajax({
			type:"POST",
			url:"/memberUpdate",
			data:param,
			success: function(data){
				if(data=="Y"){
					location.href="/memberManage"
				}else{
					console.log("오류");
				}
			},
			error: function(e){
				console.log(e)
			}
		});
	}
	
});

/**
 * 
 */