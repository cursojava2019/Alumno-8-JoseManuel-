/*
Ejercicio 4: Mostrar texto oculto
Para llevar a cabo este ejercicio utilice el fichero: /index.html y  cree un nuevo fichero llamado /js/blog.js. 
La tarea es añadir alguna interactividad a la sección blog de la página:
1.	Al hacer click en alguno de los titulares del div #blog, se debe mostrar el párrafo correspondiente con un efecto
de deslizamiento;
2.	Al hacer click en otro titular, se debe ocultar el párrafo mostrado con un efecto de deslizamiento y mostrar nuevamente
 el párrafo correspondiente también con un efecto de deslizamiento. Ayuda: No se olvide de utilizar el selector :visible. 
 * */
//$(".day").css("background-color", "blue");
$(document).ready(function() {
	$("#blog h3 a").removeAttr( "href" );
	$("#blog li").click(function(){
	    var $this = $(this).children("p");
	    $("#blog li p").not($this).hide("slow");
	    $this.toggle("slow");
	});
	
});