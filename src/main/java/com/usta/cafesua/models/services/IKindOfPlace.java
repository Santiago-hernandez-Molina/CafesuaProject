package com.usta.cafesua.models.services;

import java.util.List;

import com.usta.cafesua.entities.KindOfPlace;

public interface IKindOfPlace {
	public List<KindOfPlace> findAll();
	public void saveKindOfPlace(KindOfPlace kindOfPlace);
}
