package com.etour.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.etour.dto.Itinerarydto;
import com.etour.entities.Itinerary_Master;

@Transactional
@Repository
public interface ItireneriesRepo extends JpaRepository<Itinerary_Master,Integer>
{
	
	@Query(nativeQuery=true,value="Select itinerary.*,date.*,cost.*,category.masterid,category.categoryname,category.categoryimage"
			+ " from Itinerary_Master itinerary inner join"
			+ " Category_Master category on itinerary.itimasterid = category.masterid inner join"
			+ " Date_Master date on date.damasterid = category.masterid inner join"
			+ " Cost_Master cost on cost.cosmasterid = category.masterid "
			+ "where itinerary.itimasterid = :masterid ")
	public List<Object[]> getdesc(@Param("masterid") Integer masterid);
	
	//admin method
	
	@Modifying
	@Query("update Itinerary_Master p set p.tourduration = :tourduration, p.itrdetail=:itrdetail,p.itimasterid = :itimasterid where p.itrid = :id")
	void update(@Param("tourduration") int tourduration,@Param("itrdetail")String itrdetail,@Param("itimasterid") Integer itimasterid,@Param("id")int id);
	
}