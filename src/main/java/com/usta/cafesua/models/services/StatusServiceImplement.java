package com.usta.cafesua.models.services;

import com.usta.cafesua.entities.Status;
import com.usta.cafesua.models.dao.IStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void deleteByIdStatus(Long id) {
        iStatusDao.deleteById(id);
    }
}
