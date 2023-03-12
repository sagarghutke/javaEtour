package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Category_Master;

public interface CategoryManager 
{
	List<Category_Master> getCategories();

	List<Category_Master> getCategory(String categoryid);
	
	//admin use
	
	void save(Category_Master ref);
	List<Category_Master> getAll();
	void delete(int id);
	void update(Category_Master category,int id);
	public List<Category_Master> getSelected(String cat);
	public Optional<Category_Master> getCategory(int id);
	

}
