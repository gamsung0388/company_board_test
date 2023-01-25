$(function(){
	
	$("#loginBtn").on("click",function(){
				
		var userid = $("#loginId").val();
		var userpw = $("#loginPw").val();
		
		if(userid==""){
			alert("아이디를 입력해주세요");
			$("#loginId").focus();
		}else if(userpw==""){
			alert("비밀번호를 입력해주세요");
			$("#loginPw").focus();
		}else{
			var param  = {
				user_id : userid,
				user_pw : userpw
			}
			loginApi(param);
		}
	});	
	
	$("#memberJoinBtn").on('click',function(){
		var url = "/memberJoinPage";
		var name = "memberjoin"
		
		window.open(url,name,"width=1000,height=1000,toolbar=no,location=no,scrollbarys=yes,menubar=no,resizable=yes,left=50,right=50");
	});
	
	var loginApi = function(param){
				
		return $.ajax({
			
			type: "POST",
			url: "/login",
			data: param,
			success: function(data){
				var data = data || {};
								
				var msg = data.msg;
				var code = data.code;
				
				if(code=="N"){
					alert(msg);					
					$("#loginId").focus();
				}else{
					alert(msg);
					location.href="/"
				}
				
				
			},
			error: function(a,textStatus,errorThrown){
				
			}
		}).done(function(data){
			
		});
	}
});


