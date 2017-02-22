package com.stanfieldsystems.web;
import com.stanfieldsystems.Category;
import com.stanfieldsystems.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = CategoryDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Category.class)
public class CategoryDeserializer extends JsonObjectDeserializer<Category> {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public CategoryService categoryService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryService
     * @param conversionService
     */
    @Autowired
    public CategoryDeserializer(CategoryService categoryService, ConversionService conversionService) {
        this.categoryService = categoryService;
        this.conversionService = conversionService;
    }
}
