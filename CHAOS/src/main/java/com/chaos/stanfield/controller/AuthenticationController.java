package com.chaos.stanfield.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.UserInfo;
import com.chaos.stanfield.utils.JPAInitEMF;

@Controller
public class AuthenticationController {

	@RequestMapping("/login")
	public ModelAndView auhtenticateUser(HttpServletRequest request) {
		   try{
		   String username=request.getParameter("username");
		   String password=request.getParameter("password");
		   JPAInitEMF jpa=new JPAInitEMF();
		   UserInfo userInfo=new UserInfo().userInfoByUsername(username);
		   if(userInfo==null){
			   return new ModelAndView("index","alert",0);
		   }else{
			   if(userInfo.getUsername().equals(username) && userInfo.getPassword().equals(password)){
				   HttpSession session=request.getSession();
				   session.setAttribute("userInfo",userInfo);
				   return new ModelAndView("home");
			   }else{
				   return new ModelAndView("index","alert",0);
			   }
		   }
		   }catch (Exception e) {
			   System.out.println(e.getMessage());
		   }
		   return new ModelAndView("home");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logoutUser(HttpServletRequest request) {
		   try{
		   	   HttpSession session=request.getSession();
			   session.invalidate();
			   return new ModelAndView("index");
			
		   }catch (Exception e) {
			   System.out.println(e.getMessage());
		   }
		   return new ModelAndView("index");
	}
	
	
}
