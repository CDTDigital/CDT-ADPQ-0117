package com.chaos.stanfield.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.chaos.stanfield.model.Product;

public class ShoppingCartSession {


	public HttpSession addProductsToCart(HttpSession session, Product product) {
		 if(session.getAttribute("cartProduct")==null){
			  List<Product> listCartProducts=new ArrayList<Product>();
			  listCartProducts.add(product);
			  session.setAttribute("cartProduct",listCartProducts);
		  }else{
			  List<Product> listCartProducts=(List<Product>) session.getAttribute("cartProduct");
			  listCartProducts.add(product);
			  System.out.println(">>>>>>>>>>>>>>> "+listCartProducts.size());
			  session.setAttribute("cartProduct", listCartProducts);
		  }
		  return session;
	}
	
	
	
	public List<Product> getProductsFromCart(HttpSession session) {
		 List<Product> listCartProducts=new ArrayList<Product>();
		 if(session.getAttribute("cartProduct")==null){
			  session.setAttribute("cartProduct",listCartProducts);
		  }else{
			  listCartProducts=(List<Product>) session.getAttribute("cartProduct");
			  System.out.println("<<<<<<<<<<<<<<< "+listCartProducts.size());
		  }
		  return listCartProducts;
	}
	
	

	public List<Product> updateProductToCart(HttpSession session, BigDecimal quantity,Long id) {
		 	  List<Product> listCartProducts=(List<Product>) session.getAttribute("cartProduct");
		 	  for(int i=0;i<listCartProducts.size();i++){
		 		 if(listCartProducts.get(i).getId()==id){
		 			 listCartProducts.get(i).setQuantity(quantity);
		 		 }
		 	  }
		 	 session.setAttribute("cartProduct", listCartProducts);
			 System.out.println(">>>>>>>>>>>>>>>UPDATED  "+listCartProducts.size());
			 
		  return listCartProducts;
	}
	
	
	public List<Product> removeProductFromCart(HttpSession session,Long id) {
	 	  List<Product> listCartProducts=(List<Product>) session.getAttribute("cartProduct");
	 	  for(int i=0;i<listCartProducts.size();i++){
	 		 if(listCartProducts.get(i).getId()==id){
	 			 listCartProducts.remove(i);
	 		 }
	 	  }
	 	 session.setAttribute("cartProduct", listCartProducts);
		 System.out.println(">>>>>>>>>>>>>>>UPDATED  "+listCartProducts.size());
		 
	  return listCartProducts;
}
	
	public Long calculateTotalPrice(List<Product> listProducts){
		Long total=(long) 0;
		for (Product product : listProducts) {
			 total+=(product.getPrice().longValue())*(product.getQuantity().longValue());
		}
		return total;
	}
	
}
