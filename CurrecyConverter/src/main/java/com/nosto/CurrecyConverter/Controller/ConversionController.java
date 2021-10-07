package com.nosto.CurrecyConverter.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nosto.CurrecyConverter.Entity.ConversionEntity;
import com.nosto.CurrecyConverter.Exception.CurrencyNotFoundException;
import com.nosto.CurrecyConverter.Service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    @Autowired
    private ConverterService converterService;

    @GetMapping
    public Object convert(@RequestBody ConversionEntity conversionEntity) throws Exception {
        try {
            return converterService.convert(conversionEntity);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
