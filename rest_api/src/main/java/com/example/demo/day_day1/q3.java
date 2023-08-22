package com.example.demo.day_day1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class q3 {
	@Value("Blue")
	 public String name;
	@RequestMapping("/colour")
	public String colour(){
	return "My Favourite colour is "+name;
}
}
