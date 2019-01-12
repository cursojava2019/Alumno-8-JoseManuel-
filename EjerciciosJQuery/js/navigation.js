/*
 * Ejercicio 5: Crear un menú desplegable
Para llevar a cabo este ejercicio utilice el fichero: /index.html y  cree un nuevo fichero llamado /js/navigation.js. 

La tarea es poder desplegar los ítems del menú superior de la página:
•	Al pasar el puntero del ratón por encima de un ítem del menú, se debe mostrar su submenú en caso que exista;
•	Al no estar más encima de un ítem, el submenú se debe ocultar.
Para poder realizarlo, utilice el método $.fn.hover para añadir o eliminar una clase en el submenú para poder controlar
 si debe estar oculto o visible (El archivo /ejercicios/css/styles.css incluye una clase hover para este propósito).
 */
$(document).ready(function() {
	$("#nav li").removeClass('selected');
	$("#nav li").hover(function(){
			$(this).addClass('selected');
		    $(this).addClass('hover');
		    $(this).children('ul').css('display','inline');
	},function(){
			$(this).removeClass('selected');
			$(this).removeClass('hover');
			$(this).children('ul').css('display','none');
			
		}); 
});