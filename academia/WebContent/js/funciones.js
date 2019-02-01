/*
 * Funcion para enviar id al servlet.
 */
function eliminacionProfesor(id){
		if (confirm("¿Esta seguro que desea eliminar este Profesor?")){
			location.href='./eliminar.html?id='+id;
		};
		
	};

function confirmarEliminacion(id){
		if (confirm("¿Esta seguro que desea eliminar este alumno?")){
			location.href='./eliminar.html?id='+id;
		}
		
		
	}


