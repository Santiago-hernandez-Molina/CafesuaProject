package com.usta.cafesua.models.services;

import com.usta.cafesua.entities.Bag;
import com.usta.cafesua.models.dao.IBagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BagServiceImplement implements IBag {

    @Autowired
    private IBagDao iBagDao;

    @Override
    @Transactional(readOnly = true)
    public List<Bag> findAll(){
        return (List<Bag>) iBagDao.findAll();
    }

    @Override
    public void saveBag(Bag bag) {
        iBagDao.save(bag);
    }

}
