package com.nosto.CurrecyConverter.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nosto.CurrecyConverter.Entity.ConversionEntity;

public interface ConverterService {

    public Double convert(ConversionEntity conversionEntity) throws Exception;
}
