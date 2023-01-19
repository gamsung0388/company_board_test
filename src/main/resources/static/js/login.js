$(function(){


//var login = function(){
//	
//	init = function(){
//		
//		this.event();
//		
//		return this;	
//	},
//		
//	event = function(){
//		var _this = this;
//		
//		_this.clickEvent();	
//	},
//	clickEvent = function(){
//		
//		$("#loginBtn").on("click",function(){
//			
//			var userid = $("#userid").val();
//			var userpw = $("#userpw").val();
//			console.log("userid: "+ userid);
//			console.log("userpw: "+ userpw);
//		});		
//		
//	},
//	
//	loginApi = function(){
//		
//	}	
//}	

	/**
	 * 
	 */

	$("#loginBtn").on("click",function(){
				
		var userid = $("#userid").val();
		var userpw = $("#userpw").val();
		console.log("userid: "+ userid);
		console.log("userpw: "+ userpw);
		
		var param  = {
			userid : userid,
			userpw : userpw
		}
		
		loginApi(param);
	
	});	
	
	var loginApi = function(param){
		
		return $.ajax({
			
			type: "POST",
			url: "localhost:8080/totallogin",
			data: JSON.stringify(param),
			contentType: "application/json; charset=utf-8",     
			success: function(data){
				if(data.testVal == 'N'){
					alert(data.testText);	
				}else{
					location.href="view/main"
				}				
			},
			error: function(a,textStatus,errorThrown){
				
			}
		}).done(function(data){
			
		});
	}
});


