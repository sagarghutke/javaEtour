package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etour.dto.BookingRequest;
import com.etour.entities.Booking_Master;
import com.etour.services.BookingManager;

@RestController
public class BookingController {

	@Autowired
	private BookingManager manager;

	 @GetMapping(value = "api/bookings")
	public List<Booking_Master> getBookings(){
		return manager.getAll();
	}
	 @PostMapping(value = "api/bookings")
	public void addsBooking(@RequestBody Booking_Master booking){
		System.out.println("addBooking called");
		manager.save(booking);
	}
	 
	 @GetMapping(value = "api/bookings/{pid}")
	 public Optional<Booking_Master> getBooking(@PathVariable int pid)
	 {
		Optional<Booking_Master> p=manager.getBooking(pid);
		return p;
	 }
	 @DeleteMapping(value = "api/bookings/{pid}")
	 public void removeBooking(@PathVariable int pid)
	 {
		 manager.delete(pid);
	 }
	 @PutMapping(value = "api/bookings/{pid}")
	 public void updateBooking(@RequestBody Booking_Master product,@PathVariable int pid)
	 {
		 System.out.println(product);
		System.out.println("inside updatebooking of controller");
		manager.update(product,pid);
	 }
	 
	 //client use
	@PostMapping("/api/booking")
	private BookingRequest addBooking(@RequestBody BookingRequest book)
	{
		System.out.println("In controller\t"+book);
		
		if(book == null)
		{
		
			System.out.println("Ues");
		}
		else
		{
			System.out.println(book.getBooking());
		}
		return manager.updateBookings(book);
		
	}
	
}