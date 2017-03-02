package com.stanfieldsystems.web;
import com.stanfieldsystems.OrderProduct;
import org.springframework.stereotype.Controller;
import com.stanfieldsystems.service.api.OrderProductService;
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
 * = OrderProductsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = OrderProduct.class, pathPrefix = "/api", type = ControllerType.ITEM)
//@RooJSON
@RestController
@RequestMapping(value = "/api/orderproducts/{orderProduct}", name = "OrderProductsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderProductsItemJsonController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public OrderProductService orderProductService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderProductService
     */
    @Autowired
    public OrderProductsItemJsonController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return OrderProduct
     */
    @ModelAttribute
    public OrderProduct getOrderProduct(@PathVariable("orderProduct") Long id) {
        OrderProduct orderProduct = orderProductService.findOne(id);
        if (orderProduct == null) {
            throw new NotFoundException(String.format("OrderProduct with identifier '%s' not found", id));
        }
        return orderProduct;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProduct
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute OrderProduct orderProduct) {
        return ResponseEntity.status(HttpStatus.FOUND).body(orderProduct);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProduct
     * @return UriComponents
     */
    public static UriComponents showURI(OrderProduct orderProduct) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(OrderProductsItemJsonController.class).show(orderProduct)).buildAndExpand(orderProduct.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedOrderProduct
     * @param orderProduct
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute OrderProduct storedOrderProduct, @Valid @RequestBody OrderProduct orderProduct, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        orderProduct.setId(storedOrderProduct.getId());
        orderProductService.save(orderProduct);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProduct
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute OrderProduct orderProduct) {
        orderProductService.delete(orderProduct);
        return ResponseEntity.ok().build();
    }
}
