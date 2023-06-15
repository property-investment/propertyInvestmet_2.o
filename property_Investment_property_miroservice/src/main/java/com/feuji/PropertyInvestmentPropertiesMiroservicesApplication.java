package com.feuji;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PropertyInvestmentPropertiesMiroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyInvestmentPropertiesMiroservicesApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
//	    RestTemplate restTemplate = new RestTemplate();
//	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//	    converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//	    restTemplate.getMessageConverters().add(converter);
	    return new RestTemplate();
	}
	
	
	

}
