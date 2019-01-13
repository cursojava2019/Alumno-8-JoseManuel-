package es.indra.ejercicio8;

public abstract class Persona {
	String nombre;
	char sexo;
	Integer edad;

	public Persona(String nombre, char sexo, Integer edad) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public boolean ausente(boolean ausente) {
		// TODO Auto-generated method stub
		return ausente;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + "]";
	}

}
