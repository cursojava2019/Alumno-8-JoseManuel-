package es.indra.ejercicio6;

public class Libro {
	protected String isbn, titulo, autor;
	protected Integer numPag = new Integer(0);
	
	public Libro(String isbn, String titulo, String autor, Integer numPag) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numPag = numPag;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getNumPag() {
		return numPag;
	}
	public void setNumPag(Integer numPag) {
		this.numPag = numPag;
	}
	@Override
	public String toString() {
		return "El libro con el isbn " + isbn + " creado por " + autor + " tiene " + numPag + " paginas";
	}
	
}
