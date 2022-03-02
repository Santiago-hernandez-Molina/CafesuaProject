package com.usta.cafesua.models.dao;

import com.usta.cafesua.entities.Bag;
import org.springframework.data.repository.CrudRepository;

public interface IBagDao extends CrudRepository<Bag,Long> {
}
