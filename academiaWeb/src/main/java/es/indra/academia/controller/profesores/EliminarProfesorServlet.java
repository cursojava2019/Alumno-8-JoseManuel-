package es.indra.academia.controller.profesores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.service.ProfesorService;

/**
 * Servlet implementation class EliminarProfesorServlet
 */
@WebServlet("/admin/profesores/eliminar.html")
public class EliminarProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProfesorService profesorService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarProfesorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	  @Override
	    public void init() throws ServletException{
	    	ServletContext sc = getServletContext();
	    	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
	    	this.profesorService = wac.getBean(ProfesorService.class);
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Long idLong = null;
		
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			idLong = null;
		}
		if (idLong == null) {
			response.sendRedirect("./listado.html?mensaje=errorId");
		} else {
			Profesor profesor = profesorService.find(idLong);
			if (profesor != null) {
				profesorService.delete(idLong);
				response.sendRedirect("./listado.html?mensaje=correcto");
			} else {
				response.sendRedirect("./listado.html?mensaje=errorId");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
