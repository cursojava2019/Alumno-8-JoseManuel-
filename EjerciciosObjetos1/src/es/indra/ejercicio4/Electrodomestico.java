package es.indra.ejercicio4;

public class Electrodomestico {

	static final Color COLOR_BASE = Color.BLANCO;
	static final Float PRECIO_DEFECTO = Float.valueOf(100);
	static final Float PESO_DEFECTO = Float.valueOf(5);
	static final Character CLASIFICACION_DEFECTO = 'F';

	protected Float precioBase;
	protected Color color;
	protected Character clasificacion;
	protected Float peso;

	public Electrodomestico() {
		super();
		this.precioBase = PRECIO_DEFECTO;
		this.color = COLOR_BASE;
		this.clasificacion = CLASIFICACION_DEFECTO;
		this.peso = PESO_DEFECTO;
	}

	public Electrodomestico(Float precioBase, Float peso) {
		this();
		this.precioBase = precioBase;
		this.peso = peso;
	}

	public Electrodomestico(Float precioBase, String color, Character clasificacion, Float peso) {
		super();
		this.precioBase = precioBase;
		comprobarColor(color);
		comprobarConsumoEnergetico(clasificacion);
		this.peso = peso;
	}

	public Float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Float precioBase) {
		this.precioBase = precioBase;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(String color) {
		comprobarColor(color);
	}

	public Character getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Character clasificacion) {
		comprobarConsumoEnergetico(clasificacion);
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	private void comprobarConsumoEnergetico(char clasificacion) {
		if (clasificacion == 'A' || clasificacion == 'B' || clasificacion == 'C' || clasificacion == 'D'
				|| clasificacion == 'E' || clasificacion == 'F') {

			this.clasificacion = clasificacion;
		} else {
			this.clasificacion = CLASIFICACION_DEFECTO;
		}
	}

	private void comprobarColor(String color2) {
		if (color2.equalsIgnoreCase(color.ROJO.toString()) || color2.equalsIgnoreCase(color.GRIS.toString())
				|| color2.equalsIgnoreCase(color.NEGRO.toString())
				|| color2.equalsIgnoreCase(color.BLANCO.toString())) {
			this.color = color.valueOf(color2);
		} else {
			this.color = COLOR_BASE;
		}
	}

	public Float precioFinal() {
		Float precioFinal = Float.valueOf(0);
		switch (this.clasificacion) {
		case 'A':
			precioFinal += 80;
			break;
		case 'B':
			precioFinal += 60;
			break;

		case 'C':
			precioFinal += 60;
			break;

		case 'D':
			precioFinal += 50;
			break;

		case 'E':
			precioFinal += 30;
			break;
		case 'F':
			precioFinal += 20;
			break;

		default:
			precioFinal += 20;
			break;
		}
		if (peso <= 19) {
			precioFinal += 10;
		} else if (peso > 19 && peso <= 49) {
			precioFinal += 50;
		} else if (peso > 49 && peso <= 79) {
			precioFinal += 80;
		} else {
			precioFinal += 100;
		}
		return precioFinal;
	}

}
