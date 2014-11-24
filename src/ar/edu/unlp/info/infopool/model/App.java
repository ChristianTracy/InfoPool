package ar.edu.unlp.info.infopool.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ar.edu.unlp.info.infopool.utils.EMF;

public class App {
	public static void main(String[] args) {
		System.out.println("Creo entity");
		EntityManager em = EMF.getEMF().createEntityManager();

		Traveler t = new Traveler();
		t.setEmail("algo@mail.com");
		t.setName("Mariel");
		t.setPassword("1234");
		t.setSurname("Cordal");
		t.setTelephone("5555555");
		t.setUsername("mcordal");

		Admin a = new Admin();
		a.setUsername("admin");
		a.setPassword("admin");

		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(t);
		em.persist(a);
		em.flush();
		etx.commit();
		em.close();
	}
}
