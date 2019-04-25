package com.service.proxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.service.proxy.config.DataCofig;
import com.service.proxy.config.MultiService;

@Service
public class ProxyService {
	
	@Autowired
	private MultiService multiService;
	
	public Boolean isServicePresent(String seviceName){
		long i=multiService.getData()
				.stream().
				filter(t->t.getServicename().contains(seviceName))
				.count();
		return i==0?false:true;
	}
	
	/*
	 * 
	 * This Function will be useful to fetch data from
	 * the yml such that the properties are available
	 * as an object of the defined service type.
	 * 
	 * */
	private DataCofig getServiceData(String seviceName){
		return multiService.getData()
				.stream()
				.filter(t->t.getServicename().equalsIgnoreCase(seviceName))
				.findFirst()
				.get();
	}
	
	public String callService(String seviceName) {
		WebClient client3 = WebClient
				  .builder()
				  .baseUrl(getServiceData(seviceName).getHost())
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				  .build();
		return client3.get()
				.retrieve()
				.bodyToMono(String.class).block();
	}

}
