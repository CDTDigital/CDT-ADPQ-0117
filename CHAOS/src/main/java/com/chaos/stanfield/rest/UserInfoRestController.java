package com.chaos.stanfield.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.chaos.stanfield.model.UserInfo;
import com.chaos.stanfield.model.UserRole;

@RestController
@EnableWebMvc
@RequestMapping("/api")
public class UserInfoRestController {

	@RequestMapping(value="/userinfoes",method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<UserInfo>> listAllUserInfoes(){
		List<UserInfo> listUserInfoes=new UserInfo().allUserInfoes();
		if(listUserInfoes.isEmpty()){
			return new ResponseEntity<List<UserInfo>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<UserInfo>>(listUserInfoes,HttpStatus.OK);
	}
	
}
