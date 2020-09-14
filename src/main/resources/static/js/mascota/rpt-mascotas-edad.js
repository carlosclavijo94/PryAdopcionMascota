function report(){	
	$.ajax({
		url : "/mascota/dataRptMascotasPorEdades",
		method : 'GET',
		success : function(response){		
			console.log(response);
			var mascotas = [];
			var tipom = [];
			var edad = [];
					
			$.each(response, function(i, item){
				console.log(item);
				mascotas.push(item.nombre);
				tipom.push(item.tipo);
				edad.push(item.edad);
			});
			
			
			var perros = [0,0,0];
			var gatos = [0,0,0];
			
			
			tipom.forEach( function(valor, j, array) {
				
				if(edad[j]<2){
					if(tipom[j]=='PERRO'){
						perros[0]=1+perros[0];
					}else{
						gatos[0]=1+gatos[0];
					}
				}
				
				if(edad[j]>=2){
					if(edad[j]<5){
						
						if(tipom[j]=='PERRO'){
							perros[1]=1+perros[1];
						}else{
							gatos[1]=1+gatos[1];
						}
						
					}
				}
				
				if(edad[j]>=5){
					
					if(tipom[j]=='PERRO'){
						perros[2]=1+perros[2];
					}else{
						gatos[2]=1+gatos[2];
					}
					
				}
											
			});
			
			console.log(perros[0]+' perros');
			console.log(gatos[0]+' gatos');
			
			console.log(perros[1]);		
			console.log(gatos[1]);
			
			console.log(perros[2]);
			console.log(gatos[2]);
			
			var barChartData = {
				labels: ['MENOS DE 2 AÑOS', 'ENTRE 2 Y 5 AÑOS', '5 AÑOS O MÁS'],
				datasets: [{
					label: 'GATOS',
					backgroundColor: getRandomColor(),
					data: [gatos[0],gatos[1],gatos[2]]
				},{
					label: 'PERROS',
					backgroundColor: getRandomColor(),
					data: [perros[0],perros[1],perros[2]]
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
 nombre: mascotas_edades
procedure: 
SELECT mascotas.nombre,mascotas.tipo_mascota,mascotas.edad FROM mascotas
ORDER BY mascotas.edad
 */












