package com.example.demo.day_day2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class qn1 {
	@Value("${var}")
	private String name;
	@GetMapping("name")
	public String open() {
		return "Hi Everyone ,I am "+name;
	}
}
