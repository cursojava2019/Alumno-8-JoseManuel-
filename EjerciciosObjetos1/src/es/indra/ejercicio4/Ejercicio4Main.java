package es.indra.ejercicio4;

import java.util.ArrayList;

public class Ejercicio4Main {

	public static void main(String[] args) {

		/*
		 * Television t1 = new Television((float) 300, (float) 10); Television t2 = new
		 * Television((float) 200.50, (float) 8.5); Television t3 = new
		 * Television((float) 100.50, (float) 8.5);
		 */
		Television t4 = new Television((float) 200.50, "NEGRO", 'A', (float) 8.5);
		Lavadora l1 = new Lavadora();
		Lavadora l2 = new Lavadora((float) 500, (float) 50);
		Lavadora l3 = new Lavadora((float) 500, "ROJO", 'A', (float) 50, (float) 10);
		Electrodomestico e = new Electrodomestico();
		Electrodomestico e2 = new Electrodomestico((float) 100, (float) 30);
		Electrodomestico[] lista = new Electrodomestico[10];
		ArrayList<Electrodomestico> listaBuena = new ArrayList<Electrodomestico>();
		listaBuena.add(l1);
		listaBuena.add(t4);

		listaBuena.add(l2);

		listaBuena.add(e);
		listaBuena.add(l3);
		listaBuena.add(e2);

		Float totalTV = (float) 0;
		Float totalLavadoras = (float) 0;
		Float totalElectrodomesticos = (float) 0;

		for (Electrodomestico electrodomestico : listaBuena) {

			if (electrodomestico instanceof Television) {
				totalTV += electrodomestico.precioFinal();
			}
			if (electrodomestico instanceof Lavadora) {
				System.out.println("Lavadora: ");
				totalLavadoras += electrodomestico.precioFinal();
			}
			System.out.println(electrodomestico.getClass().getName() + " :" + electrodomestico.precioFinal());
			totalElectrodomesticos += electrodomestico.precioFinal();
		}
		System.out.println("El total de las televsiones es: " + totalTV);
		System.out.println("El total de las Lavadoras es: " + totalLavadoras);
		System.out.println("El total de los Electrodomesticos es: " + totalElectrodomesticos);
	}

}
