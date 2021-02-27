package com.CurrencyComporator.controller;

import com.CurrencyComporator.beans.CurrencyBean;
import com.CurrencyComporator.beans.GifBean;
import com.CurrencyComporator.service.CurrencyComporatorServiceProxy;
import com.CurrencyComporator.service.GifServiceProxy;
import com.CurrencyComporator.service.GiphyServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
public class CurrencyComporatorController {

    @Autowired
    private CurrencyComporatorServiceProxy currencyProxy;
    @Autowired
    private GiphyServiceProxy giphyProxy;
    @Autowired
    private GifServiceProxy gifProxy;


    @GetMapping(value = "/compare-currency-excgange/charcode/{name}")
    public ResponseEntity<InputStreamResource> getGifByCurrencyChanges(@PathVariable String name) throws IOException {
        String query = getQueryGifPath(name);
        System.out.println(query);
        if (query.equals("")) {return  null;}
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_GIF)
                .body(new InputStreamResource(getResourceWithGif(query).getInputStream()));
    }

    public String getQueryGifPath(String name) {
        String gifQuery = compareCurrency(name);
        return  gifQuery;
    }
    public String compareCurrency(String name) {
        CurrencyBean responseLatest = currencyProxy.retrieveLatestCurrencies();
        String yesterdayDate = getYesterdayDate(responseLatest.getTimestamp());
        CurrencyBean responseYesterday = currencyProxy.retrieveYesterdayCurrencies(yesterdayDate);
        Map<String,Double> todayExchangeRates = responseLatest.getRates();
        if(!(todayExchangeRates.containsKey(name.toUpperCase()))) {return "";}
        Map<String,Double> yesterdayExchangeRates = responseYesterday.getRates();
        double todayCurrencyAmount = convertCurrencyToRub(todayExchangeRates,name);
        double yesterdayCurrencyAmount = convertCurrencyToRub(yesterdayExchangeRates,name);
        double changingRate = todayCurrencyAmount - yesterdayCurrencyAmount;
        if (changingRate > 0) {
            return  "rich";
        }
        else if (changingRate < 0) {
            return  "broke";
        }
        return  "";
    }

    public Resource getResourceWithGif(String query) {
        GifBean gifBean = giphyProxy.retrieveRandomGif(query);
        Map <String,Object> dataMap = gifBean.getData();
        String url = dataMap.get("image_url").toString();
        Resource resource = gifProxy.retrieveGifImage(getGifIdFromUrl(url));
        return resource;
    }

    public double convertCurrencyToRub(Map <String,Double> exchangeRates, String name) {
        if (name.equals("RUB")) {return 1.0;}
        return 1 / exchangeRates.get(name.toUpperCase())*exchangeRates.get("RUB");
    }

    public String getGifIdFromUrl(String url) {
        String [] urlArray = url.split("/");
        return urlArray[4];
    }

    public String getYesterdayDate(int timestamp) {
        long timeInMillis = timestamp*1000L;
        Date date = new Date(timeInMillis);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(calendar.getTime()));
        return dateFormat.format(calendar.getTime());
    }
}
