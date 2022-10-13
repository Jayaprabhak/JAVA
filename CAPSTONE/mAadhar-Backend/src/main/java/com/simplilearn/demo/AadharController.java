package com.simplilearn.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maadhar")
@CrossOrigin(origins = "http://localhost:63931/")
public class AadharController {

	@Autowired
	private AadharService service;
	
	@PostMapping("/applyAadhar")
	public Aadhar applyforAadhar(@RequestBody Aadhar aadhar) {
		return service.applyAadhar(aadhar);
	}
	
	@GetMapping("/getMyAadhar/{aadharnumber}")
	public Aadhar getAadharByNumber(@PathVariable String aadharnumber){
		System.out.println(aadharnumber);
		return service.getAadharByNumber(aadharnumber);
	}

	@GetMapping("/getAllAadhar")
	public  List<Aadhar> getAllAadhar(){
		return service.getAllAadhar();
	}
	
	@PutMapping("/updateAadhar/{number}")
	public Aadhar updateAadhar(@RequestBody Aadhar aadhar,@PathVariable String number){
		return service.updateAadhar(number,aadhar);	
	}
	
	@DeleteMapping("/deleteAadhar/{number}")
	public ResponseEntity<Object> deleteUser(@PathVariable  String number ){
		
		if(service.deleteAadhar(number))
			return new ResponseEntity<Object>("Aadhar Deleted", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Aadhar Found",HttpStatus.NOT_FOUND);
	}
	
}
