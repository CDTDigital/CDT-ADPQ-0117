package com.chaos.stanfield.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.model.Status;

@RestController
@EnableWebMvc
@RequestMapping("/api")
public class ProductRestController {
	
	
	@RequestMapping(value="/products",method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<Product>> listAllProducts(@RequestParam(value="category", required=false) String category){
		List<Product> listProducts;
		if(category==null){
			listProducts=new Product().allProducts();
		}else{
			listProducts=new Product().productsByCategory(category);
		}
		
		if(listProducts.isEmpty()){
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Product>>(listProducts,HttpStatus.OK);
	}
		
}
