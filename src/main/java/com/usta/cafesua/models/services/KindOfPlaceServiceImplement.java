package com.usta.cafesua.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usta.cafesua.entities.KindOfPlace;
import com.usta.cafesua.models.dao.IKindOfPlaceDao;

@Service
public class KindOfPlaceServiceImplement implements IKindOfPlace{
	@Autowired
	private IKindOfPlaceDao iKindOfPlaceDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<KindOfPlace> findAll(){
		return (List<KindOfPlace>) iKindOfPlaceDao.findAll();
	}
	
	@Override
	public void saveKindOfPlace(KindOfPlace kindOfPlace) {
		iKindOfPlaceDao.save(kindOfPlace);
	}
	
	@Override
	public void deleteKindOfPlace(Long id) {
		iKindOfPlaceDao.deleteById(id);
	}
	
	@Override
	public KindOfPlace findById(Long id) {
		return iKindOfPlaceDao.findById(id).orElse(null);
	}
}
