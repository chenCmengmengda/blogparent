function doData(url,params,callback){
	$.ajax({
		url:url,
		type:'post',
		dataType:'json',
		data:params,
		success:function(data){
			if(callback){
				callback(data);
			}
		}
	});
}

function doDataSyn(url,params,callback){
	$.ajax({
		url:url,
		type:'post',
		dataType:'json',
		data:params,
		async:false,
		success:function(data){
			if(callback){
				callback(data);
			}
		}
	});
}