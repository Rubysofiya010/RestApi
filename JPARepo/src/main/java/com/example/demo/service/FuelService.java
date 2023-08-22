package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.day4.d4;
import com.example.demo.day4.repository.FuelRepo;

@Service
public class FuelService {
	@Autowired
	FuelRepo frepo;
	
	public d4 saveDetails(d4 d)
	{
		return frepo.save(d);
	}
	
	public List<d4> getDetails()
	{
		return frepo.findAll();
	}

}