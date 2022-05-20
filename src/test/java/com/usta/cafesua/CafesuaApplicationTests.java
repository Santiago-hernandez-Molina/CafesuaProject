package com.usta.cafesua;

import com.usta.cafesua.entities.UserCafesua;
import com.usta.cafesua.models.services.IUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class CafesuaApplicationTests {

    @Autowired
    private IUser repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    void contextLoads() {
        UserCafesua userCafesua=new UserCafesua();
        userCafesua.setUsername("base");
        userCafesua.setPassword(encoder.encode("134"));
        repo.saveUser(userCafesua);
    }

}
