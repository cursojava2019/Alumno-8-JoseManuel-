
package es.indra.ejercicio2;

public class Persona {
	protected static char HOMBRE = 'H', MUJER = 'M';
	protected char sexo;
	protected String nombre, dni;
	protected int edad;
	protected Double peso, altura;

	public Persona(char sexo, String nombre, int edad, double peso, double altura) {
		super();
		this.sexo = comprobarSexo(sexo);
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		this.dni = generaDNI();

	}

	public Persona() {
		super();
		this.sexo = comprobarSexo(sexo);
		this.nombre = "sin nombre";
		this.edad = 0;
		this.peso = Double.valueOf(0);
		this.altura = Double.valueOf(0);
	}

	public Persona(char sexo, String nombre, int edad) {
		super();
		this.sexo = sexo;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = Double.valueOf(0);
		this.altura = Double.valueOf(0);
	}

	public int calcularIMC(double peso, double altura) {
		int indice = 2;
		if (peso / (altura * altura) < 20) {
			indice = -1;
		} else if (peso / (altura * altura) >= 20 && peso / (altura * altura) <= 25) {
			indice = 0;
		} else if (peso / (altura * altura) > 25) {
			indice = 1;
		}
		return indice;
	}

	public boolean esMayorEdad(int edad) {
		boolean mayor = false;
		if (edad >= 18) {
			mayor = true;
		} else {
			mayor = false;
		}
		return mayor;
	}

	protected char comprobarSexo(char sexo) {
		char letra;
		if (sexo == HOMBRE || sexo == MUJER) {
			letra = sexo;
		} else {

			letra = HOMBRE;
		}
		return letra;
	}

	protected String generaDNI() {
		String dni = "", letraDni = "", letras = "abcdehijkflqmnsoprvwxyz";
		char letra;
		int numero = 0;
		for (int i = 0; i < 8; i++) {
			numero = (int) (Math.random() * 8) + 1;
			dni += Integer.toString(numero);
		}

		letra = letras.charAt((int) (Math.random() * 23) + 1);
		letraDni = Character.toString(letra);
		dni += letraDni;
		return dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = comprobarSexo(sexo);
	}

	@Override
	public String toString() {
		return "Persona [sexo=" + sexo + ", nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}

}
