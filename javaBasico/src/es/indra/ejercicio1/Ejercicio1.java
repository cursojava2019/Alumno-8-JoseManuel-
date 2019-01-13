package es.indra.ejercicio1;

import java.util.Scanner;

/**
 * @author CURSOJAVA
 *
 */
public abstract class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner (System.in);
		
		System.out.print("Introduzca un numero para ver si es divisible por 2");
		int numero=entrada.nextInt();
		if(numero % 2 == 0) {
			System.out.println("El numero: "+numero+" es divisible por 2");
		}else {
			System.out.println("El numero: "+numero+" no es divisible por 2");
		}
	}

}
