package es.indra.controler;

import java.io.Serializable;
import java.util.TreeMap;

import com.sun.org.apache.regexp.internal.recompile;

import es.indra.model.Cliente;
import es.indra.model.Cuenta;
import es.indra.model.CuentaCorriente;
import es.indra.model.CuentaVivienda;
import es.indra.model.FondoInversion;

public class OperacionesCuenta implements Serializable {
	private TreeMap<String, Cliente> clientes;
	private TreeMap<Long, CuentaCorriente> cuentasCorriente;
	private TreeMap<Long, CuentaVivienda> cuentasVivienda;
	private TreeMap<Long, FondoInversion> cuentasInversion;

	public OperacionesCuenta() {
		super();
		this.clientes = new TreeMap<String, Cliente>();
		this.cuentasCorriente = new TreeMap<Long, CuentaCorriente>();
		this.cuentasVivienda = new TreeMap<Long, CuentaVivienda>();
		this.cuentasInversion = new TreeMap<Long, FondoInversion>();
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
	 * Funcion para saber si el cliente no esta registrado
	 */
	
	public Boolean existeCliente(String dni) {
		Boolean existe=false;
		if(this.clientes.get(dni) != null) {
			System.out.println("Bienvenido "+this.clientes.get(dni).getNombre());
			existe = true;
		}else{
			System.out.println("El cliente no existe.Por favor registrese en la opcion 1 del menu principal.");
			existe=false;
		};
		return existe;
		
	}
	/*
	 * Funcion para añadir crear Cuenta segun su tipo
	 */
	public Boolean aniadirCuentaEspecifica(Cuenta c) {
		String tipo = c.getTipo();
		if (tipo.equals("corriente")) {
			CuentaCorriente c2 = new CuentaCorriente(c.getCodigo(), c.getSaldo(), c.getComision(), c.getTipo(),
					c.getCliente(),c.getBloqueada());
			String dniCliente = c2.getCliente().getDni();
			this.clientes.put(dniCliente, c2.getCliente());
			this.cuentasCorriente.put(c2.getCodigo(), c2);
			System.out.println(this.cuentasCorriente.toString());
		} else if (tipo.equals("vivienda")) {
			CuentaVivienda cv2 = new CuentaVivienda(c.getCodigo(), c.getSaldo(), c.getComision(), c.getTipo(),
					c.getCliente(),c.getBloqueada());
			String dniCliente = cv2.getCliente().getDni();
			this.clientes.put(dniCliente, cv2.getCliente());
			this.cuentasVivienda.put(cv2.getCodigo(), cv2);
			System.out.println(this.cuentasVivienda.toString());
		} else if (tipo.equals("inversion")) {
			FondoInversion fi2 = new FondoInversion(c.getCodigo(), c.getSaldo(), c.getComision(), c.getTipo(),
					c.getCliente(),c.getBloqueada());
			String dniCliente = fi2.getCliente().getDni();
			this.clientes.put(dniCliente, fi2.getCliente());
			this.cuentasInversion.put(fi2.getCodigo(), fi2);
			System.out.println(this.cuentasInversion.toString());
		}
		return true;
	}

	/*
	 * Funcion para Obtener cuenta 
	 */
	public Object obtenerCuenta(String dni,Long codigo) {
		Object c = null;
		if(this.cuentasCorriente.get(codigo) != null) {
			String dniCliente=this.cuentasCorriente.get(codigo).getCliente().getDni();
			if(dni.equals(dniCliente)) {
				c= this.cuentasCorriente.get(codigo);
			}
			
		}else if(this.cuentasVivienda.get(codigo) != null) {
			c= this.cuentasVivienda.get(codigo);
		}else if(this.cuentasInversion.get(codigo) != null) {
			c= this.cuentasInversion.get(codigo);
		} 
		return c;
	};

	/*
	 * Funcion que actualizar la cuenta si se ha modificado algo
	 */
	public Boolean actualizarCuenta(Long codigo, Object c) {
		if(this.cuentasCorriente.get(codigo) != null) {
			this.cuentasCorriente.replace(codigo,(CuentaCorriente) c);
		}else if(this.cuentasVivienda.get(codigo) != null) {
			this.cuentasVivienda.replace(codigo,(CuentaVivienda) c);
		}else if(this.cuentasInversion.get(codigo) != null) {
			this.cuentasInversion.replace(codigo,(FondoInversion) c);
		} 
		return true;
	};

	/*
	 * Funcion para visualizar el estado de la cuenta
	 */
	public static void visualizarCuenta(Object c) {
		System.out.println(c.toString());
	};
	/*
	 * Funcion sacar dinero cuando la cuenta es corriente
	 */
	public static CuentaCorriente sacarDineroCC(CuentaCorriente cc, Long saldo) {
		Long saldoActual=cc.getSaldo();
		if(saldo>saldoActual) {
			cc=null;
		}else {
			cc.setSaldo((saldoActual - saldo));
		}
		return cc;
	}
	
	/*
	 * Funcion sacar dinero cuando la cuenta es un FONDO INVERSION
	 */
	public static FondoInversion sacarDineroFI(FondoInversion fi, Long saldo) {
		Long saldoActual=fi.getSaldo();
		if(saldoActual< -500) {
			fi=null;
		}else {
			fi.setSaldo((saldoActual - saldo));
		}
		
		return fi;
	}
}
