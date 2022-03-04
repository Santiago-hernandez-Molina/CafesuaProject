package com.usta.cafesua.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usta.cafesua.entities.Place;
import com.usta.cafesua.models.dao.IPlaceDao;

@Service
public class PlaceServiceImplement implements IPlace {
	@Autowired
	private IPlaceDao iPlaceDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Place> findAll(){
		return (List<Place>) iPlaceDao.findAll();
	}
}
