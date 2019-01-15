package es.indra.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Concesionario {

	private TreeMap<String, Comprador> compradores;
	private TreeMap<Long, Vehiculo> vehiculos;
	private ArrayList<Venta> ventas;

	public Concesionario() {
		this.compradores = new TreeMap<String, Comprador>();
		this.vehiculos = new TreeMap<Long, Vehiculo>();
		this.ventas = new ArrayList<Venta>();
	}

	public Concesionario(TreeMap<String, Comprador> compradores, TreeMap<Long, Vehiculo> vehiculos,
			ArrayList<Venta> ventas) {
		super();
		this.compradores = compradores;
		this.vehiculos = vehiculos;
		this.ventas = ventas;
	}

	public TreeMap<String, Comprador> getCompradores() {
		return compradores;
	}

	public void setCompradores(TreeMap<String, Comprador> compradores) {
		this.compradores = compradores;
	}

	public TreeMap<Long, Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(TreeMap<Long, Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public Boolean aniadirComprador(Comprador c) {
		this.compradores.put(c.getDni(), c);
		return true;
	}

	public Boolean aniadirVehiculo(Vehiculo v) {
		this.vehiculos.put(v.getCodigo(), v);
		return true;
	}

	public List<Vehiculo> vehiculosDisponibles() {
		ArrayList<Vehiculo> listado = new ArrayList<Vehiculo>(vehiculos.values());
		LinkedList<Vehiculo> disponibles = new LinkedList<Vehiculo>();
		for (Vehiculo vehiculo : listado) {
			if (vehiculo.getVendido()) {
				disponibles.add(vehiculo);
			}
		}
		return disponibles;
	}

	public List<Vehiculo> vehiculosPropietario(String dni) {
		Comprador c = compradores.get(dni);
		if (c != null) {
			return c.getPropiedades();
		} else {
			return null;
		}

	}

	public Venta nuevaVenta(String dni, Long codigo, Double precio) {
		Comprador comprador = compradores.get(dni);
		Vehiculo vehiculo = this.vehiculos.get(codigo);
		if (comprador != null && vehiculo != null) {
			Venta v = new Venta();
			v.setComprador(comprador);
			v.setVehiculo(vehiculo);
			v.setPrecioVenta(precio);
			vehiculo.setVendido(true);
			comprador.getPropiedades().add(vehiculo);
			this.ventas.add(v);
			return v;
		} else {
			return null;
		}
	}

}
