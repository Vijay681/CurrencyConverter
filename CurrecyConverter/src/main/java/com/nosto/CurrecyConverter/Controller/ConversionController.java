package com.nosto.CurrecyConverter.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nosto.CurrecyConverter.Entity.ConversionEntity;
import com.nosto.CurrecyConverter.Entity.ResponseEntity;
import com.nosto.CurrecyConverter.Exception.CurrencyNotFoundException;
import com.nosto.CurrecyConverter.Service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/v1")
public class ConversionController {

    @Autowired
    private ConverterService converterService;

    @GetMapping("/convert")
    public ResponseEntity convert(@RequestBody ConversionEntity conversionEntity) throws Exception {
        try {
            return new ResponseEntity(converterService.convert(conversionEntity), Date.valueOf(LocalDate.now()), HttpStatus.OK);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
