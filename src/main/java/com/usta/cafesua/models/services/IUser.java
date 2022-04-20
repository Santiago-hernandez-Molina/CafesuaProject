package com.usta.cafesua.models.services;


import com.usta.cafesua.entities.UserCafesua;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUser{
    public List<UserCafesua> findAll();

    public void saveUser(UserCafesua user);

    public void deleteStatus(Long id);

    public UserCafesua findById(Long id);

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
