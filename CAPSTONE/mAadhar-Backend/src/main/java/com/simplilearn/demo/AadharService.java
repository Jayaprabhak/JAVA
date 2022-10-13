package com.simplilearn.demo;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AadharService {

	@Autowired
	private AadharRepo repo;
	
	public Aadhar applyAadhar(Aadhar aadhar) {
    	aadhar.setAadharnumber(set());
    	return repo.save(aadhar);
    }

	private String set() {
		long smallest = 7000_0000_0000_0000L;
	    long biggest =  9999_9999_9999_9999L;
	    long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
	    String number = String.valueOf(random);
		return number;
	}
	
	public Aadhar getAadharByNumber(String aadharnumber) {
		System.out.println(aadharnumber);
		if( (repo.findByAadharnumber(aadharnumber)).isPresent()) {
			return repo.findByAadharnumber(aadharnumber).get();
		}
		else {
			System.out.println("null");
			return null;
		}
		
	}
	
	

	public List<Aadhar> getAllAadhar(){
		return repo.findAll();
	}
	
	public Aadhar updateAadhar(String number, Aadhar newAadhar) {
		if(repo.findByAadharnumber(number).isPresent()) {
			Aadhar oldAadhar= repo.findByAadharnumber(number).get();
			oldAadhar.setName(newAadhar.getName());
			oldAadhar.setDob(newAadhar.getDob());
			oldAadhar.setGender(newAadhar.getGender());
			oldAadhar.setMobilenumber(newAadhar.getMobilenumber());
			oldAadhar.setHousenumber(newAadhar.getHousenumber());
			oldAadhar.setStreet(newAadhar.getStreet());
			oldAadhar.setDistrict(newAadhar.getDistrict());
			oldAadhar.setState(newAadhar.getState());
			oldAadhar.setPincode(newAadhar.getPincode());
			return repo.save(oldAadhar);
		}
		else {
			return null;
		}
	}
	
	public boolean deleteAadhar(String number) {
		if(repo.findByAadharnumber(number).isPresent()) {
			repo.deleteByAadharnumber(number);
			return true;
		}
		
		else {
			return false;
		}
	}
	
	

	
}
