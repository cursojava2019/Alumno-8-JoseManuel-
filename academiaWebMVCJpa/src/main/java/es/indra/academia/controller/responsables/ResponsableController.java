package es.indra.academia.controller.responsables;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@Controller
@RequestMapping("/admin/responsables")
public class ResponsableController {
	@Autowired
	ResponsableJpaService responsableService;

	@Autowired
	ResponsableFormValidator validador;

	@RequestMapping(value = "/listado.html", method = RequestMethod.GET)
	public String listado(Model model) throws ServiceException, DaoException {
		List<ResponsableAlumno> listado = this.responsableService.buscarTodos();
		model.addAttribute("listado", listado);
		return "responsables/listado";
	}

	@RequestMapping(value = "/listado.html", method = RequestMethod.POST)
	public String listadoPatron(@RequestParam("patron") String patron, Model model)
			throws ServiceException, DaoException {
		List<ResponsableAlumno> listado;
		if (patron == null || patron.equals("")) {
			listado = responsableService.buscarTodos();

		} else {
			listado = responsableService.findResponsablePatron(patron);
		}
		model.addAttribute("patron", patron);
		model.addAttribute("listado", listado);
		return "responsables/listado";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("responsable", new ResponsableForm(new ResponsableAlumno()));
		return "responsables/nuevo";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("responsable") ResponsableForm form, BindingResult result)
			throws ServiceException, DaoException {
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "responsables/nuevo";
		} else {
			this.responsableService.crear(form.obtenerResponsable());
			return "redirect:/admin/responsables/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {
		if (id == null) {
			return "redirect:/admin/responsables/listado.html?mensaje=errorId";
		} else {
			ResponsableAlumno responsableAlumno = this.responsableService.buscar(id);
			if (responsableAlumno != null) {
				ResponsableForm form = new ResponsableForm(responsableAlumno);
				model.addAttribute("formulario", form);
				return "responsables/modificar";
			} else {
				return "redirect:/admin/responsables/listado.html?mensaje=errorId";
			}
		}
	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@Valid @ModelAttribute("formulario") ResponsableForm form, BindingResult result)
			throws ServiceException, DaoException {
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "responsables/modificar";
		} else {

			this.responsableService.modificar(form.obtenerResponsable());

			return "redirect:/admin/responsables/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {

		if (id == null) {
			return "redirect:/admin/responsables/listado.html?mensaje=errorId";
		} else {
			ResponsableAlumno responsableAlumno = this.responsableService.buscar(id);
			if (responsableAlumno != null) {
				this.responsableService.eliminar(responsableAlumno);
				return "redirect:/admin/responsables/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/responsables/listado.html?mensaje=errorId";
			}

		}

	}

}
