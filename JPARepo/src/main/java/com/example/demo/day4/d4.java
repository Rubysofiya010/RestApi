package com.example.demo.day4;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="d4")

public class d4 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sapCode;
	private String bunkName;
	private String address;
	public int getSapCode() {
		return sapCode;
	}
	public void setSapCode(int sapCode) {
		this.sapCode = sapCode;
	}
	public String getBunkName() {
		return bunkName;
	}
	public void setBunkName(String bunkName) {
		this.bunkName = bunkName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	  
	      



}