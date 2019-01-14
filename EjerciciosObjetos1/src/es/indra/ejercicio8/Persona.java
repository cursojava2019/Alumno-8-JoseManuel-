package es.indra.ejercicio8;

import java.util.Scanner;

public abstract class Persona {
	Scanner entrada = new Scanner(System.in);
	String nombre;
	char sexo;
	Integer edad;

	public Persona(String nombre, char sexo) {
		super();
		this.nombre = nombre(nombre);
		this.sexo = sexo(sexo);
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre(nombre);
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo(sexo);
	}

	public Integer getEdad() {
		return edad;
	}

	public String nombre(String nombre) {
		System.out.println("Introduzca el nombre: ");
		nombre= entrada.nextLine();
		return nombre;
	}
	public Character sexo(char sexo) {
		boolean correcto=false;
		System.out.println("Introduzca el sexo: ");
		do {
			sexo=entrada.next().charAt(0);
			sexo=Character.toLowerCase(sexo);
			if(sexo=='h' || sexo=='m') {
				correcto=true;
			}else {
				System.out.println("El sexo no es correcto. Debe se H o M. Introduzca el sexo: ");
			}
			
		}while(correcto !=false);
		
		return sexo;
	}

	public boolean ausente() {
		boolean ausente=false;
		return ausente;
	}
	public Integer edad(Integer edad) {
		return edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + "]";
	}

}
