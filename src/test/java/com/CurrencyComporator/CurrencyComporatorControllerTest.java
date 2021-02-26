package com.CurrencyComporator;

import com.CurrencyComporator.controller.CurrencyComporatorController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.CurrencyComporator.service.CurrencyComporatorServiceProxy;
import com.CurrencyComporator.service.GifServiceProxy;
import com.CurrencyComporator.service.GiphyServiceProxy;;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@WebMvcTest(CurrencyComporatorController.class)
public class CurrencyComporatorControllerTest {

    @MockBean
    private CurrencyComporatorServiceProxy currencyProxy;
    @MockBean
    private GifServiceProxy gifProxy;
    @MockBean
    private GiphyServiceProxy giphyProxy;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    CurrencyComporatorController currencyComporatorController;

    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(currencyComporatorController).build();
    }

    @Test
    public void testReturn200AndContentType() throws Exception {
        this.mockMvc.perform(get("/compare-currency-excgange/charcode/{USD}","USD"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_GIF));
    }

}

