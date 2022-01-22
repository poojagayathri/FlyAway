package com.flyaway.model;

import javax.persistence.*;

@Entity
public class Places {
	
	@Column(name="PlaceName")
	private String placeName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="PlaceId")
	private int id;
	public Places() {
		super();
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
