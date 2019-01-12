/*
3.Cálculo de números primos. Realiza una página para calcular los números primos entre 1 y 100.
*/

var c = 100;
var j = 2;
var resultad="";

for (; j < c; j++) {

 if (primo(j)) {
	  var parrafo = document.createElement("P");                    
	  var texto = document.createTextNode("El "+j+" es numero primo");
	  parrafo.appendChild(texto);                                          
	  document.getElementById("numPrimos").appendChild(parrafo); 
	
 };
 
};
function primo(numero) {

	for (var i = 2; i < numero; i++) {

	   if (numero % i === 0) {
	     return false;
	   };

	 };

	 return numero !== 1;
	};
