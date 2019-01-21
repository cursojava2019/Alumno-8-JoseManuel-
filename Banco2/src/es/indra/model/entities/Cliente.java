package es.indra.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
	private String dni, nombre, apellidos, direccion, tlf;
	private List<Cuenta> propiedades = new ArrayList<Cuenta>();

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

	public List<Cuenta> getPropiedades() {
		return this.propiedades;
	}

	public void setPropiedades(List<Cuenta> propiedades) {
		this.propiedades = propiedades;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", tlf=" + tlf + ", propiedades=" + propiedades + "]";
	}

}
