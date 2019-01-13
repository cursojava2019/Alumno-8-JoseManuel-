package es.indra.ejercicio2;

import java.util.Scanner;

public class Ejercicio2Main {

	private static Scanner entrada;

	public static void inicializar() {
		entrada = new Scanner(System.in);
	}

	public static void main(String[] args) {
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
		System.out.println("Introduzca sex0: ");
		sexo = entrada.next().charAt(0);
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
		System.out.println("Introduzca sex0: ");
		persona3.setSexo(entrada.next().charAt(0));

		System.out.println("La persona 1 esta: " + persona1.calcularIMC(persona1.peso, persona1.altura));

	}

}
