package com.chaos.stanfield.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.model.Status;
import com.chaos.stanfield.utils.JPAInitEMF;

@Controller
//@SessionAttributes("categories")
public class ProductController {

	@RequestMapping("/products")
	public ModelAndView showAllProducts(HttpServletRequest request) {
		   ArrayList<Product> listProduct=new ArrayList<Product>();
		   listProduct=new Product().allProducts();
		   return new ModelAndView("product/list", "listProduct", listProduct);
	}
	
	@RequestMapping("/create-product-form")
	 public String newProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> listCategory=new Category().allCategories();
        model.addAttribute("categories", listCategory);
        return "product/create";
    }
	
	@RequestMapping("/createProduct")
	public ModelAndView createNewProduct(HttpServletRequest request) {
		   System.out.println(request.getParameter("category"));
		   Category category=new Category();
		   category=category.categoryById(Long.parseLong(request.getParameter("category")));
 		   
		   Product product=new Product();
		   product.setName(request.getParameter("name"));
		   product.setDescription(request.getParameter("description"));
		   product.setCategory(category);
		   product.setQuantity(new BigDecimal(request.getParameter("quantity")));
		   product.setMSRP(new BigDecimal(request.getParameter("MSRP")));
		   product.setPrice(new BigDecimal(request.getParameter("price")));
		   product.setDiscount(new BigDecimal(request.getParameter("discount")));
		   product.setCLIN(request.getParameter("CLIN"));
		   product.setOEM(request.getParameter("OEM"));
		   product.setOEM_NAME(request.getParameter("OEM_NAME"));
		   product.setSKU(request.getParameter("SKU"));
		   product.setUnitMeasure(request.getParameter("unitMeasure"));
		   product.setUNSPSC(request.getParameter("UNSPSC"));
		   JPAInitEMF jpa=new JPAInitEMF();
		   jpa.InsertEntity(product);
		   
		   ArrayList<Product> listProduct=new ArrayList<Product>();
		   listProduct=new Product().allProducts();
		   return new ModelAndView("product/list", "listProduct", listProduct);
	}
	
//	
//	@ModelAttribute("categories")
//	public List<Category> retriveListOfCategories(){
//		return new Category().allCategories();
//	}
//	
	
	
	 @RequestMapping("/deleteProduct")
	 public ModelAndView deleteProduct(HttpServletRequest request) {
		   String id=request.getParameter("id");
		   Product product=new Product();
		   product.setId(Long.parseLong(id));
		   JPAInitEMF jpa=new JPAInitEMF();
		   product=jpa.getEm().find(Product.class, product.getId());
		   jpa.deleteEntity(product);
		   ArrayList<Product> listProduct=new ArrayList<Product>();
		   listProduct=new Product().allProducts();
		   return new ModelAndView("product/list", "listProduct", listProduct);
	   }
	
	  
     @RequestMapping("/editProduct")
	 public ModelAndView editProduct(HttpServletRequest request) {
			   String id=request.getParameter("id");
			   Product product=new Product();
			   product.setId(Long.parseLong(id));
			   JPAInitEMF jpa=new JPAInitEMF();
			   product=jpa.getEm().find(Product.class, product.getId());
			   List<Category> listCategory=new Category().allCategories();
		       return new ModelAndView("product/edit", "product", product).addObject("categories", listCategory);
	}
	
     
     @RequestMapping("/updateProduct")
	 public ModelAndView updateProduct(HttpServletRequest request) {
		   Product product=new Product();
		   JPAInitEMF jpa=new JPAInitEMF();
		   product.setId(Long.parseLong(request.getParameter("id").toString()));
		   product=jpa.getEm().find(Product.class, product.getId());
		
		   System.out.println(request.getParameter("category"));
		   Category category=new Category();
		   category=category.categoryById(Long.parseLong(request.getParameter("category")));
 		   
		   
		   product.setName(request.getParameter("name"));
		   product.setDescription(request.getParameter("description"));
		   product.setCategory(category);
		   product.setQuantity(new BigDecimal(request.getParameter("quantity")));
		   product.setMSRP(new BigDecimal(request.getParameter("MSRP")));
		   product.setPrice(new BigDecimal(request.getParameter("price")));
		   product.setDiscount(new BigDecimal(request.getParameter("discount")));
		   product.setCLIN(request.getParameter("CLIN"));
		   product.setOEM(request.getParameter("OEM"));
		   product.setOEM_NAME(request.getParameter("OEM_NAME"));
		   product.setSKU(request.getParameter("SKU"));
		   product.setUnitMeasure(request.getParameter("unitMeasure"));
		   product.setUNSPSC(request.getParameter("UNSPSC"));
		   
		   jpa.updateEntity(product);
		   ArrayList<Product> listProduct=new ArrayList<Product>();
		   listProduct=new Product().allProducts();
		   return new ModelAndView("product/list", "listProduct", listProduct);
    }
	
	
	
	
}
