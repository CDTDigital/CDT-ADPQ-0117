package com.chaos.stanfield.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.chaos.stanfield.model.CustomerOrder;

@RestController
@EnableWebMvc
@RequestMapping("/api")
public class CustomerOrderRestController {

	

	@RequestMapping(value="/customerOrders",method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<CustomerOrder>> listAllCustomerOrders(@RequestParam(value="username", required=false) String username){
		List<CustomerOrder> listCustomerOrders;
		if(username!=null){
				listCustomerOrders=new CustomerOrder().customerOrderByUsername(username);
		}else{
			 listCustomerOrders=new CustomerOrder().allCustomerOrders();
		}

		if(listCustomerOrders.isEmpty()){
			return new ResponseEntity<List<CustomerOrder>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CustomerOrder>>(listCustomerOrders,HttpStatus.OK);
	}


	
	
}
