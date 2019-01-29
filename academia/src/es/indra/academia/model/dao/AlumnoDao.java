package es.indra.academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.indra.academia.configuration.Configuracion;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;

public class AlumnoDao implements Dao<Long, Alumno> {

	private static final String CAMPOS = "nombre,apellido1,apellido2,nif,telefono,correo,repetidor,observaciones,fechaalta,fechabaja";

	@Override
	public void create(Alumno entity) throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co
					.prepareStatement("INSERT INTO ALUMNO(" + CAMPOS + ") VALUES (?,?,?,?,?,?,?,?,?,?) ");

			p.setString(1, entity.getNombre());
			p.setString(2, entity.getApellido1());
			p.setString(3, entity.getApellido2());
			p.setString(4, entity.getNif());
			p.setString(5, entity.getTelefono());
			p.setString(6, entity.getCorreo());
			p.setBoolean(7, entity.getRepetidor());
			p.setString(8, entity.getObservaciones());
			if (entity.getFechaAlta() != null) {
				p.setDate(9, new java.sql.Date(entity.getFechaAlta().getTime()));
			} else {
				p.setDate(9, null);
			}
			if (entity.getFechaBaja() != null) {
				p.setDate(10, new java.sql.Date(entity.getFechaBaja().getTime()));
			} else {
				p.setDate(10, null);
			}

			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public void update(Alumno entity) throws DaoException {
		try {
			// "nombre,apellido1,apellido2,nif,telefono,correo,repetidor,observaciones,id,fechaalta,fechabaja";
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co.prepareStatement("UPDATE ALUMNO" + " SET nombre=?," + " apellido1=?,"
					+ " apellido2=?," + " nif=?," + " telefono=?," + " correo=?," + " repetidor=?," + " observaciones=?,"
					+ " fechaalta=?," + " fechabaja=? WHERE id=?;");

			p.setString(1, entity.getNombre());
			p.setString(2, entity.getApellido1());
			p.setString(3, entity.getApellido2());
			p.setString(4, entity.getNif());
			p.setString(5, entity.getTelefono());
			p.setString(6, entity.getCorreo());
			p.setBoolean(7, entity.getRepetidor());
			p.setString(8, entity.getObservaciones());
			if (entity.getFechaAlta() != null) {
				p.setDate(9, new java.sql.Date(entity.getFechaAlta().getTime()));
			} else {
				p.setDate(9, null);
			}
			if (entity.getFechaBaja() != null) {
				p.setDate(10, new java.sql.Date(entity.getFechaBaja().getTime()));
			} else {
				p.setDate(10, null);
			}
			p.setLong(11, entity.getId());
			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error modificando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}

	}

	@Override
	public void delete(Long key) throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co.prepareStatement("DELETE FROM ALUMNO WHERE id=?");

			p.setLong(1, key);
			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error borrando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}

	}

	@Override
	public Alumno find(Long key) throws DaoException {
		Alumno alumno = null;
		try {
			String query = "SELECT id," + CAMPOS + " FROM ALUMNO WHERE id=?";

			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setLong(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				alumno = obtenerAlumno(resultados);

			}
			co.close();
			return alumno;
		} catch (SQLException e) {
			System.out.println("Error buscando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public List<Alumno> findAll() throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			Statement instruccion = co.createStatement();

			String query = "SELECT id," + CAMPOS + " FROM ALUMNO";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Alumno> listado = new ArrayList<Alumno>();

			while (resultados.next()) {

				Alumno alumno = obtenerAlumno(resultados);

				listado.add(alumno);
			}

			co.close();
			return listado;
		} catch (Exception e) {
			System.out.println("Error buscando objetos Alumnos en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	public List<Alumno> findAlumnos(String patron) throws DaoException {

		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			Statement instruccion = co.createStatement();

			String query = "SELECT id," + CAMPOS + " FROM ALUMNO WHERE LOWER(nombre) like LOWER('%" + patron
					+ "%') OR LOWER(apellido1) like LOWER('%" + patron + "%') OR LOWER(apellido2) like LOWER('%"
					+ patron + "%')  OR LOWER(nif) like LOWER('%" + patron + "%') ;";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Alumno> listado = new ArrayList<Alumno>();

			while (resultados.next()) {

				Alumno alumno = obtenerAlumno(resultados);

				listado.add(alumno);
			}

			co.close();
			return listado;
		} catch (Exception e) {
			System.out.println("Error buscando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	private Alumno obtenerAlumno(ResultSet resultado) throws SQLException {
		// "nombre,apellido1,apellido2,nif,telefono,correo,repetidor,observaciones,fechaalta,fechabaja";

		Long id = resultado.getLong(1);
		String nombre = resultado.getString(2);
		String apellido1 = resultado.getString(3);
		String apellido2 = resultado.getString(4);
		String nif = resultado.getString(5);
		String telefono = resultado.getString(6);
		String correo = resultado.getString(7);
		Boolean repetidor = resultado.getBoolean(8);
		String observaciones = resultado.getString(9);
		Date fAlta = resultado.getDate(10);
		Date fBaja = resultado.getDate(11);
		Alumno alumno = new Alumno(nombre, apellido1, apellido2, nif, telefono, correo, repetidor, observaciones, fAlta,
				fBaja);
		alumno.setId(id);
		return alumno;
	}
}
