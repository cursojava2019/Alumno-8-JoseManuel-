package es.indra.model;

import es.indra.model.entities.Cliente;
import es.indra.model.support.*;

public class ClienteService extends Service<String, Cliente> {

	private ClienteDao dao = null;

	@Override
	protected Dao<String, Cliente> getDao() {
		if (this.dao == null) {
			this.dao = new ClienteDao();
		}
		return this.dao;
	}

}