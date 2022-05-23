package com.usta.cafesua.models.dao;

import com.usta.cafesua.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
