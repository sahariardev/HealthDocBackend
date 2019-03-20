package com.healthDoc.POC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthDoc.POC.service.SearchService;
@CrossOrigin()
@RestController()
@RequestMapping("/api/v1/")
public class SearchController {

     @Autowired
     SearchService searchService;
	
	//search by disease name[single value]
	@GetMapping("/search/by/disease/{name}")
	public String searchByDiseaseName(@PathVariable String name)
	{
		String result=searchService.searchByDiseaseName(name);
		return result;
	}
	//search symptom[multi value]
		//autocomplete
}
