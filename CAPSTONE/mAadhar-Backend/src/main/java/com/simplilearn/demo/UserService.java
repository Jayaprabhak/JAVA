package com.simplilearn.demo;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64enocder = Base64.getUrlEncoder();
	
    public User register(User user) {
    	if(checkUserExist(user)==true)
    		return null;
    	user.setToken(generateToken());
    	return repo.save(user);
    }
    
    private String generateToken() {
    	byte[] token = new byte[24];
    	secureRandom.nextBytes(token);
    	return base64enocder.encodeToString(token);
    }
    
    private boolean checkUserExist(User user) {
    	User existingUser = repo.findByUsername(user.getUsername());
    	if(existingUser == null)
    		return false;
    	return true;
    }
    
    public ResponseEntity<?> login(User user) {
    	User existingUser = repo.findByUsername(user.getUsername());
    	if(existingUser.getUsername().equals(user.getUsername()) && 
    			existingUser.getPassword().equals(user.getPassword()) &&
    			existingUser.getRole().equals(user.getRole())) {
    		//existingUser.setPassword("");
    		//return existingUser;
    		return ResponseEntity.ok(existingUser);
    	}
    	return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }
    
}
