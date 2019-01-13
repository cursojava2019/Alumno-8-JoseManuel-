/*
*Ejercicio 4.Crea un programa básico  que pida por teclado un número entero positivo (debemos controlarlo) y muestra  el número de cifras que tiene.
*Por ejemplo: si introducimos 1250, nos muestre que tiene 4 cifras. Tendremos que controlar si tiene una o más cifras, al mostrar el mensaje.
 * 
 */
package es.indra.ejercicio4;

import java.util.Scanner;

/**
 * @author CURSOJAVA
 *
 */
public class Ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner (System.in);
		int num=0;
		boolean positivo=false;
		System.out.println("Introduzca un numero positivo: ");
		num=entrada.nextInt();
		entrada.nextLine();
		do {
			if(num>0) {
				System.out.println("El numero es positivo ");
				positivo=true;
			}else {
				System.out.println("El numero no es positivo");
				System.out.println("Introduzca un numero positivo: ");
				num=entrada.nextInt();
			}
			
		}while(positivo==false);
		
	
	}

}
