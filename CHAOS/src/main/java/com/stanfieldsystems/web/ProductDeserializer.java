package com.stanfieldsystems.web;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = ProductDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Product.class)
public class ProductDeserializer extends JsonObjectDeserializer<Product> {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ProductService productService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productService
     * @param conversionService
     */
    @Autowired
    public ProductDeserializer(ProductService productService, ConversionService conversionService) {
        this.productService = productService;
        this.conversionService = conversionService;
    }
}
