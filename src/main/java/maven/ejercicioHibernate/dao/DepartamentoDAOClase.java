package maven.ejercicioHibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import maven.ejercicioHibernate.model.Departamento;

public class DepartamentoDAOClase implements DepartamentoDAO{
	
	@Override
	public void insertarDepartamento(Session miSesion, Departamento nuevoDepartamento) {
		// TODO Auto-generated method stub
		miSesion.save(nuevoDepartamento);
	}
	
	@Override
	public void eliminarDepartamento(Session miSesion, int codigo) {
		// TODO Auto-generated method stub
		//Borrar el cliente de la BD utilizando como criterio su ID correspondiente
		Query<?> consulta=miSesion.createQuery("delete from Departamento where codigo=:codDep");
		consulta.setParameter("codDep", codigo);
		consulta.executeUpdate();
	}	
	
	@Override
	public List<Departamento> getDepartamentos(Session miSesion) {
		// TODO Auto-generated method stub		
		//Crear la consulta a la base de datos
				
		Query<Departamento> miConsulta=miSesion.createQuery("from Departamento", Departamento.class);
		
		//Ejecutar la consulta y devolver los resultados
		
		List<Departamento> departamentos = miConsulta.getResultList();
		
		return departamentos;
	}

	@Override
	public void modificarDepartamento(Session miSesion, Departamento departamentoModificado) {
		// TODO Auto-generated method stub
		miSesion.update(departamentoModificado);
	}
}