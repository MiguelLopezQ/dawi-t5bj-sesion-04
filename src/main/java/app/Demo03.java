package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	
	public static void main(String[] args) {
		// 1. especificar la conexion de BD - DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// 2. Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		
		// procesos.. eliminar un  usuario
		Usuario u= new Usuario();
		u.setCodigo(12);
		
		
		
		// reg, act, elim -> Transacciones
		try {
			em.getTransaction().begin();
			em.remove(u);	//eliminar 
			em.getTransaction().commit();
			System.out.println("Eliminación OK");
		} catch (Exception e) {
			System.out.println("Error : "+e.getClass().getTypeName());
		}
		em.close();
		
	}

}
