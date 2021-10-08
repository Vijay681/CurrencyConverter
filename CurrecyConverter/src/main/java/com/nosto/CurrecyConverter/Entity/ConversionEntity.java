package com.nosto.CurrecyConverter.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionEntity {
    private String sourceCurrency;
    private String targetCurrency;
    private String monetaryValue;

    public ConversionEntity() {
    }

    public ConversionEntity(String sourceCurrency, String targetCurrency, String monetaryValue) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.monetaryValue = monetaryValue;
    }


}
