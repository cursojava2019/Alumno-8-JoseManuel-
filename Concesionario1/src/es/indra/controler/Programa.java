package es.indra.controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import es.indra.model.Comprador;
import es.indra.model.Concesionario;
import es.indra.model.Vehiculo;
import es.indra.model.Venta;

public class Programa {

	private static final String FICHERO_VENTAS = "venta.txt";
	private static Concesionario concesionario = null;
	private static final String NOMBRE_FICHERO_CONCESIONARIO = "concesionario.dat";
	private static Scanner ENTRADA = new Scanner(System.in);

	public static void init() throws ClassNotFoundException, IOException {
		File file = new File(NOMBRE_FICHERO_CONCESIONARIO);

		try {
			FileInputStream fileInput = new FileInputStream(file);
			ObjectInputStream objetoInput = new ObjectInputStream(fileInput);
			concesionario = (Concesionario) objetoInput.readObject();
			objetoInput.close();

		} catch (FileNotFoundException e) {
			concesionario = new Concesionario();
			System.out.println("El concesionario se inicializa desde cero al no encontrar el fichero");
		}

	}

	public static void aniadirPropietario() {
		System.out.println("Introduce los datos del propietario");
		System.out.println("Introduce DNI: ");
		String dni = ENTRADA.nextLine();
		System.out.println("Introduce nombre: ");
		String nombre = ENTRADA.nextLine();
		System.out.println("Introduce apellidos: ");
		String apellidos = ENTRADA.nextLine();
		System.out.println("Introduce el TLF: ");
		String tlf = ENTRADA.nextLine();
		System.out.println("Introduce una direccion: ");
		String direccion = ENTRADA.nextLine();
		System.out.println("Introduce CP: ");
		String cp = ENTRADA.nextLine();
		Comprador comprador = new Comprador(dni, nombre, apellidos, tlf, direccion, cp);
		concesionario.aniadirComprador(comprador);
		System.out.println("Comprador aniadido correctamente");
	}

	public static void aniadirVehiculo() {
		System.out.println("Introduce los datos del Vehiculo");
		System.out.println("Introduce Codigo: ");
		Long codigo = ENTRADA.nextLong();
		ENTRADA.nextLine();
		System.out.println("Introduce Anio: ");
		Integer anio = ENTRADA.nextInt();
		ENTRADA.nextLine();
		System.out.println("Introduce Kilometraje: ");
		Integer km = ENTRADA.nextInt();
		ENTRADA.nextLine();
		System.out.println("Introduce marca: ");
		String marca = ENTRADA.nextLine();
		System.out.println("Introduce tipo: ");
		String tipo = ENTRADA.nextLine();
		ENTRADA.nextLine();
		Vehiculo v = new Vehiculo(codigo, marca, tipo, anio, km, true);
		concesionario.aniadirVehiculo(v);
		System.out.println("Vehiculo aniadido correctamente");
	}

	public static void listadoVehiculosDisponibles() {
		System.out.println("Listado Vehiculos");
		List<Vehiculo> listado = concesionario.vehiculosDisponibles();
		for (Vehiculo vehiculo : listado) {
			System.out.println(vehiculo);
		}
	}

	public static void listadoVehiculosPropietario() {
		System.out.println("Introduce DNI: ");
		String dni = ENTRADA.nextLine();
		Comprador c = concesionario.obtenerComprador(dni);
		if (c != null) {
			List<Vehiculo> listado = concesionario.vehiculosPropietario(dni);
			System.out.println("El comprador indicado es: " + c);
			for (Vehiculo vehiculo : listado) {
				System.out.println(vehiculo);
			}
		}

	}

	public static void crearVenta() {
		System.out.println("Introduce el Codigo del vehiculo a vender: ");
		Long codigo = ENTRADA.nextLong();
		ENTRADA.nextLine();
		Vehiculo v = concesionario.obtenerVehiculo(codigo);
		if (v == null) {
			System.out.println("No se ha encontrado el vehiculo");
			return;
		}

		System.out.println("Introduce el DNI del comprador: ");
		String dni = ENTRADA.nextLine();
		Comprador c = concesionario.obtenerComprador(dni);
		if (c == null) {
			System.out.println("No se ha encontrado el comprador");
			return;
		}
		System.out.println("Introduce el precio de venta");
		Double precio = ENTRADA.nextDouble();
		ENTRADA.nextLine();
		Venta venta = concesionario.nuevaVenta(dni, codigo, precio);
		if (venta != null) {
			File file = new File(FICHERO_VENTAS);
			if (!file.exists()) {
				try {
					file.createNewFile();

				} catch (IOException e) {
					System.out.println("Error al crear el fichero");
					e.printStackTrace();
				}
			}
			try {
				PrintWriter salida = new PrintWriter(file);
				salida.println(venta.toString());
				salida.flush();
				salida.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Fichero creado correctamente");
			System.out.println("Venta realizada correctamente");
		} else {
			System.out.println("Error. No se ha podido realizar la venta.");
		}
	}

	public static void fin() throws IOException {
		File file = new File(NOMBRE_FICHERO_CONCESIONARIO);
		file.delete();
		file.createNewFile();
		FileOutputStream fileOut;

		try {
			fileOut = new FileOutputStream(file);

			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(concesionario);
			objectOut.flush();
			objectOut.close();
		} catch (IOException e) {
			System.out.println("Error guardado en disco.Se ha perdido todo");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			init();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Error al iniciar de disco al no encontrar el archivo. Inicializamos el concesionario");
			concesionario = new Concesionario();
		}
		System.out.println("Bienevenido al concesionario");
		int opcion = 0;
		try {
			do {
				System.out.println("Introduzca la operacion que desea relaizar");
				System.out.println("1- Añadir propetario");
				System.out.println("2- Añadir vehiculo");
				System.out.println("3- Lista Vehiculos");
				System.out.println("4- Lista Vehiculos por comprador");
				System.out.println("5- Introducir venta");
				System.out.print("0- Finalizar");
				opcion = ENTRADA.nextInt();
				ENTRADA.nextLine();

				switch (opcion) {
				case 1:
					aniadirPropietario();
					fin();
					break;
				case 2:
					aniadirVehiculo();
					fin();
					break;
				case 3:
					listadoVehiculosDisponibles();
					break;
				case 4:
					listadoVehiculosPropietario();
					break;
				case 5:
					crearVenta();
					fin();
					break;
				case 0:
					System.out.println("Fin del programa");
					break;
				default:
					break;
				}
			} while (opcion != 0);

		} catch (Exception e) {
			System.out.println("Error al guardar el fichero");
			e.printStackTrace();
		}

		try

		{
			fin();
		} catch (IOException e) {
			System.out.println("NO SE HA PODIDO GUARDAR. ERROR FATAL");
			e.printStackTrace();
		}

	}

}
