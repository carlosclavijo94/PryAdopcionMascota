function report(){	
	$.ajax({
		url : "/carnet/dataRptVacunasPorMascotas",
		method : 'GET',
		success : function(response){
			console.log(response);
			
			var _mascotas=[];
			var _total=[];
			var _vacunas=[];
			
			$.each(response, function(i, item){
				console.log(item);
				_mascotas.push(item.mascota);
				_vacunas.push(item.vacunas_realizadas);	
				_total.push(item.total);
			});
			
			var color = Chart.helpers.color;
			var barChartData = {
				labels: _mascotas,
				datasets: [{
					label: 'Vacunas Realizadas',
					backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),			
					borderWidth: 1,
					data: _vacunas
				}, {
					label: 'Total Costo',
					backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),			
					borderWidth: 1,
					data: _total
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
							text: 'Vacunas realizadas por mascotas'
						},
						
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero: true
				                }
				            }]
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

/*
procedural
nombre:vacunas_por_mascotas
sql:
SELECT ma.nombre as mascota, COUNT(cv.pk_carnet_vacunacion) as vacunas_realizadas, Sum(cv.costo) as total 
from carnet_vacunacion as cv
INNER JOIN mascotas as ma ON ma.pk_mascota = cv.fk_mascota
GROUP BY ma.nombre

*/