package maven.ejercicioHibernate;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maven.ejercicioHibernate.dao.DepartamentoDAOClase;
import maven.ejercicioHibernate.dao.EmpleadoDAOClase;
import maven.ejercicioHibernate.model.Departamento;
import maven.ejercicioHibernate.model.Empleado;
import maven.ejercicioHibernate.utils.HibernateUtil;

public class Main {
	
	private static Logger logger = LogManager.getLogger(Main.class);
	
    public static void main( String[] args ) {
    	Scanner teclado=new Scanner(System.in);
        
        int opcion;
        
        int codObtenerEmpleado;
        
        //DECLARACIÓN DE VARIABLES DEPARTAMENTO
        int codDepInsert, codRespInsert, codDepDelete, codDepUpdate, codRespUpdate;
        String nomDepInsert, nomDepUpdate;
        
        //DECLARACIÓN DE VARIABLES EMPLEADO
        int codEmpInsert, codDepEmpInsert, codEmpDelete;
        String nomEmpInsert, ape1EmpInsert, ape2EmpInsert, lugarNacInsert, fechaNacInsert, dirInsert, telInsert, puestoInsert;
        
        int codEmpUpdate, codDepEmpUpdate;
        String nomEmpUpdate, ape1EmpUpdate, ape2EmpUpdate, lugarNacUpdate, fechaNacUpdate, dirUpdate, telUpdate, puestoUpdate;
        
        //INICIALIZAMOS UNA SESIÓN Y UNA TRANSACCIÓN
        Session miSesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        //INSTANCIA DE LAS CLASES DAO DEPARTAMENTO Y EMPLEADO
        DepartamentoDAOClase dep = new DepartamentoDAOClase();
        EmpleadoDAOClase emp = new EmpleadoDAOClase();
        
        logger.info("El usuario ha ejecutado la aplicación");
        
        do{
			System.out.println("----MENÚ CRUD----");
			System.out.println("1.-Insertar Departamento.");
			System.out.println("2.-Eliminar Departamento.");
			System.out.println("3.-Modificar un departamento.");
			System.out.println("4.-Consultar departamentos.");
			System.out.println("5.-Insertar un empleado.");
			System.out.println("6.-Eliminar un empleado.");
			System.out.println("7.-Modificar un empleado.");
			System.out.println("8.-Consultar empleados.");
			System.out.println("9.-Empleado que pertenece a un cierto departamento.");
			System.out.println("0.-Salir.");
			System.out.println("--------------------------------");
			opcion=teclado.nextInt();
            	switch(opcion) {
            	//INSERTAR UN DEPARTAMENTO
            	case 1:	logger.info("El usuario ha seleccionado la opcion: "+opcion);
            			try{
            				tx = miSesion.beginTransaction();
		            		System.out.print("Código del departamento: ");
		            		codDepInsert=teclado.nextInt();
		        			System.out.print("Nombre del departamento: ");
		        			nomDepInsert=teclado.next();
		        			System.out.print("Código del responsable del departamento: ");
		        			codRespInsert=teclado.nextInt();
		        			Departamento departamento = new Departamento(codDepInsert, nomDepInsert, codRespInsert);		        			
		        			dep.insertarDepartamento(miSesion, departamento);
		        			tx.commit();
		        			System.out.println("CAMPO INSERTADO CORRECTAMENTE EN LA BASE DE DATOS");
            			}catch(Exception e) {
            				if(tx != null) {
            					tx.rollback();
            				}
            				logger.error("Error al insertar un registro en la base de datos "+e.getMessage());
            			}
            			
            		break;
            	//ELIMINAR UN DEPARTAMENTO
            	case 2: logger.info("El usuario ha seleccionado la opcion: "+opcion);
            			try{
		            		tx = miSesion.beginTransaction();
		        			System.out.print("Introduce el código para eliminar un departamento: ");
		        			codDepDelete=teclado.nextInt();
		        			dep.eliminarDepartamento(miSesion, codDepDelete);
		        			tx.commit();
		        			System.out.println("CAMPO ELIMINADO CORRECTAMENTE DE LA BASE DE DATOS");
            			}catch(Exception e) {
            				if(tx != null) {
            					tx.rollback();
            				}
            				logger.error("Error al eliminar un registro en la base de datos "+e.getMessage());
            			}
            		break;
            	//MODIFICAR UN DEPARTAMENTO
            	case 3: logger.info("El usuario ha seleccionado la opcion: "+opcion);
            			try {
            				tx = miSesion.beginTransaction();
            				System.out.print("Introduce el código del departamento que quieres modificar:");
            				codDepUpdate=teclado.nextInt();
            				System.out.print("Nuevo nombre del departamento: ");
            				nomDepUpdate=teclado.next();
            				System.out.print("Nuevo codigo del departamento responsable: ");
            				codRespUpdate=teclado.nextInt();
            				Departamento departamentoModificado = new Departamento(codDepUpdate, nomDepUpdate, codRespUpdate);
            				dep.modificarDepartamento(miSesion, departamentoModificado);
            				tx.commit();
		        			System.out.println("DEPARTAMENTO MODIFICADO CREADO CORRECTAMENTE");
            			}catch(Exception e) {
            				if(tx != null) {
            					tx.rollback();
            				}
            				logger.error("Error al modificar un registro en la base de datos "+e.getMessage());
            			}
            		break;
            	//LISTAR TODOS LOS DEPARTAMENTOS
            	case 4: logger.info("El usuario ha seleccionado la opcion: "+opcion);
            			List<Departamento> departamentos = dep.getDepartamentos(miSesion);
            			for(int i = 1; i<departamentos.size(); i++) {
            			}
            				System.out.println(departamentos.toString());
            		break;
            	//INSERTAR UN EMPLEADO
            	case 5:	logger.info("El usuario ha seleccionado la opcion: "+opcion);
            			try{
		    				tx = miSesion.beginTransaction();
		            		System.out.print("Código del empleado: ");
		            		codEmpInsert=teclado.nextInt();
		        			System.out.print("Nombre del empleado: ");
		        			nomEmpInsert=teclado.next();
		        			System.out.print("Primer apellido: ");
		        			ape1EmpInsert=teclado.next();
		        			System.out.print("Segundo apellido: ");
		        			ape2EmpInsert=teclado.next();
		        			System.out.print("Lugar de nacimiento: ");
		        			lugarNacInsert=teclado.next();
		        			System.out.print("Fecha de nacimiento: ");
		        			fechaNacInsert = teclado.next();
		        			System.out.print("Dirección: ");
		        			dirInsert=teclado.next();
		        			System.out.print("Teléfono: ");
		        			telInsert=teclado.next();
		        			System.out.print("Puesto: ");
		        			puestoInsert=teclado.next();
		        			System.out.print("Código de departamento: ");
		        			codDepEmpInsert=teclado.nextInt();
		        			Empleado nuevoEmpelado = new Empleado(codEmpInsert, nomEmpInsert, ape1EmpInsert, ape2EmpInsert, lugarNacInsert, fechaNacInsert, dirInsert, telInsert, puestoInsert, codDepEmpInsert);
		        			emp.insertarEmpleado(miSesion, nuevoEmpelado);
		        			tx.commit();
		        			System.out.println("CAMPO INSERTADO CORRECTAMENTE EN LA BASE DE DATOS");
		    			}catch(Exception e) {
		    				if(tx != null) {
            					tx.rollback();
            				}
            				logger.error("Error al insertar un registro en la base de datos "+e.getMessage());
		    			}
            		break;
            	//ELIMINAR UN EMPLEADO
            	case 6: logger.info("El usuario ha seleccionado la opcion: "+opcion); 
            			try{
		            		tx = miSesion.beginTransaction();
		        			System.out.print("Introduce el código para eliminar un empleado: ");
		        			codEmpDelete=teclado.nextInt();
		        			emp.eliminarEmpleado(miSesion, codEmpDelete);
		        			tx.commit();
		        			System.out.println("CAMPO ELIMINADO CORRECTAMENTE DE LA BASE DE DATOS");
		    			}catch(Exception e) {
		    				if(tx != null) {
            					tx.rollback();
            				}
            				logger.error("Error al eliminar un registro en la base de datos "+e.getMessage());
		    			}
            		break;
            	//MODIFICAR UN EMPLEADO
            	case 7: logger.info("El usuario ha seleccionado la opcion: "+opcion);
            			try{
		    				tx = miSesion.beginTransaction();
		            		System.out.print("Código del empleado: ");
		            		codEmpUpdate=teclado.nextInt();
		        			System.out.print("Nombre del empleado: ");
		        			nomEmpUpdate=teclado.next();
		        			System.out.print("Primer apellido: ");
		        			ape1EmpUpdate=teclado.next();
		        			System.out.print("Segundo apellido: ");
		        			ape2EmpUpdate=teclado.next();
		        			System.out.print("Lugar de nacimiento: ");
		        			lugarNacUpdate=teclado.next();
		        			System.out.print("Fecha de nacimiento: ");
		        			fechaNacUpdate = teclado.next();
		        			System.out.print("Dirección: ");
		        			dirUpdate=teclado.next();
		        			System.out.print("Teléfono: ");
		        			telUpdate=teclado.next();
		        			System.out.print("Puesto: ");
		        			puestoUpdate=teclado.next();
		        			System.out.print("Código de departamento: ");
		        			codDepEmpUpdate=teclado.nextInt();
		        			Empleado nuevoEmpelado = new Empleado(codEmpUpdate, nomEmpUpdate, ape1EmpUpdate, ape2EmpUpdate, lugarNacUpdate, fechaNacUpdate, dirUpdate, telUpdate, puestoUpdate, codDepEmpUpdate);
		        			emp.insertarEmpleado(miSesion, nuevoEmpelado);
		        			tx.commit();
		        			System.out.println("CAMPO MODIFICADO CORRECTAMENTE EN LA BASE DE DATOS");
		    			}catch(Exception e) {
		    				if(tx != null) {
		    					tx.rollback();
            				}
            				logger.error("Error al modificar un registro en la base de datos "+e.getMessage());
		    			}
            		break;
            	//LISTAR LOS EMPLEADOS
            	case 8:	logger.info("El usuario ha seleccionado la opcion: "+opcion);
            			List<Empleado> empleados = emp.getEmpleados(miSesion);
			    			for(int i = 1; i<empleados.size(); i++) {
			    			}
			    		System.out.println(empleados.toString());
            		break;
            	//SACAR EMPLEADOS MEDIANTE EL CÓDIGO DEL DEPARTAMENTO
            	case 9: logger.info("El usuario ha seleccionado la opcion: "+opcion);
            			System.out.print("Introduce el código del empleado que desea sacar por pantalla: ");
            			codObtenerEmpleado=teclado.nextInt();
	            		System.out.println(emp.getEmpleado(miSesion, codObtenerEmpleado));
            		break;
            	default:
            	}
		}while(opcion!=0);
        	miSesion.close();
        	teclado.close();
    }
}