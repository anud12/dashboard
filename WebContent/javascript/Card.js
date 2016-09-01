Card = {

	init : function()
	{
		$(".card" + " > .card-title").ready(function()
		{
			divId = $(".card" + " > .card-title").parent().attr('id');
			$(".card" + " > .card-title").click(function()
			{
				$(this).parent().toggleClass("card-open");
			});
		});
	}
}