package com.etour.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.etour.entities.Cost_Master;
import com.etour.entities.Customer_Master;
import com.etour.repositories.Customer_MasterRepository;
@Service
public class Customer_MasterManagerImpl implements Customer_MasterManager {
	
	@Autowired
	private Customer_MasterRepository  customerrepository;
	
//	@Autowired
//	BCryptPasswordEncoder passwordencoder;
	
	public void save(Customer_Master ref)
	{
		//String hashedpassword = passwordencoder.encode(ref.getPassword());
		String password= ref.getPassword();
		ref.setPassword(sha256(password));		
		customerrepository.save(ref);
	}
	
	public List<Customer_Master> getAll()
	{
		return customerrepository.findAll();
		
	}
	
	@Override
	public void delete(int id)
	{
		// TODO Auto-generated method stub
		customerrepository.deleteById(id);
	}
	
	@Override
	public void update(Customer_Master customer, int id) 
	{
		// TODO Auto-generated method stub
		customerrepository.update(customer.getCustomername(), customer.getEmail(), customer.getPassword(), customer.getPhonenumber(), customer.getAge(), customer.getAddress(), customer.getCountrycode(), customer.getProofid(), customer.getGender(), id);
	}
	
	@Override
	public Optional<Customer_Master> getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerrepository.findById(id);
	}

	private String sha256(String password)
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
	}

}
