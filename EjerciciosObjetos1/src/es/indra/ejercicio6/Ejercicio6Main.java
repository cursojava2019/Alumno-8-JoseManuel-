package es.indra.ejercicio6;

public class Ejercicio6Main {

	public static void main(String[] args) {
		Libro libro1 = new Libro("DRA-BRAM-120","Dracula","Bram Stocker",400);
		Libro libro2 = new Libro("POTTER-ROWLING-200","Harry potter 4","J.K.Rowling",1100);
		System.out.println(libro2);
		System.out.println(libro1);
		if(libro1.getNumPag()>libro2.getNumPag()) {
				System.out.println("El libro "+libro1.getTitulo()+" de "+libro1.getAutor()+" tiene mas paginas que el "
					+"libro "+libro2.getTitulo()+" de "+libro2.getAutor()+". Con "+(libro1.getNumPag()-libro2.getNumPag())+" paginas mas");
		}else if(libro2.getNumPag()> libro1.getNumPag()) {
			System.out.println("El libro "+libro2.getTitulo()+" de "+libro2.getAutor()+" tiene mas paginas que el "
					+"libro "+libro1.getTitulo()+" de "+libro1.getAutor()+". Con "+(libro2.getNumPag()-libro1.getNumPag())+" paginas mas");
		
		}else {
			System.out.println("Los libros "+libro1.getTitulo()+" de "+libro1.getAutor()+" y "+libro2.getTitulo()+" de "+libro2.getAutor()+". Tienen el mismo numero de paginas. Con "+libro1.getNumPag()+" paginas cada uno");
		}
	}

}
