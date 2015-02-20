package ar.edu.unlp.info.infopool.actions;

import java.util.List;

import ar.edu.unlp.info.infopool.dao.TravelDAO;
import ar.edu.unlp.info.infopool.model.Event;
import ar.edu.unlp.info.infopool.model.Travel;

import com.opensymphony.xwork2.ActionSupport;

public class TravelAction extends ActionSupport{

	private static final long serialVersionUID = -7088198285168273206L;

	private List<Travel> travelCollection;
	String algo;
	public String getAlgo() {
		return algo;
	}

	public void setAlgo(String algo) {
		this.algo = algo;
	}
	private TravelDAO travelDAO;
	public TravelAction() {
	}

	public List<Travel> getTravelCollection() {
		return travelCollection;
	}

	public void setTravelCollection(List<Travel> travelCollection) {
		this.travelCollection = travelCollection;
	}

	public TravelDAO getTravelDAO() {
		return travelDAO;
	}

	public void setTravelDAO(TravelDAO travelDAO) {
		this.travelDAO = travelDAO;
	}
	 public String listTravels() {
	    	travelCollection = (List<Travel>)travelDAO.getAll();
	    	 algo = travelCollection.get(0).getDriver().getName();
	    	
	    	return "success";
	    }
}
