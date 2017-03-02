package com.stanfieldsystems.web;
import com.stanfieldsystems.CustomerOrder;

import org.springframework.stereotype.Controller;

import com.stanfieldsystems.service.api.CustomerOrderService;
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
 * = CustomerOrdersItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = CustomerOrder.class, pathPrefix = "/api", type = ControllerType.ITEM)
//@RooJSON

@RestController
@RequestMapping(value = "/api/customerorders/{customerOrder}", name = "CustomerOrdersItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerOrdersItemJsonController {

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
    public CustomerOrdersItemJsonController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerOrder
     */
    @ModelAttribute
    public CustomerOrder getCustomerOrder(@PathVariable("customerOrder") Long id) {
        CustomerOrder customerOrder = customerOrderService.findOne(id);
        if (customerOrder == null) {
            throw new NotFoundException(String.format("CustomerOrder with identifier '%s' not found", id));
        }
        return customerOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute CustomerOrder customerOrder) {
        return ResponseEntity.status(HttpStatus.FOUND).body(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return UriComponents
     */
    public static UriComponents showURI(CustomerOrder customerOrder) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CustomerOrdersItemJsonController.class).show(customerOrder)).buildAndExpand(customerOrder.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedCustomerOrder
     * @param customerOrder
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute CustomerOrder storedCustomerOrder, @Valid @RequestBody CustomerOrder customerOrder, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        customerOrder.setId(storedCustomerOrder.getId());
        customerOrderService.save(customerOrder);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute CustomerOrder customerOrder) {
        customerOrderService.delete(customerOrder);
        return ResponseEntity.ok().build();
    }
}
