package es.indra.ejercicio8;

public class Profesosr extends Persona {

	String materia;

	public Profesosr(String nombre, char sexo, Integer edad, String materia) {
		super(nombre, sexo, edad);
		this.materia = materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public boolean ausente(boolean ausente) {
		// TODO Auto-generated method stub
		return ausente;
	}

	@Override
	public String toString() {

		return super.toString() + " materia: " + this.materia;
	}

}
