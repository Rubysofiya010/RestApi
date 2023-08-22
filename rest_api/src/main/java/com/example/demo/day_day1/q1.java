package com.example.demo.day_day1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class q1 {
	@Value("SpringBoot")
	 public String name;
	@RequestMapping("/welcome")
	public String welcome(){
	return "Welcome "+name+"!";
}
}
