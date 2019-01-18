package es.indra.view;

import java.util.Scanner;

import es.indra.controler.OperacionesCuenta;
import es.indra.model.Cliente;
import es.indra.model.Cuenta;
import es.indra.model.CuentaCorriente;
import es.indra.model.CuentaVivienda;
import es.indra.model.FondoInversion;

public class BancoMain {
	private static OperacionesCuenta operaciones = null;
	private static Scanner ENTRADA = new Scanner(System.in);

	public static Long pedirCodigo() {
		Long codigo = null;
		System.out.println("Introduce el codigo de la cuenta:");
		codigo = ENTRADA.nextLong();
		ENTRADA.nextLine();

		return codigo;
	}

	public static Long introducirCantidad() {
		Long codigo = null;
		System.out.println("Introduce la cantidad a ingresar:");
		codigo = ENTRADA.nextLong();
		ENTRADA.nextLine();
		return codigo;
	}

	public static Cuenta crearCuenta(Cliente cl) {
		String tipo = null;
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
		while (tipo == null) {
			tipo = ENTRADA.nextLine();
			System.out.println("Introduce el tipo de cuenta (Corriente,Vivienda,Inversion):");
			tipo = operaciones.valideTipo(tipo);
		}

		Cuenta c = new Cuenta(codigo, saldo, comision, tipo, cl);
		return c;
	}

	public static Cliente crearCliente() {
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
		return cl;
	};

	public static void crearCuentaYCliente() {
		Cliente cl = crearCliente();
		Cuenta c = crearCuenta(cl);
		String tipo = c.getTipo();
		if (tipo.equals("corriente")) {
			CuentaCorriente c2 = new CuentaCorriente(c.getCodigo(), c.getSaldo(), c.getComision(), c.getTipo(),
					c.getCliente());
			if (operaciones.aniadirCC(c2)) {

				System.out.println("Cuenta creada correctamente.");
			} else {
				System.out.println("Algo ha fallado.La cuenta no se ha creado.");
			}
		} else if (tipo.equals("vivienda")) {
			CuentaVivienda cv2 = new CuentaVivienda(c.getCodigo(), c.getSaldo(), c.getComision(), c.getTipo(),
					c.getCliente());
			if (operaciones.aniadirCV(cv2)) {
				System.out.println("Cuenta creada correctamente.");
			} else {
				System.out.println("Algo ha fallado.La cuenta no se ha creado.");
			}

		} else if (tipo.equals("inversion")) {
			FondoInversion fi2 = new FondoInversion(c.getCodigo(), c.getSaldo(), c.getComision(), c.getTipo(),
					c.getCliente());
			if (operaciones.aniadirFI(fi2)) {
				System.out.println("Cuenta creada correctamente.");
			} else {
				System.out.println("Algo ha fallado.La cuenta no se ha creado.");
			}
		}
	}

	public static void ingresarDinero(Long codigo, Long saldo) {
		CuentaCorriente cc = operaciones.obtenerCuenta(codigo);
		cc.setSaldo((cc.getSaldo() + saldo));
		operaciones.actualizarCuenta(codigo, cc);
	}

	public static void sacarDinero(Long codigo, Long saldo) {
		CuentaCorriente cc = operaciones.obtenerCuenta(codigo);
		cc.setSaldo((cc.getSaldo() - saldo));
		operaciones.actualizarCuenta(codigo, cc);
	}

	public static void estadoCuenta(Long codigo) {
		CuentaCorriente cc = operaciones.obtenerCuenta(codigo);
		OperacionesCuenta.visualizarCuenta(cc);
	}

	public static void main(String[] args) {
		operaciones = new OperacionesCuenta();
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
				crearCuentaYCliente();
				break;
			case 3:

				ingresarDinero(pedirCodigo(), introducirCantidad());

				break;
			case 4:
				sacarDinero(pedirCodigo(), introducirCantidad());
				break;
			case 5:
				estadoCuenta(pedirCodigo());
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
