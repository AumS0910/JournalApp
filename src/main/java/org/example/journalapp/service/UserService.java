package org.example.journalapp.service;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

import org.example.journalapp.entity.User;

import org.example.journalapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean saveNewUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Error occured during {} :", user.getUserName(), e);
            return false;
        }
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(ObjectId id) {
        return userRepository.findById(id);
    }
    public void deleteByUserName(String userName) {
        userRepository.deleteByUserName(userName);
    }

    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
