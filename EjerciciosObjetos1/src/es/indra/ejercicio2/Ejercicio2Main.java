package es.indra.ejercicio2;

import java.util.Scanner;

public class Ejercicio2Main {

	private static Scanner entrada;

	public static void inicializar() {
		entrada = new Scanner(System.in);
	}

	public static void main(String[] args) {
		inicializar();
		Persona persona1, persona2, persona3;
		String nombre = "";
		Integer edad = new Integer(0);
		Double peso = new Double(0);
		Double altura = new Double(0);
		char sexo = 'A';
		System.out.println("Introduzca el nombre: ");
		nombre = entrada.nextLine();
		System.out.println("Introduzca la edad: ");
		edad = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Introduzca el peso: ");
		peso = entrada.nextDouble();
		entrada.nextLine();
		System.out.println("Introduzca el altura: ");
		altura = entrada.nextDouble();
		entrada.nextLine();
		System.out.println("Introduzca sexo: ");
		sexo = entrada.next().charAt(0);
		entrada.nextLine();
		persona1 = new Persona(sexo, nombre, edad, peso, altura);
		persona2 = new Persona(sexo, nombre, edad);
		persona3 = new Persona();
		System.out.println("Introduzca el nombre: ");
		persona3.setNombre(entrada.nextLine());
		System.out.println("Introduzca la edad: ");
		persona3.setEdad(entrada.nextInt());
		entrada.nextLine();
		System.out.println("Introduzca el peso: ");
		persona3.setPeso(entrada.nextDouble());
		entrada.nextLine();
		System.out.println("Introduzca el altura: ");
		persona3.setAltura(entrada.nextDouble());
		entrada.nextLine();
		System.out.println("Introduzca sexo: ");
		persona3.setSexo(entrada.next().charAt(0));

		System.out.println("La persona 1 esta: " + persona1.calcularIMC(persona1.peso, persona1.altura));
		System.out.println("La persona 2 esta: " + persona3.calcularIMC(persona2.peso, persona2.altura));
		System.out.println("La persona 3 esta: " + persona3.calcularIMC(persona3.peso, persona3.altura));
		
		if(persona1.esMayorEdad(persona1.edad)) {
			System.out.println(persona1.nombre+" es mayor de edad");
		}else {
			System.out.println(persona1.nombre+" es menor de edad");
		}
		if(persona2.esMayorEdad(persona2.edad)) {
			System.out.println(persona2.nombre+" es mayor de edad");
		}else {
			System.out.println(persona2.nombre+" es menor de edad");
		}
		if(persona3.esMayorEdad(persona3.edad)) {
			System.out.println(persona3.nombre+" es mayor de edad");
		}else {
			System.out.println(persona3.nombre+" es menor de edad");
		}
		System.out.println(persona1.toString());
		System.out.println(persona2.toString());
		System.out.println(persona3.toString());
	}

}
