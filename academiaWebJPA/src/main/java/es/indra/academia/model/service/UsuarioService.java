package es.indra.academia.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import es.indra.academia.model.dao.UsuarioDao;
import es.indra.academia.model.entities.Usuario;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.jpa.JpaDao;
import es.indra.academia.model.support.jpa.ServiceJpa;

@org.springframework.stereotype.Service
public class UsuarioService extends ServiceJpa<Long, Usuario> {

	@Autowired
	UsuarioDao dao;
	private Logger log = LogManager.getLogger(UsuarioService.class);

	@Override
	public JpaDao<Long, Usuario> getDao() {
		return this.dao;
	}

	public Usuario buscarUsuario(String username) {
		try {
			return this.dao.buscarUsuario(username);
		} catch (DaoException e) {
			this.log.error("Error", e);
			return null;
		}
	}

}