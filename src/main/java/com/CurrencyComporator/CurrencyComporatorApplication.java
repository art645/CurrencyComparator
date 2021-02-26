package com.CurrencyComporator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.CurrencyComporator")
@EnableDiscoveryClient
public class CurrencyComporatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyComporatorApplication.class, args);
	}

}
