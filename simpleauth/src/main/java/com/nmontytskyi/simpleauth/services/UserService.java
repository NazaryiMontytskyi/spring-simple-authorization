package com.nmontytskyi.simpleauth.services;

import com.nmontytskyi.simpleauth.models.User;
import com.nmontytskyi.simpleauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public void saveUser(User user) {
        user.setPassword(
                (new BCryptPasswordEncoder()).encode(user.getPassword())
        );
        userRepository.save(user);
    }
}
