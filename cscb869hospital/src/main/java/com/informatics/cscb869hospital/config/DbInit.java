package com.informatics.cscb869hospital.config;

import com.informatics.cscb869hospital.data.entity.Role;
import com.informatics.cscb869hospital.data.entity.User;
import com.informatics.cscb869hospital.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public DbInit() {
    }

    @Override
    public void run(String... args) throws Exception {

        // Create the roles
        Role adminRole = new Role("ADMIN");
        Role doctorRole = new Role("DOCTOR");
        Role patientRole = new Role("PATIENT");

        this.userRepository.deleteAll();
        User user = new User();
        user.setUsername("user");
        user.setPassword(encoder.encode("user_123"));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.getAuthorities().add(adminRole);
        adminRole.getUsers().add(user);



        User user2 = new User();
        user2.setUsername("doctor");
        user2.setPassword(encoder.encode("doctor_123"));
        user2.setAccountNonExpired(true);
        user2.setAccountNonLocked(true);
        user2.setEnabled(true);
        user2.setCredentialsNonExpired(true);
        user2.getAuthorities().add(doctorRole);
        doctorRole.getUsers().add(user2);

        User user3 = new User();
        user3.setUsername("patient");
        user3.setPassword(encoder.encode("patient_123"));
        user3.setAccountNonExpired(true);
        user3.setAccountNonLocked(true);
        user3.setEnabled(true);
        user3.setCredentialsNonExpired(true);
        user3.getAuthorities().add(patientRole);
        patientRole.getUsers().add(user3);

        List<User> users = Arrays.asList(user, user2, user3);

        // Save to db
        this.userRepository.saveAll(users);

    }
}
