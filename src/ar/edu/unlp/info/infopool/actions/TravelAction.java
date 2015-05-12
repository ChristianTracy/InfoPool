package ar.edu.unlp.info.infopool.actions;

import java.util.List;
import java.util.Map;

import ar.edu.unlp.info.infopool.dao.TravelDAO;
import ar.edu.unlp.info.infopool.model.Event;
import ar.edu.unlp.info.infopool.model.Travel;
import ar.edu.unlp.info.infopool.model.Traveler;
import ar.edu.unlp.info.infopool.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TravelAction extends ActionSupport{

	private static final long serialVersionUID = -7088198285168273206L;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private List<Travel> travelCollection;
	private TravelDAO travelDAO;
	

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
		 User loguedUser = (User) session.get("user");
	    travelCollection = (List<Travel>)travelDAO.getOtherUsersTravels(loguedUser.getId());
	    return "success";
	 }
}
