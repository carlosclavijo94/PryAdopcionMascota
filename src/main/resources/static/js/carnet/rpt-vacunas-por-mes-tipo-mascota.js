function report(){	
	$.ajax({
		url : "/carnet/dataRptVacunasPorMesTipoMascota",
		method : 'GET',
		success : function(response){
			console.log(response);
			
			var _mes=[];
			var _perro=[];
			var _gato=[];
			
			$.each(response, function(i, item){
				console.log(item);
				_mes.push(item.mes);
				_perro.push(item.perro);	
				_gato.push(item.gato);
			});
			
			var color = Chart.helpers.color;
			var barChartData = {
				labels: _mes,
				datasets: [{
					label: 'Perros',
					backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),			
					borderWidth: 1,
					data: _perro
				}, {
					label: 'Gatos',
					backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),			
					borderWidth: 1,
					data: _gato
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
nombre:vacunas_por_tipo_mascota_gatos
sql:
SELECT MONTH(cv.fecha_vacunacion) as fecha, MONTHNAME(cv.fecha_vacunacion) as mes,COUNT(cv.pk_carnet_vacunacion) as vacunas_realizadas 
from carnet_vacunacion as cv
INNER JOIN mascotas as ma ON ma.pk_mascota = cv.fk_mascota
WHERE cv.fk_mascota=ma.pk_mascota and ma.tipo_mascota="GATO"
GROUP BY fecha ASC, mes ASC

Procedural 2
nombre:vacunas_por_tipo_mascota_perros
sql:
SELECT MONTH(cv.fecha_vacunacion) as fecha, MONTHNAME(cv.fecha_vacunacion) as mes,COUNT(cv.pk_carnet_vacunacion) as vacunas_realizadas 
from carnet_vacunacion as cv
INNER JOIN mascotas as ma ON ma.pk_mascota = cv.fk_mascota
WHERE cv.fk_mascota=ma.pk_mascota and ma.tipo_mascota="PERRO"
GROUP BY fecha ASC, mes ASC



*/