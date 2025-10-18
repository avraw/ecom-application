package com.app.ecom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UserService {
    private long userIdCounter = 1L;
    private List<User> userList = new ArrayList<>();


    public List<User> addUser( User user) {
        user.setId(userIdCounter++);
        userList.add(user);
        return userList;
    }
    public List<User> getAllUsers() {
        // Business logic for retrieving all users can be added here
        return userList;
    }
    
}
