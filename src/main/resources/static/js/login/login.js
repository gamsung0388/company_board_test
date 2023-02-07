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
	https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=jyvqXeaVOVmV&redirect_uri=http%3A%2F%2Fservice.redirect.url%2Fredirect&state=hLiDdL2uhPtsftcU
	var clientId = "jxcTtq3MguqNAe7ISDer";
	var callbackUrl = "https://nid.naver.com/oauth2.0/authorize";
	var naver_id_login = new naver_id_login(clientId, callbackUrl);
	var state = naver_id_login.getUniqState();
	naver_id_login.setButton("white", 3, 40);
	naver_id_login.setDomain("localhost:8000/BBS/main.jsp");
	naver_id_login.setState(state);
	naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();
	
});


