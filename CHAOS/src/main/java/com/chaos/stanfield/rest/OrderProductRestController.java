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
import com.chaos.stanfield.model.OrderProduct;

@RestController
@EnableWebMvc
@RequestMapping("/api")
public class OrderProductRestController {

	@RequestMapping(value="/orderProducts",method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<OrderProduct>> listAllOrderProduct(@RequestParam(value="customerOrder", required=false) String customerOrder){
		List<OrderProduct> listOrderProduct;
		if(customerOrder!=null){
				listOrderProduct=new OrderProduct().OrderProductByCustomerOrderId(Long.parseLong(customerOrder));
		}else{
			 listOrderProduct=new OrderProduct().allOrderProducts();
		}

		if(listOrderProduct.isEmpty()){
			return new ResponseEntity<List<OrderProduct>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderProduct>>(listOrderProduct,HttpStatus.OK);
	}


	
}
