package com.healthDoc.POC.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.healthDoc.POC.model.DiseaseData;
@CrossOrigin
@RestController
public class TestController {

	
	//test elasticsearch
	@GetMapping("search/by/symtom/{symtom}")
	public String test(@PathVariable String symtom)
	{	RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://192.168.50.156:9200/_search?q=symptom:"+symtom;
		ResponseEntity<String> response
		  = restTemplate.getForEntity(fooResourceUrl, String.class);
		System.out.println(response.getBody());
		return response.getBody();
	}
	@GetMapping("post/sample/data")
	public String postSample()
	{
		
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://192.168.50.156:9200/disease/dis-sym";
		DiseaseData data=new DiseaseData();
		data.setName("test");
		data.addData("fall");
		data.addData("fall02");
		data=restTemplate.postForObject(fooResourceUrl, data, DiseaseData.class);
		return "";
		
	}
	
	
}
