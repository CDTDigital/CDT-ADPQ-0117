package com.dbtest.web;
import com.dbtest.HelloDb;
import com.dbtest.service.api.HelloDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = HelloDbDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = HelloDb.class)
public class HelloDbDeserializer extends JsonObjectDeserializer<HelloDb> {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public HelloDbService helloDbService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param helloDbService
     * @param conversionService
     */
    @Autowired
    public HelloDbDeserializer(HelloDbService helloDbService, ConversionService conversionService) {
        this.helloDbService = helloDbService;
        this.conversionService = conversionService;
    }
}
