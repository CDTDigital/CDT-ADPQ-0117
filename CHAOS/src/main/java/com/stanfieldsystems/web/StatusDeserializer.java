package com.stanfieldsystems.web;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.service.api.StatusService;
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
 * = StatusDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooDeserializer(entity = Status.class)
@JsonComponent
public class StatusDeserializer extends JsonObjectDeserializer<Status> {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public StatusService statusService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param statusService
     * @param conversionService
     */
    @Autowired
    public StatusDeserializer(StatusService statusService, ConversionService conversionService) {
        this.statusService = statusService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Status
     */
    public Status deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Status status = statusService.findOne(id);
        if (status == null) {
            throw new NotFoundException("Status not found");
        }
        return status;
    }
}
