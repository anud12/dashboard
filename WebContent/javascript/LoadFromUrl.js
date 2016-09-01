LoadFromUrl = {
	load : function(json)
	{
		$(document).ready(function() 
		{
        	setInterval(function()
			{
        		$.get
            	(
        			json.url,
        			{},
        			function(responseText)
        			{
    				$("#" + json.destination).html(responseText);
        			}
    			)
			}, 1500)
		});
	},
	example : 
	{
		url:"resource/MONTH",
		destination:"div-15"
	}
}

LoadFromUrl.load(LoadFromUrl.example);