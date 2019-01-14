package es.indra.ejercicio8;

import java.util.Scanner;

public class Profesosr extends Persona {

	protected String materia,profesion="Profesor";
	Scanner entrada = new Scanner(System.in);
	public Profesosr() {
		super();
		this.edad= edad();
		this.materia = materia();
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria() {
		this.materia = materia();
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
			if(edad>=18 && edad<=70) {
				correcto=true;
			}else {
				System.out.println("La edad no es correcta.Introducela de nuevo: ");

			}
		}while(correcto == false);
	
		return edad;
	}
	public String materia() {
		String materia="";
		boolean correcto=false;
		
		System.out.println("Introduzca la materia: ");
		do {
			materia= entrada.nextLine();
			materia=materia.toLowerCase();
			if(materia.equals("matematicas") || materia.equals("filosofia") || materia.equals("fisica")) {
				correcto=true;
			}else {
				System.out.println("Introduzca la materia (Debe ser: matematicas,filosofia o fisica) ");
			}	
				
		}while(correcto == false);
		return materia;
	}
	
	@Override
	public boolean ausente() {
		boolean ausente=false;
		int num=0;
		num=(int) Math.ceil(Math.random()*10);
		if(num==1 || num==2) {
			ausente=true;
		}	
		return ausente;
	}

	@Override
	public String toString() {

		return super.toString() +" edad: "+this.edad+ " materia: " + this.materia+" Profesion: "+this.profesion+" Ausente: "+ausente();
	}

}
