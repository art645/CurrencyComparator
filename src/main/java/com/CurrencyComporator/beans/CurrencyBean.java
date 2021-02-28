package com.CurrencyComporator.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
public class CurrencyBean {

    private String base;
    private Map<String,Double> rates;
    private Integer timestamp;

    public CurrencyBean(String base, Map<String, Double> rates, Integer timestamp) {
        this.base = base;
        this.rates = rates;
        this.timestamp = timestamp;
    }
}
