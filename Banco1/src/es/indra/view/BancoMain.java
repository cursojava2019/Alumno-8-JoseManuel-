package es.indra.view;

import java.util.Scanner;

import es.indra.controler.OperacionesCuenta;
import es.indra.model.Cliente;
import es.indra.model.CuentaCorriente;
import es.indra.model.CuentaVivienda;
import es.indra.model.FondoInversion;

public class BancoMain {
	private static OperacionesCuenta operacionesCuenta = null;
	private static Scanner ENTRADA = new Scanner(System.in);

	public static void main(String[] args) {
		operacionesCuenta = new OperacionesCuenta();

		System.out.println("Bienevenido al Banco");
		int opcion = 0;
		do {
			System.out.println("Introduzca la operacion que desea relaizar");
			System.out.println("1- Introducir cliente");
			System.out.println("2- Crear cuenta");
			System.out.println("3- Realizar ingresos en una cuenta");
			System.out.println("4- Sacar Dinero de una cuenta");
			System.out.println("5- Ver el estado de la cuenta bancaria");
			System.out.println("6- Revisión mensual de las cuentas");
			System.out.print("0- Finalizar");
			opcion = ENTRADA.nextInt();
			ENTRADA.nextLine();

			switch (opcion) {
			case 1:
				// introducirCliente();
				break;
			case 2:
				System.out.println("Vamos a darnos de alta como cliente:");
				System.out.println("Introduce tu DNI:");
				String dni = ENTRADA.nextLine();
				System.out.println("Introduce tu nombre:");
				String nombre = ENTRADA.nextLine();
				System.out.println("Introduce tu apellido:");
				String apellido = ENTRADA.nextLine();
				System.out.println("Introduce tu direccion:");
				String direccion = ENTRADA.nextLine();
				System.out.println("Introduce tu TLF:");
				String tlf = ENTRADA.nextLine();
				Cliente cl = new Cliente(dni, nombre, apellido, direccion, tlf);

				System.out.println("Vamos a crear la cuenta");
				System.out.println("Introduce el codigo de la cuenta:");
				Long codigo = ENTRADA.nextLong();
				ENTRADA.nextLine();
				System.out.println("Introduce el saldo inicial de la cuenta:");
				Long saldo = ENTRADA.nextLong();
				ENTRADA.nextLine();
				System.out.println("Introduce la comision de la cuenta:");
				Double comision = ENTRADA.nextDouble();
				ENTRADA.nextLine();
				System.out.println("Introduce el tipo de cuenta (Corriente,Vivienda,Inversion):");
				String tipo = ENTRADA.nextLine();
				tipo = operacionesCuenta.valideTipo(tipo);
				if (tipo.equals("corriente")) {
					CuentaCorriente cc = new CuentaCorriente(codigo, saldo, comision, tipo, cl);
					operacionesCuenta.crearCuenta(cc);
				} else if (tipo.equals("vivienda")) {
					CuentaVivienda cv = new CuentaVivienda(codigo, saldo, comision, tipo, cl);
					operacionesCuenta.crearCuenta(cv);
				} else if (tipo.equals("inversion")) {
					FondoInversion fi = new FondoInversion(codigo, saldo, comision, tipo, cl);
					operacionesCuenta.crearCuenta(fi);
				} else {
					System.out.println("No se ha podido crear la cuenta");
				}

				break;
			case 3:
				// ingresarDinero();
				break;
			case 4:
				// sacarDinero();
				break;
			case 5:
				// estadoCuenta();
				break;
			case 6:
				// revisionMensualCuentas();
				break;
			case 0:
				System.out.println("Fin del programa");
				break;
			default:
				break;
			}
		} while (opcion != 0);

	}

}
