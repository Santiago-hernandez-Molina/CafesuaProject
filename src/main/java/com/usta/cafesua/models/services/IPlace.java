package com.usta.cafesua.models.services;

import java.util.List;

import com.usta.cafesua.entities.Place;

public interface IPlace {
	public List<Place> findAll();
	
	public void savePlace(Place place);
	
	public void deletePlace(Long id);
	
	public Place findById(Long id);
}
