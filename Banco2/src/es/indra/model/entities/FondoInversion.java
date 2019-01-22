package es.indra.model.entities;

import java.io.Serializable;

public class FondoInversion extends Cuenta implements Serializable {
	private static final Float INTERESFI = new Float("0.34");

	public FondoInversion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FondoInversion(Long codigo, Long saldo, Double comision, String tipo, String dniCliente, Boolean bloqueada) {
		super(codigo, saldo, comision, tipo, dniCliente, bloqueada);
		// TODO Auto-generated constructor stub
	}

	public static Float getInteresfi() {
		return INTERESFI;
	}

	@Override
	public String toString() {
		return "FondoInversion [" + super.toString() + "]";
	}

}