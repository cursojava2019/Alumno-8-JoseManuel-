package es.indra.model;

import java.io.Serializable;

public class CuentaVivienda extends Cuenta implements Serializable{
	private static final Float INTERESCV = new Float("0.2");

	public CuentaVivienda() {
		super();
	}

	public CuentaVivienda(Long codigo, Long saldo, Double comision, String tipo, Cliente cliente,Boolean bloqueada) {
		super(codigo, saldo, comision, tipo, cliente,bloqueada);
	}

	public static Float getInterescv() {
		return INTERESCV;
	}

	@Override
	public String toString() {
		return "CuentaVivienda [" + super.toString() + "]";
	}

}
