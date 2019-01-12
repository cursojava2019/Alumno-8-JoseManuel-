
/*
 * 1.Pulsar botón. Realiza una página que muestre el mensaje “Hola a todos”
 *  en una ventana haciendo una llamada a una función JavaScript. Utilizar la función Alert().
 * 
 */

document.getElementById("botonSaludar").onclick = funcionSaludar;

function funcionSaludar(){
	alert("Hola a todos");
};
/*
 * 2.Entrada y salida de página.
 * Realiza una página que muestre el mensaje "Bienvenido" al entrar en la página y
 * muestre el mensaje "Adios" al salir de la página.
 */

//document.getElementById("main").onload= bienvenido; 

function bienvenido(){
	alert("Bienvenido");
};
document.getElementById("main").onunload = adios;

function adios(){
	alert("Adios");
};


 
/*
 *4.OnMouseOver(). Realiza una página que muestre cinco cuadrados de diferentes colores.
 * Cuando el raton pase por encima de alguno de ellos el color de fondo será del color de relleno del cuadrado. 
 */
document.getElementById("cuadrado1").onmouseover = cambiarColor;
document.getElementById("cuadrado2").onmouseover = cambiarColor;
document.getElementById("cuadrado3").onmouseover = cambiarColor;
document.getElementById("cuadrado4").onmouseover = cambiarColor;
function cambiarColor(){
	this.style.backgroundColor = "purple";
}

/*
 *5.Conversor monetario. Realiza una página que muestre 
 *un formulario para la conversión de Euros a Pesetas o viceversa. Los campos del formulario han de poder ser limpiados. 
 *Para calcular de euros a pesetas
 *euros*166.386;
 *pesetas/166.386;
 */
document.getElementById("cambiar").onclick = cambio;
document.getElementById("borrar").onclick = borrar;

function cambio() {
	var eu = parseFloat(document.getElementById("euros").value);
	var euros = document.getElementById("euros").value;
	var pesetas = parseFloat(document.getElementById("pesetas").value);
	var resultado=0.0;
		
	if(pesetas.length == 0){
		document.getElementById("euros").value = euros + " \u20AC";
		resultado= eu*166.386;
		document.getElementById("pesetas").value = resultado + " pta";
	}
	if(euros.length == 0){
		document.getElementById("pesetas").value = pesetas + " pta";
		resultado= pesetas/166.386;
		document.getElementById("euros").value = resultado + " \u20AC";
	}

}

function borrar() {
	document.getElementById("pesetas").value = "";
	document.getElementById("euros").value = "";
}
/*
//6-Password. Realiza una página que muestre una entrada protegida con 
password a un web. Comprobar que la contraseña que mete el usuario sea la correcta
*/

document.getElementById("enviar").onclick = contrasena;

function contrasena(){
	var pass=document.getElementById("pass").value;
	if (pass=='123'){ 
		document.getElementById("mensajeForm").innerHTML= nombre="La contrase&ntildea es correcta";
	    
	} 
	else{ 
		document.getElementById("mensajeForm").innerHTML= nombre="La contrase&ntildea es incocorrecta";
	}

}

/*
7.Saludo. Realiza una página que pregunte el nombre de entrada y muestre una página 
con un saludo con la fuente Comic Sans y de tamaño 10.Distinguir la hora del día para 
saber si es por la mañana, por la tarde o por la noche.
*/

document.getElementById("saludoYHora").onclick = hora;

function hora() {
	var nombre = document.getElementById("nombre").value ;
	var d= new Date();
	var hora = d.getHours();
	if(hora<12){
		var saludo="Buenos dias " + nombre;  
	}else if(hora<20){
		var saludo="Buenos tardes " + nombre;
	}else if(hora<23){
		var saludo="Buenos noches " + nombre;
	} 
	document.getElementById("hora").style.fontSize="10px";
	document.getElementById("hora").style.fontFamily="Comic Sans MS";
	document.getElementById("hora").innerHTML=saludo; 
}

//8. Arrays. Leer una cadena de texto en un formulario y generar un array con la función split().
//Posteriormente, mostrar la siguiente información: Número de palabras, primera palabra, última palabra,
//las palabras colocadas en orden inverso, las palabras ordenadas de la a la z y las palabras ordenadas de la z a la a. 
//Sacar toda esta información en una ventana nueva

document.getElementById("botonPalabra").onclick = infoPalabra;

function infoPalabra() {
	var cadena=document.getElementById("palabra").value;
	var res = cadena.split(" ");
	document.getElementById("menPalabra").innerHTML="La primera palabra es: "+res[0]+"<br />La Ultima palabra es: "+res[(res.length-1)]+
	"<br />Frase desordenada: "+res.reverse()+"<br />Frase ordenada alfabeticamente: "+res.sort()
	+"<br />Frase ordenada alfabeticamente de la z-a: "+res.sort().reverse()+"<br />";
	
	
}

//9. Coordenadas de ratón en la barra de estado.
// Realiza una página que capture las coordenadas de ratón y las muestre en la barra de estado.

document.body.onmouseover= coordenadas;
function coordenadas(event) {
	 x=event.clientX;
	 y=event.clientY;
	 
	 document.getElementById("x").value = x;
	 document.getElementById("y").value = y;
	 windows.status="X: "+x+" Y: "+y;
	 
	}

//10. Reloj edit box. Realiza una página que muestre la fecha y la hora actual en un reloj que se va actualizando.

var x = new Date();
var f = x.toDateString();
document.getElementById("fecha").innerHTML = f;
var myVar = setInterval(myTimer, 1000);

function myTimer() {
  var d = new Date();
  var t = d.toLocaleTimeString();
  document.getElementById("fechaHora").innerHTML = "&nbsp &nbsp&nbsp"+t;
}

/*
 *11. Verficación formulario. Realiza una página que muestre un formulario y verifique la entrada
 de un número que esté comprendido entre 1..100.
 
 * */
document.getElementById("botonNum").onclick= comprobarNum;
function comprobarNum(){
	var num=document.getElementById("num").value;
	if(num>=1 && num<=100){
		 document.getElementById("menNum").innerHTML = "El numero esta entre 1 y 100";
	}else{
		document.getElementById("menNum").innerHTML = "El numero no esta entre 1 y 100. Compruebe que es un numero";
	}

}
/*

 
12. Test radio button. Realiza una página que efectúe test de evaluación a través de radio button de tres opciones. 
La página prporcionará la evaluación y las respuesta correctas a petición del usuario.

*/
document.getElementById("botonRespuesta").onclick= comprobarCiudad;
function comprobarCiudad(){

	var x = document.getElementsByName('ciudad');
	for(var i=0;i<x.length;i++){
			if(x[i].checked){
				if(x[i].value=="Madrid"){
					document.getElementById("respuesta").innerHTML = "La respuesta es correcta";
					i=x.length;
				}else{
					document.getElementById("respuesta").innerHTML = "La respuesta es incorrecta. La Respuesta correcta es Madrid";
				}
			}
		};
}

/*
13. Calculadora tabla formulario. Realiza una página implemente una calculadora aritmética. 
Para ello haz uso de una tabla y un formulario.

*/

//Declaracion de variables
var num1 = 0;
var num2 = 0;
var opera;

//Función que coloca el número presionado
function darNumero(numero){
if(num1==0 && num1 !== '0.'){
    num1 = numero;
}else{
    num1 += numero;
}
refrescar();
}


//Esta función realiza las distintas operaciones aritméticas en función del botón pulsado
function operar(valor){
if (num1 == 0){
    num1 = parseFloat(document.getElementById("valor_numero").value);
}
num2 = parseFloat(num1);
num1= 0;
opera = valor;
}

//Función para pulsar igual
/*
multiplicacion = 1
division = 2
suma = 3
resta = 4
*/

function esIgual(){
num1 = parseFloat(num1);
switch (opera){
    case 1:
        num1 *= num2;
    break;
    case 2:
        num1 = num2 / num1;
    break;
    case 3:
        num1 += num2;
    break;
    case 4:
        num1 = num2 - num1;
    break;

}
refrescar();
num2 = parseFloat(num1);
num1 = 0;
}

function refrescar(){
document.getElementById("valor_numero").value = num1;
}
//Función que coloca la C al presionar dicho botón
function darC(){
    num1 = 0;
    num2 = 0;
    refrescar();
}

/*
14. Cambio de imágenes. Realiza una página que muestre una imagen que cambie cuando el ratón 
en pase por encima de la imagen y que vuelva a cambiar cuando salga de ella.

*/
document.getElementById("caraSon1").onmouseout = cambiarfotoOut1;
document.getElementById("caraSon1").onmouseover = cambiarfotoOver1;

function cambiarfotoOut1(){
	this.setAttribute("src", "img/cara%20triste1.jpg");
	
}
function cambiarfotoOver1(){
	this.setAttribute("src", "img/cara%20sonriente1.jpg");
}
document.getElementById("caraSon2").onmouseout = cambiarfotoOut2;
document.getElementById("caraSon2").onmouseover = cambiarfotoOver2;

function cambiarfotoOut2(){
	this.setAttribute("src", "img/cara%20triste2.jpg");
	
}
function cambiarfotoOver2(){
	this.setAttribute("src", "img/cara%20sonriente2.jpg");
}
document.getElementById("caraSon3").onmouseout = cambiarfotoOut3;
document.getElementById("caraSon3").onmouseover = cambiarfotoOver3;

function cambiarfotoOut3(){
	this.setAttribute("src", "img/cara%20triste3.jpg");
	
}
function cambiarfotoOver3(){
	this.setAttribute("src", "img/cara%20sonriente3.jpg");
}

/*
15. Construir un validador para un formulario de registro. Crear un formulario con los campos 
que se indican más abajo para que se validen los campos  al introducir datos en cada uno de ellos,
es decir, al perder el foco. Si el campo no cumple las restricciones, se mostrará una alerta al usuario,
pero se le permitirá seguir introduciendo datos en el resto de campos.
En el momento en el que el usuario envíe el formulario (evento submit), se validarán todos los campos y el 
formulario no se enviará si alguno de los campos no es válido. Las restricciones a cumplir son las siguientes:
        a. El nombre, email y comentarios son campos obligatorios.
        b. El campo email debe ser una dirección de email válida.
        c. El texto introducido en el campo de comentarios no debe exceder los 50 caracteres.
        d. El password debe tener una longitud mínima de 6 caracteres, y contener al menos una letra minúscula, 
        una letra mayúscula y un dígito.

 
 * */


document.getElementById("enviarForm").onclick = comprobarForm;
function pierdeBlur(){
	var nombre=document.getElementById("nom").value;
	var email=document.getElementById("email").value;
	var comentario=document.getElementById("comentario").value;
	var contrasena=document.getElementById("contrasena").value;
	if(nombre.length==0){
		document.getElementById("mensajeNom").innerHTML="El nombre no puede estar vacio";
	};
	if(email.length==0){
		document.getElementById("mensajeEmail").innerHTML="El email no puede estar vacio";
	}else if(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(email))){
		document.getElementById("mensajeEmail").innerHTML="El email no es valido";
	};
	if(comentario.length==0){
		document.getElementById("mensajeComentario").innerHTML="El campo comentario no puede estar vacio";
	}else if(comentario.length > 50){
		document.getElementById("mensajeComentario").innerHTML="El comentario no puede tener mas de 50 caracteres";
	};
	if(contrasena.length<6){
		document.getElementById("mensajePass").innerHTML="La contrasena tiene que tener un minimo de 6 caracteres. Incluyendo uno en mayusculas, uno en" +
				"minusculas y un digito";
	}else if(!(/^(?=.*\d)(?=.*[a-záéíóúüñ]).*[A-ZÁÉÍÓÚÜÑ]/.test(contrasena))){
		document.getElementById("mensajePass").innerHTML="La contrasena debe incluir un caracter en mayusculas, uno en" +
		"minusculas y un digito";
	}else{
		document.getElementById("mensajePass").innerHTML="La contrasena es valida";
	};
}

function ganaFoco(){
	document.getElementById("mensajeNom").innerHTML="";
	document.getElementById("mensajePass").innerHTML="";
	document.getElementById("mensajeComentario").innerHTML="";
	document.getElementById("mensajeEmail").innerHTML="";
}


function comprobarForm(){
	var nombre=document.getElementById("nom").value;
	var email=document.getElementById("email").value;
	var comentario=document.getElementById("comentario").value;
	var contrasena=document.getElementById("contrasena").value;
	var valido=false;
	if(nombre.length==0){
		document.getElementById("mensajeNom").innerHTML="El nombre no puede estar vacio";
		valido=false;
	}else if(email.length==0){
		document.getElementById("mensajeEmail").innerHTML="El email no puede estar vacio";
		valido=false;
	}else if(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(email))){
		document.getElementById("mensajeEmail").innerHTML="El email no es valido";
		valido=false;
	}else if(comentario.length==0){
		document.getElementById("mensajeComentario").innerHTML="El campo comentario no puede estar vacio";
		valido=false;
	}else if(comentario.length > 50){
		document.getElementById("mensajeComentario").innerHTML="El comentario no puede tener mas de 50 caracteres";
		valido=false;
	}else if(contrasena.length<6){
		document.getElementById("mensajePass").innerHTML="La contrasena tiene que tener un minimo de 6 caracteres. Incluyendo uno en mayusculas, uno en" +
				"minusculas y un digito";
		valido=false;
	}else if(!(/^(?=.*\d)(?=.*[a-záéíóúüñ]).*[A-ZÁÉÍÓÚÜÑ]/.test(contrasena))){
		document.getElementById("mensajePass").innerHTML="La contrasena debe incluir un caracter en mayusculas, uno en" +
		"minusculas y un digito";
		valido=false;
	}else{
		valido=true;
	};
	if(valido==true){
		document.getElementById("formulario").submit();
	}
}


