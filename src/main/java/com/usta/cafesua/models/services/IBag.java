package com.usta.cafesua.models.services;

import java.util.List;

import com.usta.cafesua.entities.Bag;

public interface IBag {
    public List<Bag> findAll();

    public void saveBag(Bag bag);

    public void deleteBag(Long id);
    
    public Bag findById(Long id);
}
