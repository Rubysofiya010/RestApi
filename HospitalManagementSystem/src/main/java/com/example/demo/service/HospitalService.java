package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.HospitalModel;
import com.example.demo.repository.HospitalRepository;
@Service
public class HospitalService {
@Autowired
public HospitalRepository hrepo;
public String saveHospital(HospitalModel h) {
	hrepo.save(h);
	return "Data is saved to database";
}
public List<HospitalModel> getHospital1(){
	return hrepo.findAll();
}
public HospitalModel updateHospital1(HospitalModel hm) {
	return hrepo.saveAndFlush(hm);
}
public boolean updateHospitalif(int HospitalId,HospitalModel hm) {
	if(hrepo.existsById(HospitalId)) {
		hrepo.save(hm);
		return true;
	}
	return false;
}
public boolean deleteHospitalif(int hospitalId) {
	if(hrepo.existsById(hospitalId)) {
		hrepo.deleteById(hospitalId);
		return true;
	}
	return false;
}
public void deleteHospital(int Hospital_id) {
	System.out.println("Deleted");
	hrepo.deleteById(Hospital_id);
}
public Optional<HospitalModel> getUserId(int userId){
	Optional<HospitalModel>hospital=hrepo.findById(userId);
	if(hospital.isPresent()) {
		return hospital;
	}
	return null;
}
public HospitalModel updateHospital(HospitalModel ha) {
	
	return null;
}
public List<HospitalModel> getHospital() {
	
	return null;
}

}
