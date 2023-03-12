package com.etour.services;

import java.sql.Date;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.etour.dto.Itinerarydto;
import com.etour.entities.Cost_Master;
import com.etour.entities.Date_Master;
import com.etour.entities.Itinerary_Master;
import com.etour.repositories.ItireneriesRepo;

@Service
public class ItineraryManagerImpl implements ItineraryManager
{
	@Autowired
	ItireneriesRepo itineraryrepository;
	
	@Override
	public void save(Itinerary_Master ref) {
		// TODO Auto-generated method stub
		itineraryrepository.save(ref);
	}

	@Override
	public List<Itinerary_Master> getAll() {
		// TODO Auto-generated method stub
		return itineraryrepository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		itineraryrepository.deleteById(id);
	}

	@Override
	public void update(Itinerary_Master itinerary, int id) {
		// TODO Auto-generated method stub
		itineraryrepository.update(itinerary.getTourduration(), itinerary.getItrdetail(), itinerary.getItimasterid(), id);
	}

	@Override
	public Optional<Itinerary_Master> getItinerary(int id) {
		// TODO Auto-generated method stub
		return itineraryrepository.findById(id);
	}

//client use
	
	@Override
	public List<Itinerarydto> getdescription(Integer masterid) 
	{
		//List<Itinerarydto> itr = new ArrayList<>();
		List<Object[]> result = itineraryrepository.getdesc(masterid);
		Object[] res = result.get(0);
		int itrid = (int) res[0];
		int itimasterid =(int) res[1];
		String itrdetail = (String) res[2];
		int tourduration = (int)res[3];
		Itinerary_Master mc = new Itinerary_Master(itrid,tourduration,itrdetail,itimasterid);
		int departureid =(int)res[4];
		int damasterid=(int)res[5];
		Date startdate=(Date) res[6];
		Date enddate=(Date) res[7];
		int noofdays =(int)res[8];
		Date_Master dm=new Date_Master(departureid,startdate,enddate,noofdays,damasterid);
		int costid=(int)res[9];
		double childwithbed = (double)res[10];
		double childwithoutbed=(double)res[11];
		int cosmasterid=(int)res[12];
		double cost=(double)res[13];
		double extrapersoncost=(double)res[14];
		double singlepersoncost=(double)res[15];
		Date validfrom=(Date)res[16];
		Date validto=(Date)res[17];
		Cost_Master cm = new Cost_Master(costid,cost,singlepersoncost,extrapersoncost,childwithbed,childwithoutbed,validfrom,validto,cosmasterid);
		int masterid1 = (int)res[18];
		String categoryname =(String)res[19];
		String categoryimage= (String)res[20];
		Itinerarydto itr = new Itinerarydto(dm,mc,cm,masterid1,categoryname,categoryimage);
		List<Itinerarydto> list = new ArrayList<>();
		list.add(itr);
		// TODO Auto-generated method stub
		return list;
	}

}
