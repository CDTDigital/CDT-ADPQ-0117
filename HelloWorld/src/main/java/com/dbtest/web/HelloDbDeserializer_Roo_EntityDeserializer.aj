// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.dbtest.web;

import com.dbtest.HelloDb;
import com.dbtest.web.HelloDbDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;

privileged aspect HelloDbDeserializer_Roo_EntityDeserializer {
    
    declare @type: HelloDbDeserializer: @JsonComponent;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return HelloDb
     * @throws IOException
     */
    public HelloDb HelloDbDeserializer.deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        HelloDb helloDb = helloDbService.findOne(id);
        if (helloDb == null) {
            throw new NotFoundException("HelloDb not found");
        }
        return helloDb;
    }
    
}
