package com.chaos.stanfield.controller;

import java.math.BigDecimal;
import java.text.ParseException;
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
import com.chaos.stanfield.model.Status;
import com.chaos.stanfield.model.UserInfo;
import com.chaos.stanfield.utils.DateFormatConvertor;
import com.chaos.stanfield.utils.JPAInitEMF;

@Controller
public class CustomerOrderController {

	@RequestMapping("/customerOrders")
	public ModelAndView showAllCustomerOrders(HttpServletRequest request) {
		   ArrayList<CustomerOrder> listCustomerOrder=new ArrayList<CustomerOrder>();
		   listCustomerOrder=new CustomerOrder().allCustomerOrders();
		   return new ModelAndView("customerOrder/list", "listCustomerOrder", listCustomerOrder);
	}
	
	
	 @RequestMapping("/deleteCustomerOrder")
	 public ModelAndView deleteCustomerOrder(HttpServletRequest request) {
		   String id=request.getParameter("id");
		   CustomerOrder customerOrder=new CustomerOrder();
		   customerOrder.setId(Long.parseLong(id));
		   JPAInitEMF jpa=new JPAInitEMF();
		   customerOrder=jpa.getEm().find(CustomerOrder.class, customerOrder.getId());
		   jpa.deleteEntity(customerOrder);
		   ArrayList<CustomerOrder> listCustomerOrder=new ArrayList<CustomerOrder>();
		   listCustomerOrder=new CustomerOrder().allCustomerOrders();
		   return new ModelAndView("customerOrder/list", "listCustomerOrder", listCustomerOrder);
	   }
	
	  
     @RequestMapping("/editCustomerOrder")
	 public ModelAndView editCustomerOrder(HttpServletRequest request) {
			   String id=request.getParameter("id");
			   CustomerOrder customerOrder=new CustomerOrder();
			   customerOrder.setId(Long.parseLong(id));
			   JPAInitEMF jpa=new JPAInitEMF();
			   customerOrder=jpa.getEm().find(CustomerOrder.class, customerOrder.getId());
			   List<Status> listStatus=new Status().allStatus();
			   List<UserInfo> listUserInfo=new UserInfo().allUserInfoes();
			   ModelAndView model=new ModelAndView("customerOrder/edit", "customerOrder", customerOrder);
			   model.addObject("userInfoes", listUserInfo);
			   model.addObject("statuses", listStatus);
			   return model;
		       //return new ModelAndView("customerOrder/edit", "customerOrder", customerOrder).addObject("categories", listCategory);
	}
	
     
     @RequestMapping("/updateCustomerOrder")
	 public ModelAndView updateCustomerOrder(HttpServletRequest request) throws ParseException {
    	   DateFormatConvertor dft=new DateFormatConvertor();
 		   CustomerOrder customerOrder=new CustomerOrder();
 		   Status status=new Status();
		   JPAInitEMF jpa=new JPAInitEMF();
		   
		   customerOrder.setId(Long.parseLong(request.getParameter("id").toString()));
		   customerOrder=jpa.getEm().find(CustomerOrder.class, customerOrder.getId());
		   status=status.statusById(Long.parseLong(request.getParameter("status")));
		   UserInfo userInfo=new UserInfo().userInfoById(Long.parseLong(request.getParameter("userInfo")));
		
		   System.out.println(request.getParameter("orderDate"));
		   customerOrder.setOrderDate(dft.stringToCalendar(request.getParameter("orderDate")));
		   customerOrder.setUserInfo(userInfo);
		   customerOrder.setStatus(status);
		   customerOrder.setTotalPrice(new BigDecimal(request.getParameter("totalPrice")));
		   		   
		   jpa.updateEntity(customerOrder);
		   
		   ArrayList<CustomerOrder> listCustomerOrder=new ArrayList<CustomerOrder>();
		   listCustomerOrder=new CustomerOrder().allCustomerOrders();
		   return new ModelAndView("customerOrder/list", "listCustomerOrder", listCustomerOrder);
    }
	
     
    @RequestMapping("/customerOrderDetail")
 	public ModelAndView showAllCustomerOrderDetail(HttpServletRequest request) {
 		   CustomerOrder customerOrder=new CustomerOrder();
 		   JPAInitEMF jpa=new JPAInitEMF();
 		   customerOrder.setId(Long.parseLong(request.getParameter("id").toString()));
		   customerOrder=jpa.getEm().find(CustomerOrder.class, customerOrder.getId());
 		   return new ModelAndView("customerOrder/customerOrderDetail/listDetail", "customerOrder", customerOrder);
 	}
 	
     
     
     
	
	
}
