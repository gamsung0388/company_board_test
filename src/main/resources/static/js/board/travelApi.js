/**
 * 
 */
$(function(){
	
	$("#busId").on("click",function(){
		
		var data = {
			serviceKey: "HF9Hb7iX/TC5fegODcUsW1f4sSYXD16vxpwD0AcSkyXom1ZBZ75QIBBBU/CrYwXL0iTqOiGloRgnc+v+49/0xw==",
			pageNo : "1",
			numOfRows: "10",
			parentCode: "PS01"
		}
		console.log("1111");
		$.ajax({
			url:'http://www.emuseum.go.kr/openapi/code',
			type:'GET',
			data:data,
			success:function(data){
			},
			error:function(e){
				
			}
			
		})	
	});
	

});	