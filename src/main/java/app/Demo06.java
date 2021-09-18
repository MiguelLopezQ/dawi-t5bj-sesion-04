package app;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {
	
	public static void main(String[] args) {
		// 1. especificar la conexion de BD - DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// 2. Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		
		// listado de los usuarios
		
		TypedQuery<Usuario> query = em.createQuery("Select u from Usuario u",Usuario.class);
		
		List<Usuario> lstUsuarios = query.getResultList();
		
		System.out.println("Cantidad de usuarios : "+lstUsuarios.size());
		
		if (lstUsuarios.size()==0) {
			System.out.println("Listado vacio");
		}else {
			System.out.println("Listado de usuarios");
			for(Usuario u: lstUsuarios) {
				System.out.println(">>>> "+u);
			}
		}
		
		// otra forma de listado de usuarios
		List<Usuario> lstUsuarios2 = query.getResultList();
		
		System.out.println("Cantidad de usuarios : "+lstUsuarios2.size());
		
			System.out.println("---Listado de usuarios---");
			for(Usuario u: lstUsuarios2) {
				System.out.println(">>>> "+u);
		}
		
		// listado con parametros -> listado de los usuarios por tipo
		// select * from tb_usuarios where idtipo=?
		String sql = "Select u from Usuario u where u.tipo = :xtipo";
		TypedQuery<Usuario> query3 = em.createQuery(sql,Usuario.class);	
		query3.setParameter("xtipo", 1);
		
		List<Usuario> lstUsuarios3 = query3.getResultList();
		
		System.out.println("Cantidad de usuarios : "+lstUsuarios3.size());
		
		if (lstUsuarios3.size()==0) {
			System.out.println("Listado vacio");
		}else {
			System.out.println("--Listado de usuarios tipo 1--");
			for(Usuario u: lstUsuarios3) {
				System.out.println(">>>> "+u);
			}
		}
		
		em.close();
		
	}
	

}
