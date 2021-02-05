package com.example1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example1.model.Details;
import com.example1.repo.details_repo;



@RestController
@RequestMapping("/api/v1")

public class DetailsController {
	
	
		
		@Autowired
		private  details_repo detailsrepo;
		
		
		
		@GetMapping("/details")
		public List<Details> getAllemp()
		{
			return detailsrepo.findAll();
			
		}
		
		 @PostMapping("/details")
		    public Details createemp( @RequestBody Details data)
		 {
		        return detailsrepo.save(data);
		 }
		 
		  RestTemplate restTemplate = new RestTemplate();
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    Details data = new Details();
		    HttpEntity<?> entity = new HttpEntity<Object>(data,headers);
		    ResponseEntity<Object> responseEntity =    restTemplate.exchange("url", HttpMethod.POST, entity, Object.class);

}
