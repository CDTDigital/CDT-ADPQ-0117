package com.stanfieldsystems.web;
import com.stanfieldsystems.Category;
import com.stanfieldsystems.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = CategoryDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooDeserializer(entity = Category.class)
@JsonComponent
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Category
     */
    public Category deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Category category = categoryService.findOne(id);
        if (category == null) {
            throw new NotFoundException("Category not found");
        }
        return category;
    }
}
