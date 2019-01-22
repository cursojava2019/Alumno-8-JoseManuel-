package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Cuenta;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class CuentaDao implements Dao<Long, Cuenta> {
	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Cuenta entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO CUENTA VALUES (?,?,?,?,?,?) ");
			ps.setLong(1, entity.getCodigo());
			ps.setLong(2, entity.getSaldo());
			ps.setDouble(3, entity.getComision());
			ps.setString(4, entity.getTipo());
			ps.setString(5, entity.getDniCliente());
			ps.setBoolean(6, entity.getBloqueada());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}

	}

	@Override
	public void update(Cuenta entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("UPDATE CUENTA SET saldo=? WHERE codigo=?");
			ps.setLong(1, entity.getSaldo());
			ps.setLong(2, entity.getCodigo());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar el saldo de la cuenta");
			throw new DaoException();
		}

	}

	public void bloquear(Cuenta entity) throws DaoException {
		try {
			Connection co = getConexion();
			if (entity.getBloqueada()) {
				PreparedStatement ps = co.prepareStatement("UPDATE CUENTA SET bloqueada=? WHERE codigo=?");
				ps.setBoolean(1, entity.getBloqueada());
				ps.setLong(2, entity.getCodigo());
				ps.executeUpdate();
				co.close();

			} else {
				PreparedStatement ps = co.prepareStatement("UPDATE CUENTA SET bloqueada=? WHERE codigo=?");
				ps.setBoolean(1, entity.getBloqueada());
				ps.setLong(2, entity.getCodigo());
				ps.executeUpdate();
				co.close();

			}

		} catch (SQLException e) {
			System.out.println("Error 1 intentar bloquear/Desbloquear la cuenta");
			throw new DaoException();
		}

	}

	@Override
	public void delete(Long key) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cuenta find(Long key) throws DaoException {
		Cuenta cuenta = null;
		try {
			Connection co = getConexion();
			String query = "SELECT * FROM CUENTA WHERE codigo=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setLong(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				cuenta = obtenerCuenta(resultados);

			}
			co.close();

			return cuenta;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public List<Cuenta> findAll() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();

			String query = "SELECT * FROM CUENTA";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Cuenta> listado = new ArrayList<Cuenta>();

			while (resultados.next()) {

				Cuenta cuenta = obtenerCuenta(resultados);
				listado.add(cuenta);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	protected static Cuenta obtenerCuenta(ResultSet resultado) throws SQLException {
		Long codigo = resultado.getLong(1);
		Long saldo = resultado.getLong(2);
		Double comision = resultado.getDouble(3);
		String tipo = resultado.getString(4);
		String clienteDni = resultado.getString(5);
		Boolean bloqueada = resultado.getBoolean(6);
		Cuenta cuenta = new Cuenta(codigo, saldo, comision, tipo, clienteDni, bloqueada);
		return cuenta;
	}

}
