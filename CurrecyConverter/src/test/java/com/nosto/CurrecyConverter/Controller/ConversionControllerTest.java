package com.nosto.CurrecyConverter.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosto.CurrecyConverter.Entity.ConversionEntity;
import com.nosto.CurrecyConverter.Entity.ResponseEntity;
import com.nosto.CurrecyConverter.Service.ConverterService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConversionControllerTest {

    @InjectMocks
    private ConversionController conversionController;

    @Mock
    private ConverterService converterService;



    private ConversionEntity conversionEntity=null;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
        conversionEntity = mock(ConversionEntity.class);
         conversionEntity.setSourceCurrency("EUR");
         conversionEntity.setTargetCurrency("GBP");
         conversionEntity.setMonetaryValue("20");
        when(converterService.convert(conversionEntity)).thenReturn(10.11);

    }

    @Test
    public void convert() throws Exception {
      ResponseEntity responseEntity=  conversionController.convert(conversionEntity);
      String value="10.11";
      Assert.assertEquals(responseEntity.getConvertedValue().toString(),value);
    }


}
