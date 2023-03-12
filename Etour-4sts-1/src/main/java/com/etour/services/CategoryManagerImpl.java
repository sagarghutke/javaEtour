package com.etour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etour.entities.Category_Master;
import com.etour.repositories.CategoryRepository;

@Service
@Transactional(readOnly = false)
public class CategoryManagerImpl implements CategoryManager
{
	@Autowired
	CategoryRepository repo;
	
	@Override
	public List<Category_Master> getCategories()
	{
		return repo.showCategory();
	}
	
	@Override
	public List<Category_Master> getCategory(String categoryid)
	{
		//return repo.
		return repo.descCategory(categoryid);
	}
	
//admin use
	@Override
	public void save(Category_Master ref) {
		// TODO Auto-generated method stub
		System.out.println("Add save");
		repo.save(ref);
	}

	@Override
	public List<Category_Master> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}
	@Override
	public void update(Category_Master category,int id) {
		// TODO Auto-generated method stub
		System.out.println("inside update method of service layer");
		repo.update(category.getCategoryid(),category.getSubcategoryid(),category.getCategoryname(),category.getCategoryimage(),category.isFlag(),id);
	}
	
	@Override
	public List<Category_Master> getSelected(String cat) {
		// TODO Auto-generated method stub
		return repo.listCat(cat);
	}
	@Override
	public Optional<Category_Master> getCategory(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	

}
