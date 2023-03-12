package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etour.dto.Itinerarydto;
import com.etour.entities.Itinerary_Master;
import com.etour.services.ItineraryManager;

@RestController
public class ItineraryController 
{
	@Autowired
	ItineraryManager itineraryManager;
	
	 @GetMapping(value = "api/itineraries")
		public List<Itinerary_Master> getItineraries(){
			return itineraryManager.getAll();
		}
		 @PostMapping(value = "api/itineraries")
		public void addItineraries(@RequestBody Itinerary_Master itinerary){
			System.out.println("add dates called");
			itineraryManager.save(itinerary);
		}
		 @GetMapping(value = "api/itineraries/{pid}")
		 public Optional<Itinerary_Master> getItinerary(@PathVariable int pid)
		 {
			Optional<Itinerary_Master> p=itineraryManager.getItinerary(pid);
			return p;
		 }
		 @DeleteMapping(value = "api/itineraries/{pid}")
		 public void removeItinerary(@PathVariable int pid)
		 {
			 itineraryManager.delete(pid);
		 }
		 @PutMapping(value = "api/itineraries/{pid}")
		 public void updateItinerary(@RequestBody Itinerary_Master itinerary,@PathVariable int pid)
		 {
			System.out.println("inside updateItinerary of controller");
			itineraryManager.update(itinerary,pid);
		 }
	//client use
	@GetMapping(value="api/itrdesc/{masterid}")
	public ResponseEntity<?> getItrdesc(@PathVariable Integer masterid)
	{
		List<Itinerarydto> ittr = itineraryManager.getdescription(masterid);
		return ResponseEntity.ok(ittr);
	}

	
}
