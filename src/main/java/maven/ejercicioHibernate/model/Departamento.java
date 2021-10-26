package maven.ejercicioHibernate.model;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="departamento")
public class Departamento implements Serializable {
	
	//Declaración de variables y mapeo de los campos a la base de datos
	@Id
	@Column(name="codigo")
	private int codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="cod_responsable")
	private int codResponsable;
	
	//Constructor sin parametrizar
	public Departamento() {
		
	}
	
	//Constructor que recibe todos los parámetros
	public Departamento(int codigo, String nombre, int codResponsable) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.codResponsable = codResponsable;
	}
	

	//Getters and Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodResponsable() {
		return codResponsable;
	}

	public void setCodResponsable(int codResponsable) {
		this.codResponsable = codResponsable;
	}
	
	//Método toString()
	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", codResponsable=" + codResponsable + "]";
	}
}
