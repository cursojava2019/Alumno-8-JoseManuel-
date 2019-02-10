/*
 * Funcion para enviar id al servlet.
 */
function confirmarEliminacion(id){
		if (confirm("¿Esta seguro que desea eliminarlo de la BBDD?")){
			location.href='./eliminar.html?id='+id;
		}
		
		
	}
