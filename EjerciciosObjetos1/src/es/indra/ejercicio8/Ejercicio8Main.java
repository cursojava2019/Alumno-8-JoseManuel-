package es.indra.ejercicio8;

public class Ejercicio8Main {

	public static int totalAlumnos(boolean ausente, int totalAlumnos) {
		if (ausente == false) {
			totalAlumnos++;
		}
		return totalAlumnos;
	}

	public static void main(String[] args) {

		Estudiantes[] estudiantes = new Estudiantes[5];
		Profesosr p1 = new Profesosr();
		int totalAlumnos = 0;
		for (int i = 0; i < estudiantes.length; i++) {
			estudiantes[i] = new Estudiantes();
		}
		System.out.println(p1.toString());
		for (int i = 0; i < estudiantes.length; i++) {
			System.out.println(estudiantes[i].toString());
		}

		for (int i = 0; i < estudiantes.length; i++) {
			boolean aus = estudiantes[i].getAusente();
			totalAlumnos = totalAlumnos(aus, totalAlumnos);
		}
		Aula aula1 = new Aula(new Integer(1), new Integer(5), "fisica");
		if (aula1.disponible(p1.getAusente(), p1.getMateria(), totalAlumnos)) {
			for (int i = 0; i < estudiantes.length; i++) {
				if (estudiantes[i].getCalificacion() >= 5) {
					System.out.println("El alumno: " + estudiantes[i].getNombre() + " esta aprobado con un "
							+ estudiantes[i].getCalificacion());
				}
			}
		}
		;
	}

}
