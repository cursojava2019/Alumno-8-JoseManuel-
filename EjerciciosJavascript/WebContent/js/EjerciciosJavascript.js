
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
 * 3.Cálculo de números primos. Realiza una página para calcular los números primos entre 1 y 100.
var resultado="";
var primo=false;
for(var n=1;n<=100;n++){
	if(n%2==0){
		resultado += "El numero no es primo: " + n + "<br>";
	}else{
		for(var i=3.0;i*i<=n;i+=2){
			if(n%i==0){
				resultado += "El numero no es primo: " + n + "<br>";
			}else{
				primo=true;
			}
			if(primo==true){
				resultado += "El numero es primo: " + n + "<br>";
			}
		}
		
	}
}
document.getElementById("resultado").innerHTML = resultado; 
 */

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
	var euuros = document.getElementById("euros").value;
	var pesetas = parseFloat(document.getElementById("pesetas").value);
	var resultado=0.0;
		
	if(euros.length != 0){
		document.getElementById("euros").value="0";
		resultado= eu*166.386;
		document.getElementById("pesetas").value = resultado + " pta";
	}
	if(pesetas.length != 0){
		resultado= pesetas/166.386;
		document.getElementById("euros").value = resultado + " &euro";
	}
	//document.getElementById("demo").innerHTML = pesetas;
}

function borrar() {
	document.getElementById("pesetas").value = "";
	document.getElementById("euros").value = "";
}



