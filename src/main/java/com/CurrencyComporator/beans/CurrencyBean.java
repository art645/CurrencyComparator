package com.CurrencyComporator.beans;

import java.util.List;
import java.util.Map;

public class CurrencyBean {

    private String base;
    private Map<String,Double> rates;
    private Integer timestamp;

    public CurrencyBean() {
    }

    public CurrencyBean(String base, Map<String, Double> rates, Integer timestamp) {
        this.base = base;
        this.rates = rates;
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestap(Integer timestamp) {
        this.timestamp = timestamp;
    }
}
