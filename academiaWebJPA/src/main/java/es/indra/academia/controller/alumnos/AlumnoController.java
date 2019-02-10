package es.indra.academia.controller.alumnos;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.indra.academia.authentication.MyUserDetails;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.service.AlumnoJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@Controller
@RequestMapping("/admin/alumnos")
public class AlumnoController {
	@Autowired
	AlumnoJpaService alumnoService;

	@Autowired
	AlumnoFormValidator validador;

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("error", e.getMessage());
		// logger.error(e);
		return "error";
	}

	@RequestMapping(value = "/listado.html", method = RequestMethod.GET)
	public String listado(Model model) throws ServiceException, DaoException {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername(); // get logged in username
		List<Alumno> listado = this.alumnoService.buscarTodos();
		model.addAttribute("listado", listado);
		return "alumnos/listado";
	}

	@RequestMapping(value = "/listado.html", method = RequestMethod.POST)
	public String listadoPatron(@RequestParam("patron") String patron, Model model)
			throws ServiceException, DaoException {
		List<Alumno> listado;
		if (patron == null || patron.equals("")) {
			listado = this.alumnoService.buscarTodos();

		} else {
			listado = this.alumnoService.findAlumnosPatron(patron);
		}
		model.addAttribute("patron", patron);
		model.addAttribute("listado", listado);
		return "alumnos/listado";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("alumno", new AlumnoForm(new Alumno()));
		return "alumnos/nuevo";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("alumno") AlumnoForm form, BindingResult result)
			throws ServiceException, DaoException {
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "alumnos/nuevo";
		} else {
			this.alumnoService.crear(form.obtenerAlumno());
			return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {
		if (id == null) {
			return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
		} else {
			Alumno alumno = this.alumnoService.buscar(id);
			if (alumno != null) {
				AlumnoForm form = new AlumnoForm(alumno);
				model.addAttribute("formulario", form);
				return "alumnos/modificar";
			} else {
				return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
			}
		}
	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@Valid @ModelAttribute("formulario") AlumnoForm form, BindingResult result)
			throws ServiceException, DaoException {
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "alumnos/modificar";
		} else {

			this.alumnoService.modificar(form.obtenerAlumno());

			return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {

		if (id == null) {
			return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
		} else {
			Alumno alumno = this.alumnoService.buscar(id);
			if (alumno != null) {
				this.alumnoService.eliminar(alumno);
				return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
			}

		}

	}

}
