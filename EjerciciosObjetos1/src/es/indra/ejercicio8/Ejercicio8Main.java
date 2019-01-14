package es.indra.ejercicio8;

public class Ejercicio8Main {

	public static void main(String[] args) {
		Estudiantes estudiante1= new Estudiantes("Pepe",'M',new Integer (20), new Float(5));
		Profesosr profesor1= new Profesosr("Santi",'M', new Integer (40),"Filosofia");
		boolean ausente=false;
		System.out.println(profesor1.toString());
		System.out.println(estudiante1.toString());
	}

}
