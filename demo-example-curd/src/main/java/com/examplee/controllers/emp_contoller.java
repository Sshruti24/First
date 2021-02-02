package com.examplee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.examplee.exception.ResourceNotFoundException;
import com.examplee.model.emp;
import com.examplee.repos.emp_repos;



@RestController
@RequestMapping("/api/v1")
public class emp_contoller {
	
	@Autowired
	private emp_repos emprepo;
	
	
	
	@GetMapping("/emps")
	public List<emp> getAllemp()
	{
		return emprepo.findAll();
		
	}
	
	 @PostMapping("/emps")
	    public emp createemp( @RequestBody emp emp)
	 {
	        return emprepo.save(emp);
	 }
	 
	 
	 @PutMapping("/employees/{id}")
	    public ResponseEntity < emp > updateEmployee(@PathVariable(value = "id") Long employeeId,
	        @Validated @RequestBody emp employeeDetails) throws ResourceNotFoundException {
	        emp employee = emprepo.findById(employeeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

	        
	        employee.setLname(employeeDetails.getLname());
	        employee.setFname(employeeDetails.getFname());
	        final emp updatedEmployee = emprepo.save(employee);
	        return ResponseEntity.ok(updatedEmployee);
	    }

	
	
	
	

}
