package es.indra.controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

import es.indra.model.Clientes;
import es.indra.model.Cuentas;

public class operacionesCuenta implements Serializable{
	private TreeMap<String, Clientes> clientes;

	public operacionesCuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public operacionesCuenta(TreeMap<String, Clientes> clientes) {
		super();
		this.clientes = clientes;
	}
/*
 * Funciones cliente
 * -aniadir cliente
 * -consultar info cliente
 
 */
	public Boolean aniadirCliente(Clientes c) {
		this.clientes.put(c.getNombre(), c);
		return true;
	}

	public Clientes obtenerCliente(String nombre) {
		return this.clientes.get(nombre);
	}
/*
 Funciones ingresar dinero, sacar dinero, consultar saldo, efectuar una revisión mensual. 
 */
	public Boolean ingresarDinero(String nombre,Long saldo) {
		Boolean b=false;
		if(this.clientes.get(nombre) != null) {
			Long saldoAnterior,saldoNuevo;
			Clientes cliente = this.clientes.get(nombre);
			ArrayList<Cuentas> cuenta = cliente.getCuentas();
			saldoAnterior = cuenta.get(0).getSaldo();
			saldoNuevo = saldoAnterior+saldo;
			cuenta.get(0).setSaldo(saldoNuevo);
			cliente.setCuentas(cuenta);
			this.clientes.put(nombre, cliente);
		}	
		return b;
	}
}
