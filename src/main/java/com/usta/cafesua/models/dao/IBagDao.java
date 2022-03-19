package com.usta.cafesua.models.dao;

import com.usta.cafesua.entities.Bag;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IBagDao extends CrudRepository<Bag,Long> {
}
