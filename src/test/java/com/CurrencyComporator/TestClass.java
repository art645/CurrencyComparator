package com.CurrencyComporator;

import com.CurrencyComporator.controller.CurrencyComporatorController;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestClass {


    private CurrencyComporatorController currencyComporatorController = new CurrencyComporatorController();

    @Test
    public void test_getUrlPath(){
        String url = "https://media3.giphy.com/media/YR8koF8LPekQUZRKL6/200_d.gif";
        String urlPath = "YR8koF8LPekQUZRKL6";
        assertEquals(currencyComporatorController.getGifIdFromUrl(url),urlPath);
    }
    @Test
    public void test_getYesterdayDate() {
        String date = "2021-02-25";
        assertEquals(date,currencyComporatorController.getYesterdayDate(1614301200));
    }
    @Test
    public void test_convertCurrencyToRub(){
        Map<String,Double> currenciesBaseUSD = new HashMap<>();
        currenciesBaseUSD.put("USD",1.0);
        currenciesBaseUSD.put("RUB",75.0);
        assertEquals(currencyComporatorController.convertCurrencyToRub(currenciesBaseUSD,"USD"),0.013333333333333334);
    }
}
