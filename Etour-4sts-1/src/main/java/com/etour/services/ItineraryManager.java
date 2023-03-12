package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.dto.Itinerarydto;
import com.etour.entities.Itinerary_Master;

public interface ItineraryManager 
{
	
	
	List<Itinerarydto> getdescription(Integer masterid);
	
	//admin use
	void save(Itinerary_Master ref);
	List<Itinerary_Master> getAll();
	void delete(int id);
	void update(Itinerary_Master date,int id);
	Optional<Itinerary_Master> getItinerary(int id);

}
