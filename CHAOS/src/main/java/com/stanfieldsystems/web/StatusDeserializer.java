package com.stanfieldsystems.web;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.service.api.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = StatusDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Status.class)
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
}
