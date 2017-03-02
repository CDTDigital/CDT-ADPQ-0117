package com.stanfieldsystems.web;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.service.api.OrderProductService;
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
 * = OrderProductDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooDeserializer(entity = OrderProduct.class)
@JsonComponent
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return OrderProduct
     */
    public OrderProduct deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        OrderProduct orderProduct = orderProductService.findOne(id);
        if (orderProduct == null) {
            throw new NotFoundException("OrderProduct not found");
        }
        return orderProduct;
    }
}
