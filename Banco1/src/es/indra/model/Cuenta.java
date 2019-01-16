package es.indra.model;

public abstract class Cuenta {

	private Long codigo, saldo;
	private Double comision;
	private String tipo;
	private Cliente cliente;

	public Cuenta() {
		super();
		this.comision = new Double("0.6");
		this.cliente = new Cliente();
	}

	public Cuenta(Long codigo, Long saldo, Double comision, String tipo, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.comision = comision;
		this.tipo = tipo;
		this.cliente = cliente;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

	public Double getComision() {
		return comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cuentas [saldo=" + saldo + ", codigo=" + codigo + ", comision=" + comision + ", tipo=" + tipo
				+ ", cliente=" + cliente + "]";
	}

}
