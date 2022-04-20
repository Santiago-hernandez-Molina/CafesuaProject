package com.usta.cafesua.models.dao;

import com.usta.cafesua.entities.UserCafesua;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<UserCafesua,Long> {
    UserCafesua findByUsername(String username);
}
