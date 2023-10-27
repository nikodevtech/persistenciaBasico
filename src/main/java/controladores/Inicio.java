package controladores;

import java.util.Calendar;

import daos.Acceso;
import daos.Usuario;
import jakarta.persistence.*;

public class Inicio {

	public static void main(String[] args) {

		// Creamos un registro de la bbdd de acceso como una instancia de Acceso
		Acceso accesoCliente = new Acceso("cliente", "Acceso de cliente normal de la biblioteca");

		// Crear una instancia de Usuario
		Usuario usuarioRandom = new Usuario("30242873N", "Nico", "Alvarez", "685297787", "nikoalvarezzapata@gmail.com",
				"1234", false, Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), accesoCliente);

		//Creamos un modelo virtual a partir de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaEjercicio"); 
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(accesoCliente); // Insertar el acceso y el usuario en el modelo virtual
		em.persist(usuarioRandom);
		tx.commit(); // <-- Hasta que no se realiza esta acción no pasa los datos del "contexto" o "modelo" a la bbdd

		// Cerramos para liberar recurso el EntityManager y el EntityManagerFactory
		em.close();
		emf.close();

	}

}
