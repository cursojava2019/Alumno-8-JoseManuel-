package es.indra.ejercicio5;

public class Ejercicio5Main {

	public static void main(String[] args) {
		Videojuego[] videojuegos = new Videojuego[5];
		Serie[] series = new Serie[5];
		int vEntregados = 0;
		String nVideojuego = "";
		videojuegos[0] = new Videojuego();
		videojuegos[1] = new Videojuego("PAC-MAN", new Float(100));
		videojuegos[2] = new Videojuego("Mario", "nintendo", "Arcade", new Float(300));
		videojuegos[3] = new Videojuego("Age of empire", "pc", "conquista", new Float(720));
		videojuegos[4] = new Videojuego("pc-futbol", new Float(520.30));
		videojuegos[4].entregar();
		videojuegos[2].devolver();
		for (int i = 0; i < videojuegos.length; i++) {

			if (videojuegos[i].isEntregado()) {
				vEntregados++;
			}
		}
		float hVideojuego = 0;
		for (int i = 0; i < videojuegos.length; i++) {
			hVideojuego = videojuegos[i].hEstimadas;
			for (int x = 0; x < videojuegos.length; x++) {
				if (hVideojuego < videojuegos[x].hEstimadas) {
					nVideojuego = videojuegos[x].titulo;
				}
			}
		}

		System.out.println("De " + videojuegos.length + " videojuegos se han entregado " + vEntregados);
		System.out.println("El videojuego con mas horas es: " + nVideojuego);

	}

}
