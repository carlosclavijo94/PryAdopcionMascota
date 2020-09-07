function consult(){	
	$.ajax({
		url : "/adopcion/dataCltAdopcionMascotas",
		method : 'GET',
		success : function(response){
			console.log(response);
			
			var _id=[];
			var _mascota=[];
			var _imagen=[];
			
			$.each(response, function(i, item){
				console.log(item);
				_id.push(item.id);
				_mascota.push(item.mascota);	
				_imagen.push(item.imagen);
				
			});
			
			$("gallery").html(response);
			
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