package es.indra.ejercicio8;

import java.util.Scanner;

public class Profesosr extends Persona {

	protected String materia;
	Scanner entrada = new Scanner(System.in);
	public Profesosr(String nombre, char sexo, Integer edad, String materia) {
		super(nombre, sexo);
		this.edad= edad(edad);
		this.materia = materia(materia);
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	public void setEdad(Integer edad) {
		this.edad = edad(edad);
	}
	public String materia(String materia) {
		boolean correcto=false;
		
		do {
			materia=materia.toLowerCase();
			if(materia == "matematicas" || materia == "filosofia" || materia == "fisica") {
				correcto=true;
			}else {
				System.out.println("Introduzca la materia (Debe ser: matematicas,filosofia o fisica) ");
				materia= entrada.nextLine();
			}	
				
		}while(correcto != false);
		return materia;
	}
	public Integer edad(Integer edad) {
		boolean correcto=false;
		do {
			if(edad>=18 || edad<=70) {
				correcto=true;
			}else {
				System.out.println("La edad no es correcta ");
				edad= entrada.nextInt();
			}
		}while(correcto !=false);
	
		return edad;
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

		return super.toString() + " materia: " + this.materia;
	}

}
