package es.indra.ejercicio7;

public class Raices {
	double a, b, c = 0;

	public Raices(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public boolean tieneRaiz() {
		boolean tieneRaiz = false;
		if (getDiscriminante() == 0) {
			tieneRaiz = true;
		}
		return tieneRaiz;
	}

	public boolean tieneRaices() {
		boolean tieneRaices = false;
		if (getDiscriminante() > 0) {
			tieneRaices = true;
		}
		return tieneRaices;
	}

	public void obtenerRaices() {
		double solucion;
		solucion = (-b - Math.sqrt(getDiscriminante())) / (2 * a);
		System.out.println("La solucion 1 es: " + solucion);
		solucion = (-b + Math.sqrt(getDiscriminante())) / (2 * a);
		System.out.println("La solucion 2 es: " + solucion);

	}

	public void obtenerRaiz() {
		double solucion = 0;
		solucion = (-b) / (2 * a);
		System.out.println("La solucion es: " + solucion);
	}

	public double getDiscriminante() {
		double discriminante = 0;
		return discriminante = (this.b * this.b) - 4 * this.a * this.c;
	}

	public void calcular() {

		if (this.a != 0) {
			if (tieneRaices()) {
				obtenerRaices();
			} else if (tieneRaiz()) {
				obtenerRaiz();
			} else {
				System.out.println("La ecuacion no tiene solucion");
			}

		} else {
			System.out.println("A no puede ser 0");
		}

	}

	@Override
	public String toString() {
		return "Raices [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

}
