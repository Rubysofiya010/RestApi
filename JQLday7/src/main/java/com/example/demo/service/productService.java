package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.productModel;
import com.example.demo.repository.productRepo;
@Service
public class productService {
@Autowired
public productRepo trepo;
public List<productModel> getProduct(){
	return trepo.findAll();
}
public productModel updateProduct(productModel hm) {
	return trepo.saveAndFlush(hm);
}
//get all the data
	public List<productModel> getAllrows()
	{
		return trepo.getAllrows();
	}
	
	//get specific rows
	public List<productModel> getSpecrows(String cat,String name)
	{
		return trepo.getSpecrows(cat, name);
	}
	//delete the data
	public int deleteRowByid(int id) {
		return trepo.deleteId(id);
	}
	//update the data
	public Integer updateRow(String cat,int id) {
		return trepo.updateByid(cat, id);
	}
	//JQL query
	public List<productModel> getByname(String name){
		return trepo.getByname(name);
	}
	


}