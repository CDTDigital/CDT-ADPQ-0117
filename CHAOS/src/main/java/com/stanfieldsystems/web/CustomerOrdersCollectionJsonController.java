package com.stanfieldsystems.web;
import com.stanfieldsystems.CustomerOrder;
import org.springframework.stereotype.Controller;
import com.stanfieldsystems.service.api.CustomerOrderService;
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
 * = CustomerOrdersCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = CustomerOrder.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
//@RooJSON

@RestController
@RequestMapping(value = "/api/customerorders", name = "CustomerOrdersCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerOrdersCollectionJsonController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public CustomerOrderService customerOrderService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerOrderService
     */
    @Autowired
    public CustomerOrdersCollectionJsonController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<CustomerOrder>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<CustomerOrder> customerOrders = customerOrderService.findAll(globalSearch, pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(customerOrders);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CustomerOrdersCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody CustomerOrder customerOrder, BindingResult result) {
        if (customerOrder.getId() != null || customerOrder.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        CustomerOrder newCustomerOrder = customerOrderService.save(customerOrder);
        UriComponents showURI = CustomerOrdersItemJsonController.showURI(newCustomerOrder);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrders
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<CustomerOrder> customerOrders, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        customerOrderService.save(customerOrders);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrders
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<CustomerOrder> customerOrders, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        customerOrderService.save(customerOrders);
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
        customerOrderService.delete(ids);
        return ResponseEntity.ok().build();
    }
}
