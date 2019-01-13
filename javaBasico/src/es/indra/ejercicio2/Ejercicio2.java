/**
 Ejercicio 2.  Crea un programa básico en java que sea 
 capaz de leer dos numeros por consola y sea capaz de imprimir todos los números que se encuentran entre ambos.
 */
package es.indra.ejercicio2;

import java.util.Scanner;

/**
 * @author CURSOJAVA
 *
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner (System.in);
		int num1=0,num2=0;
		System.out.print("Introduzca un numero");
		num1=entrada.nextInt();
		System.out.print("Introduzca el segundo numero");
		num2=entrada.nextInt();
		System.out.print("Los numeros entre "+num1+" y el "+num2+" son: ");
		for(int i=num1;i<num2;i++) {
			System.out.println(i);
		}
	
	}

}
