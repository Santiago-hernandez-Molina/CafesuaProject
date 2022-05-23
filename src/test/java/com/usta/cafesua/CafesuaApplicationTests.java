package com.usta.cafesua;

import com.usta.cafesua.entities.UserCafesua;
import com.usta.cafesua.models.services.IUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class CafesuaApplicationTests {

    @Autowired
    private IUser repo;

    @Test
    void contextLoads() {
        UserCafesua userCafesua = new UserCafesua();
        userCafesua.setUsername("user1");
        userCafesua.setPassword("123");
        repo.saveUser(userCafesua);


    }

}
