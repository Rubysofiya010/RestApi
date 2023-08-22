package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.day4.d4;
import com.example.demo.service.FuelService;

@RestController
public class FuelController {
	
	@Autowired
	FuelService fser;
	@PostMapping("/saveFuel")
	public d4 saveFuelStationDe(@RequestBody d4 d)
	{
		return fser.saveDetails(d);
	}
	@GetMapping("/getFuel")
	public List<d4>getFuelStationDe()
	{
		return fser.getDetails();
	}

}