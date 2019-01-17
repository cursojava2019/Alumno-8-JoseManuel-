package es.indra.model;

public class CuentaCorriente extends Cuenta {
	private static final Float INTERESCC = new Float("0.1");

	public CuentaCorriente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaCorriente(Long codigo, Long saldo, Double comision, String tipo, Cliente cliente) {
		super(codigo, saldo, comision, tipo, cliente);
	}

	public static Float getInterescc() {
		return INTERESCC;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [Cuenta:" + super.toString() + "]";
	}

}
