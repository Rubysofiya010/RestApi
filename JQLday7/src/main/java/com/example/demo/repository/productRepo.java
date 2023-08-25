package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.productModel;

import jakarta.transaction.Transactional;

public interface productRepo extends JpaRepository<productModel, Integer>{
//native query
	@Query(value="select * from Productdetails",nativeQuery = true )
	public List<productModel>getAllrows();

	@Query(value="select * from Productdetails where category=:cat and productname=:name",nativeQuery = true )
	public List<productModel> getSpecrows(@Param("cat") String cat,@Param("name") String name);
//:
	
	@Query("Select h from productModel h where h.productname like %?1%")
	public List<productModel> getByname(@Param("name") String name);
	
//Delete using native query
	@Modifying
	@Transactional
	//@Query(value = "delete from product where product_id=:id",nativeQuery=true)
	@Query("Delete from productModel h where h.productId=:id")
	public int deleteId(@Param("id") int id);
	
//Update the native query
		@Modifying
		@Transactional
		@Query(value="update product set category=:cat where product_id=:id",nativeQuery=true)
		public Integer updateByid(@Param("cat") String cat,@Param("id")int id);
}