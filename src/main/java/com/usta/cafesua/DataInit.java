package com.usta.cafesua;

import com.usta.cafesua.entities.UserCafesua;
import com.usta.cafesua.models.services.IUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

  private final IUser userRepo;
  private final PasswordEncoder passwordEncoder;

  public DataInit(IUser userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void run(String... args) throws Exception {
    try {
      userRepo.loadUserByUsername("admin");
    } catch (Exception e) {
      UserCafesua admin = new UserCafesua();
      admin.setUsername("admin");
      admin.setPassword(passwordEncoder.encode("admin"));
      userRepo.saveUser(admin);
      System.out.println("Admin user initialized");
    }
  }
}
