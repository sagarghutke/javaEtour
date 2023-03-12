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

import com.etour.entities.Category_Master;
import com.etour.services.CategoryManager;

@RestController
public class CategoryController 
{
	@Autowired
	 CategoryManager manager;
	
	@GetMapping(value="api/categorymaster")
	public List<Category_Master> showCategories()
	{
		return manager.getCategories();
		
	}
	
	@GetMapping(value="api/category/{categoryid}")
	public List<Category_Master> showCategory(@PathVariable("categoryid") String categoryid)
	{
		return manager.getCategory(categoryid);
	}
	
//admin use
	
	 @GetMapping(value = "api/admincategories")
	public List<Category_Master> getCategories(){
		return manager.getAll();
	}
	 @GetMapping(value = "api/Hello")
	public String Hello(){
		return "Hello";
	}
	 @GetMapping(value = "api/categories/{pid}")
	 public Optional<Category_Master> getCategory(@PathVariable int pid)
	 {
		Optional<Category_Master> p=manager.getCategory(pid);
		return p;
	 }
	 @DeleteMapping(value = "api/categories/{pid}")
	 public void removeCategory(@PathVariable int pid)
	 {
		 manager.delete(pid);
	 }
	 @PutMapping(value = "api/categories/{pid}")
	 public void updateCategory(@RequestBody Category_Master product,@PathVariable int pid)
	 {
		System.out.println("inside updatecategory of controller");
		manager.update(product,pid);
	 }
	 @PostMapping(value = "api/addcategories")
	public void addCategory(@RequestBody Category_Master category){
		System.out.println("add category called");
		manager.save(category);
	}
	
	
	

}
