package es.indra.controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import es.indra.model.Comprador;
import es.indra.model.Concesionario;

public class Programa {

	private static Concesionario concesionario = null;
	private static String NOMBRE_FICHERO_CONCESIONARIO = "concesionario.dat";
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
	}

	public static void aniadirVehiculo() {

	}

	public static void listadoVehiculosDisponibles() {

	}

	public static void listadoVehiculosPropietario() {

	}

	public static void crearVenta() {

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
				break;
			case 2:
				aniadirVehiculo();
				break;
			case 3:
				listadoVehiculosDisponibles();
				break;
			case 4:
				listadoVehiculosPropietario();
				break;
			case 5:
				crearVenta();
				break;
			case 0:
				System.out.println("Fin del programa");
				break;
			default:
				break;
			}
		} while (opcion != 0);

		try

		{
			fin();
		} catch (IOException e) {
			System.out.println("NO SE HA PODIDO GUARDAR. ERROR FATAL");
			e.printStackTrace();
		}

	}

}
