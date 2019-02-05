package es.indra.academia.controller.profesores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.indra.academia.model.entities.Profesor;

public class ProfesorForm extends Profesor {
	public ProfesorForm() {
		super();
		setNif("");
		setNombre("");
		setApellido1("");
		setApellido2("");
		setTelefono("");
		setCorreo("");
		setTitulacion("");
	}

	public ProfesorForm(Profesor p) {
		super();
		setId(p.getId());
		setNif(p.getNif());
		setNombre(p.getNombre());
		setApellido1(p.getApellido1());
		setApellido2(p.getApellido2());
		setTelefono(p.getTelefono());
		setCorreo(p.getCorreo());
		setTitulacion(p.getTitulacion());

	}

	public static ProfesorForm obtenerProfesorForm(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String correo = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String titulacion = request.getParameter("titulacion");

		ProfesorForm profesor = new ProfesorForm();
		Long idLong = null;
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			idLong = null;
		}

		profesor.setId(idLong);
		profesor.setCorreo(correo);
		profesor.setApellido2(apellido2);
		profesor.setApellido1(apellido1);
		profesor.setNif(nif);
		profesor.setNombre(nombre);
		profesor.setTelefono(telefono);
		profesor.setTitulacion(titulacion);

		return profesor;
	}

	public void validar(List<String> errores) {
		if (getNif() == null || getNif().equals("")) {
			errores.add("El nif es obligatorio");

		}
		if (getNif().length() != 9) {
			errores.add("El formato de NIF no es correcto");

		}
		if (getNombre() == null || getNombre().equals("")) {
			errores.add("El Nombre es obligatorio");

		}
		if (getApellido1() == null || getApellido1().equals("")) {
			errores.add("El Primero Apellido es obligatorio");

		}

	}

}
