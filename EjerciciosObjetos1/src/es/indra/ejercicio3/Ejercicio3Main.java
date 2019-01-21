package es.indra.ejercicio3;

import java.util.Scanner;

public class Ejercicio3Main {

	public static void main(String[] args) {
		Password[] contrasenas;
		boolean[] esFuerte;
		Scanner entrada= new Scanner(System.in);
		int nArray=0;
		System.out.println("Introduce el numero de contrasenas a generar");
		nArray=entrada.nextInt();
		entrada.nextLine();
		contrasenas = new Password[nArray];
		esFuerte = new boolean[nArray];
		for(int i=0;i<nArray;i++) {
			System.out.println("Que longitud quieres que tenga tu password?");
			Integer longitud= new Integer(entrada.nextInt());
			contrasenas[i]= new Password(longitud);
			esFuerte[i]=contrasenas[i].esFuerte(contrasenas[i].getPass());
			if(esFuerte[i]) {
				System.out.println(contrasenas[i].getPass()+" es fuerte");
			}else {
				System.out.println(contrasenas[i].getPass()+" es debil");
			}
			
		};
			
	}

}
