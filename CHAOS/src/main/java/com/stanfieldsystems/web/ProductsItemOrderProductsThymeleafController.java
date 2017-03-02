package com.stanfieldsystems.web;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.service.api.OrderProductService;
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
 * = ProductsItemOrderProductsThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = Product.class, type = ControllerType.DETAIL)
//@RooDetail(relationField = "orderProducts")
//@RooThymeleaf
@Controller
@RequestMapping(value = "/products/{product}/orderProducts", name = "ProductsItemOrderProductsThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class ProductsItemOrderProductsThymeleafController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public OrderProductService orderProductService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public MessageSource messageSource;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productService
     * @param orderProductService
     * @param messageSource
     */
    @Autowired
    public ProductsItemOrderProductsThymeleafController(ProductService productService, OrderProductService orderProductService, MessageSource messageSource) {
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.messageSource = messageSource;
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
     * @param product
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<DatatablesData<OrderProduct>> datatables(@ModelAttribute Product product, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<OrderProduct> orderProducts = orderProductService.findByProduct(product, search, pageable);
        long totalOrderProductsCount = orderProductService.countByProduct(product);
        DatatablesData<OrderProduct> data = new DatatablesData<OrderProduct>(orderProducts, totalOrderProductsCount, draw);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param Product
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Product Product, Model model) {
        populateForm(model);
        model.addAttribute(new OrderProduct());
        return new ModelAndView("products/orderProducts/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderProductsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromOrderProducts", value = "/{orderProductsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromOrderProducts(@ModelAttribute Product product, @PathVariable("orderProductsToRemove") Long orderProductsToRemove) {
        productService.removeFromOrderProducts(product, Collections.singleton(orderProductsToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderProducts
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Product product, @RequestParam("orderProductsIds") List<Long> orderProducts, Model model) {
        // Remove empty values
        for (Iterator<Long> iterator = orderProducts.iterator(); iterator.hasNext(); ) {
            if (iterator.next() == null) {
                iterator.remove();
            }
        }
        productService.setOrderProducts(product, orderProducts);
        UriComponents listURI = ProductsCollectionThymeleafController.listURI();
        return new ModelAndView("redirect:" + listURI.toUriString());
    }
}
