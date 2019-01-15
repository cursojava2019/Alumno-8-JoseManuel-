package es.indra.model;

public class Venta {

	private Vehiculo vehiculo;
	private Comprador comprador;
	private Double precioVenta;

	public Venta() {
		super();
	}

	public Venta(Vehiculo vehiculo, Comprador comprador, Double precioVenta) {
		super();
		this.vehiculo = vehiculo;
		this.comprador = comprador;
		this.precioVenta = precioVenta;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

}
