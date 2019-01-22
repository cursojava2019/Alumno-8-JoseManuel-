package es.indra.model.entities;

public class Cuenta {

	private Long codigo, saldo;
	private Double comision;
	private String tipo;
	private String dniCliente;
	private Boolean bloqueada;

	public Cuenta() {
		super();
		this.comision = new Double("0.6");
		this.bloqueada = false;
	}

	public Cuenta(Long codigo, Long saldo, Double comision, String tipo, String dniCliente, Boolean bloqueada) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.comision = comision;
		this.tipo = tipo;
		this.dniCliente = dniCliente;
		this.bloqueada = bloqueada;
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

	public Boolean getBloqueada() {
		return bloqueada;
	}

	public void setBloqueada(Boolean bloqueada) {
		this.bloqueada = bloqueada;
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

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	@Override
	public String toString() {
		return "Cuenta [codigo=" + codigo + ", saldo=" + saldo + ", comision=" + comision + ", tipo=" + tipo
				+ ", dniCliente=" + dniCliente + ", bloqueada=" + bloqueada + "]";
	}

}
