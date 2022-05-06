package com.usta.cafesua.models.services;


import com.usta.cafesua.entities.Role;
import com.usta.cafesua.entities.UserCafesua;
import com.usta.cafesua.models.dao.IUserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImplement implements IUser, UserDetailsService {

    private final IUserDao iUserDao;

    @Override
    @Transactional
    public List<UserCafesua> findAll() {
        return iUserDao.findAll();
    }

    @Override
    public void saveUser(UserCafesua user) {
        iUserDao.save(user);
    }

    @Override
    public void deleteStatus(Long id) {
        iUserDao.deleteById(id);
    }

    @Override
    public UserCafesua findById(Long id) {
        return iUserDao.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCafesua user = iUserDao.findByUsername(username);

        return new User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(UserCafesua user)
    {
        String[] userRoles = user.getRoles()
                .stream()
                .map(Role::getName)
                .toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }

}
