package es.indra.ejercicio8;

import java.util.Scanner;

public class Estudiantes extends Persona {
	protected Float calificacion;
	Scanner entrada = new Scanner(System.in);
	public Estudiantes(String nombre, char sexo, Integer edad, Float calificacion) {
		super(nombre, sexo);
		this.edad=edad(edad);
		this.calificacion = calificacion(calificacion);
	}

	public Float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Float calificacion) {
		this.calificacion = calificacion(calificacion);
	}
	public void setEdad(Integer edad) {
		this.edad = edad(edad);
	}

	public Integer edad(Integer edad) {
		boolean correcto=false;
		do {
			if(edad>=12 || edad<=21) {
				correcto=true;
			}else {
				System.out.println("La edad no es correcta ");
				edad= entrada.nextInt();
			}
		}while(correcto !=false);
	
		return edad;
	}
	public Float calificacion(Float calificacion) {
		boolean correcto=false;
		System.out.println("Introduzca la calificacion: ");
		do {
			calificacion= entrada.nextFloat();
			if(calificacion>0 || calificacion<=10) {
				correcto=true;
			}else {
				System.out.println("La calificacion no es correcta.Introduzca la calificacion correcta ");
			}
		}while(correcto !=false);
	
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
		return super.toString() + " Calificacion: " + this.calificacion;
	}

}
