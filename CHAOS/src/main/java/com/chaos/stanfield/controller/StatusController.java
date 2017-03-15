package com.chaos.stanfield.controller;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.chaos.stanfield.model.Status;
import com.chaos.stanfield.utils.JPAInitEMF;

@Controller
public class StatusController {


	@RequestMapping("/statues")
	public ModelAndView showAllStatus(HttpServletRequest request) {
		   ArrayList<Status> listStatus=new ArrayList<Status>();
		   listStatus=new Status().allStatus();
		   return new ModelAndView("status/list", "listStatus", listStatus);
	}
	
	   
	   
	 @RequestMapping("/deleteStatus")
	 public ModelAndView deleteCategory(HttpServletRequest request) {
		   String id=request.getParameter("id");
		   Status status=new Status();
		   status.setId(Long.parseLong(id));
		   JPAInitEMF jpa=new JPAInitEMF();
		   status=jpa.getEm().find(Status.class, status.getId());
		   jpa.deleteEntity(status);
		   ArrayList<Status> listStatus=new ArrayList<Status>();
		   listStatus=new Status().allStatus();
		   return new ModelAndView("status/list", "listStatus", listStatus);
	   }
	
	  
     @RequestMapping("/editStatus")
		 public ModelAndView editCategory(HttpServletRequest request) {
			   String id=request.getParameter("id");
			   Status status=new Status();
			   status.setId(Long.parseLong(id));
			   JPAInitEMF jpa=new JPAInitEMF();
			   status=jpa.getEm().find(Status.class, status.getId());
			   return new ModelAndView("status/edit", "status", status);
	}
	
     
     @RequestMapping("/updateStatus")
	 public ModelAndView updateCategory(HttpServletRequest request) {
		   Status status=new Status();
		   JPAInitEMF jpa=new JPAInitEMF();
		   status.setId(Long.parseLong(request.getParameter("id")));
		   status=jpa.getEm().find(Status.class, status.getId());
		   status.setName(request.getParameter("name"));
		   status.setDescription(request.getParameter("description"));
		   jpa.updateEntity(status);
		   ArrayList<Status> listStatus=new ArrayList<Status>();
		   listStatus=new Status().allStatus();
		   return new ModelAndView("status/list", "listStatus", listStatus);
    }
	
     
     @RequestMapping("/addStatus")
   	 public ModelAndView addStatus(HttpServletRequest request) {
   		   Status status=new Status();
   		   JPAInitEMF jpa=new JPAInitEMF();
   		   status.setName(request.getParameter("name"));
   		   status.setDescription(request.getParameter("description"));
   		   jpa.InsertEntity(status);
   		   ArrayList<Status> listStatus=new ArrayList<Status>();
   		   listStatus=new Status().allStatus();
   		   return new ModelAndView("status/list", "listStatus", listStatus);
       }
   	
     @RequestMapping("/create-status-form")
	 	public String createStatus(Model model) {
	    	    return "status/create";
	 	}
     
}
