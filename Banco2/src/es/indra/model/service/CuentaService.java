package es.indra.model.service;

import es.indra.model.dao.CuentaDao;
import es.indra.model.entities.Cuenta;
import es.indra.model.support.Dao;
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

	public Cuenta sumarSaldoService(Cuenta c, Long cantidad) {
		Long saldoActual = c.getSaldo();
		c.setSaldo((saldoActual + cantidad));
		return c;
	}

	public Cuenta restarSaldoService(Cuenta c, Long cantidad) {
		Long saldoActual = c.getSaldo();
		c.setSaldo((saldoActual - cantidad));
		return c;
	}

//	public List<Cuenta> findCuentasBloqueadas() {
//		try {
//			getDao();
//			return this.dao.findCuentaBloqueadas();
//		} catch (DaoException e) {
//			System.out.println("Error Al obtener informacion en la BBDD ");
//			return null;
//		}
//
//	}

}