
PieChart = 
{
	init: function()
	{
		google.charts.load('current', {'packages' : ['corechart']});

		
	},
	create: function(json){
		google.charts.setOnLoadCallback(function()
				{
					
					PieChart.writeChart
					(json)
					
				});
	},
	example:
	{
		primaryKey:1,
		title:'Something',
		headerLength:1,
		tableId:"table-0",
		drawDestinationId:"table-3",
		appendClass:"chart "
	},
		
	writeChart: function writeChart(json)
	{
		
		var array = tableToArray(json.tableId);
		
		var table = [[]];
		
		//Insert header
		for(var i = 0 ; i < array.length - json.headerLength ; i++)
		{
			table[i] = [];
			
			table[i][0] = array[i + json.headerLength][json.primaryKey] + "";
		}
		
		//Clone table indexes
		
		var max = 0;
		var min;
		for(var i = 0 ; i < array.length - json.headerLength ; i++)
		{
			for(j = 0 ; j < array[i].length ; j++)
			{
				if(j != json.primaryKey)
				{
					table[i][j + 1] = array[i + json.headerLength][j];
					
					if(max < table[i][j + 1])
					{
						max = table[i][j + 1];
					}
					if(min > table[i][j + 1] || min == null)
					{
						min = table[i][j + 1];
					}
				}
				
			}
		}
		
		data = new google.visualization.DataTable();
		
		//Add header
		data.addColumn('string', 'Month');
		
		//Add columns
		for(var i = 0 ; i < table[1].length - 1; i++)
		{
			data.addColumn("number", i);
		}
		
		//Prepare destination
		
		document.getElementById(json.drawDestinationId).className += " " + json.appendClass;
		
		data.addRows(table);
		
		chart = new google.visualization.PieChart(document.getElementById(json.drawDestinationId));
		
		options = {
				title: json.title,
				//colors: ['red'],
				chartArea:{
					width:"100%",
					height:"80%"
				},
				animation:{
					duration:600,
					startup:true,
					easing:'inAndOut'
				},
				areaOpacity:0.2,
				height:document.getElementById(json.drawDestinationId + "").height,
				width:document.getElementById(json.drawDestinationId + "").width,
				legend:{
					'position':'none'
				},
				annotation:{
					color:"transparent",
					style:"line"
				},
				hAxis:{
					gridlines:{
						color:"transparent"
					}
				},
				vAxis:{
					maxValue:max,
					minValue:min,
					gridlines:{
						color:"transparent"
					}
				},
				tooltip:{
					textStyle:{color:'black'}
				}
				
			};
		
		chart.draw(data,options);
		
		window.addEventListener("resize", function()
		{	
			options.height = document.getElementById(json.drawDestinationId + "").height;
			options.width = document.getElementById(json.drawDestinationId + "").width;
			chart.draw(data,options);
		});
	}
}

function tableToArray(id)
{
	//gets table
	var oTable = document.getElementById(id);
	
	//gets rows of table
	var rowLength = oTable.rows.length;
	
	var array = [[]];
	
	//loops through rows    
	for (i = 0; i < rowLength; i++)
	{
	
		array[i] = [];
		//gets cells of current row
		var oCells = oTable.rows.item(i).cells;
		
		//gets amount of cells of current row
		
		var cellLength = oCells.length;
	   
		//loops through each cell in current row
		
		for(var j = 0; j < cellLength; j++)
		{
	      
			var cellVal = oCells.item(j).innerHTML;
			if(isNaN(parseInt(cellVal)))
			{
				array[i][j] = cellVal;
			}
			else
			{
				array[i][j] = parseInt(cellVal);
			}
		}
	}
	return array;
}