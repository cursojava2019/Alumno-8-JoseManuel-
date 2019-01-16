package es.indra.controler;

import java.io.Serializable;
import java.util.TreeMap;

import es.indra.model.Cliente;
import es.indra.model.Cuenta;
import es.indra.model.CuentaCorriente;
import es.indra.model.CuentaVivienda;
import es.indra.model.FondoInversion;

public class OperacionesCuenta implements Serializable {
	private TreeMap<String, Cliente> cliente;
	private TreeMap<Long, Cuenta> cuenta;

	public OperacionesCuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperacionesCuenta(TreeMap<String, Cliente> cliente, TreeMap<Long, Cuenta> cuenta) {
		super();
		this.cliente = cliente;
		this.cuenta = cuenta;
	}

	/*
	 * Funciones cliente -aniadir cliente -consultar info cliente
	 * 
	 */
	public Boolean aniadirCliente(Cliente c) {
		this.cliente.put(c.getNombre(), c);
		return true;
	}

	public Cliente obtenerCliente(String nombre) {
		return this.cliente.get(nombre);
	}
	/*
	 * Validacion del tipo de cuenta. Tiene que ser o corriente, Cuenta Vivienda o
	 * Fondo de Inversion
	 */

	public String valideTipo(String s) {
		s = s.toLowerCase();
		if (s.equals("corriente") || s.equals("vivienda") || s.equals("inversion")) {
			return s;
		} else {
			return "corriente";
		}
	}

	/*
	 * Funcion crear cuenta
	 */
	public void crearCuenta(Cuenta c) {
		if (c.getTipo().equals("corriente")) {
			CuentaCorriente cc = new CuentaCorriente(c);
		} else if (c.getTipo().equals("vivienda")) {
			CuentaVivienda cv = new CuentaVivienda(c);
		} else if (c.getTipo().equals("inversion")) {
			FondoInversion fi = new FondoInversion(c);
		}
	}

	/*
	 * Funciones ingresar dinero, sacar dinero, consultar saldo, efectuar una
	 * revisión mensual.
	 */

}
