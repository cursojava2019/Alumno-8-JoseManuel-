package es.indra.ejercicio8;

public class Aula {
	Integer identificador, nMaxEstudiantes;
	String materiaAula;

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Integer getnMaxEstudiantes() {
		return nMaxEstudiantes;
	}

	public void setnMaxEstudiantes(Integer nMaxEstudiantes) {
		this.nMaxEstudiantes = nMaxEstudiantes;
	}

	public String getMateriaAula() {
		return materiaAula;
	}

	public void setMateriaAula(String materiaAula) {
		this.materiaAula = materiaAula;
	}

	public Aula(Integer identificador, Integer nMaxEstudiantes, String materiaAula) {
		super();
		this.identificador = identificador;
		this.nMaxEstudiantes = nMaxEstudiantes;
		this.materiaAula = materiaAula;
	}

}
