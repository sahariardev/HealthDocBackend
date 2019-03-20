package com.healthDoc.POC.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchService {
	@Value("${app.hostUrl}")
	public String host;
	
	public String searchByDiseaseName(String name)
	{
		RestTemplate restTemplate=new RestTemplate();
		System.out.println(host);
		String dataUrl=host+"/_search?q=name:"+name;
		System.out.println(dataUrl);
		ResponseEntity<String> response = restTemplate.getForEntity(dataUrl, String.class);
		return response.getBody();
	}
	public String searchBySymptoms(ArrayList<String> symptoms) {
		
		RestTemplate restTemplate=new RestTemplate();
		String sym="";
		for(String s:symptoms) {
			sym+=","+s;
		}
		sym=sym.substring(1,sym.length());
		String dataUrl=host+"/_search?q=symptoms:"+sym;
		System.out.println(dataUrl);
		ResponseEntity<String> response = restTemplate.getForEntity(dataUrl, String.class);
		return response.getBody();
		
	}

}
