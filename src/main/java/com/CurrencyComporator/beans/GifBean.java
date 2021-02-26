package com.CurrencyComporator.beans;


import java.util.Map;

public class GifBean {

    private Map<String,Object> data;
    private String gifUrl;

    public GifBean() {
    }

    public GifBean(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public GifBean(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }
}
