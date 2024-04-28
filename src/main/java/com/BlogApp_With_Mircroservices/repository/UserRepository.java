package com.BlogApp_With_Mircroservices.repository;

import com.BlogApp_With_Mircroservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
   //SIGN-UP
    boolean existsByEmail(String email);

    boolean existsByUsername(String name);

    //SIGN-IN
    User findByUsername(String username);
}
