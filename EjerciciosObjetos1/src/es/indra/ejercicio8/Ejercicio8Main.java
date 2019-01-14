package es.indra.ejercicio8;

public class Ejercicio8Main {

	public int totalAlumnos(boolean ausente) {
		int totalAlumnos = 0;
		if (ausente == false)
			totalAlumnos++;
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
			totalAlumnos = totalAlumnos(estudiantes[i].ausente());
		}
	}

}
