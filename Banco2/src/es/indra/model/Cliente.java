package es.indra.model;

import java.io.Serializable;

public class Cliente implements Serializable {
	private String dni, nombre, apellidos, direccion, tlf;

	public Cliente() {
		super();
	}

	public Cliente(String dni, String nombre, String apellidos, String direccion, String tlf) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.tlf = tlf;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	@Override
	public String toString() {
		return "Cliente: \n -Dni=" + dni + "\n -Nombre=" + nombre + "\n -Apellidos=" + apellidos + "\n -Direccion="
				+ direccion + "\n -Tlf=" + tlf + " .";
	}

}
