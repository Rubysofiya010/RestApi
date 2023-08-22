package com.example.demo.day5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.day5.model.HotelModel;
import com.example.demo.service.HotelService;

@RestController
	public class HotelController {
		@Autowired
	public HotelService hserv;
		@PostMapping("/postHotel")
		public String postHotel(@RequestBody HotelModel hr) {
			hserv.saveHotel(hr);
			return "data saved";
		}
		@GetMapping("/getHotel")
		public List<HotelModel> getHotelInfo(){
			return hserv.getHotel();
		}
		@GetMapping("/users/{userId}")
		public ResponseEntity<?> getUserbyId(@PathVariable int userId){
			Optional<HotelModel>hotel=hserv.getUserId(userId);
			if(hotel!=null) {
				return ResponseEntity.ok(hotel);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID"+userId);
		}
		@PutMapping("/updateHotel")
		public HotelModel updateHotelInfo(@RequestBody HotelModel ha) {
			return hserv.updateHotel(ha);
		}
		@PutMapping("/updateHotelif/{id}")
		public ResponseEntity<String>putHotelInfo(@PathVariable int id,@RequestBody HotelModel ha){
			boolean updated=hserv.updateHotelif(id,ha);
			if(updated) {
				return ResponseEntity.ok("Hotel with id "+id+" is updated");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel not exist with id: "+id);
			}
		}
		
		//using path variable
		@DeleteMapping("/deleteHotel/{id}")
		public String removeHotel(@PathVariable("id") int hid) {
			hserv.deleteHotel(hid);
			return "Hotel with id "+hid+" is deleted";
		}
		@DeleteMapping("/byRegParm")
		public String removeByRequestPam(@RequestParam("id") int id) {
			hserv.deleteHotel(id);
			return "Hotel with id "+id+" is deleted";
		}
		@DeleteMapping("/deleteHotelif/{id}")
		public ResponseEntity<String>deleteHotelInfo(@PathVariable int id){
			boolean deleted=hserv.deleteHotelif(id);
			if(deleted) {
				return ResponseEntity.ok("Hotel with ID "+ id+ " deleted successfully");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID does not exists");
			}
		
	
	
}
}
