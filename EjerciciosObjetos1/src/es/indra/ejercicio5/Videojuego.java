package es.indra.ejercicio5;

public class Videojuego implements Entregable {
	protected String titulo, compañia, genero;
	protected Float hEstimadas;
	protected Boolean entregado = new Boolean(false);

	public Videojuego(String titulo, String compañia, String genero, Float hEstimadas) {
		super();
		this.titulo = titulo;
		this.compañia = compañia;
		this.genero = genero;
		this.hEstimadas = hEstimadas;
	}

	public Videojuego(String titulo, Float hEstimadas) {
		super();
		this.titulo = titulo;
		this.compañia = "Sin compañia";
		this.genero = "sin genero";
		this.hEstimadas = hEstimadas;
		this.entregado = new Boolean(false);
	}

	public Videojuego() {
		super();
		this.titulo = "Sin titulo";
		this.compañia = "Sin compañia";
		this.genero = "Sin genero";
		this.hEstimadas = new Float(10);
		this.entregado = new Boolean(false);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Float gethEstimadas() {
		return hEstimadas;
	}

	public void sethEstimadas(Float hEstimadas) {
		this.hEstimadas = hEstimadas;
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
		if (a instanceof Videojuego) {
			Videojuego aux = (Videojuego) a;
			Float numHoras = aux.gethEstimadas();
			if (this.hEstimadas == numHoras) {
				num = 0;
			} else if (this.hEstimadas < numHoras) {
				num = 1;
			} else {
				num = -1;
			}

		} else {
			System.out.println("No es un Videojuego");
		}
		return num;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", compañia=" + compañia + ", genero=" + genero + ", hEstimadas="
				+ hEstimadas + ", entregado=" + entregado + "]";
	}

}
