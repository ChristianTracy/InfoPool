package ar.edu.unlp.info.infopool.model;

import ar.edu.unlp.info.infopool.dao.impl.GenericDAOHibernateJPA;

public class App {
	public static void main(String[] args) {
		
		GenericDAOHibernateJPA<Traveler>gDao = new GenericDAOHibernateJPA<Traveler>(Traveler.class);
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

		gDao.add(t);
		gDao.add(t2);

		User result = gDao.getById(new Long(1));
		System.out.println(result.getUsername());
	}
}
