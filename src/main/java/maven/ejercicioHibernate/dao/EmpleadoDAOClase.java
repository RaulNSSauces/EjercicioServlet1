package maven.ejercicioHibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import maven.ejercicioHibernate.model.Empleado;

public class EmpleadoDAOClase implements EmpleadoDAO{

	@Override
	public void insertarEmpleado(Session miSesion, Empleado nuevoEmpleado) {
		// TODO Auto-generated method stub
		miSesion.save(nuevoEmpleado);
	}

	@Override
	public void eliminarEmpleado(Session miSesion, int codigo) {
		// TODO Auto-generated method stub
		Query<?> consulta=miSesion.createQuery("delete from Empleado where codigo=:codEmpleado");
		consulta.setParameter("codEmpleado", codigo);
		consulta.executeUpdate();
	}
	
	@Override
	public void modificarEmpleado(Session miSesion, Empleado empleadoModificado) {
		// TODO Auto-generated method stub
		miSesion.update(empleadoModificado);
	}

	@Override
	public List<Empleado> getEmpleados(Session miSesion) {
		// TODO Auto-generated method stub
		//Crear la consulta a la base de datos
		
		Query<Empleado> miConsulta = miSesion.createQuery("from Empleado", Empleado.class);
				
		//Ejecutar la consulta y devolver los resultados
				
		List<Empleado> empleados = miConsulta.getResultList();
				
		return empleados;
	}

	@Override
	public Empleado getEmpleado(Session miSesion, int codigo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		Criteria criteria = miSesion.createCriteria(Empleado.class);
		Empleado empleado = (Empleado)criteria.add(Restrictions.eq("cod_departamento", codigo)).setMaxResults(1).uniqueResult();
		return empleado;
	}
}