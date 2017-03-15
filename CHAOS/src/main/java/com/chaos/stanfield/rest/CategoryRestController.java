package com.chaos.stanfield.rest;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.chaos.stanfield.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.Api;

@RestController
@EnableWebMvc
@Api(value="chaos",description="Category Rest")
@RequestMapping("/api")
public class CategoryRestController {

	
	@RequestMapping(value="/categories",method=RequestMethod.GET,produces = "application/json")
	@JsonIgnore
	public ResponseEntity<List<Category>> listAllCategories(){
		System.out.println("Reached Here >>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<Category> listCategories=new Category().allCategories();
		if(listCategories.isEmpty()){
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Category>>(listCategories,HttpStatus.OK);
	}
	
	
	// OR
	
//	@GetMapping("/category")
//	public ResponseEntity getCustomer() {
//		List<Category> listCategories=new Category().allCategories();
//		if(listCategories.isEmpty()){
//			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
//			}
//		return new ResponseEntity<List<Category>>(listCategories,HttpStatus.OK);
//	}
	
	
	
}
