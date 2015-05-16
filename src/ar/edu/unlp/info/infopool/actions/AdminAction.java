package ar.edu.unlp.info.infopool.actions;

import java.util.List;

import ar.edu.unlp.info.infopool.dao.ComplaintDAO;
import ar.edu.unlp.info.infopool.model.Complaint;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	List<Complaint> allComplaints;
	private static final long serialVersionUID = -294055426001660258L;

	private ComplaintDAO complaintDAO;
	
	public String render (){
		this.setAllComplaints(complaintDAO.getAll());
		
		return "success";
	}

	public List<Complaint> getAllComplaints() {
		return allComplaints;
	}

	public void setAllComplaints(List<Complaint> allComplaints) {
		this.allComplaints = allComplaints;
	}

	public ComplaintDAO getComplaintDAO() {
		return complaintDAO;
	}

	public void setComplaintDAO(ComplaintDAO complaintDAO) {
		this.complaintDAO = complaintDAO;
	}
	
	
	
}
