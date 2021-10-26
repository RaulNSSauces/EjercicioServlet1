package maven.ejercicioHibernate.dao;

import java.util.List;
import org.hibernate.Session;

import maven.ejercicioHibernate.model.Departamento;

public interface DepartamentoDAO {
	public void insertarDepartamento(Session miSesion, Departamento nuevoDepartamento);
	public void eliminarDepartamento(Session miSesion, int codigo);
	public List<Departamento> getDepartamentos(Session miSesion);
	public void modificarDepartamento(Session miSesion, Departamento departamentoModificado);
}
