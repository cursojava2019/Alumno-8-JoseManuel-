package es.indra.ejercicio8;

import java.net.PortUnreachableException;

public class Aula {
	protected Integer idAula,numMax;
	protected String materia;
	protected boolean disponible;
	public Aula(Integer idAula, Integer numMax, String materia) {
		super();
		this.idAula = idAula;
		this.numMax = numMax;
		this.materia = materia;
		this.disponible=false;
		
	}
	
	public Integer getIdAula() {
		return idAula;
	}

	public void setIdAula(Integer idAula) {
		this.idAula = idAula;
	}

	public Integer getNumMax() {
		return numMax;
	}

	public void setNumMax(Integer numMax) {
		this.numMax = numMax;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean profesorDisponible,String materia,Integer contAlumnos) {
		this.disponible = disponible(profesorDisponible,materia,contAlumnos);
	}

	public boolean disponible(boolean profesorDisponible,String materia,Integer contAlumnos) {
		boolean disponible=false;
		Integer porceAlumnos = new Integer(0);
		porceAlumnos = (int)(this.numMax*contAlumnos)/100;
		if(profesorDisponible==true && materia.contentEquals(this.materia) && porceAlumnos>=50) {
			disponible=true;
		}else {
			System.out.println("El aula no esta disponible. Pueden ser las siguientes razones:");
			System.out.println("El profesor no puede dar clase en un aula designada para "+this.materia);
			System.out.println("El profesor no esta disponible. Disponibilidad del profesaor: "+profesorDisponible);
			System.out.println("La cantidad de alumnos es inferior al 50%. Porcentaje de alumnos:"+porceAlumnos);
		}
		return disponible;
	}
	
}
