package com.usta.cafesua.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usta.cafesua.entities.Status;
import com.usta.cafesua.models.dao.IStatusDao;

@Service
public class StatusServiceImplement implements IStatus {

    @Autowired
    private IStatusDao iStatusDao;

    @Override
    @Transactional(readOnly = true)
    public List<Status> findAll() {
        return (List<Status>) iStatusDao.findAll();
    }

    @Override
    public void saveStatus(Status status) {
        iStatusDao.save(status);
    }
    
    @Override
    public void deleteStatus(Long id) {
    	iStatusDao.deleteById(id);
    }
    
    @Override
    public Status findById(Long id) {
    	return iStatusDao.findById(id).orElse(null);
    }
}
