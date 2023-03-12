package com.etour.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.etour.entities.Category_Master;

@Transactional
@Repository
public  interface CategoryRepository extends JpaRepository<Category_Master,Integer> 
{
	@Modifying
	@Query("FROM Category_Master c WHERE c.subcategoryid IS NULL")
	public List<Category_Master> showCategory();
	
	
	@Query("FROM Category_Master c WHERE c.subcategoryid =:categoryid")
	public List<Category_Master> descCategory(@Param("categoryid") String categoryid);
	
	//admin use
	
	@Modifying
	@Query("update Category_Master p set p.categoryid = :categoryid, p.subcategoryid=:subcategoryid,p.categoryname = :categoryname, p.categoryimage=:categoryimage,p.flag=:flag where p.masterid = :id")
	void update(@Param("categoryid") String categoryid,@Param("subcategoryid")String subcategoryid,@Param("categoryname") String categoryname,@Param("categoryimage") String categoryimage,@Param("flag") boolean flag, @Param("id")int id);
	

	@Query("from Category_Master p where p.subcategoryid=:cat")
	List<Category_Master> listCat(@Param("cat") String name);

}
