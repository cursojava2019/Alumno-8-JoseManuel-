package es.indra.controler;

import java.io.Serializable;
import java.util.TreeMap;

import es.indra.model.Cliente;
import es.indra.model.Cuenta;
import es.indra.model.CuentaCorriente;
import es.indra.model.CuentaVivienda;
import es.indra.model.FondoInversion;

public class OperacionesCuenta implements Serializable {
	private TreeMap<String, Cliente> clientes;
	private TreeMap<Long, CuentaCorriente> cuentasCorriente;
		
	public OperacionesCuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperacionesCuenta(TreeMap<Long, CuentaCorriente> cc) {
		super();
		this.cuentasCorriente=cc;
	}

	/*
	 * Funciones cliente -aniadir cliente -consultar info cliente
	 * 
	 */
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
	 * Funciones ingresar dinero, sacar dinero, consultar saldo, efectuar una
	 * revisión mensual.
	 */

}
