package com.example.userapi.service;

import com.example.userapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean deleteUserById(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
