package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.adaptercontroller.CommonControllerService;
import com.example.demo.adaptercontroller.ControllerAdapterService;

@SpringBootApplication
@RestController
public class SomeThingApplication {
	
	@Autowired
	CommonControllerService commonControllerService = null;
	
	@Autowired
	ControllerAdapterService controllerAdapterService = null;

	public static void main(String[] args) {
		SpringApplication.run(SomeThingApplication.class, args);
		
	}
	
	@GetMapping
	public String getmessage() {
		
		System.out.println(commonControllerService.addNode());
		
		System.out.println(controllerAdapterService.superviseNode());
		
		// to create json object
		JSONObject jo = new JSONObject();
		List<String> l =Arrays.asList("hi","bye");
		jo.put("name", "hi");
		jo.put("list", l);
		
		
		String s = "hi my name is " + jo.getString("name") + "my attributes are "+ jo.getJSONArray("list").toString();
		
		System.out.println(s);
		
		System.out.println(jo.toString());
		
		
		String json = "{\"name\":\"jayanth\",\"age\":\"20\"}";
		//=========================to extract values from json=======================
		JSONObject jo1 = new JSONObject(json);
		System.out.println(jo1.get("name"));
		
		
		return jo.getJSONArray("list").toString();
	}

}
