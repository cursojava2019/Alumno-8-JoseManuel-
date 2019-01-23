package es.indra.controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Cliente;
import es.indra.model.entities.Cuenta;
import es.indra.model.service.ClienteService;
import es.indra.model.service.CuentaService;

public class OperacionesCuenta implements Serializable {
	private ClienteService clienteService;
	private CuentaService cuentaService;
	private List<Cuenta> cuentas;

	public OperacionesCuenta() {
		super();

		this.cuentas = new ArrayList<Cuenta>();
		this.clienteService = new ClienteService();
		this.cuentaService = new CuentaService();
	}

	/*
	 * Validacion del tipo de cuenta. Tiene que ser o corriente, Cuenta Vivienda o
	 * Fondo de Inversion
	 */

	public String valideTipo(String s) {
		s = s.toLowerCase();
		if (s.equals("corriente") || s.equals("vivienda") || s.equals("inversion")) {
			return s;
		} else {
			return null;
		}
	}
	/*
	 * Funcion para saber si el cliente esta o no esta registrado
	 */

	public Boolean existeCliente(String dni) {
		Boolean existe = false;
		if (this.clienteService.find(dni) != null) {
			System.out.println("Bienvenido " + this.clienteService.find(dni).getNombre());
			existe = true;
		} else {
			System.out.println("El cliente no existe.Por favor registrese en la opcion 1 del menu principal.");
			existe = false;
		}
		;
		return existe;

	}
	/*
	 *Funcion para  añadir un cliente a la BBDD 
	 */	
	public void aniadirCliente(Cliente cl) {
		this.clienteService.create(cl);

	/*
	 *Funcion para borrar una cuenta 
	 */	
	};
	public void borrarCuenta(Long codigo) {
		this.cuentaService.delete(codigo);

	};
	
	/*
	 * Funcion para crear la Cuenta 
	 */
	public Boolean aniadirCuentaEspecifica(Cuenta c) {

		Boolean correcto = false;
		this.cuentaService.create(c);
		correcto = true;

		return correcto;
	}

	/*
	 * Funcion que devuelve la cuenta que coincida con el dni y el codigo entregado
	 */
	public Cuenta obtenerCuenta(String dni, Long codigo) {
		Cuenta c = null;

		if (this.cuentaService.find(codigo) != null && this.cuentaService.find(codigo).getDniCliente().equals(dni)) {
			c = this.cuentaService.find(codigo);

		}
		return c;
	};

	/*
	 * Funcion para meter o  sacar dinero
	 */

	public void sacarDinero(Cuenta c, Long cantidad) {

		c = this.cuentaService.restarSaldoService(c, cantidad);
		if (c != null) {
			this.cuentaService.update(c);
			this.cuentaService.bloquear(c);
		}

	}

	public void ingresarDinero(Cuenta c, Long cantidad) {

		c = this.cuentaService.sumarSaldoService(c, cantidad);
			if (c != null) {
				this.cuentaService.update(c);
			} else {
				System.out.println("Ha habido algun error al ingresar el dinero");
			}

	}

	

	/*
	 * Funcion que fuerza la revision mensual de todas las cuentas. Donde al saldo
	 * se le aplica la siguiente formula: saldo=saldo*interes_cuenta-comision.
	 */
	public void revisionMensualCuentas() {
		this.cuentas = this.cuentaService.findAll();
		this.cuentaService.revisionMensualCuentas(cuentas);
		if (cuentas != null) {
			for (int i = 0; i < cuentas.size(); i++) {
				Cuenta cuenta = new Cuenta();
				cuenta = cuentas.get(i);
				this.cuentaService.update(cuenta);
			}
		}
	}

}
