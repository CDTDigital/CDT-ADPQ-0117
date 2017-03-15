package com.chaos.stanfield.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.chaos.stanfield.model.Status;
import com.chaos.stanfield.model.UserInfo;

@RestController
@EnableWebMvc
@RequestMapping("/api")
public class StatusRestController {
	
	@RequestMapping(value="/statuses",method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<Status>> listAllStatuses(){
		List<Status> listStatus=new Status().allStatus();
		if(listStatus.isEmpty()){
			return new ResponseEntity<List<Status>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Status>>(listStatus,HttpStatus.OK);
	}
	
}
