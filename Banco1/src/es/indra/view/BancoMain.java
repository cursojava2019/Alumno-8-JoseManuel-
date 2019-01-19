package es.indra.view;

import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

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
		Long saldo = null;
		System.out.println("Introduce la cantidad: ");
		saldo = ENTRADA.nextLong();
		ENTRADA.nextLine();
		return saldo;
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
		while (tipo == null) {
			System.out.println("Introduce el tipo de cuenta (Corriente,Vivienda,Inversion):");
			tipo = ENTRADA.nextLine();
			tipo = operaciones.valideTipo(tipo);
		}

		Cuenta c = new Cuenta(codigo, saldo, comision, tipo, cl,false);
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
	public static String validarCliente() {
		System.out.println("Introduzca su DNI");
		String dni=ENTRADA.nextLine();
		if(operaciones.existeCliente(dni) == null) {
			dni=null;
		};
		return dni;
	};
	public static void menuUsuario(String dni) {
		int opMenuUsuario = 1;
		do {
			System.out.println("3- Realizar ingresos en una cuenta");
			System.out.println("4- Sacar Dinero de una cuenta");
			System.out.println("5- Ver el estado de la cuenta bancaria");
			System.out.println("6- Revisión mensual de las cuentas");
			System.out.print("1- Finalizar");
			opMenuUsuario = ENTRADA.nextInt();
			ENTRADA.nextLine();

			switch (opMenuUsuario) {	
				case 3:
					ingresarDineroMU(dni,pedirCodigo(), introducirCantidad());
	
					break;
				case 4:
					sacarDineroMU(dni,pedirCodigo(), introducirCantidad());
					break;
				case 5:
					estadoCuentaMU(dni,pedirCodigo());
					break;
				case 6:
					// revisionMensualCuentas();
					break;
				case 1:
					System.out.println("Fin del programa");
					break;
				default:
					break;
				}
		} while (opMenuUsuario != 1);
	}
	public static void crearCuentaYCliente() {
		Cliente cl = crearCliente();
		Cuenta c = crearCuenta(cl);
		operaciones.aniadirCuentaEspecifica(c);
	}

	public static void ingresarDineroMU(String dni, Long codigo, Long saldo) {
		Object c =operaciones.obtenerCuenta(dni,codigo);
		if(c != null) {
			CuentaCorriente cc = new CuentaCorriente();
			CuentaVivienda cv = new CuentaVivienda();
			FondoInversion fi = new FondoInversion();
			if(c.getClass().equals(cc.getClass())) {
				cc = (CuentaCorriente) c;
				cc.setSaldo((cc.getSaldo() + saldo));
				operaciones.actualizarCuenta(codigo, cc);
				System.out.println("Todo correcto");
			}else if(c.getClass().equals(cv.getClass())) {
				cv = (CuentaVivienda) c;
				cv.setSaldo((cv.getSaldo() + saldo));
				operaciones.actualizarCuenta(codigo, cv);
				System.out.println("Todo correcto");
			}else if(c.getClass().equals(fi.getClass())) {
				fi = (FondoInversion) c;
				fi.setSaldo((fi.getSaldo() + saldo));
				operaciones.actualizarCuenta(codigo, fi);
				System.out.println("Todo correcto");
			}else {
				System.out.println("Algo salio mal.");
			}
		}else {
			System.out.println("Cliente erroneo");
		}
	}

	public static void sacarDineroMU(String dni, Long codigo, Long saldo) {
		Object c = operaciones.obtenerCuenta(dni,codigo);
		CuentaCorriente cc = new CuentaCorriente();
		CuentaVivienda cv = new CuentaVivienda();
		FondoInversion fi = new FondoInversion();
		if(c.getClass().equals(cc.getClass())) {
			cc = (CuentaCorriente) c;
			cc = OperacionesCuenta.sacarDineroCC(cc,saldo);
			if(cc != null) {
				operaciones.actualizarCuenta(codigo, cc);
				System.out.println("Todo correcto");
			}else {
				System.out.println("Esta intentando sacar mas dinero del que dispone");
			}
			
		}else if(c.getClass().equals(cv.getClass())) {
			System.out.println("De la cuenta Vivienda no se puede sacar dinero. Lo sentimos");
		}else if(c.getClass().equals(fi.getClass())) {
				fi = (FondoInversion) c;
				if(fi.getBloqueada()==false) {
					fi = OperacionesCuenta.sacarDineroFI(fi,saldo);
					if(fi != null) {
						operaciones.actualizarCuenta(codigo, fi);
						System.out.println("Todo correcto");
					}else {
						System.out.println("Esta intentando sacar mas de 500 euros. La cuenta ha sido bloqueada");
						fi.setBloqueada(true);
						operaciones.actualizarCuenta(codigo, fi);
					}
				}else {
					System.out.println("Lo sentimos, su cuenta está bloqueada");
				}
			
		}else {
			System.out.println("Algo salio mal.");
		}
	}

	public static void estadoCuentaMU(String dni, Long codigo) {
		Object c = operaciones.obtenerCuenta(dni,codigo);
		OperacionesCuenta.visualizarCuenta(c);
	}

	public static void main(String[] args) {
		operaciones = new OperacionesCuenta();
		System.out.println("Bienevenido al Banco");
		int opcion = 0;
		do {
			System.out.println("Introduzca la operacion que desea relaizar");
			System.out.println("1- Crear nueva cuenta y cliente");
			System.out.println("2- Entrar en mi menu");
			System.out.print("0- Finalizar");
			opcion = ENTRADA.nextInt();
			ENTRADA.nextLine();

			switch (opcion) {
			case 1:
				crearCuentaYCliente();
				break;
			case 2:
				String dni = validarCliente();
				if(dni != null) {
					opcion=0;
					menuUsuario(dni);
				};
				
				break;
			case -1:
				menuUsuario(dni);
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
