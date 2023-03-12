package com.etour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.etour.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>
{
	
	@Modifying
	@Query("update Admin a set a.name =:name,a.phoneno=:phoneno,a.password=:password,a.accesslvl=:accesslvl where a.aid=:id")
	void update(@Param("name") String name,@Param("phoneno") String phoneno,@Param("password") String password,@Param("accesslvl") int accesslvl,@Param("id") int id);

	Admin findByName(String username);
}
