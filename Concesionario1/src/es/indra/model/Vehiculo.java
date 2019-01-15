package es.indra.model;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	public static String COCHE = "coche";
	public static String MOTO = "moto";
	public static String CAMION = "camion";

	private Long codigo;
	private String marca, tipo;
	private Integer anio, kilometraje;
	private Boolean vendido;

	public Vehiculo() {
		super();
	}

	public Vehiculo(Long codigo, String marca, String tipo, Integer anio, Integer kilometraje, Boolean vendido) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.tipo = tipo;
		this.anio = anio;
		this.kilometraje = kilometraje;
		this.vendido = vendido;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = valideTipo(tipo);
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(Integer kilometraje) {
		this.kilometraje = kilometraje;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

	private String valideTipo(String s) {
		if (s.equals(CAMION) || s.equals(COCHE) || s.equals(MOTO)) {
			return s;
		} else {
			return COCHE;
		}
	}

	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", marca=" + marca + ", tipo=" + tipo + ", anio=" + anio
				+ ", kilometraje=" + kilometraje + ", vendido=" + vendido + "]";
	}

}
