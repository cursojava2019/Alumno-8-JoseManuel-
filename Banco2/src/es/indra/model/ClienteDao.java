package es.indra.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.*;
import es.indra.model.support.*;


public class ClienteDao implements Dao<String, Cliente> {
	
	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}
	
	@Override
	public void create(Cliente entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO CLIENTE VALUES (?,?,?,?,?) ");
			ps.setString(1, entity.getDni());
			ps.setString(2, entity.getNombre());
			ps.setString(3, entity.getApellidos());
			ps.setString(4, entity.getDireccion());
			ps.setString(5, entity.getTlf());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
}
		
	}

	@Override
	public void update(Cliente entity) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String key) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente find(String key) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAll() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();

			String query = "SELECT * FROM CLIENTE";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Cliente> listado = new ArrayList<Cliente>();

			while (resultados.next()) {
				String nif = resultados.getString(1);
				String nombre = resultados.getString(2);
				String apellidos = resultados.getString(3);
				String direccion = resultados.getString(4);
				String tlf = resultados.getString(5);

				Cliente cliente = new Cliente(nif, nombre, apellidos,direccion,tlf);
				listado.add(cliente);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
}
	}


}
