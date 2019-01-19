package es.indra.model;

public class Cuenta {

	private Long codigo, saldo;
	private Double comision;
	private String tipo;
	private Cliente cliente;
	private Boolean bloqueada;

	public Cuenta() {
		super();
		this.comision = new Double("0.6");
		this.cliente = new Cliente();
		this.bloqueada=false;
	}

	public Cuenta(Long codigo, Long saldo, Double comision, String tipo, Cliente cliente,Boolean bloqueada) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.comision = comision;
		this.tipo = tipo;
		this.cliente = cliente;
		this.bloqueada=false;
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
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	@Override
	public String toString() {
		return " Codigo=" + codigo +", saldo=" + saldo +", comision=" + comision + ", tipo=" + tipo
				+ "\n" + cliente + "]"+"\n";
	}

}
