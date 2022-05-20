package com.usta.cafesua.models.services;

import java.util.List;

import com.usta.cafesua.entities.Status;

public interface IStatus {
    public List<Status> findAll();
    
    public void saveStatus(Status status);
    
    public void deleteStatus(Long id);
    
    public Status findById(Long id);
}
