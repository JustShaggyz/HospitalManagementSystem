package com.informatics.cscb869hospital.data.repository;

import com.informatics.cscb869hospital.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
