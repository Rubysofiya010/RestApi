package com.example.demo.day_day1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class q2 {
	@Value("Sofii")
	 public String name;
	@RequestMapping("/name")
	public String name(){
	return "Welcome "+name+"!";
}
}
