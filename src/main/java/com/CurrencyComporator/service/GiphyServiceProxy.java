package com.CurrencyComporator.service;

import com.CurrencyComporator.beans.GifBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="giphy.com-service", url = "https://api.giphy.com/v1/gifs")
public interface GiphyServiceProxy {
    @GetMapping("/random?api_key=OG3hFuV3wxcehXrel4VWoDVhl7Q8jaoH&tag={query}&rating=r")
    public GifBean retrieveRandomGif (@PathVariable("query") String query);
}
