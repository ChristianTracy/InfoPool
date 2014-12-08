package ar.edu.unlp.info.infopool.utils;

import java.util.Date;
import java.util.LinkedList;

import ar.edu.unlp.info.infopool.dao.impl.GenericDAOHibernateJPA;
import ar.edu.unlp.info.infopool.model.Admin;
import ar.edu.unlp.info.infopool.model.Complaint;
import ar.edu.unlp.info.infopool.model.Event;
import ar.edu.unlp.info.infopool.model.Message;
import ar.edu.unlp.info.infopool.model.Travel;
import ar.edu.unlp.info.infopool.model.Traveler;
import ar.edu.unlp.info.infopool.model.User;
import ar.edu.unlp.info.infopool.model.WeekDays;

public class App {
	public static void main(String[] args) {
		
		//DECLARAR DAOS
		
		GenericDAOHibernateJPA<User>userDao = new GenericDAOHibernateJPA<User>(User.class);
		GenericDAOHibernateJPA<Travel> travelDao = new GenericDAOHibernateJPA<Travel>(Travel.class);
		GenericDAOHibernateJPA<Message> msjDao = new GenericDAOHibernateJPA<Message>(Message.class);
		GenericDAOHibernateJPA<Complaint> complaintDao = new GenericDAOHibernateJPA<Complaint>(Complaint.class);
		GenericDAOHibernateJPA<Event> eventDao = new GenericDAOHibernateJPA<Event>(Event.class);
		//AGREGAR USUARIOS
		
		Traveler traveler1 = new Traveler();
		traveler1.setEmail("mcordal@mail.com");
		traveler1.setName("Mariel");
		traveler1.setPassword("1234");
		traveler1.setSurname("Cordal");
		traveler1.setTelephone("5555555");
		traveler1.setUsername("mcordal");

		Traveler traveler2 = new Traveler();
		traveler2.setEmail("ctracy@mail.com");
		traveler2.setName("Christian");
		traveler2.setPassword("1234");
		traveler2.setSurname("Tracy");
		traveler2.setTelephone("888888");
		traveler2.setUsername("ctracy");
		
		Admin ad = new Admin();
		ad.setUsername("admin");
		ad.setPassword("admin");

		userDao.add(traveler1);
		userDao.add(traveler2);
		userDao.add(ad);
		
		//TRAER USUARIOS DE LA BASE DE DATOS
		Traveler user2 = (Traveler) userDao.getById(new Long(2));
		Traveler user1 = (Traveler) userDao.getById(new Long(1));
		
		//MODIFICAR USUARIO
		user2.setName("NombreCambiado");
		System.out.println("SE cambió nombre del usuario 2");
		userDao.update(user2);
		
		//CREAR MENSAJE
		Message msj = new Message();
		msj.setOwner(user1);
		msj.setReceptor(user2);
		msj.setText("Hola usuario 2");
		
		msj = msjDao.update(msj);
		user2.addMessage(msj);
		//CREAR DENUNCIA 
		Complaint complaint = new Complaint();
		complaint.setComment("Esta es una denuncia");
		complaint.setOwner(user1);
		complaint = complaintDao.update(complaint);
		user2.addComplaint(complaint);
		//CREAR VIAJE
		Travel trav = new Travel();
		trav.setDate(new Date());
		trav.setDays(new LinkedList<WeekDays>());
		trav.setDriver(user1);
		trav.setFromAdress("Desde");
		trav.setToAdress("hasta");
		trav.setReturnTime(new Date());
		trav.setSeats(4);
		trav = travelDao.update(trav);
		user1.addTravel(trav);
		//AGREGAR VIAJERO 
		user2.addOtherTravel(trav);
		userDao.update(user2);
		userDao.update(user1);
		
		//Agregar evento 
		Event event = new Event();
		event.setDate(new Date());
		event.setDescription("Este es un event");
		event.setLocation("La Plata");
		event.setName("EVENTO");
		event = eventDao.update(event);
		
		ad.addEvent(event);
		
		//Agregar un evento a un viaje
		trav.addEvent(event);
		travelDao.update(trav);
	}
}
