/**
 * Ejercicios
 **/

/**
Ejercicio 1: Selectores
Para llevar a cabo este ejercicio utilice el fichero: /index.html y realice las siguientes operaciones.
1.	Seleccionar todos los elementos div que poseen la clase module y ponerle un fondo verde. Crear un botón para realizar esto.
2.	Seleccionar el elemento label del elemento input utilizando un selector de atributo, y ponerle un fondo azul. 
Crear un botón para realizar esto.
3.	Averiguar cuantos elementos en la página están ocultos (ayuda: .length). Hacer un botón que permita calcularlo y 
mostrarlo en un alert por pantalla. Averiguar cuantas imágenes en la página poseen el atributo alt. Hacer un botón que 
permita calcularlo y mostrarlo en un alert.
4.	Seleccionar todas las filas impares del cuerpo de la tabla y ponerle un fondo amarillo.
 **/

$(document).ready(function() {
	var botonModule="<input type='button' id='botonModule' value='cambiar fondo div Module'>";
	$(".module:first").before(botonModule);
	$("#botonModule").click(function(){
		  $(".module").css("background-color", "green");
	}); 
	var botonLabel="<input type='button' id='botonLabel' value='cambiar fondo Label dentro del inpute'>";
	$("label[for='q']").before(botonLabel);
	$("#botonLabel").click(function(){
		 $("label[for='q']").css("background-color", "blue");
	});
	var elementOcultos = $("*:hidden").length
	var imgAlt = $("img[alt]").length
	var bElementOcultos="<input type='button' id='bElementOcultos' value='numero de elementos ocultos'>";
	var bImgAlt="<input type='button' id='bImgAlt' value='numero de img con atrr alt'>";
	$("label[for='q']").before(bElementOcultos,bImgAlt);
	$("#bElementOcultos").click(function(){
		  alert(elementOcultos)
	}); 
	$("#bImgAlt").click(function(){
		  alert(imgAlt);
	}); 
	$("td:even").css("background-color", "yellow");

});
/**
Ejercicio 2: Recorrer el DOM.
Para llevar a cabo este ejercicio utilice el fichero: /index.html y realice las siguientes operaciones.
1.	Seleccionar todas las imágenes en la página; registrar en la consola el atributo alt de cada imagen. 
Crear un botón para ello.
2.	Seleccionar el elemento input, luego dirigirse hacia el formulario y añadirle una clase al mismo que le ponga un fondo gris. 
Crear un botón para ello.
3.	Seleccionar el ítem que posee la clase current dentro de la lista #myList y eliminar dicha clase en el elemento; luego añadir 
la clase current al siguiente ítem de la lista. Crear un botón para ello.
4.	Seleccionar el elemento select dentro de #specials; luego dirigirse hacia el botón submit y escribir su contenido en la consola. 
Crear un botón para ello.
5.	Seleccionar el primer ítem de la lista en el elemento #slideshow; añadirle la clase current al mismo y luego añadir la clase 
disabled a los elementos hermanos. Crea un botón para ello.

 **/

$(document).ready(function() {
	//$("div").hide(); 
	var bMostrarImgAlt="<input type='button' id='bMostrarImgAlt' value='Mostrar por consola img con atrr alt'>";
	$("label[for='q']").before(bMostrarImgAlt); 
	$("#bMostrarImgAlt").click(function(){
		$('img').each(function(){
			console.log($(this).attr('alt'));
		})
	}); 
	var bInputGris="<input type='button' id='bInputGris' value='Poner input con fondo gris'>";
	$("form:last").before(bInputGris); 
	$("#bInputGris").click(function(){
		$('form:last').addClass("gray");
		$('.gray').css("background-color", "gray");
	}); 
	var bCurrent="<input type='button' id='bCurrent' value='Cambiar clase current'>";
	$("#myList").before(bCurrent); 
	$("#bCurrent").click(function(){
		$('.current').next().addClass("current");
		$('.bar').removeClass("current");
	});
	var bValorSubmit="<input type='button' id='bValorSubmit' value='Valor submit por consola'>";
	$("#specials").before(bValorSubmit); 
	$("#bValorSubmit").click(function(){
		console.log($('input[type="submit"]').attr('value'));
	});
	var bElementoSlideShow="<input type='button' id='bElementoSlideShow' value='Quitar y añadir clase al elemento de SlideShow'>";
	$("#slideshow").before(bElementoSlideShow); 
	$("#bElementoSlideShow").click(function(){
		$("#slideshow li:first").addClass("current")
		$("#slideshow li:first").siblings('li').addClass("disabled");
	});
});

/**
Ejercicio 3: Manipulación 
Para llevar a cabo este ejercicio utilice el fichero: /index.html y realice las siguientes operaciones.
1.	Añadir 5 nuevos ítems al final de la lista desordenada #myList. Ayuda: for (var i = 0; i<5; i++) { ... }. Crea un botón para incorporarlos.
2.	Remover los ítems impares de la lista. Crea un botón para eliminarlos
3.	Añadir otro elemento h2 y otro párrafo al último div.module. Crea un botón.
4.	Añadir otra opción al elemento select; darle a la opción añadida el valor Wednesday. Botón para acerlo
5.	Añadir un nuevo div.module a la página después del último; luego añadir una copia de una de las imágenes existentes dentro del nuevo div.
 Crea un botón para ello.

 **/

$(document).ready(function() {
	var bAñadirLi="<input type='button' id='bAñadirLi' value='Añadir 5 nuevos li'>";
	$("#myList").before(bAñadirLi); 
	$("#bAñadirLi").click(function(){
		$('#myList li:last ').append(function(){
			for(var x=0;x<5;x++){
				var l="<li>Item añadido "+x+"</li>";
				$(this).after(l);
			}
		});
	});	
});
$(document).ready(function() {
	var bEliminarLi="<input type='button' id='bEliminarLi' value='Eliminar los li impares'>";
	$("#myList").before(bEliminarLi); 
	$("#bEliminarLi").click(function(){
		$('#myList li:even ').remove();
	});	

var bModuleH2="<input type='button' id='bModuleH2' value='Añadir un H2 y otro parrafo'>";
$(".module:first").before(bModuleH2);
$("#bModuleH2").click(function(){
	  var txtH2="<h2>H2 Aniadido</h2>";
	  var txtP="<p>P Aniadido Lorem Ipsum is simply dummy text of the printing and typesetting industry.  but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>";
	  $(".module:last").append(txtH2,txtP);
});
var bModuleSelect="<input type='button' id='bModuleSelect' value='Añadir Wendsday al select'>";
$("#specials:first").before(bModuleSelect);
$("#bModuleSelect").click(function(){
	  var txtOption="<option value='wendsday'>Wendsday</option>";
	  $("select[name='day']").append(txtOption);
	  
});

var bModuleDiv="<input type='button' id='bModuleDiv' value='Añadir un nuevo Div.Module y una imagen'>";
$(".module:first").before(bModuleDiv);
$("#bModuleDiv").click(function(){
	  var txtDiv="<div class='module'><p>Nuevo div</p><img src='img/foto1.jpg'></div>";
	  $(".module:last").append(txtDiv);
	});

});
