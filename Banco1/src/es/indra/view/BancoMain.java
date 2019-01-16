package es.indra.view;

import java.util.ArrayList;
import java.util.Collection;

import es.indra.model.Clientes;
import es.indra.model.Cuentas;

public class BancoMain {

	public static void main(String[] args) {
		Clientes c1 = new Clientes("655345345h", "Jose", "molino", "cisne", "616232323");
		System.out.println(c1.toString());
		Cuentas cuenta = new Cuentas();
		Cuentas cuenta2 = new Cuentas();
		ArrayList<Cuentas> cuentas = new ArrayList<Cuentas>();
		cuentas.add(cuenta);
		c1.setCuentas(cuentas);
		System.out.println(c1.toString());
		cuenta.setComision(0.50);
		cuenta.setSaldo(new Long("1000"));
		cuenta.setTipo("corriente");
		c1.setCuentas(cuentas);
		System.out.println(c1.toString());
		cuenta2.setComision(0.10);
		cuenta2.setSaldo(new Long("10"));
		cuenta2.setTipo("vivienda");
		cuentas.add(cuenta2);
		c1.setCuentas(cuentas);
		System.out.println(c1.toString());
	}

}
