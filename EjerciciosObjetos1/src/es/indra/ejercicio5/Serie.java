package es.indra.ejercicio5;

public class Serie implements Entregable {

	protected String titulo, creador, genero;
	protected Integer nTemporadas;
	protected Boolean entregado = new Boolean(false);

	public Serie(String titulo, String creador, String genero, Integer nTemporadas) {
		super();
		this.titulo = titulo;
		this.creador = creador;
		this.genero = genero;
		this.nTemporadas = nTemporadas;
	}

	public Serie(String titulo, String creador) {
		super();
		this.titulo = titulo;
		this.creador = creador;
		this.genero = "Sin genero";
		this.nTemporadas = new Integer(3);
		this.entregado = new Boolean(false);
	}

	public Serie() {
		super();
		this.titulo = "Sin titulo";
		this.creador = "Sin creador";
		this.genero = "Sin genero";
		this.nTemporadas = new Integer(3);
		this.entregado = new Boolean(false);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getnTemporadas() {
		return nTemporadas;
	}

	public void setnTemporadas(Integer nTemporadas) {
		this.nTemporadas = nTemporadas;
	}

	@Override
	public void entregar() {
		this.entregado = Boolean.valueOf(true);
	}

	@Override
	public void devolver() {
		this.entregado = Boolean.valueOf(true);
	}

	@Override
	public boolean isEntregado() {

		return this.entregado;
	}

	@Override
	public Integer compararObject(Object a) {
		int num = 2;
		if (a instanceof Serie) {
			Serie aux = (Serie) a;
			Integer numTemp = aux.getnTemporadas();
			if (this.nTemporadas == numTemp) {
				num = 0;
			} else if (this.nTemporadas < numTemp) {
				num = 1;
			} else {
				num = -1;
			}

		} else {
			System.out.println("No es una serie");
		}
		return num;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", creador=" + creador + ", genero=" + genero + ", nTemporadas="
				+ nTemporadas + ", entregado=" + entregado + "]";
	}

}
