package es.indra.view;

import java.util.Scanner;
import java.util.TreeMap;

import com.sun.org.apache.regexp.internal.recompile;

import es.indra.controler.OperacionesCuenta;
import es.indra.model.Cliente;
import es.indra.model.Cuenta;
import es.indra.model.CuentaCorriente;
import es.indra.model.CuentaVivienda;
import es.indra.model.FondoInversion;

public class BancoMain {
	private static OperacionesCuenta operaciones = null;
	private static Scanner ENTRADA = new Scanner(System.in);
	
public static Cuenta crearCuenta(Cliente cl) {

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
		tipo = operaciones.valideTipo(tipo);
		Cuenta c = new Cuenta(codigo,saldo,comision,tipo,cl);
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
		Cliente cl= crearCliente();
		Cuenta c = crearCuenta(cl);
		String tipo = c.getTipo();
		if(tipo.equals("corriente")) {
			CuentaCorriente c2 = new CuentaCorriente(c.getCodigo(),c.getSaldo(),c.getComision(),c.getTipo(),c.getCliente());
			if(operaciones.aniadirCC(c2)) {
			
				System.out.println("Cuenta creada correctamente.");
			}else {
				System.out.println("Algo ha fallado.La cuenta no se ha creado.");
			}
		}
	}
	public static void ingresarDinero(Long codigo,Long saldo) {
		CuentaCorriente cc = operaciones.obtenerCuenta(codigo);
		cc.setSaldo((cc.getSaldo()+saldo));
		operaciones.actualizarCuenta(codigo,cc);
	}
	public static void sacarDinero(Long codigo,Long saldo) {
		CuentaCorriente cc = operaciones.obtenerCuenta(codigo);
		cc.setSaldo((cc.getSaldo()-saldo));
		operaciones.actualizarCuenta(codigo,cc);
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
				System.out.println("Introduce el codigo de la cuenta:");
				Long codigo3 = ENTRADA.nextLong();
				ENTRADA.nextLine();				
				System.out.println("Introduce la cantidad a ingresar:");
				Long saldo3 = ENTRADA.nextLong();
				ENTRADA.nextLine();
				ingresarDinero(codigo3,saldo3);
				
				break;
			case 4:
				System.out.println("Introduce el codigo de la cuenta:");
				Long codigo4 = ENTRADA.nextLong();
				ENTRADA.nextLine();				
				System.out.println("Introduce la cantidad a sacar:");
				Long saldo4 = ENTRADA.nextLong();
				ENTRADA.nextLine();
				ingresarDinero(codigo4,saldo4);
				sacarDinero(codigo4,saldo4);
				break;
			case 5:
				System.out.println("Introduce el codigo de la cuenta:");
				Long codigo5 = ENTRADA.nextLong();
				ENTRADA.nextLine();				
				estadoCuenta(codigo5);
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
