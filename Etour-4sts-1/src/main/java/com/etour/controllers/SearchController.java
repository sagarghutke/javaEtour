package com.etour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etour.dto.SearchRequestdto;
import com.etour.services.SearchManager;

@RestController
@RequestMapping(value="api/search")
public class SearchController 
{
	@Autowired
	SearchManager manager;
	
	@PostMapping(value="/")
	public List<?> getresult(@RequestBody SearchRequestdto req)
	{
		return manager.search(req);
	}

}
