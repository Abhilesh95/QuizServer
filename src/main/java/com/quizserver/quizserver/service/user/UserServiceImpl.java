package com.quizserver.quizserver.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quizserver.quizserver.entities.*;
import com.quizserver.quizserver.enums.userRole;
import com.quizserver.quizserver.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void createAdminUser(){
        User optionalUser = userRepository.findByRole(userRole.ADMIN);
        if (optionalUser == null){
            User user = new User();
            //setting the data here
            user.setName("Admin");
            user.setEmail("admin@gmail.com");
            user.setRole(userRole.ADMIN);
            user.setPassword("admin");

            userRepository.save(user);

        }
    }

    //On the startup of the application we want to call this createAdminUser() function so we use @PostConstruct annotations

    //Need to check if we already have user with the email
    public Boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email) != null;
    }

    //signup API
    public User createUser(User user){
        user.setRole(userRole.USER);

        return userRepository.save(user);
    }
}
