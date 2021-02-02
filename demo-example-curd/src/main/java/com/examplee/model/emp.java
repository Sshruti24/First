package com.examplee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emps")
public class emp
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	@Column(name="first_name")
	private String fname;
	@Column(name="last_name")
	private String lname;
	

	public emp() {
		super();
	}
	public emp(String fname, String lname, long id) {
		super();
		this.id= id;
		this.fname = fname;
		this.lname = lname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

	}


