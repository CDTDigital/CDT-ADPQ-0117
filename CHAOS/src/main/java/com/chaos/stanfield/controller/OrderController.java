package com.chaos.stanfield.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class OrderController {
	
	@RequestMapping("/placeOrder")
	public ModelAndView showAllCategories(HttpServletRequest request) {
		   ArrayList<Category> listCategories=new ArrayList<Category>();
		   listCategories=new Category().allCategories();
		   return new ModelAndView("order/placeOrder", "categories", listCategories).addObject("selectedCategory", listCategories.get(0));
	}
	
	@RequestMapping("/getProducts")
	public ModelAndView showProductByCategory(HttpServletRequest request) {
			JPAInitEMF jpa=new JPAInitEMF();
			Category category=new Category().categoryById(Long.parseLong(request.getParameter("category")));
			List<Product> listProducts;
			listProducts=new Product().productsByCategory(category.getName());
			
			ArrayList<Category> listCategories=new ArrayList<Category>();
			listCategories=new Category().allCategories();
			
			ModelAndView model=new ModelAndView("order/placeOrder", "listProducts", listProducts);
			model.addObject("selectedCategory", category);
			model.addObject("filtered", 1);
			model.addObject("categories", listCategories);
			return model;
	}
	
	
	@RequestMapping("/addToCart")
	public ModelAndView addProductsToCart(HttpServletRequest request) {
		   String id=request.getParameter("id");
		   Product product=new Product();
		   product.setId(Long.parseLong(id));
		   JPAInitEMF jpa=new JPAInitEMF();
		   product=jpa.getEm().find(Product.class, product.getId());
		   product.setQuantity(new BigDecimal(request.getParameter("quantity")));
		   ShoppingCartSession shoppingcartsession=new ShoppingCartSession();
		   HttpSession session=request.getSession();
		   session=shoppingcartsession.addProductsToCart(session,product);
		   
	       return new ModelAndView("product/productDescription", "product", product);
	}
	
	@RequestMapping("/showShoppingCart")
	public ModelAndView showShoppingCart(HttpServletRequest request) {
		   ShoppingCartSession shoppingcartsession=new ShoppingCartSession();
		   List<Product> listProducts;
		   HttpSession session=request.getSession();
		   listProducts=shoppingcartsession.getProductsFromCart(session);
		   Long totalPrice=shoppingcartsession.calculateTotalPrice(listProducts);
		   return new ModelAndView("order/shoppingCart", "listProducts", listProducts).addObject("totalPrice", totalPrice);
	}
	
	@RequestMapping("/updateShoppingCartQuantity")
	public ModelAndView updateShoppingCartQuantity(HttpServletRequest request) {
		   ShoppingCartSession shoppingcartsession=new ShoppingCartSession();
		   List<Product> listProducts;
		   HttpSession session=request.getSession();
		   listProducts=(List<Product>) shoppingcartsession.updateProductToCart(session, new BigDecimal(request.getParameter("quantity")), Long.parseLong(request.getParameter("productId")));
		   Long totalPrice=shoppingcartsession.calculateTotalPrice(listProducts);
		   return new ModelAndView("order/shoppingCart", "listProducts", listProducts).addObject("totalPrice", totalPrice);
	
	}
	  
	 @RequestMapping("/showProductDescription")
	  public ModelAndView showProductDescription(HttpServletRequest request) {
				   String id=request.getParameter("id");
				   Product product=new Product();
				   product.setId(Long.parseLong(id));
				   JPAInitEMF jpa=new JPAInitEMF();
				   product=jpa.getEm().find(Product.class, product.getId());
				   List<Category> listCategory=new Category().allCategories();
			       return new ModelAndView("product/productDescription", "product", product);
	 }
	 
	 
	 @RequestMapping("/proceedOrder")
	public ModelAndView proceedOrder(HttpServletRequest request) {
		   ShoppingCartSession shoppingcartsession=new ShoppingCartSession();
		   List<Product> listProducts;
		   JPAInitEMF jpa=new JPAInitEMF();
		   
		   HttpSession session=request.getSession();
		   listProducts=shoppingcartsession.getProductsFromCart(session);
		   Long totalPrice=shoppingcartsession.calculateTotalPrice(listProducts);
		   
		   CustomerOrder newCustomerOrder=new CustomerOrder();
		   Status status=new Status().statusByName("Pending");
		   Calendar todayDate=new DateFormatConvertor().getTodaysDate();
		   UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		   newCustomerOrder.setUserInfo(userInfo);
		   newCustomerOrder.setStatus(status);
		   newCustomerOrder.setOrderDate(todayDate);
		   newCustomerOrder.setTotalPrice(new BigDecimal(totalPrice));
		   jpa.InsertEntity(newCustomerOrder);
		   
		   Set<OrderProduct> listOrderProduct=newCustomerOrder.getOrderProducts();
			
		   for (Product product : listProducts) {
			   product=product.productById(product.getId());
			   OrderProduct orderProduct=new OrderProduct();
			   orderProduct.setCustomerOrder(newCustomerOrder);
			   orderProduct.setPrice(new BigDecimal(product.getPrice().longValue()*product.getQuantity().longValue()));
			   orderProduct.setProduct(product);
			   orderProduct.setQuantity(product.getQuantity());
			   jpa.InsertEntity(orderProduct);
			   listOrderProduct.add(orderProduct);
			   newCustomerOrder.setOrderProducts(listOrderProduct);
		   }
		   jpa.updateEntity(newCustomerOrder);
		   
		   CustomerOrder customerOrder=new CustomerOrder();
 		   customerOrder.setId(newCustomerOrder.getId());
		   customerOrder=jpa.getEm().find(CustomerOrder.class, customerOrder.getId());
 		   return new ModelAndView("order/confirmedOrder", "customerOrder", customerOrder);
    }
	 
	
	    @RequestMapping("/removeProductShoppingCart")
	 	public ModelAndView removeProductShoppingCart(HttpServletRequest request) {
			   ShoppingCartSession shoppingcartsession=new ShoppingCartSession();
			   List<Product> listProducts;
			   HttpSession session=request.getSession();
			   listProducts=(List<Product>) shoppingcartsession.removeProductFromCart(session,Long.parseLong(request.getParameter("productId")));
			   Long totalPrice=shoppingcartsession.calculateTotalPrice(listProducts);
			   return new ModelAndView("order/shoppingCart", "listProducts", listProducts).addObject("totalPrice", totalPrice);
		
		}
}
