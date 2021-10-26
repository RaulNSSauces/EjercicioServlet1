package maven.ejercicioHibernate.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class MostrarDatosServ
 */
@WebServlet("/MostrarDatos")
public class MostrarDatosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LogManager.getLogger(MostrarDatosServ.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDatosServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String parametro = request.getParameter("table");
		if(parametro!=null) {
			if(parametro.equals("departamento")) {
				request.getRequestDispatcher("MostrarDepartamentos").forward(request, response);
				logger.info("El usuario ha seleccionado la tabla departamentos");
			}else if(parametro.equals("empleado")){
				request.getRequestDispatcher("MostrarEmpelados").forward(request, response);
				logger.info("El usuario ha seleccionado la tabla empleados");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}