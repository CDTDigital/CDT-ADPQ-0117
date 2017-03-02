package com.stanfieldsystems.web;
import com.stanfieldsystems.Category;

import com.stanfieldsystems.Product;
import com.stanfieldsystems.service.api.CategoryService;
import com.stanfieldsystems.service.api.ProductService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesData;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

/**
 * = CategoriesItemProductsThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = Category.class, type = ControllerType.DETAIL)
//@RooDetail(relationField = "products")
//@RooThymeleaf
@Controller
@RequestMapping(value = "/categories/{category}/products", name = "CategoriesItemProductsThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CategoriesItemProductsThymeleafController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public MessageSource messageSource;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public CategoryService categoryService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryService
     * @param productService
     * @param messageSource
     */
    @Autowired
    public CategoriesItemProductsThymeleafController(CategoryService categoryService, ProductService productService, MessageSource messageSource) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Category
     */
    @ModelAttribute
    public Category getCategory(@PathVariable("category") Long id) {
        Category category = categoryService.findOne(id);
        if (category == null) {
            throw new NotFoundException(String.format("Category with identifier '%s' not found", id));
        }
        return category;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<DatatablesData<Product>> datatables(@ModelAttribute Category category, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Product> products = productService.findByCategory(category, search, pageable);
        long totalProductsCount = productService.countByCategory(category);
        DatatablesData<Product> data = new DatatablesData<Product>(products, totalProductsCount, draw);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param Category
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Category Category, Model model) {
        populateForm(model);
        model.addAttribute(new Product());
        return new ModelAndView("categories/products/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param productsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromProducts", value = "/{productsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromProducts(@ModelAttribute Category category, @PathVariable("productsToRemove") Long productsToRemove) {
        categoryService.removeFromProducts(category, Collections.singleton(productsToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param products
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Category category, @RequestParam("productsIds") List<Long> products, Model model) {
        // Remove empty values
        for (Iterator<Long> iterator = products.iterator(); iterator.hasNext(); ) {
            if (iterator.next() == null) {
                iterator.remove();
            }
        }
        categoryService.setProducts(category, products);
        UriComponents listURI = CategoriesCollectionThymeleafController.listURI();
        return new ModelAndView("redirect:" + listURI.toUriString());
    }
}
