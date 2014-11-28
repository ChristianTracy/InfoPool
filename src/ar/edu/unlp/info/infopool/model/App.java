package ar.edu.unlp.info.infopool.model;

import java.util.Date;
import java.util.LinkedList;

import ar.edu.unlp.info.infopool.dao.impl.GenericDAOHibernateJPA;

public class App {
	public static void main(String[] args) {
		
		GenericDAOHibernateJPA<User>gDao = new GenericDAOHibernateJPA<User>(User.class);
//	    PRUEBA CON REFLECTION
//		GenericDAOHibernateJPA<Traveler>gDao = new GenericDAOHibernateJPA<Traveler>();
		Traveler t = new Traveler();
		t.setEmail("algo@mail.com");
		t.setName("Mariel");
		t.setPassword("1234");
		t.setSurname("Cordal");
		t.setTelephone("5555555");
		t.setUsername("mcordal");

		Traveler t2 = new Traveler();
		t2.setEmail("algoOtro@mail.com");
		t2.setName("Christian");
		t2.setPassword("123456");
		t2.setSurname("Tracy");
		t2.setTelephone("888888");
		t2.setUsername("cTracy");
		
		Admin ad = new Admin();
		ad.setUsername("admin");
		ad.setPassword("admin");

		gDao.add(t);
		gDao.add(t2);
		gDao.add(ad);
		
		
		Traveler user2 = (Traveler) gDao.getById(new Long(2));
		user2.setName("otroNOMBRE");
		System.out.println("SE cambió nombre del usuario 2");
		user2.createTravel(5, new Date(), "hasta", "desde",  new LinkedList<WeekDays>(), new Date());
		System.out.println("Se creó un viaje para el Travel 2");
		gDao.update(user2);
		
		
		User result = gDao.getById(new Long(1));
		System.out.println(result.getUsername());
		
//		gDao.delete(new Long(1));
//		System.out.println("Se borro el usuario con id 1!");

		
		
		
		
	}
}
