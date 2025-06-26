package com.quizserver.quizserver.repository;
import com.quizserver.quizserver.entities.User;
import com.quizserver.quizserver.enums.userRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*
        JpaRepository is an interface, not a class.

        In Java, a class cannot extend an interface.

        Instead, a class must implement an interface: 
        
    */
    User findByRole(userRole role);
    User findFirstByEmail(String email);

    

}
