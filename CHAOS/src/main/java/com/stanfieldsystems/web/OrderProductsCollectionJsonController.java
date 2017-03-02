package com.stanfieldsystems.web;
import com.stanfieldsystems.OrderProduct;
import org.springframework.stereotype.Controller;
import com.stanfieldsystems.service.api.OrderProductService;
import io.springlets.data.domain.GlobalSearch;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = OrderProductsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = OrderProduct.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
//@RooJSON

@RestController
@RequestMapping(value = "/api/orderproducts", name = "OrderProductsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderProductsCollectionJsonController {

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
    public OrderProductsCollectionJsonController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<OrderProduct>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<OrderProduct> orderProducts = orderProductService.findAll(globalSearch, pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(orderProducts);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(OrderProductsCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProduct
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody OrderProduct orderProduct, BindingResult result) {
        if (orderProduct.getId() != null || orderProduct.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        OrderProduct newOrderProduct = orderProductService.save(orderProduct);
        UriComponents showURI = OrderProductsItemJsonController.showURI(newOrderProduct);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProducts
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<OrderProduct> orderProducts, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        orderProductService.save(orderProducts);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProducts
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<OrderProduct> orderProducts, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        orderProductService.save(orderProducts);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        orderProductService.delete(ids);
        return ResponseEntity.ok().build();
    }
}
