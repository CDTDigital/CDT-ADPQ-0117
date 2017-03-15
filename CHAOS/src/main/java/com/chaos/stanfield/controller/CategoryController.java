package com.chaos.stanfield.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.utils.JPAInitEMF;

@Controller

public class CategoryController {

	
	@RequestMapping("/categories")
	public ModelAndView showAllCategories(HttpServletRequest request) {
		   ArrayList<Category> listCategories=new ArrayList<Category>();
		   listCategories=new Category().allCategories();
		   return new ModelAndView("category/list", "listCategories", listCategories);
	}
	
	   
	   
	 @RequestMapping("/deleteCategory")
	 public ModelAndView deleteCategory(HttpServletRequest request) {
		   String id=request.getParameter("id");
		   Category category=new Category();
		   category.setId(Long.parseLong(id));
		   JPAInitEMF jpa=new JPAInitEMF();
		   category=jpa.getEm().find(Category.class, category.getId());
		   jpa.deleteEntity(category);
		   ArrayList<Category> listCategories=new ArrayList<Category>();
		   listCategories=new Category().allCategories();
		   return new ModelAndView("category/list", "listCategories", listCategories);
	   }
	
	  
     @RequestMapping("/editCategory")
		 public ModelAndView editCategory(HttpServletRequest request) {
			   String id=request.getParameter("id");
			   Category category=new Category();
			   category.setId(Long.parseLong(id));
			   JPAInitEMF jpa=new JPAInitEMF();
			   category=jpa.getEm().find(Category.class, category.getId());
			   return new ModelAndView("category/edit", "category", category);
	}
	
     
     @RequestMapping("/updateCategory")
	 public ModelAndView updateCategory(HttpServletRequest request) {
		   Category category=new Category();
		   JPAInitEMF jpa=new JPAInitEMF();
		   category.setId(Long.parseLong(request.getParameter("id")));
		   category=jpa.getEm().find(Category.class, category.getId());
		   category.setName(request.getParameter("name"));
		   category.setDescription(request.getParameter("description"));
		   jpa.updateEntity(category);
		   ArrayList<Category> listCategories=new ArrayList<Category>();
		   listCategories=new Category().allCategories();
		   
		   return new ModelAndView("category/list", "listCategories", listCategories);
    }
	
     @RequestMapping("/addCategory")
	 public ModelAndView addCategory(HttpServletRequest request) {
		   Category category=new Category();
		   JPAInitEMF jpa=new JPAInitEMF();
		   category.setName(request.getParameter("name"));
		   category.setDescription(request.getParameter("description"));
		   jpa.InsertEntity(category);
		   ArrayList<Category> listCategories=new ArrayList<Category>();
		   listCategories=new Category().allCategories();
		   return new ModelAndView("category/list", "listCategories", listCategories);
    }
	

 	@RequestMapping("/create-category-form")
 	 public String newCategory(Model model) {
         return "category/create";
     }	
	
}
