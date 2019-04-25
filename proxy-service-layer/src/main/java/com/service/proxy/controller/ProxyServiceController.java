package com.service.proxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.proxy.service.ProxyService;

@RestController
public class ProxyServiceController {
	
	@Autowired
	private ProxyService proxyService;
	
	@RequestMapping("/getdata")
	public String getService(@RequestHeader(value="service") String service) {
		return proxyService.isServicePresent(service)?proxyService.callService(service):"Not available";
	}

}
