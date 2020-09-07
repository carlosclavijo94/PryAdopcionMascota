function report(){	
	$.ajax({
		url : "/mascota/dataRptMascotasPorEdades",
		method : 'GET',
		success : function(response){		
			
			console.log(response);
			
			var mascotas = [];
			var tipo = [];
			var edad = [];
					
			$.each(response, function(i, item){
				console.log(item);
				mascotas.push(item.nombre);
				tipo.push(item.tipo_mascota);
				edad.push(item.edad);
			});
			
			var barChartData = {
				labels: ['MENOS DE 2', 'ENTRE 2 Y 5', 'MAS DE 5'],
				datasets: [{
					label: 'Dataset 1',
					data: [

					]
				}, {
					label: 'Dataset 2',
					data: [

					]
				}]

			};

			window.onload = function() {
				var ctx = document.getElementById('canvas').getContext('2d');
				window.myBar = new Chart(ctx, {
					type: 'bar',
					data: barChartData,
					options: {
						responsive: true,
						legend: {
							position: 'top',
						},
						title: {
							display: true,
							text: 'Mascotas por Edad'
						}
					}
				});

			};
			
			
			
			
		},
		error : function(err){
			console.log(err);
		}		
	});	
}

$(document).ready(function(){
	
	report();		
	
});
















