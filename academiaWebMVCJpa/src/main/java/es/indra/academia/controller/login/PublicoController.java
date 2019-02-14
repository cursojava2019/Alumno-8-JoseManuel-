package es.indra.academia.controller.login;


import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class PublicoController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/admin/inicio.html", method = RequestMethod.GET)
	public String indexAdmin(ModelMap model) {
		return "inicio";
	}

	@RequestMapping(value = "/admin/sinpermisos.html", method = RequestMethod.GET)
	public String sinPermisos(ModelMap model) {
		return "base/sinpermisos";
	}

}