package com.stanfieldsystems.web;
import com.stanfieldsystems.Category;
//import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
//import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
//import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.stanfieldsystems.service.api.CategoryService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = CategoriesItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = Category.class, type = ControllerType.ITEM)
//@RooThymeleaf
@Controller
@RequestMapping(value = "/categories/{category}", name = "CategoriesItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CategoriesItemThymeleafController {

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
     * TODO Auto-generated constructor documentation
     *
     * @param categoryService
     * @param messageSource
     */
    @Autowired
    public CategoriesItemThymeleafController(CategoryService categoryService, MessageSource messageSource) {
        this.categoryService = categoryService;
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
     * @param category
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Category category, Model model) {
        return new ModelAndView("categories/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @return UriComponents
     */
    public static UriComponents showURI(Category category) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CategoriesItemThymeleafController.class).show(category, null)).buildAndExpand(category.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("category")
    public void initCategoryBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
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
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Category category, Model model) {
        populateForm(model);
        return new ModelAndView("categories/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("categories/edit");
        }
        Category savedCategory = categoryService.save(category);
        UriComponents showURI = CategoriesItemThymeleafController.showURI(savedCategory);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Category category) {
        categoryService.delete(category);
        return ResponseEntity.ok().build();
    }
}
