package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.day5.model.HotelModel;
import com.example.demo.repository.HotelRepo;
@Service
public class HotelService {
@Autowired
public HotelRepo hrepo;
public String saveHotel(HotelModel h) {
	hrepo.save(h);
	return "Data is saved to database";
}
public List<HotelModel> getHotel(){
	return hrepo.findAll();
}
public HotelModel updateHotel(HotelModel hm) {
	return hrepo.saveAndFlush(hm);
}
public boolean updateHotelif(int hotelId,HotelModel hm) {
	if(hrepo.existsById(hotelId)) {
		hrepo.save(hm);
		return true;
	}
	return false;
}
public boolean deleteHotelif(int hotelId) {
	if(hrepo.existsById(hotelId)) {
		hrepo.deleteById(hotelId);
		return true;
	}
	return false;
}
public void deleteHotel(int hotel_id) {
	System.out.println("Deleted");
	hrepo.deleteById(hotel_id);
}
public Optional<HotelModel> getUserId(int userId){
	Optional<HotelModel>hotel=hrepo.findById(userId);
	if(hotel.isPresent()) {
		return hotel;
	}
	return null;
}

}
