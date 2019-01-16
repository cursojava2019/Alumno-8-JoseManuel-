package es.indra.model;

public class CuentaVivienda extends Cuenta {
	private static final Float INTERESCV = new Float("0.2");

	public CuentaVivienda() {
		super();
	}

	public CuentaVivienda(Long codigo, Long saldo, Double comision, String tipo, Cliente cliente) {
		super(codigo, saldo, comision, tipo, cliente);
	}

	public static Float getInterescv() {
		return INTERESCV;
	}

	@Override
	public String toString() {
		return "CuentaVivienda [Cuenta:" + super.toString() + "]";
	}

}
