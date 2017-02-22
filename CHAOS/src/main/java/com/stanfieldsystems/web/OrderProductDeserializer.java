package com.stanfieldsystems.web;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.service.api.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = OrderProductDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = OrderProduct.class)
public class OrderProductDeserializer extends JsonObjectDeserializer<OrderProduct> {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public OrderProductService orderProductService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderProductService
     * @param conversionService
     */
    @Autowired
    public OrderProductDeserializer(OrderProductService orderProductService, ConversionService conversionService) {
        this.orderProductService = orderProductService;
        this.conversionService = conversionService;
    }
}
