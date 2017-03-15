package com.chaos.stanfield.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.utils.JPAInitEMF;

@Controller
public class CompareProductController {

	@RequestMapping("/addToCompare")
	public ModelAndView addProductsToCompare(HttpServletRequest request) {
		   String id=request.getParameter("id");
		   Product product=new Product();
		   product.setId(Long.parseLong(id));
		   JPAInitEMF jpa=new JPAInitEMF();
		   product=jpa.getEm().find(Product.class, product.getId());
		   CompareSession compareSession=new CompareSession();
		   HttpSession session=request.getSession();
		   session=compareSession.addProductsToCompare(session, product);
	       return new ModelAndView("product/productDescription", "product", product);
	}
	
	@RequestMapping("/showComparision")
	public ModelAndView showComparision(HttpServletRequest request) {
		   CompareSession compareSession=new CompareSession();
		   List<Product> listProducts;
		   HttpSession session=request.getSession();
		   listProducts=compareSession.getProductsFromComparision(session);
		   ModelAndView model=new ModelAndView("comparision/compareProducts");
		   Product product1,product2,product3;
			product1 = new Product();
			product2 = new Product();
			product3 = new Product();
		   try{
		   
		  
				
		    if (listProducts.size()>=1) {
				product1 = listProducts.get(0);
			}
			if (listProducts.size()>=2) {
				product2 = listProducts.get(1);
			} 
			if (listProducts.size()>=3) {
				product3 = listProducts.get(2);
			} 
			  
			   model.addObject("product1", product1);
			   model.addObject("product2", product2);
			   model.addObject("product3", product3);
		
			   return model;
		
		   }catch (Exception e) {
		
		   }
		
		   model.addObject("product1", product1);
		   model.addObject("product2", product2);
		   model.addObject("product3", product3);
		   return model;
	   
	}
	
	
	@RequestMapping("/removeProductFromCompare")
 	public ModelAndView removeProductFromCompare(HttpServletRequest request) {
		 CompareSession compareSession=new CompareSession();
		   List<Product> listProducts;
		   HttpSession session=request.getSession();
		   listProducts=(List<Product>) compareSession.removeProductFromComparision(session,Long.parseLong(request.getParameter("id")));
		  
		   ModelAndView model=new ModelAndView("comparision/compareProducts");
		   Product product1,product2,product3;
			product1 = new Product();
			product2 = new Product();
			product3 = new Product();
		   try{
		   
		  
				
		    if (listProducts.size()>=1) {
				product1 = listProducts.get(0);
			}
			if (listProducts.size()>=2) {
				product2 = listProducts.get(1);
			} 
			if (listProducts.size()>=3) {
				product3 = listProducts.get(2);
			} 
			  
			   model.addObject("product1", product1);
			   model.addObject("product2", product2);
			   model.addObject("product3", product3);
		
			   return model;
		
		   }catch (Exception e) {
		
		   }
		
		   model.addObject("product1", product1);
		   model.addObject("product2", product2);
		   model.addObject("product3", product3);
		   return model;
	
	}
	
}
