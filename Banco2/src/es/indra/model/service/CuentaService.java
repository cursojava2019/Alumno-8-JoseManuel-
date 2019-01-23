package es.indra.model.service;

import java.util.List;

import es.indra.model.dao.CuentaDao;
import es.indra.model.entities.Cuenta;
import es.indra.model.entities.CuentaCorriente;
import es.indra.model.entities.CuentaVivienda;
import es.indra.model.entities.FondoInversion;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.Service;

public class CuentaService extends Service<Long, Cuenta> {
	private CuentaDao dao = null;

	@Override
	protected Dao<Long, Cuenta> getDao() {
		if (this.dao == null) {
			this.dao = new CuentaDao();
		}
		return this.dao;
	}

	public CuentaService() {
		this.dao = new CuentaDao();
	}

	/*
	 * Condiciones segun el tipo de cuenta que sea:
	 * La CC tiene un interés del 0.1, la CV del 0.2 y el FI de un 0.34. De la CC no
	 * se puede sacar mas dinero del que hay, del FI se pueden sacar hasta 500€ de
	 * números rojos (si se supera la cuenta se bloquea) y de la CV no se puede
	 * sacar dinero.La revisión mensual de la CV no paga comisión bancaria.
	 */
	public Cuenta sumarSaldoService(Cuenta c, Long cantidad) {
		Long saldoActual = c.getSaldo();
		c.setSaldo((saldoActual + cantidad));
		return c;
	}

	public Cuenta restarSaldoService(Cuenta c, Long cantidad) {
		Long saldoActual = c.getSaldo();
		if (c.getTipo().equals("corriente")) {
			if (cantidad > saldoActual) {
				System.out.println("No puede sacar mas dinero del que tiene en saldo.");
				c = null;
			} else {
				c.setSaldo((saldoActual - cantidad));
			}

		} else if (c.getTipo().equals("vivienda")) {
			System.out.println("De las cuentas que son de tipo vivienda no se puede sacar dinero.");
			c = null;
		} else if (c.getTipo().equals("inversion")) {
			if ((saldoActual - cantidad) <= -500) {
				c.setSaldo((saldoActual - cantidad));
				System.out
						.println("Esta en numeros rojos y ha superado la cantidad de -500.Su cuenta ha sido bloqueada");
				c.setBloqueada(true);
			} else {
				c.setSaldo((saldoActual - cantidad));
			}
		}

		return c;
	}

	public void bloquear(Cuenta entity) {
		try {
			dao.bloquear(entity);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	public List revisionMensualCuentas(List<Cuenta> cuentas) {
		for (int i = 0; i < cuentas.size(); i++) {
			Cuenta c = cuentas.get(i);
			if (c.getTipo().equals("corriente")) {
				CuentaCorriente cc = new CuentaCorriente();
				c.setSaldo((long) (c.getSaldo() * cc.getInterescc() - c.getComision()));
				cuentas.remove(i);
				cuentas.add(i, c);
			} else if (c.getTipo().equals("vivienda")) {
				CuentaVivienda cv = new CuentaVivienda();
				c.setSaldo((long) (c.getSaldo() * cv.getInterescv()));
				cuentas.remove(i);
				cuentas.add(i, c);
			} else if (c.getTipo().equals("inversion")) {
				FondoInversion fi = new FondoInversion();
				c.setSaldo((long) (c.getSaldo() * fi.getInteresfi() - c.getComision()));
				cuentas.remove(i);
				cuentas.add(i, c);
			} else {
				cuentas = null;
			}
		}
		return cuentas;
	}




}
