/**
 * 
 */
$(function(){
	
	$("#busId").on("click",function(){
		var param = {
			ServiceKey: "HF9Hb7iX%2FTC5fegODcUsW1f4sSYXD16vxpwD0AcSkyXom1ZBZ75QIBBBU%2FCrYwXL0iTqOiGloRgnc%2Bv%2B49%2F0xw%3D%3D",
			pageNo :1,
			numOfRows:10,
			dataType:"JSON",
			code1:"N500",
			code2:"ANL",
			time:"20230126"
		}
		$.ajax({
			url:'/api',
			type:'GET',
			data:param,
			contentType : "application/json",
			success:function(data){
				console.log("data:",data);
			},
			error:function(e){
				
			}
			
		})	
	});
	

});	