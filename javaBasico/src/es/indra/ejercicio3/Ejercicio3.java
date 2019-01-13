/*
 * Ejercicio 3.Crea un programa básico en java que pida un día de la semana en texto
 * y que nos diga si es un dia laboral o no. Usa un switch para ello.
 * */

package es.indra.ejercicio3;
import java.util.Scanner;

public class Ejercicio3 {

	static int diaSemNum(String dia) {
    	int numDia=0;
    	System.out.println(dia);
    	if("lunes".equals(dia)) {
    		return numDia=1;
    	}else if("martes".equals(dia)) {
    		return numDia=2;
    	}else if("miercoles".equals(dia)) {
    		return numDia=3;
    	}else if("jueves".equals(dia)) {
    		return numDia=4;
    	}else if("viernes".equals(dia)) {
    		return numDia=5;
    	}else if("sabado".equals(dia)) {
    		return numDia=6;
    	}else if("domingo".equals(dia)) {
    		return numDia=7;
    	}else {
    		return numDia=0;
    	}
 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner (System.in);
		String dia = "";
		System.out.println("Introduzca un dia de la semana en texto: ");
		dia=entrada.next();
		dia=dia.toLowerCase();
		
		switch (diaSemNum(dia)) {
		case 1:
			System.out.println("El dia seleccionado es: "+dia+" y es laborable.");
			break;
		case 2:
			System.out.println("El dia seleccionado es: "+dia+" y es laborable.");
			break;
		case 3:
			System.out.println("El dia seleccionado es: "+dia+" y es laborable.");
			break;
		case 4:
			System.out.println("El dia seleccionado es: "+dia+" y es laborable.");
			break;
		case 5:
			System.out.println("El dia seleccionado es: "+dia+" y es laborable.");
			break;
		case 6:
			System.out.println("El dia seleccionado es: "+dia+" y es laborable solo por las mañanas.");
			break;
		case 7:
			System.out.println("El dia seleccionado es: "+dia+" y no es laborable.");
			break;	
		case 0:
			System.out.println("El dia no es correcto.");
			break;
		default:
			System.out.println("No has puesto ningun dia");
			break;
		}
		
	}

}
