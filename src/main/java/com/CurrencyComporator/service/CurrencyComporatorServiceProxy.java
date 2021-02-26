package com.CurrencyComporator.service;

import com.CurrencyComporator.beans.CurrencyBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="exchange-service", url = "https://openexchangerates.org/api")
public interface CurrencyComporatorServiceProxy {

    @GetMapping("/historical/{date}.json?app_id=0c2ec335ca8140ea8b581df9f94e4792")
    public CurrencyBean retrieveYesterdayCurrencies (@PathVariable("date") String date);
    @GetMapping("/latest.json?app_id=0c2ec335ca8140ea8b581df9f94e4792")
    public CurrencyBean retrieveLatestCurrencies();
}

