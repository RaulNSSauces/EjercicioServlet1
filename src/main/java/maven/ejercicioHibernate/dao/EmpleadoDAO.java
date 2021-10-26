package maven.ejercicioHibernate.dao;

import java.util.List;
import org.hibernate.Session;
import maven.ejercicioHibernate.model.Empleado;

public interface EmpleadoDAO {
	public void insertarEmpleado(Session miSesion, Empleado nuevoEmpleado);
	public void eliminarEmpleado(Session miSesion, int codigo);
	public List<Empleado> getEmpleados(Session miSesion);
	public void modificarEmpleado(Session miSesion, Empleado empleadoModificado);
	public Empleado getEmpleado(Session miSesion, int codigo);
}
