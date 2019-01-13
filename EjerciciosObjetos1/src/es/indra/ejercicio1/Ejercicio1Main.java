package es.indra.ejercicio1;

import java.util.Scanner;

public class Ejercicio1Main {

	private static Scanner entrada;
	private static Cuenta cuenta1;

	public static void inicializar() {
		entrada = new Scanner(System.in);
		cuenta1 = null;
	}

	public static void main(String[] args) {
		inicializar();
		int opcion = 0;

		do {
			System.out.println("Introduzca la operacion que desea relaizar");
			System.out.println("1- Inicializar cuenta");
			System.out.println("2- Añadir Saldo");
			System.out.println("3- Retirar Saldo");
			System.out.print("0- Finalizar");
			opcion = entrada.nextInt();
			entrada.nextLine();
			switch (opcion) {
			case 1:
				inicializarCuenta();
				break;
			case 2:
				aniadirSaldo();
				break;
			case 3:
				retirarSaldo();
				break;
			case 0:
				System.out.println("Fin del programa");
				break;
			default:
				break;
			}
		} while (opcion != 0);

	}

	private static void retirarSaldo() {
		if (cuenta1 != null) {
			System.out.println("Introduzca la cantidad que desea retirar y pulse intro: ");
			Double saldo = entrada.nextDouble();
			entrada.nextLine();
			cuenta1.retirar(saldo);
			System.out.println("El resultado es: " + cuenta1.toString());
		} else {
			System.out.println("Debe inicializar la cuenta antes de hacer un ingreso");
		}

	}

	private static void aniadirSaldo() {
		if (cuenta1 != null) {
			System.out.println("Introduzca la cantidad que desea añadir y pulse intro: ");
			Double saldo = entrada.nextDouble();
			entrada.nextLine();
			cuenta1.ingresar(saldo);
			System.out.println("El resultado es: " + cuenta1.toString());
		} else {
			System.out.println("Debe inicializar la cuenta antes de hacer un ingreso");
		}
	}

	private static void inicializarCuenta() {
		System.out.println("Introduzca el nombre del titular y pulse intro: ");
		String titular = entrada.nextLine();
		System.out.println("Introduzca la cantidad del saldo y pulse intro: ");
		Double saldo = entrada.nextDouble();
		entrada.nextLine();
		cuenta1 = new Cuenta(titular, saldo);
		System.out.println("El resultado es: " + cuenta1.toString());

	}

}
