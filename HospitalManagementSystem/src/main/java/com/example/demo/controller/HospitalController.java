package com.example.demo.controller;

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

import com.example.demo.Model.HospitalModel;
import com.example.demo.service.HospitalService;

@RestController
public class HospitalController {
	@Autowired
	public HospitalService hserv;
		@PostMapping("/postHospital")
		public String postHospital(@RequestBody HospitalModel hr) {
			hserv.saveHospital(hr);
			return "data saved";
		}
		@GetMapping("/getHospital")
		public List<HospitalModel> getHospitalInfo(){
			return hserv.getHospital1();
		}
		@GetMapping("/users/{userId}")
		public ResponseEntity<?> getUserbyId(@PathVariable int userId){
			Optional<HospitalModel>hospital=hserv.getUserId(userId);
			if(hospital!=null) {
				return ResponseEntity.ok(hospital);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID"+userId);
		}
		@PutMapping("/updateHospital")
		public HospitalModel updateHospitalInfo(@RequestBody HospitalModel ha) {
			return hserv.updateHospital1(ha);
		}
		@PutMapping("/updateHospitalif/{id}")
		public ResponseEntity<String>putHospitalInfo(@PathVariable int id,@RequestBody HospitalModel ha){
			boolean updated=hserv.updateHospitalif(id,ha);
			if(updated) {
				return ResponseEntity.ok("Patient with id "+id+" is updated");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not exist with id: "+id);
			}
		}
		@DeleteMapping("/deleteHospital/{id}")
		public String removeHospital(@PathVariable("id") int hid) {
			hserv.deleteHospitalif(hid);
			return "Patient with id "+hid+" is deleted";
		}
		@DeleteMapping("/byRegParm")
		public String removeByRequestPam(@RequestParam("id") int id) {
			hserv.deleteHospitalif(id);
			return "Patient with id "+id+" is deleted";
		}
		@DeleteMapping("/deleteHospitalif/{id}")
		public ResponseEntity<String>deleteHospitalInfo(@PathVariable int id){
			boolean deleted=hserv.deleteHospitalif(id);
			if(deleted) {
				return ResponseEntity.ok("Patient with ID "+ id+ " deleted successfully");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient with ID does not exists");
			}
		
	
	
}
}
