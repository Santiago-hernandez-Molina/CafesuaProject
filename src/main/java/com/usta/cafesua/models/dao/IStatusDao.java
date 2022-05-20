package com.usta.cafesua.models.dao;

import com.usta.cafesua.entities.Status;
import org.springframework.data.repository.CrudRepository;

public interface IStatusDao extends CrudRepository<Status,Long> {
}
