package maven.ejercicioHibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import maven.ejercicioHibernate.dao.EmpleadoDAOClase;
import maven.ejercicioHibernate.model.Empleado;
import maven.ejercicioHibernate.utils.HibernateUtil;

/**
 * Servlet implementation class MostrarEmpeladosServ
 */
@WebServlet("/MostrarEmpelados")
public class MostrarEmpeladosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LogManager.getLogger(MostrarDepartamentosServ.class);
	List<Empleado> listaEmpleados;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarEmpeladosServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter res = response.getWriter();
		EmpleadoDAOClase empleado = new EmpleadoDAOClase();
		Session miSesion = HibernateUtil.getSessionFactory().openSession();
		listaEmpleados = empleado.getEmpleados(miSesion);
		if(listaEmpleados != null) {
			logger.info("La lista de empleados tiene valores");
			res.println("<html>");
			res.println("<head>");
				res.println("<title>Listado de empleados</title>");
			res.println("</head>");
			res.println("<body>");
				res.println("<table border= \"2\">");
					res.println("<tr>");
						res.println("<th>Código</th>");
						res.println("<th>Nombre</th>");
						res.println("<th>Apellido 1</th>");
						res.println("<th>Apellido 2</th>");
						res.println("<th>Luegar de nacimiento</th>");
						res.println("<th>Fecha de nacimiento</th>");
						res.println("<th>Dirección</th>");
						res.println("<th>Teléfono</th>");
						res.println("<th>Puesto</th>");
						res.println("<th>Código del departamento</th>");
					res.println("</tr>");
					for(Empleado e: listaEmpleados) {
						res.println("<tr>");
							res.println("<td>"+e.getCodigo()+"</td>");
							res.println("<td>"+e.getNombre()+"</td>");
							res.println("<td>"+e.getApe1()+"</td>");
							res.println("<td>"+e.getApe2()+"</td>");
							res.println("<td>"+e.getLugar_nac()+"</td>");
							res.println("<td>"+e.getFecha_nac()+"</td>");
							res.println("<td>"+e.getDireccion()+"</td>");
							res.println("<td>"+e.getTel()+"</td>");
							res.println("<td>"+e.getPuesto()+"</td>");
							res.println("<td>"+e.getCod_departamento()+"</td>");
						res.println("</tr>");
					}
				res.println("</table>");
			res.println("</body>");
		res.println("</html>");
		res.close();
		}else {
			logger.info("La lista de empleados está vacía");
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