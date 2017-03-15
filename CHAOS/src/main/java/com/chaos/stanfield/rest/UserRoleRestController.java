package com.chaos.stanfield.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.chaos.stanfield.model.UserRole;

@RestController
@EnableWebMvc
@RequestMapping("/api")
public class UserRoleRestController {

	
	@RequestMapping(value="/userroles",method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<UserRole>> listAllUserRoles(){
		List<UserRole> listUserRoles=new UserRole().allUsersRoles();
		if(listUserRoles.isEmpty()){
			return new ResponseEntity<List<UserRole>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<UserRole>>(listUserRoles,HttpStatus.OK);
	}
	
	
}
