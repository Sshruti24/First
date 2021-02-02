package com.examplee.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.MvcResult;

import com.examplee.model.emp;
import com.examplee.repos.emp_repos;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
@WebMvcTest(emp_contoller.class)

public class emp_contollerTest {
	
	@Autowired
	private emp_contoller empc;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private emp_repos emprepo;
	
	
	@Test
	void listAllEmp() throws Exception
	{
		List<emp> listEmp = new ArrayList<>();
		
		
		Mockito.when(emprepo.findAll()).thenReturn(listEmp);
		listEmp.add(new emp("abcd", "pqrs",1));
		listEmp.add(new emp("asdf","tryu",2));
		
		String url ="/emps";
		
	MvcResult mvcResult= mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
	
	String actualJsonResponse = mvcResult.getResponse().getContentAsString();
	System.out.println(actualJsonResponse);
	
	String expectedJsonResponse = objectMapper.writeValueAsString(listEmp);
	assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
		
	}
	
	
	
	

}
