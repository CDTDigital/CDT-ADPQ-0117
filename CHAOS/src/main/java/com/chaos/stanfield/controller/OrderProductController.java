package com.chaos.stanfield.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.CustomerOrder;
import com.chaos.stanfield.model.OrderProduct;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.utils.JPAInitEMF;

@Controller
public class OrderProductController {

	@RequestMapping("/orderProducts")
	public ModelAndView showAllOrderProducts(HttpServletRequest request) {
		   ArrayList<OrderProduct> listOrderProducts=new ArrayList<OrderProduct>();
		   listOrderProducts=new OrderProduct().allOrderProducts();
		   return new ModelAndView("orderProduct/list", "listOrderProducts", listOrderProducts);
	}
	
	
	  
    @RequestMapping("/editOrderProduct")
	 public ModelAndView editProduct(HttpServletRequest request) {
			   String id=request.getParameter("id");
			   OrderProduct orderProduct=new OrderProduct();
			   orderProduct.setId(Long.parseLong(id));
			   JPAInitEMF jpa=new JPAInitEMF();
			   orderProduct=jpa.getEm().find(OrderProduct.class, orderProduct.getId());
			   String productName=orderProduct.getProduct().getName();
			   String customerOrderId=orderProduct.getCustomerOrder().getId().toString();
			   ModelAndView model=new ModelAndView("orderProduct/edit", "orderProduct", orderProduct);
			   model.addObject("productName",productName );
			   model.addObject("customerOrderId", customerOrderId);
			   return model;
    }
	
    
    @RequestMapping("/updateOrderProduct")
	 public ModelAndView updateProduct(HttpServletRequest request) {
		   OrderProduct orderProduct=new OrderProduct();
		   JPAInitEMF jpa=new JPAInitEMF();
		   orderProduct.setId(Long.parseLong(request.getParameter("id").toString()));
		   orderProduct=jpa.getEm().find(OrderProduct.class, orderProduct.getId());
		   orderProduct.setPrice(new BigDecimal(request.getParameter("price")));
		   orderProduct.setQuantity(new BigDecimal(request.getParameter("quantity")));
		   jpa.updateEntity(orderProduct);
		   ArrayList<OrderProduct> listOrderProducts=new ArrayList<OrderProduct>();
		   listOrderProducts=new OrderProduct().allOrderProducts();
		   return new ModelAndView("orderProduct/list", "listOrderProducts", listOrderProducts);
   }
	
	
	
	
}
