package es.indra.model;

public class FondoInversion extends Cuenta {
	private static final Float INTERESFI = new Float("0.34");

	public FondoInversion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FondoInversion(Long codigo, Long saldo, Double comision, String tipo, Cliente cliente) {
		super(codigo, saldo, comision, tipo, cliente);
		// TODO Auto-generated constructor stub
	}

	public static Float getInteresfi() {
		return INTERESFI;
	}

	@Override
	public String toString() {
		return "FondoInversion [Cuenta:" + super.toString() + "]";
	}

}
