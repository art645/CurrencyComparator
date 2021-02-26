package com.CurrencyComporator.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="gif-service" , url = "https://media2.giphy.com")
public interface GifServiceProxy  {

    @GetMapping("/media/{urlFilePath}/giphy.gif")
    public Resource retrieveGifImage(@PathVariable("urlFilePath") String urlFilePath);
}
