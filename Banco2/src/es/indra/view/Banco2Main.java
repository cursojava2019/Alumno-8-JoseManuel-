package es.indra.view;

import java.io.IOException;
import java.util.Scanner;

import es.indra.controler.OperacionesCuenta;
import es.indra.model.entities.Cliente;
import es.indra.model.entities.Cuenta;

public class Banco2Main {
	private static OperacionesCuenta operaciones = null;
	private static Scanner ENTRADA;

	/*
	 * Funcion que crean, leen y cierra el fichero donde se guardan las operaciones
	 * del banco
	 */
	public static void init() throws ClassNotFoundException, IOException {
		ENTRADA = new Scanner(System.in);
		operaciones = new OperacionesCuenta();

	}

	public static void fin() throws IOException {

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Funciones donde se le pide al usuario que introduzca el codigo de la cuenta,
	 * al introducir el dni comprobar que existe y la cantidad que va a ingresar o
	 * sacar
	 *
	 */

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

	public static String validarCliente() {

		System.out.println("Introduzca su DNI");
		String dni = ENTRADA.nextLine();
		if (!operaciones.existeCliente(dni)) {
			dni = "null";
		}
		;
		return dni;
	};

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Funciones para crear una cuenta generica de tipo Cuenta, crear el cliente y
	 * despues juntar esa cuenta (especificar el tipo) y a�adirle el cliente
	 */
	public static Cuenta crearCuenta(String dniCliente) {
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

		Cuenta c = new Cuenta(codigo, saldo, comision, tipo, dniCliente, false);
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
		operaciones.aniadirCliente(cl);
		Cuenta c = crearCuenta(cl.getDni());
		operaciones.aniadirCuentaEspecifica(c);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * /////////////////////////////////////////////////////////////////////////////
	 * Funciones para el menu del Usuario. A este menu se accede una vez que se haya
	 * validado el cliente
	 * 
	 * public static void ingresarDineroMU(String dni, Long codigo, Long saldo) {
	 * Object c = operaciones.obtenerCuenta(dni, codigo); if (c != null) {
	 * CuentaCorriente cc = new CuentaCorriente(); CuentaVivienda cv = new
	 * CuentaVivienda(); FondoInversion fi = new FondoInversion(); if
	 * (c.getClass().equals(cc.getClass())) { cc = (CuentaCorriente) c;
	 * cc.setSaldo((cc.getSaldo() + saldo)); operaciones.actualizarCuenta(codigo,
	 * cc); File file = new File(FICHERO_OPERACIONES); if (!file.exists()) { try {
	 * file.createNewFile(); } catch (IOException e) {
	 * System.out.println("Error al crear fichero"); e.printStackTrace(); }
	 * 
	 * } FileWriter salida; try { salida = new FileWriter(file, true);
	 * 
	 * salida.write(cc.toString()); salida.flush(); salida.close(); } catch
	 * (Exception e) {
	 * 
	 * e.printStackTrace(); } System.out.println("Todo correcto"); } else if
	 * (c.getClass().equals(cv.getClass())) { cv = (CuentaVivienda) c;
	 * cv.setSaldo((cv.getSaldo() + saldo)); operaciones.actualizarCuenta(codigo,
	 * cv); File file = new File(FICHERO_OPERACIONES); if (!file.exists()) { try {
	 * file.createNewFile(); } catch (IOException e) {
	 * System.out.println("Error al crear fichero"); e.printStackTrace(); }
	 * 
	 * } FileWriter salida; try { salida = new FileWriter(file, true);
	 * 
	 * salida.write(cv.toString()); salida.flush(); salida.close(); } catch
	 * (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * System.out.println("Todo correcto"); } else if
	 * (c.getClass().equals(fi.getClass())) { fi = (FondoInversion) c;
	 * fi.setSaldo((fi.getSaldo() + saldo)); operaciones.actualizarCuenta(codigo,
	 * fi); File file = new File(FICHERO_OPERACIONES); if (!file.exists()) { try {
	 * file.createNewFile(); } catch (IOException e) {
	 * System.out.println("Error al crear fichero"); e.printStackTrace(); }
	 * 
	 * } FileWriter salida; try { salida = new FileWriter(file, true);
	 * 
	 * salida.write(fi.toString()); salida.flush(); salida.close(); } catch
	 * (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * System.out.println("Todo correcto"); } else {
	 * System.out.println("Algo salio mal."); } } else {
	 * System.out.println("La cuenta no existe");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * public static void sacarDineroMU(String dni, Long codigo, Long saldo) {
	 * Object c = operaciones.obtenerCuenta(dni, codigo); if (c != null) {
	 * CuentaCorriente cc = new CuentaCorriente(); CuentaVivienda cv = new
	 * CuentaVivienda(); FondoInversion fi = new FondoInversion(); if
	 * (c.getClass().equals(cc.getClass())) { cc = (CuentaCorriente) c; cc =
	 * OperacionesCuenta.sacarDineroCC(cc, saldo); if (cc != null) {
	 * operaciones.actualizarCuenta(codigo, cc);
	 * System.out.println("Todo correcto"); } else {
	 * System.out.println("Esta intentando sacar mas dinero del que dispone"); }
	 * 
	 * } else if (c.getClass().equals(cv.getClass())) { System.out.
	 * println("De la cuenta Vivienda no se puede sacar dinero. Lo sentimos"); }
	 * else if (c.getClass().equals(fi.getClass())) { fi = (FondoInversion) c; if
	 * (fi.getBloqueada() == false) { fi = OperacionesCuenta.sacarDineroFI(fi,
	 * saldo); if (fi != null) { operaciones.actualizarCuenta(codigo, fi);
	 * System.out.println("Todo correcto"); } else { System.out.
	 * println("Esta intentando sacar mas de 500 euros. La cuenta ha sido bloqueada"
	 * ); fi.setBloqueada(true); operaciones.actualizarCuenta(codigo, fi); } } else
	 * { System.out.println("Lo sentimos, su cuenta est� bloqueada"); }
	 * 
	 * } else { System.out.println("Algo salio mal."); } } else {
	 * System.out.println("La cuenta no existe");
	 * 
	 * } }
	 */////////////////////////////////////////////////////////////////////////////////////////

	public static void estadoCuentaMU(Long codigo) {
		Cuenta cuenta = operaciones.visualizarCuenta(codigo);
		if (cuenta != null) {
			System.out.println(cuenta.toString());
		} else {
			System.out.println("La cuenta no existe");
		}
	}

//	public static void revisionMensualCuentasMU() {
//		operaciones.revisionMensualCuentas();
//	};

	public static void menuUsuario(String dni) {
		int opMenuUsuario = 1;
		try {
			do {
				System.out.println("3- Realizar ingresos en una cuenta");
				System.out.println("4- Sacar Dinero de una cuenta");
				System.out.println("5- Ver el estado de la cuenta bancaria");
				System.out.println("6- Revisi�n mensual de las cuentas");
				System.out.print("1- Finalizar");
				opMenuUsuario = ENTRADA.nextInt();
				ENTRADA.nextLine();

				switch (opMenuUsuario) {
				case 3:
//					ingresarDineroMU(dni, pedirCodigo(), introducirCantidad());

					break;
				case 4:
//					sacarDineroMU(dni, pedirCodigo(), introducirCantidad());

					break;
				case 5:
					estadoCuentaMU(pedirCodigo());
					break;
				case 6:
//					revisionMensualCuentasMU();

					break;
				case 1:
					System.out.println("Fin del programa");
					break;
				default:
					break;
				}
			} while (opMenuUsuario != 1);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		try {
			init();
		} catch (ClassNotFoundException | IOException e1) {
			System.out.println("Error al iniciar las variables");
			operaciones = new OperacionesCuenta();
		}

		System.out.println("Bienevenido al Banco");
		int opcion = 0;
		try {
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
					String dniUsuario = "";
					dniUsuario = validarCliente();
					if (!dniUsuario.equals("null")) {
						opcion = 0;
						menuUsuario(dniUsuario);
					}
					;

					break;
				case 0:
					System.out.println("Fin del programa");
					break;
				default:
					break;
				}
			} while (opcion != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}