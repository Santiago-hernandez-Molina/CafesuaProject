package com.usta.cafesua.models.services;


import com.usta.cafesua.entities.Role;
import com.usta.cafesua.entities.UserCafesua;
import com.usta.cafesua.models.dao.IRoleDao;
import com.usta.cafesua.models.dao.IUserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImplement implements IUser, UserDetailsService {

    private final IUserDao iUserDao;

    private final IRoleDao iRoleDao;

    private final BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public List<UserCafesua> findAll() {
        return iUserDao.findAll();
    }

    @Override
    public void saveUser(UserCafesua user) {
        if (iUserDao.findByUsername(user.getUsername()) == null) {
            UserCafesua userCafesua = new UserCafesua(
                    user.getUsername(), encoder.encode(user.getPassword()), Arrays.asList(iRoleDao.findByName("ROLE_USER"))
            );
            iUserDao.save(userCafesua);
        } else {
            System.err.println("The user already exist");
        }
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
        User user1= new User(user.getUsername(), user.getPassword(), getAuthorities(user));
        System.out.println(user1.getAuthorities());
        return user1;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(UserCafesua user) {
        String[] userRoles = user.getRoles()
                .stream()
                .map(Role::getName)
                .toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }

}
