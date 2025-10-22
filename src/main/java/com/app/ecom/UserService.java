package com.app.ecom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
  


    public List<User> addUser( User user) {
        
        userRepository.save(user);
        return userRepository.findAll();
    }
    public List<User> getAllUsers() {
     
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
       
       }


       public Optional<User> updateUserById(Long id, User updatedUser) {
        return (userRepository.findById(id).map(existingUser -> {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            userRepository.save(existingUser);
            return userRepository.findById(id);
        }).orElse(null));
       
       }
}
