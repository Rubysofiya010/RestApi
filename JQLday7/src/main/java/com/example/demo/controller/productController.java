package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.productModel;
import com.example.demo.service.productService;

@RestController
public class productController {
@Autowired
public productService tserv;
//get mapping
@GetMapping("/getProduct")
	public List<productModel>getProductInfo()
	{
	return tserv.getProduct();
	}
@PutMapping("/updateProduct")
public productModel updateProductInfo(@RequestBody productModel ca)
{
	return tserv.updateProduct(ca);
}
//get all the data
@GetMapping("/getAllrows")
public List<productModel> getAllrows()
{
	 return tserv.getAllrows();
}
//get specific data
@GetMapping("/getSpecific/{cat}/{name}")
public List<productModel> getSpecrows(@PathVariable("cat") String cat,@PathVariable("name") String name)
{
	 return tserv.getSpecrows(cat, name);
}
//delete
@DeleteMapping("/deleteRow/{id}")
public String deleteRow(@PathVariable("id") int id) {
	 return tserv.deleteRowByid(id)+" id deleted";
}

//update
@PutMapping("/updateId/{cat}/{id}")
public String updateInfo(@PathVariable("cat") String cat,@PathVariable("id") int id)
{
	 return tserv.updateRow(cat, id)+" rows are updated";
}
//JQL query
@GetMapping("getjql/{name}")
public List<productModel>getByname(@PathVariable("name")String name){
	return tserv.getByname(name);
}
}
