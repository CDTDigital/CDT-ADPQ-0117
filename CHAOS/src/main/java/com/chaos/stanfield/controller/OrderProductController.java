package com.chaos.stanfield.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.stanfield.model.CustomerOrder;
import com.chaos.stanfield.model.OrderProduct;

@Controller
public class OrderProductController {

	@RequestMapping("/orderProducts")
	public ModelAndView showAllOrderProducts(HttpServletRequest request) {
		   ArrayList<OrderProduct> listOrderProducts=new ArrayList<OrderProduct>();
		   listOrderProducts=new OrderProduct().allOrderProducts();
		   return new ModelAndView("orderProduct/list", "listOrderProducts", listOrderProducts);
	}
}
