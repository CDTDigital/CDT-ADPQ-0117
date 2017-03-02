package com.stanfieldsystems.web;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.service.api.CustomerOrderService;
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
 * = CustomerOrderDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooDeserializer(entity = CustomerOrder.class)
@JsonComponent
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return CustomerOrder
     */
    public CustomerOrder deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        CustomerOrder customerOrder = customerOrderService.findOne(id);
        if (customerOrder == null) {
            throw new NotFoundException("CustomerOrder not found");
        }
        return customerOrder;
    }
}
