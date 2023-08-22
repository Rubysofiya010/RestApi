package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.day5.model.HotelModel;

public interface HotelRepo extends JpaRepository<HotelModel,Integer>{

}
