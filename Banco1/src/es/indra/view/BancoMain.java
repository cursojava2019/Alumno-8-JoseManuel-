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
	private static OperacionesCuenta operaciones = new OperacionesCuenta();
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

	public static TreeMap<Long, CuentaCorriente> crearCuentaYCliente(TreeMap<Long, CuentaCorriente> cuentasCorriente) {
		Cliente cl= crearCliente();
		Cuenta c = crearCuenta(cl);
		System.out.println(c.toString());
		String tipo = c.getTipo();
		if(tipo.equals("corriente")) {
			cuentasCorriente = new TreeMap<Long, CuentaCorriente>();
			CuentaCorriente c2 = new CuentaCorriente(c.getCodigo(),c.getSaldo(),c.getComision(),c.getTipo(),c.getCliente());
			cuentasCorriente.put(c2.getCodigo(),c2);
			OperacionesCuenta operacionesCuentasCorriente = new OperacionesCuenta(cuentasCorriente);
		}
		return cuentasCorriente;
	}
	public static TreeMap<Long, CuentaCorriente> ingresarDinero(TreeMap<Long, CuentaCorriente> cuentasCorriente,Long codigo,Long saldo) {
		CuentaCorriente c2 = cuentasCorriente.get(codigo);
		c2.setSaldo((c2.getSaldo()+saldo));
		cuentasCorriente.replace(codigo, c2);
		System.out.println(cuentasCorriente.toString());
		return cuentasCorriente;
	}
	public static void main(String[] args) {
		TreeMap<Long, CuentaCorriente> cuentasCorriente = null;
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
				cuentasCorriente=crearCuentaYCliente(cuentasCorriente);
				break;
			case 3:
				System.out.println("Introduce el codigo de la cuenta:");
				Long codigo = ENTRADA.nextLong();
				ENTRADA.nextLine();				
				System.out.println("Introduce la cantidad a ingresar:");
				Long saldo = ENTRADA.nextLong();
				ENTRADA.nextLine();
				if(cuentasCorriente !=null) {
					cuentasCorriente=ingresarDinero(cuentasCorriente, codigo,saldo);
				}else {
					System.out.println("Es null");
				}
				
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
