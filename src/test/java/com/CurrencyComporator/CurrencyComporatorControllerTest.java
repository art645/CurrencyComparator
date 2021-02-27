package com.CurrencyComporator;

import com.CurrencyComporator.beans.CurrencyBean;
import com.CurrencyComporator.controller.CurrencyComporatorController;
import com.CurrencyComporator.service.CurrencyComporatorServiceProxy;
import com.CurrencyComporator.service.GifServiceProxy;
import com.CurrencyComporator.service.GiphyServiceProxy;;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyComporatorControllerTest {

    @InjectMocks
    CurrencyComporatorController currencyComporatorController;
    @Mock
    private CurrencyComporatorServiceProxy currencyProxy;


    @Test
    public void test_compareCurrencyBroke() throws Exception {
        Map<String,Double> todayCurrencies = new HashMap<>();
        todayCurrencies.put("USD",1.0);
        todayCurrencies.put("RUB",75.0);
        Map<String,Double> yesterdayCurrencies = new HashMap<>();
        yesterdayCurrencies.put("USD",1.0);
        yesterdayCurrencies.put("RUB",73.0);
        Mockito.when(currencyProxy.retrieveLatestCurrencies()).thenReturn(new CurrencyBean("USD",todayCurrencies,1614301200));
        Mockito.when(currencyProxy.retrieveYesterdayCurrencies("2021-02-25")).thenReturn(new CurrencyBean("USD",yesterdayCurrencies,1312321));
        Assert.assertEquals(currencyComporatorController.compareCurrency("USD"),"rich");
    }
    @Test
    public void test_compareCurrencyRich() throws Exception {
        Map<String,Double> todayCurrencies = new HashMap<>();
        todayCurrencies.put("USD",1.0);
        todayCurrencies.put("RUB",73.0);
        Map<String,Double> yesterdayCurrencies = new HashMap<>();
        yesterdayCurrencies.put("USD",1.0);
        yesterdayCurrencies.put("RUB",75.0);
        Mockito.when(currencyProxy.retrieveLatestCurrencies()).thenReturn(new CurrencyBean("USD",todayCurrencies,1614301200));
        Mockito.when(currencyProxy.retrieveYesterdayCurrencies("2021-02-25")).thenReturn(new CurrencyBean("USD",yesterdayCurrencies,1312321));
        Assert.assertEquals(currencyComporatorController.compareCurrency("USD"),"broke");
    }
    @Test
    public void test_CompareCurrencyEquals() {
        Map<String,Double> todayCurrencies = new HashMap<>();
        todayCurrencies.put("USD",1.0);
        todayCurrencies.put("RUB",75.0);
        Map<String,Double> yesterdayCurrencies = new HashMap<>();
        yesterdayCurrencies.put("USD",1.0);
        yesterdayCurrencies.put("RUB",75.0);
        Mockito.when(currencyProxy.retrieveLatestCurrencies()).thenReturn(new CurrencyBean("USD",todayCurrencies,1614301200));
        Mockito.when(currencyProxy.retrieveYesterdayCurrencies("2021-02-25")).thenReturn(new CurrencyBean("USD",yesterdayCurrencies,1312321));
        Assert.assertEquals(currencyComporatorController.compareCurrency("USD"),"");
    }
}

