package com.stanfieldsystems.web;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.service.api.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = CustomerOrderDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = CustomerOrder.class)
public class CustomerOrderDeserializer extends JsonObjectDeserializer<CustomerOrder> {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public CustomerOrderService customerOrderService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerOrderService
     * @param conversionService
     */
    @Autowired
    public CustomerOrderDeserializer(CustomerOrderService customerOrderService, ConversionService conversionService) {
        this.customerOrderService = customerOrderService;
        this.conversionService = conversionService;
    }
}
