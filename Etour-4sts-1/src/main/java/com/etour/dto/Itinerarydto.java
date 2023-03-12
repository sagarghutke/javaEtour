package com.etour.dto;

import java.sql.Date;

import com.etour.entities.Category_Master;
import com.etour.entities.Cost_Master;
import com.etour.entities.Date_Master;
import com.etour.entities.Itinerary_Master;

public class Itinerarydto 
{
	
	public Itinerarydto() {
		super();
	}

	public Itinerarydto(Date_Master date, Itinerary_Master itinerary, Cost_Master cost, int masterid,
			String categoryname, String categoryimage) {
		super();
		this.date = date;
		this.itinerary = itinerary;
		this.cost = cost;
		this.masterid = masterid;
		this.categoryname = categoryname;
		this.categoryimage = categoryimage;
	}

	private Date_Master date;
	
	private Itinerary_Master itinerary;
	
	private Cost_Master cost;
	
	private int masterid;
	
	private String categoryname;
	
	private String categoryimage;

	public Date_Master getDate() {
		return date;
	}

	public void setDate(Date_Master date) {
		this.date = date;
	}

	public Itinerary_Master getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary_Master itinerary) {
		this.itinerary = itinerary;
	}

	public Cost_Master getCost() {
		return cost;
	}

	public void setCost(Cost_Master cost) {
		this.cost = cost;
	}

	public int getMasterid() {
		return masterid;
	}

	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategoryimage() {
		return categoryimage;
	}

	public void setCategoryimage(String categoryimage) {
		this.categoryimage = categoryimage;
	}
	
	
	
}
