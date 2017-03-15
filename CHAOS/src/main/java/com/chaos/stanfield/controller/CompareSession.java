package com.chaos.stanfield.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.chaos.stanfield.model.Product;

public class CompareSession {


	public HttpSession addProductsToCompare(HttpSession session, Product product) {
		 if(session.getAttribute("compareProduct")==null){
			  List<Product> listCompareProducts=new ArrayList<Product>();
			  listCompareProducts.add(product);
			  session.setAttribute("compareProduct",listCompareProducts);
		  }else{
			  List<Product> listCompareProducts=(List<Product>) session.getAttribute("compareProduct");
			  listCompareProducts.add(product);
			  session.setAttribute("compareProduct", listCompareProducts);
			  System.out.println(">>>>>>>>>>>>"+listCompareProducts.size());
		  }
		 
		  return session;
	}
	
	
	
	public List<Product> getProductsFromComparision(HttpSession session) {
		 List<Product> listCompareProducts=new ArrayList<Product>();
		 if(session.getAttribute("compareProduct")==null){
			  session.setAttribute("compareProduct",listCompareProducts);
		  }else{
			  listCompareProducts=(List<Product>) session.getAttribute("compareProduct");
			  System.out.println(">>>>>>>Get Products Compare>>>>>"+listCompareProducts.size());
		  }
		  return listCompareProducts;
	
	}
	
	public List<Product> removeProductFromComparision(HttpSession session,Long id) {
	 	  List<Product> listCompareProducts=(List<Product>) session.getAttribute("compareProduct");
	 	  for(int i=0;i<listCompareProducts.size();i++){
	 		 if(listCompareProducts.get(i).getId()==id){
	 			 listCompareProducts.remove(i);
	 		 }
	 	  }
	 	 session.setAttribute("compareProduct", listCompareProducts);
		 
	  return listCompareProducts;
}
	
	
//
//	public List<Product> removeProductFromCart(HttpSession session,Long id) {
//	 	  List<Product> listCartProducts=(List<Product>) session.getAttribute("cartProduct");
//	 	  for(int i=0;i<listCartProducts.size();i++){
//	 		 if(listCartProducts.get(i).getId()==id){
//	 			 listCartProducts.remove(i);
//	 		 }
//	 	  }
//	 	 session.setAttribute("cartProduct", listCartProducts);
//		 System.out.println(">>>>>>>>>>>>>>>UPDATED  "+listCartProducts.size());
//		 
//	  return listCartProducts;
//}
	
	
}
