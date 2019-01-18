package es.indra.controler;

import java.io.Serializable;
import java.util.TreeMap;

import es.indra.model.Cliente;
import es.indra.model.Cuenta;
import es.indra.model.CuentaCorriente;
import es.indra.model.CuentaVivienda;

public class OperacionesCuenta implements Serializable {
	private TreeMap<String, Cliente> clientes;
	private TreeMap<Long, CuentaCorriente> cuentasCorriente;
	private TreeMap<Long, CuentaVivienda> cuentasVivienda;

	public OperacionesCuenta() {
		super();
		this.cuentasCorriente = new TreeMap<Long, CuentaCorriente>();
		this.cuentasVivienda = new TreeMap<Long, CuentaVivienda>();
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
			return null;
		}
	}

	/*
	 * Funcion para añadir Cuenta
	 * 
	 * String tipo = c.getTipo(); if (tipo.equals("corriente")) { CuentaCorriente c2
	 * = new CuentaCorriente(c.getCodigo(), c.getSaldo(), c.getComision(),
	 * c.getTipo(), c.getCliente()); if (operaciones.aniadirCC(c2)) {
	 * 
	 * System.out.println("Cuenta creada correctamente."); } else {
	 * System.out.println("Algo ha fallado.La cuenta no se ha creado."); } } else if
	 * (tipo.equals("vivienda")) { CuentaVivienda cv2 = new
	 * CuentaVivienda(c.getCodigo(), c.getSaldo(), c.getComision(), c.getTipo(),
	 * c.getCliente()); if (operaciones.aniadirCV(cv2)) {
	 * System.out.println("Cuenta creada correctamente."); } else {
	 * System.out.println("Algo ha fallado.La cuenta no se ha creado."); }
	 * 
	 * } else if (tipo.equals("inversion")) { FondoInversion fi2 = new
	 * FondoInversion(c.getCodigo(), c.getSaldo(), c.getComision(), c.getTipo(),
	 * c.getCliente()); if (operaciones.aniadirFI(fi2)) {
	 * System.out.println("Cuenta creada correctamente."); } else {
	 * System.out.println("Algo ha fallado.La cuenta no se ha creado."); } }
	 *
	 * public Boolean aniadirCC(CuentaCorriente c2) {
	 * this.cuentasCorriente.put(c2.getCodigo(), c2);
	 * System.out.println(this.cuentasCorriente.toString()); return true; };
	 * 
	 * // aniadirCV public Boolean aniadirCV(CuentaCorriente c2) {
	 * this.cuentasVivienda.put(c2.getCodigo(), c2);
	 * System.out.println(this.cuentasVivienda.toString()); return true; };
	 *
	 *
	 * 
	 */
	public Boolean aniadirCuentaEspecifica(Cuenta c) {

		return true;
	};

	/*
	 * Funcion para Obtener cuenta especifica
	 */
	public CuentaCorriente obtenerCuenta(Long codigo) {

		return this.cuentasCorriente.get(codigo);
	};

	/*
	 * Funcion que actualizar la cuenta si se ha modificado algo
	 */
	public Boolean actualizarCuenta(Long codigo, CuentaCorriente cc) {
		this.cuentasCorriente.replace(codigo, cc);
		return true;
	};

	/*
	 * Funcion para visualizar el estado de la cuenta
	 */
	public static void visualizarCuenta(CuentaCorriente cc) {
		System.out.println(cc.toString());
	};
	/*
	 * Funciones ingresar dinero, sacar dinero, consultar saldo, efectuar una
	 * revisión mensual.
	 */

}
