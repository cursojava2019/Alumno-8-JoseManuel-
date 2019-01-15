package es.indra.model;

import java.util.ArrayList;

public class Comprador {
	private String dni, nombre, apellidos, tlf, direccion, cp;
	private ArrayList<Vehiculo> propiedades = new ArrayList<Vehiculo>();

	public Comprador() {
		super();
	}

	public Comprador(String dni, String nombre, String apellidos, String tlf, String direccion, String cp) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tlf = tlf;
		this.direccion = direccion;
		this.cp = cp;
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

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public ArrayList<Vehiculo> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(ArrayList<Vehiculo> propiedades) {
		this.propiedades = propiedades;
	}

}
