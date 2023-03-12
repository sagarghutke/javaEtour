package com.etour.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

//import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.etour.entities.Customer_Master;
import com.etour.repositories.Customer_MasterRepository;

import com.etour.dto.*;

@Service
public class LoginMasterManagerImpl implements LoginMasterManager  
{

	@Autowired
	private Customer_MasterRepository repository;
	
//	@Autowired
//	BCryptPasswordEncoder passwordencoder;
	
public ResponseEntity<LoginResponse> login(LoginRequest request) 
{ 
	String passwordHash = hash256(request.getPassword()); // hash the password using SHA-256
	Customer_Master person = repository.findAll().stream()
			.filter(customer -> customer.getPhonenumber().equals(request.getPhonenumber()) && customer.getPassword().equals(passwordHash))
			.findFirst()
			.orElse(null);
	//System.out.print(person);

	if (person != null && person.getPhonenumber().equals(request.getPhonenumber()) && person.getPassword().equals(passwordHash)) 
	{
			return ResponseEntity.ok().body(new LoginResponse(true, person));
	} 
	else 
	{
		return ResponseEntity.ok().body(new LoginResponse(false, null));
	}
}
private String hash256(String password)
{
	try
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		StringBuilder hexstring = new StringBuilder();
		for(byte b : hash)
		{
			String hex =Integer.toHexString(0xff & b);
			if(hex.length()==1)
				hexstring.append('0');
			hexstring.append(hex);
		}
		return hexstring.toString();
	}
	catch(NoSuchAlgorithmException e)
	{
		throw new RuntimeException(e);
	}
	
	//return null;
}

}
