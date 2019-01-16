package es.indra.model;

public class Cuentas {
	private static final Float INTERESCC = new Float("0.1");
	private static final Float INTERESCV = new Float("0.2");
	private static final Float INTERESFI = new Float("0.34");
	private Double comision;
	private Long saldo;
	private String tipo;
	public Cuentas() {
		super();
		this.comision = new Double("0.6");
	}
	public Cuentas(Double comision, Long saldo, String tipo) {
		super();
		this.comision = comision;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	public Double getComision() {
		return comision;
	}
	public void setComision(Double comision) {
		this.comision = comision;
	}
	public Long getSaldo() {
		return saldo;
	}
	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = valideTipo(tipo);
	}
	private String valideTipo(String s) {
		if (s.equals("corriente") || s.equals("vivienda") || s.equals("inversion")) {
			return s;
		} else {
			return "normal";
		}
	}
	@Override
	public String toString() {
		return "Cuentas [comision=" + comision + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}
	

}
