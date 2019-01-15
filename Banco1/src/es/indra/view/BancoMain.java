package es.indra.view;

import es.indra.model.Clientes;

public class BancoMain {

	public static void main(String[] args) {
		Clientes c1 = new Clientes("655345345h", "Jose", "molino", "cisne", "616232323");
		System.out.println(c1.toString());

	}

}
