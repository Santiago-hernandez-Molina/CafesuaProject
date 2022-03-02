package com.usta.cafesua.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.usta.cafesua.entities.Place;

public interface IPlaceDao extends CrudRepository<Place,Long>{
}
