package es.indra.model.entities;

import java.io.Serializable;

public class CuentaCorriente extends Cuenta implements Serializable{
	private static final Float INTERESCC = new Float("0.1");

	public CuentaCorriente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaCorriente(Long codigo, Long saldo, Double comision, String tipo, Cliente cliente, Boolean bloqueada) {
		super(codigo, saldo, comision, tipo, cliente,bloqueada);
	}

	public static Float getInterescc() {
		return INTERESCC;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [" + super.toString() + "]";
	}

}
