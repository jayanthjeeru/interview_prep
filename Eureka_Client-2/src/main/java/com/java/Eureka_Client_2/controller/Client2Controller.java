package com.java.Eureka_Client_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Client2Controller {

	@Autowired
    private DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/getmessage")
	public String getMessage() {
		
		String res = "this is a message via client-2 :: ";
		
		try {
			List<ServiceInstance> instances = discoveryClient.getInstances("EUREKACLIENT1");
			
			 if (instances != null && !instances.isEmpty()) {
		            String serviceUri = instances.get(0).getUri().toString() + "/getmessage";
		            System.out.println(serviceUri);
		            res = res + restTemplate.getForObject(serviceUri, String.class);
		        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return res;
	}
	
	
}
