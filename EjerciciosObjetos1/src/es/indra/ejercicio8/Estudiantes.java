package es.indra.ejercicio8;

public class Estudiantes extends Persona {
	Float calificacion;

	public Estudiantes(String nombre, char sexo, Integer edad, Float calificacion) {
		super(nombre, sexo, edad);
		this.calificacion = calificacion;
	}

	public Float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Float calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public boolean ausente(boolean ausente) {
		return ausente;
	}

	@Override
	public String toString() {
		return super.toString() + " Calificacion: " + this.calificacion;
	}

}
