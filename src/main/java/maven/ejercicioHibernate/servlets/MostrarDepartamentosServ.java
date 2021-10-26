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

import maven.ejercicioHibernate.dao.DepartamentoDAOClase;
import maven.ejercicioHibernate.model.Departamento;
import maven.ejercicioHibernate.utils.HibernateUtil;

/**
 * Servlet implementation class MostrarDepartamentosServ
 */
@WebServlet("/MostrarDepartamentos")
public class MostrarDepartamentosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LogManager.getLogger(MostrarDepartamentosServ.class);
	List<Departamento> listaDepartamentos;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDepartamentosServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter res = response.getWriter();
		DepartamentoDAOClase departamento = new DepartamentoDAOClase();
		Session miSesion = HibernateUtil.getSessionFactory().openSession();
		listaDepartamentos = departamento.getDepartamentos(miSesion);
		if(listaDepartamentos != null) {
			logger.info("La lista de departamentos tiene valores");
			res.println("<html>");
			res.println("<head>");
				res.println("<title>Listado de departamentos</title>");
			res.println("</head>");
			res.println("<body>");
				res.println("<table border= \"2\">");
					res.println("<tr>");
						res.println("<th>Código del departamento</th>");
						res.println("<th>Nombre del departamento</th>");
						res.println("<th>Codigo del responsable del departamento</th>");
					res.println("</tr>");
					for(Departamento d: listaDepartamentos) {
						res.println("<tr>");
							res.println("<td>"+d.getCodigo()+"</td>");
							res.println("<td>"+d.getNombre()+"</td>");
							res.println("<td>"+d.getCodResponsable()+"</td>");
						res.println("</tr>");
					}
				res.println("</table>");
			res.println("</body>");
		res.println("</html>");
		res.close();
		}else {
			logger.info("La lista de departamentos está vacía");
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