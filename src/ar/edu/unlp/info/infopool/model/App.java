package ar.edu.unlp.info.infopool.model;

import javax.persistence.EntityManager;

import ar.edu.unlp.info.infopool.utils.EMF;

public class App {
public static void main(String[] args) {
	System.out.println("Creo entity");
	EntityManager em = EMF.getEMF().createEntityManager();
}
}
