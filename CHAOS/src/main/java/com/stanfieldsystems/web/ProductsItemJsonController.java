package com.stanfieldsystems.web;
import com.stanfieldsystems.Product;
import org.springframework.stereotype.Controller;
import com.stanfieldsystems.service.api.ProductService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = ProductsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = Product.class, pathPrefix = "/api", type = ControllerType.ITEM)
//@RooJSON
@RestController
@RequestMapping(value = "/api/products/{product}", name = "ProductsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsItemJsonController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productService
     */
    @Autowired
    public ProductsItemJsonController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Product
     */
    @ModelAttribute
    public Product getProduct(@PathVariable("product") Long id) {
        Product product = productService.findOne(id);
        if (product == null) {
            throw new NotFoundException(String.format("Product with identifier '%s' not found", id));
        }
        return product;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Product product) {
        return ResponseEntity.status(HttpStatus.FOUND).body(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return UriComponents
     */
    public static UriComponents showURI(Product product) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(ProductsItemJsonController.class).show(product)).buildAndExpand(product.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedProduct
     * @param product
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Product storedProduct, @Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        product.setId(storedProduct.getId());
        productService.save(product);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Product product) {
        productService.delete(product);
        return ResponseEntity.ok().build();
    }
}
