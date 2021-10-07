package com.nosto.CurrecyConverter.Service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosto.CurrecyConverter.Entity.ConversionEntity;
import com.nosto.CurrecyConverter.Exception.CurrencyNotFoundException;
import com.nosto.CurrecyConverter.Service.ConverterService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

@Service
@Slf4j
public class ConverterServiceImpl implements ConverterService {

    @Autowired
    ObjectMapper mapper ;
    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${api_key}")
    private String api_key;

    @Override
    public Object convert(ConversionEntity conversionEntity) throws Exception {

        if (!conversionEntity.getSourceCurrency().equals("EUR")) {
            Logger.getAnonymousLogger().info("Only Euro source currency is supported on free subscription plan.");
            throw new Exception("Only Euro source currency is supported on free subscription plan.");
        }
        String url = baseUrl + "?access_key=" + api_key;
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(url, String.class);
        JsonNode jsonNode = mapper.readTree(jsonResponse);
        JsonNode result = jsonNode.get("rates");
        JsonNode targetCurrencyValue = result.get(conversionEntity.getTargetCurrency());
        if (null == targetCurrencyValue)
        {
            Logger.getAnonymousLogger().info("Target currency" + conversionEntity.getTargetCurrency() + " is not a valid currency.");
            throw new CurrencyNotFoundException("Target currency" + conversionEntity.getTargetCurrency() + " is not a valid currency.");
        }
        Double convertedValue = Double.parseDouble(targetCurrencyValue.toString()) * Integer.parseInt(conversionEntity.getMonetaryValue());
        return convertedValue;
    }
}
