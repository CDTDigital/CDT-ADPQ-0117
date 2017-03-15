package com.chaos.stanfield.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.model.UserInfo;
import com.chaos.stanfield.model.UserRole;
import com.chaos.stanfield.utils.JPAInitEMF;

@Controller
public class UserInfoController {
	
	@RequestMapping("/userInfoes")
	public ModelAndView showAllUserInfo(HttpServletRequest request) {
		   ArrayList<UserInfo> listUserInfo=new ArrayList<UserInfo>();
		   listUserInfo=new UserInfo().allUserInfoes();
		   List<UserRole> listUserRoles=new UserRole().allUsersRoles();
		   return new ModelAndView("userInfo/list", "listUserInfo", listUserInfo).addObject("userRoles", listUserRoles);
	}
	
	@RequestMapping("/create-userInfo-form")
	 public String newUserInfo(Model model) {
        UserInfo userInfo = new UserInfo();
        model.addAttribute("product", userInfo);
        List<UserRole> listUserRoles=new UserRole().allUsersRoles();
        model.addAttribute("userRoles", listUserRoles);
        return "userInfo/create";
    }
	
	@RequestMapping("/createUserInfo")
	public ModelAndView createNewUserInfo(HttpServletRequest request) {
		   UserRole userRole=new UserRole();
		   userRole=userRole.userRoleById(Long.parseLong(request.getParameter("userRole")));
 		   
		   UserInfo userInfo=new UserInfo();
		   userInfo.setUserRole(userRole);
		   userInfo.setAddress(request.getParameter("address"));
		   userInfo.setDisplayName(request.getParameter("displayName"));
		   userInfo.setEmail(request.getParameter("email"));
		   userInfo.setPassword(request.getParameter("password"));
		   userInfo.setPhone(request.getParameter("phone"));
		   userInfo.setUsername(request.getParameter("username"));

		   JPAInitEMF jpa=new JPAInitEMF();
		   jpa.InsertEntity(userInfo);
		   
		   ArrayList<UserInfo> listUserInfo=new ArrayList<UserInfo>();
		   listUserInfo=new UserInfo().allUserInfoes();
		   return new ModelAndView("userInfo/list", "listUserInfo", listUserInfo);
	}
	
//	
//	@ModelAttribute("categories")
//	public List<Category> retriveListOfCategories(){
//		return new Category().allCategories();
//	}
//	
	
	
	 @RequestMapping("/deleteUserInfo")
	 public ModelAndView deleteUserInfo(HttpServletRequest request) {
		   String id=request.getParameter("id");
		   UserInfo userInfo=new UserInfo();
		   userInfo.setId(Long.parseLong(id));
		   JPAInitEMF jpa=new JPAInitEMF();
		   userInfo=jpa.getEm().find(UserInfo.class, userInfo.getId());
		   jpa.deleteEntity(userInfo);
		   ArrayList<UserInfo> listUserInfo=new ArrayList<UserInfo>();
		   listUserInfo=new UserInfo().allUserInfoes();
		   return new ModelAndView("userInfo/list", "listUserInfo", listUserInfo);
	   }
	
	  
     @RequestMapping("/editUserInfo")
	 public ModelAndView editUserInfo(HttpServletRequest request) {
			   String id=request.getParameter("id");
			   UserInfo userInfo=new UserInfo();
			   userInfo.setId(Long.parseLong(id));
			   JPAInitEMF jpa=new JPAInitEMF();
			   userInfo=jpa.getEm().find(UserInfo.class, userInfo.getId());
			   List<UserRole> listUserRole=new UserRole().allUsersRoles();
		       return new ModelAndView("userInfo/edit", "userInfo", userInfo).addObject("userRoles", listUserRole);
	}
	
     
     @RequestMapping("/updateUserInfo")
	 public ModelAndView updateUserInfo(HttpServletRequest request) {
		   UserInfo userInfo=new UserInfo();
		   JPAInitEMF jpa=new JPAInitEMF();
		   userInfo.setId(Long.parseLong(request.getParameter("id").toString()));
		   userInfo=jpa.getEm().find(UserInfo.class, userInfo.getId());
		
		   System.out.println(request.getParameter("userRole"));
		   UserRole userRole=new UserRole();
		   userRole=userRole.userRoleById(Long.parseLong(request.getParameter("userRole")));
 		   
		   userInfo.setUserRole(userRole);
		   userInfo.setAddress(request.getParameter("address"));
		   userInfo.setDisplayName(request.getParameter("displayName"));
		   userInfo.setEmail(request.getParameter("email"));
		   userInfo.setPassword(request.getParameter("password"));
		   userInfo.setPhone(request.getParameter("phone"));
		   userInfo.setUsername(request.getParameter("username"));
		   
		   jpa.updateEntity(userInfo);
		   ArrayList<UserInfo> listUserInfo=new ArrayList<UserInfo>();
		   listUserInfo=new UserInfo().allUserInfoes();
		   return new ModelAndView("userInfo/list", "listUserInfo", listUserInfo);
    }
	
}
