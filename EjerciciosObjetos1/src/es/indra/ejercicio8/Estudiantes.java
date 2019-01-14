package es.indra.ejercicio8;

import java.util.Scanner;

public class Estudiantes extends Persona {
	protected Float calificacion;
	protected String profesion="Estudiante";
	Scanner entrada = new Scanner(System.in);
	public Estudiantes() {
		super();
		this.edad=edad();
		this.calificacion = calificacion();
	}

	public Float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion() {
		this.calificacion = calificacion();
	}
	public void setEdad() {
		this.edad = edad();
	}

	public Integer edad() {
		Integer edad = new Integer(0);
		boolean correcto=false;
		System.out.println("Introduce la edad: ");
		do {
			edad= entrada.nextInt();
			entrada.nextLine();
			if(edad>=12 && edad<=21) {
				correcto=true;
			}else {
				System.out.println("La edad no es correcta.Introducela de nuevo: ");

			}
		}while(correcto == false);
	
		return edad;
	}
	public Float calificacion() {
		Float calificacion = new Float(0);
		boolean correcto=false;
		System.out.println("Introduzca la calificacion: ");
		do {
			calificacion= entrada.nextFloat();
			entrada.nextLine();
			if(calificacion>0 && calificacion<=10) {
				correcto=true;
			}else {
				System.out.println("La calificacion no es correcta.Introduzca la calificacion correcta ");
			}
		}while(correcto ==false);
	
		return calificacion;
	}
	
	@Override
	public boolean ausente() {
		boolean ausente=false;
		int num=0;
		num=(int) Math.ceil(Math.random()*2);
		if(num==1) {
			ausente=true;
		}
		return ausente;
	}

	@Override
	public String toString() {
		return super.toString() +" Edad: "+this.edad+ " Calificacion: " + this.calificacion+" Profesion: "+this.profesion+" Ausente: "+ausente();
	}

}
