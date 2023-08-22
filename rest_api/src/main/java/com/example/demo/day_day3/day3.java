package com.example.demo.day_day3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class day3 {
	@Value("1")
	public int id;
	@Value("Sofi")
	public String name;
	@Value("20")
	public int age;
	@Value("200000")
	public long salary;
	@RequestMapping("/day")
	public String day() {
		return id+"-"+name+"-"+age+"-"+salary;
	}
}
