module.exports = function(request, response){
	
	var HOST = 'localhost';
	var PORT = '3535';
	
	function updateJsonUrls(jsonObject, host, port){
		for (var key in jsonObject){
		  	if (jsonObject.hasOwnProperty(key)){
		  		if (typeof jsonObject[key] == 'object' && jsonObject[key] !== null){
		            updateJsonUrls(jsonObject[key], host, port);
		  		} 
		  		if (typeof jsonObject[key] == 'string'){
		    	  var urlParser = require('url');	

		    	  var url = urlParser.parse(jsonObject[key]);
		    	  if (typeof url !== 'undefined'){
		    		  url.hostname = host;
		    		  url.port = port;
		    		  url.host = null;
		    		  //response.body.field = urlParser.format(url);
		    		  jsonObject[key] = urlParser.format(url);
		    	  }
		      }
		  	}
		}		
	}
	
	if(!response || !response.body){
		return;
	}
	
	var jsonObject = JSON.parse(response.body);
	updateJsonUrls(jsonObject, HOST, PORT);
	
	response.body = jsonObject;
}