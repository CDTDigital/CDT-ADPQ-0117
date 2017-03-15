package com.chaos.stanfield.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.UserRole;
import com.chaos.stanfield.utils.JPAInitEMF;

@Controller
public class UserRoleController {

	
	@RequestMapping("/userRoles")
	public ModelAndView showAllUserRoles(HttpServletRequest request) {
		   ArrayList<UserRole> listuserRoles=new ArrayList<UserRole>();
		   listuserRoles=new UserRole().allUsersRoles();
		   return new ModelAndView("userRole/list", "listUserRole", listuserRoles);
	}
	
	   
	 @RequestMapping("/deleteUserRole")
	 public ModelAndView deleteUserRole(HttpServletRequest request) {
		   String id=request.getParameter("id");
		   UserRole userRole=new UserRole();
		   userRole.setId(Long.parseLong(id));
		   JPAInitEMF jpa=new JPAInitEMF();
		   userRole=jpa.getEm().find(UserRole.class, userRole.getId());
		   jpa.deleteEntity(userRole);
		   ArrayList<UserRole> listuserRoles=new ArrayList<UserRole>();
		   listuserRoles=new UserRole().allUsersRoles();
		   return new ModelAndView("userRole/list", "listUserRole", listuserRoles);
    }
	
	  
     @RequestMapping("/editUserRole")
		 public ModelAndView editCategory(HttpServletRequest request) {
			   String id=request.getParameter("id");
			   UserRole userRole=new UserRole();
			   userRole.setId(Long.parseLong(id));
			   JPAInitEMF jpa=new JPAInitEMF();
			   userRole=jpa.getEm().find(UserRole.class, userRole.getId());
			   return new ModelAndView("userRole/edit", "userRole", userRole);
	}
	
     
     @RequestMapping("/updateUserRole")
	 public ModelAndView updateCategory(HttpServletRequest request) {
		   UserRole  userRole=new UserRole();
		   JPAInitEMF jpa=new JPAInitEMF();
		   userRole.setId(Long.parseLong(request.getParameter("id")));
		   userRole=jpa.getEm().find(UserRole.class, userRole.getId());
		   userRole.setName(request.getParameter("name"));
		   userRole.setDescription(request.getParameter("description"));
		   jpa.updateEntity(userRole);
		   ArrayList<UserRole> listuserRoles=new ArrayList<UserRole>();
		   listuserRoles=new UserRole().allUsersRoles();
		   return new ModelAndView("userRole/list", "listUserRole", listuserRoles);
    }
	
     
     @RequestMapping("/addUserRole")
	 public ModelAndView addUserRole(HttpServletRequest request) {
		   UserRole  userRole=new UserRole();
		   JPAInitEMF jpa=new JPAInitEMF();
		   userRole.setName(request.getParameter("name"));
		   userRole.setDescription(request.getParameter("description"));
		   jpa.InsertEntity(userRole);
		   ArrayList<UserRole> listuserRoles=new ArrayList<UserRole>();
		   listuserRoles=new UserRole().allUsersRoles();
		   return new ModelAndView("userRole/list", "listUserRole", listuserRoles);
    }
	
     
     @RequestMapping("/create-userRole-form")
 	 public String newCategory(Model model) {
         return "userRole/create";
     }	
}
